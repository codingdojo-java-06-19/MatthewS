<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Details</title>
</head>
<body>
<h1><c:out value="${eventDetails.name}"/></h1>
<p>Host: <c:out value="${eventDetails.user.firstName}" /></p>
<p>Date: <c:out value="${eventDetails.date}" /></p>
<p>Location: <c:out value="${eventDetails.city}" /></p>
<p>People Attending This Event:</p>

<h4>Message Wall</h4>
<div class="messages">
<c:forEach var="messages" items="${eventDetails.messages}">
<c:out value="${messages.user.firstName}" /> Says: <c:out value="${messages.message}" />
</c:forEach>
</div>

<form:form method="POST" action="/addComment/${eventDetails.id}" modelAttribute="newMessage">
		<form:hidden path="user" value="${user_id}" />
		<form:hidden path="event" value="${eventDetails.id}" />
		 <p>
           <form:label path="message">Add Comment</form:label>
           <form:input path="message"/>
       </p>
       <input type="submit" value="Add Comment">
		</form:form>
</body>
</html>