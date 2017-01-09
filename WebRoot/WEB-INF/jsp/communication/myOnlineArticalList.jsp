<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/onlineForumModelDisp.css">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/communication/myOnlineArticalList.js"></script>
</head>
<body>
<div class="mainDiv">
    <div class="ModelDetailContainer">
    	<div><img src="resource/image/communication/model_theme.png" height="32px" width="32px"/></div>
    	<div class="model_title"><a href="#">XX专区</a></div>
    	<div class="modle_artical_count">帖子：555</div>
    </div>
    <div class="articalDetailContainer">
    	<div class="articalDetail_title">
    		<span class="articalDetail_title_reply"><a href="" onclick="articalReplyFun();return false">回复(57)</a></span>
    		<span class="articalDetail_title_cont">title:XXsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfdsfsfsddfsfsfsdfsdfsdfsXXX</span>
    	</div>
    	<div class="articalDetail">
    		<div class="articalPostUsrInfo">
    			<div class="postUsrInfo_img"><img src="resource/image/communication/articalUsrImg.png" height="80px" width="80px"/></div>
    			<div class="postUsrInfo_art_count"><span>用户名：xx</span><span>|</span><span>发帖：8</span></div>
    		</div>
    		<div class="articalDetailInfo">
    			<div class="articalDetail_content">XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</div>
    		</div>
    	</div>
    </div>
    <div class="replyDetailContainer">
    	<div class="replyDetail_main">
    		<div class="replyPostUsrInfo">
    			<div class="postUsrInfo_img"><img src="resource/image/communication/articalUsrImg.png" height="80px" width="80px"/></div>
    			<div class="postUsrInfo_art_count"><span>用户名：xx</span><span>|</span><span>发帖：8</span></div>
    		</div>
    		<div class="replyDetailInfo">
    			<div class="replyDetail_content">XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</div>
    			<div class="reply_main">
    				<div class="replyDetail_group_btn">
    					<span class="reply_btn">
    						<a href="" onclick="articalReplyFun1();return false">回复</a>
    					</span>
    					<span>|</span>
    					<span>回复时间:2014-04-04</span>
    					<span>|</span>
    					<span>1楼</span>
    				</div>
    				<div class="replyList">
    					<ul class="replyList_ul">
    						<li>
    							<div class="reply_usr_img"><img src="resource/image/communication/articalUsrImg.png" height="32px" width="32px"/></div>
    							<div class="reply_usr_info">
    								<div class="usr_info_reply"><span>用户A</span>：后面是回复内容XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</div>
    								<div class="usr_reply">
    									<span class="usr_reply_span"><a href="" onclick="articalReplyFun2($(this));return false">回复</a></span>
    									<span>2014-06-10</span>
    								</div>
    							</div>
    						</li>
    						<li>
    							<div class="reply_usr_img"><img src="resource/image/communication/articalUsrImg.png" height="32px" width="32px"/></div>
    							<div class="reply_usr_info">
    								<div class="usr_info_reply"><span>用户B</span>：后面是回复内容XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</div>
    								<div class="usr_reply">
    									<span class="usr_reply_span"><a href="" onclick="articalReplyFun2($(this));return false">回复</a></span>
    									<span>2014-06-10</span>
    								</div>
    							</div>
    						</li>
    						<li>
    							<div class="reply_usr_img"><img src="resource/image/communication/articalUsrImg.png" height="32px" width="32px"/></div>
    							<div class="reply_usr_info">
    								<div class="usr_info_reply"><span>用户XX</span>：回复用户A：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</div>
    								<div class="usr_reply">
    									<span class="usr_reply_span"><a href="" onclick="articalReplyFun2($(this));return false">回复</a></span>
    									<span>2014-06-10</span>
    								</div>
    							</div>
    						</li>
    						<li>
    							<div class="reply_usr_img"><img src="resource/image/communication/articalUsrImg.png" height="32px" width="32px"/></div>
    							<div class="reply_usr_info">
    								<div class="usr_info_reply"><span>用户C</span>：后面是回复内容XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</div>
    								<div class="usr_reply">
    									<span class="usr_reply_span"><a href="" onclick="articalReplyFun2($(this));return false">回复</a></span>
    									<span>2014-06-10</span>
    								</div>
    							</div>
    						</li>
    					</ul>
    					<div class="usr_reply_div close" opstat="close" id="usr_reply_div">
    						<textarea style="height:70px;width:640px;overflow-y:auto;" id="usrReplyTextarea"></textarea>
    						<div class="usr_reply_div_btn">提交</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <div class="replyAreaContainer">
    	<div class="replyAreaContainer_div">
    		<div class="replyArea_title">发表回复</div>
    		<div class="replyArea_content">
    			<textarea id="replyTextarea" style="height:150px;width:700px;overflow-y:auto;"></textarea>
    			<div class="replyArea_btn">
    				<a>发表回复</a>
    			</div>
    		</div>
    	</div>
    </div>
</div>
</body>
</html>
