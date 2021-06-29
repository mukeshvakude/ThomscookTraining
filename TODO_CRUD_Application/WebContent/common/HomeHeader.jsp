
	<nav class="navbar navbar-expand-md navbar-light"
		style="background-color: #00AA9E;">
		<a class="navbar-brand" href="#"> <img src="img/thomascook.jpg"
			height=40px width=60px></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/home"
					class="nav-link text-white">Home</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/getAllTodos"
					class="nav-link text-white">Todos</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="#" data-toggle="modal" data-target="#exampleModal"
					class="nav-link text-white">AddPost</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="AllPost.jsp" 
					class="nav-link text-white">AllPost</a></li>
			</ul>
			<ul class="navbar-nav navbar-collapse justify-content-end">

				<li class="nav-item"><a class="nav-link text-white"> <span
						class="fa fa-user-circle"></span>${user.username}
				</a></li>
				<li class="nav-item"><a class="nav-link text-white"
					href="<%=request.getContextPath()%>/logout"> <span
						class="fas fa-arrow-circle-right"></span>Logout
				</a></li>

			</ul>
		</div>
	</nav>


<!--  Model call-->
<%@include file="newPost.jsp" %>

