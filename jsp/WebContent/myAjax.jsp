<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath(); //????????
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
			#showdiv{
				border: aqua solid 2px;
				width: 500px;
				height: 500px;
			}
		</style>
<base href="<%= basePath%>">
<meta charset="utf-8">
<title>Insert title here</title>
<script src="jquery-3.4.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
			$(function(){
				$("#btn").click(function(){
					var ajax;
					if(window.XMLHttpRequest){//FireFox
						ajax=new XMLHttpRequest();
					}else if(window.ActiveXObject){//IE
						ajax = new ActiveXObject("Msxml2.XMLHTTP");
					}
					ajax.onreadystatechange=function(){
						//console.log(ajax.readyState+"我被执行")
						if(ajax.readyState==4)
							{
							var text = ajax.responseText;
							$("#showdiv").html(text);
							}
					}
					//因为get和post的请求体位置的不同，post需要单独写请求体，故需要加上send()方法
					ajax.open("post","ajax");
					ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
					ajax.send("username=里丝&pwd=123456");
				})
			})
		</script>
</head>
<body>
	<input type="button" name="" id="btn" value="发送ajax" />
	<div id="showdiv"></div>
</body>
</html>