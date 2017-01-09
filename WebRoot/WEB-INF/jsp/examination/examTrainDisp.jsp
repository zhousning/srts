<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">-->
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>进行培训考试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/exam.css">
    <link rel="stylesheet" type="text/css" href="resource/css/examination/examTrainDisp.css">

	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/examination/examTestDisp.js"></script>
  </head>
  
  <body>

<div class="mainDiv" >

<!-- 左侧悬浮栏 -->
<div class="panel_main" id="left">
<div class="content_margin" >今天日期 : <span id="exam_date">${testPaper.exam_date }</span></div>
  <div class="content_margin">考试名称 :  ${testPaper.testPaperName }</div>
  <div class="content_margin">考试时间 : <span id="exam_time">${testPaper.exam_time }</span>---<span id="end_time">${testPaper.end_time }</span></div>
 
  <div class="panel_sub">
  <s:iterator value="testPaperMap" id="rid">
    <div>
    <div class="title_sub">
    <s:property value="key"/>&nbsp;每题<s:property value="value[1]"/>分,&nbsp;共<s:property value="value[0]"/>题,&nbsp;合计<s:property value="value[2]"/>分
    </div>
    <div class="content_margin">
        <s:iterator value="value[3]" status="s">
         <a href="exam/ExaminationTrainAction_examTrainDisp#an_${id}" style="text-decoration: NONE;cursor:hand"><div id="${id}" class="check_n"><s:property value="#s.index+1"/></div></a>
        </s:iterator>
      <div class="filling"></div>
    </div>
  </div>
  </s:iterator>
  </div>
  
  
  <div class="filling"></div>
</div>

<!-- 右侧题目 -->
<div class="panel_main" id="right">
  <div class="title_main">培训考试</div>
  <div class="content_margin">
<div id=CountMsg class=HotDate >  剩余时间：
        <span id="t_h">00时</span>
        <span id="t_m">00分</span>
        <span id="t_s">00秒</span>
    </div>
    <div class="content_margin" id="btn_over"><img src="resource/image/examination/btn_over.png" style="cursor:pointer;"  onclick="submitForm()"/></div>
    </div>
  <div class="panel_sub">
  <form method="post">
  <s:hidden name="testPaperId"></s:hidden>
  <s:hidden name="userId"></s:hidden>
  <s:iterator value="testPaperMap" id="column">
    <div class="title_sub"><s:property value="key"/>&nbsp;每题<s:property value="value[1]"/>分,&nbsp;共<s:property value="value[0]"/>题,&nbsp;合计<s:property value="value[2]"/>分
    </div>
    <div class="content_margin">
      <s:iterator value="value[3]" id="ques" status="s">
      <div class="test_ques" style="border:solid 1px #528B8B;" id="${ques.id}">
        <a name="an_${id}"><div class="question_title"><s:property value="#s.index+1"/>.&nbsp;&nbsp;${ques.content}</div></a>
        
         <s:if test="%{#ques.type=='单选题'}">
             <div class="question_cont"  model="S"  >
                    <span class="span_item"><input type="radio" ids="${id}" name="single_ans_${ques.id }" value="A"  onblur="comStatus($(this))"/>A</span>
                    <span class="span_item"><input type="radio" ids="${id}" name="single_ans_${ques.id }" value="B" onblur="comStatus($(this))"/>B</span>
                    <span class="span_item"><input type="radio" ids="${id}" name="single_ans_${ques.id }" value="C" onblur="comStatus($(this))"/>C</span>
            </div>
          </s:if>
          
      <s:if test="%{#ques.type=='多选题'}">
             <div class="question_cont"  model="M"  tabindex="0"  >
 <span class="span_item"> <input type="checkbox" ids="${id}" name="mul_ans_${ques.id }" value="A"   onblur="comStatus($(this))"/>A</span>
 <span class="span_item"> <input type="checkbox" ids="${id}" name="mul_ans_${ques.id }" value="B"   onblur="comStatus($(this))"/>B</span>
  <span class="span_item"> <input type="checkbox" ids="${id}" name="mul_ans_${ques.id }" value="C"    onblur="comStatus($(this))"/>C</span>
    <span class="span_item"> <input type="checkbox" ids="${id}" name="mul_ans_${ques.id }" value="D"  onblur="comStatus($(this))"/>D</span>
                </div>
          </s:if>
          
            <s:if test="%{#ques.type=='判断题'}">
             <div class="question_cont" model="J">
                   <span class="span_item"><input type="radio" ids="${id}" name="jud_ans_${ques.id }" value="正确"     onblur="comStatus($(this))"/>正确</span>
                  <span class="span_item"><input type="radio" ids="${id}" name="jud_ans_${ques.id }" value="错误"  onblur="comStatus($(this))" />错误</span>
                </div>
          </s:if>
          
               <s:if test="%{#ques.type=='填空题'}">
             <div class="question_cont" model="B" >
                    <span class="span_item"><input type="text" ids="${id}"   onblur="comStatus($(this))"/></span>
                </div>
          </s:if>
          
               <s:if test="%{#ques.type=='改错题'}">
             <div class="question_cont" model="C" >
                      <span class="span_item"><input type="text" ids="${id}"   onblur="comStatus($(this))"/></span>
                </div>
          </s:if>
          
               <s:if test="%{#ques.type=='名词解释'}">
             <div class="question_cont" model="E" >
              <div><textarea cols="80" rows="8" ids="${id}"  onblur="comStatus($(this))"></textarea> </div> 
                </div>
          </s:if>
          
               <s:if test="%{#ques.type=='简答题'}">
             <div class="question_cont" model="A">
                   <div><textarea cols="80" rows="8" ids="${id}"  onblur="comStatus($(this))"></textarea> </div> 
                </div>
          </s:if>
          
            <s:if test="%{#ques.type=='问答题'}">
             <div class="question_cont" model="Q">
                   <div><textarea cols="80" rows="8" ids="${id}"  onblur="comStatus($(this))"></textarea> </div> 
                </div>
          </s:if>
          </div>
      </s:iterator>

   </div>
    </s:iterator>
    </form>
  </div>
  </div>
</div>
  </body>
</html>
