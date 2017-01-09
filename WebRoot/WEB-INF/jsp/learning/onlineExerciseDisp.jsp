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
    <title>在线练习</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/learning/train.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/learning/onlineExerciseDisp.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script src="resource/js/learning/onlineExerciseDisp.js" type="text/javascript"></script>
	<style>
		.btnGps{
			display:none;
		}
	</style>
</head>
<body>
<div class="mainDiv">
<div class="panel_main">
	<div>练习题</div>
	<s:iterator value="questionBankList" status="s">
		<div><s:property value="#s.index+1" />、<s:property value="content" /></div>
		<div style="margin-top: 20px;"></div>
	</s:iterator>
  	<div>参考答案</div>
  	<s:iterator value="questionBankList" status="s">
		<div><s:property value="#s.index+1" />、<s:property value="answer" /></div>
		<div style="margin-top: 20px;"></div>
	</s:iterator>
    <div class="filling">&nbsp;</div>
  </div>
</div>
</div>
</body>
</html>
