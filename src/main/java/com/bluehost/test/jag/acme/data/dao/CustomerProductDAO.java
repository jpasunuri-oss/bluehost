package com.bluehost.test.jag.acme.data.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import com.bluehost.test.jag.acme.data.model.CustomerProduct;

public class CustomerProductDAO {
	
	private static CustomerProductDAO instance  = new CustomerProductDAO();
	
	ReentrantLock lock = new ReentrantLock();
	
	List<CustomerProduct> products = new ArrayList<CustomerProduct>();
	
	CustomerProductDAO()	{
		
	}

	public static CustomerProductDAO getInstance()	{
		return instance;
	}
	
	public List<CustomerProduct> getProducts(String customerId)	{
		return products.stream().filter(cp -> cp.getCustomerId().equals(customerId))
				.sorted(Comparator.comparing(CustomerProduct::getCustomerId)).collect(Collectors.toList());
	}
	
	public List<CustomerProduct> getProductsGroupByCustomer()	{
		return products.stream().sorted(Comparator.comparing(CustomerProduct::getCustomerId)).collect(Collectors.toList());
	}
	
	public List<CustomerProduct> getProducts()	{
		return products;
	}
	
	public void add(CustomerProduct customerProduct)	{
		lock.lock();
		try	{
			products.add(customerProduct);			
		}
		finally {
			lock.unlock();
		}		
	}
	
	public void load(List<CustomerProduct> customerDomains)	{
		for(CustomerProduct product: customerDomains) {
			add(product);
		}
	}
	
}
