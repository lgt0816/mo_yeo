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
		<div class="accordion" id="accordionExample">
			<c:forEach var="portfolio" items="${portfolios }" varStatus="status">
			<div class="card">
				<div class="card-header" id="heading${status.index }">
					<h2 class="mb-0">
						<button class="btn btn-link btn-block text-left" type="button"
							data-toggle="collapse" data-target="#collapse${status.index }"
							aria-expanded="true" aria-controls="collapse${status.index }"><c:out value="${portfolio.title }" />
						</button>
					</h2>
				</div>

				<div id="collapse${status.index }" class="collapse" aria-labelledby="heading${status.index }"
					data-parent="#accordionExample">
					<div class="card-body row">
						<!--포트폴리오에 등록된 활동들-->
						<c:forEach var="activity" items="${portfolio.activitys }">
						<a class="col col-sm-4" href="/activity/detail?activityId=${activity.encodedId }">
							<div class="card mb-3">
								<div class="card-body">
									<h5 class="card-title">${activity.title }</h5>
									<p class="card-text">${activity.contents }</p>
									<p class="card-text">
										<small class="text-muted">${activity.startDay } ~ ${activity.endDay }</small>
									</p>
								</div>
							</div>
						</a>
						</c:forEach>
						
					</div>
					
					<div class="text-right mb-3 mr-3">
						<a href="" class="btn btn-primary">수정</a> 
						<a href="" class="btn btn-primary">삭제</a> 
						<a href="" class="btn btn-primary">pdf로 한번에 보기</a>
					</div>
				</div>
			</div>
			</c:forEach>

		</div>
	</div>

	<%@ include file="./include/footer.jsp"%>
</body>
</html>