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
	const sexs = joinForm.querySelectorAll(".sex");
	const schoolType = joinForm.querySelector("#schoolType");
	const major = joinForm.querySelector("#major");
	const grade = joinForm.querySelector("#grade");
	const schoolState = joinForm.querySelector("#schoolState");
	const singUp = joinForm.querySelector("#singUp");
	const checkId = joinForm.querySelector("#checkId");	//아이디 중복확인 버튼
    const sendAuthorizationMail = document.querySelector("#sendAuthorizationMail");	//인증메일보내기 버튼
    const checkAuthorizationCode = document.querySelector("#checkAuthorizationCode");	//인증하기 버튼
    let httpRequest;
    //대학 및 전공 초기화변수
    const schoolTypeOfMajor = {
            신학대학:{major:["신학부"]}, 
            인문대학:{major:["영어영문학과", "중어중문학과", "국어국문학과"]},
            사회과학대학:{major:["사회복지학과", "국제개발협력학과", "행정학과"]}, 
            사범대학:{major:["유아교육과", "체육교육과", "교직부"]}, 
            예술대학:{major:["음악학부", "연극영화학부", "뷰티디자인학과", "공연음악예술학부"]},
            파이데이아칼리지:{major:["파이데이아학부"]},
            융합대학:{major:["융합학부"]}, 
            글로벌경영기술대학:{major:["관광개발학부", "경영학과", "동아시아물류학부", "산업경영공학과"]},
            IT공과대학:{major:["컴퓨터공학과", "정보통신공학과", "미디어소프트웨어학과", "도시디자인정보공학과"]}
        };
    
    
    singUp.onclick= function(){
    	if(submitFormData()){
    		joinForm.submit();
    	}
    };
    
    //<%--인증하기버튼 클릭 이벤트 --%>
    checkAuthorizationCode.onclick=function(){
    	/* const authorizationCode = document.querySelector("#authorizationCode").value; */
    	const jsonData = {inputKey:authorizationCode.value};
    	makePostRequest("/join/authorizationCheck", jsonData, alertAndChecking);
    }
    
    //<%--인증메일 보내기 버튼 클릭 이벤트 --%>
    sendAuthorizationMail.onclick=function(){
    	/* const email1 = document.querySelector("#email1").value;
    	const email2 = document.querySelector("#email2").value; */
    	const jsonData = {email1:email1.value, email2:email2.value};
    	makePostRequest("/join/authorizationMailCheck", jsonData, alertAndSendMail);
    };
    
    //<%--아이디 중복확인버튼 클릭 이벤트 --%>
    checkId.onclick=function(){
        const userIdValue = userId.value;
        if(isNaN(userIdValue)){
        	alert("학번을 입력해 주세요.")
        	document.querySelector("#checkIdClear").value ="false";
        	return;
        }
        
        let jsonData = {userId:userId.value};
        makePostRequest("/join/checkUserId",jsonData, alertAndChecking);
    };
    
    //<%--ajax통신을 위한 함수 --%>
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
    //<%--ajax 통신의 결과값 alert와 다시 ajax로인증 이메일을 보냄 --%>
    function alertAndSendMail(){
    	if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status === 200) {
            	const response = JSON.parse(httpRequest.responseText);
                const result = response.result;
                const flag = response.flag;

            	const jsonData = {email1:email1.value, email2:email2.value};
            	
                if(result!==null) alert(result);
                if(flag){
                	makePostRequest("/join/authorizationMailSend", jsonData);
                }
                
            } else {
              alert('request에 뭔가 문제가 있습니다.');
            }
          }
    }
    
    //<%-- contents null값 체크 함수 --%>
    function nullCheck(){
    	const userIdValue = userId.value;
    	const userPw1Value = userPw1.value;
    	const userPw2Value = userPw2.value;
    	const nameValue = name.value;
    	const phoneNumValue = phoneNum.value;
    	const email1Value = email1.value;
    	const sexValue = getSex();
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
    }
    
    //비밀번호 일치여부 체크 -->
    function passwordCheck(){
    	const userPw1Value = userPw1.value;
    	const userPw2Value = userPw2.value;
    	
    	if(userPw1Value!==userPw2Value){
    		alert("비밀번호가 일치하지 않습니다.");
    		return false;
    	}
    	return true;
    }
    
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
    }
    
	function submitFormData(){
		if(nullCheck() && passwordCheck() && clearCheck()){
			alert("")
			return true;
		}
    }
	
	function getSex(){
		return (sexs[0].checked===true) ? sexs[0].value : sexs[1].value ;
	}

    //대학&전공 초기화
    function schoolTypeAndMajorInit(){
        const schoolTypes = Object.keys(schoolTypeOfMajor);
        const majors = schoolTypeOfMajor.신학대학.major;
        //대학 초기화
        for(let i=0 ; i< schoolTypes.length;i++){
            var option = document.createElement('option');
            option.append(schoolTypes[i]);
            schoolType.append(option);
        }
        // 전공 초기화
        for(let i=0; i<majors.length ; i++){
            var option = document.createElement('option');
            option.append(majors[i]);
            major.appendChild(option);
        }
    }
    
    //change 이벤트 추가  (대학 변경시 전공의 select의 옵션을 변경)
    schoolType.addEventListener("change", function(e){
        const key = e.target.value;
        const majors = schoolTypeOfMajor[key].major
        major.innerHTML=""; //전공 초기화
        for(let i=0; i<majors.length;i++){
            var option = document.createElement('option');
            option.append(majors[i]);
            major.appendChild(option);
        }

    })

    schoolTypeAndMajorInit();	//초기화 함수 실행
    
    
})