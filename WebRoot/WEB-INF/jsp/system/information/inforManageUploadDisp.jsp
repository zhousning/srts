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
    
    <title>新建通知</title>
    <!--
  		  这个页面需要文字编辑器
  		  已经尝试过ckeditor，ie显示不出来，360正常
  		 如果可以，多换几个试试
  		 时间不足，先用textarea代替
    -->
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/information/info.css">
    <link rel="stylesheet" type="text/css" href="resource/css/information/inforManageUploadDisp.css">

	<script type="text/javascript" src="resource/js/information/inforManageUploadDisp.js"></script>


</head>
<body>
<div class="mainDiv">
 
  <!--  通知公告列表   -->
  <div class="panel_main">
    <div class="title_main">
    <span class="span_item">
   	 	新建通知
    </span>
    
    </div>
    <div class="content_margin">
    <form action="info/InforManageCenterAction_inforManageCenterNew" method="post" enctype="multipart/form-data" id="myForm">
				     <table width="90%" align="center" border="1" cellpadding="4" cellspacing="1" class="table">
						<tr align='center' height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="center">
						        标题：
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="trainNotice.noticeTitle" Class="{required:true}"/></td>
						</tr>
						<tr align='center' height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="center">
						       类型：
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						        <select name="trainNotice.noticeType">
						        	<option value="考试通知">考试通知</option>
						        	<option value="培训通知">培训通知</option>
						        </select>
						    </td>
						</tr>
                        <tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="center">
						        内容：
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						        
	                            <div><textarea name="trainNotice.noticeContent" class="{required:true}" style=" width:400px; height:100px; resize:none;"></textarea></div>
								<!-- 此textarea应改成网页编辑器 -->
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="center">
						        接收单位：
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						      
						       <select name="trainNotice.acceptCompany" size="1">
						         <option value="吉林供电公司">吉林供电公司</option>
						         <option value="安全监察质量部">安全监察质量部</option>
						         <option value="运维检修部">运维检修部</option>
						         <option value="基建部">基建部</option>
						         <option value="营销部">营销部</option>
						         <option value="调控中心">调控中心</option>
						         <option value="检修试验工区">检修试验工区</option>
						       </select>
					      </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" height="22">
						    <td width="15%" bgcolor="#FFFFFF" align="center">
						        附件：
						    </td>
						    <td width="85%" bgcolor="#FFFFFF" align="left">
						    	<input type="file" name="upload"  size="30" onKeyDown="javascript:alert('此信息不能手动输入');return false;" />
						       
						    </td>
						</tr>
						
						
						<tr align='center' bgcolor="#FFFFFF"  height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">&nbsp;
						        
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="submit" value="提交" /><%--&nbsp; 
						       <input name="重置" type="reset" value="重置"/>&nbsp;
						    --%></td>
						</tr>
					 </table>
					 </form>
      
    </div>
    
    
    

  
  
 
  </div>
   
  </div>


</body>
</html>

