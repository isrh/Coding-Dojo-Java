package com.ignaciorivera.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class HomeController {
	
	@RequestMapping("/")
	public String showForm(HttpSession session, Model model, @RequestParam(value="name", required=false) String name, @RequestParam(value="location", required=false) String location,
			@RequestParam(value="language", required=false) String language, @RequestParam(value="comment", required=false) String comment, @RequestParam(value="action", required=false) String action) {
		
		if(action!=null) {
			
			
			session.setAttribute("name", name);
			session.setAttribute("location", location);
			session.setAttribute("language", language);
			session.setAttribute("comment", comment);
			
			if(language.equals("Java")) {
				
				return "redirect:/java";
			}
			else {
				
				return "redirect:/result";
				
			}
			
		}
		else {
			return "index.jsp";
		}
		
	}
	
	@RequestMapping("/result")
		public String showResult(HttpSession session, @RequestParam(value="action", required=false) String action) {
			
			if(action!=null) {
				return "redirect:/";
			}
			
			else {
				return "result.jsp";
			}
		}
	
	@RequestMapping("/java")
	public String showJava(HttpSession session, @RequestParam(value="action", required=false) String action) {
		
		if(action!=null) {
			return "redirect:/";
		}
		
		else {
			return "java.jsp";
		}
	}
}
	
		

