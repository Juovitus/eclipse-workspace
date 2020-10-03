<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit</title>
</head>
<body>
<form action = "editItemServlet" method="post">
	Store: <input type = "text" name = "make" value = "${itemToEdit.make}">
	Item: <input type = "text" name = "type" value = "${itemToEdit.type}">
	<input type = "hidden" name = "id" value ="${itemToEdit.id}">
	<input type = "submit" value = "Save Edited Item">
</form>
</body>
</html>