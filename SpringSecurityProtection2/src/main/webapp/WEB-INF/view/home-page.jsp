<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--  This is Security TagLib with this we can hide or show the content based on User Ruels --%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Home Page</h1>
	<h4>Hello ${username}</h4>
	<h4>User Having Roles : ${roles}</h4>


	<!-- 	Based on USerRoles We can show it or hide it with help of security Tablibs -->
	<sec:authorize access='hasAnyAuthority("Trainer")'>
		<a href="trainer"> Show the trainer Dash-Board</a>
		<br>
	</sec:authorize>

	<sec:authorize access='hasAnyAuthority("Coder")'>
		<a href="coder"> Show the coder Dash-Board</a>
	</sec:authorize>

	<form:form action="Locker" method="POST">
		<input type="submit" value="This is Money Locker">
	</form:form>
	<br>

	<a href="deleteUser?username=${username}"> Delete User</a>
	<br>
	
	<a href="changePassword?username=${username}"> Change Password</a>
	<br>
	
	<!-- 	This is My Custom Logout Page ..after click on logout button it will ask again login -->
	<form:form action="MyCustomLogout">
		<input type="submit" value="LogOut">
	</form:form>
</body>
</html>