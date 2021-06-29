<!doctype html>
<html lang="en">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="common/BootstrapLibarary.jsp" %>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable({

			"scrollY" : "350px",
			"scrollCollapase" : true,

		});
	});
</script>

</head>


<body>
	<%@page import="java.util.*"%>
	<%@page import="com.bean.*"%>

	<jsp:include page="common/HomeHeader.jsp"></jsp:include>


	<div class="container" style="margin-top: 30px;">

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
						<c:forEach items="${userlist}" var="userobj">

							<tr>
								<td><c:out value="${userobj.getId()}" /></td>
								<td><c:out value="${userobj.getUsername()}" /></td>
								<td><c:out value="${userobj.getEmail()}" /></td>
								<td><c:out value="${userobj.getMobileNumber()}" /></td>
								<td><a href='edit?id=<c:out value="${userobj.getId()}" />'>edit/</a>
									<a href='delete?id=<c:out value="${userobj.getId()}" />'>delete</a></td>
							</tr>

						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>
	<jsp:include page="common/loginfooter.jsp"></jsp:include>
</body>
</html>