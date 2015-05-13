<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="refresh" content="10">
<style type="text/css">
<!--
.cd {
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: solid;
	border-top-color: #9f9f9f;
	border-right-color: #9f9f9f;
	border-bottom-color: #9f9f9f;
	border-left-color: #9f9f9f;
	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	text-align: center;
	padding-top: 5px;
}
.cd1 {
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: none;
	border-top-color: #9f9f9f;
	border-right-color: #9f9f9f;
	border-bottom-color: #9f9f9f;
	border-left-color: #9f9f9f;
	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	padding-top: 5px;
	text-align: center;
}
.cd2 {	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: solid;
	border-top-color: #9f9f9f;
	border-right-color: #9f9f9f;
	border-bottom-color: #9f9f9f;
	border-left-color: #9f9f9f;
	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	padding-top: 5px;
	text-align: center;
}
body {
	background-image: url(images/bg-0040.gif);
}
a:link {
	color: #000000;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #000000;
}
a:hover {
	text-decoration: none;
	color: #000000;
}
a:active {
	text-decoration: none;
	color: #000000;
}
.h14 {
	font-family: "宋体";
	font-size: 14px;
	line-height: 20px;
	color: #999999;
}
-->
</style>
<script type="text/JavaScript">
<!--



function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function check()
{	 
	if(document.form1.name.value==""||document.form1.kaishi.value==""||document.form1.jieshu.value=="")
	{
		alert("请填写所有项目！");
		return false;
	}
}
//-->
</script>
<link href="/JSPJFGL/css/local.css" rel="stylesheet" type="text/css">
<link href="/JSPJFGL/css/text.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.STYLE19 {border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-top-style: solid; border-right-style: solid; border-bottom-style: none; border-left-style: none; border-top-color: #9f9f9f; border-right-color: #9f9f9f; border-bottom-color: #9f9f9f; border-left-color: #9f9f9f; font-family: "宋体"; font-size: 12px; color: #FF0000; padding-top: 5px; text-align: center; }
-->
</style>
</head>


<%
String message = (String)request.getAttribute("message");
	if(message == null){
			message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message");

%>

<%String name=(String)session.getAttribute("Sname");
	if(name==null){
		response.sendRedirect("/JSPJFGL/index.jsp");
	}
	else{

 %>
<body >
<table align="center" width="100%" border=1 cellpadding="0" cellspacing="0">
  <tr>
  	 <td align="center"  height="30">序号</td>
     <td align="center"  height="30">卡号</td>
     <td align="center"  height="30">上机时间</td>
     <td align="center"  height="30">下机时间</td>
     <td align="center"  height="30">记时</td>
     <td align="center"  height="30">费用</td>
     <td align="center"  height="30">卡内余额</td>
     <td align="center"  height="30">机器号</td>
     <td align="center"  height="30">刷卡下机</td>
     
  </tr>
  <%
  	List list=new MachineBean().getAllShuaKa();
  	if(!list.isEmpty()){
  	for(int i=0;i<list.size();i++){
  	List list2=(List)list.get(i);
  %>
  <tr>
     <td align="center"  height="30"><%=i+1 %></td>
     <td align="center"  height="30"><%=list2.get(1).toString() %></td>
     <td align="center"  height="30"><%=list2.get(3).toString() %></td>
     <td align="center"  height="30"><%=list2.get(5).toString() %></td>
     <td align="center"  height="30">
     <%
     	long jishi=Long.parseLong(list2.get(4).toString());
     	if(jishi==0){
     		jishi=System.currentTimeMillis();
     	}
     	jishi=jishi-Long.parseLong(list2.get(2).toString());
     	jishi=jishi/60000;
     %>
     <%=jishi %>分钟</td>
     <td align="center"  height="30">
     <%
     	float f=new MachineBean().getShouFeiBiaoZhun();
     	float ff=new MachineBean().getYuE(Integer.parseInt(list2.get(1).toString())); 
     %>
     <%=jishi*f %>元</td>
     <td align="center"  height="30">
     <%
     Float yu=Float.parseFloat(list2.get(7).toString())-(jishi*f)-ff;
     if(yu<=f){
     %>
     <font color=red><%=yu%></font></td>
     <%}else{ %>
     <font color=blue><%=yu%></font>
     <%} %>
     <td align="center"  height="30"><%=list2.get(6).toString() %></td>
     <td align="center"  height="30">
     <%
     	try{Integer.parseInt(list2.get(5).toString());
     %>
     <a href="/JSPJFGL/ZhiBan.jsp?id=<%=list2.get(0).toString()%>&method=xiaji">刷卡下机</a>
     <%}catch(Exception e){ %>已下机<%} %>
     </td>
     
  </tr> 
  <%} }%>                                        
</table>
</body>
<%} %>
</html>
