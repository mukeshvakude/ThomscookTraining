<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="BootstrapLibarary.jsp"></jsp:include>
<title>Error</title>
</head>
<body>
 
 <div class="container text-center">
 	<img alt="" src="img/error.png" class="img-fluid">
 	<h3>Sorry ! Something went wrong</h3>
 	<%= exception %>
 	<a href="login.jsp" class="btn" style="background-color: #00AA9E;">Home</a>
 </div>
</body>
</html>