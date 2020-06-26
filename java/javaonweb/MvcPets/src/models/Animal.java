package models;

public class Animal implements Pet {
	
	private String name;
	private String breed;
	private double weight;
	
	public Animal() {
		
	}
	
	public Animal(String name, String breed, double weight) {
		this.setName(name);
		this.setBreed(breed);
		this.setWeight(weight);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


	public String showAffection() {
		
		return "";
		
	}

}
