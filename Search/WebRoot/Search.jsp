<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搜索引擎</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

  <body   style="background:url('image/1.jpg') no-repeat;">
<center>
 <h1><br><br><br><font face="华文中宋" color="#3399FF">搜索引擎</font></h1>
  <div align="center"><form action="/Search/LikeServlet" method="post"> 
    请输入关键字:  <input type="text" name="QueryContent" size="20"> 
   <input type="submit" name="submit" value="开始搜索"> 
  </form>
  </div>
  </center>
      <center>
      <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><p><font color=#778899 size='2'>科大天平毕业设计</font></p>
      <p><font color=#778899 size='2'>Author: 张鑫</font></p></center>
      
</body>
</html>
