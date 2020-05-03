<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="./include/head.jsp" %>
    <%-- <script type="text/javascript" src='<c:url value="/resources/js/userInfo.js"/>'></script> --%>
    <script type="text/javascript">
    window.addEventListener("load", function() {
    	const userInfoForm = document.querySelector("#userInfoForm");
    	const schoolType = userInfoForm.querySelector("#schoolType");
    	const major = userInfoForm.querySelector("#major");

    	const schoolTypeOfMajor = {
    		신학대학 : {
    			major : [ "신학부" ]
    		},
    		인문대학 : {
    			major : [ "영어영문학과", "중어중문학과", "국어국문학과" ]
    		},
    		사회과학대학 : {
    			major : [ "사회복지학과", "국제개발협력학과", "행정학과" ]
    		},
    		사범대학 : {
    			major : [ "유아교육과", "체육교육과", "교직부" ]
    		},
    		예술대학 : {
    			major : [ "음악학부", "연극영화학부", "뷰티디자인학과", "공연음악예술학부" ]
    		},
    		파이데이아칼리지 : {
    			major : [ "파이데이아학부" ]
    		},
    		융합대학 : {
    			major : [ "융합학부" ]
    		},
    		글로벌경영기술대학 : {
    			major : [ "관광개발학부", "경영학과", "동아시아물류학부", "산업경영공학과" ]
    		},
    		IT공학대학 : {
    			major : [ "컴퓨터공학과", "정보통신공학과", "미디어소프트웨어학과", "도시디자인정보공학과" ]
    		}
    	};

    	// change 이벤트 추가
    	schoolType.addEventListener("change", function(e) {
    		const key = e.target.value;
    		const majors = schoolTypeOfMajor[key].major
    		major.innerHTML = ""; // 전공 초기화
    		for (let i = 0; i < majors.length; i++) {
    			var option = document.createElement('option');
    			option.append(majors[i]);
    			major.appendChild(option);
    		}

    	})

    	// 대학&전공 초기화
    	function schoolTypeAndMajorInit() {
    		const schoolTypes = Object.keys(schoolTypeOfMajor);
    		const majors = schoolTypeOfMajor[`${user.schoolType}`].major;
    		// 대학 초기화
    		for (let i = 0; i < schoolTypes.length; i++) {
    			var option = document.createElement('option');
    			option.append(schoolTypes[i]);
    			if (schoolTypes[i] === `${user.schoolType}`) {
    				option.selected = true;
    			}
    			schoolType.append(option);
    		}
    		// 전공 초기화
    		for (let i = 0; i < majors.length; i++) {
    			var option = document.createElement('option');
    			option.append(majors[i]);
    			if (majors[i] === `${user.major}`) {
    				option.selected = true;
    			}
    			major.appendChild(option);
    		}
    	}
    	//학년 초기화
    	function gradeInit(){
    		const grade = ${user.grade};
    		const grades = document.querySelectorAll('#grade option');
    		
    		switch (grade){
    		case 1:
    			grades[0].selected=true;
    			break;
    		case 2:
    			grades[1].selected=true;
    			break;
    		case 3:
    			grades[2].selected=true;
    			break;
    		case 4:
    			grades[3].selected=true;
    			break;
    		}
    		
    	}
    	//재학상태 초기화
    	function schoolStateInit(){
    		const schoolState = `${user.schoolState}`;
    		const schoolStates = document.querySelectorAll("#schoolState option");
    		switch (schoolState){
    		case '재학중':
    			schoolStates[0].selected=true;
    			break;
    		case '휴학중':
    			schoolStates[1].selected=true;
    			break;
    		case '졸업':
    			schoolStates[2].selected=true;
    			break;
    		}
    	}
    	
    	schoolStateInit();
    	gradeInit();
    	schoolTypeAndMajorInit();
    })
    </script>
</head>
<body>

	<!--네비게이션 바-->
    <%@ include file="./include/navbar.jsp" %>
    

    <!--컨테이너-->
    <div class="container my-5 py-3 bg-light">
        <form action="/userUpdate.do" method="post" role="form" id="userInfoForm">
            <div class="form-group row">
                <h1 class="col-12 text-center pt-4">회원정보변경</h1>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="userId">아이디 :</label>
                <div class="col-6 col-form-label"><strong>${user.userId }</strong></div>
                
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="userPw1">비밀번호 : </label>
                <div class="col-6"><input type="password" id="userPw1" name="userPw1" class="form-control"
                        placeholder="비밀번호를 입력해 주세요." value="" /></div>
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="">비밀번호 확인 : </label>
                <div class="col-6"><input type="password" id="userPw2" name="userPw2" class="form-control"
                        placeholder="다시 한번 비밀번호를 입력해주세요." value="" /></div>
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="">비밀번호 변경 : </label>
                <div class="col-6"><input type="password" id="userPw3" name="userPw3" class="form-control"
                        placeholder="변경할 비밀번호를 입력해주세요" value="" /></div>
                <div class="col-3">
                    <input type="button" id="checkAuthorizationCode" value="비밀번호 변경하기"
                        class="btn btn-primary">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="">이름 : </label>
                <div class="col-6 col-form-label">
                    <strong>${user.name }</strong>
                </div>
            </div>

            <div class="form-group row">
                <label for="" class="col-3 col-form-label text-right">성별 : </label>
                <div class="col-6 col-form-label"><strong>${user.sex }</strong></div>
            </div>

            <div class="form-group row">
                <label for="" class="col-3 col-form-label text-right">대학/전공</label>
                <div class="col-3">
                	<select class="form-control" name="schoolType" id="schoolType">
                        
                    </select>
                <!-- <input type="text" id="schoolType" name="schoolType" class="form-control"
                        placeholder="User schoolType..." /> -->
                </div>
                <div class="col-3">
                	<select class="form-control" name="major" id="major">
                		
                    </select>
	                <!-- <input type="text" id="major" name="major" class="form-control"
	                        placeholder="User Major..." /> -->
                </div>
            </div>

            <div class="form-group row">
                <label for="" class="col-3 col-form-label text-right">학년/재학상태 : </label>
                <div class="col-3">
                    <select class="form-control" name="grade" id="grade">
                        <option>1학년</option>
                        <option>2학년</option>
                        <option>3학년</option>
                        <option>4학년</option>
                    </select>
                </div>
                <div class="col-3">
                    <select class="form-control" name="schoolState" id="schoolState">
                        <option>재학중</option>
                        <option>휴학중</option>
                        <option>졸업</option>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="">핸드폰 번호 :</label>
                <div class="col-6"><input type="text" id="phoneNum" name="phoneNum" class="form-control"
                        placeholder="-를 제외하고 입력해주세요." value="${user.phoneNum }"/></div>
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="">이메일 : </label>
                <div class="col-3 col-form-label">
                    <strong>${user.email }</strong>
                </div>
            </div>

            <div class="row">
                <div class="col-6 text-right"><button type="button" id="singUp" class="btn btn-primary">변경하기</button></div>
                <div class="col-6"><button type="button" id="cancel" class="btn btn-primary">취소</button></div>
            </div>



        </form>
    </div>

    <!-- 푸터 -->
    <%@ include file="./include/footer.jsp" %>

	<%-- <a href="/logout">로그아웃</a>
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
		<input type="text" id="schoolState" name="schoolState" class="form-control" placeholder="User SchoolState..." value="${user.schoolState }"/><br>
		
		<button type="submit" id="change">정보수정</button>
	</form> --%>
	
</body>
</html>