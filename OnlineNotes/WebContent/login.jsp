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
<title>Login Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid back-img">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-circle-o fa-3x" aria-hidden="true"></i>
						<h3>Login</h3>
					</div>

					<%
						String loginFailed = (String) session.getAttribute("loginFailed");
						if (loginFailed != null) {
					%>

					<div class="alert alert-danger" role="alert"><%=loginFailed%></div>
					<%
						session.removeAttribute("loginFailed");
						}
					%>

					<%
						String login_error = (String) session.getAttribute("login_error");
						
						if (login_error != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=login_error%></div>
					<%
						session.removeAttribute("loginFailed");
						}
					%>

					<%
						String logout_msg = (String) session.getAttribute("logout_msg");
						if (logout_msg != null) {
					%>
					<div class="alert alert-success" role="alert"><%=logout_msg%></div>

					<%
						session.removeAttribute("logout_msg");
						}
					%>

				
					<%
						String changePass = (String) session.getAttribute("changePass");
						
						if (changePass != null) {
					%>
					<div class="alert alert-success" role="alert"><%=changePass%></div>
					
					<%
						session.removeAttribute("changePass");
						}
					%>
					
					
				
					<%
						String error = (String) session.getAttribute("error");
						
						if (error != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=error%></div>
					<%
						session.removeAttribute("error");
						}
					%>
					
					
					


					<div class="card-body">
						<form action="LoginServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Email</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uemail" required="required">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name=upassword required="required">
							</div>
							<div>
								<h6 class="text-center mt-3"><a href="forgetPassword.jsp">ForgetPassword</a></h6>
							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block mt-3">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="all_component/footer.jsp"%>
</body>
</html>