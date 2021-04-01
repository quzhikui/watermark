<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>处理结果</title>
</head>
<body>
<table width="99%" align="center">
	<tr>
		<td>处理成功!!!</td>
	</tr>
	<tr>
		<td width="50%"	width="350"/>文件输出路径：
		<s:property value="picInfo.outputPath"/>
		</td>
	</tr>
</table>
</body>
</html>