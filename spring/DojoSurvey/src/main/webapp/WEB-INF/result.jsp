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
	
		<div class="results">
		
			<form method="post">
					<h2>Submitted Info</h2>
				
					<p>Name:   <p>  <c:out value="${name}"/></p>
					<p>Dojo Location:      <c:out value="${location}"/></p>
					<p>Favorite Langauge:      <c:out value="${language}"/></p>
					<p>Comment:      <c:out value="${comment}"/></p>
					
					<button type="submit" class="btn btn-primary" value="submit" name="action">Go Back</button>
			</form>
				
		</div>
		

	</body>
</html>