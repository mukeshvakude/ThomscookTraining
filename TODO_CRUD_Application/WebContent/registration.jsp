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
	<!--  navbar -->
	
	<jsp:include page="common/loginheader.jsp"></jsp:include>
	
	
	<div class="container ">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header  text-center color-black" style="background-color: #00AA9E;">
						<span class="fa fa-user-plus fa-3x"></span>Register here
					</div>
					<div class="card-body">
						<form action="registration" method="post" id="register_form">
							<div id="msg" class="text-center"></div>
							<div class="form-group">
								<label for="uname">User Name:</label> <input type="text"
									class="form-control" id="username" name="username" required>
							</div>

							<div class="form-group">
								<label for="password">Password:</label> <input type="password"
									class="form-control" id="password" name="password" required>
							</div>

							<div class="form-group">
								<label for="email">Email:</label> <input type="text"
									class="form-control" id="email" name="email" required>
							</div>

							<div class="form-group">
								<label for="">Mobile Number:</label> <input type="text"
									class="form-control" id="mobileNumber" name="mobileNumber"
									required>
							</div>

							<div class="text-center">
							<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>
	</div>
	
	<jsp:include page="common/loginfooter.jsp"></jsp:include>
	<script>
	
		$(document).ready(function(){
			
			console.log("page working");
			$("#register_form").on('submit',function(event){
				event.preventDefault();
				console.log("here");
				var f= $(this).serialize();
				console.log(f);
				$.ajax({
					url:"registration",
					data:f,
					type:"POST",
					success:function(data,textStatus,jqXHR){
						console.log(data);
						console.log("success"+data);
						if(data.trim() === "done"){
							let html_message = "<div class='alert alert-success' role='alert'>succesfully register</div>";
								
							$("#msg").html(html_message);
							
						}else{
							let html_message = "<div class='alert alert-danger' role='alert'>"+data+"</div>";
							$("#msg").html(html_message);
							document.getElementById("register_form").reset(); 
						}
					},
					error:function(jqXHR,textStatus,errorThrown){
						$("#msg").html("something went wrong on server");
					}
				});
			});
		});
	
	</script>
</body>
</html>