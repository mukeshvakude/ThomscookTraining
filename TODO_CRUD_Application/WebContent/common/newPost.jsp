
<%@page import="com.dao.*"%>
<%@page import="com.services.*"%>
<%@page import="com.bean.*"%>
<%@page import="java.util.*"%>

<%
CategoriesDaoImplementation catdao = new CategoriesDaoImplementation();
CategoriesServices catservice = new CategoriesServiceImlementation(catdao);
List<Categories> categories = catservice.getAllCategories();
%>
<!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Post Details</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="addPost" method="post" id="addPostForm" enctype="multipart/form-data">
					<div class="form-group">
						<select name="catId" class="form-control">
							<option selected disabled>---select category---</option>
							<% for(Categories cat: categories) 
	        				{%>
							<option value="<%= cat.getCat_id()%>"> <%= cat.getCat_title() %></option>
							<% } %>
						</select>
					</div>
					<div class="form-group">
						<input type="text" name="postTitle" placeholder="Enter Post title"
							class="form-control" />
					</div>
					<div class="form-group">
						<textarea class="form-control" name="postDescription"
							placeholder="Enter Title Description" style="height: 200px"></textarea>
					</div>
					<div class="form-group">
						<label>Select your picture..</label> <br> <input
							name="postImage" type="file" />
					</div>
					<div class="container text-center">
					<button type="submit" class="btn btn-outline-primary">post</button>
					</div>
				</form>
			</div>
			
		</div>
	</div>
</div>

<!-- Add post JS And AJAX call -->
<script>
$(document).ready(function(){
	
	$("#addPostForm").on("submit",function(event){
		//this code call when form submitted
		event.preventDefault();
		let form = new FormData(this);
		console.log("hello i am header to load the post");
		// now request to server
		$.ajax({
					url:"addPost",
					data:form,
					type:"POST",
					success:function(data,textStatus,jqXHR){
						console.log(data);
						if(data.trim() === "done"){
							
							swal("Good job!", "save succesfully", "success");
						}else{
							swal("Not Uploaded", "Something went wrong...", "error");
						}
						
					},
					error:function(jqXHR,textStatus,errorThrown){
						swal("Error!", "Something went wrong...", "error");
					},
					processData:false,
					contentType:false  
		})
	})			
})
</script>