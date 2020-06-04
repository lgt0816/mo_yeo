<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./include/head.jsp"%>
</head>
<body>
	<%@ include file="./include/navbar.jsp"%>

	<div class="container">
        <form name="actModifyDTO" role="form" action="/activity/modifyPost" method="post" enctype="multipart/form-data">
        	<input type="hidden" value="${activity.encodedId }" name="encodedId">
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <th scope="row" class="table-primary text-center">제목</th>
                        <td>${activity.title }</td>
                    </tr>
                    <tr>
                        <th scope="row" class="table-primary text-center">결과</th>
                        <td><textarea name="result" id="" cols="130" rows="10">${activity.result }</textarea></td>
                    </tr>
                    <tr>
                        <th scope="row" class="table-primary text-center">소감</th>
                        <td><textarea name="thought" id="" cols="130" rows="10">${activity.thought }</textarea></td>
                    </tr>
                    <tr>
                        <th rowspan="10" scope="row" class="table-primary text-center">첨부파일</th>
                    </tr>
                    <c:forEach var="file" items="${activity.files }">
                    <tr>
                        <td>
                            <input type="hidden" name="fileId" value="${file.fileId }">
                            <a href="#">${file.fileName }</a>
                            <input class="btn btn-primary btn-sm" type="button" value="삭제">
                        </td>
                    </tr>
                    </c:forEach>
                    <!-- <tr>
                        <td><input type="file" name="files" id=""></td>
                    </tr> -->
                </tbody>
            </table>
            <div class="text-right">
                <input class="btn btn-primary" type="submit" value="완료">
                <input class="btn btn-primary" type="button" value="취소">
            </div>
        </form>
    </div>
    
	<%@ include file="./include/footer.jsp"%>
</body>
</html>