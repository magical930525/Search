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
	font-family: "����";
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
	font-family: "����";
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
	font-family: "����";
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
	font-family: "����";
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
		alert("����д���ţ�");
		return false;
	}
}
//-->
</script>
<link href="/JSPJFGL/css/local.css" rel="stylesheet" type="text/css">
<link href="/JSPJFGL/css/text.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.STYLE19 {border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-top-style: solid; border-right-style: solid; border-bottom-style: none; border-left-style: none; border-top-color: #9f9f9f; border-right-color: #9f9f9f; border-bottom-color: #9f9f9f; border-left-color: #9f9f9f; font-family: "����"; font-size: 12px; color: #FF0000; padding-top: 5px; text-align: center; }
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

<%String name=(String)session.getAttribute("as");
	if(name==null){
		response.sendRedirect("/JSPJFGL/index.jsp");
	}
	else{

 %>
<body >
<table align="center" width="100%" border=1 cellpadding="0" cellspacing="0">
  <tr>
  	 <td align="center"  height="30">���</td>
     <td align="center"  height="30">����</td>
     <td align="center"  height="30">�ϻ�ʱ��</td>
     <td align="center"  height="30">�»�ʱ��</td>
     <td align="center"  height="30">��ʱ</td>
     <td align="center"  height="30">����</td>
     <td align="center"  height="30">������</td>
     <td align="center"  height="30">ɾ��</td>
     
  </tr>
  <%
  	List list=new MachineBean().getAllLiShiJiLu();
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
     <td align="center"  height="30"><%=list2.get(5).toString() %></td>
     <td align="center"  height="30"><%=list2.get(6).toString() %></td>
     <td align="center"  height="30"><a href="/JSPJFGL/ZhiBan.jsp?id=<%=list2.get(0).toString()%>&method=deljilu">ɾ��</a></td>
  </tr> 
  <%} }%>                                        
</table><br><br><br>
<form action="/JSPJFGL/ZhiBan.jsp" method=post name=form1 onsubmit="return check()">
<table align="center" width="100%" border=0 cellpadding="0" cellspacing="0">
<tr><input type=hidden name=method value="chaxunka">
<td align="center">����<input type=text name=cardid size=15><input type=submit value="��ѯ"></td>
</tr>
</table>
</form>
</body>
<%} %>
</html>
