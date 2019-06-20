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
	
	public Tag findOrCreate(String subject) {
		Tag newTag = findBySubject(subject.toLowerCase().trim());
		if (newTag == null) {
			newTag = new Tag();
			newTag.setSubject(subject);
			saveTag(newTag);
		}
		return newTag;
	}
	
	public void addUniqueTag(List<Tag> tags, Tag tagToAdd) {
		for (Tag tag : tags) {
			if (tag.getSubject().equals(tagToAdd.getSubject())) {
				return;
			} 
		}
		tags.add(tagToAdd);
	}
}