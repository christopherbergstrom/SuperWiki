<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_head.jsp"></jsp:include>
<title>${result.name}</title>
</head>
<body>
<jsp:include page="_nav.jsp"></jsp:include>
	<p>Logged in as: ${user.username}</p>
	<div class="result">
	<div class="indivcharimg">
	<img src="${result.image }" alt="${result.name }"/>
	</div>
	<div class="panel panel-default">
  	<div class="panel-body">
	<p>NAME: ${result.name}</p>
	<p>ALIAS: ${result.alias}</p>
	<p>CREATOR: ${result.creator }</p>
	<p>FIRST APPEARANCE: ${result.firstAppearance }</p>
	<p>TEAM NAME: ${result.team.name }</p>
	<p>ORIGIN: ${result.origin }</p>
	<p>PUBLISHER: ${result.publisher }</p>
	
	<a href="updateCharacter.do?id=${result.id }">Update</a>
	</div>
	</div>
	<c:if test="${! empty result.comments}">
		<table>
			<c:forEach var="comment" items="${result.comments }">
				<tr>
					<td>${comment.user.username}:</td>
					<td>${comment.message }</td>
					<c:choose>
						<c:when test="${admin }">
							<td><form action="deleteComment.do" method="POST">
									<input type="hidden" name="commentid" value="${comment.id }"><input
										type="hidden" name="superPersonID" value="${result.id }" /><input
										type="submit" value="Delete">
								</form></td>
								<td><form action="updateComment.do" method="GET">
									<input type="hidden" name="commentid" value="${comment.id }"><input
										type="hidden" name="superPersonID" value="${result.id }" /><input
										type="submit" value="Update">
								</form></td>
						</c:when>
						<c:when test="${user.id == comment.user.id }">
							<td><form action="deleteComment.do" method="POST">
									<input type="hidden" name="commentid" value="${comment.id }">
									<input type="hidden" name="superPersonID" value="${result.id }" />
									<input type="submit" value="Delete">
								</form></td>
								<td><form action="updateComment.do" method="GET">
									<input type="hidden" name="commentid" value="${comment.id }"><input
										type="hidden" name="superPersonID" value="${result.id }" /><input
										type="submit" value="Update">
								</form></td>
						</c:when>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</c:if >

	<c:if test = "${user.username != null}">
	<form action="addComment.do" method="POST">
		<div class="form-group">
		<input type="hidden" name="superPersonID" value="${result.id }" />
		<label for="Comment">Comment: </label> 
		<textarea class="form-control" cols="100" rows="5" name="message"></textarea>
		<input type="submit" class="btn btn-default" value="Post" />
		</div>
	</form>
	<form action="addFav.do" method="POST">
		<input type="submit" class="btn btn-default" value="favorite" /> <input type="hidden"
			name="selectionid" value="${result.id}" />
	</form>
	</c:if>
</div>
</body>
</html>