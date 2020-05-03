<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<html>
<head>
<%@ include file="./include/head.jsp" %>

</head>
<body>
	<!-- nav bar -->
	<%@ include file="./include/navbar.jsp" %>	


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

	<!-- 풋터 -->
	<%@ include file="./include/footer.jsp" %>
    
</body>
</html>
