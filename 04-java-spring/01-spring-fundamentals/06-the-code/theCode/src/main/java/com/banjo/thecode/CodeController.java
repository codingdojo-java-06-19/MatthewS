package com.banjo.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/entry", method=RequestMethod.POST)
	public String flashMessages(@RequestParam(value="pw") String pw, RedirectAttributes redirectAttributes) {
		if (pw.equals("bushido")) {
			return "redirect:/granted";
		} else {
		}
		redirectAttributes.addFlashAttribute("error", "Try again, grasshopper!");
		return "redirect:/";
	}
	
	@RequestMapping("/granted")
	public String secret() {
		return "code.jsp";
	}
}
