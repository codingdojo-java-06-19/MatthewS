package com.banjo.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DojoController {
	@RequestMapping("/{dojo}")
	public String showDojo(@PathVariable("dojo") String dojo){	
		if (dojo.equals("dojo")) {
			return "coding dojo rocks!";
		} else if (dojo.equals("dojo-burbank")) {
			return "burbank is in socal!";
		} else if (dojo.equals("san-jose")) {
			return "San Jo is the HQ";
		}

		return "whatchu talkin bout willis?";

	}
}