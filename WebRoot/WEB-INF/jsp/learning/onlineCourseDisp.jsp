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
    <title>在线学习</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/learning/StudyCourse.css">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/learning/onlineCourseDisp.js"></script>
	<script type="text/javascript" src="resource/script/JWPlayer/jwplayer.js"></script>
	
	<STYLE type="text/css">
	#con{
	border:2px solid #DDDDDD;
	background:#FFFFFF;
	font-size:20px;
	margin:0px 5px 10px 5px;
	line-height:50px;
	}
	#chapterContent{
	background:	#F4F4F5;
	}
	</STYLE>

	
</head>
<body onunload="checkLeave()">

<div id="studyContentSave" courseInfo="${courseID}" chapterID="" beforeChapterID="" studyStartTime="${studyStartTime}" class="mainDiv">
	<s:if test="%{courseType =='BOOK'}">
	
	<div class="title_main1">课程进度</div>
	<div class="preSave">
      <ul class="course_schedule_ul">
        <s:iterator value="chapterStatusPos" id="chapterStatusPo">
          <s:if test="%{#chapterStatusPo.chapterStatus =='完成'}">
            <li id="${chapterStatusPo.chapterID}">
              <div class="course_schedule_status"><img id="img_${chapterStatusPo.chapterID}" src="resource/image/learning/chapter_status_f_BG.png"/></div>
              <div><img id="img1_${chapterStatusPo.chapterID}" src="resource/image/learning/line1.png"/></div>
              <div>${chapterStatusPo.chapterNum}${chapterStatusPo.chapterName}</div>
            </li>
          </s:if>
          <s:elseif test="%{#chapterStatusPo.chapterStatus =='进行中'}">
            <li id="${chapterStatusPo.chapterID}">
              <div class="course_schedule_status"><img id="img_${chapterStatusPo.chapterID}" src="resource/image/learning/chapter_status_un_BG.png"/></div>
              <div><img id="img1_${chapterStatusPo.chapterID}" src="resource/image/learning/line2.png"/></div>
              <div>${chapterStatusPo.chapterNum}${chapterStatusPo.chapterName}</div>
            </li>
          </s:elseif>
          <s:else>
            <li id="${chapterStatusPo.chapterID}">
              <div class="course_schedule_status"><img id="img_${chapterStatusPo.chapterID}" src="resource/image/learning/chapter_status_un_BG.png"/></div>
              <div><img id="img1_${chapterStatusPo.chapterID}" src="resource/image/learning/line3.png"/></div>
              <div>${chapterStatusPo.chapterNum}${chapterStatusPo.chapterName}</div>
            </li>
          </s:else>
        </s:iterator>
      </ul>
    </div>

    
	<div class="panel">
		<div class="panel_left1 content_margin1">
		<div class="title_main1" style="text-align: center">章节目录</div>
		<ul class="chapter_ul">
	
		<s:iterator value="chapterList" id="chapter">
        	<li class="chapterItem" id="${chapter.id}" onClick="readBookChapterContent($(this))">${chapter.chapterNum}--${chapter.chapterName}</li>
        </s:iterator>
      
        </ul>
		</div>
		<div class="panel_right1 content_margin1">
			<div class="title_main1">当前正在阅读：<span id="currentChapter"></span></div>
			<div class="panel_sub" id="chapterContent">
      		</div>
		</div>
	</div>
	
	</s:if>
	
	<s:if test="%{courseType =='PPT'}">
	<div class="panel">
		正在建设中。。。
	</div>
	</s:if>
	
	<s:if test="%{courseType =='VIDEO'}">
		<div class="panel">
			<div class="title_main1">${videoInfo.videoName}</div>
			<div class="video_info">
				<div class="info">
					<div class="btn">下载</div>
					<span>${videoInfo.uploadUsr}</span>上传于<span>${videoInfo.uploadDate}</span>
					<span class="split">|</span>
					<span>${videoInfo.viewCount}次播放</span>
					<span class="split">|</span>
					<span>${videoInfo.loadCount}次下载</span>
					
				</div>
			</div>
			<div id="videoMain">播放器加载失败，请联系管理员</div>
			<script type="text/javascript">
    		jwplayer("videoMain").setup({
       	 		file:  "http://" + window.location.host + "/srts/resource/templete/learning/book_ppt_video/${videoInfo.saveURL}",
        		<s:if test="%{videoInfo.videoImgURL !=''}">
       	 			image: "${videoInfo.videoImgURL}",
       	 		</s:if>
       	 		<s:else>
       	 			image: "resource/templete/knowledge/VIDEO/default.jpg",	
       	 		</s:else>
        		width: 800,
        		height: 400
       		});    		
			</script>
			<div>
				<div class="title_main1">相关视频推荐</div>
				<div class="video_content">
				<s:iterator value="recommendVideos" id="recommend">
					<div class="videos">
    					<div class="video" id="${recommend.id}">
							<a href="learning/OnlineCourseAction_onlineCourseDisp?courseID=${recommend.id}&courseType=VIDEO">
							<s:if test='%{#recommend.videoImgURL !=""}'>
								<img src="${recommend.videoImgURL}" alt="${recommend.videoName}" width="120" height="140"/>
							</s:if>
							<s:else>
								<img src="resource/templete/knowledge/VIDEO/default.jpg" alt="${recommend.videoName}" width="120" height="140"/>
							</s:else>
							</a>
		  				</div>
		  				<div class="video"><a href="learning/OnlineCourseAction_onlineCourseDisp?courseID=${recommend.id}&courseType=VIDEO">${recommend.videoName}</a></div>
    				</div>
    			</s:iterator>
				</div>
			</div>
		</div>
	</s:if>
</div>

</body>
</html>
