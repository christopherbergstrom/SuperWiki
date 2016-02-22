<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_head.jsp"></jsp:include>
<title>Update ${character.name}</title>
</head>
<body>
<jsp:include page="_nav.jsp"></jsp:include>
	<div class="updatecharacter">
	<p>Logged in as: ${user.username}</p>
	<h1>Update - ${character.name}</h1>
	<form action="updateCharacter.do" method="post">
	<div class="form-group">
	<input type="hidden" name="id" class="form-control" value="${character.id }"/>
			Name:<input type="text" class="form-control" name="name" value="${character.name}"/>
	</div>
		<br>
			<div class="form-group">
			Alias:<input type = "text" class="form-control" name = "alias" value="${character.alias}"/>
			</div>
		<br>
			<div class="form-group">
			Creator:<input type="text" class="form-control" name="creator" value="${character.creator }"/>
			</div>
			
			<div class="form-group">
			First Appearance:<input type="text" class="form-control" name="firstAppearance" value="${character.firstAppearance }"/>
			</div>
			
			<%-- <div class="form-group">
			Team Name:<input type="text" class="form-control" name="team" value="${character.team}"/>
			</div> --%>
		<br>
			<div class="form-group">
			Origin:<textarea rows="4" class="form-control" cols="100" name="origin">${character.origin} </textarea>
			</div>
		<br>
		<div class="form-group">
		Publisher:<input type="text" class="form-control" name="publisher" value="${character.publisher }"/>
		</div>
		<br>
		<br>
		<div class="form-group">
		Image:<input type="text" class="form-control" name="image" value="${character.image }">
		</div>
		<br>
		<div class="form-group">
		<input type="radio" name="good" value="true" checked="checked">superhero
		<input type="radio" name="good" value="false">villain
		<input type = "submit" class = "btn btn-default" value = "Update"/>
		</div>
	</form>
	</div>
<div class="banner">

        <div class="container">

            <div class="row">
                <div class="col-lg-6">
                    <h2>Connect to SuperWiki:</h2>
                </div>
                <div class="col-lg-6">
                    <ul class="list-inline banner-social-buttons">
                        <li>
                            <a href="https://twitter.com/theSuperWiki" target="_blank" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                        </li>
                        <li>
                            <a href="https://github.com/Sokos6/SuperWiki" target="_blank" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>
                        </li>
                        <li>
                            <a href="https://www.facebook.com/SuperWiki-1511957842442437/" target="_blank" class="btn btn-default btn-lg"><i class="fa fa-facebook fa-fw"></i> <span class="network-name">Facebook</span></a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
</body>
</html>

