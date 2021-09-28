package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		UserDetails ud=new UserDetails();
		ud.setEmail(email);
		ud.setPassword(password);
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		UserDetails user=dao.loginUser(ud);
		HttpSession session;
		if(user!=null)
		{
			session=request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("home.jsp");
		}
		else
		{
			session=request.getSession();
			session.setAttribute("loginFailed","Incorrect username or password...!!!");
			response.sendRedirect("login.jsp");
		}
	}

}
