<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Pasword</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<%
		String email = (String) session.getAttribute("email");
	%>


	<div class="container-fluid back-img mt-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-circle-o fa-3x" aria-hidden="true"></i>
						<h3>Reset Password</h3>
					</div>

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
						<form action="ChangePassword" method="post">
							<input type="hidden" value="<%=email%>" name="email">

							<div class="form-group">
								<label for="exampleInputEmail1">Enter New Password</label> <input
									type="password" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="npass" required="required">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Confirm Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name=cpass required="required">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block mt-3">CONFIRM</button>
						</form>
					</div>
				</div>
				<div class="mb-5"></div>
			</div>
		</div>
	</div>
	<div class="mb-5"></div>

</body>
<%@include file="all_component/footer.jsp"%>
</html>