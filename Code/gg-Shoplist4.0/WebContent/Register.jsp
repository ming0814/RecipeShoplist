<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bacon Search</title>
	<link rel="stylesheet" href="style.css">
	</head>
	
	<body>
	
		<h1> Register here</h1>
		<script>
			function validateForm() {
			    var x = document.forms["userForm"]["userName"].value;
			    var y = document.forms["userForm"]["password"].value;
			    if (x == "") {
			        alert("Username must be filled out");
			        return false;
			    }
			    
			    if (y == "") {
			        alert("Password must be filled out");
			        return false;
			    }
			}
	   </script>
		<form name=userRegister action=Register onsubmit="return validateForm()" method="post">
		
			<input type=text placeholder="New username here" name=userName><br>
			<input type=password placeholder="New password here" name=password><br>
			<input type=submit value=Register> <br> 
		
		</form>
		
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		<!-- Navigation links --> 
		<a href="Welcome.jsp"> Already have an account? Log in! </a> <br>
	
	</body>
</html>