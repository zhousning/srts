<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>在线练习</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/learning/train.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/learning/onlineExerciseList.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/learning/OnlineExerciseList.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		initLine();
		
		$("#postTheInfo").click(function(){
			$("#myform").submit();
		})
	});
	</script>

</head>
<body>
<div class="mainDiv">
	<div class="panelContainer panel_main">
		<div class="title_main">在线练习</div>
    			<div class="test_count">
    			<form action="learning/OnlineExerciseAction_onlineExerciseDisp" method="post" id="myform">
    				<div class="test_select">试题数目：<input name="testNum" id="testNum" type="text" value="20"/></div>
    				<div class="test_select"><div class="btn1" id="postTheInfo">开始练习</div></div>
    			</form>
    			</div>
    	</div>
    	
        <div class="filling">&nbsp;</div>
	</div>
	    
  <div class="panel_main">
    <div class="title_main"><span class="span_item">学习情况统计</span></div>
    
    <div class="panel_sub" id="graph1">
      <div class="title_sub"><span class="span_item">历史准确率曲线</span></div>
      <div id="lineContain" class="content_margin">
        <div id="lineContainer">历史准确率折线图</div>
      </div>
    </div>
    
    <div class="panel_sub" id="graph2">
      <div class="title_sub"><span class="span_item">稳定性曲线</span></div>
      <div id="stableLine" class="content_margin">
        <div id="stableLineContainer">稳定性曲线图</div>
      </div>
    </div>
    
    <div class="filling">&nbsp;</div>
  </div>
</div>
	</body>
</html>
