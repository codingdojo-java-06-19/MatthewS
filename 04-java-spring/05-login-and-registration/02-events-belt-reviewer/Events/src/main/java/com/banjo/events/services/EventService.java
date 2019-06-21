package com.banjo.events.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banjo.events.models.Event;
import com.banjo.events.models.Message;
import com.banjo.events.models.User;
import com.banjo.events.repositories.EventRepository;
import com.banjo.events.repositories.UserRepository;


@Service
public class EventService {
	private EventRepository eRepo;
	private UserRepository uRepo;
	
	public EventService(EventRepository eRepo, UserRepository uRepo) {
		this.eRepo = eRepo;
		this.uRepo = uRepo;
	}
	
	//Creates and Saves Events
    public void saveEvent(Event event){
        eRepo.save(event);
    }
    
    //Retrieve events within state
    public List<Event> allEventsInState(String state){
    	return this.eRepo.findByState(state);
    }
    //Retrieve events out of state
    public List<Event> allEventsNotState(String state){
    	return this.eRepo.findByStateIsNot(state);
    }
    
    
    // Retrieve event by ID
    public Event findEventById(Long id) {
    	Optional<Event> e = eRepo.findById(id);    	
    	if(e.isPresent()) {
            return e.get();
    	} else {
    	    return null;
    	}
    }
    
    //Retrieve messages from Event
    public List<Message> getMessagesFromEvent(Long id){
    	Event e = findEventById(id);
    	return e.getMessages();
    }
    
    //Join Event
    public void joinEvent(Event event, User user) {
    List<User> addUsr = new ArrayList<>();
    List<Event> addEvnt = new ArrayList<>();
    addUsr.add(user);
    addEvnt.add(event);
    event.setJoinedEvent(addUsr);
    user.setJoinedEvent(addEvnt);

    }
}
