<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Products</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		
	</head>
	<body>
	
		<div class="container">
				
			
				
				<h2>Products</h2>
				
				<a href="/products/new">Add New Product</a>
				<a href="/categories/new">Add Category</a>
				<a href="/categories/show">Show Categories</a>

		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              <th>#ID</th>
		              <th>Name</th>
		              <th>Description</th>
		              <th>Price ($)</th>
		              <th>Categories</th>
		              

		            </tr>
		          </thead>
		          <tbody>
		          	<c:forEach items="${products}" var="product">
		            	<tr>
			              <td><a href="/products/${product.id}">${product.id}</a></td>
			              <td><c:out value="${product.name}"/></td>
			              <td><c:out value="${product.description}"/></td>
			               <td><c:out value="${product.price}"/></td>
			               <td><c:out value="${product.getCategories().size()}"/></td>
			            </tr>
					</c:forEach>
		          </tbody>
		        </table>
		      
			</div>
		      
				          
		   </div>
		    
		
	</body>
</html>