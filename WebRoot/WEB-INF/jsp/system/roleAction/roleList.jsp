<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'roleList.jsp' starting page</title>
    <%@ include file="/WEB-INF/jsp/commons/commons.jsp"%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
		<link rel="stylesheet" type="text/css" href="resource/css/intman/userList.css">

  </head>
  
  <body>
 
  <div class="mainDiv">

<div class="panel_main">
 <div class="title_main">角色管理</div>
  
    <div class="content_margin">
   <s:a action="roleAction_roleDisp">添加角色</s:a>
  </div>
  
  <div class="content_margin">
  <table id="t">
  <tr><td class="no">序号</td><td>岗位名称</td><td>操作</td></tr>
  <s:iterator value="roleList" status="st">
   <tr><td class="no"><s:property value="#st.index+1"/></td><td>${name}</td><td>
    <s:a action="roleAction_roleDisp?roleId=%{id}">修改</s:a> &nbsp;&nbsp;
   <s:a action="roleAction_setPriviliegeUi?roleId=%{id}">设置权限</s:a></td></tr>
  </s:iterator>
  </table>
  </div>
  
  </div>
  </div>
  
  </body>
</html>
