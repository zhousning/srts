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
    
    <title>单位学习状态评估</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/estimation/companyEtsimationList.css"/>
	<link rel="stylesheet" type="text/css" href="resource/css/common/jquery.ui.all.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/common/jquery.ui.datepicker.css">
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/estimation/companyEstimation.js"></script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.core.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.datepicker.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.datepicker-zh-CN.js">
</script>
	<script type="text/javascript">
        window.onload = function() {
	    initChart();
    }
    
    </script>
    <script type="text/javascript">
    	$(function(){
    		 $("#startDate").datepicker( 
			{ changeMonth: true, 
		    changeYear: true, 
            showMonthAfterYear : true,
             showButtonPanel:true,
				onSelect : function(dateText, inst) {

					$('#endDate').datepicker('option', 'minDate',
							new Date(dateText.replace('-', ',')))
				}

			})

	$("#endDate").datepicker(
			{
					changeMonth: true, 
		    changeYear: true, 
            showMonthAfterYear : true,
             showButtonPanel:true,
				onSelect : function(dateText, inst) {

					$('#startDate').datepicker('option', 'maxDate',
							new Date(dateText.replace('-', ',')))
				}
			})
    
    	
    	})
	   
    </script>

</head> 
<body>
<div class="mainDiv">
    <div class="panelContainer">
    <!-- <div class="title_main">记录管理</div> -->
    <!--查询部分-->
	<div class="testQuery content">
		<fieldset>
    		<legend class="title">查询条件</legend>
   			<div class="condt">
				<div class="condt1">单位：
				<select id="companyId" onchange="CompanyDeptOnChange()">
				<s:iterator value="findCompany" id="company" status="st">
				<option value="${company.id}">${company.name}</option>
				</s:iterator>
				</select>
				</div>
				<div class="condt1">部门：
				<select id="dept">
				<s:iterator value="findChildDeptByCompanyId" id="childDept" status="st">
				<option value="${childDept.id}">${childDept.name}</option>
				</s:iterator>
				</select>
				</div>
				<div class="condt1">开始时间：<input id="startDate" width="300px" type="text"
												readonly="readonly" /></div>
				<div class="condt1">结束时间：<input id="endDate" type="text" width="300px"
												readonly="readonly" /></div>
				<div class="condt1">考试名称：
				<select id="test">
				<s:iterator value="findTestInfoByStartDateAndEndDate" id="testInfo" status="st">
				<option value="${testInfo.id}">${testInfo.name}</option>
				</s:iterator>
				</select>
				</div>
				<div class="condt2"><div class="btn" onclick="queryByOptionFunction()">查询</div></div>
			</div>
  		</fieldset>
	</div>

	  <!-- 图表与统计 -->
	  <div id="statistics" class="panel_sub_main">
	    <div class="title_sub_main"><span class="span_item">统计图表</span></div>
	    <div class="testQuery content">
		<fieldset>
    		<legend class="title">查询条件</legend>
   			<div class="condt">
				<div class="condt1">单位：
				<select id="companyId1" onchange="CompanyDeptOnChange1()">
				<s:iterator value="findCompany1" id="company1" status="st">
				<option value="${company1.id}">${company1.name}</option>
				</s:iterator>
				</select>
				</div>
				<div class="condt1">部门：
				<select id="dept1">
				<s:iterator value="findChildDeptByCompanyId1" id="childDept1" status="st">
				<option value="${childDept1.id}">${childDept1.name}</option>
				</s:iterator>
				</select>
				</div>
				<div class="condt2"><div class="btn" onclick="queryByOptionFunction1()">查询</div></div>
			</div>
  		</fieldset>
	</div>
	  	<div class="panel_sub graph2">
	      <div class="title_sub"><span class="span_item">单位各次考试成绩变化</span></div>
	      <div class="content_margin" id="aveScoreByCompanyAndDeptContainer"></div>
	    </div>
	    <div class="testQuery content">
		<fieldset>
    		<legend class="title">查询条件</legend>
   			<div class="condt">
				<div class="condt1">单位：
				<select id="companyId2">
				<s:iterator value="findCompany2" id="company2" status="st">
				<option value="${company2.id}">${company2.name}</option>
				</s:iterator>
				</select>
				</div>
				<div class="condt1">考试名称：
				<select id="test2">
				<s:iterator value="findTestInfoByStartDateAndEndDate2" id="testInfo2" status="st">
				<option value="${testInfo2.id}">${testInfo2.name}</option>
				</s:iterator>
				</select>
				</div>
				<div class="condt2"><div class="btn" onclick="queryByOptionFunction2()">查询</div></div>
			</div>
  		</fieldset>
	</div>
	    <div class="panel_sub graph">
	      <div class="title_sub"><span class="span_item">各单位该次考试成绩统计</span></div>
	      <div class="content_margin" id="aveScoreByTestNameContainer"></div>
	    </div>
	    <div class="testQuery content">
		<fieldset>
    		<legend class="title">查询条件</legend>
   			<div class="condt">
				<div class="condt1">单位：
				<select id="companyId3" onchange="CompanyDeptOnChange3()">
				<s:iterator value="findCompany3" id="company3" status="st">
				<option value="${company3.id}">${company3.name}</option>
				</s:iterator>
				</select>
				</div>
				<div class="condt1">部门：
				<select id="dept3">
				<s:iterator value="findChildDeptByCompanyId3" id="childDept3" status="st">
				<option value="${childDept3.id}">${childDept3.name}</option>
				</s:iterator>
				</select>
				</div>
				<div class="condt1">考试名称：
				<select id="test3">
				<s:iterator value="findTestInfoByStartDateAndEndDate3" id="testInfo3" status="st">
				<option value="${testInfo3.id}">${testInfo3.name}</option>
				</s:iterator>
				</select>
				</div>
				<div class="condt2"><div class="btn" onclick="queryByOptionFunction3()">查询</div></div>
			</div>
  		</fieldset>
	</div>
	    <div class="panel_sub graph">
	      <div class="title_sub"><span class="span_item">考试成绩分类</span></div>
	      <div class="content_margin" id="categoryTestScoreContainer"></div>
	    </div>
	    <div class="filling"></div>
	  </div>
	</div>
	</div>
</body>
</html>
