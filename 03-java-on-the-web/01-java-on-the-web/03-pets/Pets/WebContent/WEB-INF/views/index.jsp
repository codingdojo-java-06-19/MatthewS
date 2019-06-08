<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Best Buddies!</title>
</head>
<body>
<h1>Make a Dog!</h1>
	<form action="Dogs" method="GET">
	<label>Name:</label><input type="text" name="name">
	<label>Breed:</label><input type="text" name="breed">
	<label>Weight (lb):</label><input type="text" name="weight">
	<input type="submit" value="submit">	
	</form>
<h1>Make a Cat!</h1>
	<form action="Cats" method="GET">
	<label>Name:</label><input type="text" name="name">
	<label>Breed:</label><input type="text" name="breed">
	<label>Weight (lb):</label><input type="text" name="weight">
	<input type="submit" value="submit">
	</form>	
</body>
</html>