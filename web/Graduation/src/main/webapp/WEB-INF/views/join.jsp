<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$('#checkId').click(function(){
		var userId = document.querySelector("#userId").value;
		var query = "userId="+userId;
		
		$.ajax({
			url:"/join/checkUserId" ,
			type:"GET" ,
			data:query,
			dataType:"json",
			success:function(data){
				alert(data.result);
			},
			error: function (e) {
				alert("통신실패"+e);
			}
		});
		
	});
	$('#sendAuthorizationMail').click(function () {
		var email = document.querySelector("#email").value;
		var selectEmail = document.querySelector("#emailAddress").value;
		var query = "email=" + email + "@" + selectEmail;
		$.ajax({
			url:"/join/authorizationMail" ,
			type:"GET" ,
			data:query,
			dataType:"json",
			success:function(data){
				alert(data.result);
			},
			error: function (e) {
				alert("통신실패"+e);
			}
		});
	})
	$('#checkAuthorizationCode').click(function () {
		var authorizationCode = document.querySelector("#authorizationCode").value;
		var query ="authorizationCode="+authorizationCode;
		$.ajax({
			url:"/join/authorizationCheck" ,
			type:"GET" ,
			data:query,
			dataType:"json",
			success:function(data){
				alert(data.result);
			},
			error: function (e) {
				alert("통신실패"+e);
			}
		});
	})
	
});
</script>
<title>회원가입 페이지</title>
</head>
<body>
<form action="/joinPost" method="post" role="form" id="joinForm">
		아이디 :
		<input type="text" id="userId" name="userId" class="form-control" placeholder="User ID..." />
		<input type="button" id="checkId" name="checkId" value="아이디 중복 확인" >
		비밀번호 : 
		<input type="password" id="userPw" name="userPw" class="form-control" placeholder="User Pw..." />
		이름 : 
		<input type="text" id="name" name="name" class="form-control" placeholder="User Name..." />
		핸드폰 번호 :
		<input type="text" id="phoneNum" name="phoneNum" class="form-control" placeholder="User PhoneNum..." />
		이메일 : 
		<input type="text" id="email" name="email" class="form-control" placeholder="User Email..." />
		@
		<select name="emailAddress" id="emailAddress">
			<option>sungkyul.ac.kr</option>
			<option>office.sungkyul.ac.kr</option>
		</select>
		<input type="button" id="sendAuthorizationMail" value="인증 메일 보내기">
		인증번호 : 
		<input type="text" id="authorizationCode">
		<input type="button" id="checkAuthorizationCode" value="인증하기">
		성별 : 
		<input type="text" id="sex" name="sex" class="form-control" placeholder="User Sex..." />
		전공 :
		<input type="text" id="major" name="major" class="form-control" placeholder="User Major..." />
		학년 :
		<input type="text" id="grade" name="grade" class="form-control" placeholder="User Grade..." />
		재학상태: 
		<input type="text" id="schoolState" name="SchoolState" class="form-control" placeholder="User SchoolState..." />
		<button type="submit">Sign up</button>
	</form>
</body>
</html>