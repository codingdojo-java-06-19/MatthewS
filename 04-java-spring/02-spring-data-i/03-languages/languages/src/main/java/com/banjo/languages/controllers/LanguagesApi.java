package com.banjo.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banjo.languages.models.Language;
import com.banjo.languages.services.LanguageService;

@RestController
public class LanguagesApi {
	private final LanguageService languageService;

	public LanguagesApi(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/api/languages")
	public List<Language> index() {
		return languageService.allLangs();
	}
	
	@RequestMapping(value="/api/languages", method=RequestMethod.POST)
	public Language create(@RequestParam(value="lang") String lang, @RequestParam(value="creator") String creator, @RequestParam(value="vers") Double vers) {
	Language language = new Language(lang, creator, vers);
		return languageService.createLang(language);
	}
	
	@RequestMapping("/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		Language language = languageService.findLang(id);
		return language;
	}
}