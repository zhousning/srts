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
    
    <title>帖子详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/onlineForumModelDisp.css">
	<script type="text/javascript" src="resource/js/communication/onlineForumModelDisp.js"></script>
</head>
<body>
<div class="mainDiv">
    <div class="ModelDetailContainer">
    	<div><img src="resource/image/communication/model_theme.png" height="32px" width="32px"/></div>
    	<div class="model_title"><a href="#">${oneBBSArticalShow.artical.model.modelName}</a></div>
    	<div class="modle_artical_count">帖子：${oneBBSArticalShow.artical.model.articalCount}</div>
    	
    </div>
    <div class="articalDetailContainer" articalId="${oneBBSArticalShow.artical.id}">
    	<div class="articalDetail_title">
    		<span class="articalDetail_title_reply"><a href="" onclick="articalReplyFun();return false">回复(${oneBBSArticalShow.artical.replyCount})</a></span>
    		<span class="articalDetail_title_cont">${oneBBSArticalShow.artical.articalTile}</span>
    	</div>
    	<div class="articalDetail">
    		<div class="articalPostUsrInfo">
    			<div class="postUsrInfo_img"><img src="resource/image/communication/articalUsrImg.png" height="80px" width="80px"/></div>
    			<div class="postUsrInfo_art_count"><span>用户名：${oneBBSArticalShow.artical.usr.name}</span><!-- <span>|</span><span>发帖：6</span> --></div>
    		</div>
    		<div class="articalDetailInfo">
    			<div class="articalDetail_content">${oneBBSArticalShow.artical.articalContent}</div>
    		</div>
    	</div>
    </div>

    <div class="replyDetailContainer">
    	<s:iterator value="oneBBSArticalShow.replys" status="stt">
    	<div class="replyDetail_main">
    		<div class="replyPostUsrInfo">
    			<div class="postUsrInfo_img"><img src="resource/image/communication/articalUsrImg.png" height="80px" width="80px"/></div>
    			<div class="postUsrInfo_art_count"><span>用户名：${bbsArticalRePly.usr.name}</span><!-- <span>|</span><span>发帖：26</span> --></div>
    		</div>
    		<div class="replyDetailInfo">
    			<div class="replyDetail_content">${bbsArticalRePly.replyContent}</div>
    			<div class="reply_main">
    				<div class="replyDetail_group_btn">
    					<span class="reply_btn">
    						<a href="" onclick="articalReplyFun1($(this),${bbsArticalRePly.id},${bbsArticalRePly.usr.id});return false">回复</a>
    					</span>
    					<span>|</span>
    					<span>回复时间:${bbsArticalRePly.date}</span>
    					<span>|</span>
    					<span>${stt.count }楼</span>
    				</div>
    				<div class="replyList">
    					<ul class="replyList_ul">
    						<s:iterator value="bbsReplyReplies">
    						<li>
    							<div class="reply_usr_img"><img src="resource/image/communication/articalUsrImg.png" height="32px" width="32px"/></div>
    							<div class="reply_usr_info">
    								<div class="usr_info_reply"><span>${usrReply.name}</span> 回复${usr.name }:${replyContent}</div>
    								<div class="usr_reply">
    									<span class="usr_reply_span"><a href="" onclick="articalReplyFun2($(this),${articalReply.id},${usrReply.id});return false">回复</a></span>
    									<span>${date}</span>
    								</div>
    							</div>
    						</li>
    						</s:iterator>
    					</ul>
    					<div class="usr_reply_div close" opstat="open" id="usr_reply_div">
    						<textarea id="usrReplyTextarea" style="height:70px;width:640px;overflow-y:auto;" ></textarea>
    						<div class="usr_reply_div_btn" onclick="submitUserReply()">提交</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</div>
    	</s:iterator>
    </div>
    <div class="replyAreaContainer">
    	<div class="replyAreaContainer_div">
    		<div class="replyArea_title">发表回复</div>
    		<div class="replyArea_content">
    			<textarea id="replyTextarea" style="height:150px;width:700px;overflow-y:auto;"></textarea>
    			<div class="replyArea_btn" onclick="submitReply()">
    				<a>发表回复</a>
    			</div>
    		</div>
    	</div>
    </div>
</div>
</body>
</html>
