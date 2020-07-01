package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Random
 */
@WebServlet("/RandomWord")
public class RandomWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomWord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String contador = (String) session.getAttribute("count");
		
		String fechat = (String) session.getAttribute("fecha");
		Integer numero;
		
		String letras="ABCDEFGHIJKLMNOPQRSTUWXYZ";
		
		String chain="";
		
		

		//Variable binaria para ver si sumar un numero o un string
		boolean temp;
		
		for (int i=0; i<10;i++) {
			Random rd = new Random(); // creating Random object
		    temp=  rd.nextBoolean();
		    
		    //Si se generado un TRUE, agregamos una letra al azar
		    if (temp==true) {
		    	//Generar PALABRA RANDOM
				int charnum;
				charnum = (int) (Math.random() * 25);
				char letra=letras.charAt(charnum);
				chain+=letra;
		    }
		    
		  //Si se generado un FALSE, agregamos un numero al azar
		    else {
		    	
		    	//Generar NUMERO RANDOM
				
				Integer randomnum=(int) (Math.random() * 9 +1);
				String randomnumstring;
				randomnumstring= randomnum.toString();
				chain+=randomnumstring;
		    }
		}
		
		
		session.setAttribute("chain", chain);
		
		
		
		//Contador de veces que hago click
		if(contador==null) {	
			session.setAttribute("count", "0");
			 
		}
		else {
			numero=Integer.parseInt(contador);	
			numero++;
			contador= numero.toString();
			session.setAttribute("count", contador);
		}
		
		// FECHA
		
		if(fechat==null) {	
			session.setAttribute("fecha", "No tiene registros anteriores");
			 
		}
		else {
			Date date = new Date(); 
			
			DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
			String fecha=hourdateFormat.format(date);
			
			session.setAttribute("fecha", fecha);
		}
		
		
		
		


        RequestDispatcher view= request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
