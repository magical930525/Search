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
	
		if(document.form1.new_password.value=="")
		{
			window.alert("请输入新密码！");
			document.form1.new_password.focus();
			return false;
		}
		if(document.form1.new_password.value.indexOf( " " ) != -1){
		    alert("新密码中不能含有空格！");
		    document.form1.new_password.focus();
		    return false;
  		}
		if(document.form1.new_password.value.length<6||document.form1.new_password.value.length>16)
		{
			window.alert("密码长度为6-16位！");
			document.form1.new_password.focus();
			return false;
		}
		if(document.form1.repassword.value=="")
		{
			window.alert("请确认管理员新密码！");
			document.form1.repassword.focus();
			return false;
		}
		if(document.form1.new_password.value!=document.form1.repassword.value)
		{
			window.alert("两次输入的密码不一致！");
			document.form1.repassword.focus();
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

<%
	String name=(String)session.getAttribute("Sname");
	if(name==null){
		response.sendRedirect("/JSPJFGL/admin/login.jsp");
	}
	else{
		String id=(String)request.getAttribute("id");
		List list=new LoginBean().getManager(Integer.parseInt(id));
%>
<body >
<form action="/JSPJFGL/AddManager.jsp" name="form1" method="post" onSubmit="return check()">
	<input type="hidden" name="id" value="<%=id %>"><input type="hidden" name="method" value="up2">
    <table width="100%" height="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td height="121" align="center" valign="top" bgcolor="#FFFFFF"><div align="left"><br>
            <span class="black14">　 </span><br>
    </div>
        <table width="98%" cellpadding="0" cellspacing="0">
           
          <TR bgcolor="#cccccc">
            <TD align="center" bgColor=#ffffff><br>
              <br>
                    <table width="100%" cellpadding="0" cellspacing="0">
                        
                        <tr>
                          <td width="100%" height="100" align="center" bgColor=#ffffff><span class="hb"> <br>
                            </span>
                              <table width="59%" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td align="right"  height="30">登录名:</td>
                                  <td width="205" ><%=list.get(1).toString() %></td>
                                </tr>
                                
                                <tr>
                                  <td align="right"  height="30">新密码:</td>
                                  <td><INPUT class=input id=new_password 
                              onblur="this.className='input'"  type="password"
                              style="WIDTH: 160px" 
                              onfocus="this.className='inputfs'" maxLength=16 
                              size=28 name=new_password onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')"  ></td>
                                </tr>
                                <tr>
                                  <td align="right"  height="30">确认密码:</td>
                                  <td><INPUT class=input id=repassword 
                              onblur="this.className='input'"   type="password"
                              style="WIDTH: 160px" 
                              onfocus="this.className='inputfs'" maxLength=16 
                              size=28 name=repassword  onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')" ></td>
                                </tr>
                              
                      			 <tr>
                                  <td align=right><input name="Submit32" type="submit" class="black12" value="确认"></td>
                                  <td><input name="Submit3" type="reset" class="black12" value="重填"></td>
                                </tr>
                            </table></td>
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
