<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
</head>
<a href="Logout"> Logout </a> <br>
<a href="userIngre.jsp"> Your shopplist </a> <br>
<h2>
<body>
	<h1>Welcome ${user.userName}<h1>
	<form action="Show" method="post">
		<input type="text" name="ingredientName" placeholder="Type an ingredient here to find a recipe" id="ingredientName"/>
		<input type="submit" value="Search" />
	</form>
	<form action="UserIngredient" method="get">
		<!-- <input type="text" name="userIngreName" id="userIngreName"/> -->
		<div class="styled-select slate">
		<select class="select" name="userIngreName">
		  <c:forEach items="${selectList}" var="selectValue">
		    <option value="${selectValue}">
		        ${selectValue}
		    </option>
		  </c:forEach>
		</select>
		</div>
		<input type="submit" value="Add" />
	</form>
</body>
</h2>
<a href="userIngre.jsp"> Your shopplist </a> <br>
<a href="Logout"> Logout </a> <br>
</html>
