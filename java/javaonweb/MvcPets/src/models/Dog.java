package models;

public class Dog extends Animal{
	
	public Dog() {
		super();
	}
	
	public Dog(String name, String breed, double weight) {
		super(name,breed,weight);
	}
	
	public String showAffection() {
		double peso = this.getWeight();		
	
		if(peso<=10) {
			return("Tiene peso livino");
		
		}
		else  if(peso>10 && peso<20) {
			return("Tiene peso medianamente pesado");
		
		}
		
		else {
			return ("Tiene peso pesado");
		
		}
		
		
		
	}

}
