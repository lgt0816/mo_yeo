<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="./include/head.jsp" %>
</head>
<body>

	<%@ include file="./include/navbar.jsp" %>
	<!-- jumbotron(전광판) -->
    <%@ include file="./include/jumbotron.jsp" %>
    

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
                <label class="col-3 col-form-label text-right font-weight-bold" for="name">이름 :</label>
                <div class="col-6 col"><input type="text" name="name" class="form-control" placeholder="이름을 입력해 주세요"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-right font-weight-bold" for="email1">이메일 :</label>
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

    <%@ include file="./include/footer.jsp" %>
    
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