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
    
    <title>我的问题处理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/selfProblemCommDispEnd.css">
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/communication/selfProblemCommDispEnd.js"></script>
</head>
<body>
<input type="hidden" id="problemId" value="${myOneProblem.problemInfo.id}" >
<div class="mainDiv">
 <div class="itemDropDown">
    	<!--问题-->
        <div class="itemDropDowm_problem"  >
    		<div class="itemDropDowm_problem_title">${myOneProblem.problemInfo.problemDesc}</div>
    		<div class="itemDropDowm_problem_info"><span>标签</span><span>${myOneProblem.problemInfo.labels}</span></div>
    		<div class="itemDropDowm_problem_other"><span>问题补充:</span>${myOneProblem.problemInfo.problemDescAdd}</div>
    	</div>
    	
        <!--回答列表-->
    	<div class="itemDropDowm_answer">
    		<div class="itemDropDowm_answer_item">
    			<div class="itemDropDowm_answer_item_ans">
    				<div class="ans_info">
						<span class="ans_info_up2">${myOneProblem.aaas.answerInfo.date}</span>
						<span class="ans_info_up1">${myOneProblem.aaas.answerInfo.usr.username}</span>
					</div>
                   <div class="endFlag">被采纳答案</div>
    				<div class="ans_content">${myOneProblem.aaas.answerInfo.answerContent}</div>
    				<!--<div class="ans_other">
    					<div class="ans_btn" onClick="continueAsk(${answerInfo.id})">继续追问</div>
    					<div class="ans_btn1" onClick="adoptAnswer(${answerInfo.id})">采纳答案</div>
    				</div>-->
                    <s:iterator value="myOneProblem.aaas.answerAsks">
                        <div class="ans_ask">
                            <div class="ans_ask_content"><span>追问：</span>${askContent}</div>
                            <s:if test="answerContent!=null">
                                <div class="ans_ask_ans"><span>回答：</span>${answerContent}</div>
                            </s:if>
                        </div>
                    </s:iterator>
    			</div>
    		</div>
    	<s:iterator value="myOneProblem.answerInfoAndAnswerAsks">
    		<div class="itemDropDowm_answer_item">
    			<div class="itemDropDowm_answer_item_ans">
    				<div class="ans_info">
						<span class="ans_info_up2">${answerInfo.date}</span>
						<span class="ans_info_up1">${answerInfo.usr.username}</span>
					</div>
                    
    				<div class="ans_content">${answerInfo.answerContent}</div>
    				<!--<div class="ans_other">
    					<div class="ans_btn" onClick="continueAsk(${answerInfo.id})">继续追问</div>
    					<div class="ans_btn1" onClick="adoptAnswer(${answerInfo.id})">采纳答案</div>
    				</div>-->
                    <s:iterator value="answerAsks">
                        <div class="ans_ask">
                            <div class="ans_ask_content"><span>追问：</span>${askContent}</div>
                            <s:if test="answerContent!=null">
                                <div class="ans_ask_ans"><span>回答：</span>${answerContent}</div>
                            </s:if>
                        </div>
                    </s:iterator>
    				<!--<div class="ans_ask_area" id="${answerInfo.id}">
						<div><textarea id="myAsk${answerInfo.id}" style="height:150px;width:730px;overflow-y:auto;"></textarea></div>
						<div class="ans_ask_area_btn" onClick="postAnswer(${answerInfo.id},$(this))">提交</div>
					</div>-->
    			</div>
    		</div>
    	</s:iterator>
  <!-- 		<div class="itemDropDowm_answer_item">
    			<div class="itemDropDowm_answer_item_ans">
    				<div class="ans_info">
						<span class="ans_info_up2">2014-05-19 22:12</span>
						<span class="ans_info_up1">员工姓名</span>
					</div>
    				<div class="ans_content">1．作业人员的基本条件：1)经医师鉴定，无妨碍工作的病症(体格检查每两年至少一次)。 2)具备必要的电气知识和业务技能，且按工作性质，熟悉本部分的相关部分，并经考试合格。 3)具备必要的安全生产知识，学会紧急救护法，特别要学会触电急救。</div>
    				<div class="ans_other">
    					<div class="ans_btn" onclick="continueAsk()">继续追问</div>
    					<div class="ans_btn1" onclick="adoptAnswer()">采纳答案</div>
    				</div>
    				<div class="ans_ask">
    					<div class="ans_ask_content"><span>追问：</span>还有其他条件吗？</div>
    					<div class="ans_ask_ans"><span>回答：</span>就这些</div>
    				</div>
    				<div class="ans_ask_area">
						<form action="" method="post">
							<div><textarea style="height:150px;width:730px;"></textarea></div>
							<div class="ans_ask_area_btn" onclick="postAnswer()">提交</div>
						</form>
					</div>
    			</div>
    		</div> --> 
    	</div>
    </div>
</div>
</body>
</html>
