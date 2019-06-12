package com.banjo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count")== null) {
			session.setAttribute("count", 0);
		} else {
			int counter = (int)session.getAttribute("count");
			counter++;
			session.setAttribute("count", counter);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String count(HttpSession session, Model model) {
		Integer current = (Integer)session.getAttribute("count");		
		if (current == null) {
			model.addAttribute("current", "0");
		} else {
		model.addAttribute("current", current);
		}
		return "counter.jsp";
	}
	
	@RequestMapping("/gocrazy")
	public String crazy(HttpSession session, Model model) {

		if (session.getAttribute("count")== null) {
			session.setAttribute("count", 0);
		} else {
			int counter = (int)session.getAttribute("count");
			counter += 2;
			session.setAttribute("count", counter);
		}
		Integer current = (Integer)session.getAttribute("count");
		model.addAttribute("current", current);
		return "crazy.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "index.jsp";
	}
}
