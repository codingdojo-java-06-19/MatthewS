<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>One Of Us!</title>
</head>
<body>
<c:out value="${error}"/>
<h1> What is the code?</h1>
<form method="POST" action="/entry">
<input type="text" name="pw">
<input type="submit" value="Try Code">
</form>
</body>
</html>