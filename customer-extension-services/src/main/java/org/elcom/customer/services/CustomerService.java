package org.elcom.customer.services;

import java.io.Serializable;

import javax.jcr.LoginException;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.elcom.customer.model.CustomerModel;
import org.exoplatform.commons.utils.CommonsUtils;
import org.exoplatform.services.cache.CacheService;
import org.exoplatform.services.cache.ExoCache;
import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.services.jcr.ext.common.SessionProvider;
import org.exoplatform.services.jcr.util.Text;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

public class CustomerService {
	private static final Log LOG = ExoLogger.getLogger(CustomerService.class.getName());	  
	protected static final String WORKSPACE_NAME = "collaboration";
	
	 private static ExoCache<Serializable, CustomerModel> customerCache;
	 public static String CUSTOMER_PROFILE_KEY = "videoCallsProfile" + CommonsUtils.getRepository().getConfiguration().getName();
	 public static String BASE_PATH = "exo:applications";
	 public static String CUSTOMER_BASE_PATH = "CustomerManagement";
	 public static String CUSTOMER_NODETYPE = "exo:Customer";
	 public static String CUSTOMER_NAME_PROP = "exo:customerName";
	 public static String CUSTOMER_ADDRESS_PROP = "exo:customerAddress";
	 public static final String NT_BASE = "nt:base";

	 
	 /**
	   * Method constructor   
	   */
	  public CustomerService() {
	    customerCache = CommonsUtils.getService(CacheService.class).getCacheInstance(CustomerService.class.getName());
	  }
	  
	  public void save(CustomerModel customerModel) {
	    String customerName = customerModel.getCustomerName();
	    String customerAddress = customerModel.getCustomereAddress();
	    SessionProvider sessionProvider = null;
	    try {
	      
	      sessionProvider = CommonsUtils.getUserSessionProvider();
	      RepositoryService repositoryService = CommonsUtils.getService(RepositoryService.class);
	      Session session = sessionProvider.getSession(WORKSPACE_NAME, repositoryService.getCurrentRepository());
	      
	      Node rootNode = session.getRootNode();
	      Node baseNode = rootNode.getNode(BASE_PATH);
	      
	      Node customerBaseNode = null;
	      if(baseNode.hasNode(CUSTOMER_BASE_PATH)) {
	        customerBaseNode = baseNode.getNode(CUSTOMER_BASE_PATH);
	      } else {
	        customerBaseNode = baseNode.addNode(CUSTOMER_BASE_PATH, NT_BASE);    
	        customerBaseNode.save();
	      }
	     
	      Node customerNode = null;
	      String nodeName = Text.escapeIllegalJcrChars(customerName);
	      if(customerBaseNode.hasNode(nodeName)) {
	        customerNode = customerBaseNode.getNode(nodeName);
        } else {
          customerNode = customerBaseNode.addNode(nodeName, CUSTOMER_NODETYPE);  
          customerNode.save();
        }
	      customerNode.setProperty(CUSTOMER_NAME_PROP, customerName);
	      customerNode.setProperty(CUSTOMER_ADDRESS_PROP, customerAddress);
	      
	      session.save();  
	      customerCache.put(CUSTOMER_PROFILE_KEY, customerModel);
	      
	    } catch (LoginException e) {	      
	      e.printStackTrace();
	      if (LOG.isErrorEnabled()) {
	        LOG.error("saveCustomer() failed because of ", e);
	      }
	    } catch (NoSuchWorkspaceException e) {
	      e.printStackTrace();
	      if (LOG.isErrorEnabled()) {
	        LOG.error("saveCustomer() failed because of ", e);
	      }
	    } catch (RepositoryException e) {
	      e.printStackTrace();
	      if (LOG.isErrorEnabled()) {
	        LOG.error("saveCustomer() failed because of ", e);
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	      if (LOG.isErrorEnabled()) {
	        LOG.error("saveCustomer() failed because of ", e);
	      }
	    } 
	    
	  }
	  ///////////////
	  
}
