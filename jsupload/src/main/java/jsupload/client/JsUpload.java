/*
 * Copyright 2010 Manuel Carrasco Moñino. (manolo at apache/org) 
 * http://code.google.com/p/gwtupload
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package jsupload.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;

/**
 * @author Manolo Carrasco Moñino T
 * <p>
 * This class exports the gwtUpload library into native javascript library.
 * </p>
 */
public class JsUpload implements EntryPoint {

  /**  
   * This method is called as soon as the browser loads the page and
   * classes and methods are available to be used from javascript.
   * Eventually the javascript method jsuOnLoad is called if it exists.
   */
  public void onModuleLoad() {
    GWT.create(Upload.class);
    GWT.create(PreloadImage.class);
    
    // Sleep for a while until all css stuff has been loaded
    new Timer() {
      public void run() {
        onLoadImpl();
      }
    }.schedule(1500);
  }

  private native void onLoadImpl() /*-{
    try {
      if ($wnd.jsuOnLoad) $wnd.jsuOnLoad();
    } catch(e) {
      alert("Error executing jsuOnLoad method: " + e);
    }
  }-*/;
}
