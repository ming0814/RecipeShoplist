<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bacon Search</title>
<link rel="stylesheet" href="style2.css">
<style type="text/css">
	p{margin-top: 20px;}
	span{font-weight: bold}
</style>
</head>
<body>
	<a href="Home.jsp"> Home Page </a> <br>
	<p><a href="Logout"> Logout </a></p><br>
	<p><img alt="" src="${recipe.image}" style="width: 500px; height: 500px;"></p> 
	<h2><span>Ingredients: </span></h2>
	<h3>
		<c:forEach items="${recipe.ingredientName}" var="ingValue">
	        <tr>${ingValue.ingName}</tr>
	        	<form action="UserIngredient" method="get">		
	        <input name=userIngreName value="${ingValue.ingName}" hidden>
	        <input type="submit" value="Add"/>
	        </form>
	  	</c:forEach>
	  </h3>
	<br>
	<h2><span>Recipe Found: </span></h2> <h3>${recipe.recipeName}</h3> 
	<br>
	<h2><span>Description: </span></h2><h3> ${recipe.description}</h3> 
	<br>
	<h2><span>Instructions: </span></h2> <h3>${recipe.instruction}</h3> 
	<br>
	<h2><span>Preparation Time: </span></h2> <h3>${recipe.prepTime}</h3> 
	<br>
	<h2><span>Cook Time: </span></h2><h3> ${recipe.cookTime}</h3> 
	<br>
	<h2><span>Amount: </span></h2>
	<h3>
		<c:forEach items="${recipe.ingredientName}" var="ingValue">
			<tr>${ingValue.ingName}</tr>
			<tr>${ingValue.ingAmount}</tr>
		</c:forEach>
	</h3>
</body>
</html>