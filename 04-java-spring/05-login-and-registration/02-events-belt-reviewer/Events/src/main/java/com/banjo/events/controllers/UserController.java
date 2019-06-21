package com.banjo.events.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banjo.events.models.Event;
import com.banjo.events.models.Message;
import com.banjo.events.models.User;
import com.banjo.events.services.EventService;
import com.banjo.events.services.MessageService;
import com.banjo.events.services.UserService;
import com.banjo.events.validator.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final EventService eventService;
	private final MessageService messageService;
	
	public UserController(UserService userService, UserValidator userValidator, EventService eventService, MessageService messageService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.eventService = eventService;
		this.messageService = messageService;
	}
		
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "registrationPage.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("user_id", u.getId());
        	return "redirect:/home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if (userService.authenticateUser(email, password)) {
    		User user = userService.findByEmail(email);
    		session.setAttribute("user_id", user.getId());
    		return "redirect:/home";
    	} else {
    		model.addAttribute("error", "Something went wrong, Try Again");
    		return "redirect:/login";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model, @ModelAttribute("newEvent") Event event) {
        // get user from session, save them in the model and return the home page
    	if(session.getAttribute("user_id")==null) {
    		model.addAttribute("error", "You took a wrong turn, please register");
    		return "redirect:/login";
    	} else {
    		Long userId = (long)session.getAttribute("user_id");
    		User user = userService.findUserById(userId);
    		model.addAttribute("userState", this.eventService.allEventsInState(user.getState()));
    		model.addAttribute("userOtherState", this.eventService.allEventsNotState(user.getState()));
    		model.addAttribute("user", user);
    		return "dashboard.jsp";
    	}
    }
    
    @RequestMapping(value="/createEvent", method=RequestMethod.POST)
    public String createEvent(@Valid @ModelAttribute("newEvent") Event event, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Error!!!!!");
			return "redirect:/home";
		}
		//Save Event to DB
			eventService.saveEvent(event);
    	return "redirect:/home";
    }
    
    @RequestMapping("/{id}")
    public String showEvent(@ModelAttribute("newMessage") Message message, @PathVariable("id") Long id, Model model, HttpSession session) {
    	Event e = eventService.findEventById(id);
    	model.addAttribute("eventDetails", e);
    	model.addAttribute("user_id", session.getAttribute("user_id"));
    	return "showEvent.jsp";
    }
    
    @RequestMapping(value="/addComment/{id}", method=RequestMethod.POST)
    public String addComment(@Valid @ModelAttribute("newMessage") Message message, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			System.out.println("Error!!!!!");
			return "redirect:/ " + id;
		}
		//Save Message to DB
			messageService.saveMsg(message);
    	return "redirect:/ " + id;
    }
    
    @RequestMapping("/join/{id}")
    public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
    	Event event = eventService.findEventById(id);
    	Long userid = (Long) session.getAttribute("user_id");
    	User user = userService.findUserById(userid);    
    	eventService.joinEvent(event, user);
    	eventService.saveEvent(event);
    	return "redirect:/home";
    }
    
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user_id");
    	return "redirect:/login";
    }
}
