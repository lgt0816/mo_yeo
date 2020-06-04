<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--네비게이션 바-->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container">
		<a class="navbar-brand" href="/">모여라 여기로</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
				<a class="nav-link" href="/">홈
						<span class="sr-only">(current)</span>
				</a></li>
				<c:if test="${loginedUser != null }">
					<li class="nav-item"><a class="nav-link" href='/activity/completedStudys'>스터디</a></li>
					<li class="nav-item"><a class="nav-link" href="#">프로젝트</a></li>
					<li class="nav-item"><a class="nav-link" href="#">졸업작품</a></li>
					<li class="nav-item"><a class="nav-link" href="#">포트폴리오</a></li>
				</c:if>
			</ul>
		</div>
	</div>

	<c:choose>
		<c:when test="${loginedUser != null }" >
			<a class="navbar-brand" href="/logout">로그아웃</a>
			<a class="navbar-brand" href="/userInfo">개인정보</a>
		</c:when>
		<c:when test="${logineduser == null }">
			<a class="navbar-brand" href="/login">로그인</a>
		</c:when>
	</c:choose>
	<c:if test="${loginedUser != null }">
			
	</c:if>
	
</nav>