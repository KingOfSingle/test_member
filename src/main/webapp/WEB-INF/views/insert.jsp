<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
</head>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>

<script type="text/javascript">

	function insertMem(){

		var name = $('#name').val();
		var level = $('#level').val();
		var dept = $('#dept').val();

		console.log(name);
		
		$('#memName').val(name);
		$('#memLevel').val(level);
		$('#memDept').val(dept);

		$('#newMem').submit();	
		
	}

</script>

<body>
<div>
	<table>
		<tr>
			<td>성명: </td>
			<td><input id="name" type="text"></td>
		</tr>
		<tr>
		 	<td>직급: </td>
		
			<td>
			<select id="level" size="1">
				<option value="1">사원</option>
				<option value="2">대리</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>부서: </td>
			<td>
			<select id="dept" size="1">
				<option value="1">CarPlay</option>
				<option value="2">AA</option>
			</select>
			</td>
		</tr>
	</table>
	<button>초기화</button><button id="insert" onclick="insertMem();">등록</button>	
</div>

<form id="newMem" action="newmem" method="post">
	<input type="hidden" name="memName" id="memName">
	<input type="hidden" name="memLevel" id="memLevel">
	<input type="hidden" name="memDept" id="memDept">
</form>

</body>
</html>