package com.banjo.overFlow.controllers;

import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.banjo.overFlow.models.Question;
import com.banjo.overFlow.models.Tag;
import com.banjo.overFlow.services.QuestionService;
import com.banjo.overFlow.services.TagService;


@Controller
@RequestMapping("/questions")
public class QuestionController {
	private final QuestionService questionService;
	private final TagService tagService;
	
	public QuestionController(QuestionService questionService, TagService tagService) {
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Question> allQ = questionService.allQuestions();
		
		model.addAttribute("allQ", allQ);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/new")
	public String newQ(@ModelAttribute("question") Question question) {
		return "newQ.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addNewQ(@RequestParam("question") String q, @RequestParam("tags") String tags) {
		Question newQuestion = new Question();
		Tag newTags = new Tag();
		newQuestion.setQuestion(q);
		
		String[] tagArr = tags.split(", ");
		if (tagArr.length > 3) {
			return "redirect:/questions/new";
		}
		
		List<Tag> qTags = new ArrayList<>();
		for (int i = 0; i < tagArr.length; i++) {
			if(tagService.findBySubject(tagArr[i]) == null) {
				newTags.setSubject(tagArr[i]);
				tagService.saveTag(newTags);
				qTags.add(newTags);				
			} else {
				Tag tag2 = new Tag();
				tag2.setSubject(tagArr[i]);
				qTags.add(tag2);
			}
		}
		newQuestion.setTags(qTags);
		questionService.createOrUpdate(newQuestion);
		return "redirect:/dashboard";
		
		
	}
}
