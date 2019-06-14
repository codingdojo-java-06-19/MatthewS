<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<h1><c:out value="${langs.lang}"/></h1>
<p>Created By: <c:out value="${langs.creator}"/></p>
<p>Version: <c:out value="${langs.vers}"/></p>
<a href="/languages/${langs.id}/edit">Edit Language</a>


<form action="/languages/${langs.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete Language">
</form>
</body>
</html>