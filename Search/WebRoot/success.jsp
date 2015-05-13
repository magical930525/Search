<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="/Seacrch/jquery-2.1.4.js"></script>


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
<script type="text/javascript" src="/Search/jquery-2.1.4.js">
  </script>
<body>
	<center>
		<h1>
			<font face="华文中宋" color="#3399FF">搜索引擎</font>
		</h1>
		<div align="center">
			<form action="/Search/LikeServlet" method="post">
				请输入关键字: <input type="text" name="QueryContent" size="20"> <input
					type="submit" name="submit" value="开始搜索">
			</form>
		</div>
	</center>
	<p>
		搜索关键字：<font color=red>“${content} ”</font>
	</p>
	<p>
		总共找到<font color=red>“ ${length } ”</font>条新闻<br>
	</p>
	<c:forEach items="${as}" var="a" varStatus="status">
		<br />
		<div>
			${status.count}.<a href="${a.url }"><span id="${status.count}">
					${a.title}</span></a>
		</div>
		<div style="width:500px;font-size:15px">
			<div style="width: 600px">${a.time}-${a.p}</div>
		</div>
		<font size=2 color=green>${a.url }</font>
		<br>
	</c:forEach>
 <!--
    ${pageNow}
	<a href="/Search/LikeServlet?pageNow=1">首页</a>
	<a href="/Search/LikeServlet?pageNow=${pageNow-1}">上一页</a>
	<a href="/Search/LikeServlet?pageNow=${pageNow+1}">下一页</a>
	<a href="/Search/LikeServlet?pageNow=${pageCount}">尾页</a>
	-->
	<script type="text/javascript">
  $(function(){
  for(var i=1;i<=${length};i++){
    var p = $("#"+i+"");//段落
    var t ="${content}";//关键字
    p.html(eachColor(p,t));
    }
  });
  function eachColor(p,t){
    var nt = '<span style="color:red">'+t+"</span>";
    var reg = RegExp(t,"g");
    return  p.text().replace(reg,nt);
}
</script>
</body>
</html>
