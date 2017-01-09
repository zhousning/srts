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
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klg.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klgBankDisp.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resource/js/knowledge/KlgBankDisp.js"></script>
    <script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
    <script type="text/javascript" src="resource/script/jquery/jquery.paginate.js"></script>
    <script type="text/javascript">
		$(document).ready(function(){
			if("${searchType}"=="条文导学")
			{$("#rule").show();}
			if("${searchType}"=="典型违章")
			{$("#vio").show();}
			if("${searchType}"=="典型案例")
			{$("#case").show();}
			if("${searchType}"=="操作经验")
			{$("#exp").show();}
			if("${infoType}"=="条文导学"&&"${showPageTip}"=="hide")
			{$("#ruleInfo").show();
			$("#pageChangeDisp").hide();
			$("#rule").hide();
			$("#vio").hide();
			$("#case").hide();
			$("#exp").hide();}
			if("${infoType}"=="典型违章"&&"${showPageTip}"=="hide")
			{$("#vioInfo").show();
			$("#pageChangeDisp").hide();
			$("#rule").hide();
			$("#vio").hide();
			$("#case").hide();
			$("#exp").hide();}
			if("${infoType}"=="典型案例"&&"${showPageTip}"=="hide")
			{$("#caseInfo").show();
			$("#pageChangeDisp").hide();
			$("#rule").hide();
			$("#vio").hide();
			$("#case").hide();
			$("#exp").hide();}
		});
	</script>

  </head>
  
