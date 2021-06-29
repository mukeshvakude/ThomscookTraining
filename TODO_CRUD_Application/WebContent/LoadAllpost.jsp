	<!--  All Post Displays -->
	<%@page import="com.dao.*"%>
	<%@page import="com.services.*"%>
	<%@page import="com.bean.*"%>
	<%@page import="java.util.*"%>
	
<div class="row" style=" height: 450px ; width: 800px; overflow:auto">
<%
PostDaoImplementation postdao = new PostDaoImplementation();
PostServices postservice = new PostServicesImplementation(postdao);
int catId =Integer.parseInt( request.getParameter("cat_id"));
User user = (User) session.getAttribute("user");
/* Like Module  */
LikedDaoImplementation likedao = new LikedDaoImplementation();
LikedServices likeservice = new LikedServicesImplementation(likedao);
//Thread.sleep(1000);
List<Post> posts = null;
if(catId == 0) 
	posts = postservice.getAllPost();
	else{
	 posts = postservice.getPostByCategoryid(catId);
} 

if(posts.size() == 0){
	out.println("<h3 class='display-3 text-center'>No Post In this category...<h3>");
	return;
}
for(Post p:posts){
%>

<div class="col-md-6 mt-2">
	<div class="card">
		<img class="card-img-top" src="PostFiles/<%= p.getPostImage() %>" height="110px" width="20px" alt="Card image cap" >
		<div class="card-body">
			<b><%= p.getPostTitle() %></b>
			<p><%= p.getPostDescription() %> </p>
		</div>
		<div class="card-footer">
			<a href="#"  onclick ="LikePost(<%=p.getPost_id() %>,<%= user.getId() %>,'like')" class="btn btn-outline-primary btn-sm"><i class="fa fa-thumbs-up"><span id="like_<%=p.getPost_id() %>">(<%= likeservice.getlikeCount(p.getPost_id()) %>)</span></i></a>
			<a href="#" onclick ="LikePost(<%=p.getPost_id() %>,<%= user.getId() %>,'dislike')" class="btn btn-outline-primary btn-sm"><i class="fa fa-thumbs-down"><span id="dislike_<%=p.getPost_id() %>">(<%= likeservice.getdislikeCount(p.getPost_id())%>)</span></i></a>
			<a href="#" class="btn btn-outline-primary btn-sm">more...</a>
			
		</div>
	</div>

</div>

<%}%>

</div>