
public class Test {

	public static void main (String[] args) {
		
		Calculator calculadora = new Calculator();
		
		calculadora.performOperation(100);
		calculadora.performOperation("+");
		calculadora.performOperation(100);
		calculadora.performOperation("*");
		calculadora.performOperation(2);
		calculadora.performOperation("+");
		calculadora.performOperation(4);
		calculadora.performOperation("/");
		calculadora.performOperation(4);
		calculadora.performOperation("-");
		calculadora.performOperation(2);
		calculadora.performOperation("=");
		
		
		calculadora.getResult();
	}
}
