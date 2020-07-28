<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Subjects</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		
	</head>
	<body>
	
		<div class="container">
				
				<h2>Subjects</h2>
				


		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              <th>#ID</th>
		              <th>Name</th>
		              <th>Total Students</th>

		            </tr>
		          </thead>
		          <tbody>
		          	<c:forEach items="${subjects}" var="subject">
		            	<tr>
			              <td><a href="/subjects/${subject.id}">${subject.id}</a></td>
			              <td><c:out value="${subject.name}"/></td>
			              <td><c:out value="${subject.students.size()}"/></td>
			               
			            </tr>
					</c:forEach>
		          </tbody>
		        </table>
		        <a href="/">Back to Menu</a>
		     
			</div>
		      
				          
		   </div>
		    
		
	</body>
</html>