package csce361.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csce361.model.DBAccess;
import csce361.model.Recipe;

public class Show extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String ingredientName = request.getParameter("ingredientName");
		DBAccess db = new DBAccess();
		ArrayList<Recipe> recipelist = db.getRecipes(ingredientName);
		if(recipelist.size() != 0){
			request.getSession().setAttribute("recipelist", recipelist);
			response.sendRedirect("SearchRecipeList.jsp");
		}else{
			response.getWriter().println("No result for this ingredient");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
