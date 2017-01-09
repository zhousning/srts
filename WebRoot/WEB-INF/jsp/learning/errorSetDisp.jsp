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
    <script type="text/javascript" src="resource/js/learning/ErrorSetDisp.js"></script>
  </head>
  
<body>
<div class="mainDiv">
	<div class="panel_main">
		<div class="title_main"><span class="span_item">正在进行：错题演练</span></div>
	</div>
	<table>
		<tr class="qus">
			<td class="qu1 h">题号</td>
			<td class="qu2 h">题目类型</td>
			<td class="qu3 h">题目内容</td>
			<td class="qu4 h">答案</td>
			<td class="qu5 h">是否提交</td>
		</tr>
		<s:iterator value="errorSetQuestionPo" id="questionPo" status="st">
		<tr id="${questionPo.errorSetQuestionId}" type-info="${questionPo.errorSetQuestionType}">
			<td class="qu1">${st.count}</td>
			<td class="qu2">${questionPo.errorSetQuestionType}</td>
			<td class="qu3">${questionPo.errorSetQuestionContent}</td>
			<td class="qu4">
				<s:if test="%{#questionPo.errorSetQuestionType=='单选题'}">
   					A.<input type="radio" id="A" name="SINGLE" value="A"/>||
   					B.<input type="radio" id="B" name="SINGLE" value="B"/>||
   					C.<input type="radio" id="C" name="SINGLE" value="C"/>
   				</s:if>
   				<s:elseif test="%{#questionPo.errorSetQuestionType=='多选题'}">
   					A.<input type="radio" id="AM" name="A" value="A,"/>||
   					B.<input type="radio" id="BM" name="B" value="B,"/>||
   					C.<input type="radio" id="CM" name="C" value="C,"/>||
   					D.<input type="radio" id="DM" name="D" value="D"/>
   				</s:elseif>
   				<s:elseif test="%{#questionPo.errorSetQuestionType=='判断题'}">
					T.<input type="radio" id="T" name="judge" value="正确"/>||
					F.<input type="radio" id="F" name="judge" value="错误"/>
				</s:elseif>
				<s:elseif test="%{#questionPo.errorSetQuestionType=='改错题'}">
					<input type="text" id="CorrectError" name="CorrectError" value=""/>
				</s:elseif>
				<s:elseif test="%{#questionPo.errorSetQuestionType=='名词解释'}">
					<input type="text" id="Explaination" name="Explaination" value=""/>
				</s:elseif>
                <s:elseif test="%{#questionPo.errorSetQuestionType=='简答题'}">
                    <input type="text" id="ShortAnswer" name="ShortAnswer" value=""/>
                </s:elseif>
			</td>
			<td class="qu5">
			<s:if test="%{#questionPo.errorSetQuestionType!='无记录'}">
   				<input type="button" id="submit" name="submit" value="提交" onclick="submit($(this))"/>
				<input type="button" id="cancel" name="cancel" value="取消" onclick="cancel($(this))"/>
			</s:if>
			</td>
		</tr>
		</s:iterator>
	</table>
 	<div class="pageDiv pagination" id="pageChangeDisp">
  		<div id="btn_prev"><input type="button" value="上一条" onclick="backToLastPage()"/></div> 
			<ul class="page_ul">
				<s:iterator value="allPageList" id="pageList"><li class="active" value="${pageList}"><a onclick="turnToPageN($(this))">${pageList}</a></li></s:iterator>
			</ul>
			<div id="btn_next"><input type="button" value="下一条" onclick="goToNextPage()"/></div>
			<div id="pageInfo" recordAmount="${resNum}" curPage="${curPage}" pageNum="${pageAmount}" info-model="${modelType}" info-type="${type}" info-timeLength="${timeLength}" info-flag="${flag}">当前第${curPage}页,共${pageAmount}页</div>
  	</div>
</div>
</body>
</html>
