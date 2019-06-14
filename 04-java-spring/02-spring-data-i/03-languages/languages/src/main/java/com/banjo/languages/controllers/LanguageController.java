package com.banjo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.banjo.languages.models.Language;
import com.banjo.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("")
	public String index(Model model) {
		List<Language> languages = languageService.allLangs();
		model.addAttribute("langs", languages);
		return "langs/index.jsp";
	}
	
	@RequestMapping("/new")
	public String newLang(@ModelAttribute("language") Language language) {
		return "langs/new.jsp";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {		
		if (result.hasErrors()) {
			return "langs/new.jsp";
		} 	
		languageService.createLang(language);
		return "redirect:/languages";
	}
	
    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {    
    model.addAttribute("langs", languageService.findLang(id));
    return "langs/show.jsp";
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/langs/edit.jsp";
        } else {
            languageService.update(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLang(id);
    	model.addAttribute("language", language);
    	return "langs/edit.jsp";
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id, RedirectAttributes redirectattrs) {    	
    	languageService.deleteLang(id);
    	redirectattrs.addFlashAttribute("success", "Successully Deleted!!");
    	return "redirect:/languages";
    }
    
}
