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
    
    <title>课件浏览</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/learning/StudyCourse.css"/>
	<link rel="stylesheet" type="text/css" href="resource/css/learning/onlineCourseManageDisp.css"/>
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/learning/onlineCourseManageDisp.js"></script>
	<!--<script>
		window.onload = function(){
			initMulLine();
		}
	</script>-->
	<style>
	.course_info{
		width:1200px;
		height:500px;
	}
	.course_img{
		margin-left:50px;
	}
	.course_message{
		margin-left:200px;
		margin-top:80px;
	}
	tr{
	border:1px solid #113965;
	}
	.title{
	width:100px;
	height:40px;
	}
	.item{

	height:40px;
	}
	.cnt{
	width:400px;
	}
	#bookIntro{
	width:400px;
	}
	.cop{
	margin-top:30px;
	}
	.btn1{
	float:left;
	margin-left:40px;
	}


	</style>
</head>
<body>  
<div class="mainDiv">
	<s:if test="%{courseType =='BOOK'}">
	<div class="panelContainer">
		<div class="title_main">书籍信息</div>
		<div class="content">
    		<div class="course_info">
    		<!-- 	<div class="course_img"><img src="<s:property value="'resource/templete/learning/book_ppt_video/'+book.bookIcon"/>" alt="" width="175" height="240"/></div>   -->
    			<div class="course_message">
    			<form id="updateBookForm" method="post">
    	<input type="hidden" id="bookID" value="${book.id}"/>
    	<table>
    				<tr><td class="title">书籍书名:</td><td class="item"><input class="cnt" type="text" id="bookName" value="${book.bookName}" /></td></tr>
    				<tr><td class="title">上传者:</td><td class="item"><input class="cnt" type="text" value="${book.uploadUsr}" readonly="readonly"/></td></tr>
    			<tr><td class="title">上传时间:</td><td class="item"><input class="cnt" type="text" value="${book.date}" readonly="readonly"/></td></tr>
    				<tr><td class="title">简介:</td><td class="item"><textarea id="bookIntro">${book.bookIntro}</textarea></td></tr>
    				</table>
    			</form>
    		<div class="cop">
    			<div class="btn1" onclick="saveCourseInfo('BOOK')">保存</div>
    				<div class="btn1" id="${book.id}" onclick="deleteAndUpload($(this))">删除重传</div></div>
    			</div>
			</div><%--
			<div class="chapter_info">
				<div>章节详情</div>
				<div class="chapters">
				<s:iterator value="courseInfoPo.bookInfo.chapters" id="chapter">
					<div class="chapter">
						<div>${chapter.chapterNum}</div>
						<div>${chapter.chapterName}</div>
					</div>
				</s:iterator>
				</div>
			</div>
		--%></div>
	</div>
	
	</s:if>
	<s:if test="%{courseType =='PPT'}">
		<div class="panelContainer">
		<div class="title_main">课件信息</div>
		<div class="content">
			<div class="course_info">
				<!-- <div class="course_img"><img src="<s:property value="'resource/templete/learning/book_ppt_video/'+ppt.pptImgURL"/>" alt="" width="175" height="240"/></div> -->
    			<div class="course_message">
    			<form id="updateBookForm" method="post">
    			<input type="hidden" id="pptID" value="${ppt.id}"/>
    			<table>
    				<tr><td class="title">课件名称:</td><td class="item"><input class="cnt" type="text" id="pptName" value="${ppt.pptName}"/></td></tr>
    				<tr><td class="title">上传者:</td><td class="item"><input class="cnt" type="text" value="${ppt.uploadUsr}" readonly="readonly"/></td></tr>
    				<tr><td class="title">上传时间:</td><td class="item"><input class="cnt" type="text" value="${ppt.uploadDate}" readonly="readonly"/></td></tr>
    				<tr><td class="title">简介:</td><td class="item"><textarea class="cnt" id="pptIntro">${ppt.pptIntro}</textarea></td></tr>
    				</table>
    			</form>
    			<div class="cop">
    			<div class="btn1" onclick="saveCourseInfo('PPT')">保存</div>
    				<div class="btn1" id="${ppt.id}" onclick="deleteAndUpload($(this))">删除重传</div></div>
    			</div>
			</div>
		</div>
    	</div>
	</s:if>
	<s:if test="%{courseType =='VIDEO'}">
	<div class="panelContainer">
	<div class="title_main">视频信息</div>
		<div class="content">
			<div class="course_info">
			<!-- 	<div class="course_img"><img src="<s:property value="'resource/templete/learning/book_ppt_video/'+video.videoImgURL"/>" alt="" width="175" height="240"/></div>    -->
    			<div class="course_message">
    			<form id="updateBookForm" method="post">
    			<input type="hidden" id="videoID" value="${video.id}"/>
    			<table>
    				<tr><td class="title">视频名称:</td><td class="item"><input class="cnt" type="text" id="videoName" value="${video.videoName}"/></td></tr>
    				<tr><td class="title">上传者:</td><td class="item"><input class="cnt" type="text" value="${video.uploadUsr}" readonly="readonly"/></td></tr>
    				<tr><td class="title">上传时间:</td><td class="item"><input class="cnt" type="text" value="${video.uploadDate}" readonly="readonly"/></td></tr>
    				<tr><td class="title">简介:</td><td class="item"><textarea class="cnt" id="videoIntro">${video.videoIntro}</textarea></td></tr>
    				</table>
    			</form>
    			
    			<div class="btn1" onclick="saveCourseInfo('VIDEO')">保存</div>
    				<div class="course_message_sub"><div class="btn1" id="${video.id}" onclick="deleteAndUpload($(this))">删除重传</div></div>
    			</div>
			</div>
		</div>
    </div>
	</s:if>
</div>
</body>
</html>
