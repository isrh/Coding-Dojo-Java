<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>The Code!</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class='container'>
		<form method="post">
		  <div class="form-group">
		  
		  	<p><c:out value="${error}"/></p>"
		    <label for="exampleInputEmail1">What is the code?</label>
		    <input type="text" class="form-control" name="code">
		    
		  </div>	 
		  <button type="submit" class="btn btn-primary">Try Code</button>
		</form>
	</div>
	

</body>
</html>