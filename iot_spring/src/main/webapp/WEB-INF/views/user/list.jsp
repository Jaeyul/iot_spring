<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
div#winVP {
	position: relative;
	height: 300;
	border: 1px solid #dfdfdf;
	margin: 10px;
}
</style>
<script>
var mygrid;
$(document).ready(function(){
	mygrid = new dhtmlXGridObject('winVP');
	mygrid.setImagePath("${dPath}/imgs/");                 
	mygrid.setHeader("번호,아이디,이메일");
	mygrid.enableColumnAutoSize(true);      
	mygrid.setColAlign("left,left,left");       
	mygrid.setColTypes("ro,ed,ed");               
	mygrid.setColSorting("int,str,str");          
	mygrid.setColumnIds("uiNo,uiID,uiEmail");
	mygrid.init();    
	
	var au2 = new AjaxUtil("${root}/user/list",null,"GET","json");	
	
	function listCallback(res){	
		console.log(res.userList);		
		mygrid.parse({data:res}, "js");				
	}
	
	au2.setCallbackSuccess(listCallback)
	au2.send(); 
	
	mygrid.attachEvent("onRowSelect", function(rowId,cellIndex){		
		alert("rowid 는 : " + rowId + "cellIndex 는 : " +cellIndex);		
		var cellObj = mygrid.cellById(rowId, cellIndex);
		var colId=mygrid.getColumnId(cellIndex);
		console.log(cellObj);		
		alert(cellObj.getValue());		
		alert(colId);
		
		document.getElementById("hidden").name = colId;
		document.getElementById("hidden").value = cellObj.getValue();
		document.getElementById("form").submit();
		
		
		//var data = mygrid.getRowData(rowId);
		//console.log(data);
		
	});		
	
})


</script>
<body>
	<div><br><br><br><br><br></div>
	<div id="winVP"></div>		
	
	<form action="${root }/user/view" method="get" id="form">
	<input type="hidden" name="" value="" id="hidden">			
	</form>
	
</body>
</html>