<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify!</title>
</head>
<body>
<a href="music/new">Add New</a> <a href="/search/topten">Top Songs</a>

<form:form action="/search" method="post" modelAttribute="music">
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:input path="artist"/>
    <input type="submit" value="Submit"/>
</form:form>    

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${allmusic}" var="music">
        <tr>
            <td><a href="songs/${music.id}"><c:out value="${music.title}"/></a></td>
            <td><c:out value="${music.rating}"/></td>
            <td>
            <form action="/songs/${music.id}" method="post">
            <input type="hidden" name="_method" value="delete"><input type="submit" value="delete"></form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>