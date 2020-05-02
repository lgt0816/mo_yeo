<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모여라 여기로</title>
<link href="<c:url value="/resources/css/errorPage.css" />" rel="stylesheet" >
</head>
<body>
	<div id="clouds">
        <div class="cloud x1"></div>
        <div class="cloud x1_5"></div>
        <div class="cloud x2"></div>
        <div class="cloud x3"></div>
        <div class="cloud x4"></div>
        <div class="cloud x5"></div>
    </div>
    <div class='critical'>
        <div class='_error'>404</div>
        <hr>
        <div class='mesage_1'>THE PAGE</div>
        <div class='mesage_2'>WAS NOT FOUND</div>
        <a class='btn' href='/login'>홈으로 돌아가기</a>
    </div>

</body>
</html>