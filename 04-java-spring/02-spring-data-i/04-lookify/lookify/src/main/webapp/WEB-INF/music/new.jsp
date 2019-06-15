<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Music</title>
</head>
<body>

<h1>Add Music</h1>
<form:form action="/music" method="post" modelAttribute="music">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:input path="artist"/>
    </p>
    <p>
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>
        <form:select path="rating">
        	<form:option value="1"/>
        	<form:option value="2"/>
        	<form:option value="3"/>
        	<form:option value="4"/>
        	<form:option value="5"/>
        	<form:option value="6"/>
        	<form:option value="7"/>
        	<form:option value="8"/>
        	<form:option value="9"/>
        	<form:option value="10"/>
        	</form:select>
    </p>  
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>