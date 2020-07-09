package com.ignaciorivera.firstproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class DojoController {

	@RequestMapping("/{track}")
	public String showLesson(@PathVariable("track") String track) {
		
		
		if(track.equals("dojo")) {
			return "¡El Dojo es increíble!";
		}
		else if(track.equals("burbank-dojo")){
			return "El Dojo Burbank está localizado al sur de California";
			
		}
		
		else if(track.equals("san-jose")) {
			return "El Dojo SJ es el cuartel general";
		}
		
		else {
			return null;
		}
		

	}
}
