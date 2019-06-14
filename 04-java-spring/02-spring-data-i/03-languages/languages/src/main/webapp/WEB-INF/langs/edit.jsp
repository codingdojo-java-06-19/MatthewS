<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
   <%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
</head>
<body>
<form:form action="/languages/${language.getId()}" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="put">
    	<form:hidden path="id"/>
    <p>
        <form:label path="lang">Language</form:label>
        <form:errors path="lang"/>
        <form:input path="lang"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
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