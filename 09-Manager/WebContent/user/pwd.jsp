<%@ page language="java" import="com.bjsxt.pojo.*" contentType="text/html; charset=utf-8"
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
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="user/userInfo.jsp">个人信息</a></li>
    <li><a href="#">修改账号密码</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <form action="userservelt" method="post">
	    <li><label>新密码</label><input name="newPwd"  type="text" class="dfinput" /></li>
	    <li><label>确认密码</label><input name="newPwd2" type="text" class="dfinput" /></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </form>
    </ul>
    
    
    </div>


</body>

</html>
