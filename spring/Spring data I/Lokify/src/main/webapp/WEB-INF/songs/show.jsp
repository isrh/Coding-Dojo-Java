<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title><c:out value="${song.title}"/></title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/stylesong.css">

<body>

	<div class="songcard">
		<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h3 class="card-title"><c:out value="${song.title}"/></h3>
		    <h4 class="card-subtitle mb-2 text-muted">Artist: <c:out value="${song.artist}"/></h4>
		    <h4 class="card-subtitle mb-2 text-muted">Rating: <c:out value="${song.rating}"/>/10</h4>
		    <a href="/songs" class="card-link">Back to Dashboard</a>
		   
		  </div>
		</div>
	</div>
	
</body>
