<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Language</title>
</head>
<body>
<h1>New Language</h1>
<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="lang">Language</form:label>
        <form:errors path="lang"/>
        <form:input path="lang"/>
    </p>
    <p>
        <form:label path="creator">Version</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="vers">Version</form:label>
        <form:errors path="vers"/>
        <form:input path="vers"/>
    </p> 
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>