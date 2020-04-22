<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
</head>
<body>
	<h1>아이디 찾기</h1>
	<form action="/findUserId" id="findUserId" name="findUserId" method="post">
		이름 : 
		<input type="text" name="name" /><br>
		이메일 : 
		<input type="text" id="email1" name="email1" class="form-control" placeholder="User Email..." />
		@
		<select name="email2" id="email2">
			<option>sungkyul.ac.kr</option>
			<option>office.sungkyul.ac.kr</option>
		</select><br>
		<input type="submit" name ="submit" value="아이디 찾기" /><br>
	</form>
	<hr>
	<h1>비밀번호 찾기</h1>
	<form action="/findUserPw" id="findUserPw" name="findUserPw" method="post">
		아이디 : 
		<input type="text" name="userId"><br>
		이름 : 
		<input type="text" name="name"><br>
		이메일 : 
		<input type="text" id="email1" name="email1" class="form-control" placeholder="User Email..." />
		@
		<select name="email2" id="email2">
			<option>sungkyul.ac.kr</option>
			<option>office.sungkyul.ac.kr</option>
		</select><br>
		<input type="submit" value="비밀번호 찾기"><br>
	</form>
</body>
</html>