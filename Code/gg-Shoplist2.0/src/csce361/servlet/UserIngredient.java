package csce361.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csce361.model.DBAccess;
import csce361.model.Users;

/**
 * Servlet implementation class UserIngredient
 */
public class UserIngredient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserIngredient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubString userName = request.getParameter("userName");
		String userIngreName = request.getParameter("userIngreName");
		HttpSession session = request.getSession();
		Users user=(Users) session.getAttribute("user");
		DBAccess db = new DBAccess();
		String result=db.addUserIngredient(userIngreName,user);
		ArrayList<String> ingredientList=db.getUserIngredient(user);
		session.setAttribute("userIngreList", ingredientList);
		session.setAttribute("addIngreResult", result);
		response.sendRedirect("userIngre.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
