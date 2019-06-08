package com.matt.web.models;

public class Dog extends Animal implements Affection {
	public Dog(String name, String breed, int weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		int weight = getWeight();
		String name = getName();
		String breed = getBreed();
		String woof = "";
		if (weight >= 30) {
			woof =  name + " curled up besides you";
		} else if (weight < 30) {
			woof = name + " jumped up on your lap";
		}
		return woof;
	}
	
}
