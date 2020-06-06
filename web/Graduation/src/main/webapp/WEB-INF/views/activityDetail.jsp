<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./include/head.jsp"%>
<style>
table {
	table-layout: fixed;
}

td {
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
				<col />
				<col width="100px" />
				<col />
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
					<td><c:forEach var="participant"
							items="${activity.participants }">
							<c:if test="${participant ne activity.author}">
								<c:out value="${participant}&nbsp" />
							</c:if>
						</c:forEach></td>
				</tr>
				<tr>
					<th scope="row" class="table-primary text-center">활동 타입</th>
					<td colspan="3">${activity.activityType }</td>
				</tr>
				<tr>
					<th scope="row" class="table-primary text-center">진행기간</th>
					<td colspan="3">${activity.startDay }~ ${activity.endDay }</td>
				</tr>
				<tr>
					<th scope="row" class="table-primary text-center align-middle">내용</th>
					<td colspan="3">${activity.contents }</td>
				</tr>
				<tr>
					<th scope="row" class="table-primary text-center align-middle">진행내용</th>
					<td colspan="3">
						<div class="accordion" id="accordionExample">
						<c:forEach var="activityPlan" items="${activity.activityPlans }" varStatus="status">
							<div class="card">
								<div class="card-header" id="heading${status.index }">
									<h2 class="mb-0">
										<button class="btn btn-link btn-block text-left" type="button"
											data-toggle="collapse" data-target="#collapse${status.index }"
											aria-expanded="true" aria-controls="collapse${status.index }">
											${activityPlan.planTitle }
											<small class="text-right">${activityPlan.planStartDay } ~ ${activityPlan.planEndDay }</small>
											</button>
									</h2>
								</div>

								<div id="collapse${status.index }" class="collapse"
									aria-labelledby="heading${status.index }" data-parent="#accordionExample">
									<div class="card-body">
										${activityPlan.planContents }
										<c:forEach var="activityPlanStatus" items="${activityPlan.planStatusList }">
										<table>
											<colgroup>
												<col width="150px" />
												<col />
											</colgroup>
											<tbody>
												<tr>
													<th class="table-primary text-center">중간 보고 제목</th>
													<td>${activityPlanStatus.planStatusTitle }</td>
												</tr>
												<tr>
													<th scope="row"
														class="table-primary text-center align-middle">내용</th>
													<td>
														${activityPlanStatus.planStatusContents }
													</td>
												</tr>
											</tbody>
										</table>
										</c:forEach>
									</div>
								</div>
							</div>
							 </c:forEach>

						</div>
					</td>
				</tr>
				<tr>
					<th scope="row" class="table-primary text-center align-middle">결과</th>
					<td colspan="3">${activity.activityResult.result }</td>
				</tr>
				<tr>
					<th scope="row" class="table-primary text-center align-middle">소감</th>
					<td colspan="3">${activity.activityResult.thought }</td>
				</tr>
				<tr>
					<th scope="row" class="table-primary text-center align-middle">결과파일</th>
					<td colspan="3">
						<c:forEach var="file"
							items="${activity.files }">
							<p><a href="/activity/fileDownload?fileId=${file.encodedId }">${file.fileName }<small>(${file.fileSize }Byte)</small></a></p>
						</c:forEach>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="text-right">
			<a href="/activity/modify?activityId=${activity.encodedId }"
				class="btn btn-primary">수정</a> <a href="${goListUrl }"
				class="btn btn-primary">목록</a>
		</div>
	</div>

	<%@ include file="./include/footer.jsp"%>
</body>
</html>