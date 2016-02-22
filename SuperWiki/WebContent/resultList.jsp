<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_head.jsp"></jsp:include>
<title>Character Results | SuperWiki</title>
</head>
<body>
<jsp:include page="_nav.jsp"></jsp:include>
<img class="resultlistimg" src="img/200_tiny_characters_wallpaper_by_marciotakara-d2izzc8.jpg"/>
	<div class="characterresult">
	<p>Logged in as: ${user.username}</p>
	<table class="table table-bordered">
	<c:forEach var="results" items="${result}">
		<tr>
			<td><a href="selectID.do?id=${results.id}">${results.name}</a></td>
			<td>${results.alias}</td>
		</tr>
	</c:forEach>
	</table>
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
                            <a href="https://github.com/https://github.com/Sokos6/SuperWiki" target="_blank" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>
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