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
    
    <title>课程上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/learning/StudyCourse.css"/>
	<link rel="stylesheet" type="text/css" href="resource/css/learning/onlineCourseManageList.css"/>
	<link rel="stylesheet" type="text/css" href="resource/css/learning/onlineCourseManagePost.css"/>
 <style type="text/css">
		label.error{
			margin-left: 10px;
			color: red;
		}
		</style>
				<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
<script type="text/javascript" src="resource/script/jquery/jquery.metadata.js"></script>
    <script type="text/javascript" src="resource/script/jquery/jquery.validate.js"></script>
     <script type="text/javascript" src="resource/script/jquery/jquery.validate.cn.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("form").validate();
    	})
    </script>
</head>
<body>
<div class="mainDiv">
	<s:if test="%{courseType == 'BOOK'}">
	<div class="t">添加课程信息</div>
	<div class="content" id="bk">
	<form action="learning/OnlineCourseManageAction_onlineCourseManagePostSus" method="post" enctype="multipart/form-data" id="myForm">
		<div class="in"><label class="l">书籍名称：</label><input class="courseName {required:true ,messages:{required:'*'}}" name="courseName" type="text" value="${courseName}"/></div>
		<div class="in"><label class="l">书籍简介：</label><textarea class="courseIntro {required:true ,messages:{required:'*'}}" name="courseIntro">${courseIntro}</textarea></div>
		<div class="in"><label class="l">书籍上传：</label><input name="upload" type="file" class="{required:true ,messages:{required:'*'}}"/><span style="color:red">只能上传doc文件</span></div>
		<div class="in"><a href=""><input name="courseType" value="BOOK" type="hidden"/></a></div>
		<div class="in"><input  type="image" src="resource/image/learning/btn_over.png"/></div>
	</form>
	</div>
	</s:if>

	<s:if test="%{courseType =='PPT'}">
	<div class="t">添加文档信息</div>
	<div class="content">
	<form action="learning/OnlineCourseManageAction_onlineCourseManagePostSus" method="post" enctype="multipart/form-data" id="myForm">
		<div class="in"><label class="l">文档名称：</label><input class="courseName {required:true ,messages:{required:'*'}}" name="courseName" type="text" value="${courseName}"/></div>
		<div class="in"><label class="l">文档简介：</label><textarea class="courseIntro {required:true ,messages:{required:'*'}}" name="courseIntro">${courseIntro}</textarea></div>
		<div class="in"><label class="l">文档上传：</label><input name="upload" type="file" class="{required:true ,messages:{required:'*'}}"/><span style="color:red">只能上传doc文件</span></div>
		<div class="in"><input name="courseType" value="PPT" type="hidden"/></div>
		<div class="in"><input type="image" src="resource/image/learning/btn_over.png"/></div>
	</form>
	</div>
	</s:if>
	
	<s:if test="%{courseType =='VIDEO'}">
	<div class="t">添加视频信息</div>
	<div class="content">
	<form action="learning/OnlineCourseManageAction_onlineCourseManagePostSus" method="post" enctype="multipart/form-data" id="myForm">
		<div class="in"><label class="l">视频名称：</label><input class="courseName {required:true ,messages:{required:'*'}}" name="courseName" type="text" value="${courseName}"/></div>
		<div class="in"><label class="l">视频简介：</label><textarea class="courseIntro {required:true ,messages:{required:'*'}}" name="courseIntro">${courseIntro}</textarea></div>
		<div class="in"><label class="l">视频上传：</label><input name="upload" type="file" class="{required:true ,messages:{required:'*'}}"/><span style="color:red">只能上传mp4文件</span></div>
		<div class="in"><input name="courseType" value="VIDEO" type="hidden"/></div>
		<div class="in"><input type="image" src="resource/image/learning/btn_over.png"/></div>
	</form>
	</div>
	</s:if>
</div>
</body>
</html>
