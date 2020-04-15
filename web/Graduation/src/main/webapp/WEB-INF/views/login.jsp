<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login jsp file</title>
</head>
<body>
	<form action="/loginPost" method="post" role="form">
		<p>아이디</p>
		<input type="text" name="userId" class="form-control" placeholder="User ID..." />
		<p>비밀번호</p>
		<input type="password" name="userPw" class="form-control" placeholder="User Pw..." />
		<button type="submit">Sign up</button>
	</form>
	<a href="/join">회원가입</a>
</body>
</html>