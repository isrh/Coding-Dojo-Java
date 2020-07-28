<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Licenses</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
	
		<div class="container">
				
			<div class="lookify">
				
				<h2>Licenses</h2>
				
		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              <th>#ID</th>
		              <th>First Name</th>
		              <th>Last Name</th>
		              <th>License</th>
		              <th>State</th>
		              <th>Experiration Date</th>
		             

		            </tr>
		          </thead>
		          <tbody>
		          	<c:forEach items="${persons}" var="person">
		            	<tr>
			              <td><c:out value="${person.id}"/></td>
			              <td><c:out value="${person.firstName}"/></td>
			              <td><c:out value="${person.lastName}"/></td>
			              <td><c:out value="${person.license.number}"/></td>
			              <td><c:out value="${person.license.state}"/></td>
			              <td><c:out value="${person.license.expirationDate}"/></td>
			              
			              
			            </tr>
					</c:forEach>
		          </tbody>
		        </table>
		      </div>
			</div>
		      
				          
		   </div>
		    
		
	</body>
</html>