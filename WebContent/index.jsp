<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传图片</title>
</head>
<body>
<h4>上传图片</h4>
<hr/>
	<form name="form"action="${pageContext.request.contextPath}/textwatermark.action" 
	method="post" enctype="multipart/form-data">
	<input type="file" name="image"multiple="multiple"/>
	<input type="submit" value="添加文字水印..."/>
	</form>
	<form name="form"action="${pageContext.request.contextPath}/imagewatermark.action" 
	method="post" enctype="multipart/form-data">
	<input type="file" name="image"multiple="multiple"/>
	<input type="submit" value="添加图片水印..."/>
	</form>	
<hr/>
</body>
</html>