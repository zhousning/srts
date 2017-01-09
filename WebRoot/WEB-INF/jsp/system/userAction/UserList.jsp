<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<%@ include file="/WEB-INF/jsp/commons/commons.jsp" %>
    <title>My JSP 'UserList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/intman/userList.css">
<script type="text/javascript" src="resource/js/system/userMan.js"> </script>

<script type="text/javascript">
	$(function(){
		for(var i=1; i<=${totalPage}; i++){
				$("#page").append("<option value="+i+">"+i+"</option>"); 
			}
			$("#page").val(${page}); //设置select的value为${page}的项选中 
			$("#page").change(function(){
				window.location="system/userAction_userList.action?page="+$("#page").val();
			});
	})
</script>
  </head>
  
  <body>
   <div class="mainDiv">

<div class="panel_main">
 <div class="title_main">查询</div>
 <div class="content_margin">
  <div id="select">
 <s:form action="userAction_userList" method="post">

 <div class="iem">
<div>姓名：<s:textfield id="userName" name="userName"></s:textfield></div>
 </div>
 
<div class="iem">
<div>部门：<s:select  id="depId" name="depId" list="depList" listKey="id" listValue="name" headerKey="" headerValue="--请选择部门--"></s:select></div>
 </div>
 
 <div class="iem">
<div>工号：<s:textfield id="workNo" name="workNo"></s:textfield></div>
 </div>
 </s:form>
 
 <div><input type="button" onclick="submit_form()" value="查询"/> <input type="button" onclick="save_user()" value="添加"/></div>
 </div>
 </div>
</div>

<div class="panel_main">
 <div class="title_main">用户列表</div>
   <div class="content_margin">
 <table id="t">
 <tr><td class="no">序号</td><td>姓名</td><td>部门</td><td>工号</td><td>角色</td></tr>
  <s:iterator value="userList" status="st">
  <s:if test="username!='admin'">
 <tr><td class="no"> <s:property value="#st.index"/></td><td><s:a action="userAction_userShow?userId=%{id}" namespace="/system">${name}</s:a></td><td>${department.name}</td><td>${workno }</td>
<td> 
<s:iterator value="roles">
  ${name}&nbsp;
</s:iterator>
</td>
 <%--<td><s:a action="userAction_deleteUserById?userId=%{id}">删除</s:a></td>
 --%></tr>
 </s:if>
  </s:iterator>
   </table>
     </div> 
     <div>共
		<s:property value="allRow" />
		条 共
		<s:property value="totalPage" />
		页 第
		<s:property value="page" />
		页
		<s:if test="page == 1">上一页</s:if>
		<s:else>
			<a
				href="system/userAction_userList.action?page=<s:property value="%{page-1}"/>">上一页</a>
		</s:else>
		<s:if test="page != totalPage">
			<a
				href="system/userAction_userList.action?page=<s:property value="%{page+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="page">
		</select>
		页</div>
		</div>
   </div>
  </body>
</html>
