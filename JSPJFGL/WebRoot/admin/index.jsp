<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>机房计算机管理系统</title>
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
 %>
<frameset rows="112,*" cols="*" frameborder="no"  border="0" framespacing="0">
  <frame src="/JSPJFGL/admin/iframe/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame">
  <frameset rows="*" cols="165,*" framespacing="0" frameborder="no" border="0">
    <frame src="/JSPJFGL/admin/iframe/menu.jsp" name="leftFrame" scrolling="yes" noresize="noresize"  id="leftFrame" title="leftFrame">
    <frame src="/JSPJFGL/admin/iframe/main.jsp" scrolling="yes" name="mainFrame" id="mainFrame" title="mainFrame" >
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes>
<%} %></html>
