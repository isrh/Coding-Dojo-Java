<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Students</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
	
		<div class="container">
				
			<div class="lookify">
				
				<h2>Rooms</h2>
				
				<a href="/students/new">Add New Student</a>
				<a href="/contacts/new">Add New Contact</a>
				<a href="/contacts/show">Show Contacts</a>
				<a href="/rooms/new">Add Room</a>
		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              <th>#ID</th>
		              <th>Name</th>

		            </tr>
		          </thead>
		          <tbody>
		          	<c:forEach items="${rooms}" var="room">
		            	<tr>
			              <td><c:out value="${room.id}"/></td>
			              <td><c:out value="${room.name}"/></td>
			              
        
			              
			            </tr>
					</c:forEach>
		          </tbody>
		        </table>
		      </div>
			</div>
		      
				          
		   </div>
		    
		
	</body>
</html>