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
    
    <title>在线学习</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/learning/onlinecourse.css"/>
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/learning/onlineCourseList.js"></script>
	
	<STYLE type="text/css">
	a{
	width: 154px;
	height:225px;
	text-decoration: none;
	text-align:center;
	padding:60px 0px;
	border:1px solid #005E5E;
	color: #666;
	font-size:20px;
	
}

a:hover {
	color: #B79567;
	border:1px solid #E7473E;
}
	</STYLE>
	
</head>
<body>
<div class="mainDiv">
    <div class="panelContainer">
    	<div class="title_main">在线学习</div>
    	<div class="title_cld">
    		<ul class="title_ul">
    			<li><span class="title_p bk" onclick="onlineCourseListChangeFun($(this))">书籍学习</span><span class="title_c">|</span></li>
    		<!-- 	<li><span class="title_p pt" onclick="onlineCourseListChangeFun($(this))">课件学习</span><span class="title_c">|</span></li> -->
    			<li><span class="title_p ad" onclick="onlineCourseListChangeFun($(this))">视频学习</span><span class="title_c"></span></li>
    		</ul>
    	</div>
    	<div class="content" id="bk">
    		<div class="content_margin">
    		 <s:iterator value="bookList" id="book">
    			<div class="studyBook_main_books">
    			
						<a class="a" href="learning/OnlineCourseAction_onlineCourseDisp?courseID=${book.id}&courseType=BOOK">${book.bookName}</a>
		  			
    			</div>
    		</s:iterator>
			</div>
    	</div>
    	<div class="content" id="pt">
    		<div class="content_margin">
    		<s:iterator value="pptList" id="ppt">
    			<div class="studyBook_main_books">
						<a class="a"  href="learning/OnlineCourseAction_onlineCourseDisp?courseID=${ppt.id}&courseType=PPT">${ppt.pptName}</a>
    			</div>
    		</s:iterator>
			</div>
    	</div>
    	<div class="content" id="ad">
    		<div class="content_margin">
    		<s:iterator value="videoList" id="video">
    			<div class="studyBook_main_books">
    			<!--	<div class="studyBook_main_book" id="${video.id}">
						 <a href="learning/OnlineCourseAction_onlineCourseDisp?courseID=${video.id}&courseType=VIDEO"></a>	
		  			</div> -->
		  			<div class="studyBook_main_book"><a href="learning/OnlineCourseAction_onlineCourseDisp?courseID=${video.id}&courseType=VIDEO">${video.videoName}</a></div>
    			</div>
    		</s:iterator>
			</div>
    	</div>
    </div>
</div>
</body>
</html>
