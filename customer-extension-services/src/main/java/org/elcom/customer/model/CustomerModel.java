package org.elcom.customer.model;

import java.io.Serializable;

import juzu.Mapped;

@Mapped
public class CustomerModel implements Serializable{
  private static final long serialVersionUID = 1L;
  
  private String customerName = "";
  private String customerAddress = "";
  
  public String getCustomerName() {
    return customerName;
  }
  public String getCustomereAddress() {
	  return customerAddress;
  }
  
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }
}
