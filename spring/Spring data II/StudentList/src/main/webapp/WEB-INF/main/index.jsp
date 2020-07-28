<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student List       </title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/style.css">
		
		 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
<body>
	
	<div class="container">
		
		        	<h3>Main MENU</h3>
		
			<ul class="list-group ">
		  		<li class="list-group-item blue"><a href="students/new">Add Student</a></li>
		   		<li class="list-group-item blue"><a href="rooms/new">Add Room</a></li>
		   		<li class="list-group-item blue"><a href="subjects/new">Add Subject</a></li>
		   		
		   		
		  
			</ul>
		
			<ul class="list-group ">
		  		<li class="list-group-item lightblue"><a href="students/show">Show Student</a></li>
		   		<li class="list-group-item lightblue"><a href="rooms/show">Show Room</a></li>
		   		<li class="list-group-item lightblue"><a href="subjects/show">Show Subjects</a></li>
		   		
		  
			</ul>
			
			
		
		

				
		</div>

</body>
</html>