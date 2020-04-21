<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
window.addEventListener("load",function(){
    const joinForm = document.querySelector("#joinForm");
	const userId = joinForm.querySelector("#userId");
	const userPw1 = joinForm.querySelector("#userPw1");
	const userPw2 = joinForm.querySelector("#userPw2");
	const name = joinForm.querySelector("#name");
	const phoneNum = joinForm.querySelector("#phoneNum");
	const email1 = joinForm.querySelector("#email1");
	const email2 = joinForm.querySelector("#email2");
	const authorizationCode = document.querySelector("#authorizationCode");
	const sex = joinForm.querySelector("#sex");
	const schoolType = joinForm.querySelector("#schoolType");
	const major = joinForm.querySelector("#major");
	const grade = joinForm.querySelector("#grade");
	const schoolState = joinForm.querySelector("#schoolState");
	const singUp = joinForm.querySelector("#singUp");
	const checkId = joinForm.querySelector("#checkId");	//아이디 중복확인 버튼
    const sendAuthorizationMail = document.querySelector("#sendAuthorizationMail");	//인증메일보내기 버튼
    const checkAuthorizationCode = document.querySelector("#checkAuthorizationCode");	//인증하기 버튼
    let httpRequest;
    
    singUp.onclick= function(){
    	submitFormData();
    };
    
    //인증하기버튼 클릭 이벤트
    checkAuthorizationCode.onclick=function(){
    	/* const authorizationCode = document.querySelector("#authorizationCode").value; */
    	const jsonData = {inputKey:authorizationCode.value};
    	makePostRequest("/join/authorizationCheck", jsonData, alertAndChecking);
    }
    
    //인증메일 보내기 버튼 클릭 이벤트
    sendAuthorizationMail.onclick=function(){
    	/* const email1 = document.querySelector("#email1").value;
    	const email2 = document.querySelector("#email2").value; */
    	const jsonData = {email1:email1.value, email2:email2.value};
    	makePostRequest("/join/authorizationMailCheck", jsonData, alertAndSendMail);
    };
    
    //아이디 중복확인버튼 클릭 이벤트
    checkId.onclick=function(){
        /* const userId = userId.value; */
        let jsonData = {userId:userId.value};
        makePostRequest("/join/checkUserId",jsonData, alertAndChecking);
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
    //ajax 통신후 결과값을 alert후 인증상태 확인하는 함수
    function alertAndChecking() {
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
          if (httpRequest.status === 200) {
            const response = JSON.parse(httpRequest.responseText);
            const result = response.result;
            const flag = response.flag;
            
            console.log(typeof flag);
            
            if(flag==="authorizationClear"){
            	document.querySelector("#authorizationMailClear").value="true";
            }else if(flag=="authorizationfaile"){
            	document.querySelector("#authorizationMailClear").value="false";
            }else if(flag==="userIdCheckClear"){
            	document.querySelector("#checkIdClear").value ="true";
            }else if(flag==="userIdCheckFaile"){
            	document.querySelector("#checkIdClear").value ="false";
            }
            
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
                /* const email1 = document.querySelector("#email1").value;
            	const email2 = document.querySelector("#email2").value; */
            	const jsonData = {email1:email1.value, email2:email2.value};
            	
                if(result!==null) alert(result);
                if(flag){
                	makePostRequest("/join/authorizationMailSend", jsonData);
                }
                
            } else {
              alert('request에 뭔가 문제가 있습니다.');
            }
          }
    };
    
    <!-- contents null값 체크 함수 -->
    function nullCheck(){
    	const userIdValue = userId.value;
    	const userPw1Value = userPw1.value;
    	const userPw2Value = userPw2.value;
    	const nameValue = name.value;
    	const phoneNumValue = phoneNum.value;
    	const email1Value = email1.value;
    	const sexValue = sex.value;
    	const schoolTypeValue = schoolType.value;
    	const majorValue = major.value;
    	const gradeValue = grade.value;
    	const schoolStateValue = schoolState.value;
    	
    	console.log(userIdValue==="");
    	if(userIdValue==="" || userPw1Value ==="" || userPw2Value ==="" || nameValue==="" || 
    			phoneNumValue==="" || email1Value==="" || sexValue==="" || schoolTypeValue==="" ||
    			majorValue==="" || gradeValue==="" || schoolStateValue===""){
    		alert("입력하지 않은 내용이 있습니다.");
    		return false;
    	}
    	return true;
    };
    
    //비밀번호 일치여부 체크 -->
    function passwordCheck(){
    	const userPw1Value = userPw1.value;
    	const userPw2Value = userPw2.value;
    	
    	if(userPw1Value!==userPw2Value){
    		alert("비밀번호가 일치하지 않습니다.");
    		return false;
    	}
    	return true;
    };
    
    function clearCheck(){
    	const checkIdClear = document.querySelector("#checkIdClear").value;
    	const authorizationMailClear = document.querySelector("#authorizationMailClear").value;
    	
    	if(checkIdClear !=="true"){
    		alert("아이디 중복확인을 해주세요.");
    		return false;
    	}else if(authorizationMailClear !=="true"){
    		alert("이메일 인증을 해주세요.");
    		return false;
    	}
    	return true;
    };
    
	function submitFormData(){
		if(nullCheck() && passwordCheck() && clearCheck()){
			alert("ㅊㅊ")
			return true;
		}
    };
    
    
});
</script>
<title>회원가입 페이지</title>
</head>
<body>
	<form action="/joinPost" method="post" role="form" id="joinForm">
		<input type="hidden" id="checkIdClear" value="false">
		<input type="hidden" id="authorizationMailClear" value="false">

		아이디 :
		<input type="text" id="userId" name="userId" class="form-control" placeholder="User ID..." />
		<input type="button" id="checkId" name="checkId" value="아이디 중복 확인" ><br>
		
		비밀번호 : 
		<input type="password" id="userPw1" name="userPw1" class="form-control" placeholder="User Pw..." value=""/><br>
		
		비밀번호 확인 : 
		<input type="password" id="userPw2" name="userPw2" class="form-control" placeholder="User Pw..." value="" /><br>
		
		이름 : 
		<input type="text" id="name" name="name" class="form-control" placeholder="User Name..." /><br>
		
		핸드폰 번호 :
		<input type="text" id="phoneNum" name="phoneNum" class="form-control" placeholder="User PhoneNum..." /><br>
		
		이메일 : 
		<input type="text" id="email1" name="email1" class="form-control" placeholder="User Email..." />
		@
		<select name="email2" id="email2">
			<option>sungkyul.ac.kr</option>
			<option>office.sungkyul.ac.kr</option>
		</select>
		<input type="button" id="sendAuthorizationMail" value="인증 메일 보내기"><br>
		
		인증번호 : 
		<input type="text" id="authorizationCode">
		<input type="button" id="checkAuthorizationCode" value="인증하기"><br>
		
		성별 : 
		<input type="text" id="sex" name="sex" class="form-control" placeholder="User Sex..." /><br>
		
		대학 :
		<input type="text" id="schoolType" name="schoolType" class="form-control" placeholder="User schoolType..." /><br>
		
		전공 :
		<input type="text" id="major" name="major" class="form-control" placeholder="User Major..." /><br>
		
		학년 :
		<input type="text" id="grade" name="grade" class="form-control" placeholder="User Grade..." /><br>
		
		재학상태: 
		<input type="text" id="schoolState" name="SchoolState" class="form-control" placeholder="User SchoolState..." /><br>
		
		<button type="submit" id="singUp">Sign up</button>
	</form>
</body>
</html>