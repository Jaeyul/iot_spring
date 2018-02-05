<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script>
function moveView(id){	
	var sub = "form" + id;	
	document.getElementById(sub).submit();	
}

</script>

<body>
<div>
<br><br><br><br><br>
</div>

<div class="container">
<h2 >사원리스트</h2>
<br>
<table class="table table-sm table-inverse">		
	<tr>	
		<th>번호</th>
		<th>이름</th>
		<th>봉급</th>
	</tr>				
	<c:forEach items="${empList }" var="emp" varStatus="status">	
	<form action="${root }/emp/view" id="form${status.index }" method="get">	
		<tr class="tr${status.index }" id="${status.index }" onclick="moveView(id)">		
			<td><input tpye="text" id="tr${status.index }" name="empNo" value="${emp.empNo}" disabled="disabled"></td>
			<td><input tpye="text" id="tr${status.index }" name="empName" value="${emp.empName }" disabled="disabled"></td>
			<td><input tpye="text" id="tr${status.index }" name="empSal" value="${emp.empSal}" disabled="disabled"></td>			
			
			<input type="hidden" name="empNo" value="${emp.empNo}">
		</tr>			
	</form>		
	</c:forEach>
</table>
<a href="${rPath }/emp/write"><button>사원정보 추가</button></a>

</div>
</body>
</html>