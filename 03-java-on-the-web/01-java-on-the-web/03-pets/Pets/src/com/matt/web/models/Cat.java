package com.matt.web.models;

public class Cat extends Animal implements Affection {
	public Cat(String name, String breed, int weight) {
		super(name, breed, weight);
	}
public String showAffection() {
	int weight = getWeight();
	String name = getName();
	String breed = getBreed();
	String meow = "Your " + breed + " cat, " + name + " looked at you with some affection. You think.";
	return meow;
	
	}
}
	
	