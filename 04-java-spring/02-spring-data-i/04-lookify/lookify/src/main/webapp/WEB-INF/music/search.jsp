<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Songs by artist: <c:out value="${search}"/>
	
	<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${results}" var="music">
        <tr>
            <td><a href="/songs/${music.id}"><c:out value="${music.title}"/></a></td>
            <td><c:out value="${music.rating}"/></td>
            <td>Delete</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>