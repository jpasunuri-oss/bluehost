package com.bluehost.test.jag.acme;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluehost.test.jag.acme.service.ProductService;

@Service
public class BeanFactoryDynamicAutowireService {
    private final BeanFactory beanFactory;
 
    @Autowired
    public BeanFactoryDynamicAutowireService(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
 
    public ProductService getService(String product) {
        ProductService service = beanFactory.getBean(product, ProductService.class);
 
        return service;
    }
}
