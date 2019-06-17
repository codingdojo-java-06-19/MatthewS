package com.banjo.dojoNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banjo.dojoNinjas.models.Dojo;
import com.banjo.dojoNinjas.models.Ninja;
import com.banjo.dojoNinjas.services.DojoServices;

@Controller
public class DojoController {
	private final DojoServices dojoService;
	
	public DojoController(DojoServices dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/")
	public String index (Model model) {
		return "redirect:/new";
	}
	
	@RequestMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "new.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		System.out.println("We made it");
		if (result.hasErrors()) {
			System.out.println("result has errors");
			return "redirect:/";
		} else {
			System.out.println("Success");
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String displayDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjas);
		return "show.jsp";
	}
}
