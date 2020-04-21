<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
window.addEventListener("load",function(){
    const checkId = document.querySelector("#checkId");	//아이디 중복확인 버튼
    const sendAuthorizationMail = document.querySelector("#sendAuthorizationMail");	//인증메일보내기 버튼
    const checkAuthorizationCode = document.querySelector("#checkAuthorizationCode");	//인증하기 버튼
    let httpRequest;
    
    //인증하기버튼 클릭 이벤트
    checkAuthorizationCode.onclick=function(){
    	const authorizationCode = document.querySelector("#authorizationCode").value;
    	const jsonData = {inputKey:authorizationCode};
    	makePostRequest("/join/authorizationCheck", jsonData, alertContents);
    }
    
    //인증메일 보내기 버튼 클릭 이벤트
    sendAuthorizationMail.onclick=function(){
    	const email1 = document.querySelector("#email1").value;
    	const email2 = document.querySelector("#email2").value;
    	const jsonData = {email1:email1, email2:email2};
    	makePostRequest("/join/authorizationMailCheck", jsonData, alertAndSendMail);
    };
    
    //아이디 중복확인버튼 클릭 이벤트
    checkId.onclick=function(){
        const userId = document.querySelector("#userId").value;
        let jsonData = {userId:userId};
        makePostRequest("/join/checkUserId",jsonData, alertContents);
    };
    
    //ajax통신을 위한 함수
    function makePostRequest(url, jsonData, responseFounction){
        httpRequest = new XMLHttpRequest();
        if(!httpRequest){
            alert('XMLHTTP 인스턴스를 만들수가 없습니다.');
            return false;
        }
        httpRequest.onreadystatechange = responseFounction;
        httpRequest.open("POST",url);
        httpRequest.setRequestHeader('Content-Type', 'application/json');
        httpRequest.send(JSON.stringify(jsonData));
    }
    //ajax 통신후 결과값을 alert하는 함수
    function alertContents() {
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
          if (httpRequest.status === 200) {
            const response = JSON.parse(httpRequest.responseText);
            const result = response.result;
            const fleg = response.fleg;
            
            if(result!==null)
            	alert(result);
          } else {
            alert('request에 뭔가 문제가 있습니다.');
          }
        }
      }
    //ajax 통신의 결과값 alert와 다시 ajax로인증 이메일을 보냄
    function alertAndSendMail(){
    	if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status === 200) {
            	const response = JSON.parse(httpRequest.responseText);
                const result = response.result;
                const flag = response.flag;
                const email1 = document.querySelector("#email1").value;
            	const email2 = document.querySelector("#email2").value;
            	const jsonData = {email1:email1, email2:email2};
            	
                if(result!==null) alert(result);
                if(flag){
                	makePostRequest("/join/authorizationMailSend", jsonData);
                }
                
            } else {
              alert('request에 뭔가 문제가 있습니다.');
            }
          }
    }
    
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
		비밀번호 확인 : 
		<input type="password" id="userPw2" name="userPw2" class="form-control" placeholder="User Pw..." />
		이름 : 
		<input type="text" id="name" name="name" class="form-control" placeholder="User Name..." />
		핸드폰 번호 :
		<input type="text" id="phoneNum" name="phoneNum" class="form-control" placeholder="User PhoneNum..." />
		이메일 : 
		<input type="text" id="email1" name="email1" class="form-control" placeholder="User Email..." />
		@
		<select name="email2" id="email2">
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