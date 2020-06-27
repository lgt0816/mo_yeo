<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./include/head.jsp"%>
</head>
<body>
	<%@ include file="./include/navbar.jsp"%>
	<!-- jumbotron(전광판) -->
    <%@ include file="./include/jumbotron.jsp" %>
	
	<div class="container mt-3">
        <form action="/portfolio/modifyPost" method="post">
        <input type="hidden" name="portfolioId" value="<c:out value="${portfolio.encodedId }" />">
            <div class="row">
                <label for="title" class="col-1 col-form-label text-right font-weight-bold">제목</label>
                <div class="col"><input class="form-control" type="text" name="portfolioTitle" id="title" value="${portfolio.title }"></div>
            </div>
            <hr class="bg-primary">
            <div class="row">
                <label class="col-form-label text-right font-weight-bold">완료된 활동 목록</label>
                <div class="col form-check">
                    <!--완료된 활동들-->
                    <div class="row row-cols-1 btn-group-toggle" data-toggle="buttons">
                    <c:forEach var="activity" items="${allActivitys }">
                            <label class="btn btn-primary mb-2">
                                <input type="checkbox" name="activityIds" value="${activity.encodedId }"
                                <c:forEach var="includedActivity" items="${portfolio.activitys }">
                                <c:if test="${activity.activityId eq includedActivity.activityId }">checked</c:if>
                                </c:forEach>>
                                ${activity.title } (${activity.activityType }) &emsp;&emsp; ${activity.startDay } ~${activity.endDay } 
                            </label>
					</c:forEach>
					</div>

                </div>
            </div>
            <div class="row justify-content-center">
                <input class="btn btn-primary mr-1 align-middle" type="submit" value="완료">
                <input class="btn btn-primary" type="button" value="취소" onclick="javascript:history.back();">
            </div>
        </form>
    </div>
	
	
	
	<%@ include file="./include/footer.jsp"%>
</body>
</html>