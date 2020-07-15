<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SUM TWO!</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
	
	<div class='showTwo'>
		<h2>Han ingresado <c:out value="${count}"/> a la pagina!</h2>
		<a href="http://localhost:8080/counter">Show Counter</a>
	</div>
	</body>
</html>