<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/postInputFile" accept-charset="UTF-8" method="POST" enctype="multipart/form-data">
	<input type="file" name="file">
	<!-- <input type="text" name="src"> -->
	<input type="submit" value="전송">
</form>

</body>
</html>