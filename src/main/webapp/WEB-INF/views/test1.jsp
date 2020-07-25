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


	function insertBtn(){

		console.log("www");
		location.href="./insert";
		
		}

	function searchMem(){

		var memLevel = $('#selectPosition').val();
		var memName = $('#searchTxt').val();

		console.log(memLevel);

		$('#selectP').val(memLevel);
		$('#searchT').val(memName);

		$('#searchMem').submit();
		
		}

	//Enterkey 실행
	function enterKey(){

		console.log("enterkey");
		if(window.event.keyCode == 13){
			console.log("enterkey2");
			//Enterkey 입력시 실행할 내용
			searchMem();
			
			}
		}
	
	function star(){

		var str1="";
		for(var i=0; i<=3; i++){
			for(var j=0; j<=i; j++){
				str1+="*";
				}
			str1+="</br>";
			}
		$('#star').html(str1);
		
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
		<label>직책 :</label>
		<select id="selectPosition">
			<option value="">전체</option>
			<option value="1">사원</option>
			<option value="2">주임</option>
			<option value="3">대리</option>
			<option value="4">과장</option>
			<option value="5">외주</option>
		</select>
		<label></label>
			<input type="text" id="searchTxt" onkeyup="enterKey();" name="searchTxt">			
			<button id="searchBtn" onclick="searchMem();">검색</button>	
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
					<td>
						<input type="checkbox" id="del_${list.num}" name="del" value="${list.num}" <c:if test="${list.del eq 'Y'}">checked</c:if>>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div id="bottomButton" style="margin-left: 512px; margin-top: 5px;">
			<button id="insertBtn" onclick="insertBtn();">등록</button>
			<button onclick="delInfo();">삭제</button>
		</div>
		
		<div id="star">
			*
			<button onclick="star();">클릭</button>
			
		</div>
		
	</div>
</div>

<form id="searchMem" action="search" method="post">
	<input type="hidden" name="searchT" id="searchT">
	<input type="hidden" name="selectP" id="selectP">
</form>

<form id="selectMem" action="detail" method="post">
	<input type="hidden" name="selNum" id="selNum">
</form>

<form id="deleteMem" action="deleteMem" method="post">
	<input type="hidden" name="delNumArr" id="delNumArr">
</form>

</body>
</html>