package com.banjo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banjo.lookify.models.Music;
import com.banjo.lookify.repositories.MusicRepository;

@Service
public class MusicService {
	private final MusicRepository musicRepository;
	
	public MusicService(MusicRepository musicRepository){
		this.musicRepository = musicRepository;
	}
	
	// Return all music
	public List<Music> allMusic(){
		return musicRepository.findAll();
	}
	
    // Return Top 10
    public List<Music> topTen() {
    	return musicRepository.findAllByOrderByRatingDesc();
    	
    }
    
    // Search by Artist
    public List<Music> findArtist(String search){
    	return musicRepository.findByArtistContaining(search);
    }
	
    public Music createMusic(Music m) {
        return musicRepository.save(m);
    }
    
    public Music findMusic(Long id) {
        Optional<Music> optionalBook = musicRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    

}
