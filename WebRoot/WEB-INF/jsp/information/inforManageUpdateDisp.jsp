<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改通知</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		
	<script type="text/javascript" src="resource/script/jquery/jquery.js"></script>

<script type="text/javascript" src="resource/script/jquery/jquery.metadata.js"></script>
    <script type="text/javascript" src="resource/script/jquery/jquery.validate.js"></script>
     <script type="text/javascript" src="resource/script/jquery/message.cn.js"></script>
   <script type="text/javascript">
var j = jQuery.noConflict(true);
</script>  
		
		<link rel="stylesheet" type="text/css"
			href="resource/css/common/common.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/information/info.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/information/inforManageUpdateDisp.css">
		<link rel="stylesheet" type="text/css" href="resource/css/common/jquery.ui.css">
		<link rel="stylesheet" type="text/css" href="resource/css/common/jquery.ui.all.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/common/jquery.ui.datepicker.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/common/jquery.ui.timepicker.css">
					 <style type="text/css">
		label.error{
			margin-left: 10px;
			color: red;
		}
	</style>
		<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.core.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.widget.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.mouse.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.slider.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.datepicker.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.datepicker-zh-CN.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.timepicker.js">
</script>
		<script type="text/javascript" src="resource/js/common/jquery.ui.timepicker-zh-CN.js">
</script>
<script type="text/javascript"
			src="resource/js/information/inforManageUpdateDisp.js">
</script>


<script type="text/javascript" src="resource/script/jquery/jquery.metadata.js"></script>
    <script type="text/javascript" src="resource/script/jquery/jquery.validate.js"></script>
     <script type="text/javascript" src="resource/script/jquery/jquery.validate.cn.js"></script>
     
<script type="text/javascript">
$(function() {
		  $("#testDate").datepicker( { 
		  	changeMonth: true, 
		    changeYear: true, 
		    firstDay: "7",
            showMonthAfterYear : true,
            showButtonPanel:true
		});
		  
		  
		  $("#testTime").timepicker();
		  $("#endTime").timepicker();

});

j(function(){
		 j("form").validate();
	});
</script>
	</head>

	<body>
		<div class="mainDiv">

			<div class="panel_main">
				<div class="title_main">
					<span class="span_item"> </span>

				</div>
				<div class="content_margin">
					<form action="info/InforManageCenterAction_inforManageCenterUpdate"
						method="post" enctype="multipart/form-data">
						<table width="90%" align="center" border="1" cellpadding="4"
							cellspacing="1" class="table">
							<tr align='center' height="22">
								<td width="15%" bgcolor="#FFFFFF" align="center">
									标题：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">
									<input type="text" name="trainNotice.noticeTitle"
										class="{required:true}" value="${trainNotice.noticeTitle}"
										id="noticeTitle" />
									<input type="hidden" name="trainNotice.id"
										value="${trainNotice.id}" />
								</td>
							</tr>
							<tr align='center' height="22">
								<td width="15%" bgcolor="#FFFFFF" align="center">
									类型：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">
									<select name="trainNotice.noticeType">
										<option
											<s:if test='trainNotice.noticeType=="考试通知"'>selected</s:if>
											value="考试通知">
											考试通知
										</option>
										<option
											<s:if test='trainNotice.noticeType=="培训通知"'>selected</s:if>
											value="培训通知">
											培训通知
										</option>
									</select>
								</td>
							</tr>
							<tr align='center' bgcolor="#FFFFFF" height="22">
								<td width="15%" bgcolor="#FFFFFF" align="center">
									内容：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">

									<div>
										<textarea name="trainNotice.noticeContent" id="noticeContent"
											class="{required:true}"
											style="width: 400px; height: 100px; resize: none;">${trainNotice.noticeContent}</textarea>
									</div>
									<!-- 此textarea应改成网页编辑器 -->
								</td>
							</tr>
							<tr align='center' bgcolor="#FFFFFF" height="22">
								<td width="15%" bgcolor="#FFFFFF" align="center">
									接收单位：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">

									<select name="trainNotice.acceptCompany" size="1">
										<option
											<s:if test='trainNotice.acceptCompany=="吉林供电公司"'>selected</s:if>
											value="吉林供电公司">
											吉林供电公司
										</option>
										<option
											<s:if test='trainNotice.acceptCompany=="安全监察质量部"'>selected</s:if>
											value="安全监察质量部">
											安全监察质量部
										</option>
										<option
											<s:if test='trainNotice.acceptCompany=="运维检修部"'>selected</s:if>
											value="运维检修部">
											运维检修部
										</option>
										<option
											<s:if test='trainNotice.acceptCompany=="基建部"'>selected</s:if>
											value="基建部">
											基建部
										</option>
										<option
											<s:if test='trainNotice.acceptCompany=="营销部"'>selected</s:if>
											value="营销部">
											营销部
										</option>
										<option
											<s:if test='trainNotice.acceptCompany=="调控中心"'>selected</s:if>
											value="调控中心">
											调控中心
										</option>
										<option
											<s:if test='trainNotice.acceptCompany=="检修试验工区"'>selected</s:if>
											value="检修试验工区">
											检修试验工区
										</option>
									</select>
								</td>
							</tr>
							<tr align='center' bgcolor="#FFFFFF" height="22">
								<td width="15%" bgcolor="#FFFFFF" align="center">
									附件：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">
									<input type="file" name="upload" size="30"
										onKeyDown="javascript:alert('此信息不能手动输入');return false;" />

								</td>
							</tr>

							<s:if test='%{noticeType=="考试通知"}'>
								<tr align='center' height="22">
									<td width="15%" bgcolor="#FFFFFF" align="center">
										考试名称：
									</td>
									<td width="85%" bgcolor="#FFFFFF" align="left">
										<input type="text" name="testInfo.testName"
											value="${trainNotice.testInfo.testName}"
											Class="{required:true}" />
									</td>
								</tr>
								<tr align='center' height="22">
									<td width="15%" bgcolor="#FFFFFF" align="center">
										考试日期：
									</td>
									<td width="85%" bgcolor="#FFFFFF" align="left">
										<input type="text" name="testInfo.testDate" id="testDate" 
											value="${trainNotice.testInfo.testDate}"
											Class="{required:true}" />
									</td>
								</tr>
								<tr align='center' height="22">
									<td width="15%" bgcolor="#FFFFFF" align="center">
										开始时间：
									</td>
									<td width="85%" bgcolor="#FFFFFF" align="left">
										<input type="text" name="testInfo.testTime" id="testTime" 
											value="${trainNotice.testInfo.testTime}"
											Class="{required:true}" />
									</td>
								</tr>
								<tr align='center' height="22">
								
								<td width="15%" bgcolor="#FFFFFF" align="center">
									结束时间：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">
									<input type="text" name="testInfo.endTime" id="endTime"
									value="${trainNotice.testInfo.endTime}"
										class="{required:true}" />
								</td>
							</tr>
							</s:if>



							<tr align='center' bgcolor="#FFFFFF" height="22">
								<td width="25%" bgcolor="#FFFFFF" align="right">
									&nbsp;

								</td>
								<td width="75%" bgcolor="#FFFFFF" align="left">
									<input type="submit" value="提交" />
									&nbsp;

								</td>
							</tr>
						</table>
					</form>

				</div>







			</div>

		</div>


	</body>
</html>
