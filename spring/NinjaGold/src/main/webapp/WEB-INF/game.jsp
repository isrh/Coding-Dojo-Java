<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
			<title>Dojo Survey Index</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="css/style.css">
		
	</head>
	
	<body>
	
	<div class="container">
	
			
			  <div class="form-group row">
			    <label class="col-sm-2 col-form-label">Your Gold: </label>
			    <div class="col-sm-10">
			      <label class="col-sm-2 col-form-label"> <c:out value="${gold}"/></label>
			    </div>
			  </div>
			 
	
			
			<div class="row">
			
			  <div class="col">
			  	<h3>Farm</h3>
			  	<p>(earns 10-20 gold)</p>
			  	<form method="post">
			  		<button type="submit" class="btn btn-primary" value="farm" name="action">Find Gold!</button>
			  	</form>
			  </div>
			  
			  <div class="col">
			  	<h3>Cave</h3>
			  	<p>(earns 5-10 gold)</p>
			  	<form method="post">
			  		<button type="submit" class="btn btn-primary" value="cave" name="action">Find Gold!</button>
			  	</form>	
			  </div>
			  
			  <div class="col">
			  	<h3>House</h3>
			  	<p>(earns 2-5 gold)</p>
			  	<form method="post">
			  		<button type="submit" class="btn btn-primary" value="house" name="action">Find Gold!</button>
			  	</form>	
			  </div>
			  
			  <div class="col">
			  	<h3>Casino</h3>
			  	<p>(earns 0-50 gold)</p>
			  	<form method="post">
			  		<button type="submit" class="btn btn-primary" value="casino" name="action">Find Gold!</button>
			  	</form>	
			  </div>
			</div>

			
			<label class="labelactivities">Activities: </label>
			 <div class="overflow-auto actividades">
		        <% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
             for(String activity : activities) {
			 	if(activity.toLowerCase().contains("perdido".toLowerCase())) {%>
				<p class="red"><%= activity %></p>
			 <% }else{ %>
				<p class="green"><%= activity %></p>
			 <% }
		     } %>
		      </div>
			
	</div>	
			
	</body>
</html>