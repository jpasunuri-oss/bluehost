package com.bluehost.test.jag.acme.data.dao;

import java.util.ArrayList;
import java.util.List;

import com.bluehost.test.jag.acme.data.model.Customer;

public class CustomerDAO {
	
	List<Customer> customers = new ArrayList<Customer>();
	private static CustomerDAO instance = new CustomerDAO();

	private CustomerDAO()	{
		// Establish Data Base Connections
		Customer customer1 = new Customer();
		customer1.setId("Cust123");
		customers.add(customer1);		

		Customer customer2 = new Customer();
		customer2.setId("Cust234");
		customers.add(customer2);		

		Customer customer3 = new Customer();
		customer3.setId("Cust345");
		customers.add(customer3);		

		Customer customer4 = new Customer();
		customer4.setId("Cust456");
		customers.add(customer4);
	}

	public static CustomerDAO getInstance() {
		return instance;
	}
	
	public List<Customer> getCustomers()	{
		// Load all customers in the system and cache	
		
		return customers;
	}
}
