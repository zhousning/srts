<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电力安全规程多媒体网校培训系统 - 登录系统 - 上侧菜单</title>
<link href="${pageContext.request.contextPath}/resource/css/common/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resource/css/system/topMenu.css" rel="stylesheet" type="text/css" />

<style type="text/css">
a:link {color: #FFFFFF;text-decoration:none;}
a:hover {color: #006E6B}
</style>



</head>

<body>
<div class="mainDiv">
  <div class="menu">｜　　欢迎您:　${user.name }　｜　<a  href="system/loginLogoutAction_logouUi" onclick="return confirm('您确定退出系统吗？')">退出系统</a>　　　｜　　　　</div>
 <!-- <div class="banner">预留Flash</div> -->
 <!--  <div class="welcome">此处显示“欢迎user123使用XXX系统，今天是2000年1月1日星期天退出登录%%%　　</div> -->
</div>
</body>
</html>