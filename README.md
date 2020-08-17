
# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/#build-image)


Acme Service provides the Customers with Domain Registration, Hosting and Email Services
-----------------------------------------------------------------------------------------

The application currently supports the following services
------------------------------------------------

Add a Domain  --- POST http://localhost:8080/acme/product/{product}/customer/{customerId}
------------


    Sample Request 
    http://localhost:8080/acme/product/domain/customer/Cust123
    {
        "duration": 1,
        "domainName" : "xyz.com"
    }

Add a Hosting --- POST http://localhost:8080/acme/product/{product}/customer/{customerId}
-------------

    
    Sample Request 
    http://localhost:8080/acme/product/hosting/customer/Cust123
    {
        "duration": 12,
        "domainName" : "xyz.com"
    }

List All Registered Products in the system --- GET http://localhost:8080/acme/products
-------------------------------------------

    Sample Request http://localhost:8080/acme/products


List Registered Products by Customer --- GET http://localhost:8080/acme/customer/{customerId}/products
------------------------------------


    Sample Request http://localhost:8080/acme/customer/Cust234/products

The currently the below list of Customers exists in the System.
--------------------------------------------------------------
    Cust123
    Cust234
    Cust345
    Cust456

The List of Products 
----------------------
    domain
    hosting
    email
    edomain
    pdomain


