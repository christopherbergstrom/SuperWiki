<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_head.jsp"></jsp:include>
<title>Register | SuperWiki</title>
</head>
<body>
<jsp:include page="_nav.jsp"></jsp:include>
<div class="adduser">
<img src="img/Crystal_Project_Add_user.png">
<h1 class="signuptext">Signup for a Free Account Today!</h1>
	<form action="addUser.do" method="post">
		<div class="form-group">
		<label for="username">Username: </label> <input type = "text" name = "username" class="form-control" id="username"/>
		</div>
		<div class="form-group">
		<label for="username">Password: </label><input type = "password" name = "password" class="form-control" id="password"/>
		</div>
		<div class="form-group">
		<label for="Email">Email: </label> <input type = "text" name = "email" class="form-control" id="email"/>
		<input type = "submit" value = "Create" class="btn btn-default"/>
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

