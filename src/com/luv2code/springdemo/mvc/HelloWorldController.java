package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

// import com.luv2code.springboot.restclient.Person;

@Controller
public class HelloWorldController {


	HelloWorldService service;

	@Autowired	
	public HelloWorldController(HelloWorldService theService) {
		service = theService;
	}
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {

		return "helloworld-form";
	}

	@RequestMapping("/displayForm")
	public String displayForm() {
		
		return "employee-form";
	}	
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
	
		return "helloworld";
	}

	@RequestMapping("/processEmployeeForm")
	public String processEmployeeForm(HttpServletRequest request, Model model) {
		
		String clientName = request.getParameter("clientName");
		String clientPasswd = request.getParameter("clientPassword");		


		Cliente cliente = service.displayForm(clientName,clientPasswd);
		model.addAttribute("employeeName", cliente.getNombreCompleto() );		
		model.addAttribute("employeeLastName", cliente.getNumeroDocumento() );
		System.out.println("Person >>" + cliente );
		
		return "displayemployee";
	}
	
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

	  // read the request parameter from the HTML form
	  String theName = request.getParameter("studentName");
	  
	  // convert the data to all caps
	  theName = theName.toUpperCase() ;

	  // create the message
	  String result = "Yo! " + theName ;

	  // add message to the model
	  model.addAttribute("message", result);
	  
	  return "helloworld";
	}
}
