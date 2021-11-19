package gwtupload.client.bundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class UploadCss_ie10_default_InlineClientBundleGenerator implements gwtupload.client.bundle.UploadCss {
  private static UploadCss_ie10_default_InlineClientBundleGenerator _instance0 = new UploadCss_ie10_default_InlineClientBundleGenerator();
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GWTUpld,table.GWTUpld td{font-family:" + ("Verdana"+ ","+ " " +"Arial")  + ";font-size:" + ("12px")  + ";padding:" + ("0")  + ";}.GWTUpld form,.GWTUpld .upld-form-elements{padding:" + ("0")  + ";vertical-align:" + ("top")  + ";}.GWTUpld .upld-status{font-family:" + ("arial")  + ";font-size:" + ("12px")  + ";font-weight:" + ("bold")  + ";}.GWTUpld .upld-status div.cancel{width:" + ("12px")  + ";height:" + ("12px")  + ";cursor:") + (("pointer")  + ";margin-top:" + ("1px")  + ";height:" + ((UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUpload()).getHeight() + "px")  + ";width:" + ((UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUpload()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUpload()).getSafeUri().asString() + "\") -" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUpload()).getLeft() + "px -" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUpload()).getTop() + "px  no-repeat")  + ";}.GWTUpld .upld-status div.cancel:hover{height:" + ((UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUploadHover()).getHeight() + "px")  + ";width:" + ((UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUploadHover()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUploadHover()).getSafeUri().asString() + "\") -" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUploadHover()).getLeft() + "px -" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUploadHover()).getTop() + "px  no-repeat")  + ";}.GWTUpld .upld-status .filename{overflow:" + ("hidden") ) + (";white-space:" + ("nowrap")  + ";margin-right:" + ("8px")  + ";margin-left:" + ("11px")  + ";height:" + ("100%")  + ";font-size:" + ("12px")  + ";max-width:" + ("200px")  + ";text-overflow:" + ("ellipsis")  + ";}.GWTUpld .upld-status .status{padding-right:" + ("8px")  + ";white-space:" + ("nowrap")  + ";height:" + ("100%")  + ";font-size:") + (("12px")  + ";}.GWTUpld .upld-status .status-success{color:" + ("green")  + ";}.GWTUpld .upld-status .status-error,.GWTUpld .upld-status .status-canceled{color:" + ("red")  + ";}.GWTUpld .prgbar{height:" + ("12px")  + ";float:" + ("right")  + ";width:" + ("100px")  + ";margin-right:" + ("2px")  + ";}.GWTUpld .prgbar-back{background:" + ("#fff"+ " " +"none"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#999")  + ";overflow:" + ("hidden")  + ";padding:" + ("1px") ) + (";}.GWTUpld .prgbar-done{background:" + ("#d4e4ff"+ " " +"none"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0")  + ";font-size:" + ("0")  + ";height:" + ("100%")  + ";float:" + ("right")  + ";}.GWTUpld .prgbar-msg{position:" + ("absolute")  + ";z-index:" + ("9")  + ";font-size:" + ("9px")  + ";font-weight:" + ("normal")  + ";margin-right:" + ("3px")  + ";}.GWTUpld .changed{color:" + ("red")  + ";font-weight:") + (("bold")  + ";text-decoration:" + ("blink")  + ";}.upld-modal .GWTUpld{border:" + ("2px"+ " " +"groove"+ " " +"#f6a828")  + ";padding:" + ("10px")  + ";background:" + ("#bf984c")  + ";-moz-border-radius-bottomleft:" + ("6px")  + ";-moz-border-radius-bottomright:" + ("6px")  + ";-moz-border-radius-topleft:" + ("6px")  + ";-moz-border-radius-topright:" + ("6px")  + ";}.upld-modal-glass{background-color:" + ("#d4e4ff")  + ";opacity:" + ("0.3") ) + (";}.GWTUpld .DecoratedFileUpload{margin-left:" + ("5px")  + ";display:" + ("inline-block")  + ";}.GWTUpld .DecoratedFileUpload-button{white-space:" + ("nowrap")  + ";font-size:" + ("10px")  + ";cursor:" + ("pointer")  + ";}.GWTUpld .gwt-Button,.GWTUpld .gwt-FileUpload{font-size:" + ("10px")  + ";min-height:" + ("15px")  + ";}.GWTUpld .DecoratedFileUpload .gwt-Anchor,.GWTUpld .DecoratedFileUpload .gwt-Label{color:" + ("blue")  + ";text-decoration:" + ("underline")  + ";cursor:" + ("pointer")  + ";}.GWTUpld .DecoratedFileUpload-button:HOVER,.GWTUpld .DecoratedFileUpload-button-over{color:") + (("#af6b29")  + ";}.GWTUpld .DecoratedFileUpload-disabled,.GWTUpld .DecoratedFileUpload-disabled .gwt-Anchor,.GWTUpld .DecoratedFileUpload-disabled .gwt-Button,.GWTUpld .DecoratedFileUpload-disabled .gwt-Label{color:" + ("grey")  + " !important;}.GWTUpld input[type=\"file\"]{cursor:" + ("pointer")  + ";}.upld-drop-zone{border:" + ("1px"+ " " +"dashed")  + ";}.upld-drop-zone-sending{opacity:" + ("0.2")  + ";}")) : ((".GWTUpld,table.GWTUpld td{font-family:" + ("Verdana"+ ","+ " " +"Arial")  + ";font-size:" + ("12px")  + ";padding:" + ("0")  + ";}.GWTUpld form,.GWTUpld .upld-form-elements{padding:" + ("0")  + ";vertical-align:" + ("top")  + ";}.GWTUpld .upld-status{font-family:" + ("arial")  + ";font-size:" + ("12px")  + ";font-weight:" + ("bold")  + ";}.GWTUpld .upld-status div.cancel{width:" + ("12px")  + ";height:" + ("12px")  + ";cursor:") + (("pointer")  + ";margin-top:" + ("1px")  + ";height:" + ((UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUpload()).getHeight() + "px")  + ";width:" + ((UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUpload()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUpload()).getSafeUri().asString() + "\") -" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUpload()).getLeft() + "px -" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUpload()).getTop() + "px  no-repeat")  + ";}.GWTUpld .upld-status div.cancel:hover{height:" + ((UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUploadHover()).getHeight() + "px")  + ";width:" + ((UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUploadHover()).getWidth() + "px")  + ";overflow:" + ("hidden")  + ";background:" + ("url(\"" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUploadHover()).getSafeUri().asString() + "\") -" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUploadHover()).getLeft() + "px -" + (UploadCss_ie10_default_InlineClientBundleGenerator.this.imgCancelUploadHover()).getTop() + "px  no-repeat")  + ";}.GWTUpld .upld-status .filename{overflow:" + ("hidden") ) + (";white-space:" + ("nowrap")  + ";margin-left:" + ("8px")  + ";margin-right:" + ("11px")  + ";height:" + ("100%")  + ";font-size:" + ("12px")  + ";max-width:" + ("200px")  + ";text-overflow:" + ("ellipsis")  + ";}.GWTUpld .upld-status .status{padding-left:" + ("8px")  + ";white-space:" + ("nowrap")  + ";height:" + ("100%")  + ";font-size:") + (("12px")  + ";}.GWTUpld .upld-status .status-success{color:" + ("green")  + ";}.GWTUpld .upld-status .status-error,.GWTUpld .upld-status .status-canceled{color:" + ("red")  + ";}.GWTUpld .prgbar{height:" + ("12px")  + ";float:" + ("left")  + ";width:" + ("100px")  + ";margin-left:" + ("2px")  + ";}.GWTUpld .prgbar-back{background:" + ("#fff"+ " " +"none"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0")  + ";border:" + ("1px"+ " " +"solid"+ " " +"#999")  + ";overflow:" + ("hidden")  + ";padding:" + ("1px") ) + (";}.GWTUpld .prgbar-done{background:" + ("#d4e4ff"+ " " +"none"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0")  + ";font-size:" + ("0")  + ";height:" + ("100%")  + ";float:" + ("left")  + ";}.GWTUpld .prgbar-msg{position:" + ("absolute")  + ";z-index:" + ("9")  + ";font-size:" + ("9px")  + ";font-weight:" + ("normal")  + ";margin-left:" + ("3px")  + ";}.GWTUpld .changed{color:" + ("red")  + ";font-weight:") + (("bold")  + ";text-decoration:" + ("blink")  + ";}.upld-modal .GWTUpld{border:" + ("2px"+ " " +"groove"+ " " +"#f6a828")  + ";padding:" + ("10px")  + ";background:" + ("#bf984c")  + ";-moz-border-radius-bottomleft:" + ("6px")  + ";-moz-border-radius-bottomright:" + ("6px")  + ";-moz-border-radius-topleft:" + ("6px")  + ";-moz-border-radius-topright:" + ("6px")  + ";}.upld-modal-glass{background-color:" + ("#d4e4ff")  + ";opacity:" + ("0.3") ) + (";}.GWTUpld .DecoratedFileUpload{margin-right:" + ("5px")  + ";display:" + ("inline-block")  + ";}.GWTUpld .DecoratedFileUpload-button{white-space:" + ("nowrap")  + ";font-size:" + ("10px")  + ";cursor:" + ("pointer")  + ";}.GWTUpld .gwt-Button,.GWTUpld .gwt-FileUpload{font-size:" + ("10px")  + ";min-height:" + ("15px")  + ";}.GWTUpld .DecoratedFileUpload .gwt-Anchor,.GWTUpld .DecoratedFileUpload .gwt-Label{color:" + ("blue")  + ";text-decoration:" + ("underline")  + ";cursor:" + ("pointer")  + ";}.GWTUpld .DecoratedFileUpload-button:HOVER,.GWTUpld .DecoratedFileUpload-button-over{color:") + (("#af6b29")  + ";}.GWTUpld .DecoratedFileUpload-disabled,.GWTUpld .DecoratedFileUpload-disabled .gwt-Anchor,.GWTUpld .DecoratedFileUpload-disabled .gwt-Button,.GWTUpld .DecoratedFileUpload-disabled .gwt-Label{color:" + ("grey")  + " !important;}.GWTUpld input[type=\"file\"]{cursor:" + ("pointer")  + ";}.upld-drop-zone{border:" + ("1px"+ " " +"dashed")  + ";}.upld-drop-zone-sending{opacity:" + ("0.2")  + ";}"));
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
  private void imgCancelUploadInitializer() {
    imgCancelUpload = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "imgCancelUpload",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 12, 12, false, false
    );
  }
  private static class imgCancelUploadInitializer {
    static {
      _instance0.imgCancelUploadInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return imgCancelUpload;
    }
  }
  public com.google.gwt.resources.client.ImageResource imgCancelUpload() {
    return imgCancelUploadInitializer.get();
  }
  private void imgCancelUploadHoverInitializer() {
    imgCancelUploadHover = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "imgCancelUploadHover",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage0),
      0, 0, 12, 12, false, false
    );
  }
  private static class imgCancelUploadHoverInitializer {
    static {
      _instance0.imgCancelUploadHoverInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return imgCancelUploadHover;
    }
  }
  public com.google.gwt.resources.client.ImageResource imgCancelUploadHover() {
    return imgCancelUploadHoverInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.CssResource css;
  private static final java.lang.String externalImage = "data:image/gif;base64,R0lGODlhDAAMAKU9ANk/P9lBQdpHR9tJSdxRUdtSUtxXV91cXN5eXt5hYeJubuN3d+V5eeN6euN8fOV+fuaDg+eFheOHh+eIiOeKiueOjumPj+WSkemVleuZmeudneafn+uenuujo+2kpO+vr/C2tuu6uum7uvK+vvDBwO7DwvTHx/XLy+zOzu3OzvXOzuzR0OzS0fHS0vbS0vbU1PbV1e/d2u/e3vjc3Pji4u7l5O/l4/rm5u7s6u7t6+7u7Pzu7vvv7////////////yH5BAEKAD8ALAAAAAAMAAwAAAZ/wJfH0yl2OEUPqLO70WZQKO2GnMFcKtXppHLBMBqVqWUjgWQxksmSGYFKuZosl/qAKJgPMZTLoTIcHhAWHRkWLH02GBUYDhYWEyE6Ihs4Kw8RCxMRDREbCQkSFwoNmg0KCQcEBAUGCKAVqAYCAQABAwOgLxMPDwwMDQwODxAgQQA7";
  private static final java.lang.String externalImage0 = "data:image/gif;base64,R0lGODlhDAAMAKUvAKhKuatQu6xTvK9Yv7Bav7JewbRiw7VlxLdoxbx0ycF+zcJ/zsKBzsSEz8aI0ceL0siM08mO08uS1cuU1cyV1s2Y18+c2dKh2tSl3NSm3dmw4d255N675OC/5uHC5+LD6OTI6ebM6+jP7OjQ7enS7erT7urV7u3Z8O3a8fDg8/Lk9fPm9fPn9vTp9vbt+P///////////////////////////////////////////////////////////////////yH+EUNyZWF0ZWQgd2l0aCBHSU1QACH5BAEKAD8ALAAAAAAMAAwAAAZ7QFMmgyliLsXMBuNSpVBQaEqFRJlKIlEoJCqZKhcRiJTybFAnD2hi6Ww+rCcrpNlEKhoihzW3XDIOExgWEyN8KRUSFQwTExAcLRwXKyINDwoQDwsPFwgIDxQJC5gLCQgGAwMEBQeeEqYFAQCzAgKeJhANDQoKowwNDhtBADs=";
  private static com.google.gwt.resources.client.ImageResource imgCancelUpload;
  private static com.google.gwt.resources.client.ImageResource imgCancelUploadHover;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
      imgCancelUpload(), 
      imgCancelUploadHover(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
        resourceMap.put("imgCancelUpload", imgCancelUpload());
        resourceMap.put("imgCancelUploadHover", imgCancelUploadHover());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@gwtupload.client.bundle.UploadCss::css()();
      case 'imgCancelUpload': return this.@gwtupload.client.bundle.UploadCss::imgCancelUpload()();
      case 'imgCancelUploadHover': return this.@gwtupload.client.bundle.UploadCss::imgCancelUploadHover()();
    }
    return null;
  }-*/;
}
