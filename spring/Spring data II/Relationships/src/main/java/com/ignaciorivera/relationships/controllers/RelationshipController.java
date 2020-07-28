package com.ignaciorivera.relationships.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ignaciorivera.relationships.models.License;
import com.ignaciorivera.relationships.models.Person;
import com.ignaciorivera.relationships.services.RelationshipService;


@Controller
public class RelationshipController {



	private final RelationshipService relationshipService;
	    
	    public RelationshipController(RelationshipService relationshipService) {
	        this.relationshipService = relationshipService;
	    }
	    
	   
	    
	    @RequestMapping("/")
	    public String index(Model model, @ModelAttribute("person") Person person) {
	        List<Person> persons = relationshipService.allPerson();
	        model.addAttribute("persons", persons);
	        return "/persons/showperson.jsp";
	    }
	    
	    @RequestMapping("/persons/new")
	    public String newPerson(Model model, @ModelAttribute("person") Person person) {
	        
	        return "/persons/newperson.jsp";
	    }
	    
	    @RequestMapping(value="/persons/new", method=RequestMethod.POST)
	    public String create(@Validated @ModelAttribute("person") Person person, BindingResult result) {
	        if (result.hasErrors()) {
	            return"redirect:/";
	        } else {
	        	relationshipService.createPerson(person);
	           return"redirect:/";
	        }
	    }
	    
	    @RequestMapping("/license/new")
	    public String newLicense(Model model) {
	    	List<Person> persons = relationshipService.allPerson();
	        model.addAttribute("persons", persons);
	        return "/licenses/newlicense.jsp";
	    }
	    
	    @RequestMapping("/license/show")
	    public String showLicense(Model model) {
	    	List<Person> persons = relationshipService.allPerson();
	        model.addAttribute("persons", persons);
	        return "/licenses/showlicenses.jsp";
	    }
	    
	    @RequestMapping(value="/license/add", method=RequestMethod.POST)
	    public String createLicense(@RequestParam("person_id") Long id, @RequestParam("state") String state, 
	    		@RequestParam("expirationDate") String expirationDate, Model model) throws ParseException {
	    	
	    	Person user = relationshipService.findPerson(id);
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(expirationDate);
			License l = new License("", date, state, user);
			
			String idstring = Long.toString(id);
			String number="";
			
			for (int i=0; i<5-(idstring.length());i++) {
				number+="0";
			}
			
			l.setNumber(number+idstring);
			
			relationshipService.createLicense(l);
			

	           return "redirect:/";
	        }
	    
}
