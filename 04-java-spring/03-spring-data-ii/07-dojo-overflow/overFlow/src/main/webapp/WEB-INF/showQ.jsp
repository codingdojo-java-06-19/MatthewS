<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question</title>
</head>
<body>
<h1><c:out value="${q.question}"/></h1>
<h4><c:forEach items="${q.tags}" var="tag"> | ${tag.subject} |</c:forEach></h4>
<p>Answers:</p>

<p><small>Answers Go Here</small><p>

<c:forEach items="${q.answers}" var="answer">
${answer.answer}
</c:forEach>
<hr>

<form:form action="/questions/addanswer/${q.id}" method="post" modelAttribute="newAnswer">
    <p>
    	<form:hidden path="question" value="${q.id}" />
        <form:label path="answer">answer</form:label>
        <form:errors path="answer"/>
        <form:textarea path="answer"/>
    </p>
    <p>
    <input type="submit" value="Answer"/>
</form:form>


</body>
</html>