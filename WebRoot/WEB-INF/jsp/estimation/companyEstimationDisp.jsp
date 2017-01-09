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
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/learning/train.css" rel="stylesheet" type="text/css" />
	<link href="resource/css/learning/onlineExerciseDisp.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="resource/css/learning/errorSetDisp.css">
    <script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resource/js/estimation/companyEstimationDisp.js"></script>
  </head>
  
<body>
<div class="mainDiv">
	<div class="panel_main">
		<div class="title_main"><span class="span_item">正在进行：学习考试情况查看</span></div>
	</div>
	<div id="wholeEst" class="panel_sub">
						<div class="title_sub">
							<span class="span_item">学习状况评价</span>
						</div>
						<div class="content_margin" id="wholeEstContainer"></div>
							<div class="title_sub">
								${setEstimateInfo.type}
							</div>
							<div class="content_margin">
								<table class="table">
									<tr>
										<td>
											${setEstimateInfo.estString}
										</td>
									</tr>
								</table>
							</div>
	</div>
	<table>
		<tr class="qus">
			<td class="qu1 h">序号</td>
			<td class="qu2 h">部门</td>
			<td class="qu3 h">工号</td>
			<td class="qu4 h">员工姓名</td>
			<td class="qu5 h">考试名称</td>
			<td class="qu5 h">考试日期</td>
			<td class="qu5 h">考试成绩</td>
		</tr>
		<s:iterator value="findAllTestInfoByAllConditions" id="allTestInfo" status="st">
		<tr id="${allTestInfo.id}">
			<td class="qu1">${allTestInfo.id}</td>
			<td class="qu2">${allTestInfo.dept}</td>
			<td class="qu3">${allTestInfo.workno}</td>
			<td class="qu4">${allTestInfo.workerName}</td>
			<td class="qu5">${allTestInfo.testName}</td>
			<td class="qu5">${allTestInfo.testDate}</td>
			<td class="qu5">${allTestInfo.score}</td>
		</tr>
		</s:iterator>
	</table>
</div>
</body>
</html>
