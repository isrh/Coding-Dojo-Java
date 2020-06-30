package models;

public class Contador {
	
	private int cont=0;
	
	public Contador(){
		
	
		
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public void contClick() {
		this.cont=cont+1;
	}
	
	

}
