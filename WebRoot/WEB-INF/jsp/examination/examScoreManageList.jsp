<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
       <%@include file="/WEB-INF/jsp/commons/commons.jsp" %>
    <title>成绩管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/exam.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/examScoreManageList.css">

	<script type="text/javascript" src="resource/js/examination/examScoreManageList.js"></script>
	<script type="text/javascript">
	$(function(){
		for(var i=1; i<=${totalPage}; i++){
			$("#page").append("<option value="+i+">"+i+"</option>"); 
		}
		$("#page").val(${page}); //设置select的value为${page}的项选中 
		$("#page").change(function(){
			window.location="exam/ExamScore_findPaperByCon.action?page="+$("#page").val();
		});
	});
</script>
</head>
<body>
<div class="mainDiv">
	<div class="title">
		<div>成绩管理</div>
	</div>
	<div class="testQuery">
		<fieldset>
    		<legend class="title">查询条件</legend>
    		<s:form action="ExamScore_findPaperByCon">
   			<div class="condt">
				<div class="condt1">试卷名称：<s:textfield name="paperName"></s:textfield>   </div>
				<div class="condt1">考试名称：<s:textfield name="examName"></s:textfield></div>
				<div class="condt1">考试日期：<s:textfield name="examDate"></s:textfield></div>
		</div>
		<s:submit value="查询"></s:submit>
		</s:form>
		  		</fieldset>
		</div>
		

	<div class="testList">
		<div class="list_title">
			<div class="ie">序号</div>
			<div class="ie1">试卷名称</div>
			<div class="ie">考试名称</div>
			<div class="ie">考试日期</div>
			<div class="ie">操作</div>

		</div>
		<div class="list_cont">
		<s:iterator value="testPapers" status="st">
			<div class="list_item">
				<div class="ie"><s:property value="#st.index+1"/></div>
				<div class="ie1"><s:a action="exam/ExamScore_findScoreByCon?testPaperId=%{id}">${testPaperName}</s:a></div>
				<div class="ie">${testInfo.testName}</div>
				<div class="ie">${exam_date}</div>
				<div class="ie3">导出成绩单</div>
		
			</div>
			</s:iterator>
		</div>
	</div>
	<div class="pageDiv">
	<div>共
		<s:property value="allRow" />
		条 共
		<s:property value="totalPage" />
		页 第
		<s:property value="page" />
		页
		<s:if test="page == 1">上一页</s:if>
		<s:else>
			<a
				href="exam/ExamScore_findPaperByCon.action?page=<s:property value="%{page-1}"/>">上一页</a>
		</s:else>
		<s:if test="page != totalPage">
			<a
				href="exam/ExamScore_findPaperByCon.action?page=<s:property value="%{page+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="page">
		</select>
		页</div>
		</div>
	
</div>

</body>
</html>
