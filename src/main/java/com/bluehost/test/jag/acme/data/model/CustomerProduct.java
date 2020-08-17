package com.bluehost.test.jag.acme.data.model;

import java.util.Date;

public class CustomerProduct implements Comparable<CustomerProduct>{
	
	private String customerId;
	private String productName;
	private String domainName;
	private int duration;
	private Date expirationDate;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public int compareTo(CustomerProduct o) {
		if(customerId.equals(o.customerId))	return 0;
		return customerId.compareTo(o.customerId);
	}
	
	
}
