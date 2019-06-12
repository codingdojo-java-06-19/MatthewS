<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>You have visited <a href="http://localhost:8080">http://localhost:8080</a> <c:out value="${current}" /> times.</h1>
	<p>Wanna Go Crazy and up the count.... TWO times? <a href="/gocrazy">Click Here</a></p>
	
	<p>Want to start over? <a href="/reset">Click Here</a> to reset.
	
</body>
</html>