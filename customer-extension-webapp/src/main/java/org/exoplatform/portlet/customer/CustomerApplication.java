package org.exoplatform.portlet.customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import juzu.*;
import juzu.request.HttpContext;
import juzu.request.RenderContext;
import juzu.template.Template;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpSession;

import org.exoplatform.portal.application.PortalRequestContext;
import org.exoplatform.portal.webui.util.Util;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.elcom.customer.model.CustomerModel;
import org.elcom.customer.services.CustomerService;
import org.json.JSONObject;

public class CustomerApplication {

  @Inject
  @Path("index.gtmpl")
  Template index;
  
  Log log = ExoLogger.getLogger("CustomerApplication");
  CustomerService customerService_;

  @Inject
  public CustomerApplication(CustomerService customerService) {
    customerService_ = customerService;
  }


  @View
  public void index(RenderContext renderContext) throws Exception
  {   
    String customerName = "";
    String customerAddress = "";
    CustomerModel customerModel = null;
    //PortalRequestContext requestContext = Util.getPortalRequestContext();
    //HttpSession httpSession = requestContext.getRequest().getSession();
    
    index.render();
  }  
  
  @Action
  @Route("/save")
  public Response save(String customerName, String customerAddress, HttpContext context) {
    if(context.getMethod().equals(Method.GET)) {
      return CustomerApplication_.index();
    }
    
    CustomerService customerSerice = new CustomerService();
    CustomerModel customerModel = new CustomerModel();
    customerModel.setCustomerName(customerName);
    customerModel.setCustomerAddress(customerAddress);
    customerSerice.save(customerModel);
    
    return CustomerApplication_.index();
  }
}
