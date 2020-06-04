<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./include/head.jsp"%>
<style>
        table{
            table-layout: fixed;
        }
        td{
            overflow: hidden;
            word-wrap: break-word;
        }
    </style>
</head>
<body>
	<%@ include file="./include/navbar.jsp"%>
	
	<div class="container">
        <table class="table table-bordered">
            <colgroup>
                <col width="100px" />
                <col/>
                <col width="100px" />
                <col/>
            </colgroup>
            <tbody>
                <tr>
                    <th scope="row" class="table-primary text-center">제목</th>
                    <td><c:out value="${activity.title }" /></td>
                    <th scope="row" class="table-primary text-center">부제목</th>
                    <td>${activity.subTitle }</td>
                </tr>
                <tr>
                    <th scope="row" class="table-primary text-center">팀장명</th>
                    <td>${activity.author}</td>
                    <th scope="row" class="table-primary text-center">팀원</th>
                    <td>
	                    <c:forEach var="participant" items="${activity.participants }">
		                    <c:if test="${participant ne activity.author}">
		                    	<c:out value="${participant}&nbsp" /> 
		                    </c:if>
	                    </c:forEach>
                    </td>
                </tr>
                <tr>
                    <th scope="row" class="table-primary text-center">진행기간</th>
                    <td colspan="3">${activity.startDay } ~ ${activity.endDay }</td>
                </tr>
                <tr>
                    <th scope="row"class="table-primary text-center align-middle">내용</th>
                    <td colspan="3">${activity.contents }</td>
                </tr>
                <tr>
                    <th scope="row"class="table-primary text-center align-middle">진행내용</th>
                    <td colspan="3">
                        <div class="accordion" id="accordionExample">
                            <div class="card">
                              <div class="card-header" id="headingOne">
                                <h2 class="mb-0">
                                  <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    Collapsible Group Item #1
                                  </button>
                                </h2>
                              </div>
                          
                              <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
                                <div class="card-body">
                                  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                </div>
                              </div>
                            </div>
                            
                          </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row"class="table-primary text-center align-middle">결과</th>
                    <td colspan="3">${activity.result }</td>
                </tr>
                <tr>
                    <th scope="row"class="table-primary text-center align-middle">소감</th>
                    <td colspan="3">${activity.thought }</td>
                </tr>
                <tr>
                    <th scope="row"class="table-primary text-center align-middle">결과파일</th>
                    <td colspan="3">
                    	<!-- 파일들 넣으면 됨 -->
                    	<c:forEach var="file" items="${activity.files }">
                    		<a href="#">${file.fileName }<small>(${file.fileSize })</small></a>
                    	</c:forEach>
                    </td>
                </tr>
            </tbody>
        </table>
        <div class="text-right">
            <a href="/activity/modify?activityId=${activity.encodedId }" class="btn btn-primary">수정</a>
            <a href="#" class="btn btn-primary">목록</a>
            <a href="#" class="btn btn-primary">포트폴리오 등록</a>
        </div>
    </div>

	<%@ include file="./include/footer.jsp"%>
</body>
</html>