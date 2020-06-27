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

	<!-- jumbotron(전광판) -->
    <%@ include file="./include/jumbotron.jsp" %>

    <div class="container mt-3">
        <div class="main-contents">
            <div class="row row-cols-3 justify-content-center">
                <div class="col-lg-4  text-center">
                    <div class="border-primary mb-3" style="max-width: 20rem;">
                    	<img class="mb-4 card-img-top" src="<c:url value="/resources/images/스터디.png" />" alt="스터디">
                        <div class="card-body">
                            <h4 class="card-title font-weight-bold">스터디</h4>
                            <p class="card-text">You can do it!<br> 함께라면 당신도 할 수 있습니다!</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4  text-center">
                    <div class="border-primary mb-3" style="max-width: 20rem;">
                    	<img class="mb-4 card-img-top" src="<c:url value="/resources/images/공모전.png" />" alt="공모전">
                        <div class="card-body">
                            <h4 class="card-title font-weight-bold">공모전</h4>
                            <p class="card-text">You can do it!<br> 당신도 입상 할 수 있습니다!</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4  text-center">
                    <div class="border-primary mb-3" style="max-width: 20rem;">
                    	<img class="mb-4 card-img-top" src="<c:url value="/resources/images/프로젝트.png" />" alt="프로젝트">
                        <div class="card-body">
                            <h4 class="card-title font-weight-bold">프로젝트</h4>
                            <p class="card-text">You can do it!<br> 당신도 만들 수 있습니다!</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row row-cols-2 justify-content-center">
                <div class="col-lg-4  text-center">
                    <div class="border-primary mb-3" style="max-width: 20rem;">
                    	<img class="mb-4 card-img-top" src="<c:url value="/resources/images/졸업작품.png" />" alt="졸업작품">
                        <div class="card-body">
                            <h4 class="card-title font-weight-bold">졸업작품</h4>
                            <p class="card-text">You can do it!<br> 당신도 졸업 할 수 있습니다!</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4  text-center">
                    <div class="border-primary mb-3" style="max-width: 20rem;">
                    	<img class="mb-4 card-img-top" src="<c:url value="/resources/images/포트폴리오.png" />" alt="포트폴리오">
                        <div class="card-body">
                            <h4 class="card-title font-weight-bold">포트폴리오</h4>
                            <p class="card-text">You can do it!<br> 당신도 취업 할 수 있습니다!</p>
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
