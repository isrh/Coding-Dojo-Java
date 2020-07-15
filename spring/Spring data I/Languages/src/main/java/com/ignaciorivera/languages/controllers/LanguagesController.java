package com.ignaciorivera.languages.controllers;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ignaciorivera.languages.models.Language;
import com.ignaciorivera.languages.services.LanguageService;


@Controller
public class LanguagesController {
	private final LanguageService languageService;
    
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }

    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Validated @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return"redirect:/languages";
        } else {
           languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    //Mostrar lenguaje
    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Language language=languageService.findLanguage(id);
    	model.addAttribute("language",language);
        return "/languages/show.jsp";
    }
    
    
    //Editar libro
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Validated @ModelAttribute("language") Language language, BindingResult result) {
    	

        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            languageService.updateLanguage(language.getId(), language.getName(), language.getCreator(), 
            		language.getCurrentVersion());
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/languages/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }

    //Eliminar libro
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
