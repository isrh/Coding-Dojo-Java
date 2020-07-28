package com.ignaciorivera.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ignaciorivera.dojos.models.Dojo;
import com.ignaciorivera.dojos.models.Ninja;
import com.ignaciorivera.dojos.repositories.DojoRepository;
import com.ignaciorivera.dojos.repositories.NinjaRepository;





@Service
public class MainService {

	
private final  NinjaRepository ninjaRepository;
private final  DojoRepository dojoRepository;

	
	public MainService(NinjaRepository ninjaRepository,DojoRepository dojoRepository) {
		this.ninjaRepository=ninjaRepository;
		this.dojoRepository=dojoRepository;
		
	}
	
	//Devolviendo todas las canciones
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    
  //Devolviendo todos los estudiantes
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    
  //Creando un nuevo estudiante
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
    
  //Creando un nuevo contacto
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
    
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    

}


