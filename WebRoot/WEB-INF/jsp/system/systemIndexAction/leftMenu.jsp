<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-

transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电力安全规程多媒体网校培训系统 - 登录系统 - 左侧菜单</title>
<link href="${pageContext.request.contextPath}/resource/css/common/common.css" rel="stylesheet" 

type="text/css" />
<link href="${pageContext.request.contextPath}/resource/css/system/leftMenu.css" rel="stylesheet" 

type="text/css" />
<script type="text/javascript" 

src="${pageContext.request.contextPath}/resource/script/jquery/jquery.min.js"></script>
<script type="text/javascript" 

src="${pageContext.request.contextPath}/resource/js/system/leftMenu.js"></script>
</head>

<body>

<div id="mainDiv">
    
    <!-- 信息 -->
  <s:iterator value="#session.topPrivilegeList">
     <s:if test="#session.user.hasPrivilegeByName(name)">
      <div class="item"><img src="${pageContext.request.contextPath}/${icon}" /></div>
         <div class="subitem">
     <s:iterator value="children">
     <s:if test="#session.user.hasPrivilegeByName(name)">
      <div><a href="${pageContext.request.contextPath}/${url}"target="main">${name }</a></div>
     </s:if>
     </s:iterator>
         </div>
     </s:if>
     
    </s:iterator>
   
 
</div>

</body>
</html>