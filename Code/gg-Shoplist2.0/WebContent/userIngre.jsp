<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Ingredients</title>
<link rel="stylesheet" href="hi.css">
</head>
<body>
<p><a href="Logout"> Logout </a></p>
<h2>
	<p>${addIngreResult}</p>
</h2>

	<!-- <input type="text" name="userIngreName" id="userIngreName"/> -->
	<table align="center">
		<tr>
			<th>	<h3>Your Ingredients:</h3></th>
		</tr>
		<c:forEach items="${userIngreList}" var="IngreValue">
	    <tr>
	        <td><h3>${IngreValue}</h3></td>
      		<td> <form action="DeleteUserIngre"> <input type="hidden" name="userIngreName" value="${IngreValue}"/>
      		<input type=submit value="delete" name=Delete></form>
      		</td>
	    </tr>
	  </c:forEach>
	</table>
	<form action="GetRecipeList"> 
      		<input type=submit value="GetRecipes" name=GetRecipes></form>
<a href="Home.jsp"> Home Page </a> <br>
</body>
</html>