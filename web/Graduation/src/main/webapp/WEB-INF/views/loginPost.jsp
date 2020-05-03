<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./include/head.jsp" %>
</head>
<body>
	<!-- nav bar -->
	<%@ include file="./include/navbar.jsp" %>
	<div>
		<div>${ loginResult }</div>
		
		<div>
			<a href="/login">Retry Sign In</a>
		</div>
	</div>
	
	<!-- 푸터 -->
	<%@ include file="./include/footer.jsp" %>

</body>
</html>