package com.ignaciorivera.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ignaciorivera.dojooverflow.models.Answer;
import com.ignaciorivera.dojooverflow.models.Question;
import com.ignaciorivera.dojooverflow.models.Tag;
import com.ignaciorivera.dojooverflow.services.MainService;




@Controller
public class HomeController {

private final MainService mainService;
    
    public HomeController(MainService mainService) {
        this.mainService = mainService;
    }
    
    @RequestMapping("/questions")
    public String viewDashboard(Model model, @ModelAttribute("question") Question question) {
    	 List<Question> questions = mainService.allQuestions();
         model.addAttribute("questions", questions);
            return "/questions/show.jsp";
        
    }
    
    @RequestMapping("/questions/new")
    public String newQuestion(Model model, @ModelAttribute("question") Question question, @ModelAttribute("tag") Tag tag) {
    	return "/questions/new.jsp";
        
    }
    
    @RequestMapping(value="/questions/new", method=RequestMethod.POST)
    public String createQuestion(@RequestParam("question") String pregunta, @RequestParam("tag") String etiqueta, RedirectAttributes errors) {
    	
    	List<Tag> etiquetas = new ArrayList<Tag>();
    	List<Answer> respuestas = new ArrayList<Answer>();
    	List<Tag> oldTags = mainService.allTags();
    	
    	etiqueta = etiqueta.toLowerCase();
		etiqueta = etiqueta.replace(" ","");
		String[] newtags =  etiqueta.split(",");
    	
		if (newtags.length>3) {
			errors.addFlashAttribute("errors", "Solo se pueden maximo 3 Etiquetas");
			return "redirect:/questions/new";
		}
		else {
			boolean nuevo;
			
			for (int i = 0; i < newtags.length;i++) {
				nuevo = true;
				int save = 0;
				for (int e = 0; e < oldTags.size();e++) {
					if(oldTags.get(e).getSubject().equals(newtags[i])) {
						nuevo = false;
						save = e;
					}
				}
				if(nuevo) {
					List<Question> quest = new ArrayList<Question>();
					Tag ready = new Tag(newtags[i], quest);
					mainService.createTag(ready);
					etiquetas.add(ready);
					
				} else {
					Tag vieja = mainService.findTag(oldTags.get(save).getId());
					etiquetas.add(vieja);
					
				}
		}
		}
		Question user = new Question(pregunta, respuestas, etiquetas);
		mainService.createQuestion(user);
		
    	return "redirect:/questions/";
    	
        
    }
    
  //Mostrar pregunta por id
    @RequestMapping("/questions/{id}")
    public String showIdQuestion(@PathVariable("id") Long id, Model model) {
    	
    	
    	Question question=mainService.findQuestion(id);
    	model.addAttribute("question",question);
    	
    	List<Tag> tags = question.getTags();
    	model.addAttribute("tags",tags);
    	List<Answer> question_answers = question.getAnswers();
    	model.addAttribute("question_answers", question_answers);
        return "/questions/idshow.jsp";
        
    }
    
  //Mostrar pregunta por id
    @RequestMapping(value="/questions/{id}", method=RequestMethod.POST)
    public String showRoom(@PathVariable("id") Long id,@RequestParam("answer") String answer, Model model) {
    	
    	Question question=mainService.findQuestion(id);
    	
		Answer respuesta = new Answer(answer, question);
		mainService.createAnswer(respuesta);
        return "redirect:/questions/"+id;
        
    }
    
}
