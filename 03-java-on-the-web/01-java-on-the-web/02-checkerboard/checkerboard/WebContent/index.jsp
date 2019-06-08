<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkerboard Assignment</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<% String width = request.getParameter("width");
	   String height = request.getParameter("height");
	 %>
	 <div id="wrapper">
	 <h1>Checkerboard:<%= width %>w X <%= height %>h</h1>
	<% for(int index = 0; index < Integer.valueOf(height); index++){ %>
	<div class="row">
	<% for (int j = 0; j < Integer.valueOf(width); j++){%>
	<div class="box<%= ((index + j) % 2) + 1 %>"></div>
	<% } %>
	</div>
	<% } %>
	</div>
</body>
</html>