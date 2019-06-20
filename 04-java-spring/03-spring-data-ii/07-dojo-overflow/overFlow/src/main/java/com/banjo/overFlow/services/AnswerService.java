package com.banjo.overFlow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banjo.overFlow.models.Answer;
import com.banjo.overFlow.repositories.AnswerRepository;


@Service
public class AnswerService {
	private final AnswerRepository answerRepo;
	
	public AnswerService(AnswerRepository answerRepo) {
		this.answerRepo = answerRepo;	
	}
	
	public List<Answer> getAll(){
		return answerRepo.findAll();
	}
	
	public Answer getById(Long id) {
		Optional<Answer> optionalAnswer = answerRepo.findById(id);
		if(optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		} else {
			return null;
		}
	}	
    public void saveAnswer(Answer answer){
        answerRepo.save(answer);
}
}	
