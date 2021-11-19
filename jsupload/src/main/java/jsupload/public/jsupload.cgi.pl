#!/usr/bin/perl -w
#
# Copyright 2010 Manolo Carrasco Moñino. (manolo at apache/org)
# http://code.google.com/p/gwtupload
#
# Licensed under the Apache License, Version 2.0 (the "License"); you may not
# use this file except in compliance with the License. You may obtain a copy of
# the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
# WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
# License for the specific language governing permissions and limitations under
# the License.
#

############################################################################################
## * * The provided server script has been written in perl for the GWTUpload/JSUpload library.
## *
## * * This script requires perl, CGI and Digest::MD5, which are installed by default in
## * most linux/unix distributions.
## *
## * * You have to put this file in a script/cgi-bin enabled folder of your web server, and
## * you have to set the rigth execution permissions.
## *
## * # *Operation*:
## *    * When it receives a POST request, it updates periodically a status file with the progress, 
## *      and stores all received form elements in a temporary folder for the user session.
## *    * When it receives GET requests, returns a xml response with the progess information.
## *    * When the GET request, has the parameter show=xxxx, it returns the content of the form
## *      element whose name is xxxx. If the element is a file it sends a response with the adequate
## *      content-type, otherwise it returns a xml response with the element's value.
## * # *Configuration*: At the top of the script you have some customizable variables.
## *   * $idname: is the name for the sessionid cookie name, you could redefine it to match
## *              the name of the cookie set by your application. By default the name is CGISESSID.
## *   * $tmp_dir: is the prefix used in the path location to store the data received. By default
## *              it is set to "/tmp/uploader", normally you have to change it to match the path
## *              configured in your application. It is strongly recommended that this directory 
## *              should be created apart from "/tmp", in a non-httpd accessible path.
## *   * $max_size: is the maximum size in bytes allowed for the entire request size, note that it is not
## *              the real file size because the request includes the headers and could have more
## *              files or parameters. Normally only one file is transfered, and the request size
## *              is very closed to the file size.
## *   * $mkpath: if true jsupload will create the folder to store the received data, otherwise
## *              it is the application the responsible of creating it. Note that setting it to false 
## *              your system is protected to be used as a surreptitious storage area. The files 
## *              in this folder will be created with the default perl permissions (0666 or the user umask), 
## *              so in the case you leave the application to create the folder be aware to set the
## *              appropriate permissions.
## *   * $slow:   if it has a value greater than zero, after each chunk received, jsupload will sleep
## *              for this value in seconds (it may be fractional). It is used to see the progress bar 
## *              in fast networks when you are testing or developing your app.
## * # *Integration*:
## *   * The files are stored in the folder $tmp_dir/xxxx where xxxx is the session id (cookie CGISESSID).
## *   * For each form element received, it stores a file /tmp/uploader/xxxx/yyyy.info 
## *     where yyyy is the name of the element.
## *   * In the case of file elements, it puts the content of the file in the file
## *     /tmp/uploader/xxxx/yyyy.bin.
## *   * The application must create, handle, and clean $tmp_dir files.
############################################################################################
# this script version.
my $version = "1.0.2";

use CGI;
use Digest::MD5;
use File::Path;
use strict;
use warnings;
use Data::Dumper;

my $idname   = "CGISESSID";
my $tmp_dir  = "/tmp/uploader";
my $max_size = 2000000;
# Note that by default we set mkpath=1 to avoid problems to newbies. 
# You should set it to 0 and make the server create the folder when the user is validated
# and before uploading any file. 
my $mkpath = 1;
my $slow = 0;

## Protect names used in path of traversal directory vulnerability
sub fixPath {
  my $p = shift;
  $p =~ s,[^\w\d-],_,g;
  return $p;
}


# Get the sessionId or create a new one
# do not use CGI here, because we need to handle STDIN in order to update the progress status.
my $sid = fixPath(new Digest::MD5()->add( $$, time(), rand(time) )->hexdigest());
my $set_cookie = "";
if ( $ENV{'HTTP_COOKIE'} && $ENV{'HTTP_COOKIE'} =~ /$idname="*([^";]+)/ ) {
    $sid = fixPath($1);
} elsif ($mkpath) {
    $set_cookie = "Set-Cookie: CGISESSID=$sid; path=/\n"
} else {
    writeResponse("<error>JSUPLOAD: Unable to find $idname</error>");
}
my $user_dir = "$tmp_dir/$sid/";
my $data_file = "$user_dir/data.$$";
my $cancel_file = "$user_dir/cancel";
my $error_file = "$user_dir/error";
my $progress_file = "$user_dir/progress";

