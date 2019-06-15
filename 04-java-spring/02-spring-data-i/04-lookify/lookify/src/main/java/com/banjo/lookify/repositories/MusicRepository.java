package com.banjo.lookify.repositories;

import com.banjo.lookify.models.Music;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends CrudRepository<Music, Long> {
	List<Music> findAll();	
	List<Music> findByArtistContaining(String search);
	List<Music> findAllByOrderByRatingDesc();
}
