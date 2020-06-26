<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Pets</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="resources/style.css">
	</head>
	<body>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	

			<div class="container">
			
				<div class='dogform'>
				
					<form action="ShowDog" method="post">
					
					  	<div class="form-group">
						    <label for="exampleInputName">Name</label>
						    <input name="dogname" type="text"  class="form-control" placeholder="Enter Name">	   
					 	 </div>
					 	 
						 <div class="form-group">
						    <label for="exampleInputPassword1">Breed</label>
						    <input name="dogbreed" type="text" class="form-control" id="exampleInputBreed" placeholder="Enter Breed">
						 </div>
						 
						 <div class="form-group">
						    <label for="exampleInputPassword1">Weight</label>
						    <input name="dogweight" type="number" class="form-control" id="exampleWeight" placeholder="Enter Weight">
						 </div>
						
			  			<button type="submit" class="btn btn-primary">Ingresar</button>
					</form>
					
				</div>
				
				<div class='catform'>
					<form action="ShowCat" method="post">
					  	<div class="form-group">
						    <label for="exampleInputName">Name</label>
						    <input name="catname" type="text"  class="form-control" placeholder="Enter Name">
						  
					 	 </div>
						 <div class="form-group">
						    <label for="exampleInputPassword1">Breed</label>
						    <input name="catbreed" type="text" class="form-control" id="exampleInputBreed" placeholder="Enter Breed">
						 </div>
						 <div class="form-group">
						    <label for="exampleInputWeight">Weight</label>
						    <input name="catweight" type="number" class="form-control" id="exampleInputWeight" placeholder="Enter Weight">
						 </div>
						
			  			<button type="submit" class="btn btn-primary">Ingresar</button>
					</form>
				</div>
	
			</div>
	</body>
</html>