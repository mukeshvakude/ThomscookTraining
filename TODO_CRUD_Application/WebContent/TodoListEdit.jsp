<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

<title>Todo</title>
<jsp:include page="BootstrapLibarary.jsp"></jsp:include>

</head>

<body>
	<%@page import="com.bean.*"%>

	<jsp:include page="common/HomeHeader.jsp"></jsp:include>

	<div class="container" style="margin-top: 30px">

		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<c:if test="${todo != null}">
							<form action="updateTodo" method="post">
						</c:if>

						<c:if test="${todo == null}">

							<form action="insertTodo" method="post">
						</c:if>
						<c:if test="${todo != null}">
							<caption>
								<div class="text-center">
									<h2>
										Edit Todo
									</h2>
								</div>
							</caption>
						</c:if>
						<c:if test="${todo == null}">
							<caption>
								<div class="text-center">
									<h2>Add New Todo</h2>
								</div>
							</caption>
						</c:if>


						<c:if test="${todo != null}">
							<input type="hidden" name="todoid"
								value="<c:out value='${todo.todo_id}' />" />
							<input type="hidden" name="userid"
								value="<c:out value='${todo.user_id}' />" />
						</c:if>

						<fieldset class="form-group">
							<label>Todo Title</label> <input type="text"
								value="<c:out value='${todo.title}' />" class="form-control"
								name="title" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>Todo Decsription </label> <input type="text"
								value="<c:out value='${todo.descriptions}' />"
								class="form-control" name="description">
						</fieldset>

						<fieldset class="form-group">

							<label>Todo Status</label> <select class="form-control"
								name="isDone">
								<option value="false"
									${todo.isStatus() == false ? 'selected' : ''}>In Progress</option>
								<option value="true"
									${todo.isStatus() == true ? 'selected' : ''}>Complete</option>
							</select>
						</fieldset>

						<fieldset class="form-group">
							<label>Todo Target Date</label> <input type="date"
								value="<c:out value='${todo.target_date}' />"
								class="form-control" name="targetDate" required="required">
						</fieldset>
						<div class="text-center">
							<button type="submit" class="btn btn-primary">Save</button>
						</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="common/loginfooter.jsp"></jsp:include>

</body>
</html>