<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="./include/head.jsp" %>
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet" />
</head>
<body>
	<!--네비게이션 바-->
	<%@ include file="./include/navbar.jsp" %>

    <div class="container">
        <div class="login-form">
            <form action="/loginPost" method="post" role="form">
                <div class="avatar">
                    <img src="<c:url value="/resources/images/avatar.png" />" alt="Avatar">
                </div>
                <h2 class="text-center"> 모여라 여기로</h2>
                <div class="form-group">
                    <input type="text" class="form-control" name="userId" placeholder="아이디" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="userPw" placeholder="비밀번호"
                        required="required">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">로그인</button>
                </div>

                <div class="clearfix text-center">
                    <a href="/findUser" class="pull-right">아이디/비밀번호 찾기</a>
                    |
                    <a href="/join">회원가입</a>
                </div>
                
            </form>
            
        </div>
    </div>

    <!-- 푸터 -->
    <%@ include file="./include/footer.jsp" %>
	

	<!-- <form action="/loginPost" method="post" role="form">
		<p>아이디</p>
		<input type="text" name="userId" class="form-control" placeholder="User ID..." />
		<p>비밀번호</p>
		<input type="password" name="userPw" class="form-control" placeholder="User Pw..." />
		<button type="submit">Sign up</button>
	</form>
	<a href="/join">회원가입</a>
	<a href="/findUser">아이디/비밀번호 찾기</a> -->
</body>
</html>