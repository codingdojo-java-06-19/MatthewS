<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/submitform">
<p>Your Name: <input type="text" name="name"></p>
<p>Dojo Location: <select name="location"><option value="San Jose">San Jose</option><option value="Burbank">Burbank</select></p>
<p>Favorite Language: <select name="language"><option value="Python">Python</option><option value="Java">Java</option></select></p>
<p>Comments: <textarea name="comments"></textarea></p>
<input type="submit" value="Button">
</form>
</body>
</html>