package com.banjo.overFlow.services;

import org.springframework.stereotype.Service;

import com.banjo.overFlow.models.Answer;
import com.banjo.overFlow.models.Question;
import com.banjo.overFlow.repositories.AnswerRepository;
import com.banjo.overFlow.repositories.QuestionRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepo;
	private final QuestionRepository questionRepo;
	
	public AnswerService(AnswerRepository answerRepo, QuestionRepository questionRepo) {
		this.answerRepo = answerRepo;
		this.questionRepo = questionRepo;		
	}
	

}
