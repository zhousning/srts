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
    
    <title>我的问题</title>
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/common/paginate.css" media="screen">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/selfProblemCommList.css">
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/communication/selfProblemCommList.js"></script>
	<script type="text/javascript" src="resource/script/jquery/jquery.paginate.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#demo5").paginate({
				count 		: ${selfProblemInfo.allPageNum},
				start 		: ${curPageNum},
				display     : 5,
				border					: false,
				border_color			: '#BBB8B8',
				text_color  			: '#888',
				background_color    	: '#EEE',	
				border_hover_color		: '#68BA64',
				text_hover_color  		: 'black',
				background_hover_color	: '#CFCFCF', 
				images					: false,
				mouse					: 'press',
				onChange     			: function(page){
											$('._current','#paginationdemo').removeClass('_current').hide();
											window.location.href='commu/ProblemCommuAction_selfProblemCommList?curPageNum='+ encodeURI(encodeURI(page));
										
										  }
			});
		});
		</script>
</head>
<body>
<div class="mainDiv">
<!-- 我的提问 -->  
	<div>
		<img src="resource/image/communication/title_ask.png" id="title_ask" onclick="AskAnswerChange($(this))"/> 
    	<img src="resource/image/communication/title_answer.png" id="title_answer" onclick="AskAnswerChange($(this))"/>
	</div>
	
<div id="my_ask" class="panel">
<s:iterator value="selfProblemInfo.selfProblemInfos" status="stuts"> 
	<!--  判断记号是否为奇数  -->
    <s:if test="#stuts.odd == true">
		<div class="item1">
    	<div class="item1_show">
        	<div id="title" class="content"><a href="commu/ProblemCommuAction_selfProblemCommDisp?problemId=${id}">${problemDesc}</a></div>
        	<div class="info">
            	<div id="ans_time" class="time" >${date}</div><div id="ans_num" class="highlight">${answerCount}</div><div class="text">回答</div>
            	<div id="operation" class="bubble_btn">处理</div><div id="ans_num_new" class="bubble">3</div>
        	</div>
    	</div>
    </div>
    </s:if>
    <s:else><!--  判断记号是否为偶数 -->
		<div class="item2">
    	<div class="item2_show">
        	<div id="title" class="content"><a href="commu/ProblemCommuAction_selfProblemCommDisp?problemId=${id}">${problemDesc}</a></div>
        	<div class="info">
        		<div id="ans_time" class="time">${date}</div><div id="ans_num" class="highlight">${answerCount}</div><div class="text">回答</div>
            	<div id="operation" class="bubble_btn">处理</div><div id="ans_num_new" class="bubble">3</div>
        	</div>
    	</div>
    </div>
    </s:else>
	
</s:iterator>
    <div class="problemList_page">
		<div id="demo5"></div>
	</div> 
</div>


<!-- 我的回答 -->   
<div id="my_answer" class="panel" style="display:none;">
	<s:iterator value="">
	<div class="item1">
		<div class="item1_show">
        	<div id="title" class="content">1. 问题：问题标题问题标题问题标题？</div>
        	<div class="info">
            	<div id="user" class="text">用户1024</div><div id="ans_time" class="time">2014-05-09 22:00:00</div>
            	<div id="ans_num" class="highlight">5</div><div class="text">回答</div>
        	</div>
    	</div>
    	<div class="content">
    		<div>我的回答：回答内容回答内容回答内容回答内容回答内容回答内容回答内容。</div>
    		<div id="ans_time" class="time">2014-05-09 22:00:00</div>
    	</div>
    	<div id="ans_block" class="scroll_block">
        	<div id="title" class="content">追问：追问内容追问内容追问内容追问内容追问内容追问内容追问内容追问内容追问内容？</div>
        	<div class="info">
            	<div id="user" class="text">用户1024</div>
            	<div id="ans_time" class="time">2014-05-09 22:00:00</div>
				<div id="operation" class="bubble_btn"  onclick="handleAnswer($(this))">处理</div>
    			<div id="ans_num_new" class="bubble">3</div>
        	</div> 
    	</div>
    	<div id="input" class="input_block">
        	<div class="input_area">
				<textarea style="width: 576px; height: 87px;overflow-y:auto;"></textarea>
			</div>
        	<div class="input_submit"><img src="resource/image/communication/btn_submit.png" /></div>
    	</div> 
    </div>    	
    <div class="item2">
    	<div class="item2_show">
        	<div id="title" class="content">1. 问题：问题标题问题标题问题标题？</div>
        	<div class="info">
            	<div id="user" class="text">用户1024</div><div id="ans_time" class="time">2014-05-09 22:00:00</div>
            	<div id="ans_num" class="highlight">5</div><div class="text">回答</div>
        	</div>
    	</div> 
    	<div class="content">
    		<div>我的回答：回答内容回答内容回答内容回答内容回答内容回答内容回答内容。</div>
    		<div id="ans_time" class="time">2014-05-09 22:00:00</div>
    	</div>
    	<div id="ans_block" class="scroll_block">
        	<div id="title" class="content">追问：追问内容追问内容追问内容追问内容追问内容追问内容追问内容追问内容追问内容？</div>
        	<div class="info">
            	<div id="user" class="text">用户1024</div>
            	<div id="ans_time" class="time">2014-05-09 22:00:00</div>
           		<div id="operation" class="bubble_btn"  onclick="handleAnswer($(this))">处理</div>
    			<div id="ans_num_new" class="bubble">3</div>
        	</div>
    	</div>
    	<div id="input" class="input_block">
        	<div class="input_area">
				<textarea style="width: 576px; height: 87px;overflow-y:auto;"></textarea>
			</div>
        	<div class="input_submit"><img src="resource/image/communication/btn_submit.png" /></div>
    	</div>  
    </div>
    
    </s:iterator>
    <div class="problemList_page">
			<ul class="problemList_page_ul">
			<li class="page">«</li>
			<li class="page">1</li>
			<li class="page">2</li>
			<li class="page">3</li>
			<li class="page">4</li>
			<li class="page">5</li>
			<li class="page">6</li>
			<li class="page">»</li>
			<li class="total">共6页</li>
		</ul>
		</div>
</div>
    
    	
</div>
</body>
</html>
