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
    
    <title>题库管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<%    
  //设置缓存为空    
  response.setHeader("Pragma","No-cache");    
  response.setHeader("Cache-Control","no-cache");    
  response.setDateHeader("Expires",   0);    
  %> 
  <%    
  if(request.getProtocol().compareTo("HTTP/1.0")==0)    
        response.setHeader("Pragma","no-cache");    
  else   if(request.getProtocol().compareTo("HTTP/1.1")==0)    
        response.setHeader("Cache-Control","no-cache");    
  response.setDateHeader("Expires",0);    
  %>  

	
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/exam.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/questionBankManageDisp.css">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resource/js/examination/questionBankSearchResManageDisp.js"></script>

  </head>
  
  <body>
  
<div class="mainDiv">
  <!-- title -->
  <div class="panel_main">
    <div class="title_main"><span class="span_item">上传历史/修改历史</span></div>
    
    <!-- 深灰色块 -->
    <s:iterator value="questionResSearchByConditions" id="questionRSBC" status="st">
    <div class="grey1" id-info="${questionRSBC.id}" type-info="${questionRSBC.type}" selectOptionNum-info="${questionRSBC.selectOptions}">
        <div id="info">
            <span class="span_item"><div>题型：</div><div>${questionRSBC.type}</div></span>
            <span class="span_item"><div>题目id：</div><div>${questionRSBC.id}</div></span>
            <span class="span_item"><div>上传时间：</div><div>${questionRSBC.uploadTime}</div></span>
            <span class="span_item"><div>修改时间：</div><div>${questionRSBC.lastUpdateTime}</div></span>
            <span class="span_item"><div>选项数目：</div><div>${questionRSBC.selectOptions}</div></span>
        </div>
        <div id="question" class="content_margin">题目<div>${questionRSBC.content}</div></div>
        <div>${questionRSBC.questionPic}<div>题目图片：</div><img id="${questionRSBC.id}" src="${questionRSBC.questionPic}?randomNum=${randomNumber}" alt="图裂了"  width="140" height="161"/></div>
        <div id="answer" class="content_margin">答案<div>${questionRSBC.answer}</div></div>
        <div class="viewdetail content_margin">
            <img id="edit" style="cursor: hand" src="resource/image/examination/btn_edit.png" onclick="showUpdate($(this))"/>
            <img id="delete" style="cursor: hand" src="resource/image/examination/btn_delete.png" onclick="deleteQuestion($(this))"/>
        </div>
        <div id="${questionRSBC.id}" style="display:none">
        <div class="content"><input type="text" id="content" value="${questionRSBC.content}"/></div>
        <div class="answer"><input type="text" id="answer" value="${questionRSBC.answer}"/></div>
        <div class="selectOption"><input type="text" id="selectOption" value="${questionRSBC.selectOptions}"/></div>
        <input type="button" id="submit" name="submit" value="提交" onclick="submit($(this))"/>
		<input type="button" id="cancel" name="cancel" value="取消" onclick="cancel($(this))"/>
		</div>
		<div>
        <form action="exam/QuestionBankManageAction_UpdateQuestionPic" id="pictureForm" method="post" enctype="multipart/form-data">
        <input type="file" id="uploadPic" name="questionPicture"/>
        <input type="hidden" value="${questionRSBC.id}" name="updateQuestionId"/>
        <input id="submitButton" type="submit" value="提交"/>
        </form>      
        </div>
    </div>
    </s:iterator>
</div>
</div>
<div class="pageDiv pagination" id="pageChangeDisp">
  <div id="btn_prev"><input type="button" value="上一条" onclick="backToLastPage()"/></div> 
				<ul class="page_ul">
					<s:iterator value="allPageList1" id="pageList"><li class="active" value="${pageList}"><a onclick="turnToPageN($(this))">${pageList}</a></li></s:iterator>
				</ul>
				<div id="btn_next"><input type="button" value="下一条" onclick="goToNextPage()"/></div>
				<div id="pageInfo" recordAmount="${resNum1}" curPage="${curPage1}" pageNum="${pageAmount1}">当前第${curPage1}页,共${pageAmount1}页</div>
  </div>
  </body>
</html>
