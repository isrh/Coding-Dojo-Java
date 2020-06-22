import java.util.ArrayList;

public class Calculator {
	
	public ArrayList<Dato> secuencia = new ArrayList<Dato>();
	
	
	public Calculator() {
		
	}

	//ingresar operador
	public void performOperation(String operator) {
		Dato secuencia = new Dato(operator);
		this.secuencia.add(secuencia);
	}
	
	//ingresar numero
	
	public void performOperation(double number) {
		Dato secuencia = new Dato(number);
		this.secuencia.add(secuencia);
	}
	
	//conseguir lista
	public ArrayList<Dato> getList(){
		return this.secuencia;
	}
	
	
	//ver listado
	public void viewSecuencia(ArrayList<Dato> lista) {
		
		boolean nature;
		Dato dato;
		
		for (int i=0; i<lista.size(); i++) {
			
			dato=lista.get(i);
			nature=dato.getNumeric();
			
			if (nature==false) {
				System.out.println(dato.getOperator());
			
			}
			
			if (nature==true) {
				System.out.println(dato.getNumber());
			
			}
		
		}
	}
	
	
	//ver si hay * o /
	
	public boolean checkList(ArrayList<Dato> lista){
		
		
		int sum=0;
		String operador;
		
		for (int i=1; i<lista.size(); i+=2) {
			
			operador=lista.get(i).getOperator();
			
			if (operador=="*" || operador=="/") {
				sum=sum+1;
			
			}
		
		}
		
		if (sum==0) {
			return false;
		}
		
		return true;
			
	}
	
	public void getResult() {
		
		
		double result=0;
		
		boolean validator=false;
		boolean validator2=false;
		
		
		validator=checkList(this.getList());
		
		
		
		if (validator==false) {
			//System.out.println("hay solo sumas");
			result=this.getSuma(this.getList());
			System.out.println(result);
		}
		
		//si aun existen * o /, arreglar secuencia y enviar denuevo a getResult
		else if (validator==true){
		//System.out.println("hay multiplicaciones o divisiones, hay que arreglar la secuencia");
		this.improveSequence(this.getList());
		
		this.getResult();
			
		}

		
	}
	
	public ArrayList<Dato> improveSequence(ArrayList<Dato> lista) {
		
		ArrayList<Dato> newlista = new ArrayList<Dato>();
		
		String operador;
		
		double number1;
		double number2;
		
		double newnumber;
		
		
		
		for (int i=1; i<lista.size(); i+=2) {
			
			
			operador=lista.get(i).getOperator();
			
			if (operador=="*") {
				number1=lista.get(i-1).getNumber();
				number2=lista.get(i+1).getNumber();
				
				newnumber=number1*number2;
				
				Dato dato=new Dato(newnumber);
				//this.viewSecuencia(lista);			
				
				lista.set(i-1,dato);
				lista.remove(i+1);
				lista.remove(i);
				
				//this.viewSecuencia(lista);
				newlista=lista;
				
				return newlista;

			}
			
			if (operador=="/") {
				number1=lista.get(i-1).getNumber();
				number2=lista.get(i+1).getNumber();
				
				newnumber=number1/number2;
				
				Dato dato=new Dato(newnumber);
				
				lista.set(i-1,dato);
				lista.remove(i+1);
				lista.remove(i);

				
				newlista=lista;
				return newlista;
			}
			
		}
		
		return null;
		

	}
	
	public double getSuma(ArrayList<Dato> lista) {
		
		double result=0;
		String operador;
		double number;
		
		
		
		for (int i=1; i<lista.size(); i+=2) {
			
			operador=lista.get(i).getOperator();
			
			if (operador=="-") {
				number=lista.get(i+1).getNumber()*(-1);
						
						Dato dato=new Dato(number);
				
				lista.set(i+1,dato);
			}
		
		}
		
		for (int i=0; i<lista.size(); i+=2) {
			
			result=result +lista.get(i).getNumber();
		}
		
		return result;
	}
}

