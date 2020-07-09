package com.ignaciorivera.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	
	
	@RequestMapping("/")
	public String index(@RequestParam(value="firstname", required=false) String firstname,  @RequestParam (value="lastname", required=false) String lastname) {
		
		if(firstname==null && lastname==null) {
			return "<h1>HELLO HUMAN</h1> <br> <p> Welcome to Spring Boot</p>";
		}
		else{
			return "<h1>HELLO "+firstname+" " +lastname+"</h1> <br> <p> Welcome to Spring Boot</p>\"";
		}
		
	}	

}
