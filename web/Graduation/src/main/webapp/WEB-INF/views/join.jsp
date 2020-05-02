<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%-- trimDirectiveWhitespaces="true"는 html로 변환시 빈줄을 제거해준다 --%>
<%-- jstl c태그 라이브러리 사용 추가 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" >
<script type="text/javascript" src='<c:url value="resources/js/join.js"/>'></script>
<title>모여라 여기로</title>
</head>
<body>

	<%-- <form action="/joinPost" method="post" role="form" id="joinForm">
		hidden속성의 input태그는 아이디 중복확인결과와 메일 인증 결과를 value에 담고 있습니다. String형태임
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
		
		<button type="button" id="singUp">Sign up</button>
	</form> --%>
	 <!--네비게이션 바-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
            aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
            </ul>
        </div>
    </nav>

    <!--컨테이너-->
    <div class="container my-5 py-3 bg-light">
        <form action="/joinPost" method="post" role="form" id="joinForm">
            <input type="hidden" id="checkIdClear" value="false">
            <input type="hidden" id="authorizationMailClear" value="false">

            <div class="form-group row">
                <h1 class="col-12 pt-4 text-center">회원가입</h1>
            </div>
            <hr class="bg-primary">
            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="userId">아이디 :</label>
                <div class="col-6"><input type="text" id="userId" name="userId" class="form-control"
                        placeholder="아이디는 자신의 학번으로 입력해주세요" /></div>
                <div class="col-3"><input class="btn btn-primary" type="button" id="checkId" name="checkId"
                        value="아이디 중복 확인"></div>
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="userPw1">비밀번호 : </label>
                <div class="col-6"><input type="password" id="userPw1" name="userPw1" class="form-control"
                        placeholder="비밀번호를 입력해 주세요." value="" /></div>
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="">비밀번호 확인 : </label>
                <div class="col-6"><input type="password" id="userPw2" name="userPw2" class="form-control"
                        placeholder="다시한번 비밀번호를 입력해 주세요." value="" /></div>
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="">이름 : </label>
                <div class="col-6">
                    <input type="text" id="name" name="name" class="form-control" placeholder="이름을 입력해주세요." />
                </div>
            </div>

            <div class="form-group row">
                <label for="" class="col-3 col-form-label text-right">성별 : </label>
                <!-- <div class="col-6"><input type="text" id="sex" name="sex" class="form-control"
                        placeholder="성별을 입력해주세요" /></div> -->

                <div class="custom-control custom-radio mx-3 pt-2">
                    <input type="radio" id="customRadio1" name="sex" class="custom-control-input sex" checked="" value="남자">
                    <label class="custom-control-label" for="customRadio1">남자</label>
                </div>
                <div class="custom-control custom-radio mx-3 pt-2">
                    <input type="radio" id="customRadio2" name="sex" class="custom-control-input sex" value="여자">
                    <label class="custom-control-label" for="customRadio2">여자</label>
                </div>
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
                <div class="col-3"><input type="text" id="email1" name="email1" class="form-control"
                        placeholder="이메일을 입력해주세요" /></div>
                <label class="col-form-label" for="">@</label>
                <div class="col-3">
                    <select class="form-control" name="email2" id="email2">
                        <option>sungkyul.ac.kr</option>
                        <option>office.sungkyul.ac.kr</option>
                    </select>
                </div>
                <div class="col-2"><input type="button" class="btn btn-primary" id="sendAuthorizationMail"
                        value="인증 메일 보내기"></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="">인증번호 : </label>
                <div class="col-6"><input type="text" id="authorizationCode" class="form-control"
                        placeholder="인증번호를 입력해주세요"></div>
                <div class="col-2"><input type="button" id="checkAuthorizationCode" value="인증하기"
                        class="btn btn-primary"></div>
            </div>

            <div class="row">
                <div class="col-6 text-right"><button type="button" id="singUp" class="btn btn-primary">완료</button></div>
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
	

</body>
</html>