<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Counter</title>
		<link rel="stylesheet" href="style.css"> 
	</head>
	<body>
	
		
		
			<div class='counterform'>
				
				<form action="counter" method="get">
			
				
					<h2>Han ingresado <c:out value="${count}"/> a la pagina!</h2>
					<a href="http://localhost:8080/one">Sumar 1 visita</a>
					<a href="http://localhost:8080/double">Sumar 2 visitas</a>
					
					<button type="submit" value="restart" name="views">Ingresar</button>
					
				</form>
				
			</div>
			
			
			
			
		
			
	</body>
</html>