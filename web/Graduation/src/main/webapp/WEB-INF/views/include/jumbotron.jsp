<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--전광판 convers 넣을 예정-->
<!-- <div class="jumbotron"> -->
	<!-- <h1 class="display-3">Hello, world!</h1>
	<p class="lead">This is a simple hero unit, a simple
		jumbotron-style component for calling extra attention to featured
		content or information.</p>
	<hr class="my-4">
	<p>It uses utility classes for typography and spacing to space
		content out within the larger container.</p>
	<p class="lead">
		<a class="btn btn-primary btn-lg" href="#" role="button">Learn
			more</a>
	</p> -->

	<div id="carousel" class="carousel slide carousel-fade"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src='<c:out value="/resources/images/jumbotron_01.png" />' class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="<c:out value="/resources/images/jumbotron_02.png" />" class="d-block w-100" alt="...">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carousel"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carousel"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
<!-- </div> -->