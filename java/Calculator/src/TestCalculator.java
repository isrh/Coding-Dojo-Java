
public class TestCalculator {
	
	public static void main (String [] args) {
		
		Calculadora calculator= new Calculadora();
		
		calculator.setOperator1(10.5);
		calculator.setOperation("+");
		calculator.setOperator2(5.2);
		calculator.perfomOperation();
		System.out.println(calculator.getResult());
		
	}

	
	
	
}
