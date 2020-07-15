<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lookify</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
	
		<div class="container">
	
			<div class="lookify">
				
				<h2>Lookify</h2>
		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              <th>#ID</th>
		              <th>Title</th>
		              <th>Artist</th>
		              <th>Rating</th>
		              <th>Actions</th> 
		            </tr>
		          </thead>
		          <tbody>
		          	<c:forEach items="${songs}" var="song">
		            	<tr>
			              <td><c:out value="${song.id}"/></td>
			              <td><a href="http://localhost:8080/songs/${song.id}/"><c:out value="${song.title}"/></a> </td>
			              <td><c:out value="${song.artist}"/></td>
			              <td><c:out value="${song.rating}"/></td>
			              <td><a href="http://localhost:8080/songs/${song.id}/delete">Delete </a></td>
			            </tr>
					</c:forEach>
		          </tbody>
		        </table>
		        
		        <a href="/songs">Back to Dashboard</a>
		      </div>
			</div>
		      
				          
		   </div>
		    
		
	</body>
</html>