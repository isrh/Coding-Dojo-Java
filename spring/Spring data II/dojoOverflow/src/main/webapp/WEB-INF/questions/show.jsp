<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Questions</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
	
		<div class="container">
				
				<h2>Questions Dashboard</h2>
				
		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              <th>Question</th>
		              <th>Tags</th>
		              
		              

		            </tr>
		          </thead>
		          <tbody>
		          	<c:forEach items="${questions}" var="question">
		            	<tr>
			              <td><a href="/questions/${question.id}">${question.question}</a></td>
			              <td><c:forEach items="${question.getTags()}" var="tag">${tag.subject} </c:forEach></td>

			            </tr>
					</c:forEach>
		          </tbody>
		        </table>
		      </div>
			<a href="/questions/new">New Question</a>
				          
		   </div>
		    
		
	</body>
</html>