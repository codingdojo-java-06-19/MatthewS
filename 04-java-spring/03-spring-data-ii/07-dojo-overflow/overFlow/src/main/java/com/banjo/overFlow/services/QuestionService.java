package com.banjo.overFlow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banjo.overFlow.models.Answer;
import com.banjo.overFlow.models.Question;
import com.banjo.overFlow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepo;
	
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	//Find All Questions	
	public List<Question> allQuestions(){
		return questionRepo.findAll();
	}
	
	//Create Update Question
	public Question createOrUpdate(Question q) {
		return questionRepo.save(q);
	}
	
	//Get Singular Question
	public Question findQuestion(Long id) {
		Optional<Question> optionalQuestion = questionRepo.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
	//Get Answers To Question
	public List<Answer> getAnswers(Long id) {
		Question question = findQuestion(id);
		return question.getAnswers();		
	}
	
	//Set Answer to Question
	public void addAnswer(Question question, Answer answer) {
		question.addAnswer(answer);
		createOrUpdate(question);
	}
	
}
