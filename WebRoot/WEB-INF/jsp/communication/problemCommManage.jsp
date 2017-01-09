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
    
    <title>问题管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/common/paginate.css" media="screen">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/comm.css">
    <link rel="stylesheet" type="text/css" href="resource/css/communication/problemCommManage.css">
	
	<script type="text/javascript" src="resource/js/communication/problemCommManage.js"></script>
	
	<script type="text/javascript" src="resource/js/learning/jquery-1.3.2.js"></script>
	<script src="resource/js/learning/jquery.paginate.js" type="text/javascript"></script>
		 
	<script type="text/javascript">
	function SelectAll() {
 var checkboxs=document.getElementsByName("checkboxid");
 for (var i=0;i<checkboxs.length;i++) {
  var e=checkboxs[i];
  e.checked=!e.checked;
 }
}

function SelectAll2() {
 var checkboxs=document.getElementsByName("checkboxid2");
 for (var i=0;i<checkboxs.length;i++) {
  var e=checkboxs[i];
  e.checked=!e.checked;
 }
}
function Getid(){
	 var checkboxs=document.getElementsByName("checkboxid");
	 var problemIds;
	 var begin=true;
	 for (var i=0;i<checkboxs.length;i++) {  
  		var e=checkboxs[i];
 		if(e.checked){
 			var s=$("#problem"+i).val();
 			if(begin){
 				problemIds=s;
 				begin=false;
 			}else{
 				problemIds=problemIds+","+s;
 			}
 		}
 	}
	 if(begin){
		 alert("未选择！");
	 }else{
		 window.location.href="commu/ProblemManageAction_deleteProblem?problemIds="+problemIds;
	 	 //alert("删除成功！");
	 }
	 
}
function Getid2(){
	 
	var checkboxs=document.getElementsByName("checkboxid2");
	var problemIds;
	var begin=true;
	for (var i=0;i<checkboxs.length;i++) {  
			var e=checkboxs[i];
		if(e.checked){
			var s=$("#answer"+i).val();
			if(begin){
				problemIds=s;
				begin=false;
			}else{
				problemIds=problemIds+","+s;
			}
		}
	}
	if(begin){
	 	alert("未选择！");
	}else{
	 	window.location.href="commu/ProblemManageAction_deleteAnswer?problemIds="+problemIds;
	}
}


	$(function(){
			if(${type=="question"}){
				
				$("#question").show();
		 		$("#answer").hide();
				for(var i=1; i<=${size}; i++){
					$("#pageQuestion").append("<option value="+i+">"+i+"</option>"); 
				}
				$("#pageQuestion").val(${page}); //设置select的value为${page}的项选中 
				$("#pageQuestion").change(function(){
					window.location="commu/ProblemManageAction_queryByPage.action?type=question&&page="+$("#pageQuestion").val();
				});
			}else if(${type=="answer"}){
				
				$("#answer").show();
		 		$("#question").hide();
				for(var i=1; i<=${size}; i++){
					$("#pageAnswer").append("<option value="+i+">"+i+"</option>"); 
				}
				$("#pageAnswer").val(${page}); //设置select的value为${page}的项选中 
				$("#pageAnswer").change(function(){
					window.location="commu/ProblemManageAction_queryByPage.action?type=answer&&page="+$("#pageAnswer").val();
				});
			}
			
			$("#questionTab").click(function(){
				 window.location.href="commu/ProblemManageAction_queryByPage.action?type=question&&page=1";
			 	$("#question").show();
		 		$("#answer").hide();
			})
			$("#answerTab").click(function(){
				 window.location.href="commu/ProblemManageAction_queryByPage.action?type=answer&&page=1";
			 	$("#answer").show();
		 		$("#question").hide();
			})
		});
	</script>
</head>
  
