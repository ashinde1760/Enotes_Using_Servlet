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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer note_id=Integer.parseInt(request.getParameter("note_id"));
		UserDAO ud=new UserDAO(DBConnect.getConn());
		
		boolean result=ud.deleteNote(note_id);
		
		HttpSession session=null;
		if(result)
		{
			session=request.getSession();
			session.setAttribute("update_note","Note Deleted Successfully");
			response.sendRedirect("showNotes.jsp");
		}
		else
		{
			session=request.getSession();
			session.setAttribute("wrong_msg","Something went wrong");
			response.sendRedirect("showNotes.jsp");
		}
		
	}

}
