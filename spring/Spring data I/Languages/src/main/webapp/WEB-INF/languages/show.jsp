<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title><c:out value="${lenguaje.name}"/></title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" href="css/styleshow.css">

<body>
	<div class="container">
		<h2><c:out value="${language.name}"/></h2>
	<h4>Creador: <c:out value="${language.creator}"/></h4>
	<h4>Versión: <c:out value="${language.currentVersion}"/></h4>
	<a href="/languages/${language.id}/edit">Editar Lenguaje</a> <br>
	<a href="/languages">Back to Dashboard</a>
	<form action="/languages/${language.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
	</form>
	</div>
	
</body>
</html>