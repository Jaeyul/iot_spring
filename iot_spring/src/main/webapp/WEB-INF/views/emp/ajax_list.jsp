<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	var au = new AjaxUtil("${root}/emp/lista",null,"GET","json");

	function callback(res){	
		alert(res.msg);
		$("#empTable").bootstrapTable('load',{data:res.empList});		
	}
	au.setCallbackSuccess(callback)
	au.send(); 	
});



</script>
<body>
<div>
<br><br><br><br><br>
</div>

<div class="container">
<h2 >사원리스트</h2>
<br>
<table data-toggle="table" id="empTable">	
	<thead>	
	<tr>	
		<th data-field="empNo">번호</th>
		<th data-field="empName">이름</th>
		<th data-field="empSal">봉급</th>
	</tr>				
	</thead>	
</table>
<a href="${rPath }/emp/write"><button>사원정보 추가</button></a>



</div>
</body>
</html>