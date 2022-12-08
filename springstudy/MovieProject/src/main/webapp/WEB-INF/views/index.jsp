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
<script
>
	$(function(){
		fnSearchAll();
		fnSearch();
		fnInit();
	});

	function fnSearchAll() {
		$.ajax({
			type: 'get',
			url: '${contextPath}/searchAllMovies',
			dataType: 'json',
			success: function(resData) {
				alert(resData.message);
				$('#list').empty();
				if (resData.status == 200) {
					$.each(resData.list, function(idx, movie) {
						$('<tr>')
						.append($('<td>').html(movie.title))
						.append($('<td>').html(movie.genre))
						.append($('<td>').html(movie.description))
						.append($('<td>').html(movie.star))
						.appendTo('#list');
					});
				} else if (resData.status == 500) {
					$('<tr>')
					.append($('<td colspan="4">').html('검색 결과가 없습니다.'))
					.appendTo('#list');
				}
			}
		});
	}
	
	function fnSearch() {
		$('#btnSearch').click(function() {
			$('#list').empty();
			$.ajax({
				type: 'get',
				url: '${contextPath}/searchMovie',
				data: 'column=' + $('#column').val() + '&searchText=' + $('#searchText').val(),
				dataType: 'json',
				success: function(resData) {
					alert(resData.message);
					$('#list').empty();
					if (resData.status == 200) {
						$.each(resData.list, function(idx, movie) {
							$('<tr>')
							.append($('<td>').html(movie.title))
							.append($('<td>').html(movie.genre))
							.append($('<td>').html(movie.description))
							.append($('<td>').html(movie.star))
							.appendTo('#list');
						});
					} else if (resData.status == 500) {
						$('<tr>')
						.append($('<td colspan="4">').html('검색 결과가 없습니다.'))
						.appendTo('#list');
					}
				}
			});
		});
	}
	
	function fnInit() {
		$('#btnInit').click(function(){
			fnSearchAll();
		});
	}
	
</script>
</head>
<body>

	<form method="get">
		
		<select id="column" name="column">
			<option value="TITLE">제목</option>
			<option value="GENRE">장르</option>
			<option value="DESCRIPTION">내용</option>
		</select>
		<input type="text" id="searchText" name="searchText">
		<input type="button" id="btnSearch" value="검색">
		<input type="button" id="btnInit" value="초기화">
		
		<br><hr><br>
		
		<table border="1">
			<thead>
				<tr>
					<td>제목</td>
					<td>장르</td>
					<td>내용</td>
					<td>평점</td>
				</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>
		
	</form>

</body>
</html>