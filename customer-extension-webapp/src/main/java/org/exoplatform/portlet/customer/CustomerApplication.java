package org.exoplatform.portlet.customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import juzu.*;
import juzu.request.RenderContext;
import juzu.template.Template;
import javax.inject.Inject;
import javax.inject.Provider;


import org.json.JSONObject;

public class CustomerApplication {

  @Inject
  @Path("index.gtmpl")
  Template index;
  
  

  @Inject
  public CustomerApplication()
  {
    
  }


  @View
  public void index(RenderContext renderContext) throws Exception
  {
    
    
    index.render();
  }  
}
