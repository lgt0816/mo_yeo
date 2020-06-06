<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./include/head.jsp"%>
</head>
<body>
	<%@ include file="./include/navbar.jsp"%>

	<!-- 컨테이너  -->
	<div class="container my-5 py-3 bg-light">
		<!-- 학년구분 -->
		<c:forEach var="map" items="${map}">
		<div class="row">
			<div class="col-2">
				<h4 class="text-right mr-2">${map.key }학년</h4>
				<hr class="mt-0 bg-primary">
			</div>
			<div class="col-10">
				<div class="row">
					<!-- 완료된활동 목록 -->
					<c:forEach var="activity" items="${map.value }">
					<a class="col col-sm-4" href="/activity/detail?activityId=${activity.encodedId }">
						<div class="card mb-3">
							<div class="card-body">
								<h5 class="card-title">${activity.title }   <c:out value="(${activity.activityType })" /></h5>
								<p class="card-text">${activity.contents }</p>
								<p class="card-text">
									<small class="text-muted">${activity.startDay } ~ ${activity.endDay }</small>
								</p>
							</div>
						</div>
					</a>
					</c:forEach>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<%@ include file="./include/footer.jsp"%>
</body>
</html>