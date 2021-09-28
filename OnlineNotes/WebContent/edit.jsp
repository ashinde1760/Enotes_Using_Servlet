<%@page import="com.User.Notes"%>
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
<title>Edit Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>

	<%
		Integer note_id = Integer.parseInt(request.getParameter("note_id"));

		UserDAO ud = new UserDAO(DBConnect.getConn());

		Notes nt1 = ud.getDataById(note_id);
	%>

	<div class="container-fluid">
		<%@include file="all_component/navbar.jsp"%>
		<h2 class="text-center mt-3">Edit Your Notes</h2>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="EditNotes" method="post">
						<div class="form-group">

							<input type="hidden" value="<%=note_id%>" name="note_id">

							<label for="exampleInputEmail1">Enter Ttile</label> 
							<input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" required="required"
								value="<%=nt1.getTitle()%>">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="8" cols="" class="form-control" name="content"
								required="required"><%=nt1.getContent()%></textarea>
						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary mt-3 mb-3">Add
								Note</button>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>


</body>
</html>