<body>
<div class="mainDiv">
  
  <div class="panel_margin"><a href="javascript:;" onClick="javascript:history.back(-1);">＜＜返回</a></div>
  
  <div class="panel_sub">
    <div class="title_sub"><span class="span_item">${searchType}</span></div>
    <div class="content_margin">
      <div><span class="span_item title">检索结果</span></div>
      <div id="rule" style="display:none" amount-info="${resNum}">
     <s:iterator value="ruleSearchResList" id="ruleSearchRes" status="st">
    <div id="${ruleSearchRes.serialnumber}" class="grey1" id-info="${ruleSearchRes.id}">
        <div id="info">
            <span class="span_item"><div>类型：</div><div>${searchType}</div></span>
            <span class="span_item"><div>条文导学id：</div><div>${ruleSearchRes.id}</div></span>
            <span class="span_item"><div>上传时间：</div><div>${ruleSearchRes.uploaddate}</div></span>
            <span class="span_item"><div>修改时间：</div><div>${ruleSearchRes.updatedate}</div></span>
            <span class="span_item"><div>书目名称：</div><div>${ruleSearchRes.bookname}</div></span>
            <span class="span_item"><div>章节名称：</div><div>${ruleSearchRes.chaptername}</div></span>
            <span class="span_item"><div>简要内容：</div><div>${ruleSearchRes.contentSe}</div></span>
            <div class="content_margin viewdetail"><a href="javascript:void(0)" onclick="showAllContent($(this))">点击此处查看详细</a></div>
        </div>
        <div id=allContent style="display:none">
        <div class="content_margin">编号：<div>${ruleSearchRes.roleno}</div></div>
        <div class="content_margin">内容：<div>${ruleSearchRes.content}</div></div>
        <div>安规图片：</div><img id="${ruleSearchRes.id}" src="${ruleSearchRes.pic}" alt="图裂了"  width="140" height="161"/>
        <div class="content_margin">检索数目：<div>${ruleSearchRes.searchnum}</div></div>
        </div>
    </div>
    </s:iterator>
    </div>
    <div id="exp" style="display:none" amount-info="${resNum}">
    <s:iterator value="expSearchResList" id="expSearchRes" status="st">
    <div id="${expSearchRes.serialnumber}" class="grey1" id-info="${expSearchRes.id}">
        <div id="info">
            <span class="span_item"><div>类型：</div><div>${searchType}</div></span>
            <span class="span_item"><div>操作经验id：</div><div>${expSearchRes.id}</div></span>
            <span class="span_item"><div>上传时间：</div><div>${expSearchRes.uploaddate}</div></span>
            <span class="span_item"><div>修改时间：</div><div>${expSearchRes.updatedate}</div></span>
            <span class="span_item"><div>审核通过时间：</div><div>${expSearchRes.checkeddate}</div></span>
            <span class="span_item"><div>简要内容：</div><div>${expSearchRes.contentSe}</div></span>
            <div class="content_margin viewdetail"><a href="javascript:void(0)" onclick="showAllContent($(this))">点击此处查看详细</a></div>
        </div>
        <div id=allContent style="display:none">
        <div class="content_margin">内容：<div>${expSearchRes.content}</div></div>
        <div class="content_margin">检索数目：<div>${expSearchRes.searchnum}</div></div>
        <div class="content_margin">上传人：<div>${expSearchRes.user}</div></div>
        </div>
    </div>
    </s:iterator>
    </div>
    <div id="case" style="display:none" amount-info="${resNum}">
    <s:iterator value="caseSearchResList" id="caseSearchRes" status="st">
    <div id="${caseSearchRes.serialnumber} class="grey1" id-info="${caseSearchRes.id}">
        <div id="info">
            <span class="span_item"><div>类型：</div><div>${searchType}</div></span>
            <span class="span_item"><div>典型案例id：</div><div>${caseSearchRes.id}</div></span>
            <span class="span_item"><div>上传时间：</div><div>${caseSearchRes.uploaddate}</div></span>
            <span class="span_item"><div>修改时间：</div><div>${caseSearchRes.updatedate}</div></span>
            <span class="span_item"><div>标题：</div><div>${caseSearchRes.title}</div></span>
            <div class="content_margin viewdetail"><a href="javascript:void(0)" onclick="showAllContent($(this))">点击此处查看详细</a></div>
        </div>
        <div id=allContent style="display:none">
        <div class="content_margin">案例类型：<div>${caseSearchRes.type}</div></div>
        <div class="content_margin">内容：<div>${caseSearchRes.content}</div></div>
        <div>案例图片：</div><img id="${caseSearchRes.id}" src="${caseSearchRes.pic}" alt="图裂了"  width="140" height="161"/>
        <div class="content_margin">检索数目：<div>${caseSearchRes.searchnum}</div></div>
        </div>
    </div>
    </s:iterator>
    </div>
    <div id="vio" style="display:none" amount-info="${resNum}">
    <s:iterator value="vioSearchResList" id="vioSearchRes" status="st">
    <div id="${vioSearchRes.serialnumber}" class="grey1" id-info="${vioSearchRes.id}">
        <div id="info">
            <span class="span_item"><div>类型：</div><div>${searchType}</div></span>
            <span class="span_item"><div>典型违章id：</div><div>${vioSearchRes.id}</div></span>
            <span class="span_item"><div>上传时间：</div><div>${vioSearchRes.uploaddate}</div></span>
            <span class="span_item"><div>修改时间：</div><div>${vioSearchRes.updatedate}</div></span>
            <span class="span_item"><div>标题：</div><div>${vioSearchRes.title}</div></span>
            <div class="content_margin viewdetail"><a href="javascript:void(0)" onclick="showAllContent($(this))">点击此处查看详细</a></div>
        </div>
        <div id=allContent style="display:none">
        <div class="content_margin">违章类型：<div>${vioSearchRes.type}</div></div>
        <div class="content_margin">内容：<div>${vioSearchRes.content}</div></div>
        <div class="content_margin">检索数目：<div>${vioSearchRes.searchnum}</div></div>
        </div>
    </div>
    </s:iterator>
    </div>
    </div>
    <div id="ruleInfo" style="display:none">
     <s:iterator value="ruleLearningInfo" id="ruleRes" status="st">
    <div class="grey1" id-info="${ruleRes.id}">
        <div id="info">
            <span class="span_item"><div>类型：</div><div>条文导学</div></span>
            <span class="span_item"><div>条文导学id：</div><div>${ruleRes.id}</div></span>
            <span class="span_item"><div>上传时间：</div><div>${ruleRes.uploaddate}</div></span>
            <span class="span_item"><div>修改时间：</div><div>${ruleRes.updatedate}</div></span>
            <span class="span_item"><div>书目名称：</div><div>${ruleRes.bookname}</div></span>
            <span class="span_item"><div>章节名称：</div><div>${ruleRes.chaptername}</div></span>
            <span class="span_item"><div>简要内容：</div><div>${ruleRes.contentSe}</div></span>
            <div class="content_margin viewdetail"><a href="javascript:void(0)" onclick="showAllContent($(this))">点击此处查看详细</a></div>
        </div>
        <div id=allContent style="display:none">
        <div class="content_margin">编号：<div>${ruleRes.roleno}</div></div>
        <div class="content_margin">内容：<div>${ruleRes.content}</div></div>
        <div>安规图片：</div><img id="${ruleRes.id}" src="${ruleRes.pic}" alt="图裂了"  width="140" height="161"/>
        <div class="content_margin">检索数目：<div>${ruleRes.searchnum}</div></div>
        </div>
    </div>
    </s:iterator>
    </div>
    <div id="caseInfo" style="display:none">
    <s:iterator value="typicalCaseInfo" id="caseRes" status="st">
    <div class="grey1" id-info="${caseRes.id}">
        <div id="info">
            <span class="span_item"><div>类型：</div><div>${caseRes.type}</div></span>
            <span class="span_item"><div>典型案例id：</div><div>${caseRes.id}</div></span>
            <span class="span_item"><div>上传时间：</div><div>${caseRes.uploaddate}</div></span>
            <span class="span_item"><div>修改时间：</div><div>${caseRes.updatedate}</div></span>
            <span class="span_item"><div>标题：</div><div>${caseRes.title}</div></span>
            <div class="content_margin viewdetail"><a href="javascript:void(0)" onclick="showAllContent($(this))">点击此处查看详细</a></div>
        </div>
        <div id=allContent style="display:none">
        <div class="content_margin">案例类型：<div>${caseRes.type}</div></div>
        <div class="content_margin">内容：<div>${caseRes.content}</div></div>
        <div>案例图片：</div><img id="${caseRes.id}" src="${caseRes.pic}" alt="图裂了"  width="140" height="161"/>
        <div class="content_margin">检索数目：<div>${caseRes.searchnum}</div></div>
        </div>
    </div>
    </s:iterator>
    </div>
    <div id="vioInfo" style="display:none">
    <s:iterator value="typicalViolationInfo" id="vioRes" status="st">
    <div class="grey1" id-info="${vioRes.id}">
        <div id="info">
            <span class="span_item"><div>类型：</div><div>${vioRes.type}</div></span>
            <span class="span_item"><div>典型违章id：</div><div>${vioRes.id}</div></span>
            <span class="span_item"><div>上传时间：</div><div>${vioRes.uploaddate}</div></span>
            <span class="span_item"><div>修改时间：</div><div>${vioRes.updatedate}</div></span>
            <span class="span_item"><div>标题：</div><div>${vioRes.title}</div></span>
            <div class="content_margin viewdetail"><a href="javascript:void(0)" onclick="showAllContent($(this))">点击此处查看详细</a></div>
        </div>
        <div id=allContent style="display:none">
        <div class="content_margin">违章类型：<div>${vioRes.type}</div></div>
        <div class="content_margin">内容：<div>${vioRes.content}</div></div>
        <div class="content_margin">检索数目：<div>${vioRes.searchnum}</div></div>
        </div>
    </div>
    </s:iterator>
    </div>
    </div>
  </div>

<!-- 翻页 -->
  <div class="pageDiv pagination" id="pageChangeDisp">
  <div id="btn_prev"><input type="button" value="上一条" onclick="backToLastPage()"/></div> 
				<ul class="page_ul">
					<s:iterator value="allPageList" id="pageList"><li class="active" value="${pageList}"><a onclick="turnToPageN($(this))">${pageList}</a></li></s:iterator>
				</ul>
				<div id="btn_next"><input type="button" value="下一条" onclick="goToNextPage()"/></div>
				<div id="pageInfo" recordAmount="${resNum}" curPage="${curPage}" pageNum="${pageAmount}" searchType="${searchType}" searchKeyWords="${searchKeyWords}">当前第${curPage}页,共${pageAmount}页</div>
  </div>
</body>

</html>