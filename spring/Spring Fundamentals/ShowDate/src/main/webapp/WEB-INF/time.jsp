<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Time Template</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/timeapp.js"></script>
</head>
<body>
	<div class='timeform'>
		<h1><c:out value="${fecha}"/></h1>
	</div>
</body>
</html>