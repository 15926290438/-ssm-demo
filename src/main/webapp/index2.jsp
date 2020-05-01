<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
             request.setAttribute("AppPath", request.getContextPath());
%>
<title>Insert title here</title>
<script src="${AppPath}/static/js/jquery-1.11.3/jquery.min.js"></script>
<!--  <script  src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>-->
<style type="text/css">
#list {
table-layout:fixed;/* 只有定义了表格的布局算法为fixed，下面td的定义才能起作用。 */
border:1px solid black;
border-collapse:collapse;
width:900px;

}
#list td {
width:205px;
height:35px;
border:1px solid red;
white-space:nowrap;
overflow:hidden;
text-overflow:ellipsis;

}

             
.controllTablesize {
width:900px;
height:180px;
overflow:scroll;   //Table显示滚动条，要先把table放到一个div中，div的长度和宽度要固定，控制overflow属性为scroll
}

</style>
</head>
<body>
<!-- 
   :hover选择器用于选择鼠标指针浮动在上面的元素。  (css选择器的知识)
vertical-align: bottom   //引起行内元素向下偏移

#list td:hover { 

overflow: visible;  
}    //显示隐藏的内容
 -->

<!-- 
注意:text-overflow : ellipsis生效的前提是
overflow不为visible，最好是类似hidden的值
需要指定table的width

word-wrap 属性 -- 允许长单词换行到下一行
word-break 属性  -- 在恰当的断字点处换行--normal(使用浏览器默认的换行规则。),break-all(允许在单词内换行),keep-all(只能在半角空格或连字符处换行)
 -->
<!-- 注意table标签和td标签都需要设置border，不然默认情况下不会显示 -->
<!-- 
给td设置属性
white-space:nowrap;/* 不换行 */
overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */
text-overflow:ellipsis;/* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用。*/
 -->
<input type="radio" name="sex" value="male" checked="checked">男
<input type="radio" name="sex" value="female">女
<button id="test">点挂机</button>
 <div class="controllTablesize">
<table id="list">
<thead>
<tr>
<td style="width:30px"><input type="checkbox"></td>
<th>工号</th>
<th>名字</th>
<th>性别</th>
<th>年龄</th>
<th>部门</th>
<th>操作</th>
</tr>
</thead>

<tbody>

<c:forEach items="${list}" var="item">
<tr>
<td style="width:30px"><input type="checkbox" value="${item.eid}"></td>
<td>${item.eid}</td>
<td>${item.name}</td>
<td>
${item.sex}
</td>
<td>${item.age}</td>
<td>${item.department.dname }</td>
<td>&nbsp;&nbsp;<button onclick="deleteEmloyee(${item.eid})">删除</button>&nbsp;&nbsp;&nbsp;&nbsp;
    <button>修改</button>
</td>
</tr>
</c:forEach>
</tbody>

</table>
</div>
<script type="text/javascript">
var x = 20;
var y =20;
$(document).ready(function(){
	//【坑】前端使用ajax异步请求以后，springMvc拦截器跳转页面无效
	// 解决Ajax异步请求 springMvc 不跳转页面的问题
	$.ajaxSetup( {
		//设置ajax请求结束后的执行动作
	    complete :
	        function(XMLHttpRequest, textStatus) {
				// 通过XMLHttpRequest取得响应头，sessionstatus
	            var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
	            if (sessionstatus == "TIMEOUT") {
	                var win = window;
	                while (win != win.top){
	                    win = win.top;
	                }
	                win.location.href= XMLHttpRequest.getResponseHeader("CONTEXTPATH");
	            }
	        }
	});
	initList();
	test();
})

function test(){
	if($("input[name='sex']").val()=="female"){
		$("#test").mouseenter(function(){
			alert("yes");
		})
	}
}

function deleteEmloyee(id){
	$.ajax({
	url:"${AppPath}/emp/delete",
	type:"post",
	data:{"id":id},
	success:function(result){
		debugger;
		var href = "${AppPath}"+"/emp"+result;
		$.ajax({
			url:href,
			dataType:"JSON",
			Type:"GET",
			success:function(data){
				//删除成功后刷新页面
			$.each(data,function(key,value){
				alert(value);
			})
	         window.location.reload();
			}
		})
	}
	})
	
}

function initList(){
	
	$.ajax({
		url:"${AppPath}/emp/list",
		dataType:"JSON",
		Type:"GET",
		success:function(data){

		}
	})
}


$("#list td").not($("#list td").has("button")).hover(function(e){
//this.text is not a function  一开是我是this.text()写错了， this是DOM对象，text()是Jquery对象的方法，所以使用$(this).text()
	//创建div元素
	
	var messege = "<div id='messege' style='position:absolute'>"+$(this).text()+"</div>"
	//把它追加到文档中
	$("body").append(messege);
	//  如果设置一个属性 $("p").css("background-color":"yellow")
	//如果设置多个属性 css()方法里传一个对象
	$("#messege").css({
		"top":(e.pageY+y)+"px",
		"left":(e.pageX+x)+"px",
		backgroundColor:"red"
	}).show("fast")  //设置X和Y的坐标，并且显示
	
},function(){
	$("#messege").remove()
})

</script>
</body>
</html>