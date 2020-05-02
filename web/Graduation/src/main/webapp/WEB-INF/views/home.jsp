<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>모여라 여기로</title>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" >
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

    <!--전광판 convers 넣을 예정-->
    <div class="jumbotron">
        <h1 class="display-3">Hello, world!</h1>
        <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
        <hr class="my-4">
        <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
        <p class="lead">
          <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
        </p>
    </div>

    <div class="container">
        <div class="main-contents">
            <div class="row row-cols-3 justify-content-center">
                <div class="col-lg-4  text-center">
                    <div class="border-primary mb-3" style="max-width: 20rem;">
                        <div class="card-body">
                            <img class="mb-4" src="<c:url value="/resources/images/스터디.png" />" alt="스터디">
                            <h4 class="card-title font-weight-bold">스터디</h4>
                            <p class="card-text">스터디 기능 설명</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4  text-center">
                    <div class="border-primary mb-3" style="max-width: 20rem;">
                        <div class="card-body">
                            <img class="mb-4" src="<c:url value="/resources/images/공모전.png" />" alt="공모전">
                            <h4 class="card-title font-weight-bold">공모전</h4>
                            <p class="card-text">공모전 기능 설명</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4  text-center">
                    <div class="border-primary mb-3" style="max-width: 20rem;">
                        <div class="card-body">
                            <img class="mb-4" src="<c:url value="/resources/images/프로젝트.png" />" alt="프로젝트">
                            <h4 class="card-title font-weight-bold">프로젝트</h4>
                            <p class="card-text">프로젝트 기능 설명</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row row-cols-2 justify-content-center">
                <div class="col-lg-4  text-center">
                    <div class="border-primary mb-3" style="max-width: 20rem;">
                        <div class="card-body">
                            <img class="mb-4" src="<c:url value="/resources/images/졸업작품.png" />" alt="졸업작품">
                            <h4 class="card-title font-weight-bold">졸업작품</h4>
                            <p class="card-text">졸업작품 기능 설명</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4  text-center">
                    <div class="border-primary mb-3" style="max-width: 20rem;">
                        <div class="card-body">
                            <img class="mb-4" src="<c:url value="/resources/images/스터디.png" />" alt="포트폴리오">
                            <h4 class="card-title font-weight-bold">포트폴리오</h4>
                            <p class="card-text">포트폴리오 기능 설명</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
