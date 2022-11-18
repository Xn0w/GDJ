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
		pro1();
		pro2();
		pro3();
	});
	
	function pro1(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData){
				 $('#project').empty();
				$.each(resData, function(i, staff){				
					
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					$('#project').append(tr);
					
					/*
					
					$('<tr>')
					.append( $('<td>').text(staff.sno))
					.append( $('<td>').text(staff.name))
					.append( $('<td>').text(staff.dept))
					.append( $('<td>').text(staff.salary))
					.appendTo('#목록id');
					
					*/
				});
			}
		});
	}
	
	function pro2() {
		$('#btn1').click(function(){
			if( /^[0-9]{5}$/.test($('#sno').val()) == false ) {
				alert('사원번호는 5자리 숫자입니다.');
				return;
			} else if( /^[가-힣]{3}$/.test($('#dept').val()) == false) {
				alert('부서는 3~5자리 한글입니다.');
				return;
			}
			
			$.ajax({
				type: 'post',
				url: '${contextPath}/add',
				data: $('#frm1').serialize(),
				data: 'sno=' + $('#sno').val() + '$name=' + $('#name').val() + '$dept=' + $('#dept').val(),
				dataType: 'text',
				success: function(resData){
					alert(resData);
					pro1();
					$('#sno').val('')
					// $('#sno').value = '';
					document.getElementById('sno').value = '';
				},
				error: function(jqXHR){
					alert(jqXHR.responseText);
				}
			});
		});
	}
	
	function pro3() {
		$('#btn2').click(function(){
			$.ajax({
				type : "get",
				url : '${contextPath}/search',
				dataType: 'json',
				success : function(resData) {
					alert(resData);
				},
				error : function(error) {
					alert('조회된 정보가 없습니다.');
				}
			});
		});
	}
</script>
</head>
<body>

	<h3>사원등록</h3>
	<form id="frm1">
		<input type="text" id="sno" name="sno" placeholder="사원번호">
		<input type="text" id="name" name="name" placeholder="사원명">
		<input type="text" id="dept" name="dept" placeholder="부서명">
		<input type="button" value="등록" id="btn1">
	</form>
	
	<h3>사원조회</h3>
	<form id="frm2">
		<input type="text" id="sno" name="sno" placeholder="11111">
		<input type="button" value="조회" id="btn2" class="btn2">
		<input type="button" value="전체" id="btn3" class="btn3">		
	</form>
	
	
	<h3>사원목록</h3>
	<table border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>연봉</td>
			</tr>
		</thead>
		<tbody>
			<tbody id="project"></tbody>
		</tbody>
	</table>
	
</body>
</html>