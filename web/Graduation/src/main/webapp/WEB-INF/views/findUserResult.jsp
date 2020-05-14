<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./include/head.jsp" %>
</head>
<body>
	<!-- nav bar -->
	<%@ include file="./include/navbar.jsp" %>
	<!-- jumbotron(전광판) -->
    <%@ include file="./include/jumbotron.jsp" %>
    
    <div class="container">
    	<div class="row"><h1 class="ml-4">${ pageSubtitle }</h1></div>
    	<hr class="bg-primary">
    	<div class="row"><p class="ml-4">${ findUserResult }<p></div>
    </div>    
	<!-- 풋터 -->
	<%@ include file="./include/footer.jsp" %>

</body>
</html>