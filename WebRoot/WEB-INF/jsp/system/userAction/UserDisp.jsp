<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<%@ include file="/WEB-INF/jsp/commons/commons.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/jqueryvalidate.jsp" %>
    <title>My JSP 'UserDisp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/intman/userDisp.css">
	<script type="text/javascript" src="resource/js/system/userMan.js"> </script>

<link rel="stylesheet" type="text/css" href="resource/css/intman/userList.css">

     <link rel="stylesheet" type="text/css" href="resource/css/common/jquery.ui.css">
		<link rel="stylesheet" type="text/css" href="resource/css/common/jquery.ui.all.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/common/jquery.ui.datepicker.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/common/jquery.ui.timepicker.css">
  <script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.core.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.datepicker.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.datepicker-zh-CN.js">
</script>
   <script type="text/javascript">
var j = jQuery.noConflict(true);
</script>  
<script type="text/javascript">
		 
		j(function(){
		j("#countTimestart").datepicker( { 
		  	changeMonth: true, 
		    changeYear: true, 
		    firstDay: "7",
            showMonthAfterYear : true,
             showButtonPanel:true
            });
	});
</script>
  </head>
  
  <body>
<div class="mainDiv">

<div class="panel_main">

 <div class="title_main">员工信息</div>

 <div class="content_margin">
 <s:form action="userAction_%{userId!=null?'updateUser':'saveUser'}" method="post">
 <s:hidden id="id" name="id" value="%{user.id}"></s:hidden>
 <table id="t">
 <tr>
 <td class="title">姓名：</td> <td><s:textfield name="name" value="%{user.name}" cssClass="{required:true}"></s:textfield></td> <td class="title">性别：</td> <td><s:radio name="sex" list="#{'男':'男','女':'女'}"  value="#{user.sex}" ></s:radio></td> 
 </tr>
 <tr>
 <td class="title">年龄：</td> <td><s:textfield cssClass="{required:true}" name="age" value="%{user.age}"></s:textfield></td> <td class="title">政治面貌：</td> <td><s:textfield cssClass="{required:true}" name="polite" value="%{user.polite}"></s:textfield></td>
 </tr>
  <tr>
 <td class="title">学历：</td> <td><s:textfield cssClass="{required:true}" name="degree" value="%{user.degree}"></s:textfield></td> <td class="title">专业：</td> <td><s:textfield cssClass="{required:true}" name="job" value="%{user.job}"></s:textfield></td>
 </tr>
  <tr>
 <td class="title">工号：</td> <td><s:textfield cssClass="{required:true,minlength:6}" name="workNo" value="%{user.workno}"></s:textfield></td> <td class="title">身份证号：</td> <td colspan="2"><s:textfield cssClass="{required:true,minlength:18,maxlength:18,digits:true}" name="idno" value="%{user.idno}"></s:textfield></td>
 </tr>
  <tr>
 <td class="title">部门：</td> <td><s:select  id="depId" value="%{user.department.id}" name="depId" list="depList" listKey="id" listValue="name" headerKey="" headerValue="--请选择部门--" cssClass="{required:true}"></s:select>
</td> <td class="title">职称：</td> <td colspan="2"><s:textfield cssClass="{required:true}" name="jobtitle" value="%{user.jobtitle}"></s:textfield></td>
</tr>

 <tr>
 <td class="title">工作日期：</td> <td colspan="3"><s:textfield cssClass="required" name="workdate" value="%{user.workdate}" id="countTimestart" ></s:textfield></td>
<td> 
<s:select list="roleList" name="roleIds" listKey="id" listValue="name" multiple="true" size="10"></s:select>

</td>
 </tr>

 </table>
 

 
 <s:submit value="保存"></s:submit>
 </s:form>
<%--<s:if test="userId!=null">
<div><input type="button" onclick="delete_user(${userId})" value="删除"/></div>
</s:if>
 --%></div>

</div>
</div>
  </body>
</html>
