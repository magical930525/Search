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
	if(document.form1.shebei.value==""||document.form1.yuanyin.value==""||document.form1.weihu.value==""||document.form1.shijian.value=="")
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
	float f=new MachineBean().getBiaoZhun();
	if(f==1000){
		f=0;
	}
 %>
<body >
<table align="center" width="100%" border=1 cellpadding="0" cellspacing="0">
  <tr>
  	 <td align="center"  height="30">序号</td>
     <td align="center"  height="30">维护设备</td>
     <td align="center"  height="30">维护原因</td>
     <td align="center"  height="30">维护费用</td>
     <td align="center"  height="30">维护时间</td>
     <td align="center"  height="30">修改</td>
     <td align="center"  height="30">删除</td>
  </tr>
  <%
  	List list=new MachineBean().getAllSheBeiWeiHu();
  	if(!list.isEmpty()){
  	for(int i=0;i<list.size();i++){
  	List list2=(List)list.get(i);
  %>
  <tr>
     <td align="center"  height="30"><%=i+1 %></td>
     <td align="center"  height="30"><%=list2.get(1).toString() %></td>
     <td align="center"  height="30"><%=list2.get(2).toString() %></td>
     <td align="center"  height="30"><%=list2.get(3).toString() %></td>
     <td align="center"  height="30"><%=list2.get(4).toString() %></td>
     <td align="center"  height="30"><a href="/JSPJFGL/admin/upshebei.jsp?id=<%=list2.get(0).toString()%>">修改</a></td>
     <td align="center"  height="30"><a href="/JSPJFGL/Machine.jsp?id=<%=list2.get(0).toString()%>&method=delweihu">删除</a></td>
  </tr> 
  <%} }%>                                        
</table>
<form action="/JSPJFGL/Machine.jsp" name="form1" method="post" onSubmit="return check()"> 
<br><br><br>					<input type="hidden" name="method" value="addweihu">
<table align="center" width="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td align="right"  height="30">维护设备:</td>
    <td align="left"  height="30"><INPUT type=text name=shebei size=30 maxlength=20 ></td>
  </tr>
  <tr>
    <td align="right"  height="30">维护原因:</td>
    <td align="left"  height="30"><INPUT type=text name=yuanyin size=30 maxlength=20 ></td>
  </tr>
  <tr>
    <td align="right"  height="30">维护费用:</td>
    <td align="left"  height="30"><INPUT type=text name=weihu size=30 maxlength=20 ></td>
  </tr>
  <tr>
    <td align="right"  height="30">维护时间:</td>
    <td align="left"  height="30"><INPUT type=text name=shijian size=30 maxlength=20 ></td>
  </tr> 
  <tr>
    <td align="right"  height="30"><input name="Submit32" type="submit" class="black12" value="确认"></td>
    
    <td align="left"  height="30">&nbsp;&nbsp;&nbsp;&nbsp;<input name="Submit3" type="reset" class="black12" value="重填"></td>
  </tr>                                                                
</table>
</form>
</body>
<%} %>
</html>
