<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Form</title>
</head>
<body>
<h1>Sign up !</h1>

<form:form action="process-signup" method="POST" modelAttribute="signup" >

UserName : <form:input path="username"/> <br>
PassWord : <form:input path="password"/>  <br>

<input type="reset" value="Cancel"> 
<input type="submit" value="SignUp"> 

</form:form>

</body>
</html>