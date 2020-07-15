package com.ignaciorivera.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ignaciorivera.languages.models.Language;
import com.ignaciorivera.languages.repositories.LanguageRepository;



@Service
public class LanguageService {

	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository=languageRepository;
	}
	
	 //Devolviendo todos los lenguages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    //Creando un lenguaje
    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    //Obteniendo la información de un lenguaje
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    
  //Actualizando un libro
    public Language updateLanguage(Long id, String name, String creator, String currentversion) {
    	
    	 Optional<Language> optionalLanguage = languageRepository.findById(id);
    	 if(optionalLanguage.isPresent()) {
    		 Language language= optionalLanguage.get();
    		 language.setName(name);
    		 language.setCreator(creator);
    		 language.setCurrentVersion(currentversion);

            
            
            return languageRepository.save(language);
            
         }
    	 else {
    		 return null;
    	 }
    }
    
  //Borrar un libro
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
}
