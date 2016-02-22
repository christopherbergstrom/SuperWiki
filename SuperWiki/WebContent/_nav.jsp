<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-default navbar-fixed-top topnav"
	role="navigation">
	<div class="container topnav">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand topnav" href="home.jsp">SuperWiki</a>
		</div>
		<div>
			 <form class="navbar-form navbar-left" role="search" action="select.do">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" name="text">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="allCharacters.do">All Characters</a></li>
				<li><a href="allSuperheroes.do">Superheroes</a></li>
				<li><a href="allVillains.do">Villains</a></li>
				<li><a href="addSuperhero.do">Add Character</a></li>
				<c:choose>
					<c:when test="${user.id!=2 && user !=null}">
						<li><a href = "profile.do">My Account</a></li>
						<li><a href="logout.do">Logout</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="addUser.do">Register</a></li>
						<li><a href="login.do">Login</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>