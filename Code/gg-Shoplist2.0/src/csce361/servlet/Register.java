package csce361.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csce361.model.Users;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register(){
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		Users aUser = new Users(userName, password);

		PrintWriter out = response.getWriter();
		if(aUser.validateUserByUsername(aUser.getUserName()) == true){
			out.println("User already exists");
		}else{
			// Register the Users object
			aUser.registerUser(aUser);
		}
		response.sendRedirect("Welcome.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
