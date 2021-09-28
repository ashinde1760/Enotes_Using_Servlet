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
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String npass=request.getParameter("npass");
		String cpass=request.getParameter("cpass");
		String email=request.getParameter("email");
		HttpSession session;
		if(npass.equals(cpass))
		{
			UserDAO ud=new UserDAO(DBConnect.getConn());
			boolean result=ud.changePassword(email,npass);
			
			if(result)
			{
				session=request.getSession();
				session.setAttribute("changePass","Password change Successfully, Please login...!!");
				response.sendRedirect("login.jsp");
			}
			else
			{
				session=request.getSession();
				session.setAttribute("error","Password does not change");
				response.sendRedirect("login.jsp");
			}
		}
		else
		{
			session=request.getSession();
			session.setAttribute("error","Password does not Match");
			response.sendRedirect("changePassword.jsp");
		}
	}

}
