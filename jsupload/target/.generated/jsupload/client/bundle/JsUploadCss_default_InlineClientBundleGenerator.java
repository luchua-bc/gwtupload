package jsupload.client.bundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class JsUploadCss_default_InlineClientBundleGenerator implements jsupload.client.bundle.JsUploadCss {
  private static JsUploadCss_default_InlineClientBundleGenerator _instance0 = new JsUploadCss_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new com.google.gwt.resources.client.CssResource() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "css";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? (("div.GWTCProgress-dialog{border:" + ("solid"+ " " +"3px"+ " " +"pink")  + ";z-index:" + ("999")  + ";font-family:" + ("\"Trebuchet MS\""+ ","+ " " +"Helvetica"+ ","+ " " +"Arial"+ ","+ " " +"sans-serif")  + ";background-color:" + ("white")  + ";}.GWTCProgress .prg-title{font-weight:" + ("bold")  + ";}.GWTCProgress .prg-numbers,.GWTCProgress .prg-time{font-size:" + ("12px")  + ";font-style:" + ("italic")  + ";}.GWTCProgress .prg-bar-outer{border:" + ("1px"+ " " +"solid"+ " " +"grey")  + ";}.GWTCProgress .prg-bar-inner{border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";margin:" + ("1px")  + ";}.GWTCProgress .prg-bar-element{width:") + (("5px")  + ";height:" + ("15px")  + ";margin:" + ("1px")  + ";}.GWTCProgress .prg-bar-done{background:" + ("#83ae76")  + ";}.GWTCProgress .prg-bar-blank{background:" + ("#eee")  + ";}.GWTCProgress .prg-numbers{width:" + ("200px")  + ";}.upld-status .GWTCProgress .prg-bar-element{height:" + ("2px")  + ";}.upld-status .GWTCProgress .prg-title{font-size:" + ("12px")  + ";margin-top:" + ("-3px")  + ";margin-right:" + ("5px")  + ";}.upld-multiple .GWTCProgress .prg-time{height:" + ("0") ) + (";}.gwt-ProgressBar-shell{margin:" + ("2px")  + ";background-color:" + ("#eee")  + ";height:" + ("12px")  + ";width:" + ("250px")  + ";-moz-border-radius-bottomleft:" + ("4px")  + ";-moz-border-radius-bottomright:" + ("4px")  + ";-moz-border-radius-topleft:" + ("4px")  + ";-moz-border-radius-topright:" + ("4px")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";}.gwt-ProgressBar-shell .gwt-ProgressBar-bar{background-color:" + ("#f6a828")  + ";-moz-border-radius-bottomleft:") + (("4px")  + ";-moz-border-radius-topleft:" + ("4px")  + ";}.gwt-ProgressBar-shell .gwt-ProgressBar-text{padding:" + ("0")  + ";margin:" + ("0")  + ";color:" + ("grey")  + ";white-space:" + ("nowrap")  + ";font-size:" + ("8px")  + ";}")) : (("div.GWTCProgress-dialog{border:" + ("solid"+ " " +"3px"+ " " +"pink")  + ";z-index:" + ("999")  + ";font-family:" + ("\"Trebuchet MS\""+ ","+ " " +"Helvetica"+ ","+ " " +"Arial"+ ","+ " " +"sans-serif")  + ";background-color:" + ("white")  + ";}.GWTCProgress .prg-title{font-weight:" + ("bold")  + ";}.GWTCProgress .prg-numbers,.GWTCProgress .prg-time{font-size:" + ("12px")  + ";font-style:" + ("italic")  + ";}.GWTCProgress .prg-bar-outer{border:" + ("1px"+ " " +"solid"+ " " +"grey")  + ";}.GWTCProgress .prg-bar-inner{border:" + ("1px"+ " " +"solid"+ " " +"black")  + ";margin:" + ("1px")  + ";}.GWTCProgress .prg-bar-element{width:") + (("5px")  + ";height:" + ("15px")  + ";margin:" + ("1px")  + ";}.GWTCProgress .prg-bar-done{background:" + ("#83ae76")  + ";}.GWTCProgress .prg-bar-blank{background:" + ("#eee")  + ";}.GWTCProgress .prg-numbers{width:" + ("200px")  + ";}.upld-status .GWTCProgress .prg-bar-element{height:" + ("2px")  + ";}.upld-status .GWTCProgress .prg-title{font-size:" + ("12px")  + ";margin-top:" + ("-3px")  + ";margin-left:" + ("5px")  + ";}.upld-multiple .GWTCProgress .prg-time{height:" + ("0") ) + (";}.gwt-ProgressBar-shell{margin:" + ("2px")  + ";background-color:" + ("#eee")  + ";height:" + ("12px")  + ";width:" + ("250px")  + ";-moz-border-radius-bottomleft:" + ("4px")  + ";-moz-border-radius-bottomright:" + ("4px")  + ";-moz-border-radius-topleft:" + ("4px")  + ";-moz-border-radius-topright:" + ("4px")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";}.gwt-ProgressBar-shell .gwt-ProgressBar-bar{background-color:" + ("#f6a828")  + ";-moz-border-radius-bottomleft:") + (("4px")  + ";-moz-border-radius-topleft:" + ("4px")  + ";}.gwt-ProgressBar-shell .gwt-ProgressBar-text{padding:" + ("0")  + ";margin:" + ("0")  + ";color:" + ("grey")  + ";white-space:" + ("nowrap")  + ";font-size:" + ("8px")  + ";}"));
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static com.google.gwt.resources.client.CssResource get() {
      return css;
    }
  }
  public com.google.gwt.resources.client.CssResource css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.CssResource css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@jsupload.client.bundle.JsUploadCss::css()();
    }
    return null;
  }-*/;
}
