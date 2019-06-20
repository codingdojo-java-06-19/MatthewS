<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ask New Question</title>
</head>
<body>
<form:form action="/questions/new" method="post" modelAttribute="newQuestion">
    <p>
        <form:label path="question">Question</form:label>
        <form:errors path="question"/>
        <form:textarea path="question"/>
    </p>
    <p><label>Tags</label>
		<input type="text" name="subjects">
    </p>

    <input type="submit" value="Create"/>
</form:form>
</body>
</html>