# Controller:
#   POST is used for uploading.
#   GET is used to get the upload progress or get the content of the uploaded item.
my $method = $ENV{'REQUEST_METHOD'} || 'GET';
if ($ENV{'HTTP_ORIGIN'}) {
      print "Access-Control-Allow-Origin: " . $ENV{'HTTP_ORIGIN'} . "\n";
      print 'Access-Control-Allow-Credentials: true' . "\n";
}
if ($method eq 'OPTIONS') {
      print "Access-Control-Allow-Methods: GET, POST, OPTIONS\n" if ($ENV{'HTTP_ACCESS_CONTROL_REQUEST_METHOD'});
      print "Access-Control-Allow-Headers: " . $ENV{'HTTP_ACCESS_CONTROL_REQUEST_HEADERS'} . "\n" if ($ENV{'HTTP_ACCESS_CONTROL_REQUEST_HEADERS'});
}
my $cgi;
if ( $method =~ /POST/i ) {
    doPost();
} else {
    $cgi = new CGI;
    if ( $cgi->param('show') ) {
        writeItemContent( $cgi->param('show') );
    } elsif ( $cgi->param('new_session') ) {
        writeResponse("<session>ok</session>");
    } elsif ( $cgi->param('remove') ) {
        removeItem( $cgi->param('remove') );
    } elsif ( $cgi->param('cancel') ) {
        cancelProcess();
    } else {
        getProgress($cgi->param('filename'));
    }
}
exit;

## This method receives the form content and stores each item in a temporary folder.
sub doPost {
    ## flush after any write operation.
    $| = 1;

    ## Validate permissions.
    if ( $mkpath && !-d "$user_dir" ) {
        mkpath( "$user_dir", 0, 0700 )
          || writeResponse("<error>JSUPLOAD: Unable to create: $user_dir $!</error>");
    }

    ## Exit if the folder does not exist.
    writeResponse("<error>JSUPLOAD: The folder: $user_dir should be created by the application before uploading any file.</error>") 
        unless (-w $user_dir);

    ## Validate request size.
    my $len = $ENV{'CONTENT_LENGTH'} || 3000;
    print STDERR "Receiving $len ($max_size)\n";
    if ( $len && $len > $max_size ) {
        unlink($progress_file);
        unlink($data_file);
        my $maxKB = int ($max_size / 1024);
        my $sizeKB = int ($len / 1024);
        exitWithError("The maximum configured upload size ($maxKB KB.) has been exceeded ($sizeKB KB.) ");
    }

    ## Receive the request, and update progress data
    unlink($cancel_file) if (-f $cancel_file);
    unlink($error_file) if (-f $error_file);
    open( D, ">$data_file" ) || exitWithError("Can't open postfile: $user_dir/postdata $!</error>");
    my ( $n, $done, $line ) = ( 0, 0, "" );
    do {
        ## If we have received an ajax request to cancel the upload, we close
        ## the STDIN in order to make the client stop the uploading.
        if (-f $cancel_file) {
           close(D);
           unlink($progress_file);
           unlink($data_file);
           writeResponse("<canceled>true</canceled><finished>canceled</finished>", 1);
        }
        $done += $n;
        updateProgress( $done, $len );
        print D $line;
        select( undef, undef, undef, $slow ) if ($slow);
    } while ( ( $n = sysread( STDIN, $line, 4096 ) ) > 0 );
    close(D);

    ## Process received data
    my $msg = "<finished>ok</finished>\n<message>jsupload.pl $version</message>\n";
    open( STDIN, "$data_file" );
    $cgi = new CGI();
    my $cnt = 0;
    my $files = "";
    my $pars = "";
    foreach my $key ( $cgi->param() ) {
        my $value = $cgi->param($key);
        if ( defined($value) ) {
           my @fhs = $cgi->upload($key);
           $key =~ s/\[\]$//;
            foreach my $fh (@fhs) {
              if ( defined($fh) ) {
                  my $field .= $key . '-' . $cnt++;
                  # In this variable you can send any information to the client side.

                  my $type = $cgi->uploadInfo($value)->{'Content-Type'} || 'unknown';
                  my $name = saveFile( $field, $value, $type, $fh );
                  my $size = -s "$name";
                  $files .= " <file>\n  <field>$field</field>\n  <name>$value</name>"
                    . "\n  <size>$size</size>\n  <ctype>$type</ctype>\n";
              } else {
                  saveFile($key, $value, "text/plain");
                  $pars .= "<parameter><field>$key</field>"
                    . "<value>$value</value></parameter>";
              }
            }
        }
    }
    close(STDIN);
    unlink($data_file);
    writeResponse($msg . "<files>$files</files>" . "<parameters>$pars<parameters>", 1);
}

