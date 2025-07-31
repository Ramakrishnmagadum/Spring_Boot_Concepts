<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<h2>Change Password</h2>
	<c:if test="${param.oldPassword !=null}">
		<i style="color: red">Old Password is not matching..</i>
	</c:if>


	<form:form action="process-password" modelAttribute="model" method="GET">
    Old Password:  <input type="password" name="oldPassword">
		<br>
    New Password:  <input type="password" name="newPassword">
		<br>
		<input type="submit" value="Submit">
		<br>
	</form:form>
</body>
</html>