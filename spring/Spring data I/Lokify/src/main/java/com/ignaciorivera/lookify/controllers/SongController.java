package com.ignaciorivera.lookify.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ignaciorivera.lookify.models.Song;
import com.ignaciorivera.lookify.services.SongService;


@Controller
public class SongController {

private final SongService songService;
    
    public SongController(SongService songService) {
        this.songService = songService;
    }
    
    @RequestMapping("/")
    public String welcome() {
        
        return "/songs/welcome.jsp";
    }
    
    @RequestMapping("/songs")
    public String index(Model model, @ModelAttribute("song") Song song) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "/songs/index.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newSong(Model model, @ModelAttribute("song") Song song) {
        
        return "/songs/new.jsp";
    }
    
    @RequestMapping(value="/songs/new", method=RequestMethod.POST)
    public String create(@Validated @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return"redirect:/songs";
        } else {
        	songService.createSong(song);
            return "redirect:/songs";
        }
    }
    //Mostrar lenguaje
    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Song song=songService.findSong(id);
    	model.addAttribute("song",song);
        return "/songs/show.jsp";
    }
    
    
    @RequestMapping(value="/songs/search", method=RequestMethod.POST)
    public String artist(@RequestParam("artist") String artist, Model model) {
		List<Song> songs = songService.allSongsByArtist(artist);
        model.addAttribute("songs", songs);
        return "/songs/search.jsp";
    }
    
    @RequestMapping("/songs/topten")
    public String showRating(Model model, @ModelAttribute("song") Song song) {
    	List<Song> songs = songService.allSongs();
    	List<Song> templist= new ArrayList<Song>();
    	List<Song> topten= new ArrayList<Song>();
    	
    	templist=songs;
    	
    	Song temp = new Song();

    	
    	for(int i=0; i<templist.size()-1; i++) {
    		
    		for(int j=0; j<templist.size()-1; j++) {
    			
    			if(templist.get(j).getRating()<templist.get(j+1).getRating()) {
    				temp=templist.get(j);
    				templist.set(j, templist.get(j+1));
    				templist.set(j+1, temp);
    			}
    			
    		}
    	}
    	
    	for(int p=0; p<10;p++) {
    		
    		topten.add(templist.get(p));
    	}
    	
    	model.addAttribute("songs", topten);
        return "/songs/topten.jsp";

    }
    
    @RequestMapping("/songs/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
    	songService.deleteSong(id);
        return "redirect:/songs";
    }

    //Eliminar libro
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	songService.deleteSong(id);
        return "redirect:/songs";
    }
	
}
