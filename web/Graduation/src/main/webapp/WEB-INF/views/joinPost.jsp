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
	<div class="container my-5 py-3 bg-light">
        <div class="row justify-content-center"><img src='<c:url value="/resources/imgages/thankyou.jpg" />' alt=""></div>
        <h1 class="text-center mt-5 mb-4">${userName} 님 <br>모여라 여기로에 가입하신것을 <br> 진심으로 환영합니다.</h1>
        <div class="row justify-content-center">
            <div class="col-2 text-center"><a href="/" class="btn btn-primary">홈으로 이동하기</a></div>
        </div>
    </div>
	
	<!-- 푸터 -->
	<%@ include file="./include/footer.jsp" %>
	

</body>
</html>