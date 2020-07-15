package com.ignaciorivera.firstproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

//Todas las rutas de mapping se antepondran de /hello
@RequestMapping("/hello")
public class HomeController {
	
	@RequestMapping("/message")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping("/world")
	public String text() {
		return "Class level annotations are cool too!";
	}
	
	@RequestMapping("/value/")
	public String index(@RequestParam(value="q", required=false) String searchQuery) {
		
		if(searchQuery==null) {
			return "You searched for nothing ";
		}
		else {
			return "You searched for: "+searchQuery;
		}
		
	}
	
	@RequestMapping("m/{track}/{lesson}")
	public String showLesson(@PathVariable("track") String track,@PathVariable("lesson") String lesson) {
		
		return "Track: "+track+" lesson: "+lesson;
		
	}
	
	

}
