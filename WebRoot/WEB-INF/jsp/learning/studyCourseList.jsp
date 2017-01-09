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
    <title>自主学习</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/learning/train.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/learning/StudyCourse.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/learning/studyCourseList.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/learning/StudyCourseList.js"></script>
	<script type="text/javascript">
		window.onload = function(){
			initChart();
		}
	</script>
  </head>
<body>

<div class="mainDiv">

  <div class="panel_main">
	<div class="title_main"><span class="span_item">自主学习课程</span></div>
	<div class="content_margin">
	  <s:iterator value="bookList" id="book">
		<div class="studyBook_main_books">
		  <div class="studyBook_main_book" id="${book.id}">
			<a href="learning/StudyCourseAction_studyCourseDisp?bookID=${book.id}"><img src="${book.bookIcon}" alt="${book.bookName}" width="140" height="161"/></a>
		  </div>
		  <div><a href="learning/StudyCourseAction_studyCourseDisp?bookID=${book.id}">${book.bookName}</a></div>
		</div>
	  </s:iterator>
	</div>
    <div class="filling">&nbsp;</div>
  </div>

  <div class="panel_main">
    <div class="title_main"><span class="span_item">自主学习历史课程</span></div>
    <div class="content_margin">
      <s:iterator value="studyBookList" id="studyBookInfoPo" status="bookInfo">	
        <div class="myStudyCourse_main_books">
          <div class="myStudyCourse_main_book" onMouseOver="bookChapterInfo_over($(this))" onMouseOut="bookChapterInfo_out($(this))" chapter-info="${studyBookInfoPo.bookChapterInfo}">
            <img  id="${studyBookInfoPo.bookId}" src="${studyBookInfoPo.bookIcon}" alt="${studyBookInfoPo.bookName}"  width="140" height="161"/>
          </div>
          <div class="title">学习进度：${studyBookInfoPo.schedule}%</div>
          <div><a href="learning/StudyCourseAction_studyBookOtherChapter?bookID=${studyBookInfoPo.bookId}">${studyBookInfoPo.bookName}</a></div>
        </div>
      </s:iterator>
      <div class="myStudyCourse_chapter" id="bookChapterInfo"></div>
    </div>
    <div class="filling">&nbsp;</div>
  </div>

  <div class="panel_main">
    <div class="title_main"><span class="span_item">自主学习统计数据</span></div>

      <div class="panel_sub" id="graph1">
        <div class="title_sub"><span class="span_item">累计时间</span></div>
        <div id="columnChart" class="content_margin">
          <div id='columnContainer'>当前各门课程学习时间累计</div>
        </div>
      </div>
  
      <div class="panel_sub" id="graph2">
        <div class="title_sub"><span class="span_item">学习进度</span></div>
        <div id="msBarChart" class="content_margin">
          <div id="barContainer">课程学习时间对比</div>  
        </div>
      </div>
  
      <div class="panel_sub" id="graph3">
        <div class="title_sub"><span class="span_item">学习效率</span></div>
        <div id="lineChart" class="content_margin">
          <div id='lineContainer'>学习效率曲线</div>
        </div>
      </div>

    <div class="filling">&nbsp;</div>
  </div>
</div>
</body>
</html>