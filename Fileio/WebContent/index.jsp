<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gary文件上传</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<h2 style="margin-left: 100px">Gary文件上传服务器</h2>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>预览</th>
					<th>文件名称</th>
					<th>文件类型</th>
					<th>url</th>
					<th>创建时间</th>
				</tr>
			</thead>
			
			<tbody>
				<s:iterator value="list" var="lfile">
				<tr>
					<td><s:property value="#lfile.id"/> </td>
					<td><img style="height: 54px;width: 96px" src="${pageContext.request.contextPath }/images/<s:property value="#lfile.filename"/>"> </td>
					<td><s:property value="#lfile.filename"/></td>
					<td><s:property value="#lfile.filetype"/></td>
					<td><s:property value="#lfile.url"/></td>
					<td><s:property value="#lfile.createtime"/></td>
				</tr>
				</s:iterator>
			</tbody>
			
		</table>
	</div>
</body>
</html>