package com.ignaciorivera.showdate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	Date date = new Date();
	DateFormat dateFormatTime = new SimpleDateFormat("hh:mm a");
	String formattedDateTime = dateFormatTime.format(new Date()).toString();
	
	DateFormat dateFormatDate = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
	String formattedDateDate= dateFormatDate.format(new Date()).toString();
	
	@RequestMapping("/date")
	public String showDate(Model model) {
		model.addAttribute("fecha",formattedDateDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String showTime(Model model) {
		model.addAttribute("fecha",formattedDateTime);
		return "time.jsp";
	}

}
