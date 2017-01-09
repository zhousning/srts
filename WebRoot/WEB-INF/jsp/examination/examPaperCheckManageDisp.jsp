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
    
    <title>考试管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/exam.css">
    <link rel="stylesheet" type="text/css" href="resource/css/examination/examManageList.css">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	
</head>
  
<body>

<div class="mainDiv">
  <!-- 考试列表与管理 -->
  <div id="testManage" class="panel_main">
    <div class="title_main"><span class="span_item">考试及试卷列表</span></div>
    <div id="examList" class="content_margin">
      <table class="table">
        <tr>
          <th><span class="span_item">序号</span></th>
          <th><span class="span_item">考试名称</span></th>
          <th><span class="span_item">考试试卷</span></th>
          <th><span class="span_item">考试时间</span></th>
          <th><span class="span_item">本次所有答卷</span></th>
        </tr>
        <s:iterator value="findAllTestPaper" id="allTestPaper" status="st">
        <tr>
        <td>${allTestPaper.id}</td>
        <td>${allTestPaper.testName}</td>
        <td>${allTestPaper.testPaperName}</td>
        <td>${allTestPaper.testDate}</td>
        <td><a href="exam/ExaminationManageAction_examPaperCheckManageDisp?testPaperId=${allTestPaper.testPaperId}">点击查看所有答卷</a></td>
        </tr>
        </s:iterator>
      </table>
    </div>
  </div>
  <div id="testPaperManage" class="panel_main">
    <div class="title_main"><span class="span_item">答卷列表</span></div>
    <div id="testPaperList" class="content_margin">
      <table class="table">
        <tr>
          <th><span class="span_item">序号</span></th>
          <th><span class="span_item">答卷编号</span></th>
          <th><span class="span_item">考试名称</span></th>
          <th><span class="span_item">考试试卷名称</span></th>
          <th><span class="span_item">答卷人工号</span></th>
          <th><span class="span_item">答卷人姓名</span></th>
          <th><span class="span_item">查看答卷及答案</span></th>
          <th><span class="span_item">进入评卷</span></th>
        </tr>
        <s:iterator value="findAnswerSheetListByTestPaperId" id="allAnswerSheet" status="st">
        <tr>
        <td>${allAnswerSheet.id}</td>
        <td>${allAnswerSheet.answerSheetId}</td>
        <td>${allAnswerSheet.testName}</td>
        <td>${allAnswerSheet.testPaperName}</td>
        <td>${allAnswerSheet.workno}</td>
        <td>${allAnswerSheet.userName}</td>
        <td><a href="exam/ExaminationManageAction_examPaperCheckList?answerSheetId=${allAnswerSheet.answerSheetId}">点击查看答卷和答案</a></td>
        <td><a href="exam/ExaminationManageAction_examPaperCheckDisp?answerSheetId=${allAnswerSheet.answerSheetId}">点击进行评卷</a></td>
        </tr>
        </s:iterator>
      </table>
    </div>
  </div>
  
</div>


</body>
</html>
