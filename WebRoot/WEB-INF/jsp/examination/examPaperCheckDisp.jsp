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
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/examination/examPaperCheckDisp.js"></script>
	
</head>
  
<body>

<div class="mainDiv">
<div class="panel_margin"><a href="javascript:;" onClick="javascript:history.back(-1);">＜＜返回</a></div>
  <!-- 考试列表与管理 -->
  <div id="answerSheetList" class="panel_main">
    <div class="title_main"><span class="span_item">答卷情况(目前客观题得分为${objectiveQuestionMark}分})</span></div>
    <div id="answerSheetDisp" class="content_margin" answerSheetId="${answerSheetId}" obQuestionMark="${objectiveQuestionMark}" subQuestionNum="${subjectiveQuestionNum}">
      <table class="table">
        <tr>
          <th><span class="span_item">序号</span></th>
          <th><span class="span_item">题目类型</span></th>
          <th><span class="span_item">标准答案</span></th>
          <th><span class="span_item">考生答案</span></th>
          <th><span class="span_item">本题分值</span></th>
          <th><span class="span_item">本题得分</span></th>
        </tr>
        <s:iterator value="examPaperCheckSheet" id="examPaperCheck" status="st">
        <tr>
        <td>${examPaperCheck.id}</td>
        <td>${examPaperCheck.questionType}</td>
        <td>${examPaperCheck.answerTrue}</td>
        <td>${examPaperCheck.userAnswer}</td>
        <td id="QS_${examPaperCheck.id}" score="${examPaperCheck.questionScore}">${examPaperCheck.questionScore}</td>
        <td><input type="text" id="ePC_${examPaperCheck.id}" maxlength="2"/></td>
        </tr>
        </s:iterator>
      </table>
    </div>
  </div>
  <div class="content_margin" id="btn_over"><img src="resource/image/examination/btn_over.png" style="cursor:pointer;"  onclick="submit()"/></div>
  
</div>


</body>
</html>
