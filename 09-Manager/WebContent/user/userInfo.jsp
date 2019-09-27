<%@ page language="java" import="com.bjsxt.pojo.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath(); //获取项目的虚拟名
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%= basePath%>">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
			<%
        		//转换性别显示
  				String sex = (((User)session.getAttribute("user")).getSex()).equals("1")?"男":"女";
        	%>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>用户编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>用户名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>生日</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <td><%=((User)session.getAttribute("user")).getUid() %></td>
        <td><%=((User)session.getAttribute("user")).getUname() %></td>
        <td><%=sex %></td>
        <td><%=((User)session.getAttribute("user")).getAge() %></td>
        <td><%=((User)session.getAttribute("user")).getBirth().toString() %></td>
        </tr> 
        </tbody>
    </table>