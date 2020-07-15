package com.ignaciorivera.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")

public class HomeController {

	
	@RequestMapping("/")
	public String textDojo() {
		return "¡Hola Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String textPython() {
		return "¡Python/Django fue increíble!.";
	}
	
	@RequestMapping("/java")
	public String textJava() {
		return "¡Java/Spring es mejor!";
	}
}
