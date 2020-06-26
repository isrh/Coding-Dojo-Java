package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Dog;



/**
 * Servlet implementation class ShowDog
 */
@WebServlet("/ShowDog")
public class ShowDog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Let view handle the request
				RequestDispatcher view= request.getRequestDispatcher("/WEB-INF/theDog.jsp"); //seleccionar pagina
				view.forward(request, response); // ir o recargarpagina
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Solo funciona con formularios method=post
		
		// TODO Auto-generated method stub
				String name=request.getParameter("dogname");
				String breed=request.getParameter("dogbreed");
				
				int weight= Integer.parseInt(request.getParameter("dogweight"));
						
				System.out.print(name);
//				Create model
				Dog dog = new Dog(name, breed, weight);
				request.setAttribute("dog",dog);
				
				// TODO Auto-generated method stub		
				doGet(request, response);
	}

}
