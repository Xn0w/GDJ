<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- /board/detail은 views파일-> board파일-> detail 경로가 아닌 @GetMapping("/board/detail")(폴더 구조와 상관이 없음) -->
	<a href="${contextPath}/board/detail">게시판</a>

	<hr>
	
	<a href="${contextPath}/notice/detail">공지사항</a>
</body>
</html>