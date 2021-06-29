<!doctype html>
<html lang="en">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="common/BootstrapLibarary.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable({

			"scrollY" : "250px",
			"scrollCollapase" : true,

		});
	});
</script>

</head>
<body>
	<%@page import="java.util.*"%>
	<%@page import="com.bean.*"%>

	<%-- 
	<%
		Set<Todos> todolist = (Set<Todos>) request.getAttribute("todolist");
	%>
	<%
		if (todolist == null) {
	%>
	<jsp:forward page="login.jsp" />
	<%
		}
	%> --%>

	<jsp:include page="common/HomeHeader.jsp"></jsp:include>


	<div class="container" style="margin-top: 30px;">
		<div class="row">
			<div class="col offset-md-8  text-right">
				<a href="<%=request.getContextPath()%>/TodoListEdit.jsp"
					class="btn btn-primary">Add TODO</a>
			</div>
		</div>
		<div class="row">
			<div class="col">

				<table id="example"
					class="table table-striped table-bordered margin-top:20px">
					<thead>
						<th>Id</th>
						<th>title</th>
						<th>description</th>
						<th>Target Date</th>
						<th>Action</th>
					</thead>

					<tbody>

						<c:forEach var="todo1" items="${ todolist}">

							<tr>
								<td><c:out value="${todo1.getTodo_id()}" /></td>
								<td><c:out value="${todo1.getTitle()} " /></td>
								<td><c:out value="${todo1.getDescriptions()} " /></td>
								<td><c:out value="${todo1.getTarget_date()} " /></td>
								<td><a
									href='updateTodo?todoid=<c:out value='${todo1.getTodo_id()}'></c:out>'>edit/</a>
									<a
									href='deletetodo?todoid=<c:out value='${todo1.getTodo_id()}'></c:out>'>delete</a></td>
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