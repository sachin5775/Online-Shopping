package com.javapapers.jee;

public class AnimalType {

	public String animalType(String animalName) {
		String animalType = "";
		if ("Lion".equalsIgnoreCase(animalName)) {
			animalType = "Wild";
		} else if ("dog".equalsIgnoreCase(animalName)) {
			animalType = "Domestic";
		} 
		else if ("shital".equalsIgnoreCase(animalName)) {
			animalType = "Wild";
		} 
		else {
			animalType = "I Dont Know";
		}
		return animalType;
	}

}
