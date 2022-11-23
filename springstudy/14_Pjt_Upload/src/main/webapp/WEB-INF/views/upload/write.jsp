<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>

	$(function(){
		fn_fileCheck();
	});
	
	function fn_fileCheck(){
		
		$('#files').change(function(){
			
			// 첨부 가능한 파일의 최대 크기
			let maxSize = 1024 * 1024 * 10;	// 10MB
			
			// 첨부된 파일 목록
			// this가 files역할
			let files = this.files;
			
			// 첨부된 파일 순회
			for(let i = 0; i < files.length; i++) {
				
				// 크기 체크
				if(files[i].size > maxSize){
					alert('10MB 이하의 파일만 첨부할 수 있습니다.');
					$(this).val('');	// 첨부된 파일을 모두 없어줌
					return;
				} 
				
			}
			
		});
		
	}
</script>
</head>
<body>
	<div>
		
		<h1>작성화면</h1>
		<!-- 파일 첨부할 때의 기본적인 폼 형태(method와 enctype 필수) -->
		<form action="${contextPath}/upload/add" method="post" enctype="multipart/form-data">
		
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" required="required">
			</div>
			<div>
				<label for="content">내용</label>
				<input type="text" id="content" name="content">
			</div>
			<div>
			<!-- multiple이 없으면 다중 첨부가 안된다. -->
				<label for="files">첨부</label>
				<input type="file" id="files" name="files" multiple="multiple">
			</div>
			<div>
				<button>작성완료</button>
				<input type="button" value="목록" onclick="location.href="${contextPath}/upload/list'">
			</div>					
		</form>
	</div>
	
</body>
</html>