<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gary文件上传</title>
</head>
<body>

<h2>Gary文件上传</h2>

	<!-- enctype="multipart/form-data" 文件数据以二进制流传递到action -->
	<form action="${pageContext.request.contextPath}/FileAction_addFile " method="post" enctype="multipart/form-data">
		上传文件：
		<input type="file" name="upload">
		<br>
		<input type="submit" value="提交">
	</form>

</body>
</html>