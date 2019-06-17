package com.banjo.driversLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banjo.driversLicense.models.License;
import com.banjo.driversLicense.models.Person;
import com.banjo.driversLicense.services.LicenseService;
import com.banjo.driversLicense.services.PersonService;
@Controller
@RequestMapping("/license")
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/new")
	public String newLicense(@ModelAttribute("license") License license, @ModelAttribute("person") Person person, Model model) {
		List<Person> persons = personService.unlicensed();
		model.addAttribute("persons", persons);
		return "persons/license.jsp";
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		System.out.println("We made it");
		if (result.hasErrors()) {
			System.out.println("result has errors");
			return "persons/license.jsp";
		} else {
			System.out.println("Success");
			licenseService.createLicense(license);
			return "redirect:/persons/" + license.getPerson().getId();
		}
		
	}
}
