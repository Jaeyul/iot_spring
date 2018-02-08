<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
div.controls {
	margin: 0px 10px;
	font-size: 14px;
	font-family: Tahoma;
	color: #404040;
	height: 80px;
}

div#winVP {
	position: relative;
	height: 600px;
	border: 1px solid #dfdfdf;
	margin: 10px;
}
</style>
<script>
	var winF,popW;
	$(document).ready(function(){
		winF = new dhtmlXWindows();
		winF.attachViewportTo("winVP");
		popW = winF.createWindow("win1",350,30,400,400);
		
		popW.setText("Login");
		
		var formObj = [];
		//var setting = {type:"settings", position:"label-left", labelWidth:100, inputwidth:120};
		/*var inputs = {type:"fieldset", offsetTop:12, name:"connectionInfo", inputWidth:"auto",
				list:[
					{type:"input", name:"ciName", label:"커넥션"},
					{type:"input", name:"ciUrl", label:"접속URL"},
					
				]		
		};*/
		
		var formObj = [{type:"settings", offsetTop:12, name:"Login", labelAlign:"left"},				
			
			{type:"input", name:"uiID", label:"접속URL", required:true},
			{type:"input", name:"uiPwd", label:"포트번호", vaildate:"ValidInteger", required:true},				
			
			{type:"block", blockOffset:0, list:[
				{type:"button", name:"login", value:"Login"},				
				{type:"newcolumn"},
				{type:"button", name:"signUpBtn", value:"회원가입"}
			]}
						
		];
		//formObj.push(setting);
		
		/*var tt = [
		    {type:"fieldset", name:"data", label:"Welcome", inputWidth:"auto", list:[
		        {type:"input",    name: "name", label:"Login"},
		        {type:"password", name:"pass",  label:"Password"},  
		        {type:"button",   name:"save",  value:"Proceed"}] 
		    }
		]*/
		//popW.attachForm(tt,true);
		//formObj.push(inputs);
		//popW.attachForm(formObj,true);
		
		var form = popW.attachForm(formObj,true);
		
		form.attachEvent("onButtonClick", function(id){
			if(id=="login"){
				if(form.validate()){
					alert("ㅋㅋ");					
				}				
			}else if(id=="signUpBtn"){
				document.location.href="${root }/path/db/signup";
			}
		});		
		
	});
	
	function callback(loader, response){
		var res = JSON.parse(response);
		alert(res.msg);
	}
		
	
	function setPopW(onoff){			
		if(onoff){
			popW.show();
			return;
		}
		popW.hide();	
	}
</script>
<body>
<div><br><br><br></div>

	<div id="winVP"></div>
	<div class="controls">
		<button onclick="setPopW(true)">open window</button>	
		<button onclick="setPopW(false)">close window</button>	
	</div>


</body>
</html>