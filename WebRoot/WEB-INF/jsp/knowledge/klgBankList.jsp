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
    
    <title>知识库</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klg.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klgBankList.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resource/js/knowledge/KlgBankList.js"></script>
    <script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
    
    <script type="text/javascript">
		$(document).ready(function(){
			initChart();
		});
	</script>

  </head>
  
<body>
<!-- 上方：标签页切换和查询 -->
<div class="mainDiv">

  <!-- 标签页 -->
			<div id="tab">
				<div>
					以下4个标签页切换显示
					<a onClick="c(0)"> 条文导学 </a>
					<a onClick="c(1)"> 典型案例 </a>
					<a onClick="c(2)"> 典型违章 </a>
					<a onClick="c(3)"> 操作经验 </a>
				</div>

				<!-- 条文导学 -->
				<div id="tab0" class="tabC tabC0 panel_sub">
					<div class="title_sub">
						<span class="span_item">条文导学</span>
					</div>
					<div class="content_margin">
						<table class="table">
							<tr>
								<th>
									书名及章节
								</th>
								<th>
									条目
								</th>
								<th>
									内容
								</th>
							</tr>
							<s:iterator value="ruleLearningDisp" id="ruleLearning"
								status="st">
								<tr>
									<td>
										${ruleLearning.bookname}${ruleLearning.chaptername}
									</td>
									<td>
										${ruleLearning.ruleno}
									</td>
									<td>
										${ruleLearning.content}
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
				<!-- 典型案例 -->
				<div id="tab1" class="tabC tabC1 panel_sub">
					<div class="title_sub">
						<span class="span_item">典型案例</span>
					</div>
					<div class="content_margin">
						<table class="table">
							<tr>
								<th>
									案例标题
								</th>
								<th>
									上传日期
								</th>
								<th>
									内容
								</th>
							</tr>
							<s:iterator value="typicalCaseDisp" id="typicalCase" status="st">
								<tr>
									<td>
										${typicalCase.title}
									</td>
									<td>
										${typicalCase.date}
									</td>
									<td>
										${typicalCase.content}
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
				<!-- 典型违章 -->
				<div id="tab2" class="tabC tabC2 panel_sub">
					<div class="title_sub">
						<span class="span_item">典型违章</span>
					</div>
					<div class="content_margin">
						<table class="table">
							<tr>
								<th>
									违章内容序号
								</th>
								<th>
									内容
								</th>
							</tr>
							<s:iterator value="typicalViolationDisp" id="typicalViolation"
								status="st">
								<tr>
									<td>
										${typicalViolation.id}
									</td>
									<td>
										${typicalViolation.content}
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
				<!-- 操作经验 -->
				<div id="tab3" class="tabC tabC3 panel_sub">
					<div class="title_sub">
						<span class="span_item">操作经验</span>
					</div>
					<div class="content_margin">
						<table class="table">
							<tr>
								<th>
									操作经验序号
								</th>
								<th>
									内容
								</th>
							</tr>
							<s:iterator value="experienceDisp" id="experience" status="st">
								<tr>
									<td>
										${experience.id}
									</td>
									<td>
										${experience.content}
									</td>
								</tr>
							</s:iterator>
						</table>
					</div>

				</div>
				</div>

			<div id="right">
    <!-- 搜索功能 -->
    <div id="search" class="panel_sub">
      <div class="title_sub"><span class="span_item">搜索</span></div>
      <div class="content_margin">
        <div>
          类别：<select id="typeSelect">
          <option value="条文导学">条文导学</option>
          <option value="典型案例">典型案例</option>
          <option value="典型违章">典型违章</option>
          <option value="操作经验">操作经验</option>
          </select>
        </div>
        <div>关键词：<input type="text" id="keyWords" name="keyWords" value="请输入关键词"/></div>
        <div><img id="query" style="cursor: hand" src="resource/image/knowledge/btn_search.png" onclick="klgSearchResByKeyWordsType()"/></div>
        
      </div>
    </div>
  
    <!-- 查询直方图 -->
    <div id="graph" class="panel_sub">
      <div class="title_sub"><span class="span_item">图表</span></div>
      <div class="content_margin">按月统计员工检索次数，直方图
      <div id="barContainer">本月题目检索情况</div>
      </div>
    </div>
    
    <!-- 提交新知识 -->
    <div id="graph" class="panel_sub">
      <div class="title_sub"><span class="span_item">增加知识条目</span></div>
      <div class="content_margin">您可以向知识库中添加操作经验，提交后等待管理员审核通过。</div>
      <div class="content_margin viewdetail"><a href="javascript:void(0)" onclick="showUpload($(this))">点击此处增加知识条目</a></div>
      <div id="experienceUpload" style="display:none">
        <div class="content"><input type="text" id="contentUpload" value="请输入操作经验内容"/></div>
        <div class="explaination"><input type="text" id="explainationUpload" value="请输入操作经验内容说明"/></div>
        <input type="button" id="submit" name="submit" value="提交" onclick="submit($(this))"/>
		<input type="button" id="cancel" name="cancel" value="取消" onclick="cancel($(this))"/>
		</div>
    </div>
    
  </div>
  
  <div class="filling">&nbsp;</div>
  
</div>



<!-- 下方：推荐内容 -->
<%--<div class="mainDiv">
  
  <!-- 内容推荐（根据我的浏览记录推荐我感兴趣的内容） -->
  <div id="ad1" class="panel_sub">
    <div class="title_sub"><span class="span_item">内容推荐</span></div>
    <div class="content_margin">
      <table class="table">
        <tr>
        <th><span class="span_item">知识类型</span></th>
          <th><span class="span_item">知识库条目</span></th>
          <th><span class="span_item">最后修改日期</span></th>
        </tr>
        <s:iterator value="klgBankFavorDisp" id="klgBankFavor" status="st">
        <tr id="${klgBankFavor.id}" type-info="${klgBankFavor.type}">
        <td><span class="span_item">${klgBankFavor.type}</span></td>
        <td><span class="span_item"><a href="javascript:void(0)" onclick="showAll($(this))">${klgBankFavor.contentSe}</a></span></td>
        <td><span class="span_item">${klgBankFavor.lastUpdateDate}</span></td>
        </tr>        
        </s:iterator>
      </table>
    </div>
  </div>
  
  <!-- 大家都在看什么（浏览量） -->
  <div id="ad2" class="panel_sub">
    <div class="title_sub"><span class="span_item">大家都在看</span></div>
    <div class="content_margin">
      <table class="table">
        <tr>
        <th><span class="span_item">知识类型</span></th>
          <th><span class="span_item">知识库条目</span></th>
          <th><span class="span_item">最后修改日期</span></th>
        </tr>
        <s:iterator value="klgBankPopDisp" id="klgBankPop" status="st">
        <tr id="${klgBankPop.id}" type-info="${klgBankPop.type}">
        <td><span class="span_item">${klgBankPop.type}</span></td>
        <td><span class="span_item"><a href="javascript:void(0)" onclick="showAll($(this))">${klgBankPop.contentSe}</a></span></td>
        <td><span class="span_item">${klgBankPop.lastUpdateDate}</span></td>
        </tr>        
        </s:iterator>
      </table>
    </div>
  </div>
  
</div>


--%></body>

</html>