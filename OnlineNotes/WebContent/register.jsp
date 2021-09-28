<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.back-img {
	background: url("image/homepage.jpg");
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid back-img">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
						<h3>Registration</h3>
					</div>


					<%
						String regMsg = (String) session.getAttribute("regSuccess");
						if (regMsg != null) {
					%>
					<div class="alert alert-success" role="alert"><%=regMsg%>To login<a href="login.jsp">Click here</a></div>
					<%
						session.removeAttribute("regSuccess");
						}
					%>


					<%
						String regFailed = (String) session.getAttribute("regFailed");
						if (regFailed != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=regFailed%></div>
					<%
					session.removeAttribute("regFailed");
						}
					%>




					<div class="card-body">
						<form action="UserServlet" method="post">
							<div class="form-group">
								<label">Enter Full Name</label> <input type="text"
									class="form-control" name="fname" required="required">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Email</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uemail" required="required">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name="upassword" required="required">
							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="all_component/footer.jsp"%>
</body>
</html>