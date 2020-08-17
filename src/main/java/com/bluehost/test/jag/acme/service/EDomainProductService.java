package com.bluehost.test.jag.acme.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.bluehost.test.jag.acme.data.model.CustomerProduct;
import com.bluehost.test.jag.acme.exceptions.UnsupportedProductException;
import com.bluehost.test.jag.acme.web.CustomerProductRequest;

@Service("edomain")
public class EDomainProductService extends ProductService {


	@Override
	public void validateCreateRequest(CustomerProductRequest customerProductRequest) {
		// TODO Auto-generated method stub
	}

	@Override
	public CustomerProduct add(CustomerProductRequest customerProductRequest) {
		
		throw new RuntimeException("Product is not offered currently");
	}

	@Override
	protected void completeRegistration(CustomerProduct customerProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Date getExpirationDate(int duration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getDuration(int duration) {
		// TODO Auto-generated method stub
		return 0;
	}

}
