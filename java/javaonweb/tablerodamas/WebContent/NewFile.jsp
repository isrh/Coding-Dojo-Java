<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/style.css">
	
<title>Tablero Damas</title>
</head>
<body>


	
	<% 
	
	String rows="0";
	String columns="0";
	
	if(request.getParameter("height")!=null) {
		rows = request.getParameter("height");
	}
	
	else  if(request.getParameter("height")==null) {
		rows = request.getParameter("0");
	}
	
	if(request.getParameter("width")!=null) {
		columns = request.getParameter("width");
	}
	
	else  if(request.getParameter("width")==null) {
		columns = request.getParameter("0");
	}


	int height=Integer.parseInt(rows);
	int width=Integer.parseInt(columns);
	
	String insert="";
	String color="";
	
	 for(int h = 0; h < height; h++) { 
		 
		 insert=insert+"<div class='row'>";
		 
		 for (int w=0; w< width; w++){
			 
			 if(w%2!=0){
				 
				 if(h%2!=0){
					 color="white";
					 
				 }
				 
				 else if (h%2==0){
					 color="black";
				 }
				 
			 }
			 else {
				 
				 if(h%2!=0){
					 color="black";
					 
				 }
				 else if (h%2==0){
					 color="white";
				 }
						 
			 }
			 
			insert=insert+"<div class='"+color+"'></div>";
			
			
		
		} 
		 
		 insert = insert + "</div>";
		
	 }
	 
	
	
	%>
	
	<div class='container'>
		
		<h1>Checkerboard: <%=width%>w X <%=height%>h</h1>
		

		<%=insert%>
	
	
	</div>
	
	
</body>
</html>