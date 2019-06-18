<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Details</title>
</head>
<body>
<h1><c:out value="${category.name}"/></h1>
<h3>Products:</h3>
<c:if test="${empty products}">
No categories have been added
</c:if>
<c:if test="${not empty products}">
<c:forEach var="added" items="${products}">
<p><c:out value="${added.name}" /> "<c:out value="${added.description}" />" - <c:out value="${added.price}" />
</c:forEach>
</c:if>


<form:form action="/products/addCategory/${product.id}" method="post" modelAttribute="category">
<p>Add Product:</p>


<select name="product">
<c:forEach var="product" items="${unAdded}">
	<option value="${product.id}">${product.name}</option>
	</c:forEach>
</select>
<input type="submit" value="Add Product">
</form:form>
</body>
</html>