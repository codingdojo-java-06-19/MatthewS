package com.banjo.driversLicense.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banjo.driversLicense.models.Person;
import com.banjo.driversLicense.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {	
	private final PersonService personService;
	
	
	public PersonController(PersonService personService) {
		this.personService = personService;

	}
	
	@RequestMapping("")
	public String index() {
		return "redirect:/persons/new";
	}
	
	@RequestMapping("/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "persons/new.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "persons/new.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/license/new";
		}
		
	}
	
	 @RequestMapping("/{id}")
	    public String show(@PathVariable("id") Long id, Model model) {
	    	Person person = personService.findPerson(id);
	    	if(person==null) {
	    		return "redirect:/persons/new";
	    	}
	    	else {
		    	model.addAttribute("person", person);
		    	return "persons/show.jsp";
	    	}
	    }


}
