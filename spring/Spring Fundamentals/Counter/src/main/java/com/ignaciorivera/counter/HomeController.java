package com.ignaciorivera.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller


public class HomeController {
	
	
	@RequestMapping("/one")
	public String sumOne(HttpSession session){
		
		String contador = (String) session.getAttribute("count");
		Integer numero;
		
		if(contador==null) {
			session.setAttribute("count", "1");
			
		}
		else {
			numero = Integer.parseInt(contador);
        	numero++;
        	contador = numero.toString();
        	session.setAttribute("count", contador);
        	
		}
		
			
		
		return "index.jsp";
		
	}
	@RequestMapping("/counter")
	public String showCounter(HttpSession session, Model model, @RequestParam(value="views", required=false) String views){
		
		String contador = (String) session.getAttribute("count"); 
		Integer numero;
		
		System.out.println(views);
		
		if(views!=null) {
			session.setAttribute("count", "0");
			return "counter.jsp";
		}
		
		else {
			
			if(contador==null) {
	        	session.setAttribute("count", "0");
	        	return "counter.jsp";
	        }
	        else {
				numero = Integer.parseInt(contador);
	        	contador = numero.toString();
	        	session.setAttribute("count", contador);
	        	return "counter.jsp";
	        	
			}
		}
			
			

        
		
		
	}
	
	@RequestMapping("/double")
	public String sumTwo(HttpSession session){
		
		String contador = (String) session.getAttribute("count");
		Integer numero;
		
        if(contador==null) {
        	session.setAttribute("count", "2");
        }
        else {
			numero = Integer.parseInt(contador);
			numero+=2;
        	contador = numero.toString();
        	session.setAttribute("count", contador);
        	
		}
        
		return "double.jsp";
		
	}

}
