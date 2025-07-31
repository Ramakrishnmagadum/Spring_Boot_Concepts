<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Changed</title>
</head>
<body>

<h3>Password Changed succesfully...</h3>

	<form:form action="MyCustomLogout">
		<input type="submit" value="LogOut">
	</form:form>
</body>
</html>