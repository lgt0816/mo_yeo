<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./include/head.jsp"%>
<script type="text/javascript" src='<c:out value="/resources/js/activityModify.js" />'></script>
</head>
<body>
	<%@ include file="./include/navbar.jsp"%>
	<!-- jumbotron(전광판) -->
    <%@ include file="./include/jumbotron.jsp" %>

	<div class="container mt-3">
        <form name="actModifyDTO" role="form" action="/activity/modifyPost" method="post" enctype="multipart/form-data">
        	<input type="hidden" value="${activity.encodedId }" name="encodedId">
        	<input type="hidden" value="${activity.title }" name="activityTitle">
        	<input type="hidden" value="${activity.activityType }" name="activityType">
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <th scope="row" class="table-primary text-center">제목</th>
                        <td>${activity.title }</td>
                    </tr>
                    <tr>
                        <th scope="row" class="table-primary text-center">결과</th>
                        <td><textarea name="result" id="" cols="130" rows="10">${activity.activityResult.result }</textarea></td>
                    </tr>
                    <tr>
                        <th scope="row" class="table-primary text-center">소감</th>
                        <td><textarea name="thought" id="" cols="130" rows="10">${activity.activityResult.thought }</textarea></td>
                    </tr>
                    <tr>
                        <th rowspan="10" scope="row" class="table-primary text-center">첨부파일</th>
                    </tr>
                    <c:forEach var="file" items="${activity.files }">
                    <tr>
                        <td>
                            <%-- <input type="hidden" name="fileId" value="${file.fileId }"> --%>
                            <a href="/activity/fileDownload?fileId=${file.encodedId }">${file.fileName }</a>
                            <a href="/activity/fileDelete?fileId=${file.encodedId }&activityId=${activity.encodedId}"class="btn btn-primary btn-sm">삭제</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="text-right">
            	<input class="btn btn-primary" type="button" id="addFile" value="파일 추가">
                <input class="btn btn-primary" type="submit" value="완료">
                <input class="btn btn-primary" type="button" value="취소" onclick="javascript:history.back();">
            </div>
        </form>
    </div>
    
	<%@ include file="./include/footer.jsp"%>
</body>
</html>