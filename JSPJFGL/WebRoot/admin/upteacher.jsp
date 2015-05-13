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
	 
		if(document.form1.name.value==""||document.form1.xueyuan.value==""||document.form1.xibie.value=="")
		{
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
	String id=request.getParameter("id").trim();
	List list=new CollageBean().getTeacher(Integer.parseInt(id));
 %>
<body >
<form action="/JSPJFGL/Collage.jsp" name="form1" method="post" onSubmit="return check()">
	 <input type="hidden" name="method" value="upteacher">
    <table width="100%" height="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td height="121" align="center" valign="top" bgcolor="#FFFFFF">
  
        <table width="98%" cellpadding="0" cellspacing="0">
           
          <TR bgcolor="#cccccc">
            <TD align="center" bgColor=#ffffff><br>
              <br>
                    <table width="100%" cellpadding="0" cellspacing="0">
                       
                        <tr>
                          <td width="100%" >
                              <table width="59%" cellpadding="0" cellspacing="0">
                                <tr><input type="hidden" name="id" value="<%=id %>">
                                  <td align="right"  height="30">用&nbsp;户&nbsp;名:</td>
                                  <td width="205"><INPUT type=text name=name size=30 maxlength=20 value=<%=list.get(1).toString() %>></td>
                                </tr>
                                <tr>
                                  <td align="right"  height="30">学&nbsp;&nbsp;&nbsp;&nbsp;院:</td>
                                  <td width="205"><INPUT type=text name=xueyuan size=30 maxlength=20 value=<%=list.get(2).toString() %>></td>
                                </tr>
                                  <tr>
                                  <td align="right"  height="30">系&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
                                  <td width="205"><INPUT type=text name=xibie size=30 maxlength=20 value=<%=list.get(3).toString() %>></td>
                                </tr>
                                <tr>
                                  <td align="right"  height="30">用户类型:</td>
                                  <td width="205">教师卡</td>
                                </tr>               
                            </table></td>
                        </tr>
                        <tr>
                          <td height="30" colspan="2" align="center" bgColor=#ffffff><br>
                              <table width="200" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td><input name="Submit32" type="submit" class="black12" value="确认"></td>
                                  <td><input name="Submit3" type="reset" class="black12" value="重填"></td>
                                </tr>
                              </table>
                            <br></td>
                        </tr>
                      </table>
                        <br>
                    </td>
                  </tr>
                  <tr>
                    <td height="4" align="center" bordercolor="#5D8191" class="12txt18">&nbsp;</td>
                  </tr>
                </table>
                <br>
                <br></TD>
          </TR>
      </table>
</form>
</body>
<%} %>
</html>
