package com.bluehost.test.jag.acme.service;

import com.bluehost.test.jag.acme.data.model.CustomerProduct;

public class PaymentService {

	private static PaymentService instance = new PaymentService();
	
	private PaymentService()	{}

	public static PaymentService getInstance() {
		return instance;
	}
	
	public void sendPayment(CustomerProduct customerProduct)	{
		//Process the payment
		System.out.println("Payment processed successfully");
	}
}
