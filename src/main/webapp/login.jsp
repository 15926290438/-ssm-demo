<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
  request.setAttribute("AppPath", request.getContextPath());
%>
<!--  <script  src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>-->
<!-- 引入jquery的时候，把type="text/javascript" 去掉，不然可能会出现500 -->
<script  src="${AppPath}/static/js/jquery-3.4.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style>
  #login {
    width:400px;
    height:300px;
    background-color:red
  
  }

</style>
</head>
<body>
   <div id="login">
      <form id="loginForm" method="post">
        <label for="username">用户名：</label>
         <input name="name" id="username"  type="text" placeholder="请输入用户名"> </br>
         <label for="password">密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
     <input name="password" id="password" type="password" placeholder="请输入密码" >

     <input id="submit" type="button" value="提交">
      </form>
      <select>
  <option value ="volvo">Volvo</option>
  <option value ="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
      
   </div>
   
   <script type="text/javascript">
   var a = new Array();
   a.push(100);
   var roleId = [];
   roleId.push(100);
   roleId.push(200);
   roleId.push(300);

         $("#submit").click(function(){
        	 $.ajax({
        		 url:"${AppPath}/system/loginCheck",
        		type :"post",
        		//今天在做项目的时候，用serialize序列化表单到后台，发现老是失败，结果断点调试看后台的实体的值，
        		//结果有的属性有值，有的又没有，搞了好半天发现原来是一个控件的属性是disabled，因为我修改的时候不然改登录名。
        		//所以就设置成了disabled。
//解决方案：把disabled属性用readonly替换。
//这里我用serializeObject()会报错：Uncaught TypeError: $(...).serializeObject is not a function
//$("#loginForm").jsonData() TypeError: $(...).jsonData is not a function
        	
                data : {name:"张三",pas:145},
        	    success:function(result){
        	    	debugger;
        	    	if(result){
        	    		if(result.successMessege){
        	    			//var a = $("#loginForm").serialize();
        	    			//console.log(a);   结果是username=judy&password=123
        	    	       //ajax和form表单的提交跳转问题

//1. 使用ajax提交form表单数据的时候，把提交按钮的type=“submit”改成type="button"，防止点击提交的时候form表单自动提交刷新。
//2. 使用ajax提交form表单数据，controller层返回处理的结果，在ajax里跳转页面。controller层的方法上要加@ResponseBody。
//3. ajax中跳转页面使用window.location.href = "xxxx";
//4. form表单在点击提交的时候会自己提交并刷新当前页面，尽管，你可能并没有写action的路径。
//5. 在提交后跳转页面的时候，要搞清楚在前台跳转，还是后台跳转。当时用ajax提交数据时，只能在ajax中跳转。form表单可以在后台进行跳转。在跳转没有反应的时候，首先要确认代码正确，然后查看有没有打印错误，包括后台的控制台，以及前台的页面console。找到错误，根据错误修改。

//6. 前台console打印Uncaught TypeError: window.location.href is not a function，这个错误的时候，很有可能是window.location.href = "xxxx";写错了。不能写成window.location.href ("xxxx");
         window.location.href = "${AppPath}/index2.jsp";  //登录成功跳转页面
        	    		}else if(result.errorMessege){
        	    			alert(result.errorMessege);
        	    		}
        	    	}
        	    },
        	    error:function(){
        	    	alert("失败！");
        	    }
        	 })
        	 
   })
         
         
   
   </script>
</body>
</html>