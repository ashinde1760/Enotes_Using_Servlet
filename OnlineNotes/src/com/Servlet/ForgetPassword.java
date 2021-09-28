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

@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String lpass=request.getParameter("lpass");
		
		
		UserDAO ud=new UserDAO(DBConnect.getConn());
		
		boolean result=ud.forgetPassword(email,lpass);
		HttpSession session;
		if(result)
		{
			session=request.getSession();
			session.setAttribute("email",email);
			response.sendRedirect("changePassword.jsp");
		}
		else
		{
			session=request.getSession();
			session.setAttribute("incorrectPass","Incorrect password...!!!");
			response.sendRedirect("forgetPassword.jsp");
		}
		
		
	}

}
