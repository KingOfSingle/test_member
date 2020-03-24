<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>

<script type="text/javascript">
	function viewInfo(listNum){
		var i = listNum;

		$('#listNm').val(i);

		$('#selectMem').submit();
				
		}

</script>

<style>
table,th,td{
	    border-top: 1px solid black;
	    border-collapse: collapse;
	}
	
	#memlist td {
		width:25%;
		border-bottom: 1px solid red;
	}
	
.testhover {
cursor: pointer;
}
</style>

<body>
<div>
	<div id="member" style="margin: 200px auto; width: max-content;">
		<div id="memSearch" style="margin-left: 375px;">
			<input type="text">
			<button>검색</button>	
		</div>
		<table id="memlist" style="width: 600px; margin-top: 5px">
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>직급</td>
				<td>부서</td>
				<td>del</td>
			</tr>
			<c:forEach items="${memList}" var="list">
				<tr>
					<td>${list.num}</td>
					<td class="testhover" onclick="viewInfo('${list.num}');">${list.name}</td>
					<td>${list.level}</td>
					<td>${list.dept}</td>
					<td>${list.del}</td>
				</tr>
			</c:forEach>
		</table>
		<div id="bottomButton" style="margin-left: 512px; margin-top: 5px;">
			<button><a href="insert">등록</a></button><button>삭제</button>
		</div>
	</div>
</div>

<form id="selectMem" action="memInfo" method="post">
	<input type="hidden" name="selNm" id="selNm">
	
</form>

</body>
</html>