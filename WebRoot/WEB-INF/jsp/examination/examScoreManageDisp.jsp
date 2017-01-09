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

	<style>
.condt {
	margin-top: 10px;
	margin-bottom: 10px;
	width:900px;
}

.condt1 {
	width: 220px;
	float: left;
}

.btn {
	border: 1px solid #DDD;
	width: 50px;
	text-align: center;
	cursor: pointer;
	margin-left:5px;
}
select {
	width: 150px;
}

	</style>
	<script type="text/javascript">
	$(function(){
		for(var i=1; i<=${totalPage}; i++){
			$("#page").append("<option value="+i+">"+i+"</option>"); 
		}
		$("#page").val(${page}); //设置select的value为${page}的项选中 
		$("#page").change(function(){
			window.location="exam/ExamScore_findScoreByCon.action?testPaperId=${testPaperId}&page="+$("#page").val();
		});
	});
</script>
</head>
<body>
<div class="mainDiv">
	<div class="title">
		<s:a action="exam/ExamScore_findPaperByCon">返回</s:a>
	</div>
	<div class="testQuery">
		<fieldset>
    		<legend class="title">查询条件</legend>
   			<div class="condt">
   			<s:form action="ExamScore_findScoreByCon">
   			<s:hidden name="testPaperId"></s:hidden>
				<div class="condt1">考试日期：<s:textfield name="examDate"></s:textfield>  </div>
				<div class="condt1">用户姓名：<s:textfield name="userName"></s:textfield>  </div>
				<div class="condt1">部门名称：<s:textfield name="depName"></s:textfield>  </div>
				<div class="condt1" style="width:300px;">考试成绩：<s:select name="sysmbol" list="#{'>':'>','=':'=','<':'<'}" cssStyle="width:40px;"></s:select> <s:textfield  name="grade"></s:textfield>  </div>
				<s:submit value="查询"></s:submit>
				</s:form>
			</div>
  		</fieldset>
	</div>
	<div class="testList">
		<div class="list_title">
			<div class="ie">序号</div>
			<div class="ie">员工姓名</div>
			<div class="ie">员工专业</div>
			<div class="ie">员工单位</div>
			<div class="ie">考试科目</div>
			<div class="ie">考试时间</div>
			<div class="ie">考试成绩</div>
		</div>
		<div class="list_cont">
<s:iterator value="testScores" status="st">
			<div class="list_item">
				<div class="ie"><s:property value="#st.index+1"/></div>
				<div class="ie">${usr.name}</div>
				<div class="ie">${usr.job}</div>
				<div class="ie">${usr.department.name}</div>
				<div class="ie">${testPaper.testPaperName}</div>
				<div class="ie">${testPaper.exam_date}</div>
				<div class="ie">${grade}</div>
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
				href="exam/ExamScore_findScoreByCon.action?testPaperId=${testPaperId}&page=<s:property value="%{page-1}"/>">上一页</a>
		</s:else>
		<s:if test="page != totalPage">
			<a
				href="exam/ExamScore_findScoreByCon.action?testPaperId=${testPaperId}&page=<s:property value="%{page+1}"/>">下一页</a>
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
