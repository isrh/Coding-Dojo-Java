<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="css/stylenew.css">
		 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
<body>
	
	<div class="container">
		
		        	<h3>${product.name}</h3>
		        
						<form action="/products/${product.id}" method="post">
					  <div class="form-group row">	
					    <label  class="col-sm-2 col-form-label">Category:</label>
						    <select class="form-control" name="category_id">
				        		<c:forEach items="${ categories }" var="category">
				        			<option value="${ category.id }"><c:out value="${ category.name }"></c:out></option>
				        		</c:forEach>
				        		
			        	</select>
					  </div>
					  
					   <input type="submit" value="Add Category" />

					</form>
					

		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              <th>Categories</th>

		            </tr>
		          </thead>
		          <tbody>
		          	<c:forEach items="${productCategories}" var="category">
		            	<tr>
			              <td><c:out value="${category.name}"/></td>
			                
			              
			            </tr>
					</c:forEach>
		          </tbody>
		        </table>
		        
		        <a href="/">Back to Products</a>
		      </div>
			</div>
		      

</body>
</html>