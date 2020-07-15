package com.ignaciorivera.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ignaciorivera.lookify.models.Song;
import com.ignaciorivera.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final  SongRepository songRepository;
	
	public  SongService(SongRepository  songRepository) {
		this.songRepository=songRepository;
	}
	
	 //Devolviendo todas las canciones
    public List<Song> allSongs() {
        return songRepository.findAll();
    }
    
    public List<Song> allSongsByArtist(String artist) {
        return songRepository.findByArtistContaining(artist);
    }
    //Creando una canción
    public Song createSong(Song s) {
        return songRepository.save(s);
    }
    //Obteniendo la información de alguna canción por su id
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    
    
  //Actualizando una canción
    public Song updateSong(Long id, String title, String artist, int rating) {
    	
    	 Optional<Song> optionalSong = songRepository.findById(id);
    	 if(optionalSong.isPresent()) {
    		 Song song= optionalSong.get();
    		 song.setTitle(title);
    		 song.setArtist(artist);
    		 song.setRating(rating);

            return songRepository.save(song);
            
         }
    	 else {
    		 return null;
    	 }
    }
    
  //Borrar un libro
    public void deleteSong(Long id) {
    	songRepository.deleteById(id);
    }
}
