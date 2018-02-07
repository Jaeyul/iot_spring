<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
    html, body {
        width: 100%;      /*provides the correct work of a full-screen layout*/ 
        height: 100%;     /*provides the correct work of a full-screen layout*/
        overflow: hidden; /*hides the default body's space*/
        margin: 0px;      /*hides the body's scrolls*/
    }      
    div.controls {
         margin: 0px 10px;
         font-size: 14px;
         font-family: Tahoma;
         color: #404040;
         height: 80px;
      }
</style>

<script>
var formObj = [{type:"settings", offsetTop:12, name:"connectionInfo", labelAlign:"left"},				
	{type:"input", name:"uName", label:"커넥션", required:true},
	{type:"input", name:"uID", label:"접속URL", required:true},
	{type:"input", name:"uPWD", label:"포트번호", vaildate:"ValidInteger", required:true},
	{type:"input", name:"uEmali", label:"데이터베이스", required:true},	
	{type:"block", blockOffset:0, list:[
		{type:"button", name:"saveBtn", value:"저장"},
		{type:"newcolumn"},
		{type:"button", name:"cancelBtn", value:"취소"}
	]}				
];
var bodyLayout;

dhtmlxEvent(window,"load",function(){
	bodyLayout = new dhtmlXLayoutObject(document.body,"3L");
	bodyLayout.cells("a").setWidth(400);
	bodyLayout.cells("a").setText("Connection Info List");
	
	bodyLayout.cells("c").attachForm(formObj,true);	
	
	bodyLayout.cells("b").attachGrid({
	    image_path:'codebase/imgs/',
	    columns: [{
	        label: "Column A",
	        width: 100,
	        type: "ro",
	        sort: "int",
	        align: "right"
	    },{
	        label: "Column B",
	        width: 250,
	        type: "ed",
	        sort: "str",
	        align: "left"
	    }],
	    multiselect: true,
	
	});

	
		
	
	
	
});





</script>
<body>

</body>
</html>