
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>${title}</title>
</head>
<style>
div#winVP {
	position: relative;
	height: 100%;
	border: 1px solid #dfdfdf;
	margin: 10px;
}
</style>

<script>
	var winF,popW;
	$(document).ready(function(){
		winF = new dhtmlXWindows();
		winF.attachViewportTo("winVP");
		popW = winF.createWindow("win1",20,30,320,300);
		//popW.hide(); 
		popW.button("close").hide();
		popW.button("minmax").hide();
		popW.button("park").hide();
		popW.setText("Login");
		
		winF.window("win1").centerOnScreen();
		winF.window("win1").denyMove();
		winF.window("win1").denyResize();
		var formObj = [
			{type:"settings", offsetTop:12, name:"userInfo",labelAlign:"left"},			
			{type:"input",name:"uiID", label:"아이디 : ",required:true},
			{type:"password",name:"uiPwd", label:"비밀번호 : ",required:true},				
			{type: "block", blockOffset: 0, list: [
				{type: "button", name:"loginBtn",value: "로그인"},
				{type: "newcolumn"},
				{type: "button", name:"cancelBtn",value: "취소"},
				{type: "newcolumn"},
				{type: "button", name:"signupBtn",value: "회원가입"}
			]}
		];
		var form = popW.attachForm(formObj,true);
		form.attachEvent("onButtonClick",function(id){
			if(id=="loginBtn"){
				if(form.validate()){
					form.send("${root}/user/login","POST",callback);                 
				}
			}else if(id=="cancelBtn"){
				form.clear();
			}else if(id=="signupBtn"){ 
				document.location.href="${root}/path/user/signup";
			}         
		});
		
		if(${isLogin}){
			popW.hide();
		}
	})

	function callback(loader, res){	
		if(loader.xmlDoc.status == 200){
			var res = JSON.parse(res);
			alert(res.msg);
			if(res.loginOk){					
				document.location.href="${root}/path/user/list";
			}		   
		} 
	}
   

</script>
<body
	style="background: url('https://37.media.tumblr.com/f6c67ec2821a91051e4175f8a102e1e2/tumblr_n6rzpcsMk41st5lhmo1_1280.jpg'); background-repeat: no-repeat; background-size: 100%">
	<div id="winVP"></div>
</body>
</html>