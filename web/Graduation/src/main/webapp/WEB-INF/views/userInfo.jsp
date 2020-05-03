<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="./include/head.jsp" %>
    <script type="text/javascript" src='<c:url value="/resources/js/join.js"/>'></script>
</head>
<body>

	<!--네비게이션 바-->
    <%@ include file="./include/navbar.jsp" %>
    

    <!--컨테이너-->
    <div class="container my-5 py-3 bg-light">
        <form action="/userUpdate.do" method="post" role="form" id="joinForm">
            <div class="form-group row">
                <h1 class="col-12 text-center pt-4">회원정보변경</h1>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="userId">아이디 :</label>
                <div class="col-6 col-form-label"><strong>20130946</strong></div>
                
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
                    <strong>이근택</strong>
                </div>
            </div>

            <div class="form-group row">
                <label for="" class="col-3 col-form-label text-right">성별 : </label>
                <div class="col-6 col-form-label"><strong>남자</strong></div>
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
                        placeholder="-를 제외하고 입력해주세요." /></div>
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="">이메일 : </label>
                <div class="col-3 col-form-label">
                    <strong>lgt0816@sungkyul.ac.kr</strong>
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