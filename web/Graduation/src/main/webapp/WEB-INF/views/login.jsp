<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
    <!-- <meta http-equiv='X-UA-Compatible' content='IE=edge'> -->
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>모여라 여기로</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet" />
</head>
<body>
	<!--네비게이션 바-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	    <a class="navbar-brand" href="#">모여라 여기로</a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
	        aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	    </button>
	
	    <div class="collapse navbar-collapse" id="navbarColor01">
	        <ul class="navbar-nav mr-auto">
	            <li class="nav-item active">
	                <a class="nav-link" href="#">홈 <span class="sr-only">(current)</span></a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#">스터디</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#">프로젝트</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#">졸업작품</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#">포트폴리오</a>
	            </li>
	        </ul>
	    </div>
	
	    <a class="navbar-brand" href="login.html">로그인</a>
	</nav>

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
    <footer class="container my-5" id="footer">
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-inline">
                    <li class="float-lg-right list-inline-item"><a href="#top">Back to top</a></li>
                </ul>
                <p>Made by <a href="#">GeunTaek Lee</a>.</p>
                <p>Code released under the <a href="https://github.com/thomaspark/bootswatch/blob/master/LICENSE">MIT
                        License</a>.</p>
                <p>Based on <a href="https://getbootstrap.com" rel="nofollow">Bootstrap</a>. Icons from <a
                        href="https://fontawesome.com/" rel="nofollow">Font Awesome</a>. Web fonts from <a
                        href="https://fonts.google.com/" rel="nofollow">Google</a>.</p>

            </div>
        </div>
    </footer>
	

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