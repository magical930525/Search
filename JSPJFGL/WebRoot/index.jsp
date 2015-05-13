<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>机房计算机管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
  <script type="text/javascript">
  function check()
  {
  	if(document.form1.name.value==""||document.form1.password.value=="")
  	{
  		return false;
  	}
  }
  </script>
  <body  style="background:url('img/1.jpg') no-repeat;"><br><br><br><br><br>
    <form action="/JSPJFGL/Login.jsp" method=post name=form1 onsubmit="return check()" >
    <center><font size="20" color="blue">机房计算机管理系统</font></center><br><br><br><br>
    <table bordercolor=blue align=center width=400 border=1><input type=hidden name=method value=login>

    <tr>
    <td align=center>用户名</td>
    <td align=center><input typse=text name=name size=30 maxlength=20></td>
    </tr>
    <tr>
    <td align=center>密码</td>
    <td align=center><input type=password name=password size=30 maxlength=20></td>
    </tr>
    
    <tr>
    <td align=center colspan=2><input type=submit value="登陆">&nbsp;&nbsp;&nbsp;<input type=reset value="重填"></td>
    </tr>
    </table>
    </form>
  </body>
</html>
