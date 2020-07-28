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
				
				<h2>Persons</h2>
				
				<a href="/students/new">Add New Student</a>
				<a href="/contacts/new">Add New Contact</a>
				<a href="/contacts/show">Show Contacts</a>
		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              
		              <th>Name</th>
		              <th>Age</th>
		              <th>Address</th>
		              <th>City</th>
		              <th>State</th>
		              

		            </tr>
		          </thead>
		          <tbody>
		          	<c:forEach items="${students}" var="student">
		            	<tr>		              
			              <td><c:out value="${student.firstName} ${student.lastName}"/></td>
			              <td><c:out value="${student.age}"/></td>
			               <td><c:out value="${student.contact.address}"/></td>
			               <td><c:out value="${student.contact.city}"/></td>
			               <td><c:out value="${student.contact.state}"/></td>
			              
			              
			              
			            </tr>
					</c:forEach>
		          </tbody>
		        </table>
		      </div>
			</div>
		      
				          
		   </div>
		    
		
	</body>
</html>