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
    
    <title>学习历史记录管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/learning/StudyCourse.css"/>
	<link rel="stylesheet" type="text/css" href="resource/css/learning/onlineCourseTraceManageList.css"/>
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/learning/onlineCourseTraceManageList.js"></script>
	<style>
	#userCourseTraceRecord{
		position:absolute;
		top:140px;
		left:10px;
		display:none;
		border:1px solid #DDD;
	}
	.winClose{
		float:right;
		cursor: default;
	}
	</style>
	<script type="text/javascript">
$(function(){
		
	$("#queryByOptionFunction").click(function(){
		window.location.href="learning/OnlineCourseTraceManageAction_onlineCourseTraceList.action";
	})
	
		for(var i=1; i<=${size}; i++){
			$("#page").append("<option value="+i+">"+i+"</option>"); 
		}
		$("#page").val(${page}); //设置select的value为${page}的项选中 
		$("#page").change(function(){
			window.location="learning/OnlineCourseTraceManageAction_onlineCourseTraceList.action?page="+$("#page").val();
		});
	});
</script>
</head> 
<body>
<div class="mainDiv">
    <div class="panelContainer">
    <!-- <div class="title_main">记录管理</div> -->
    <!--查询部分-->
	<div class="testQuery content">
		<fieldset>
    		<legend class="title">查询条件</legend>
   			<div class="condt">
				<div class="condt1">单位：<input id="companyId" type="text" /></div>
				<div class="condt1">专业：<input id="majorId" type="text" /></div>
				<div class="condt1">员工：<input id="usrId" type="text" /></div>
				<div class="condt1">
				记录日期：年<select id="noticeYear" onchange="noticeYearSelectChangeFun()">
							<option value="2014">2014</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
							<option value="2019">2019</option>
							<option value="2020">2020</option>
						 </select>
						 月<select id="noticeMonth" onchange="noticeMonthSelectChangeFun()">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						 </select>
				</div>
				<div class="condt1">
				学习内容：<select id="noticeTitle" onchange="noticeTitleSelectChangeFun()">
							<s:iterator value="notices" id="noti">
								<option id="${noti.nonticeMonth}" value="${noti.noticeTitle}">${noti.noticeTitle}</option>
							</s:iterator>
						  </select>	
				</div>
				<div class="condt2"><div class="btn" id="queryByOptionFunction">查询</div></div>
			</div>
  		</fieldset>
	</div>
	<!--学习记录-->
	<div id="userCourseTraceRecord">
		<div class="title_sub">员工学习记录<span class="winClose" onclick="traceRecordWinClose()" onmouseover="traceRecordWinOver($(this))" onmouseout="traceRecordWinOut($(this))">关闭</span></div>
		<div id="traceRecordContainer"></div>
	</div>
	<div  class="panel_sub_main" style="height: 340px;">
    <div class="title_sub_main"><span class="span_item">学习记录</span></div>
		<div class="content1" id="">
			<div class="list_div">
			<div class="list_title">
				<div class="od">序号</div>
				<div class="dt">员工姓名</div>
				<div class="dt">员工专业</div>
				<div class="dt">单位</div>
				<div class="ne">学习内容</div>
				<div class="dt">学习记录</div>
				<div class="dt">学习时长</div>
				
			</div>
			<div class="list_content" id="traceContent">
				<ul class="list_ul">
				<s:iterator value="tracePo.traces" id="trace" status="status">
					<li class="item">
						<div class="item_div">
							<div class="od">${status.count}</div>
							<div class="dt">${trace.usrName}</div>
							<div class="dt">${trace.usrMajor}</div>
							<div class="dt">${trace.usrCompany}</div>
							<div class="ne">${trace.studyCourse}</div>
							<div id="${trace.usrId}" class="dt dtcur" onclick="recordDetailFun($(this))">点击查看</div>
							<div class="dt">${trace.studyTime}</div>
						</div>
					</li>
				</s:iterator>
				</ul>
			</div>
		</div>
		<div class="pageDiv pagination" id="tracePagination">
			共
							<s:property value="pageBean.allRow" />
							条 共
							<s:property value="pageBean.totalPage" />
							页 第
							<s:property value="pageBean.currentPage" />
							页
							<s:if test="%{pageBean.currentPage == 1}">上一页</s:if>
							<s:else>
								<a
									href="learning/OnlineCourseTraceManageAction_onlineCourseTraceList.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
							</s:else>
							<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
								<a
									href="learning/OnlineCourseTraceManageAction_onlineCourseTraceList.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
							</s:if>
							<s:else>下一页 </s:else>
							跳转到第
							<select name="" id="page">
							</select>
							页
		</div>
		<div class="filling"></div>
	</div>
	</div>
	  <!-- 图表与统计 -->
	  <div id="statistics" class="panel_sub_main">
	    <div class="title_sub_main"><span class="span_item">统计图表</span></div>
	    <div class="panel_sub graph">
	      <div class="title_sub"><span class="span_item">各月份学习总时/均时变化</span></div>
	      <div class="content_margin" id="monthCountContainer"></div>
	    </div>
	    <div class="filling"></div>
	  </div>
	</div>
	</div>
</body>
</html>
