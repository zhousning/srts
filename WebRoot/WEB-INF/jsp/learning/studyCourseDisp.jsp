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
    
    <title>自主学习课程在线学习</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/learning/train.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/learning/StudyCourse.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/learning/studyCourseDisp.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/learning/StudyCourseList.js"></script>
</head>
<body>
<div class="mainDiv">
  <!-- 上方进度图 -->
  <div class="panel_main">
    <div class="title_main">课程进度</div>
    <div class="content_margin">
      <ul class="course_schedule_ul">
        <s:iterator value="chapterStatusPos" id="chapterStatusPo">
          <s:if test="%{#chapterStatusPo.chapterStatus =='完成'}">
            <li id="${chapterStatusPo.chapterID}">
              <div class="course_schedule_status"><img src="resource/image/learning/chapter_status_f_BG.png"/></div>
              <div><img src="resource/image/learning/line1.png"/></div>
              <div>${chapterStatusPo.chapterNum}${chapterStatusPo.chapterName}</div>
            </li>
          </s:if>
          <s:elseif test="%{#chapterStatusPo.chapterStatus =='进行中'}">
            <li id="${chapterStatusPo.chapterID}">
              <div class="course_schedule_status"><img src="resource/image/learning/chapter_status_un_BG.png"/></div>
              <div><img src="resource/image/learning/line2.png"/></div>
              <div>${chapterStatusPo.chapterNum}${chapterStatusPo.chapterName}</div>
            </li>
          </s:elseif>
          <s:else>
            <li id="${chapterStatusPo.chapterID}">
              <div class="course_schedule_status"><img src="resource/image/learning/chapter_status_un_BG.png"/></div>
              <div><img src="resource/image/learning/line3.png"/></div>
              <div>${chapterStatusPo.chapterNum}${chapterStatusPo.chapterName}</div>
            </li>
          </s:else>
        </s:iterator>
      </ul>
    </div>
    <div class="filling">&nbsp;</div>
  </div>
    
  <div>
    <div class="panel_main" id="panel_left">
      <div class="title_main">学习章节</div>
      <div class="course_chapter_list">
          <ul class="course_chapter_ul">
              <s:iterator value="bookChapters" id="chapter" status="st">
                  <s:if test="%{#st.index ==0}">
                      <li class="first" id="${chapter.id}" onClick="readBookChapterContent($(this))" onMouseOut="readBookChapterContentOut($(this))">${chapter.chapterNum}--${chapter.chapterName}</li>
                  </s:if>
                  <s:else>
                      <li class="other" id="${chapter.id}" onClick="readBookChapterContent($(this))" onMouseOut="readBookChapterContentOut($(this))">${chapter.chapterNum}--${chapter.chapterName}</li>
                  </s:else>
              </s:iterator>
          </ul>
      </div>
      <div class="filling">&nbsp;</div>
    </div>
  
    <div class="panel_main" id="panel_right">
      <div class="title_main">当前正在阅读：<span id="currentChapter"></span></div>
      <div class="course_content" id="course_content">
        <s:iterator value="chapterContents" id="chapterContent">
          <div>
            <div>${chapterContent.contentName}</div>
            <div>${chapterContent.content}</div>
          </div>
        </s:iterator>
      </div>
      <div class="filling">&nbsp;</div>
    </div>
    
    <div class="filling">&nbsp;</div>
  </div>
  
</div>
</body>
</html>
