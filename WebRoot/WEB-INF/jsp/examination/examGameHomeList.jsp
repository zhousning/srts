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
    
    <title>游戏大厅</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/exam.css">
    <link rel="stylesheet" type="text/css" href="resource/css/examination/examGameHomeList.css" />
    <link rel="stylesheet" type="text/css" href="resource/css/common/rank.css" />
    
    <script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/examination/examGameHomeList.js"></script>
	<script type="text/javascript">
		window.onload = function(){
			initChart();
		}
	</script>

  </head>
  
  <body>
<div class="mainDiv">

  <!-- 上方 -->
  <div id="info_main" class="panel_main">
    <div class="title_main"><span class="span_item">闯关问答</span></div>
    
    <!-- 模拟考试信息 -->
    <div id="infoTest" class="panel_sub info_sub">
      <div class="title_sub"><span class="span_item">我的纪录</span></div>
      <div class="content_margin">
        <div>我的当前排名：${myCompetitionInfo.myRankNow}</div>
        <div>历史最佳排名：${myCompetitionInfo.myBestRank}</div>
        <div>上次闯关数目：${myCompetitionInfo.myLastScore}</div>
        <div>历史最多闯关数目：${myCompetitionInfo.myBestScore}</div>
        <div id="startExam"><a href="exam/ExaminationGameHomeAction_examGameHomeDisp">点击开始闯关</a></div>
      </div>
    </div>
    <div class="filling">&nbsp;</div>
  </div>
  <!-- 上方结束 -->

  <!-- 下方图表 -->
  <div id="statistic" class="panel_main">
    <div class="title_main"><span class="span_item">统计图表</span></div>
    
    <!--<div class="graph panel_sub">
      <div class="title_sub"><span class="span_item">图1</span></div>
      <div class="content_margin">历史闯关关数统计曲线</div>
    </div>-->
    <div class="graph panel_sub">
      <div class="title_sub"><span class="span_item">历史闯关关数统计曲线</span></div>
    	<div id="lineChart" class="content_margin">
    	  <div id="lineContainer">历史闯关情况</div>
    	</div>
      </div>
    
    <div class="graph panel_sub">
      <div class="title_sub"><span class="span_item">当前闯关Top5排名表</span></div>
      <div class="content_margin">
      <s:iterator value="competitionRankTopFiveNow" id="topFiveNow" status="st">
        <div class="rank1">
            <div class="rank_sn">${topFiveNow[0]}</div>
            <div class="rank_name">${topFiveNow[1]}</div>
            <div class="rank_num">${topFiveNow[2]}</div>
        </div>
        </s:iterator>
      </div>
    </div>

    <div class="graph panel_sub">
      <div class="title_sub"><span class="span_item">历史闯关top5排名表</span></div>
      <div class="content_margin">
      <s:iterator value="competitionRankTopFiveHis" id="topFiveHis" status="st">
        <div class="rank1">
            <div class="rank_sn">${topFiveHis[0]}</div>
            <div class="rank_name">${topFiveHis[1]}</div>
            <div class="rank_num">${topFiveHis[2]}</div>
        </div>
        </s:iterator>
      </div>
    </div>

    <div class="filling">&nbsp;</div>
  </div>
  <!-- 下方图表结束 -->


</div>

  </body>
</html>
