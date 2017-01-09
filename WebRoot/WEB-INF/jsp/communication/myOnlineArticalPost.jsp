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
    
    <title>我要发帖</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/myOnlneArticalPost.css">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/communication/myOnlineArticalPost.js"></script>
</head>
<body>
<div class="mainDiv">
	<div class="container">
		<div class="item">
			<div class="title">请选择专区</div>
			<div class="content">
				<div class="selected" id="selected" onclick="selectFun(event)">
					<div class="selected_title" >请选择</div>
					<div class="selected_btn"><img src="resource/image/communication/select_dropdowm_btn.png"/></div>
				</div>
				<div class="selected_item" id="selected_item">
					<ul class="content_ul" id="">
					<s:iterator value="models" >
						<li id="${id}" onclick="clickFun($(this))" onmouseover="overFun($(this))" onmouseout="outFun($(this))">${modelName}</li>
					</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div class="item">
			<div class="title">请输入主题</div>
			<div class="content">
				<div><textarea class="area1" ></textarea></div>
			</div>
		</div>
		<div class="item">
			<div class="title">请输入内容</div>
			<div class="content">
				<div><textarea class="area2"></textarea></div>
			</div>
		</div>
		<div class="btn_item">
			<div class="btn" onclick="submit()">提交</div>
		</div>
	</div>
</div>
</body>
</html>
