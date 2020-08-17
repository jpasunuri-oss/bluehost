package com.bluehost.test.jag.acme.service;

import java.util.Calendar;
import java.util.Date;

import com.bluehost.test.jag.acme.data.dao.CustomerProductDAO;
import com.bluehost.test.jag.acme.data.model.CustomerProduct;
import com.bluehost.test.jag.acme.web.CustomerProductRequest;

public abstract class ProductService {
	
	public abstract void validateCreateRequest(CustomerProductRequest customerProductRequest);
	
	public CustomerProduct add(CustomerProductRequest productRequest)	{
		
		CustomerProduct customerProduct = new CustomerProduct();
		customerProduct.setCustomerId(productRequest.getCustomerId());
		customerProduct.setDomainName(productRequest.getDomainName());
		customerProduct.setProductName(productRequest.getProductName());
		int duration = getDuration(productRequest.getDuration());
		customerProduct.setDuration(duration);
		customerProduct.setExpirationDate(getExpirationDate(duration));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + productRequest.getDuration());
		
		customerProduct.setExpirationDate(cal.getTime());
		CustomerProductDAO.getInstance().add(customerProduct);
		
		PaymentService.getInstance().sendPayment(customerProduct);
		
		completeRegistration(customerProduct);
		
		return customerProduct;
	}
	
	protected abstract void completeRegistration(CustomerProduct customerProduct);

	protected abstract Date getExpirationDate(int duration);

	protected abstract int getDuration(int duration);		
	
}
