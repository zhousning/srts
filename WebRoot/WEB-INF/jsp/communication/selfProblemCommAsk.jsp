<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>我要提问</title>
    
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/selfProblemCommAsk.css">
	<style type="text/css">
label.error{
margin-left: 10px;
color: red;
}
</style>

	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/jquery/jquery.validate.js"></script>
	<script type="text/javascript" src="resource/script/jquery/jquery.metadata.js"></script>
	<script type="text/javascript" src="resource/js/communication/selfProblemCommAsk.js"></script>
	<script language="javascript">
      $(function(){
      	$("#myForm").validate();
      });
       
    </script>
</head>
<body>
<div class="mainDiv">
	<form action="commu/ProblemCommuAction_submitSelfAsk" method="post" id="myForm" >
	<div class="selfProblemAreaContainer">
		<div class="selfProblemArea_prob_title">描述您的问题</div>
		<div class="selfProblemArea_prob_area">
			<textarea name="ProblemInfo.problemDesc" class="{required:true ,messages:{required:'*'}}"></textarea>
			<!-- <span>0/50</span> -->
		</div>
		<div class="selfProblemArea_other_title">问题补充</div>
		<div class="selfProblemArea_other_area">
			<textarea name="ProblemInfo.problemDescAdd" class="{required:true ,messages:{required:'*'}}"></textarea>
		</div>
		<div class="selfProblemArea_label_title">问题标签</div>
		<div class="selfProblemArea_label_area">
			<span class="label_add">+</span>
			<span class="label_input"><input type="text" name="ProblemInfo.labels" class="{required:true ,messages:{required:'*'}}"></span>
		</div>
		<input type="submit" value="提交问题" class="selfProblemArea_btn">
	</div>
	</form>
</div>
</body>
</html>
