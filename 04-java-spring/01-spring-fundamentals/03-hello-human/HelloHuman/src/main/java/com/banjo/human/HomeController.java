package com.banjo.human;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String hello(@RequestParam(value="name", required=false) String firstName) {
		if(firstName == null) {
			return "Hello Human!" + "<br><br>Welcome to Springboot";
		} else {
			return "Hello " + firstName + "<br><br>Welcome to Springboot";
		}
	}
}
