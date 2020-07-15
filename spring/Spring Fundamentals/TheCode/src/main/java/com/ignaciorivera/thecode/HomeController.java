package com.ignaciorivera.thecode;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class HomeController {
	
	@RequestMapping("/")
	public String showCounter(HttpSession session, Model model, @RequestParam(value="code", required=false) String code, RedirectAttributes redirectAttributes){
		
	
		

		if(code!=null) {
			
			
			
			if(code.equals("bushido")) {
				return "code.jsp";
			}
			else {
				redirectAttributes.addFlashAttribute("error", "You must train harder!");
		        return "redirect:/";
			}
				
			
		}
		
	
		return "index.jsp";
}
	
	
	@RequestMapping("/code")
	public String showCode(HttpSession session, Model model, @RequestParam(value="code", required=false) String code){
		return "code.jsp";
	}
	
	
		
}
