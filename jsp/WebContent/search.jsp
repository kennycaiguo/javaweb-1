<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%
	String path = request.getContextPath(); //????????
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<!DOCTYPE html>
<html>
<head>
<base href="<%= basePath%>">
<meta charset="utf-8">
<title>Insert title here</title>
		<script src="jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				$("#search").click(function(){
					//获取搜索框中的信息
					var textBox=$("#uname")
					var value=textBox.val()
					//创建ajax对象
					var ajax
					if(window.XMLHttpRequest)
					{
						ajax=new XMLHttpRequest()
					}else if(window.ActiveXObject){
						ajax = new ActiveXObject("Msxml2.XMLHTTP")
					}
					//覆写ready方法
					ajax.onreadystatechange=function(){
						//处理查询的结果
						if(ajax.readyState==4)
						{
							if(ajax.status==200){
								
							}else{
								
							}
						}
					}
					//打开，发送请求
					ajax.open("get","searchServlet?"+value)
					ajax.send(null)
				})
			})
		</script>
		
</head>
<body>
<h3>欢迎访问英雄商店</h3>
<hr>
英雄名称：<input type="text" na/>
</body>
</html>