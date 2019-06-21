<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.firstName}" /></h1>
	<a href="/logout">Logout</a>
	
	<h5>Here are some of the events in your state</h5>
	<table>
	<tr>
	<th>Name</th>
	<th>Date</th>
	<th>Location</th>
	<th>Host</th>
	<th>Action / Status</th>
	</tr>
	<c:forEach var="events" items="${userState}">
	<tr>
	<td><c:out value="${events.name}" /></td>
	<td><c:out value="${events.date}" /></td>
	<td><c:out value="${events.city}" /></td>
	<td><c:out value="${events.user.firstName}"/></td>
	<td><a href="/join/${events.id}">Join</a>
	</td>
	</tr>
	</c:forEach>
	</table>
	
	<h5>Here are some of the events in other states</h5>
	<table>
	<tr>
	<th>Name</th>
	<th>Date</th>
	<th>Location</th>
	<th>Host</th>
	<th>Action / Status</th>
	</tr>
	<c:forEach var="otherevents" items="${userOtherState}">
	<tr>
	<td><a href="${otherevents.id}"><c:out value="${otherevents.name}" /></a></td>
	<td><c:out value="${otherevents.date}" /></td>
	<td><c:out value="${otherevents.city}" /></td>
	<td><c:out value="${otherevents.user.firstName}"/></td>
	<td>
<a href="/join/${otherevents.id}">Join</a>
	</td>
	</tr>
	</c:forEach>
	</table>

<h5>Create an Event</h5>
<form:form method="POST" action="/createEvent" modelAttribute="newEvent">
		<form:hidden path="user" value="${user.id}" />
       <p>
           <form:label path="name">Name</form:label>
           <form:input path="name"/>
       </p>
       <p>
           <form:label path="date">Date</form:label>
           <form:input type="date" path="date"/>
       </p>
       <p>
           <form:label path="city">City:</form:label>
           <form:input path="city"/>
       </p>
       <p>
           <form:label path="state">State:</form:label>
           <form:input path="state"/>
       </p>
       
       <input type="submit" value="Create">
</form:form>
</body>
</html>