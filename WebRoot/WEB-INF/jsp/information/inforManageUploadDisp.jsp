<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>新建通知</title>
		<!--
  		  这个页面需要文字编辑器
  		  已经尝试过ckeditor，ie显示不出来，360正常
  		 如果可以，多换几个试试
  		 时间不足，先用textarea代替
    -->

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	
		
		<link rel="stylesheet" type="text/css"
			href="resource/css/information/info.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/information/inforManageUploadDisp.css">

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
			src="resource/js/information/inforManageUploadDisp.js">
</script>

   <script type="text/javascript">
var j = jQuery.noConflict(true);
</script>  

	<script type="text/javascript" src="resource/script/jquery/jquery.js"></script>

<script type="text/javascript" src="resource/script/jquery/jquery.metadata.js"></script>
    <script type="text/javascript" src="resource/script/jquery/jquery.validate.js"></script>
     <script type="text/javascript" src="resource/script/jquery/message.cn.js"></script>

    
<script type="text/javascript">
	$(function() {

	$("#noticeType").change(function() {
		var val=$("#noticeType").val();
		if(val=="培训通知"){
		$("tr").remove(".testt");
		}else{
			location.href("info/InforManageCenterAction_inforManageUploadDisp");
		}
	});
	$("#dd").click(function(){
	
	});
	
	 $("form").validate();
	
});
	
	j(function(){
		
		  j("#testDate").datepicker( { 
		  	changeMonth: true, 
		    changeYear: true, 
		    firstDay: "7",
            showMonthAfterYear : true,
             showButtonPanel:true
		});
		  
		j("#testTime").timepicker();
		j("#endTime").timepicker();
		
	});
</script>

</head>
	<body>
		<div class="mainDiv">

			<!--  通知公告列表   -->
			<div class="panel_main">
				<div class="title_main">
					<span class="span_item"> 新建通知 </span>

				</div>
				<div class="content_margin">
					<form action="info/InforManageCenterAction_inforManageCenterNew"
						method="post" enctype="multipart/form-data">
						<table width="90%" align="center" border="1" cellpadding="4"
							cellspacing="1" class="table">
							<tr align='center' height="22">
								<td width="15%" bgcolor="#FFFFFF" align="center">
									标题：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">
									<input type="text" name="trainNotice.noticeTitle"
										class="{required:true}" />
								</td>
							</tr>
							<tr align='center' height="22">
								<td width="15%" bgcolor="#FFFFFF" align="center">
									类型：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">
									<select name="trainNotice.noticeType" id="noticeType">
										<option value="考试通知">
											考试通知
										</option>
										<option value="培训通知">
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
										<textarea name="trainNotice.noticeContent"
											class="{required:true}"
											style="width: 400px; height: 100px; resize: none;"></textarea>
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
										<option value="国网吉林供电公司">
											国网吉林供电公司
										</option><%--
										<option value="安全监察质量部">
											安全监察质量部
										</option>
										<option value="运维检修部">
											运维检修部
										</option>
										<option value="基建部">
											基建部
										</option>
										<option value="营销部">
											营销部
										</option>
										<option value="调控中心">
											调控中心
										</option>
										<option value="检修试验工区">
											检修试验工区
										</option>
									--%></select>
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

							
								<tr class="testt" align='center' height="22" id="examinationName">
								
								<td width="15%" bgcolor="#FFFFFF" align="center">
									考试名称：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">
									<input type="text" name="testInfo.testName"
										class="{required:true}" />
								</td>
							</tr>
							<tr class="testt" align='center' height="22" id="examinationDate">
								
								<td width="15%" bgcolor="#FFFFFF" align="center">
									考试日期：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">
									<input type="text" name="testInfo.testDate" id="testDate"
										class="{required:true}" />
								</td>
							</tr>
							<tr class="testt" align='center' height="22" id="examinationTime">
								
								<td width="15%" bgcolor="#FFFFFF" align="center">
									开始时间：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">
									<input type="text" name="testInfo.testTime" id="testTime"
										class="{required:true}" />
								</td>
							</tr>
							<tr class="testt" align='center' height="22" id="examinationTime">
								
								<td width="15%" bgcolor="#FFFFFF" align="center">
									结束时间：
								</td>
								<td width="85%" bgcolor="#FFFFFF" align="left">
									<input type="text" name="testInfo.endTime" id="endTime"
										class="{required:true}" />
								</td>
							</tr>
							
							<tr align='center' bgcolor="#FFFFFF" height="22">
								<td width="25%" bgcolor="#FFFFFF" align="right">
									&nbsp;

								</td>
								<td width="75%" bgcolor="#FFFFFF" align="left">
									<input type="submit" value="提交" />
							</tr>
						</table>
					</form>

				</div>

			</div>

		</div>


	</body>
</html>

