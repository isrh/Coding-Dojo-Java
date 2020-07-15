package com.ignaciorivera.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ignaciorivera.lookify.models.Song;
import com.ignaciorivera.lookify.services.SongService;


@RestController
public class SongApi {

private final SongService songService;
	
	public SongApi(SongService songService) {
		this.songService=songService;
	}
	
	@RequestMapping("/api/songs")
	public List<Song> index(){
		return songService.allSongs();
	}
	
	@RequestMapping(value="/api/songs", method=RequestMethod.POST)
    public Song create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist,
    		@RequestParam(value="rating") int rating) {
		Song song = new Song(title, artist, rating);
        return songService.createSong(song);
    }
    
    @RequestMapping("/api/songs/{id}")
    public Song show(@PathVariable("id") Long id) {
    	Song song = songService.findSong(id);
        return song;
    }
    

    @RequestMapping(value="/api/song/{id}", method=RequestMethod.PUT)
    public Song update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="artist") String artist,
    		@RequestParam(value="ratingn") int rating){ 

    	Song song = songService.updateSong(id, title, artist, rating);
        return song;
    }
    
    @RequestMapping(value="/api/song/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	songService.deleteSong(id);
    }
}
