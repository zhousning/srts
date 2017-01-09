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
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/exam.css">
    <link rel="stylesheet" type="text/css" href="resource/css/examination/questionBankManageList.css" />
<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
<script type="text/javascript" src="resource/js/examination/questionBankManageList.js"></script>

	<script type="text/javascript">
		$(document).ready(function(){
			initChart();
		});
	</script>
  </head>
  <body>
    <div class="mainDiv">
      
      
      <!-- 标签页：增加试题和查询修改 -->
      <div id="insert_and_change" class="panel_main">
        <div class="title_main"><span class="span_item">增加、查询/修改试题</span></div>
        <div class="content_margin">
        <div>
        <form action="exam/QuestionBankManageAction_UploadQuestionBank" id="questionBankForm" method="post" enctype="multipart/form-data">
        <input type="file" id="uploadQuestionBank" name="uploadQuestionBank"/>
        <input id="submitQuetsionBankButton" type="submit" value="提交"/>
        </form>      
        </div>   
        <div id="tab_search">
          <div>
            <img id="query" style="cursor: hand" src="resource/image/examination/btn_query.png" onclick="questionSearchResByKeyWordsTypeDisp()" />
            <!--<img src="resource/image/examination/btn_upload.png" style="cursor: hand" />  -->
          </div>
          <div>
            关键字：<input type="text" id="keyWords" />
          </div>
          <div>
            题型：<input type="radio" name="question_type" value="单选题"/>单选题
            <input type="radio" name="question_type" value="多选题"/>多选题
            <input type="radio" name="question_type" value="判断题"/>判断题
            <input type="radio" name="question_type" value="填空题"/>填空题
            <input type="radio" name="question_type" value="简答题"/>简答题
          </div>
        </div>
        </div>
             <!--查询结果-->
        <div id="queryResult" class="panel_sub">
        <div class="title_sub"><span class="span_item">查询结果</span></div>
        <div class="resList">
        
        </div>
        </div>
      </div>
      
      
      <!-- 增加试题历史记录，仅列出数据，点进条目可修改和删除 -->
      <div id="history_insert" class="panel_main">
        <div class="title_main"><span class="span_item">增加试题历史记录</span></div>
        <div class="content_margin">
        <div>
        <s:iterator value="questionBankUploadLog" id="uploadLog" status="st">
        <div>
        <span class="span_item">${uploadLog.uploadDate}</span>
        <span class="span_item">${uploadLog.seContent}</span>
        <span class="span_item">${uploadLog.questionType}</span>
        </div> 
        </s:iterator>
        </div>
        <!-- 点进去修改和删除 -->
        <div class="viewdetail"><a href="exam/QuestionBankManageAction_questionBankManageDisp?model=shangchuanshijian">点击查看详细内容</a></div>
        </div>
      </div>
      
       
      <!-- 修改试题历史记录，仅列出数据，点进条目可修改和删除 -->
      <div id="history_change" class="panel_main">
        <div class="title_main"><span class="span_item">修改试题历史记录</span></div>
        <div class="content_margin">
        <div>
        <s:iterator value="questionBankUpdateLog" id="updateLog" status="st">
        <div>
        <span class="span_item">${updateLog.updateDate}</span>
        <span class="span_item">${updateLog.seContent}</span>
        <span class="span_item">${updateLog.questionType}</span>
        </div>        
        </s:iterator>
        </div>
        <!-- 点进去修改和删除 -->
        <div class="viewdetail"><a href="exam/QuestionBankManageAction_questionBankManageDisp?model=xiugaishijian">点击查看详细内容</a></div>
        </div>
      </div>
      
      
      <!-- 图表 -->
      <div id="graph" class="panel_main_graph">
        <div class="title_main"><span class="span_item">统计信息</span></div>
        <div class="graph panel_sub_graph">
          <div class="title_sub"><span class="span_item">图表1</span></div>
          <div class="content_margin_graph">
            <div id="perKind"></div>
          </div>
        </div>
        <div class="graph panel_sub_graph">
          <div class="title_sub"><span class="span_item">图表2</span></div>
          <div class="content_margin_graph">
            <div id="perMonth"></div>
          </div>
        </div>
        <div class="graph panel_sub_graph">
          <div class="title_sub">统计数字</div>
          <div class="content_margin_graph">
          <s:iterator value="questionNumByType" status="t">
          <div><s:property value="questionNumByType[#t.index][0]"/>:<s:property value="questionNumByType[#t.index][1]"/></div> 
          </s:iterator>
          </div>
        </div>
        <div class="filling">&nbsp;</div>
      </div>
      
      
    </div>
  </body>
</html>
