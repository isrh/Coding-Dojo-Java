<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Languages</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
	
		<div class="container">
		
		      <h2>Languages</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>#ID</th>
              <th>Name</th>
              <th>Creator</th>
              <th>Current Version</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach items="${languages}" var="language">
            	<tr>
	              <td><c:out value="${language.id}"/></td>
	              <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a> </td>
	              <td><c:out value="${language.creator}"/></td>
	              <td><c:out value="${language.currentVersion}"/></td>
	              <td><a href="http://localhost:8080/languages/${language.id}/edit">Edit </a>
					     <a href="http://localhost:8080/languages/${language.id}/delete">Delete </a></td>
	            </tr>
			</c:forEach>
          </tbody>
        </table>
      </div>
		        
		        
		        <div class="newlanguage">
		        	<h3>New Language</h2>
		        	
						<form:form action="/languages" method="post" modelAttribute="language">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:textarea path="creator"/>
		    </p>
		    <p>
		        <form:label path="currentVersion">Current version</form:label>
		        <form:errors path="currentVersion"/>
		        <form:input path="currentVersion"/>
		    </p>
		   
		    <input type="submit" value="Submit"/>
		</form:form>
				
		        </div>
		       
		        
		   </div>
		    
		
	</body>
</html>