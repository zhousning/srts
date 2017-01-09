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
    
    <title>学习交流</title>
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/common/paginate.css" media="screen">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/onlineForumModelList.css">
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/communication/onlineForumModelList.js"></script>
 	<script type="text/javascript" src="resource/script/jquery/jquery.paginate.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#demo5").paginate({
				count 		: ${hotBBSArtical.allPageNum},
				start 		: ${curHotPage},
				display     : 5,
				border					: false,
				border_color			: '#BBB8B8',
				text_color  			: '#888',
				background_color    	: '#EEE',	
				border_hover_color		: '#68BA64',
				text_hover_color  		: 'black',
				background_hover_color	: '#CFCFCF', 
				images					: false,
				mouse					: 'press',
				onChange     			: function(page){
											window.location.href='commu/OnlineForumAction_onlineForumModelList?curHotPage='+ encodeURI(encodeURI(page));
										
										  }
			});
		});
		</script>
		<script type="text/javascript">
		$(function() {
			$("#demo").paginate({
				count 		: ${newBBSArtical.allPageNum},
				start 		: ${curNewPage},
				display     : 5,
				border					: false,
				border_color			: '#BBB8B8',
				text_color  			: '#888',
				background_color    	: '#EEE',	
				border_hover_color		: '#68BA64',
				text_hover_color  		: 'black',
				background_hover_color	: '#CFCFCF', 
				images					: false,
				mouse					: 'press',
				onChange     			: function(page){
											window.location.href='commu/OnlineForumAction_onlineForumModelList?curNewPage='+ encodeURI(encodeURI(page));
										
										  }
			});
		});
		</script>
	 
</head>
  
<body>
<div class="mainDiv">
	<div class="forumModelList">
		<a class="modelChange_btn_left" id="prev"></a>
		<div class="modelInfo">
			<ul class="modelInfo_ul" id="scroll_ul_0">
			<s:iterator value="bbsModelInfos" >
				<li>
					<a class="modelInfoDetail">
						<div class="modelInfoDetail_main">
							<div class="modelTitle">${modelName}</div>
							<div class="modelArticalCount">贴数：${articalNum}</div>
							<div class="modelArticalCount">活跃人数：${activePersonNum}</div>
						</div>
					</a>
				</li>			
			</s:iterator>
			</ul>
		</div>
		<a class="modelChange_btn_right" id="next"></a>
	</div>
	
	<div class="forumHotArticalList">
		<div class="forumHotArticalTitle">
			<div class="type" id="hot" onclick="forumArticalChange($(this))" onmousemove="forumArticalChange_over($(this))" onmouseout="forumArticalChange_out($(this))">热门动态</div>
			<div class="type" id="latest" onclick="forumArticalChange($(this))" onmousemove="forumArticalChange_over($(this))" onmouseout="forumArticalChange_out($(this))">最新动态</div>
			<div class="type_right">
				<span><a href="commu/OnlineForumAction_myOnlineArticalDisp">我的动态</a></span>
				<span><a href="commu/OnlineForumAction_toMyOnlineArticalPost">我要发帖</a></span>
			</div>
		</div>
		<div class="hotArticalMain" id="hotArticalMain">
			<s:iterator value="hotBBSArtical.articals">
			<div class="hotArtical">
				<div class="hotArticalContent">
					<div class="articalmodel"><span>${model.modelName}</span></div>
					<div class="articaltitle"><span>${viewCount}</span><a href="commu/OnlineForumAction_onlineForumModelDisp?articalId=${id}">${articalTile}</a></div>
					<div class="articalcontent">${articalContent}</div>
					<div class="articalusrinfo"><span>员工：${usr.name}</span><span>时间：${date}</span></div>
				</div>
			</div>
			</s:iterator>
			<!-- 分页标签 -->
			<div class="articalPageMain">
				<div id="demo5"></div>
			</div>
		</div>
		<div class="latestArticalMain" id="latestArticalMain">
		<s:iterator value="newBBSArtical.articals">
			<div class="latestArtical">
				<div class="hotArticalContent">
					<div class="articalmodel"><span>${model.modelName}</span></div>
					<div class="articaltitle"><span>${viewCount}</span><a href="commu/OnlineForumAction_onlineForumModelDisp?articalId=${id}">${articalTile}</a></div>
					<div class="articalcontent">${articalContent}</div>
					<div class="articalusrinfo"><span>员工：${usr.name}</span><span>时间：${date}</span></div>
				</div>
			</div>
			</s:iterator>
			<!-- 分页标签 -->
			<div class="articalPageMain">
				<div id="demo"></div>
			</div>
		</div>
	</div>
	<div class="articalAnalisisList">
		<div class="articalAnalisisList1">
			<div class="analisisTitle">发帖排行</div>
			<div class="articalAnalisisList1_main">
				<ul class="analisis_ul">
				<s:iterator value="articalTop3" status="st">
					<li>
						<span class="order">${st.count}</span>
						<span class="usr">${name}</span>
						<span class="count">帖数:${articalNum}</span>
					</li>
				</s:iterator>
				</ul>
			</div>
		</div>
		<div class="articalAnalisisList2">
			<div class="analisisTitle">
				<div class="analisisTitleChange">
					<span class="turn_pre" id="turn_pre"></span>
					<span class="turn_next" id="turn_next"></span>
				</div>
				<span>上月专区达人</span>
			</div>
			<div class="articalAnalisisList2_main">
				<ul class="analisis_change_ul" id="analisis_change_ul">
					<s:iterator value="monthTops">
					<li>
					<div class="usrImg">
						<img src="resource/image/communication/usrImg1.png" width="80px" height="100px"/>
					</div>
					<div class="usr_right">
						<div class="modelarea">${modleName}</div>
						<div class="areaUsr">达人--${userName}</div>
						<div class="postNum">发帖：${articalNum}</div>
						<!-- <div class="replyNum">回复：43</div> -->
					</div>
					</li>
					</s:iterator>
				</ul>
			</div>
		</div>
	</div>
</div>
</body>
</html>
