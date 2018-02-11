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
	height: 150;
	border: 1px solid #dfdfdf;
	margin: 10px;
}
</style>
<script>
var mygrid;
console.log("${ui}");
$(document).ready(function(){
	mygrid = new dhtmlXGridObject('winVP');
	mygrid.setImagePath("${dPath}/imgs/");                 
	mygrid.setHeader("번호,이름,아이디,비밀번호,이메일,권리자권한");
	
	mygrid.enableColumnAutoSize(true);      
	mygrid.setColAlign("left,left,left,left,left,left");       
	mygrid.setColTypes("ro,ed,ed,ed,ed,ed");               
	mygrid.setColSorting("int,str,str,str,str,int");          
	mygrid.setColumnIds("uiNo,uiName,uiID,uiPwd,uiEmail,admin");
	mygrid.init();   	
	
	var json = {};
	var idStr, vStr;
	var tests = document.getElementsByName("aaa");
	for(var v of tests){
		idStr = v.id;
		vStr = v.value;
		json[idStr] = vStr;		
	}
	var List = [];
	List.push(json);
	mygrid.parse({data:List}, "js");	
	
	/* mygrid.attachEvent("onRowSelect", function(rowId,cellIndex){		
		alert("rowid 는 : " + rowId + "cellIndex 는 : " +cellIndex);		
		var cellObj = mygrid.cellById(rowId, cellIndex);
		var colId=mygrid.getColumnId(cellIndex);
		console.log(cellObj);		
		alert(cellObj.getValue());		
		alert(colId);
		
		document.getElementById("hidden").name = colId;
		document.getElementById("hidden").value = cellObj.getValue();		
		//var data = mygrid.getRowData(rowId);
		//console.log(data);		
	});		 */	
});

var au;
var cellObj,colId;
function revise(id){
	if(id=="delete"){
		if(confirm("정말로 삭제하시겠습니까?")){
			cellObj = mygrid.cellById(1, 0);
			colId=mygrid.getColumnId(0);
			var param =  colId +"=" + cellObj.getValue();					
			console.log(param);					
			$.ajax({
				url : "${root}/user/delete",
				data : param,
				type : "get",
				success : function(res){
					alert(res.msg);		
					if(res.deleteOk){
						document.location.href="${root}/path/user/list";
					}					
				},
				error : function(xhr, status, e) {
					alert("에러 : "+e);			
				}
			})			
		}		
	}else if(id=="update"){	
		if(confirm("정말로 수정하시겠습니까?")){			
			var data = mygrid.getRowData(1);
			console.log(data);
			var colNum= mygrid.getColumnsNum();				
			var param = "";
			for(var i=0; i<colNum; i++){
				colId = mygrid.getColumnId(i);
				param += (colId + "=" + data[colId] + "&");				
			}
			console.log(param);
			$.ajax({
				url : "${root}/user/update",
				data : param,
				type : "get",
				success : function(res){
					alert(res.msg);		
					if(res.updateOk){
						document.location.href="${root}/path/user/list";
					}					
				},
				error : function(xhr, status, e) {
					alert("에러 : "+e);			
				}
			})		
			
			
		}
		
	}	
}



</script>
<body>
	<div><br><br><br><br><br></div>
	<div id="winVP"></div>	
	<input type="hidden" value="${ui.uiNo }" name="aaa" id="uiNo">
	<input type="hidden" value="${ui.uiName }" name="aaa" id="uiName">
	<input type="hidden" value="${ui.uiID }" name="aaa" id="uiID">
	<input type="hidden" value="${ui.uiPwd }" name="aaa" id="uiPwd">
	<input type="hidden" value="${ui.uiEmail }" name="aaa" id="uiEmail">
	<input type="hidden" value="${ui.admin }" name="aaa" id="admin">	
	<button id="delete" onclick="revise(id)">삭제</button>
	<button id="update" onclick="revise(id)">수정</button>
</body>
</html>