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
    <title>问题回复</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemCommDisp.css">

	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/communication/ProblemCommDisp.js"></script>
</head>
<body>
<div class="mainDiv">
	<div class="questionAreaContainer">
		<div class="questionAreaMain">
			<div class="questionAreaMain_prob"><img src="resource/image/communication/pro_logo.jpg"/><span>${problemInfo.problemDesc}</span></div>
			<div class="questionAreaMain_other">
				<span class="other_time">${problemInfo.date}</span>
				<span class="other_info">${problemInfo.usr.username}</span><span>|</span>
				<span class="other_info">标签：${problemInfo.labels}</span><span>|</span>
				<span class="other_info">浏览${problemInfo.viewCount }次</span><span>|</span>
			</div>
			<div class="questionAreaMain_prob_other"><span>问题补充:</span>${problemInfo.problemDescAdd}</div>
			<s:if test="problemCommDisp.answerInfo==null">
				<div class="questionAreaMain_answer_btn" id="questionAreaMain_answer_btn" onclick="selfBetterAnswer()">我有更好的答案</div>
			</s:if>
			
			<div class="questionAreaMain_answer_area" id="questionAreaMain_answer_area">
				<div><textarea id="answerarea1" name="bbcode_field" style="height:150px;width:730px;overflow-y:auto;"></textarea></div>
				<div class="questionAreaMain_answer_button" onclick="selfBetterAnswerPost()">提交答案</div>
			</div>
		</div>
		<div class="answerAreaMain" id="answerAreaMain" problemInfoId="${problemInfo.id}" >
			<div class="answerAreaMain_count"><span id="answerCount">${problemInfo.answerCount}</span>条回答</div>
			<div class="answerAreaMain_area">
				<div class="answerAreaMain_area_self" id="myAnswerArea">
				<s:if test="problemCommDisp.answerInfo!=null">
					
					<div class="answerAreaMain_area_self_up" id="answerInfo"  answerInfoId="${problemCommDisp.answerInfo.id}">
						<span class="answerAreaMain_area_up2">${problemCommDisp.answerInfo.date}</span>
						<span class="answerAreaMain_area_up1">我的回答</span>|
						<span class="answerAreaMain_area_up1"></span>
					</div>
					<div class="answerAreaMain_area_self_down">${problemCommDisp.answerInfo.answerContent}</div>
					<div class="answerAreaMain_area_self_btn" onclick="selfBetterAnswerRepair()">完善答案</div>
					<div class="answerAreaMain_area_self_area" id="answerAreaMain_area_self_area">
						<form action="" method="post">
							<div><textarea id="answerarea2" name="bbcode_field1" style="height:150px;width:730px;overflow-y:auto;" > ${problemCommDisp.answerInfo.answerContent}</textarea></div>
							<div class="answerAreaMain_area_self_area_btn" onclick="selfBetterAnswerRepairPost()">提交修改</div>
						</form>
					</div>
					
				</s:if>
				</div>
				<s:iterator value="problemCommDisp.otherAnswerInfos" >
					<div class="answerAreaMain_area_other">
						<div class="answerAreaMain_area_other_up">
							<span class="answerAreaMain_area_up2">${date}</span>
					 		<span class="answerAreaMain_area_up1">${usr.username}</span>| 
							<span class="answerAreaMain_area_up1">最快回答</span>
						</div>
						<div class="answerAreaMain_area_other_down">${answerContent}</div>
					</div>
				</s:iterator>
			</div>
		</div>
	</div>
</div>
</body>
</html>

