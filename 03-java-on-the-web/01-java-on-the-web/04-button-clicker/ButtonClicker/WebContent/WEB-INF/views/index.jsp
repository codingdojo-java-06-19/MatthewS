<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Button Clicker Counter</title>
<link rel="stylesheet" href="style.css"/>
</head>
<body><div id="wrapper">
<form action="Home" method="POST">
	<input type="submit" value="Click Me!">
</form>
<p>You have clicked this button <c:out value="${count}"/> times!
</div>
</body>
</html>