## Save each received file in the user folder.
## It generates two files, one with the content of the uploaded data,
## and the other one with the item information (original name and content-type)
sub saveFile {
    my ( $key, $name, $type, $fd ) = @_;
    $key = fixPath($key);
    my $bin_file = "";
    if ($fd) {
       $bin_file = $user_dir . $key . ".bin";
       open( BIN, ">$bin_file" ) || return;
       binmode(BIN);
       my ($data, $n);
       while ($n = read($fd, $data, 65536)) {
         print BIN $data;
       }
       close(BIN);
    }
    my $size = -s "$bin_file";
    my $info_file = $user_dir . $key . ".info";
    open( INFO, ">$info_file" ) || return;
    print INFO "$name\n$type\n$size\n";
    close(INFO);
    return $bin_file;
}

## Write the server response for each request.
## This response is a simple xml response easy to handle in the browser side.
## Sets the cookie if it wasn't found before
## Terminates the reception closing stdin and exits.
sub writeResponse {
    my ($msg, $post) = @_;
    close(STDIN);
    my $xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>"
            . "\n<response>\n  $msg\n</response>\n";
    if ($post) {
      $xml =~ s/</@@^^^/g;
      $xml =~ s/>/^^^@@/g;
      $xml = '%%%INI%%%' . $xml . '%%%END%%%';
    }
    
    print "Content-Type: text/plain\n$set_cookie\n$xml";
    exit;
}

## write the upload progress in the status file
sub updateProgress {
    my ( $done, $total ) = @_;
    open( F, ">$progress_file" );
    print F "$done/$total";
    close(F);
}

sub exitWithError {
    my $msg = shift || "Server Error $!";
    open( F, ">$error_file" );
    print F $msg;
    close(F);
    print STDERR "Upload Error: $msg\n";
    writeResponse("<error>JSUPLOAD: $msg</error>");
}

sub cancelProcess {
    open( F, ">$cancel_file" );
    print F "cancel";
    close(F);
    print STDERR "Cancelled \n";
    writeResponse("<canceled>true</canceled>");
}

## read the upload progress from the status file
sub getProgress {
    my $key = shift;
    if ( -f "$error_file" ) {
        my $error=`cat $error_file`;
        writeResponse("<error>JSUPLOAD: $error</error><finished>true</finished>");
    }
    if ( -f "$cancel_file" ) {
        writeResponse("<canceled>true</canceled><finished>canceled</finished>");
    }
    my ( $done, $total, $percent ) = ( 0, 0, 0 );
    if ( open( F, "$user_dir/progress" ) ) {
        my $l = <F>;
        if ( $l =~ /^(\d+)\/(\d+)/ ) {
            ( $done, $total ) = ( $1, $2 );
            $percent = $total != 0 ? $done * 100 / $total : 0;
        }
        close(F);
    }
    my $ret =
        "<percent>$percent</percent>"
      . "<currentBytes>$done</currentBytes>"
      . "<totalBytes>$total</totalBytes>";
    if ($percent >= 100) {
        $ret .= "<finished>ok</finished><files>\n<message>jsupload.pl $version</message>\n" if ( $percent >= 100 );
        my ($cont, $value, $type, $size);
        do {
           my $field = $key . "-" . $cont++;
           ($value, $type, $size) = readInfo($field);
           if ($value) {
              $ret .= "<file><field>$field</field><ctype>$type</ctype><name>$value</name><size>$size</size></file>\n";
           }
        } while ($value);
        $ret .= "</files>";
    }
    writeResponse($ret);
}

sub readInfo {
    my $item = fixPath(shift);
print STDERR "$user_dir/$item.info\n";
    if ( open( F, "$user_dir/$item.info" ) ) {
        my $value = <F>;
        $value =~ s/[\r\n]+$//g;
        my $type = <F>;
        $type =~ s/[\r\n]+$//g;
        my $size = <F>;
        $size =~ s/[\r\n]+$//g;
        close(F);
        return ($value, $type, $size);
    }
}

## Generates the response when the client asks for an item
## if it is a form item it returns a xml response with its value
## if it is an uploaded file it returns the content of this file, setting the content-type to the original value.
sub writeItemContent {
    select( undef, undef, undef, 0.4 );
    my $item = fixPath(shift);
    my ($value, $type, $size) = readInfo($item);
    if (!$value) {
        writeResponse("<error>item not found</error>");
    } elsif ($value && open( F, "$user_dir/$item.bin" ) ) {
        print "Content-type: $type\n\n";
        while (<F>) {
            print $_;
        }
        close(F);
    } else {
        writeResponse("<item name='$item'>$value</item>");
    }
}

sub removeItem {
    my $item = shift;
    if (-f "$user_dir/$item.info") {
        unlink ("$user_dir/$item.info");
        unlink ("$user_dir/$item.bin");
        writeResponse("<deleted>true</deleted>");
    } else {
        writeResponse("<error>item not found</error>");
    }
}
