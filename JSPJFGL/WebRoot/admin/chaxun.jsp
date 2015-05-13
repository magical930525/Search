<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

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
	if(document.form1.cardid.value=="")
	{
		alert("请填写卡号！");
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
     <td align="center"  height="30">机器号</td>    
  </tr>
  <%
  	String cardid=(String)request.getAttribute("cardid");
  	float f=new MachineBean().getZongJinE(Integer.parseInt(cardid));
  	float ff=0;
  	List list=new MachineBean().getAllLiShiJiLu(Integer.parseInt(cardid)); 
  	if(!list.isEmpty()){
  	for(int i=0;i<list.size();i++){
  	List list2=(List)list.get(i);
  	ff+=Float.parseFloat(list2.get(5).toString());
  %>
  <tr>
     <td align="center"  height="30"><%=i+1 %></td>
     <td align="center"  height="30"><%=list2.get(1).toString() %></td>
     <td align="center"  height="30"><%=list2.get(2).toString() %></td>
     <td align="center"  height="30"><%=list2.get(3).toString() %></td>
     <td align="center"  height="30"><%=list2.get(4).toString() %></td>
     <td align="center"  height="30"><%=list2.get(5).toString() %></td>
     <td align="center"  height="30"><%=list2.get(6).toString() %></td>
      </tr> 
  <%} }%>  
  <tr>
  <td colspan=7 align=right>总消费金额：<%=ff %>元&nbsp;&nbsp;&nbsp;卡内余额：<%=f-ff %>元</td>
  </tr>                                      
</table><br><br><br>
</body>
<%} %>
</html>
