package com.ignaciorivera.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.ignaciorivera.relationships.models.License;
import com.ignaciorivera.relationships.models.Person;
import com.ignaciorivera.relationships.repositories.LicenseRepository;
import com.ignaciorivera.relationships.repositories.PersonRepository;



@Service
public class RelationshipService {

	
private final  PersonRepository personRepository;
private final  LicenseRepository licenseRepository;

	
	public  RelationshipService(PersonRepository  personRepository,LicenseRepository licenseRepository) {
		this.personRepository=personRepository;
		this.licenseRepository=licenseRepository;
		
	}
	
	//Devolviendo todas las canciones
    public List<Person> allPerson() {
        return personRepository.findAll();
    }
    
  //Devolviendo todas las canciones
    public List<License> allLicense() {
        return licenseRepository.findAll();
    }
    
    //Creando una nueva persona
    public Person createPerson(Person p) {
        return personRepository.save(p);
    }
    
  //Creando una nueva licencia
    public License createLicense(License l) {
        return licenseRepository.save(l);
    }
    
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
}
