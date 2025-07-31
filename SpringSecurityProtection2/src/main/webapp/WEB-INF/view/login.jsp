<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom LogIn Page</title>
</head>
<body>
<c:if test="${param.error !=null}">
<i style="color:red" >Invalide Username or Password</i>
</c:if>

<c:if test="${param.logout !=null}">
<i style="color:red" >Successfully logged Out ! Sign in Again</i>
</c:if>


<h2>Custom LogIn Page</h2>
<form:form >
UserName : <input type="text" name="username" placeholder="Enter Username"><br>
PassWord : <input type="password" name="password" placeholder="Enter Password"><br>
<input type="submit" value="login">
</form:form>


</body>
</html>