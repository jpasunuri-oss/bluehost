package com.bluehost.test.jag.acme.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluehost.test.jag.acme.BeanFactoryDynamicAutowireService;
import com.bluehost.test.jag.acme.data.dao.CustomerProductDAO;
import com.bluehost.test.jag.acme.data.model.CustomerProduct;
import com.bluehost.test.jag.acme.exceptions.ValidationException;
import com.bluehost.test.jag.acme.service.ProductService;

@RestController
@RequestMapping(value = "/acme")
public class AcmeServiceController {

	private static String[] PRODUCTS = new String[] {"domain", "hosting", "email", "pdomain", "edomain"};

	@Autowired
	BeanFactoryDynamicAutowireService autowireService;
	
	@GetMapping
	public String saySomething()	{
		return "Hello World " ;
	} 
	
	@PostMapping(value = "/product/{product}/customer/{customerId}")
	public ResponseEntity<String> registerDomain(@PathVariable(name = "product") String product, @PathVariable(name = "customerId") String customerId, 
										@RequestBody CustomerProductRequest customerProductRequest)	{
		
		if(customerProductRequest == null)	throw new ValidationException("Request Is Empty");
		
		List<String> products = Arrays.asList(PRODUCTS);
		
		if(!products.contains(product))	throw new ValidationException("Invalid Product Name - Valid products " + products.stream().collect(Collectors.toList()));	
		
		customerProductRequest.setCustomerId(customerId);
		ProductService service = autowireService.getService(product);
		
		service.validateCreateRequest(customerProductRequest);
		customerProductRequest.setProductName(product);
		service.add(customerProductRequest);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		
	}
	
	@GetMapping(value = "/customer/{customerId}/products")
	public List<CustomerProduct> getCustomerProducts(@PathVariable(name = "customerId")String customerId)	{
		
		return CustomerProductDAO.getInstance().getProducts(customerId);
	}
	
	@GetMapping(value = "/products")
	public List<CustomerProduct> getProducts()	{
		
		return CustomerProductDAO.getInstance().getProductsGroupByCustomer();
	}

}
