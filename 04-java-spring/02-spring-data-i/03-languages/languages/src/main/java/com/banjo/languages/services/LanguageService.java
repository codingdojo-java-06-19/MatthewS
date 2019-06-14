package com.banjo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banjo.languages.models.Language;
import com.banjo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	// returns all languages
	public List<Language> allLangs(){
		return languageRepository.findAll();
	}
	
	//creates a language
	public Language createLang(Language l) {
		return languageRepository.save(l);
	}
	
	//retrieves a language
	public Language findLang(Long id) {
		Optional<Language> optionalLang = languageRepository.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	//updates a language
    public Language update(Long id, String lang, String creator, Double vers) {
    	Language language = findLang(id);
    	language.setLang(lang);
    	language.setCreator(creator);
    	language.setVers(vers);
    	return update(language);
    }
    
    public Language update(Language language) {
    	return languageRepository.save(language);
    }
    
    // deletes a language
    public void deleteLang(Long id) {
    	Language language = findLang(id);
    	languageRepository.delete(language);    	
    }
	
}
