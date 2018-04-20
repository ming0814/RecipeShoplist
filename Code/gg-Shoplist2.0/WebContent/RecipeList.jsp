<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recipe List</title>
<link rel="stylesheet" href="hi.css">
</head>
<h2></h2>
<body>
	<p><a href="Logout"> Logout </a></p>
	<table>
		<tr>
			<th><h2>Recipes Available</h2></th>
		</tr>
		<c:forEach items="${userRecipes}" var="RecipesValue">
	    <tr>
	        <td><a href="GetRecipe?recipeName=${RecipesValue.recipeName}">${RecipesValue.recipeName}</a></td>
	        <td><img alt="" src="${RecipesValue.image}" style="width: 200px; height: 200px;"></td>
	    </tr>
	  </c:forEach>
	</table>
<br> <a href="Home.jsp"> Home Page </a> <br>
</body>
</html>