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
	
	<!-- 컨텐츠 -->
	<div>${ joinResult }</div>
	<div>
		<a href="/login">back to loginPage</a>
	</div>
	
	<!-- 푸터 -->
	<%@ include file="./include/footer.jsp" %>
	

</body>
</html>