<body>
<div class="mainDiv">
  <!-- 查询 -->
  <div id="" class="panel_main">
    <div class="title_main"><span class="span_item">查询</span></div>
 	<div class="content_margin">
 	<span class="span_item">员工姓名：<input type="text" name=""></span>
 	<span class="span_item"> 创建时间：<input type="text" name=""></span>
 	<span class="span_item">标签：<input type="text" name=""></span>
 	<span class="span_item"><img src="resource/image/communication/btn_query.png" style="cursor: po"/></span>
 	</div>
  </div>
  <!--  员工问题回复列表   -->
  <div class="panel_main">
    <div class="title_main">
    <span class="span_item">
   	 	<input id="questionTab"  type="button" value="问题列表" class="tab"></input>
    </span>
    <span class="span_item">
    	<input id="answerTab" type="button" value="回复列表" class="tab"></input>
    </span>

    </div>
    <div class="content_margin">
     <!--  员工问题列表   -->
     <div id="question">
    <table width="90%" class="table">
    <tr>
		<th style="width:8%;"></th>
        <th style="width:30%;">问题描述</th>
		<th style="width:8%; text-align: left">标签</th>
		<th style="width:8%;text-align: left">提问员工</th>
        <th style="width:15%;">发表时间</th>
        <th style="width:8%;">浏览次数</th>
        <th style="width:8%;">回答次数</th>
	</tr>
	<s:iterator value="pageBean.list" status="stt">
		<tr>
			<td><input type="checkbox" name="checkboxid"/><input type="hidden" id="problem<s:property value="#stt.index"/>" value="${id}"/></td>
			<td style="text-align: left"><a href="commu/ProblemCommuAction_problemCommDisp?problemId=${id}">${problemDesc}</a></td>
			<td style="text-align: left">${labels}</td>
			<td style="text-align: left">${usr.username}</td>
			<td>${postDate}</td>
			<td>${viewCount}</td>
			<td>${answerCount}</td>
		</tr>
	</s:iterator>
	
    </table>
    <input type="button" name="checkboxid" id="checkboxid"  onclick="javascript:SelectAll()" value="全选/反选" class="tab" style="margin-left: 50px;"></input>
    <input onClick="Getid();" type="button" value="删除" class="tab" style="margin-left: 50px;"></input>
    
        <!--  分页显示   -->
    	<div align="center">共
		<s:property value="pageBean.allRow" />
		条 共
		<s:property value="pageBean.totalPage" />
		页 第
		<s:property value="pageBean.currentPage" />
		页
		<s:if test="%{pageBean.currentPage == 1}">上一页</s:if>
		<s:else>
			<a
				href="commu/ProblemManageAction_queryByPage.action?type=question&&page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
		</s:else>
		<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
			<a
				href="commu/ProblemManageAction_queryByPage.action?type=question&&page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="pageQuestion">
		</select>
		页</div>
  
    </div>
     <!--  员工回复列表   -->
     <div id="answer" style="display: none;" >
    <table  width="90%" class="table" >
    <tr>
		<th style="width:10%;"></th>
        <th style="width:30%;">问题描述</th>
		<th style="width:30%;">回答描述</th>
		<th style="width:10%; text-align: left;">回答员工姓名</th>
        <th style="width:15%;">回答时间</th>
	</tr>
	<s:iterator value="pageBean.list" status="stt">
		<tr>
			<td><input type="checkbox" name="checkboxid2"/><input type="hidden" id="answer<s:property value="#stt.index"/>" value="${id}"/></td>
			<td style="text-align: left">${problemDesc}</td>
			<td style="text-align: left"><a href="commu/ProblemCommuAction_problemCommDisp?problemId=${id}">${answerContent}</a></td>
			<td style="text-align: left">${usr.username}</td>
			<td>${answerDate}</td>
		</tr>
	</s:iterator>
    </table>
   <input type="button" name="checkboxid2" id="checkboxid2"  onclick="javascript:SelectAll2()" value="全选/反选" class="tab" style="margin-left: 50px;"></input>
    <input onClick="Getid2();" type="button" value="删除" class="tab" style="margin-left: 50px;"></input>
    <!--  分页显示   -->
    	<div align="center">共
		<s:property value="pageBean.allRow" />
		条 共
		<s:property value="pageBean.totalPage" />
		页 第
		<s:property value="pageBean.currentPage" />
		页
		<s:if test="%{pageBean.currentPage == 1}">上一页</s:if>
		<s:else>
			<a
				href="commu/ProblemManageAction_queryByPage.action?type=answer&&page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
		</s:else>
		<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
			<a
				href="commu/ProblemManageAction_queryByPage.action?type=answer&&page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="pageAnswer">
		</select>
		页</div>

</div>
    </div>
  </div>
  
  
  <!-- 图表与统计 -->
  <div id="statistics" class="panel_main">
    <div class="title_main"><span class="span_item">统计图表</span></div>
    <div class="panel_sub graph">
      <div class="title_sub"><span class="span_item">图1</span></div>
      <div class="content_margin">图1内容</div>
    </div>
    <div class="panel_sub graph">
      <div class="title_sub"><span class="span_item">图2</span></div>
      <div class="content_margin">图2内容</div>
    </div>
    <div class="panel_sub graph">
      <div class="title_sub"><span class="span_item">图3</span></div>
      <div class="content_margin">图3内容</div>
    </div>
    <div class="filling"></div>
  </div>
  
</div>


</body>
</html>
