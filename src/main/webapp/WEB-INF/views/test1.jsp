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
		
		$('#selNum').val(i);

		$('#selectMem').submit();
				
		}

	function delInfo(){
	alert("삭제로 옴 ");
		
		var chkbox = document.getElementsByName('del');
		var delNumArr = "";

		
 		for(var i=0; i<chkbox.length; i++){
 	  			if(chkbox[i].checked){
 				delNumArr = delNumArr +"," +chkbox[i].value; // ,1,2,3
 				}
 			}

		alert(delNumArr);

		$('#delNumArr').val(delNumArr);
		$('#deleteMem').submit();

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
					<td>
						<input type="checkbox" id="del_${list.num}" name="del" value="${list.num}" <c:if test="${list.del eq 'Y'}">checked</c:if>>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div id="bottomButton" style="margin-left: 512px; margin-top: 5px;">
			<button><a href="insert">등록</a></button>
			<button onclick="delInfo();">삭제</button>
		</div>
	</div>
</div>

<form id="selectMem" action="detail" method="post">
	<input type="hidden" name="selNum" id="selNum">
</form>

<form id="deleteMem" action="deleteMem" method="post">
	<input type="hidden" name="delNumArr" id="delNumArr">
</form>

</body>
</html>