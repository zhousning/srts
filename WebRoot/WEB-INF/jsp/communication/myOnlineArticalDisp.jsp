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
    
    <title>我的帖子</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/myOnlineArticalDisp.css">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/communication/myOnlineArticalDisp.js"></script>
</head>
<body>
<div class="mainDiv">
	<div class="container">
		<div class="container_title">
			<div class="type" id="my_artical" onclick="forumArticalChange($(this))" onmousemove="forumArticalChange_over($(this))" onmouseout="forumArticalChange_out($(this))">我的帖子</div>
			<div class="type" id="my_reply" onclick="forumArticalChange($(this))" onmousemove="forumArticalChange_over($(this))" onmouseout="forumArticalChange_out($(this))">我回复的</div>
			<div class="type" id="reply_my" onclick="forumArticalChange($(this))" onmousemove="forumArticalChange_over($(this))" onmouseout="forumArticalChange_out($(this))">回复我的</div>
			<div class="type" id="my_message" onclick="forumArticalChange($(this))" onmousemove="forumArticalChange_over($(this))" onmouseout="forumArticalChange_out($(this))">我的消息</div>
		</div>
		<div class="container_Content">
			<div class="container_Content1" id="container_Content1">
				<s:iterator value="myArtical.articals">
				<div class="item">
					<div class="item_content">
						<div class="title_item"><span>回复：${replyCount}</span><span>浏览：${viewCount}</span><a href="commu/OnlineForumAction_onlineForumModelDisp?articalId=${id}">${articalTile}</a></div>
						<div class="content_item">${articalContent}</div>
						<div class="info_item"><span>${date}</span><span>${model.modelName}</span></div>
					</div>
				</div>
				</s:iterator>
				<div class="page_Main">
				<ul class="page_ul">
					<li class="page">«</li>
					<li class="page">1</li>
					<li class="page">2</li>
					<li class="page">3</li>
					<li class="page">4</li>
					<li class="page">5</li>
					<li class="page">6</li>
					<li class="page">»</li>
					<li class="total">共6页</li>
				</ul>
				</div>
			</div>
			<div class="container_Content2" id="container_Content2">
				<s:iterator value="myReplyContents">
					<div class="item">
					<div class="item_content">
						<div>我回复${name}：</div>
						<div>${content}</div>
						<div>标题:${title}-来自${modelName}专区</div>
					</div>
				</div>
				</s:iterator>
				
				
				<div class="page_Main">
				<ul class="page_ul">
					<li class="page">«</li>
					<li class="page">1</li>
					<li class="page">2</li>
					<li class="page">3</li>
					<li class="page">4</li>
					<li class="page">5</li>
					<li class="page">6</li>
					<li class="page">»</li>
					<li class="total">共6页</li>
				</ul>
				</div>
			</div>
			<div class="container_Content3" id="container_Content3">
				<s:iterator value="hisReplyContents">
					<div class="item">
					<div class="item_content">
						<div>员工${name }回复我：</div>
						<div>${content}</div>
						<div>标题:${title}-来自${modelName }专区</div>
					</div>
				</div>
				</s:iterator>
				
				
				<div class="page_Main">
				<ul class="page_ul">
					<li class="page">«</li>
					<li class="page">1</li>
					<li class="page">2</li>
					<li class="page">3</li>
					<li class="page">4</li>
					<li class="page">5</li>
					<li class="page">6</li>
					<li class="page">»</li>
					<li class="total">共6页</li>
				</ul>
				</div>
			</div>
			<!-- 
			<div class="container_Content4" id="container_Content4">
				<div class="item">
					<div class="item_content">
						<div>title:XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX通过审核</div>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div>title:XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX被删</div>
					</div>
				</div>
				<div class="item">
					<div class="item_content">
						<div>title:XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX通过审核</div>
					</div>
				</div>
				<div class="page_Main">
				<ul class="page_ul">
					<li class="page">«</li>
					<li class="page">1</li>
					<li class="page">2</li>
					<li class="page">3</li>
					<li class="page">4</li>
					<li class="page">5</li>
					<li class="page">6</li>
					<li class="page">»</li>
					<li class="total">共6页</li>
				</ul>
				</div>
			</div>
			 -->
		</div>
	</div>
</div>
</body>
</html>
