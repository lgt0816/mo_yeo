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
</head>
<body>

	<!--네비게이션 바-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
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
        </div>
        

        <a class="navbar-brand" href="login.html">로그인</a>
    </nav>
    

    <!--컨테이너-->
    <div class="container my-5 py-3 bg-light">
        <h1 class="ml-4">아이디 찾기</h1><hr class="bg-primary">
        <form action="/findUserId" id="findUserId" name="findUserId" method="post">
            <div class="form-group row mt-5">
                <label class="col-3 col-form-label text-right font-weight-bold" for="userId">이름 :</label>
                <div class="col-6 col"><input type="text" name="name" class="form-control" placeholder="이름을 입력해 주세요"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-right font-weight-bold" for="userId">이메일 :</label>
                <div class="col-3 col"><input type="text" name="email1" class="form-control" placeholder="이메일을 입력해 주세요" /></div>
                <strong class="col-form-label">@</strong>
                <div class="col-3 col">
                    <select name="email2" class="form-control">
                        <option>sungkyul.ac.kr</option>
                        <option>office.sungkyul.ac.kr</option>
                    </select>
                </div>
            </div>
            <div class="form-group row my-4">
                <div class="col-12 text-center">
                    <input type="submit" name ="submit" value="아이디 찾기" class="btn btn-primary" />
                </div>
            </div>
        </form>
        <br>
        <h1 class="ml-4">비밀번호 찾기</h1><hr class="bg-primary">
        <form action="/findUserPw" id="findUserPw" name="findUserPw" method="post">
            <div class="form-group row mt-5">
                <label class="col-3 col-form-label text-right font-weight-bold" for="userId">아이디 :</label>
                <div class="col-6 col"><input type="text" name="userId" class="form-control" placeholder="아이디를 입력해 주세요."/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-right font-weight-bold" for="userId">이름 :</label>
                <div class="col-6 col"><input type="text" name="name" class="form-control" placeholder="이름을 입력해 주세요"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-right font-weight-bold" for="userId">이메일 :</label>
                <div class="col-3 col"><input type="text" name="email1" class="form-control" placeholder="이메일을 입력해 주세요." /></div>
                <strong class="col-form-label">@</strong>
                <div class="col-3 col">
                    <select name="email2" class="form-control">
                        <option>sungkyul.ac.kr</option>
                        <option>office.sungkyul.ac.kr</option>
                    </select>
                </div>
            </div>
            <div class="form-group row my-4">
                <div class="col-12 text-center">
                    <input type="submit" name ="submit" value="비밀번호 찾기" class="btn btn-primary" />
                </div>
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
	<!-- <h1>아이디 찾기</h1>
	<form action="/findUserId" id="findUserId" name="findUserId" method="post">
		이름 : 
		<input type="text" name="name" /><br>
		이메일 : 
		<input type="text" id="email1" name="email1" class="form-control" placeholder="User Email..." />
		@
		<select name="email2" id="email2">
			<option>sungkyul.ac.kr</option>
			<option>office.sungkyul.ac.kr</option>
		</select><br>
		<input type="submit" name ="submit" value="아이디 찾기" /><br>
	</form>
	<hr>
	<h1>비밀번호 찾기</h1>
	<form action="/findUserPw" id="findUserPw" name="findUserPw" method="post">
		아이디 : 
		<input type="text" name="userId"><br>
		이름 : 
		<input type="text" name="name"><br>
		이메일 : 
		<input type="text" id="email1" name="email1" class="form-control" placeholder="User Email..." />
		@
		<select name="email2" id="email2">
			<option>sungkyul.ac.kr</option>
			<option>office.sungkyul.ac.kr</option>
		</select><br>
		<input type="submit" value="비밀번호 찾기"><br>
	</form> -->
</body>
</html>