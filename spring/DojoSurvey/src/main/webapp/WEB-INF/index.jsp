<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
		
			<form method="post">
			
			  <div class="form-group row">
			    <label  class="col-sm-2 col-form-label">Your Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputPassword" name="name">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label>Dojo Location</label>
			    <select class="form-control" id="exampleFormControlSelect1" name="location">
			      <option>San Jose</option>
			      <option>Burbank</option>
			      <option>New York</option>   
			    </select>
			  </div>
			  
			  <div class="form-group">
			    <label >Favorite Language</label>
			    <select class="form-control" id="exampleFormControlSelect1" name="language">
			      <option>Python</option>
			      <option>Java</option>
			      <option>C++</option>
			    </select>
			  </div>
			  

			    <label class="activities">Comment (optional)</label>
			    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="comment"></textarea>

			  
			  <button type="submit" class="btn btn-primary" value="submit" name="action">Button</button>
			</form>
			
		</div>
	</body>
</html>