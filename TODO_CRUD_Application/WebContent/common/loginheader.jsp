<header>
<nav class="navbar navbar-expand-md navbar-light" style="background-color: #00AA9E;">
	<a class="navbar-brand" href="#"> <img src="img/thomascook.jpg" height=40px width=60px></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav navbar-collapse justify-content-end">
				<!-- <ul class="navbar-nav  justify-content-end"> -->
				<li class="nav-item"><a class="nav-link text-white"
					href="<%=request.getContextPath()%>/login.jsp"><span
						class="fa fa-user-circle"></span>login</a></li>
				<li class="nav-item"><a class="nav-link text-white "
					href="<%=request.getContextPath()%>/registration.jsp"><span
						class="fa fa-user-plus"></span>signup</a></li>
			</ul>
		</div>
	</nav>
</header>