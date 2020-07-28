package com.ignaciorivera.dojos.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ignaciorivera.dojos.models.Dojo;
import com.ignaciorivera.dojos.models.Ninja;
import com.ignaciorivera.dojos.services.MainService;


@Controller
public class HomeController {

private final MainService mainService;
    
    public HomeController(MainService mainService) {
        this.mainService = mainService;
    }
    
    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("dojo") Dojo dojo) {
        List<Dojo> dojos = mainService.allDojos();
        
        model.addAttribute("dojos", dojos);
        return "/dojos/show.jsp";
    }
    
    @RequestMapping("/dojos/new")
    public String newDojo(Model model, @ModelAttribute("dojo") Dojo dojo) {
        
        return "/dojos/new.jsp";
    }
    
    @RequestMapping(value="/dojos/new", method=RequestMethod.POST)
    public String createDojo(Model model, @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
    	if (result.hasErrors()) {
            return "/dojos/new.jsp";
        } else {
            mainService.createDojo(dojo);
            return "redirect:/";
        }
        
    }
    
    
    @RequestMapping("/ninjas/show")
    public String showNinja(Model model) {
    	List<Ninja> ninjas = mainService.allNinjas();
        model.addAttribute("ninjas", ninjas);
            return "/ninjas/show.jsp";
        
    }
    
    @RequestMapping("/ninjas/new")
    public String newNinja(Model model) {
    	List<Dojo> dojos = mainService.allDojos();
        model.addAttribute("dojos", dojos);
            return "/ninjas/new.jsp";
        
    }
    
    @RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
    public String createNinja(@RequestParam("dojo_id") Long id, @RequestParam("firstName") String firstname, 
    		@RequestParam("lastName") String lastname, @RequestParam("age") int age, Model model) {
    	
    	Dojo dojo = mainService.findDojo(id);
		
		Ninja ninja = new Ninja(firstname,lastname,age,dojo);
		
		dojo.getNinjas().add(ninja);
		
		mainService.createNinja(ninja);
		

           return "redirect:/";
        }
}
