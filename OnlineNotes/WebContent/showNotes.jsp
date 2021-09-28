<%@page import="com.User.Notes"%>
<%@page import="java.util.List"%>
<%@page import="com.Db.DBConnect"%>
<%@page import="com.DAO.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	UserDetails ud1 = (UserDetails) session.getAttribute("user");

	if (ud1 == null) {
		response.sendRedirect("login.jsp");
		//session.setAttribute("login_error", "Please Login...!!");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<%
		String update_note=(String)session.getAttribute("update_note");
	
		if(update_note!=null)
		{
	%>
	
		<div class="alert alert-success" role="alert"><%=update_note%></div>	

	<%	
		session.removeAttribute("update_note");
		}
	%>
	
	<%
		String wrong_msg=(String)session.getAttribute("wrong_msg");
	
		if(wrong_msg!=null)
		{
	%>
	
		<div class="alert alert-danger mx-auto" role="alert"><%=wrong_msg%></div>	

	<%	
		session.removeAttribute("wrong_msg");
		}
	%>
	
	<div class="container">
		<h2 class="text-center mt-3">All Notes</h2>
		<div class="row">
			<div class="col-md-12">

				<%
					if (ud1 != null) {
						UserDAO ud = new UserDAO(DBConnect.getConn());
						List<Notes> notes = ud.getData(ud1.getId());
						for (Notes nt1 : notes) {
				%>

				<div class="card ml-5 mr-5 mt-3">
					<img alt="" src="image/paper.png" class="card-img-top mt-2 mx-auto"
						style="max-width: 100px;">
					<div class="card-body p-4">

						<h5 class="card-title"><%=nt1.getTitle()%></h5>
						<p><%=nt1.getContent()%></p>

						<p>
							<b class="text-success">Published By:<%=ud1.getName()%></b></br> <b
								class="text-primary"></b>
						</p>

						<p>
							<b class="text-success">Published Date:<%=nt1.getDate()%></b></br> <b
								class="text-success"></b>
						</p>

						<div class="container text-center mt-2">
						
							<a href="DeleteServlet?note_id=<%=nt1.getId() %>" 
							class="btn btn-danger">delete</a> <a
							
								href="edit.jsp?note_id=<%=nt1.getId()%>"
								class="btn btn-primary">Edit</a>
						</div>


					</div>

				</div>

				<%
					}
					}
				%>

			</div>
		</div>
	</div>



</body>
</html>