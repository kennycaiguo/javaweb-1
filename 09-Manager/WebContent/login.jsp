<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath(); //获取项目的虚拟名
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%= basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>      
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> <br />
    <% 
    	//声明判定错误提示语
    	Object obj = request.getAttribute("error");
    	if(obj!=null)
    	{
    %>
      <div style="text-align:center;">
    <span style="font-size: 15px;color:white;font-weight:bold">用户名或密码错误</span>
    </div>
    <%
    	}
    %>
  
       
    <div class="loginbox loginbox1">
    
    <form action="userservlet" method="post">
    <input type="hidden" name="oper" value="login"/>
    <ul>
    <li><input name="uname" type="text" placeholder="用户名" class="loginuser" /></li>
    <li><input name="pwd" type="password" placeholder="密码" class="loginpwd" /></li>
    <li class="yzm">
    <span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite> 
    </li>
    <li><input name="oper" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    <div class="loginbm">版权所有  UpUpDay  <a href="http://www.uimaker.com">uimaker.com</a>  欢迎你的加入</div>
	
    
</body>

</html>
