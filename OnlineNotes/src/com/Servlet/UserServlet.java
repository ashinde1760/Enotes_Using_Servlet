package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String name=request.getParameter("fname");
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		
		//if()
		
		
		
		
		
		UserDetails ud=new UserDetails();
		ud.setName(name);
		ud.setEmail(email);
		ud.setPassword(password);
		
		PrintWriter out=response.getWriter();
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		boolean result=dao.addUser(ud);
		HttpSession session;
		if(result==true)
		{
			session=request.getSession();
			session.setAttribute("regSuccess","Registration Successfully Done...!!!");
			response.sendRedirect("register.jsp");
		}
		else
		{
			session=request.getSession();
			session.setAttribute("regFailed","Something went Wrong...!!!");
			response.sendRedirect("register.jsp");
		}
	}
}
