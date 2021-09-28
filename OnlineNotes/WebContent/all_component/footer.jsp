
<%@page import="com.User.UserDetails"%>
<%
			UserDetails user3=(UserDetails)session.getAttribute("user");
			if (user3 != null) {
%>

<div class="container-fluid bg-dark ">
<p class="text-center text-white">
	Note: Any error occures then contact at dildarakki@gmail.com
			</p>
<p class="text-center text-white">				Designed and developed by Akshay Shinde
	</p>			
<p class="text-center text-white">
	All rights Reserved @Akshay_Shinde 2021-22
</p>

</div>
<%
}
			else
			{
%>
<div class="container-fluid bg-dark mb-5">
<p class="text-center text-white">
	Note: Any error occures then contact at dildarakki@gmail.com
			</p>
<p class="text-center text-white">				Designed and developed by Akshay Shinde
	</p>			
<p class="text-center text-white">
	All rights Reserved @Akshay_Shinde 2021-22
</p>

</div>
<%
	}
%>
