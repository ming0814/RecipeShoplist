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
public class GetRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRecipe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String recipeName = request.getParameter("recipeName");
		System.out.println(recipeName);
		HttpSession session = request.getSession();
		DBAccess db = new DBAccess();
		Recipe thisRecipe=db.getRecipe(recipeName);
		if(thisRecipe != null){
			session.setAttribute("recipe", thisRecipe);
			response.sendRedirect("Recipe.jsp");
		}else{
			response.getWriter().println("No result for this recipe");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
