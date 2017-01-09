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
    <title>错题回顾</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/learning/train.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/learning/errorSetList.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/learning/ErrorSetList.js"></script>
	<script type="text/javascript">
		window.onload = function(){
			initChart();
		}
	</script>
</head>
<body>
<div class="mainDiv">
  <div class="panel_main">
    <div class="title_main">错题练习</div>
    <div class="content_margin">
      <div class="errorSet_main_level current" id="level" onMouseOver="errorSetMain_over($(this))" onMouseOut="errorSetMain_out()">掌握程度</div>
      <div class="errorSet_main_type" id="type" onMouseOver="errorSetMain_over($(this))" onMouseOut="errorSetMain_out()">题目类型</div>
      <div class="errorSet_main_time" id="time" onMouseOver="errorSetMain_over($(this))" onMouseOut="errorSetMain_out()">记录时间</div>
      <div class="errorSet_main_set" id="errorSet_main_set">
      <div class="title">掌握程度选择</div>
        <ul class="errorSet_main_set_ul">
          <li><img onClick="errorSetMain_check($(this))" class ="check" src="resource/image/learning/ratio_true_BG.png"/><span id="learning/ErrorSetAction_ErrorSetDisp?modelType=zhangwochengdu&flag=0&type=''&timeLength=''">掌握较好</span></li>
          <li><img onClick="errorSetMain_check($(this))" src="resource/image/learning/ratio_false_BG.png"/><span id="learning/ErrorSetAction_ErrorSetDisp?modelType=zhangwochengdu&flag=1&type=''&timeLength=''">基本掌握</span></li>
          <li><img onClick="errorSetMain_check($(this))" src="resource/image/learning/ratio_false_BG.png"/><span  id="learning/ErrorSetAction_ErrorSetDisp?modelType=zhangwochengdu&flag=2&type=''&timeLength=''">掌握较差</span></li>
          <li><img onClick="errorSetMain_check($(this))" src="resource/image/learning/ratio_false_BG.png"/><span id="learning/ErrorSetAction_ErrorSetDisp?modelType=zhangwochengdu&flag=3&type=''&timeLength=''">完全不会</span></li>
        </ul>
        <div class="errorSet_main_set_exerise" onClick="errorSet_exerise()">开始练习</div>
      </div>
    </div>
    <div class="title_main">近期错题再现</div>
    <div id="displaySe" class="content_margin">
    <table>
    	<tr>
    		<td class="od h">序号</td>
    		<td class="ct h">错题类型</td>
    		<td class="cd h">错题内容</td>
    		<td class="ct h">错题标识</td>
    		<td class="ct h">最近练习时间</td>
    	</tr>
    	<s:iterator value="errorSetSimplifiedDisplayedPo" id="errorSetSeDisplayedPo" status="st">
        <tr >
          <td class="od" id="${errorSetSeDisplayedPo.questionId}">${st.count}</td>
          <td class="ct">${errorSetSeDisplayedPo.type}</td>
          <td class="cd"><div class="cdd">${errorSetSeDisplayedPo.content}</div></td>
          <td class="ct">${errorSetSeDisplayedPo.flag}</td>
          <td class="ct">${errorSetSeDisplayedPo.lastTestTime}</td>
        </tr>
     </s:iterator>
    </table>      
    </div>
  </div>

  <div class="panel_main">
	<div class="title_main">历史错题回顾状况</div>
  
	  <div class="panel_sub" id="graph1">
    	<div class="title_sub">错题掌握情况</div>
    	<div id="pieChart" class="content_margin">
    	  <div id="pieContainer">错题掌握情况</div>
    	</div>
      </div>
    	
      <div class="panel_sub" id="graph2">
    	<div class="title_sub">错题复习变化曲线</div>
    	<div id="lineChart" class="content_margin">
    	  <div id="lineContainer">错题掌握情况</div>
    	</div>
      </div>
    	
      <div class="panel_sub" id="graph3">
    	<div class="title_sub">错题掌握情况</div>
    	<div id="barChart" class="content_margin">
    	  <div id="barContainer">错题掌握情况</div>
    	</div>
      </div>
      
    <div class="filling">&nbsp;</div>
  </div>
</div>
</body>
</html>
