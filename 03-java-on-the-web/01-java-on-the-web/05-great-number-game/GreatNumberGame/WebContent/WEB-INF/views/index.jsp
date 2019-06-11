<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Great Number Game</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Welcome to the Great Number Game!</h1>
<p>I am thinking of a number between 1 and 100.</p>
<p>Take a Guess!</p>
<form method="POST" action="Home">
<input type="text" name="num">
<input type="submit" value="Submit">
</form>
<% String result = (String)session.getAttribute("result"); %>
<c:choose>
<c:when test='${result == null}'>
</c:when>
<c:when test='${result == "low"}'>
<div class="low">
Number guessed too low
</div>
</c:when>
<c:when test='${result == "high"}'>
<div class="high">
Number guessed too high
</div>
</c:when>
<c:otherwise>
<div class="correct">
Correct! The number was <c:out value='${num}'/>
<a href="/Reset">Play Again</a>
</div>
</c:otherwise>
</c:choose>

</body>
</html>