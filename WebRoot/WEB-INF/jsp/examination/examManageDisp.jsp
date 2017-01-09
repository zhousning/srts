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
    
    <title>My JSP 'examManageDisp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/intman/userList.css">
	 <link href="resource/css/controlPanel/self.css" rel="stylesheet" type="text/css" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div class="mainDiv">

<div class="panel_main">

   <s:if test="reqStatus==1">
    <div class="title_main"><span class="span_item">考试人员名单</span></div>
    <div class="content_margin">
    <table id="t">
     <tr><td class="no">序号</td><td>姓名</td><td>工号</td><td>部门</td></tr>
      <s:iterator value="testUsers" status="st">
       <tr><td class="no"><s:property value="#st.index+1"/></td>
       <td>${name }</td><td>${workno}</td><td>${department.name}</td></tr>
      </s:iterator>
   </table>
      </div>
    </s:if> 
     
 <s:if test="reqStatus==0">
    <div class="title_main"><span class="span_item">考试试卷</span></div>
    <div class="content_margin">
        <s:iterator value="questionBankList" status="st">
        <div class="qescta">
        <div class="qestitle"><s:property value="#st.index+1"/>:&nbsp;&nbsp;${content}</div>
        <div class="qesctn">答案：&nbsp;&nbsp;${answer}</div>
        </div>
        </s:iterator>
        </div>
         </s:if>
    
    </div>
   </div>

  </body>
</html>
