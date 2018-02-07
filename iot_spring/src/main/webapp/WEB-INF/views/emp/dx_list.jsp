<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>
<div>
<br><br><br><br><br>
</div>

	<div id="gridbox" style="width:350px;height:250px;"></div>
	
	<script>
	var mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath("{dPath}/imgs/");                 
	mygrid.setHeader("사번,이름,월급");//the headers of columns  
	mygrid.setInitWidths("80,140,100");          //the widths of columns  
	mygrid.setColAlign("left,left,left");       //the alignment of columns   
	mygrid.setColTypes("ro,ed,price");                //the types of columns  
	mygrid.setColSorting("int,str,int");          //the sorting types  
	mygrid.setColumnIds("empNo,empName,empSal")
	mygrid.init();      //finishes initialization and renders the grid on the page 
	
	
	
	var au = new AjaxUtil("${root}/emp/lista",null,"GET","json");	
	function callback(res){	
		console.log(res.empList);
		
		mygrid.parse({data:res.empList}, "js");				
	}
	au.setCallbackSuccess(callback)
	au.send(); 			
	
	
	
	
	
	</script>


</body>
</html>