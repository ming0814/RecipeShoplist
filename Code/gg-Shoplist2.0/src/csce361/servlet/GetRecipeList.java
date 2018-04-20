package csce361.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csce361.model.DBAccess;
import csce361.model.Recipe;
import csce361.model.Users;

/**
 * Servlet implementation class GetRecipe
 */
public class GetRecipeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRecipeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println();
		HttpSession session = request.getSession();
		Users user=(Users) session.getAttribute("user");
		DBAccess db = new DBAccess();
		ArrayList<Recipe> userRecipes=db.getRecipes(user);
		session.setAttribute("userRecipes", userRecipes);
		System.out.println(userRecipes);
		response.sendRedirect("RecipeList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
