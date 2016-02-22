<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_head.jsp"></jsp:include>
<title>Profile | SuperWiki</title>
</head>
<body>
<jsp:include page="_nav.jsp"></jsp:include>
<img src="img/grover.png" class="image-responsive" id="grover">
<div class="profile">
	<p>Logged in as: ${user.username}</p>
	<h1 class="profilehead">My Account</h1>
	<p>Favorite Characters</p>
	<table class="table table-bordered">
	<c:forEach var="results" items="${user.favorites}">
		<tr>
			<td>Name: <a href="selectID.do?id=${results.superPerson.id}">${results.superPerson.name}</a></td>
			<td>Alias: ${results.superPerson.alias}</td>
			<td><form action="deleteFavorite.do" method="post"><input type="hidden" name="deleteid" value="${results.superPerson.id }"> 
			<input type="submit" value="Delete"></form>
		</tr>
	</c:forEach>
	</table>
	<p>Comments</p>
	<table>
	<c:forEach var="comment" items="${user.comments}">
		<tr>
			<td>${comment.message}</td>
			<td>${comment.superPerson.name}</td>
			<td><a href = "selectID.do?id=${comment.superPerson.id}">${comment.superPerson.name}</a> 
		</tr>
	</c:forEach>
	</table>
	<c:if test="${admin}">
		<p>Users</p>
		<table class="table table-bordered">
		<c:forEach var="eachUser" items="${users}">
			<tr>
				<td>${eachUser.username}</td>
				<c:if test="${eachUser.id != 1 && eachUser.id !=2 && eachUser.id != 7 && eachUser.id != 8 && eachUser.id != 9}">
					<td><form action="deleteUser.do" method="post"><input type="hidden" name="deleteUserid" value="${eachUser.id}"> 
					<input type="submit" value="Delete"></form></td>
				</c:if>
			</tr>
		</c:forEach>
		</table>
	</c:if>
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