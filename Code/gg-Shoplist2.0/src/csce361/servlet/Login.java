package csce361.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csce361.model.DBAccess;
import csce361.model.Users;

public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login(){
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		DBAccess db = new DBAccess();
		Users user = db.login(userName, password);
		ArrayList<String> ingredientList=db.ingredientList();
		//from linlin
		if(user != null){
			session.setAttribute("user", user);
			session.setAttribute("selectList", ingredientList);
			response.sendRedirect("LoginSuccess.jsp");
		}else{
			out.println("User Does Not Exist");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

}
