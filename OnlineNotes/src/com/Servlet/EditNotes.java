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

@WebServlet("/EditNotes")
public class EditNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer note_id = Integer.parseInt(request.getParameter("note_id"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			PrintWriter out = response.getWriter();
			UserDAO ud = new UserDAO(DBConnect.getConn());
			boolean result = ud.updateNotes(note_id, title, content);

			if (result = true) {
				HttpSession session=request.getSession();
				session.setAttribute("update_note","Note Updated Successfully");
				response.sendRedirect("showNotes.jsp");
				
				
			} else {
				out.println("Something went wrong");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
