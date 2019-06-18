package com.banjo.overFlow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banjo.overFlow.models.Tag;
import com.banjo.overFlow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepo;
	
	public TagService(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	public List<Tag> getAll(){
		return tagRepo.findAll();
	}
	
	public void saveTag(Tag t) {
		tagRepo.save(t);
	}
	
	public Tag findBySubject(String subject) {
		return tagRepo.findBySubjectEquals(subject);
	}
}
