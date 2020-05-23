<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>

<div>
	<table>
		<tr>
			<td>성명: </td>
			<td>${memberInfo.name}</td>
		</tr>
		<tr>
		 	<td>직급: </td>
			<td>${memberInfo.level}</td>
		</tr>
		<tr>
			<td>부서: </td>
			<td>${memberInfo.dept}</td>
		</tr>
	</table>
	<button>수정</button><button>목록</button>	
</div>

</body>
</html>