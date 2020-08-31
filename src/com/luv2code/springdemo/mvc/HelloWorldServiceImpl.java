package com.luv2code.springdemo.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	//@Autowired
	public RestTemplate restTemplate;
	
	public HelloWorldServiceImpl() {
		this.restTemplate = new RestTemplate(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		// converter.setObjectMapper(new ObjectMapper());
		converter.setObjectMapper(new ObjectMapper());
		restTemplate.getMessageConverters().add(converter);		
	}
	
	@Override
	public Cliente displayForm(String usuario, String password) {
		//Long id = 2L ;
		Cliente cliente = null ;
		ResponseEntity<Cliente> response = null ; // Employee
		final String ROOT_URI = "http://localhost:8787/api/clientes"  ;
		String cadJson ;
		
		try {
	       System.out.println("displayForm: Antes de restTemplate.getForEntity");			
			
		   response = restTemplate.getForEntity(ROOT_URI + "/" + usuario + "/" + password , Cliente.class); // Employee.class 
		   
           System.out.println("displayForm: Status >>" + response.getStatusCodeValue()  + "<<");
		   
           cliente = response.getBody();
           // cadJson = response.getBody() ;
           System.out.println("displayForm: Status >>\n" + cliente  + "\n<<");
           
		}
		catch (Exception exc) {
		   exc.printStackTrace();	
		}
		
		
		return cliente;
	}

}
