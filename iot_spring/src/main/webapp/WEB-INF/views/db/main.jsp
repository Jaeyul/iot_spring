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

var bodyLayout, mygrid,
	aLay, bLay,
	dbTree;

function callback(res){
	console.log(res.dbList);
	dbTree = aLay.attachTreeView({
		items: res.dbList
	});
	dbTree.setImagePath("${rPath}/dx/skins/web/imgs/dhxtree_web");	
	dbTree.enableDragAndDrop(true);
	
}

function listCallback(res){	
	console.log(res.userList);					
	mygrid.parse({data:res.userList}, "js");				
}

dhtmlxEvent(window,"load",function(){
	bodyLayout = new dhtmlXLayoutObject(document.body,"3L");
	aLay = bodyLayout.cells("a");	
	aLay.setWidth(400);
	aLay.setText("Connection Info List");
	var aToolbar = aLay.attachToolbar();
	   aToolbar.addButton("adddb",1,"add Connector");
	   aToolbar.addButton("condb",2,"Connection");
	   aToolbar.attachEvent("onClick",function(id){
	      if(id=="adddb"){
	    	  document.location.href="${root }/path/db/dx_form";	    	  
	      }	      
	   })
	
	var au = new AjaxUtil("${root}/connection/db_list",null,"GET","json")
	au.setCallbackSuccess(callback)
	au.send();
	
	bLay = bodyLayout.cells("b");	
	var bToolbar = bLay.attachToolbar();
		bToolbar.addButton("ui",1,"UserInfo");
		bToolbar.addButton("ci",2,"ConnectionInfo");
		bToolbar.attachEvent("onClick",function(id){
			if(id=="ui"){
				mygrid = bLay.attachGrid(); 
				mygrid.setImagePath("${dPath}/imgs/");                 
				mygrid.setHeader("번호,이름,아이디,비밀번호,이메일,권리자권한");
				mygrid.setInitWidths("80,150,150,150,250,150");          
				mygrid.setColAlign("left,left,left,left,left,left");       
				mygrid.setColTypes("ro,ed,ed,ed,ed,ed");               
				mygrid.setColSorting("int,str,str,str,str,int");          
				mygrid.setColumnIds("uiNo,uiName,uiID,uiPwd,uiEmail,admin");
				mygrid.init();    
				
				var au2 = new AjaxUtil("${root}/user/lista",null,"GET","json");	
			
				au2.setCallbackSuccess(listCallback)
				au2.send(); 		
				
				
				
		    }else if(id=="ci"){
		    	alert("된당");
		    	
		    }	      
		})
		
		
	
		
		
		
		
			
		
	
	
});





</script>
<body>

</body>
</html>