<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
<title>学习交流管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/learning/style.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/studyandcomm.css">
		<script language="JavaScript" type="text/JavaScript">
		function change(id)
		{
		  if(id=="question"){
			  if(document.getElementById(id).style.display=='none')
			   { document.getElementById(id).style.display=''; 
			   	document.getElementById("answer").style.display='none';
			   }
			   

			  }else{	  		 
				  if(id=="answer"){					
				  if(document.getElementById(id).style.display=='none')
				   { document.getElementById(id).style.display='block';
				   document.getElementById("question").style.display='none';
				   document.getElementById("answer").style.display='block'; 
				   }
				  }
				  
			  }
		}


</script>
	<style type="text/css">
<!--
-->
    </style>
</head>
<body>
<div class="mainDiv">
<p></p>
<div class="top">
  <div class="STYLE1" >&nbsp;学习交流管理</div>
  <div class="banner"></div>
</div>
<p></p>

<div class="content">
<div class="title">
<div class="title1"><input name="" type="submit" class="find"   onClick="change('question')" value="发帖管理" /></div>
<div class="title2"><input name="" type="submit" class="find"   onClick="change('answer')" value="模块管理" /></div>
</div>
<div class="operation">
<div class="operation_button">
&nbsp;   &nbsp;操作：
<input name="" type="submit" class="add"        id="submit"  value="添加" />
<input name="" type="submit" class="delete"     id="submit"  value="删除" />
<input name="" type="submit" class="update"     id="submit"  value="修改" />
<span class="STYLE6">条件1</span>
<input name="" class="i2" type="text">
<span class="STYLE6">条件2</span>
<input name="" class="i2" type="text">
<span class="STYLE6">条件3</span>
<input name="" class="i2" type="text">
<input name="" type="submit" class="find"       id="submit"  value="查询" />
</div>
<div id="question">
<div class="area">
<p></p>
<table width="900" border="0" cellspacing="0" cellpadding="0">
  <tr style="background-color:#f1f1f1;" height="34">
    <td><div align="center"></div></td>
    <td><div align="center">标题</div></td>
    <td><div align="center">标签</div></td>
    <td><div align="center">发帖人</div></td>
    <td><div align="center">浏览</div></td>
    <td><div align="center">回复</div></td>
    <td><div align="center">发帖时间</div></td>
  </tr>
    <tr>
    <td><div align="center">&nbsp;</div></td>
    <td><div align="center">&nbsp;</div></td>
    <td><div align="center">&nbsp;</div></td>
    <td><div align="center">&nbsp;</div></td>
    <td><div align="center">&nbsp;</div></td>
    <td><div align="center">&nbsp;</div></td>
    <td><div align="center">&nbsp;</div></td>
  </tr>
  <tr style="background-color:#C3E5E7;" height="34" >
    <td><div align="center">
      <input name="" type="checkbox" value="">
    </div></td>
    <td><div align="center">为什么要施工要带安全帽？</div></td>
    <td><div align="center">安全</div></td>
    <td><div align="center">董工</div></td>
    <td><div align="center">128</div></td>
    <td><div align="center">77</div></td>
    <td><div align="center">2014-07-16 16:03</div></td>
  </tr>
   <tr style="background-color:#C3E5E7;" height="34">
    <td><div align="center">
      <input name="" type="checkbox" value="">
    </div></td>
    <td><div align="center">安全操作的重要性</div></td>
    <td><div align="center">安全</div></td>
    <td><div align="center">董工</div></td>
    <td><div align="center">126</div></td>
    <td><div align="center">12</div></td>
    <td><div align="center">2014-07-16 16:04</div></td>
  </tr>
</table>
<p></p>
<div id="demo3"></div>
		<script type="text/javascript" src="resource/js/learning/jquery-1.3.2.js"></script>
		<script src="resource/js/learning/jquery.paginate.js" type="text/javascript"></script>
		<script type="text/javascript">
		$(function() {
			$("#demo3").paginate({
				count 		: 1,
				start 		: 2,
				display     : 7,
				border					: true,
				border_color			: '#C3E5E7',
				text_color  			: '#3399FF',
				background_color    	: '#FFFFFF',	
				border_hover_color		: 'black',
				text_hover_color  		: 'black',
				background_hover_color	: '#FFFFFF',
				rotate      : false,
				images		: false,
				mouse		: 'press',
				onChange    : function(page){
				//	$('._current','#paginationdemo').removeClass('_current').hide();
					//$('#p'+page).addClass('_current').show();
					//window.location.href='userLoginAction_showMessageTopic?pageNum='+ encodeURI(encodeURI(page)+' &choiceId='+${choiceId});

					//window.location.href="userLoginAction_showMessageTopic?pageNum="+page;
				  }
			});
			
		});
		</script>
