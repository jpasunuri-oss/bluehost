package com.bluehost.test.jag.acme.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.bluehost.test.jag.acme.data.dao.CustomerDAO;
import com.bluehost.test.jag.acme.data.dao.CustomerProductDAO;
import com.bluehost.test.jag.acme.data.model.Customer;
import com.bluehost.test.jag.acme.data.model.CustomerProduct;
import com.bluehost.test.jag.acme.exceptions.ValidationException;
import com.bluehost.test.jag.acme.web.CustomerProductRequest;

@Service("hosting")
public class HostingProductService extends ProductService {


	@Override
	public void validateCreateRequest(CustomerProductRequest request) {		
		
		String domainName = request.getDomainName();
		if(domainName == null || domainName.length() == 0)	throw new ValidationException("Domain Name is Empty ");
		String p = "^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+org|com";		
		Matcher matcher = Pattern.compile(p).matcher(domainName);		
		if(!matcher.find())	throw new ValidationException("Domain Name not valid ");
		
		CustomerDAO customerDAO = CustomerDAO.getInstance();		
		List<Customer> customers = customerDAO.getCustomers();
		boolean customerExists = false;
		for(Customer customer: customers)	{
			if(customer.getId().equals(request.getCustomerId()))	{
				customerExists = true;
				break;
			}
		}
		if(!customerExists)	throw new ValidationException("Customer Not Found");
		
		if(request.getDuration() <= 0)	throw new ValidationException("Invalid Duration. Duration should be in months");		
		
		CustomerProductDAO customerProductDAO = CustomerProductDAO.getInstance();		
		List<CustomerProduct> customerDomains = customerProductDAO.getProducts(request.getCustomerId());		
		boolean domainExists = false;
		for(CustomerProduct domain: customerDomains)	{
			if(domain.getDomainName().equals(request.getDomainName()))	{
				domainExists = true;
				break;
			}
		}
		
		if(!domainExists) throw new ValidationException("Domain registration does not exists");	
	 
	}

	@Override
	protected int getDuration(int duration) {		
		return duration;
	}

	@Override
	protected Date getExpirationDate(int duration) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + duration);		
		return cal.getTime();
	}

	@Override
	protected void completeRegistration(CustomerProduct customerProduct) {

		System.out.println("Account Provisioned Successfully");
		
		System.out.println("Welcome Email Sent Successfully");
		
		
	}
}
