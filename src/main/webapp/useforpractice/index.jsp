<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- 引入jquery -->
<script type="text/javascript" src="static/js/jquery-1.11.3/jquery.min.js"></script>
<style type="text/css">
 .hello {
 width:300px;
 height:400px;
 background-color:red
 }

</style>
<!-- 引入样式 -->
<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<script type="text/javascript" src="static\bootstrap-3.3.7-dist\js\bootstrap.min.js"></script>
</head>
<body>


<div class="hello" >
<button class="btn btn-danger" onclick="a()">按钮</button>
<a href="${pathContext.request.contextPath}/ssm-crud/system/login">跳转</a>
<div style="width:300px;height:40px">

    用户名：<input type="text" id="user">
</div>
<div style="width:300px;height:40px">

    密码：<input id="pas" type="password">
</div>

<c:set var="score" value="185"></c:set>
<c:choose>
<c:when test="${score>90 }">
   你真棒！
</c:when>
<c:otherwise>
   还得继续努力啊!
</c:otherwise>
</c:choose>
<c:forEach begin="2" end="5" varStatus="v">

a--${v.index}
</c:forEach>			
<%
  Map<String,String> a = new HashMap<String,String>();
 a.put("a1","ding");
 a.put("a2", "tian");
 request.setAttribute("hh", a);
%>
<c:forEach items="${hh}" var="m">
   ${m.value} 
</c:forEach>
</div>
		
</body>
<script type="text/javascript">
  function a(){
	  var url = "${pathContext.request.contextPath}/ssm-crud/system/login/"
	  url+=$("#user").val()+"/"+$("#pas").val()
	  $.get(url,function(data){
		  if(data.successMessege){
		  alert(data.successMessege);}
		  else{
			  alert(data.errorMessege);
		  }
	  });
  }
  


</script>
</html>