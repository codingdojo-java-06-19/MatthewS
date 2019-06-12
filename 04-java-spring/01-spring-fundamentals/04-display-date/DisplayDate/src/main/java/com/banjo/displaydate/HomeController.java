package com.banjo.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import java.text.SimpleDateFormat;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("dojoName", "SF");
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String showDate(Model model) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("E, 'the' d 'of' MMMM, yyyy");
		String myDate = format.format(date);		
		model.addAttribute("date", myDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String showTime(Model model) {
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("h:mm a");
		String myTime = format.format(time);
		model.addAttribute("time", myTime);
		return "time.jsp";
	}
}
