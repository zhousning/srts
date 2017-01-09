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
    
    <title>知识库Disp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/estimation/personEstimation.css">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
    <link rel="stylesheet" type="text/css" href="resource/css/estimation/est.css">
    <script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resource/js/estimation/personEstimationDisp.js"></script>

  </head>
  
<body>
<div class="mainDiv">
  
  <div class="panel_margin"><a href="javascript:;" onClick="javascript:history.back(-1);">＜＜返回</a></div>
  
  <div class="panel_sub">
    <div class="title_sub"><span class="span_item">${searchType}</span></div>
    <div class="content_margin">
      <div><span class="span_item title">检索结果</span></div>
      <div id="searchRecord">
     <s:iterator value="findWorkerKlgSearchRecord" id="searchRes" status="st">
    <div id="${searchRes.id}" class="grey1" >
        <div id="info">
            <span class="span_item"><div>记录序号：</div><div>${searchRes.id}</div></span>
            <span class="span_item"><div>类型：</div><div>${type}</div></span>
            <span class="span_item"><div>搜索时间：</div><div>${searchRes.searchdate}</div></span>
            <div class="content_margin">内容信息1：<div>${searchRes.content1}</div></div>
            <div class="content_margin">内容信息2：<div>${searchRes.content2}</div></div>
            <div class="content_margin">内容信息3：<div>${searchRes.content3}</div></div>
        </div>
    </div>
    </s:iterator>
    </div>
    <div class="pageDiv pagination" id="pageChangeDisp">
  		<div id="btn_prev"><input type="button" value="上一条" onclick="backToLastPage()"/></div> 
			<ul class="page_ul">
				<s:iterator value="allPageList0" id="pageList"><li class="active" value="${pageList}"><a onclick="turnToPageN($(this))">${pageList}</a></li></s:iterator>
			</ul>
			<div id="btn_next"><input type="button" value="下一条" onclick="goToNextPage()"/></div>
			<div id="pageInfo" recordAmount="${resNum0}" curPage="${curPage}" pageNum="${pageAmount}">当前第${curPage}页,共${pageAmount}页</div>
  	</div>
  </div>
</div>
</div>
</body>

</html>