<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教学视频下载</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/information/info.css">
		<link rel="stylesheet" type="text/css" href="resource/css/common/paginate.css" media="screen">
    <link rel="stylesheet" type="text/css" href="resource/css/information/inforManageCenterList.css">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/information/inforManageCenterList.js"></script>
	<script src="resource/js/learning/jquery.paginate.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(function(){
		for(var i=1; i<=${size}; i++){
			$("#page").append("<option value="+i+">"+i+"</option>"); 
		}
		$("#page").val(${page}); //设置select的value为${page}的项选中 
		$("#page").change(function(){
			window.location="info/InformationUploadAction_downloadVideoByPage.action?page="+$("#page").val();
		});
	});
</script>
	<style type="text/css">
	a:link{text-decoration:none;}
	a:visited{text-decoration:none;}
	a:hover{text-decoration:underline;} 
	</style>
  </head>
  
  <body>
  	

   <div class="mainDiv">
  <!-- 通知管理 -->
  <div class="panel_main">
    <div class="title_main">
    <span class="span_item">
   	 	教学视频下载
    </span>
 
    </div>
    <div class="content_margin">
     <!--  员工问题列表   -->
     <div id="question">
    <table width="90%" class="table">
    <tr height="25">
		<td style="width:8%;">序号</td>
        <td style="width:36%;">名称</td>
		<td style="width:14%;">上传时间</td>
		<td style="width:14%;">上传者</td>
        <td style="width:14%;">下载次数</td>
	</tr>
	<s:iterator value="pageBean.list" status="st">
		<tr height="25">
		<td><s:property value='#st.index+1'/></td>
		<td><a href="info/InformationUploadAction_downloadVideo.action?id=${id }"> ${videoName}</a></td>
		<td>${uploadDate}<br></td>
		<td>${uploadUsr}</td>
		<td>${loadCount}</td>
	</tr>
	
	</s:iterator>
	</table>
        <div align="center">共
		<s:property value="pageBean.allRow" />
		条 共
		<s:property value="pageBean.totalPage" />
		页 第
		<s:property value="pageBean.currentPage" />
		页
		<s:if test="%{pageBean.currentPage == 1}">上一页</s:if>
		<s:else>
			<a
				href="info/InformationUploadAction_downloadVideoByPage.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
		</s:else>
		<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
			<a
				href="info/InformationUploadAction_downloadVideoByPage.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="page">
		</select>
		页</div>
    
</div>
    </div>
    </div>
    </div>
  
</body>
</html>