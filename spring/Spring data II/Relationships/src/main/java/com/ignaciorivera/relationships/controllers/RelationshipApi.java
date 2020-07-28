package com.ignaciorivera.relationships.controllers;

import java.util.List;

import org.aspectj.asm.internal.Relationship;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignaciorivera.relationships.models.Person;
import com.ignaciorivera.relationships.services.RelationshipService;


@RestController
public class RelationshipApi {


private final  RelationshipService  relationshipService;
		
	public RelationshipApi( RelationshipService  relationshipService) {
		this.relationshipService=relationshipService;
	}
    
	@RequestMapping("/api/relationships")
	public List<Person> index(){
		return relationshipService.allPerson();
	}
}
