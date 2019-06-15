<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song Details</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<h1><c:out value="${song.title}"/></h1>
<p>Artist: <c:out value="${song.artist}"/></p>
<p>Rating (1-10): <c:out value="${song.rating}"/></p>

<form action="/music/${song.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>