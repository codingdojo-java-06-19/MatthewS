package com.banjo.dojoNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banjo.dojoNinjas.models.Dojo;
import com.banjo.dojoNinjas.models.Ninja;
import com.banjo.dojoNinjas.services.DojoServices;
import com.banjo.dojoNinjas.services.NinjaServices;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	private final NinjaServices ninjaService;
	private final DojoServices dojoService;
	
	public NinjaController(NinjaServices ninjaService, DojoServices dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, @ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "addNinja.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		System.out.println("We made it");
		if (result.hasErrors()) {
			System.out.println("result has errors");
			return "redirect:/";
		} else {
			System.out.println("Success");
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
	
	
}
