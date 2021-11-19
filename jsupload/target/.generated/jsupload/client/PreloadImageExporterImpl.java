package jsupload.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import org.timepedia.exporter.client.Exporter;
import org.timepedia.exporter.client.ExporterUtil;

public class PreloadImageExporterImpl implements Exporter {
    public PreloadImageExporterImpl() { export(); }
    public native void export0() /*-{
      var pkg = @org.timepedia.exporter.client.ExporterUtil::declarePackage(Ljava/lang/String;)('jsu.PreloadImage');
      var _;
      $wnd.jsu.PreloadImage = $entry(function() {
        var g, j = this;
        if (@org.timepedia.exporter.client.ExporterUtil::isAssignableToInstance(Ljava/lang/Class;Lcom/google/gwt/core/client/JavaScriptObject;)(@jsupload.client.PreloadImage::class, arguments))
          g = arguments[0];
        else if (arguments.length == 1)
          g = @jsupload.client.PreloadImageExporterImpl::___create(Lcom/google/gwt/core/client/JavaScriptObject;)(arguments[0]);
        j.g = g;
        @org.timepedia.exporter.client.ExporterUtil::setWrapper(Ljava/lang/Object;Lcom/google/gwt/core/client/JavaScriptObject;)(g, j);
        return j;
      });
      _ = $wnd.jsu.PreloadImage.prototype = new Object();
      _.setAlt = $entry(function(a0) { 
        this.g.@jsupload.client.PreloadImage::setAlt(Ljava/lang/String;)(a0);
      });
      _.setSize = $entry(function(a0,a1) { 
        this.g.@jsupload.client.PreloadImage::setSize(II)(a0,a1);
      });
      _.addStyleName = $entry(function(a0) { 
        this.g.@jsupload.client.PreloadImage::addStyleName(Ljava/lang/String;)(a0);
      });
      _.getData = $entry(function() { 
        return this.g.@jsupload.client.PreloadImage::getData()();
      });
      _.realWidth = $entry(function() { 
        return this.g.@jsupload.client.PreloadImage::realWidth()();
      });
      _.getElement = $entry(function() { 
        return this.g.@jsupload.client.PreloadImage::getElement()();
      });
      _.realHeight = $entry(function() { 
        return this.g.@jsupload.client.PreloadImage::realHeight()();
      });
      
      @org.timepedia.exporter.client.ExporterUtil::addTypeMap(Ljava/lang/Class;Lcom/google/gwt/core/client/JavaScriptObject;)
       (@jsupload.client.PreloadImage::class, $wnd.jsu.PreloadImage);
      
      if(pkg) for (p in pkg) if ($wnd.jsu.PreloadImage[p] === undefined) $wnd.jsu.PreloadImage[p] = pkg[p];
    }-*/;
    public static jsupload.client.PreloadImage ___create(com.google.gwt.core.client.JavaScriptObject a0) {
      return new jsupload.client.PreloadImage(a0);
    }
    private static boolean exported;
    public void export() { 
      if(!exported) {
        exported=true;
        export0();
      }
    }
}
