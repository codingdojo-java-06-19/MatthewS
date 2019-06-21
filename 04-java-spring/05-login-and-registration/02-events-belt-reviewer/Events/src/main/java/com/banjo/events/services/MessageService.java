package com.banjo.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banjo.events.models.Message;
import com.banjo.events.repositories.MessageRepository;

@Service
public class MessageService {
	public MessageRepository mRepo;
	
	public MessageService(MessageRepository mRepo) {
		this.mRepo = mRepo;
	}
	
	//Creates and Saves Messages
    public void saveMsg(Message message){
        mRepo.save(message);
    }

}
