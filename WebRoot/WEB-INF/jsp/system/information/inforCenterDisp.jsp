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
    
    <title>通知内容</title>
    
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
    <link rel="stylesheet" type="text/css" href="resource/css/information/inforCenterDisp.css">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<!--<script type="text/javascript" src="resource/js/information/inforCenterDisp.js"></script>-->
  </head>
  
  <body>


<div class="mainDiv">
 
  <!--  通知内容   -->
  <div class="panel_main">
    <div class="title_main">
    	<span class="span_item">详细内容</span>
    </div>
    <div class="content_margin">
    
   		<div class="article">
       		<span class="article_title">${trainNotice.noticeTitle}</span>
       </div>
       <div class="article_main">
       <p>${trainNotice.noticeContent}
       </p>
                         
<p>
  附件：<a href="info/InformationCenterAction_informationCenterDownload.action?noticeAttach=${trainNotice.noticeAttach}">${trainNotice.noticeAttach}</a><br/>

       </p>
       </div>
       
    </div>
   </div>
    
    
    

  
</div>

</body>
</html>
