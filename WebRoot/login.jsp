<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

	<%@ include file="/WEB-INF/jsp/commons/commons.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/jqueryvalidate.jsp" %>

		<title>电力安全规程多媒体网校培训系统</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
<link href="${pageContext.request.contextPath}/resource/css/system/login.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	if(window.parent!=window){
			window.parent.location.href=window.location.href;
		}
</script>

</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="350" align="left" valign="top" class="login_logo"><embed class="login_logo_flash" src="${pageContext.request.contextPath}/resource/flash/system/login_logo.swf" width="100%" height="120" type="application/x-shockwave-flash" wmode="transparent" quality="high"></embed></td>
  </tr>
  <tr>
    <td height="280" valign="top">
        <form action="system/loginLogoutAction_login" method="post">
            <table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="431" height="55" class="login_window_username_bg"><input name="username" type="text" class="login_window_textfield required " id="username"  /></td>
                <td width="269" rowspan="2">&nbsp;</td>
              </tr>
              <tr>
                <td width="431" height="55" class="login_window_password_bg"><input name="password" type="password" class="login_window_textfield required" id="password" /></td>
                </tr>
              <tr>
                <td width="431" height="70"><input name="login_buttion" type="submit" class="login_button" id="login_buttion" value=" " /></td>
                <td width="269" height="70" align="center" > <font color="red" size="4">${infomation}</font></td>
              </tr>
            </table>
          
        </form>

    </td>
  </tr>
  <tr>
    <td height="30" align="center" class="login_bottom login_bottom_bg">Copyright &copy;  电力安全规程多媒体网校培训系统 Beta 1.0</td>
  </tr>
  <tr>
    <td height="25" align="center" class="login_bottom">版权所有    国网吉林省电力有限公司 东北电力大学知识工程与能效评估课题组</td>
  </tr>
  <tr>
    <td height="25" align="center" class="login_bottom">建议使用1440*900屏幕分辨率浏览</td>
  </tr>
</table>
</body>
</html>