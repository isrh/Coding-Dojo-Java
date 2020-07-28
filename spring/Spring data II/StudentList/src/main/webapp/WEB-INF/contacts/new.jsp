<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Person</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="css/stylenew.css">
		 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
<body>
	
	<div class="container">
		
		        	<h3>New Contact</h3>
		        
						<form action="/contacts/new" method="post">
					  <div class="form-group row">	
					    <label  class="col-sm-2 col-form-label">Student:</label>
						    <select class="form-control" name="student_id">
				        		<c:forEach items="${ students }" var="student">
				        			<c:if test="${student.contact == null}">
				        				<option value="${ student.id }"><c:out value="${ student.firstName } ${ student.lastName }"></c:out></option>
				        			</c:if>
				        		</c:forEach>
			        	</select>
					  </div>
					  <div class="form-group row">
					    <label  class="col-sm-2 col-form-label">Address:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="address">
					    </div>
					    <label  class="col-sm-2 col-form-label">City:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="city">
					    </div>
					    <label  class="col-sm-2 col-form-label">State:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="state">
					    </div>
					    
			        	 
				    	 <input type="submit" value="Add" />
					  </div>
					</form>
				
		</div>

</body>
</html>