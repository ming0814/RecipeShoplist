<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/png" href="http://moziru.com/images/bacon-clipart-6.png"/>
<title>Bacon Search</title>
<script>
	function validateForm(){
		var x = document.forms["userForm"]["userName"].value;
		var y = document.forms["userForm"]["password"].value;
		if(x == ""){
			alert("Username must be filled out");
			return false;
		}

		if(y == ""){
			alert("Password must be filled out");
			return false;
		}
	}
</script>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Bacon Search</h1>
	<h2>Login here</h2>
	<form name="userForm" action=Login onsubmit="return validateForm()" method="post">
		<input type=text name=userName placeholder="Username"><br> 
		<input type=password name=password placeholder="Password" align="middle"><br> 
		<input type=submit value=Login> <br>
	</form>
	<br>
	<br>
	<!-- Navigation links -->
	<a href="Register.jsp"> New? Sign up here! </a>
	<br>
</body>
</html>