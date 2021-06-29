<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<jsp:include page="BootstrapLibarary.jsp"></jsp:include>
</head>
<body>
<%@page import="java.util.*"%>
<%@page import="com.bean.*"%>
<% User user = (User) request.getAttribute("user"); %>
	
<jsp:include page="common/HomeHeader.jsp"></jsp:include>

 <div class="container col-md-8 col-md-offset-3" style="overflow: auto">
            <h1>Edit Form</h1>
            <form action="edit" method="post">
					
				<div class="form-group">
                  <input type="hidden" class="form-control" value = <%= user.getId() %> id="id" name="id" >
                </div>
                <div class="form-group">
                  <input type="hidden" class="form-control" value = <%= user.getPassword() %> id="password" name="password" >
                </div>
                <div class="form-group">
                    <label for="uname">User Name:</label> <input type="text" class="form-control" value = <%= user.getUsername() %> id="username" placeholder="User Name" name="username"  required>
                </div>
 				<div class="form-group">
                    <label for="email">Email:</label> <input type="text" class="form-control" value = <%= user.getEmail() %> id="email" placeholder="Usermail" name="email" required>
                </div>

                <div class="form-group">
                    <label for="uname">Mobile Number:</label> <input type="text" class="form-control" value = <%= user.getMobileNumber() %> id="mobileNumber" placeholder="Mobile number" name="mobileNumber" required>
                </div>
			

                <button type="submit" class="btn btn-primary">Submit</button>
            	
            </form>
        </div>
<jsp:include page="common/loginfooter.jsp"></jsp:include>
</body>
</html>