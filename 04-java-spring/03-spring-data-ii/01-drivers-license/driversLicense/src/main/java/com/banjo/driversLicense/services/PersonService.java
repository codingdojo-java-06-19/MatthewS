package com.banjo.driversLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banjo.driversLicense.repositories.PersonRepository;
import com.banjo.driversLicense.models.Person;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
	this.personRepository = personRepository;
	}
	
	//Returns all licenses
	public List<Person> allPpl(){
		return personRepository.findAll();
	}
	
	//Creates a Person
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	
	//Retrieves a Person
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	
	//Retrieves unlicensed
	public List<Person> unlicensed(){
		return personRepository.findByLicenseIdIsNull();
	}
}
