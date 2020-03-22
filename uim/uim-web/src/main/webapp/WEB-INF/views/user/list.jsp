<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<style type="text/css">
.strike {
	text-decoration: line-through;
}
</style>
</head>
<body>
	<h1>User List</h1>
	<hr />
	<div id="userList">
		<ul>
			<!-- (1) -->
			<c:forEach items="${users}" var="user">
				<li><c:choose>
						<c:when test="${user.userStatus}">
							<!-- (2) -->
							<span class="strike"> <!-- (3) --> ${f:h(user.userName)}
							</span>
						</c:when>
						<c:otherwise>
					       	${f:h(user.userName)}
						</c:otherwise>
					</c:choose></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>