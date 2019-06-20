package com.banjo.overFlow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banjo.overFlow.models.Answer;
import com.banjo.overFlow.models.Question;
import com.banjo.overFlow.models.Tag;
import com.banjo.overFlow.services.AnswerService;
import com.banjo.overFlow.services.QuestionService;
import com.banjo.overFlow.services.TagService;


@Controller
@RequestMapping("/questions")
public class QuestionController {
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	
	public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
		this.questionService = questionService;
		this.tagService = tagService;
		this.answerService = answerService;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Question> allQ = questionService.allQuestions();		
		model.addAttribute("allQ", allQ);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/new")
	public String newQ(@ModelAttribute("newQuestion") Question question) {
		return "newQ.jsp";
	}
	
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addNewQ(@ModelAttribute("newQuestion") Question q, @RequestParam("subjects") String tags) {		
		String[] tagArr = tags.split(", ");
		int tagCount = tagArr.length > 3 ? 3 : tagArr.length; 
		
		List<Tag> qTags = new ArrayList<>();
		for (int i = 0; i < tagCount; i++) {
			Tag tag = tagService.findOrCreate(tagArr[i]);
			tagService.addUniqueTag(qTags, tag);
		}
		
		q.setTags(qTags);
		questionService.createOrUpdate(q);
		return "redirect:/questions/dashboard";
		
		
}
	
	@RequestMapping("/{id}")
	public String getQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("newAnswer") Answer answer) {
		Question q = questionService.findQuestion(id);
		model.addAttribute("q", q);
		return "showQ.jsp";
	}
	
	@RequestMapping(value="/addanswer/{id}", method=RequestMethod.POST)
	public String newAnswer(@Valid @ModelAttribute("newAnswer") Answer answer, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			System.out.println("Error!!!!!");
			return "redirect:/questions/" + id;
		}
		// Save to Answer to DB
		answerService.saveAnswer(answer);
		return "redirect:/questions/" + id;
	}
	
}