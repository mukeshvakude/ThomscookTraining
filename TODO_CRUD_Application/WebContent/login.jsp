<!doctype html>
<html lang="en">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="common/BootstrapLibarary.jsp" %>
</head>
<body>
	<%@page import="java.util.*"%>
	<%@page import="com.bean.*"%>
	<%@include file="common/loginheader.jsp" %>
	<!-- container  -->
	<div class="container" style="margin-top: 50px">

		<div class="row">
			<div class="col-md-4 offset-md-4">


				<div class="card">
					<div class="card-header  text-center text-white"
						style="background-color: #00AA9E;">

						<i class="fas fa-users " style='font-size: 30px'></i>
						<div>login here</div>
					</div>
					<c:if test="${message != null }">
						<div class='alert <c:out value="${message.getCssClass()}"/>'
							role='alert'>
							<div class="text-center">
								<c:out value="${ message.getContent()}" />
							</div>
						</div>
					</c:if>
					<div class="card-body">
						<%
							session.removeAttribute("message");
						%>
						<form action="login" method="post">

							<div class="form-group">
								<label for="uname">User Name:</label> <input type="text"
									class="form-control" id="username" 
									name="username" required>
							</div>

							<div class="form-group">
								<label for="uname">Password:</label> <input type="password"
									class="form-control" id="password" 
									name="password" required>
							</div>
							<div class="text-center ">
								<button type="submit" class="btn text-white"
									style="background-color: #00AA9E;">Login</button>
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>
	</div>
	<!-- container end -->
<jsp:include page="common/loginfooter.jsp"></jsp:include>
</body>
</html>