<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script>
function reviseEmp(){
	$("#empName").attr("disabled", false);
	$("#empSal").attr("disabled", false);	
	
}

function deleteEmp(id){
	var empNo = "empNo=" + id;
	$.ajax({
		url : "${root}/emp/delete",
		data : empNo,
		success : function(res){			
			alert("삭제성공ㅋ");	
			
		}	
	})		
}

function updateEmp(){
	var empNo = $("#empNo").val();
	var empName = $("#empName").val();
	var empSal = $("#empSal").val();
	
	var param = "empNo=" + empNo +"&empName=" + empName + "&empSal=" + empSal;
	$.ajax({
		url : "${root}/emp/update",
		data : param,
		success : function(res){			
			alert("수정성공ㅋ");				
		}	
	})		
}



</script>

<body><div>
<br><br><br><br><br>
</div>

<input type="button" value="revise" onclick="reviseEmp()">
<table class="table table-sm table-inverse">		
	<tr>	
		<th>번호</th>
		<th>이름</th>
		<th>봉급</th>
	</tr>		
	
	<tr>
		<td><input tpye="text" id="empNo" value="${emp.empNo}" disabled="disabled"></td>
		<td><input tpye="text" id="empName" value="${emp.empName }" disabled="disabled"></td>
		<td><input tpye="text" id="empSal" value="${emp.empSal}" disabled="disabled"></td>
	</tr>	
</table>

<input type="button" value="delete" id="${emp.empNo }" onclick="deleteEmp(id)">
<input type="button" value="update" onclick="updateEmp()">


</body>
</html>