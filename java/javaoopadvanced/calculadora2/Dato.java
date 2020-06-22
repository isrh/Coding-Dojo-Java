
public class Dato {
	
	private String operator;
	private double number;
	private boolean isnumber;
	
	
	public Dato (String operator) {
		
		this.operator=operator;
		this.isnumber=false;
		
	}
	
	public Dato (double number) {
		
		this.number=number;
		this.isnumber=true;
		
	}
	
	public double getNumber() {
		return this.number;
	}
	
	public String getOperator() {
		return this.operator;
	}
	
	public boolean getNumeric() {
		return this.isnumber;
	}
	
	

}
