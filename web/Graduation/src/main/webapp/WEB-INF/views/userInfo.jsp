<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 조회</title>
</head>
<body>
	<a href="/logout">로그아웃</a>
	<form action="#" method="post" role="form" id="joinForm">
		<input type="hidden" id="checkIdClear" value="false">
		<input type="hidden" id="authorizationMailClear" value="false">

		아이디 :<p>${user.userId }</p><br>
		
		비밀번호 : 
		<input type="password" id="userPw1" name="userPw1" class="form-control" placeholder="User Pw..." value=""/><br>
		
		비밀번호 확인 : 
		<input type="password" id="userPw2" name="userPw2" class="form-control" placeholder="User Pw..." value="" /><br>
		
		이름 : <p>${user.name }</p><br>
		
		핸드폰 번호 :
		<input type="text" id="phoneNum" name="phoneNum" class="form-control" placeholder="User PhoneNum..." value="${user.phoneNum }"/><br>
		
		이메일 : <p>${ user.email }</p><br>
		
		성별 : 
		<p>${user.sex}</p><br>
		
		대학 :
		<input type="text" id="schoolType" name="schoolType" class="form-control" placeholder="User schoolType..." value="${user.schoolType }" /><br>
		
		전공 :
		<input type="text" id="major" name="major" class="form-control" placeholder="User Major..." value="${user.major }"/><br>
		
		학년 :
		<input type="text" id="grade" name="grade" class="form-control" placeholder="User Grade..." value="${user.grade }" /><br>
		
		재학상태: 
		<input type="text" id="schoolState" name="SchoolState" class="form-control" placeholder="User SchoolState..." value="${user.schoolState }"/><br>
		
		<button type="submit" id="change">정보수정</button>
	</form>
	
</body>
</html>