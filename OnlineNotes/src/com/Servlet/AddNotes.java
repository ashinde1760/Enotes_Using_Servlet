package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.Notes;

@WebServlet("/AddNotes")
public class AddNotes extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		
		PrintWriter out=response.getWriter();
		UserDAO ud=new UserDAO(DBConnect.getConn());
		boolean result=ud.addNotes(title, content,id);
		if(result)
		{
			response.sendRedirect("showNotes.jsp");
		}
		else
		{
			out.print("Something went wrong");
		}
	
	}

}
