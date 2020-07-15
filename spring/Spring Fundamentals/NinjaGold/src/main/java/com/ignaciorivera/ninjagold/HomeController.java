package com.ignaciorivera.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller


public class HomeController {
	
	
	@RequestMapping("/Gold")
	public String showForm(HttpSession session, Model model, @RequestParam(value="action", required=false) String action) {
		
		String gold= (String) session.getAttribute("gold");
		
		if (gold == null) {
			session.setAttribute("gold", "0");
			session.setAttribute("activities", new ArrayList<String>());
		}
		
		if(action!=null) {
			if(action.equals("farm"))	{
				
			
				Integer randomnum=(int) (Math.random() * 11 +10);
				String tiempo= new SimpleDateFormat("MMMM dd yyyy hh:mm").format(new Date());
				String mensaje ="";
				
				Integer goldint= Integer.parseInt(gold);
				
				Integer newgold=goldint+randomnum;
				
				gold= newgold.toString();
				
				mensaje+="Pasaste por la granja y haz ganado "+randomnum+" ("+tiempo+")";
				
				session.setAttribute("gold", gold);
				
				
				ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
				activities.add(mensaje);
				
				
			}
			
			if(action.equals("cave"))	{
				
				Integer randomnum=(int) (Math.random() * 6 +5);
				
				String tiempo= new SimpleDateFormat("MMMM dd yyyy hh:mm").format(new Date());
				String mensaje ="";
				
				Integer goldint= Integer.parseInt(gold);
				
				Integer newgold=goldint+randomnum;
				
				gold= newgold.toString();
				
				mensaje+="Pasaste por la cueva y haz ganado "+randomnum+" ("+tiempo+")";
				
				session.setAttribute("gold", gold);
				
				
				ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
				activities.add(mensaje);
				
			}	
			if(action.equals("house"))	{
							
				Integer randomnum=(int) (Math.random() * 4 +2);
				
				String tiempo= new SimpleDateFormat("MMMM dd yyyy hh:mm").format(new Date());
				String mensaje ="";
				
				Integer goldint= Integer.parseInt(gold);
				
				Integer newgold=goldint+randomnum;
				
				gold= newgold.toString();
				
				mensaje+="Pasaste por la casa y haz ganado "+randomnum+" ("+tiempo+")";
				
				session.setAttribute("gold", gold);
				
				
				ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
				activities.add(mensaje);
			}
	
			if(action.equals("casino"))	{
				
				boolean temp;
				Random rd = new Random(); // creating Random object
			    temp=  rd.nextBoolean();
				
				Integer randomnum=(int) (Math.random() * 51);
				
				String tiempo= new SimpleDateFormat("MMMM dd yyyy hh:mm").format(new Date());
				String mensaje ="";
				
				Integer goldint= Integer.parseInt(gold);
				
				if(temp==true) {
					Integer newgold=goldint+randomnum;
					
					gold= newgold.toString();
					
					mensaje+="Pasaste por el casino y haz ganado "+randomnum+" ("+tiempo+")";
				}
				else {
					Integer newgold=goldint-randomnum;
					
					gold= newgold.toString();
					
					mensaje+="Pasaste por el casino y haz perdido "+randomnum+" ("+tiempo+")";
				}
				
				
				session.setAttribute("gold", gold);
				
				
				ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
				activities.add(mensaje);
			}
			
			
				
			return "redirect:/Gold";
		}
		else {
			return "game.jsp";
		}
		
		
	


}
}
