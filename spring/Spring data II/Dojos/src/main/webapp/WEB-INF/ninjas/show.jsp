<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ninjas</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
	
		<div class="container">
				

				<h2>Dojos</h2>
				
				<a href="/dojos/new">Add New Dojo</a>
				<a href="/ninjas/new">Add New Ninja</a>
				<a href="/dojos/show">Show Dojos</a>
				
		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              
		              <th>Name</th>
		              <th>Age</th>
		              <th>Dojo</th>

		            </tr>
		          </thead>
		          <tbody>
		          	<c:forEach items="${ninjas}" var="ninja">
		            	<tr>		              
			              <td><c:out value="${ninja.firstName} ${ninja.lastName}"/></td>
			              <td><c:out value="${ninja.age} "/></td>
  
			              <td><c:out value="${ninja.dojo.name}"/></td>

			            </tr>
					</c:forEach>
		          </tbody>
		        </table>
		      </div>
			
		      
				          
		   </div>
		    
		
	</body>
</html>