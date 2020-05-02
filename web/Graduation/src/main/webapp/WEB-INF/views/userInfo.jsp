<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
    <!-- <meta http-equiv='X-UA-Compatible' content='IE=edge'> -->
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>모여라 여기로</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script type="text/javascript" src='<c:url value="/resources/js/join.js"/>'></script>
</head>
<body>

	<!--네비게이션 바-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">모여라 여기로</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
            aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">홈 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">스터디</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">프로젝트</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">졸업작품</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">포트폴리오</a>
                </li>
            </ul>
        </div>

        <a class="navbar-brand" href="/logout">로그아웃</a>
    </nav>
    

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
    <footer class="container my-5" id="footer">
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-inline">
                    <li class="float-lg-right list-inline-item"><a href="#top">Back to top</a></li>
                </ul>
                <p>Made by <a href="#">GeunTaek Lee</a>.</p>
                <p>Code released under the <a href="https://github.com/thomaspark/bootswatch/blob/master/LICENSE">MIT
                        License</a>.</p>
                <p>Based on <a href="https://getbootstrap.com" rel="nofollow">Bootstrap</a>. Icons from <a
                        href="https://fontawesome.com/" rel="nofollow">Font Awesome</a>. Web fonts from <a
                        href="https://fonts.google.com/" rel="nofollow">Google</a>.</p>

            </div>
        </div>
    </footer>

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