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
    
    <title>My JSP 'trainCourseList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/learning/TrainCourseList.js"></script>
	<STYLE type="text/css">
	#chapterContent{
		height: 300px;
	width: 200px;
	float: left;
	margin-left: 0px;
	margin-top: 0px;
	}
	.current_course{
	margin: 0px auto;
	height: 800px;
	width: 1000px;
		overflow:auto;
	border-top-style: solid;
	border-right-style: double;
	}
	</STYLE>
  </head>
  
  <body>
    <div id="trainContentContainer">
    <div id="chapter_item_Content">
   
       <ul>
       <s:iterator value="bookChapters">
       <li class="level1"> 
       <div id="${id}">${chapterNum}-${chapterName}</div> 
       </li>
       <ul>
       <s:iterator value="contents">
       <li class="level2"> 
       <div id="${id}" onclick="readItemContent($(this))" onmouseout="readChapterContentOut($(this))">${contentName}</div>
       </li>
       </s:iterator>
       </ul>
        </s:iterator>
       </ul>
    </div>
    <div class="current_course" >
  <div class="current_course_title">当前正在阅读:<span id="currentChapter"></span></div>
     <div class="current_course_content" id="course_content"></div>
     <div id="save" myTrainCourseId="${myTrainCourse.id}" contentId="" onclick="finishThisItem($(this))">保存并提交</div>
    </div>
    <%--<input type="button" onclick="finishRead(${userId},${trainCourseId})" value="完成提交"/>--%>
  <s:a action="TrainCourseAction_finishCurrentCourse?userId=%{userId}&trainCourseId=%{trainCourseId}&myTrainCourseId=%{myTrainCourse.id}">退出培训系统</s:a>
    </div>
    <s:debug></s:debug>
  </body>
</html>
