package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Contador;

/**
 * Servlet implementation class Counter
 */
@WebServlet("/Counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Counter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Let view handle the request
				
				
				HttpSession session = request.getSession();
				
				
				
				String contador = (String) session.getAttribute("count");
				Integer numero;
				
				if(contador==null) {	
					session.setAttribute("count", "0");
					 
				}
				else {
					numero=Integer.parseInt(contador);	
					numero++;
					contador= numero.toString();
					session.setAttribute("count", contador);
				}

				
				
		        
		       
		        RequestDispatcher view= request.getRequestDispatcher("/WEB-INF/index.jsp");
				view.forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
