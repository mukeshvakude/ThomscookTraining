<head>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link href="css/mystyle.css" rel="stylesheet" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Icone css like user fas fa -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable({

			"scrollY" : "300px",
			"scrollCollapase" : true,

		});
	});
</script>
</head>

<html>
<body>
<%@page import="java.util.*"%>
	<%@page import="com.bean.*"%>


	<%
		Set<User> userlist = (Set<User>) request.getAttribute("userlist");
	
	%>
	
	<jsp:include page="HomeHeader.jsp"></jsp:include>

	<main class="d-flex align-items-center">
	<div class="container">
		<div class="row">
		
			<div class="col offset-md-8  text-right">

				<a href="<%=request.getContextPath()%>/registration.jsp"
					class="btn btn-success ">Add User</a>
			</div>
		</div>

		<div class="row">
			<div class="col">

				<table id="example"
					class="table table-striped table-bordered margin-top:30px">
					<thead>
						<th>Id</th>
						<th>Username</th>
						<th>Mail</th>
						<th>Mobile</th>
						<th>Action</th>
						
					</thead>
					<tbody>
					   <%--  <c:forEach var="user" begin="1" end="10"> --%>
						<%
						for (User user : userlist) {
						%>
						<tr>
							<td><%=user.getId()%></td>
						<td><%=user.getUsername()%></td>
						<td><%=user.getEmail()%></td>
						<td><%=user.getMobileNumber()%></td>
						<td><a href='edit?id=<%=user.getId()%>'>edit/</a> <a
							href='delete?id=<%=user.getId()%>'>delete</a></td>
						</tr>
						<%} %>
						<%-- </c:forEach> --%>
					</tbody>
					<tfoot>
						<tr>
							<th>Name</th>
							<th>Position</th>
							<th>Office</th>
							<th>Age</th>
							<th>Start date</th>
							
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>


	</main>
	<jsp:include page="loginfooter.jsp"></jsp:include>
</body>
</html>