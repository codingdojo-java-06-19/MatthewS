<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<h1>Questions Dashboard</h1>
<table>
<tr>
<th>Question</th>
<th>Tags</th>
</tr>
<c:forEach var="question" items="${allQ}">
<tr>
<td>
<a href="/questions/${question.id}"><c:out value="${question.question}" /></a>
</td>
<td>
 <c:forEach items="${question.tags}" var="tag">[${tag.subject}]</c:forEach>
 </td>
 </tr>
</c:forEach>

</table>
</body>
</html>