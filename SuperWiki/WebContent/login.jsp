<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_head.jsp"></jsp:include>
<title>Login</title>
</head>
<body>
<jsp:include page="_nav.jsp"></jsp:include>
<div class="logintop">
<img src="img/superheroes-characters.jpg" class = "image-responsive" id="loginfix">
<h1>LOGIN TO USE YOUR SUPERWIKI ACCOUNT</h1>
	<form action = "login.do" method = "GET">
		<div class="login">		
		<div class="form-group">
		<label for="name">Name: </label><input type= "text" class="form-control" name ="username" placeholder = "username"/>
		</div>
		<div class="form-group">
		<label for="password">Password: </label><input type= "password" class="form-control" name ="password" placeholder = "password"/>	
		</div>
		<div class="form-group">
		<label for="Submit"></label><input type = "submit" class="btn btn-default" value = "Login"/>	
		</div>
		</div>
	</form>
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
   </div>
</body>
</html>