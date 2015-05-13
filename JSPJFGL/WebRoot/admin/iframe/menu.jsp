<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<META content=map,it2288,pic,pc,com,computer name=Keywords>
<title></title>
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
	background-image: url(bg-0040.gif);
	background-color: #1D526D;
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
//-->
</script>
<style type="text/css">
<!--
.STYLE19 {border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-top-style: solid; border-right-style: solid; border-bottom-style: none; border-left-style: none; border-top-color: #9f9f9f; border-right-color: #9f9f9f; border-bottom-color: #9f9f9f; border-left-color: #9f9f9f; font-family: "宋体"; font-size: 12px; color: #FF0000; padding-top: 5px; text-align: center; }
#Layer1 {	position:absolute;
	left:61px;
	top:34px;
	width:98px;
	height:189px;
	z-index:1;
}
.STYLE20 {color: #66CC33}
-->
</style>
<link href="/JSPJFGL/css/local.css" rel="stylesheet" type="text/css">
<link href="/JSPJFGL/css/text.css" rel="stylesheet" type="text/css">
</head>
<SCRIPT language="JavaScript" type="text/JavaScript">
<!--
var array = new Array();
array[0]=1;array[1]=2;array[2]=3;array[3]=4;array[4]=5; 

function expand(id_value){
  var tmp;
  eval("tmp=document.getElementById('id_"+id_value+"').style.display");
  if(tmp==''){
    eval("document.getElementById('id_"+id_value+"').style.display='none'");
  }else{
   for(i=0;i<array.length;i++){
      eval("document.getElementById('id_"+array[i]+"').style.display='none'");
  }
    eval("document.getElementById('id_"+id_value+"').style.display=''");
  }  
 }
 
//-->
</SCRIPT>
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

<%
String name=(String)session.getAttribute("Sname");
	if(name==null){
		response.sendRedirect("/JSPJFGL/index.jsp");
	}
	else{
 %>
<body >
<table width="141" cellspacing="0" cellpadding="0">
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(1)>
      <tr>
         <td width="" height="31" background="/JSPJFGL/admin/images/zht_08.gif">&nbsp;</td>
    	<td width="" background="/JSPJFGL/admin/images/zht_08.gif" class="black14"><font color=blue>系统管理</font></td>
      </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_1 style="display:none">
        <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18">
    <a href="/JSPJFGL/admin/zhmanage.jsp" target="mainFrame" class="12txt18">管理员帐户</a>		
    </td>
  	  </tr>
	</table>
	</td>
  </tr>
   <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(2)>
       <tr>
    <td  height="31" background="/JSPJFGL/admin/images/zht_08.gif">&nbsp;</td>
    <td  background="/JSPJFGL/admin/images/zht_08.gif" class="black14"><font color=blue>卡管理系统</font></td>
   </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_2 style="display:none">
       <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18"><a href="/JSPJFGL/admin/xueyuan.jsp" target="mainFrame" class="12txt18">教师卡管理</a></td>
  </tr>
  <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18"><a href="/JSPJFGL/admin/stu.jsp" target="mainFrame" class="12txt18">学生卡管理</a></td>
  </tr>
  <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18"><a href="/JSPJFGL/admin/addxy.jsp" target="mainFrame" class="12txt18">增加卡用户</a></td>
  </tr>
	</table>
	</td>
  </tr>
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(3)>
      <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08.gif" class="black14"><font color=blue>机房管理系统</font></td>
  </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_3 style="display:none">
    <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18"><a href="/JSPJFGL/admin/sfbz.jsp" target="mainFrame" class="12txt18">收费标准</a></td>
  </tr>
  <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18"><a href="/JSPJFGL/admin/sbwh.jsp" target="mainFrame" class="12txt18">设备维护</a></td>
  </tr>
  <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18"><a href="/JSPJFGL/admin/zbjl.jsp" target="mainFrame" class="12txt18">值班记录</a></td>
  </tr>
  </table>
	</td>
  </tr>
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(4)>
      <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08.gif" class="black14"><font color=blue>刷卡系统管理</font></td>
  </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_4 style="display:none">
    <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18"><a href="/JSPJFGL/admin/lsjl.jsp" target="mainFrame" class="12txt18">在线用户</a></td>
  </tr>
  <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18"><a href="/JSPJFGL/admin/cxjl.jsp" target="mainFrame" class="12txt18">历史记录</a></td>
  </tr>
  <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18"><a href="/JSPJFGL/admin/shuaka.jsp" target="mainFrame" class="12txt18">刷卡管理</a></td>
  </tr>
  </table>
	</td>
  </tr>
  
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(5)>
    <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08.gif" class="black14"><font color=blue>退出登陆</font></td>
  </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_5 style="display:none">
           <tr>
    <td height="31" background="/JSPJFGL/admin/images/zht_08_w.gif">&nbsp;</td>
    <td background="/JSPJFGL/admin/images/zht_08_w.gif" class="12txt18"><a href="/JSPJFGL/LoginOut.jsp?method=admin" target="_parent">退出登陆</a></td>
  </tr>
	</table>
	</td>
  </tr>
</table>
</body>
<%} %>
</html>
