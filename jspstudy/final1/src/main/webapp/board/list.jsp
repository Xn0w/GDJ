<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#btn_write').click(function(event){
			location.href = '${contextPath}/board/insertPage.do';
		});
		
	});
</script>
</head>
<body>
	<div>총 게시글 : 0개</div>
	<table border="1">
	<thead>
		<tr>
			<td>순번</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
	</thead>
	<tbody>
		<td colspan ="4">새 게시글이 없습니다.</td>
	</tbody>
	<tfoot>
		<td colspan ="4"><input type = "button" value="새글작성" id="btn_write"></td>
	</tfoot>
	</table>
</body>
</html>