</div>
</div> 
<div id="answer"  style="display:none;">
<div class="area"  >
<div class="area1">
  <div align="right">
    <input name="" type="checkbox" value="">
  
  <table width="280" height="159" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="">&nbsp;标题</td>
  </tr>
  <tr>
    <td>&nbsp;标签</td>
  </tr>
  <tr>
    <td>&nbsp;发帖人</td>
  </tr>
  <tr>
    <td>&nbsp;浏览</td>
  </tr>
  <tr>
    <td>&nbsp;回复</td>
  </tr>
  <tr>
    <td>&nbsp;发帖时间</td>
  </tr>
</table>
</div>
</div>
 <div class="area2"> 
 <div class="none">
  <div align="right">
    <input name="" type="checkbox" value="">
  <table width="280" height="159" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="">&nbsp;标题</td>
  </tr>
  <tr>
    <td>&nbsp;标签</td>
  </tr>
  <tr>
    <td>&nbsp;发帖人</td>
  </tr>
  <tr>
    <td>&nbsp;浏览</td>
  </tr>
  <tr>
    <td>&nbsp;回复</td>
  </tr>
  <tr>
    <td>&nbsp;发帖时间</td>
  </tr>
</table></div></div>
 </div> 


 

 
  
<div class="area3"> 
<div class="none">
  <div align="right">
    <input name="" type="checkbox" value=""> 
  <table width="280" height="159" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="">&nbsp;标题</td>
  </tr>
  <tr>
    <td>&nbsp;标签</td>
  </tr>
  <tr>
    <td>&nbsp;发帖人</td>
  </tr>
  <tr>
    <td>&nbsp;浏览</td>
  </tr>
  <tr>
    <td>&nbsp;回复</td>
  </tr>
  <tr>
    <td>&nbsp;发帖时间</td>
  </tr>
</table></div></div>
</div> 

 
<div class="area4">
<div class="none"> 
  <div align="right">
    <input name="" type="checkbox" value="">
  <table width="280" height="159" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="">&nbsp;标题</td>
  </tr>
  <tr>
    <td>&nbsp;标签</td>
  </tr>
  <tr>
    <td>&nbsp;发帖人</td>
  </tr>
  <tr>
    <td>&nbsp;浏览</td>
  </tr>
  <tr>
    <td>&nbsp;回复</td>
  </tr>
  <tr>
    <td>&nbsp;发帖时间</td>
  </tr>
</table></div></div></div>

  <div align="right">
  <div class="none">
  <div class="area5"> 
    <input name="" type="checkbox" value="">
  <table width="280" height="159" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="">&nbsp;标题</td>
  </tr>
  <tr>
    <td>&nbsp;标签</td>
  </tr>
  <tr>
    <td>&nbsp;发帖人</td>
  </tr>
  <tr>
    <td>&nbsp;浏览</td>
  </tr>
  <tr>
    <td>&nbsp;回复</td>
  </tr>
  <tr>
    <td>&nbsp;发帖时间</td>
  </tr>
</table></div></div></div>

<div class="area6"> 
<div class="none">
  <div align="right">
    <input name="" type="checkbox" value="">
  <table width="280" height="159" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="">&nbsp;标题</td>
  </tr>
  <tr>
    <td>&nbsp;标签</td>
  </tr>
  <tr>
    <td>&nbsp;发帖人</td>
  </tr>
  <tr>
    <td>&nbsp;浏览</td>
  </tr>
  <tr>
    <td>&nbsp;回复</td>
  </tr>
  <tr>
    <td>&nbsp;发帖时间</td>
  </tr>
</table></div>  </div></div>

  

 
<div class="area7"> 
<div class="none">
  <div align="right">
    <input name="" type="checkbox" value="">
 
  <table width="280" height="159" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="">&nbsp;标题</td>
  </tr>
  <tr>
    <td>&nbsp;标签</td>
  </tr>
  <tr>
    <td>&nbsp;发帖人</td>
  </tr>
  <tr>
    <td>&nbsp;浏览</td>
  </tr>
  <tr>
    <td>&nbsp;回复</td>
  </tr>
  <tr>
    <td>&nbsp;发帖时间</td>
  </tr>
</table></div>  </div> </div>
</div></div>  

<div class="message">
<input name="" type="submit" class="find"       id="submit"  value="统计信息" />
<div class="show1">
  <div class="showT" align="center"></div>
  <div></div>
</div>

<div class="show2">
  <div class="showT" align="center"></div>
  <div></div>
</div>

<div class="show3">
  <div class="showT" align="center"></div>
  <div></div>
</div>
</div>
</div>	
</div>
</body>
</html>