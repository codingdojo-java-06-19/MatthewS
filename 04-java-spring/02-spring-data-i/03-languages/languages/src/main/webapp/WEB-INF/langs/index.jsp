<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All of the Languages</title>
</head>
<body>
<h1>All Languages</h1>
<p><c:out value="${success}" /></p>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${langs}" var="lang">
        <tr>
            <td><a href="/languages/${lang.id}"><c:out value="${lang.lang}"/></a></td>
            <td><c:out value="${lang.creator}"/></td>
            <td><c:out value="${lang.vers}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/languages/new">New Language</a>
</body>
</html>