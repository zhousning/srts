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
    
    <title>培训课程</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/learning/train.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/learning/traintable.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/learning/trainCourseList.css" rel="stylesheet" type="text/css" />
	
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/learning/TrainCourseList.js"></script>
		<%--<script type="text/javascript" src="resource/script/jquery/jquery.dataTables.js"></script>--%>

	<script type="text/javascript">
		$(document).ready(function(){
			initChart(${userId});
		});
	</script>

  </head>
  <body>
  <div class="mainDiv">
  	<div id="current" class="panel_main">
  	  <div class="title_main"><span class="span_item">当前课程</span></div>
  	  <div class="content_margin">
  		<table id="currentCourse">
  		  <thead>
  			<tr class="table_th">
              <th><span class="span_item">序号</span></th>
              <th><span class="span_item">培训编号</span></th>
              <th><span class="span_item">课程名称</span></th>
              <th><span class="span_item">学习章节</span></th>
              <th><span class="span_item">章节进度</span></th>
              <th><span class="span_item">累计学习时间</span></th>
              <th><span class="span_item">最近学习时间</span></th>
              <th><span class="span_item">在线练习</span></th>
            </tr>
  		  </thead>
  		  <tbody>
  			<s:iterator value="myCurrentTrainCourses" status="stuts">                
  			<tr>
  			  <td>
                <s:property value="#stuts.index+1"/>
  			  </td>
  			  <td>第${trainCourse.id}次培训</td>
  			  <td>
  				<s:subset source="trainCourse.chapters" var="bName" count="1" start="0">
  				  <s:iterator value="#attr.bName">
                     ${bookName} 
                  </s:iterator>
  				</s:subset>
  			  </td>
  			  <td>
  				<s:iterator value="trainCourse.chapters" >
  					${chapterNum}&nbsp;
  				</s:iterator>
  			  </td>
  			  <td>
  				<div style="border-bottom-color: ">
  				<div style="width:${schedule}%;heigth:20px;background:red;">${schedule}%</div>
  				</div>
  			  </td>
  			  <td>${sumTime}</td>
  			  <td>${lastStudyDate}</td>
  			  <td><s:a action="TrainCourseAction_trainContentUi?trainCourseId=%{trainCourse.id}&userId=%{user.id}">开始学习</s:a></td>
  			</tr>
  			</s:iterator>
  		  </tbody>
  		</table>
  	  </div>
  	</div>
    <s:debug></s:debug>

    <div id="past" class="panel_main">
      <div class="title_main"><span class="span_item">课程回顾</span></div>
      <div class="content_margin">
        <table id="historyCourse">
          <thead>
            <tr class="table_th">
              <th><span class="span_item">序号</span></th>
              <th><span class="span_item">培训编号</span></th>
              <th><span class="span_item">课程名称</span></th>
              <th><span class="span_item">学习章节</span></th>
              <th><span class="span_item">开始日期</span></th>
              <th><span class="span_item">结束日期</span></th>
              <th><span class="span_item">最近学习日期</span></th>
              <th><span class="span_item">学习时长</span></th>
              <th><span class="span_item">阅读次数</span></th>
              <th><span class="span_item">在线练习</span></th>
            </tr>
          </thead>
          <tbody>
            <s:iterator value="myHistoryTrainCourses" status="stuts"> 
              <tr>
                <td class="hightlight">
                  <s:property value="#stuts.index+1"/>
                </td>
                <td>第${trainCourse.id}次培训</td>
                <td>
                  <s:subset source="trainCourse.chapters" var="bName" count="1" start="0">
                    <s:iterator value="#attr.bName">
                      ${bookName}
                    </s:iterator>
                  </s:subset>
                </td>
                <td>
                  <s:iterator value="trainCourse.chapters" >
                    ${chapterNum}&nbsp;
                  </s:iterator>
                </td>
                <td>${startTime}</td>
                <td>${endTime}</td>
                <td>${lastStudyDate}</td>
                <td>${sumTime}</td>
                <td>${sumRead}</td>
                <td><s:a action="TrainCourseAction_trainContentUi?trainCourseId=%{trainCourse.id}&userId=%{user.id}">开始学习</s:a></td>
              </tr>
            </s:iterator>
          </tbody>
        </table>
      </div>
    </div>
        
        
    <div class="panel_main">
      <div class="title_main"><span class="span_item">当前学习状况</span></div>
      <div class="content_margin">
        <div id="graph1" class="panel_sub">
          <div class="title_sub"><span class="span_item">当前课程学习时间累计</span></div>
          <div id="timeContainer" class="content_margin">23'10</div>
        </div>
        <div id="graph2" class="panel_sub">
          <div class="title_sub"><span class="span_item">完成度</span></div>
          <div id="pieChart" class="content_margin">
              <div id="pieContainer">完成度</div>
          </div>
        </div>
      </div>
      <div class="filling">&nbsp;</div>
    </div>

    <div class="panel_main">
      <div class="title_main"><span class="span_item">历史学习状况</span></div>
      <div class="content_margin">
      <div id="graph3" class="panel_sub">
        <div class="title_sub"><span class="span_item">员工平均课程学习时间和我的学习时间对比</span></div>
        <div id="lineChart" class="content_margin">
          <div id="lineContainer">课程学习时间对比</div>  
        </div>
      </div>
      <div id="graph4" class="panel_sub">
        <div class="title_sub"><span class="span_item">历史课程阅读次数</span></div>
        <div id="columnChart" class="content_margin">
          <div id='columnContainer'>课程阅读次数统计</div>
        </div>
      </div>
      <div id="graph5" class="panel_sub">
        <div class="title_sub"><span class="span_item">培训学习时间统计</span></div>
        <div id="widgetChart" class="content_margin">
          <div id="widgetContainer">培训学习时间统计</div>  
        </div>
      </div>
      </div>
      <div class="filling">&nbsp;</div>
    </div>

  </div>

</body>
</html>
