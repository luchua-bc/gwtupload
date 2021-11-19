package jsupload.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import org.timepedia.exporter.client.Exporter;
import org.timepedia.exporter.client.ExporterUtil;

public class UploadExporterImpl implements Exporter {
    public UploadExporterImpl() { export(); }
    public native void export0() /*-{
      var pkg = @org.timepedia.exporter.client.ExporterUtil::declarePackage(Ljava/lang/String;)('jsu.Upload');
      var _;
      $wnd.jsu.Upload = $entry(function() {
        var g, j = this;
        if (@org.timepedia.exporter.client.ExporterUtil::isAssignableToInstance(Ljava/lang/Class;Lcom/google/gwt/core/client/JavaScriptObject;)(@jsupload.client.Upload::class, arguments))
          g = arguments[0];
        else if (arguments.length == 1)
          g = @jsupload.client.UploadExporterImpl::___create(Lcom/google/gwt/core/client/JavaScriptObject;)(arguments[0]);
        j.g = g;
        @org.timepedia.exporter.client.ExporterUtil::setWrapper(Ljava/lang/Object;Lcom/google/gwt/core/client/JavaScriptObject;)(g, j);
        return j;
      });
      _ = $wnd.jsu.Upload.prototype = new Object();
      _.data = $entry(function() { 
        return this.g.@jsupload.client.Upload::data()();
      });
      _.addElement = $entry(function(a0,a1) { 
        @org.timepedia.exporter.client.ExporterUtil::runDispatch(Ljava/lang/Object;Ljava/lang/Class;ILcom/google/gwt/core/client/JsArray;ZZ)
         (this.g, @jsupload.client.Upload::class, 0 , arguments, false, false)[0];
      });
      _.submit = $entry(function() { 
        this.g.@jsupload.client.Upload::submit()();
      });
      
      @org.timepedia.exporter.client.ExporterUtil::registerDispatchMap(Ljava/lang/Class;Lcom/google/gwt/core/client/JavaScriptObject;Z)
      (@jsupload.client.Upload::class,{
        0:{
          1:[[function() { return this.@jsupload.client.Upload::addElement(Lcom/google/gwt/user/client/Element;).apply(this, arguments); },null,,"object",],],
          2:[[function() { return this.@jsupload.client.Upload::addElement(Lcom/google/gwt/user/client/Element;I).apply(this, arguments); },null,,"object","number",],],
        },
      }, false);
      
      @org.timepedia.exporter.client.ExporterUtil::addTypeMap(Ljava/lang/Class;Lcom/google/gwt/core/client/JavaScriptObject;)
       (@jsupload.client.Upload::class, $wnd.jsu.Upload);
      
      if(pkg) for (p in pkg) if ($wnd.jsu.Upload[p] === undefined) $wnd.jsu.Upload[p] = pkg[p];
    }-*/;
    public static jsupload.client.Upload ___create(com.google.gwt.core.client.JavaScriptObject a0) {
      return new jsupload.client.Upload(a0);
    }
    private static boolean exported;
    public void export() { 
      if(!exported) {
        exported=true;
        export0();
      }
    }
}
