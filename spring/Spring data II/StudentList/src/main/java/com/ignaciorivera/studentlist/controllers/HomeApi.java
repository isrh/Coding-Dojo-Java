package com.ignaciorivera.studentlist.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ignaciorivera.studentlist.models.Student;
import com.ignaciorivera.studentlist.services.MainService;

@RestController
public class HomeApi {

	
	
private final MainService mainService;
		
	public HomeApi(MainService mainService) {
			this.mainService=mainService;
		
	}
	
	@RequestMapping("/api/students")
	public List<Student> index(){
		return mainService.allStudent();
	}
	
	@RequestMapping(value="/api/students", method=RequestMethod.POST)
    public Student create(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, 
    		@RequestParam(value="age") int age) {
        Student student = new Student(firstName, lastName, age);
        return mainService.createStudent(student);
    }
	
}
