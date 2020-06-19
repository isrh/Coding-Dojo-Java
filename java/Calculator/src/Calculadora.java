
public class Calculadora implements java.io.Serializable {
	
	private double number1;
	private double number2;
	private String operation;
	private double result;
	
	public Calculadora() {
		
	}
	
	public void setOperator1(double number) {
		this.number1=number;
		
	}
	
	public void setOperator2(double number) {
		this.number2=number;
		
	}
	
	public void setOperation(String operation) {
		this.operation=operation;
		
	}
	
	public void perfomOperation() {
		
		if(this.operation=="+") {
			this.result=this.number1+this.number2;
			
		}
		
		if(this.operation=="-") {
			this.result=this.number1-this.number2;
			
		}
		
		
	}
	
	public double getResult() {
		return this.result;
	}
	
	
	
	

}
