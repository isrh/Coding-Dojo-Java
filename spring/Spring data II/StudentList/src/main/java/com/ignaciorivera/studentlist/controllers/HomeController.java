package com.ignaciorivera.studentlist.controllers;

import java.text.ParseException;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ignaciorivera.studentlist.models.Contact;
import com.ignaciorivera.studentlist.models.Room;
import com.ignaciorivera.studentlist.models.Student;
import com.ignaciorivera.studentlist.models.Subject;
import com.ignaciorivera.studentlist.services.MainService;

@Controller
public class HomeController {

	
	private final MainService mainService;
    
    public HomeController(MainService mainService) {
        this.mainService = mainService;
    }
    
    @RequestMapping("/")
    public String mainMenu() {
    	
            return "/main/index.jsp";
        
    }
    
    @RequestMapping("/students/show")
    public String index(Model model, @ModelAttribute("student") Student student) {
        List<Student> students = mainService.allStudent();
        model.addAttribute("students", students);
        return "/students/show.jsp";
    }
    
    @RequestMapping("/students/new")
    public String createStudent(Model model, @ModelAttribute("student") Student student) {
    	
            return "/students/new.jsp";
        
    }
    
    @RequestMapping(value="/students/new", method=RequestMethod.POST)
    public String showStudent(Model model, @ModelAttribute("student") Student student, BindingResult result) {
    	if (result.hasErrors()) {
            return "/students/new.jsp";
        } else {
            mainService.createStudent(student);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/contacts/new")
    public String createContact(Model model) {
    	List<Student> students = mainService.allStudent();
        model.addAttribute("students", students);
            return "/contacts/new.jsp";
        
    }
    
    @RequestMapping("/subjects/show")
    public String createSubject(Model model) {
    	List<Subject> subjects = mainService.allSubjects();
        model.addAttribute("subjects", subjects);
            return "/subjects/show.jsp";
        
    }
    
    @RequestMapping(value="/contacts/new", method=RequestMethod.POST)
    public String createContact(@RequestParam("student_id") Long id, @RequestParam("address") String address, 
    		@RequestParam("city") String city, @RequestParam("state") String state, Model model) throws ParseException {
    	
    	Student student = mainService.findStudent(id);
		
		Contact contact = new Contact(address,city,state,student);
		
		mainService.createContact(contact);
		

           return "redirect:/";
        }
    
    @RequestMapping("/contacts/show")
    public String showContact(Model model) {
    	List<Student> students = mainService.allStudent();
        model.addAttribute("students", students);
            return "/contacts/show.jsp";
        
    }
    
    //Mostrar formulario para ingresar nueva materia
    @RequestMapping("/subjects/new")
    public String newSubject(Model model, @ModelAttribute("subject") Subject subject) {
    	
            return "/subjects/new.jsp";
        
    }
    
    //Crear e ingresar nueva clase creada
    @RequestMapping(value="/subjects/new", method=RequestMethod.POST)
    public String createSubject(Model model, @ModelAttribute("subject") Subject subject, BindingResult result) {
    	if (result.hasErrors()) {
            return "/subjects/new.jsp";
        } else {
            mainService.createSubject(subject);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/rooms/new")
    public String newRoom(Model model, @ModelAttribute("room") Room room) {
    	
            return "/rooms/new.jsp";
        
    }
    
    @RequestMapping(value="/rooms/new", method=RequestMethod.POST)
    public String createRoom(Model model, @ModelAttribute("room") Room room, BindingResult result) {
    	if (result.hasErrors()) {
            return "/rooms/new.jsp";
        } else {
            mainService.createRoom(room);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/rooms/show")
    public String showRooms(Model model) {
    	
    	List<Room> rooms = mainService.allRooms();
        model.addAttribute("rooms", rooms);
            return "/rooms/show.jsp";
        
    }
    
  //Mostrar pieza por id
    @RequestMapping("/rooms/{id}")
    public String showRoom(@PathVariable("id") Long id, Model model) {
    	
    	List<Student> totalstudents = mainService.allStudent();
        model.addAttribute("totalstudents", totalstudents);
    	Room room=mainService.findRoom(id);
    	model.addAttribute("room",room);
    	
    	List<Student> estudiantes = room.getStudents();
    	
    	System.out.println(""+room.getStudents().size());
    	model.addAttribute("estudiantes", estudiantes);
        return "/rooms/idshow.jsp";
        
    }
    
    @RequestMapping(value="/rooms/{id}", method=RequestMethod.POST)
    public String addStudentToRoom(@PathVariable("id") Long idroom, @RequestParam("student_id") Long idstudent,  Model model) {
    	
    	Room room = mainService.findRoom(idroom);
    	Student student = mainService.findStudent(idstudent);
		
		student.setRoom(room);
		
		mainService.updateStudent(student);

		return "redirect:/rooms/"+idroom;
    }
    
  //Mostrar estudiantes por id
    @RequestMapping("/students/{id}")
    public String showStudent(@PathVariable("id") Long id, Model model) {
    	
    	
    	Student student=mainService.findStudent(id);
    	model.addAttribute("student",student);
    	
    	List<Subject> totalsubjects = mainService.allSubjects();
        model.addAttribute("subjects", totalsubjects);
    	
        List<Subject> studentSubjects= student.getSubjects();
        model.addAttribute("studentsubjects", studentSubjects);
        
        return "/students/idshow.jsp";
        
    }
    
  //Agregar materia al estudiante
    @RequestMapping(value="/students/{id}", method=RequestMethod.POST)
    public String showStudent(@PathVariable("id") Long idstudent, @RequestParam("subject_id") Long idsubject,  Model model) {
    	
    	
    	Student student=mainService.findStudent(idstudent);
    	Subject subject=mainService.findSubject(idsubject);
    	
    	student.getSubjects().add(subject);
    	mainService.updateStudent(student);
    	

        return "redirect:/students/"+idstudent;
        
    }
    //Borrar materia de un estudiante
    @RequestMapping("/students/deletesubject/{student_id}/{subject_id}")
    public String deleteStudenSubject( @PathVariable("student_id") Long idstudent, @PathVariable("subject_id") Long idsubject,  Model model) {
    	
    	Student student=mainService.findStudent(idstudent);
    	Subject subject=mainService.findSubject(idsubject);

    	System.out.println(student.getSubjects().size());
    	student.getSubjects().remove(subject);
    	mainService.updateStudent(student);
    	
        return "redirect:/students/"+idstudent;
        
    }
    
  //Mostrar estudiantes por id
    @RequestMapping("/subjects/{id}")
    public String showSubject(@PathVariable("id") Long id, Model model) {
    	
    	
    	Subject subject=mainService.findSubject(id);
    	model.addAttribute("subject",subject);
    	
    	
    	
        List<Student> subjectStudents= subject.getStudents();
        model.addAttribute("subjectStudents", subjectStudents);
        
        return "/subjects/idshow.jsp";
        
    }
}
