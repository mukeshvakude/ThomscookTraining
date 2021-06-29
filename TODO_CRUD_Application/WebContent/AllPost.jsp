<!doctype html>
<html lang="en">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="common/BootstrapLibarary.jsp"%>
</head>

<body>

	<%@page import="com.dao.*"%>
	<%@page import="com.services.*"%>
	<%@page import="com.bean.*"%>
	<%@page import="java.util.*"%>


	<%
		CategoriesDaoImplementation catdao = new CategoriesDaoImplementation();
		CategoriesServices catservice = new CategoriesServiceImlementation(catdao);
		List<Categories> categories = catservice.getAllCategories();
	%>
	<jsp:include page="common/HomeHeader.jsp"></jsp:include>


	<div class="container">


		<div class="row mt-4">
			<!-- first column -->
			<!-- Categories column -->
			<div class="col-md-4 ">
				<div class="list-group">
					<a href="javascript:void(0)" onclick="GetAllPosts(<%=0%>,this)"
						class=" c-link list-group-item list-group-item-action active">All
						Categories</a>
					<%
						for (Categories cat : categories) {
					%>
					<a href="javascript:void(0)" onclick="GetAllPosts(<%=cat.getCat_id()%>,this)"
						class="c-link list-group-item list-group-item-action"> <%=cat.getCat_title()%>
					</a>
					<%
						}
					%>

				</div>
			</div>
			<!-- Second column -->
			<div class="col-md-8">
				<div class="container text-center" id="loader">
					<i class="fas fa-sync fa-3x fa-spin"></i>
					<h3>loading...</h3>
				</div>
				<div class="container" id="post-container"></div>
			</div>

		</div>
	</div>
	<jsp:include page="common/loginfooter.jsp"></jsp:include>


	<!-- Add post JS And AJAX call -->
	<script>
/* Like and Dislike Ajax Call */
function LikePost(postId,user_id,action){
	
	$.ajax({
		url:"LikePost",
		type:"post",
		data:{postId : postId,user_id : user_id,action:action},
		success:function(data1,textStatus,jqXHR){
			
			let obj = JSON.parse(data1);
				console.log(obj['data']);
				$("#like_"+postId).html(obj['data'].liked);
				$("#dislike_"+postId).html(obj['data'].disliked);
			
		},
		error:function(jqXHR,textStatus,errorThrown){
			console.log(postId);
			swal("Error!", "Something went wrong...", "error");
		},
	
});
}
function GetAllPosts(cat_id,refrenceObj){
	
	/* making the list active  */
	$(".c-link").removeClass('active');
	$.ajax({
		url:"LoadAllpost.jsp", /* calling Load Ajaxpost.jsp file */
		data:{cat_id : cat_id},
		success:function(data,textStatus,jqXHR){
			
			$("#loader").hide();
			$("#post-container").html(data);
			$(refrenceObj).addClass('active');
		},
		error:function(jqXHR,textStatus,errorThrown){
			
			swal("Error!", "Something went wrong...", "error");
		},
		
	});	

}
$(document).ready(function(){
	/* active by default link */
	let allPostRefrence = $('.c-link')[0];
	
	GetAllPosts(0,allPostRefrence);	
});
</script>
</body>
</html>