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
    
    <title>My JSP 'examGameHomeDisp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/exam.css">
    <link rel="stylesheet" type="text/css" href="resource/css/examination/examTrainDisp.css" />
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" language="javascript">
        function submitDanxuanti()
        {
         	var compAnswer= $("input[name='danxuanti']:checked").val();
         	window.location.href="exam/ExaminationGameHomeAction_CompetitionRun?compAnswer="+compAnswer;
        }
        function submitDuoxuanti()
        {
        	var r=document.getElementsByName("duoxuanti"); 
        	var compAnswer;
        	var begin=true;
		    for(var i=0;i<r.length;i++){
		         if(r[i].checked){
		         //alert(r[i].value);//+","+r[i].nextSibling.nodeValue
		         if(begin){
		        	 compAnswer=r[i].value+",";
		        	 begin=false;
		         }else{
		        	 compAnswer=compAnswer+r[i].value+",";
		         }
		       }
		    }      
         	window.location.href="exam/ExaminationGameHomeAction_CompetitionRun?compAnswer="+compAnswer;
        }
        function submitPanduanti()
        {
         	var compAnswer= $("input[name='panduanti']:checked").val();
        	window.location.href="exam/ExaminationGameHomeAction_CompetitionRun?compAnswer="+compAnswer;
        }
        function submitQita()
        {
         	var compAnswer= document.getElementById("compAnswer").value;
        	window.location.href="exam/ExaminationGameHomeAction_CompetitionRun?compAnswer="+compAnswer;
        }
        
    </script>
  </head>
  
  <body>
<div class="mainDiv">


  <div class="panel_main">
    <div class="title_main"><span class="span_item">目前是：第${compQuestion.competitionNo}关</span></div>
    <div class="content_margin">
      <div class="panel_sub">
        <div class="title_sub"><span class="span_item">题目</span></div>
        <div class="content_margin">
    		${compQuestion.compQuestionContent}
        </div>
        <!-- 根据题目类型不同，显示不同答题区域 -->
        <s:if test='compQuestion.compQuestionType=="单选题"'>
	        <div id="singular">
	          <div class="title_sub"><span class="span_item">选择答案（只有一个选项正确）</span></div>
	          <div class="content_margin"><input type="radio" name="danxuanti" value="A"/>${compQuestion.a}</div>
	          <div class="content_margin"><input type="radio" name="danxuanti" value="B"/>${compQuestion.b}</div>
	          <div class="content_margin"><input type="radio" name="danxuanti" value="C"/>${compQuestion.c}</div>
	        </div>
        </s:if><s:elseif test='compQuestion.compQuestionType=="多选题"'>
	        <div id="multiple">
	          <div class="title_sub"><span class="span_item">选择答案（有多个正确选项）</span></div>
	          <div class="content_margin"><input type="checkbox" name="duoxuanti" value="A"/>${compQuestion.a}</div>
	          <div class="content_margin"><input type="checkbox" name="duoxuanti" value="B"/>${compQuestion.b}</div>
	          <div class="content_margin"><input type="checkbox" name="duoxuanti" value="C"/>${compQuestion.c}</div>
	          <div class="content_margin"><input type="checkbox" name="duoxuanti" value="D"/>${compQuestion.d}</div>
	        </div>
        </s:elseif><s:elseif test='compQuestion.compQuestionType=="判断题"'>
	        <div id="judge">
	          <div class="title_sub"><span class="span_item">请判断以上说法的正误</span></div>
	          <div class="content_margin"><input type="radio" name="panduanti" value="正确"/>正确</div>
	          <div class="content_margin"><input type="radio" name="panduanti" value="错误"/>错误</div>
	        </div>
        </s:elseif><s:elseif test='compQuestion.compQuestionType=="填空题"'>
	        <div id="fillblank">
	          <div class="title_sub"><span class="span_item">请正确填写空白部分的内容</span></div>
	          <div class="content_margin"><input type="text" id="compAnswer" /></div>
	        </div>
        </s:elseif><s:else>
	        <div id="describe">
	          <div class="title_sub"><span class="span_item">填写答案</span></div>
	          <div class="content_margin"><input type="text" id="compAnswer" /></div>
	        </div>
        </s:else>
        <!-- 选择答题区域结束 -->
      </div>
    </div>
  </div>

		<s:if test='compQuestion.compQuestionType=="单选题"'>
	        <div class="panel_margin">
    			<div id="btn_prev" onclick="submitDanxuanti()">
    			<img src="resource/image/examination/btn_next.png" />
    			</div>
  			</div>
        </s:if><s:elseif test='compQuestion.compQuestionType=="多选题"'>
	        <div class="panel_margin">
    			<div id="btn_prev" onclick="submitDuoxuanti()">
    			<img src="resource/image/examination/btn_next.png" />
    			</div>
  			</div>
        </s:elseif><s:elseif test='compQuestion.compQuestionType=="判断题"'>
	        <div class="panel_margin">
    			<div id="btn_prev" onclick="submitPanduanti()">
    			<img src="resource/image/examination/btn_next.png" />
    			</div>
  			</div>
        </s:elseif><s:elseif test='compQuestion.compQuestionType=="填空题"'>
	        <div class="panel_margin">
    			<div id="btn_prev" onclick="submitQita()">
    			<img src="resource/image/examination/btn_next.png" />
    			</div>
  			</div>
        </s:elseif><s:else>
	        <div class="panel_margin">
    			<div id="btn_prev" onclick="submitQita()">
    			<img src="resource/image/examination/btn_next.png" />
    			</div>
  			</div>
        </s:else>


</div>
  </body>
</html>
