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
	<form action="/userUpdate.do" method="post" role="form" id="userInfoForm">
	
		아이디 :${user.userId }<br>
		
		비밀번호 : 
		<input type="password" id="userPw1" name="userPw1" class="form-control" placeholder="User Pw..." value=""/><br>
		
		비밀번호 확인 : 
		<input type="password" id="userPw2" name="userPw2" class="form-control" placeholder="User Pw..." value="" /><br>
		
		비밀번호 변경 : 
		<input type="password" id="userPw3" name="userPw3" class="form-control" placeholder="비밀번호변경을 원하는 경우에만 입력해주세요." value="" /><br>
		
		이름 : ${user.name } <br>
		
		핸드폰 번호 :
		<input type="text" id="phoneNum" name="phoneNum" class="form-control" placeholder="User PhoneNum..." value="${user.phoneNum }"/><br>
		
		이메일 : ${ user.email }<br>
		
		성별 : ${user.sex}<br>
		
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