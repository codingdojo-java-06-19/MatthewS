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
<h1>Submitted Info</h1>
Name: <c:out value="${name}"/><br>
Dojo Location: <c:out value="${location}"/><br>
Favorite Language <c:out value="${language}"/><br>
Comments: <c:out value="${comments}"/>
</body>
</html>