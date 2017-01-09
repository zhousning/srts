<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>培训考试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/exam.css">
    <link rel="stylesheet" type="text/css" href="resource/css/examination/examTrainList.css" />
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/examination/examTrainList.js"></script>
 	<script type="text/javascript">
 /**
 * 倒计时
 */
	var timer = 0;
 
function wr(){
	    document.getElementById("t_h").innerHTML = "00时";
	    document.getElementById("t_m").innerHTML = "00分";
	    document.getElementById("t_s").innerHTML = "00秒";
}

function GetRTime() {
	var ed = $("#exam_date").text();
	var st = $("#exam_time").text();
	var et = $("#end_Time").text();
	
	ed = ed.replace(/-/g, "/");
	var est = ed + " " + st;
	var eet = ed + " " + et;
	var StartTime = new Date(est);
	var EndTime = new Date(eet);
	var NowTime = new Date();
	
	var stt = StartTime.getTime();
	var ett = EndTime.getTime();
	var ntt = NowTime.getTime();
	var t = stt - ntt;

	var h = Math.floor(t / 1000 / 60 / 60 % 24);
	var m = Math.floor(t / 1000 / 60 % 60);
	var s = Math.floor(t / 1000 % 60);
	if (h < 10) {
		h = "0" + h;
	}
	if (m < 10) {
		m = "0" + m
	}
	if (s < 10) {
		s = "0" + s;
	}

	
    if(ntt < stt){
    	document.getElementById("t_h").innerHTML = h + "时";
	    document.getElementById("t_m").innerHTML = m + "分";
	    document.getElementById("t_s").innerHTML = s + "秒";
	    $("#exam_state").html("考试未开始");
    }else if(stt <= ntt && ntt <= ett){
    	 clearInterval(timer);
    	wr();
    	$("#exam_state").html("考试进行中");
    	$("#confirm_info").removeAttr("disabled");
    }else{
    	clearInterval(timer);	
    	wr();
    	$("#exam_state").html("考试已结束");
    }
} 
		window.onload = function(){
			initLine();
			initColumn();
			initPie();
			initLine1();
			<s:if test="testInfo!=null">
			timer = setInterval(GetRTime, 1000);
			</s:if>
		}
		
		$(function(){
			<s:if test="testInfo!=null">
			$("#infoNone").css("display","none");
			$("#infoExam").css("display","block");
			    </s:if>;
			  <s:else>
			$("#infoNone").css("display","block");
			$("#infoExam").css("display","none");
			    </s:else>;
		})
	</script>
  </head>
  
  <body>
<div class="mainDiv">

  <!-- 上方 -->
  <div id="info_main" class="panel_main">
    <div class="title_main"><span class="span_item">培训考核</span></div>
    
    <!-- 无通知时显示 -->
    <div id="infoNone" class="panel_sub info_sub">
      <div class="title_sub"><span class="span_item">考试通知</span></div>
      <div class="content_margin">
        <div>亲爱的员工，目前没有考试通知，您可以进行自主学习或测试。</div>
      </div>
    </div>
    
    <!-- 培训考核信息 -->
    <div id="infoExam" class="panel_sub info_sub">
      <div class="title_sub"><span class="span_item">考试通知</span></div>
      <div class="content_margin">
        <!-- <div>培训名称：</div> -->
        <s:if test="testInfo!=null">
        <div>考试名称：${testInfo.testName}</div>
            <div>考试时间：<SPAN id="exam_date">${testInfo.testDate}</SPAN> <SPAN id="exam_time">${testInfo.testTime}</SPAN>-<span id="end_Time">${testInfo.endTime}</span></div>  
        <div>距离考试开始还有：<span id="t_h"></span><span id="t_m"></span><span id="t_s"></span></div>     
        <div>姓名：${user.name}</div>
        <div>工号：${user.workno}</div>
         <div>职务：${user.jobtitle}</div>
            </s:if>
        <div id="startExam" ><span id="exam_state"></span><input type="button" id="confirm_info" onclick="start_exam(${testInfo.id})" disabled="disabled" value="开始考试"/><br /></div>
      </div>
      </div>
    </div>
    
    <div class="filling">&nbsp;</div>

  <!-- 上方结束 -->


  <!-- 下方图表 -->
  <div id="statistic" class="panel_main_graph">
    <div class="title_main"><span class="span_item">统计图表</span></div>
    
    <div class="graph panel_sub_graph">
      <div class="title_sub"><span class="span_item">近十次培训考试成绩统计图</span></div>
      <div class="content_margin_graph">
		<div id="historyScoreContainer"></div>
	  </div>
    </div>
    
    <div class="graph panel_sub_graph">
      <div class="title_sub"><span class="span_item">近十次成绩稳定性变化曲线</span></div>
      <div class="content_margin_graph">
      	<div id="scoreStabContainer"></div>
      </div>
    </div>

    <div class="graph panel_sub_graph">
      <div class="title_sub"><span class="span_item">各阶段成绩分布统计百分比</span></div>
      <div class="content_margin_graph">
		<div id="scorePercContainer"></div>
	  </div>
    </div>

    <div class="graph panel_sub_graph">
      <div class="title_sub"><span class="span_item">近十次成绩排名变化曲线</span></div>
      <div class="content_margin_graph">
	  	<div id="scoreOrderContainer"></div>
	  </div>
    </div>
    <div class="filling">&nbsp;</div>
  </div>
  <!-- 下方图表结束 -->
</div>
  
  </body>
</html>
