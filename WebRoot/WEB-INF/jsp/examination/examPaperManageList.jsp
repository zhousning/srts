<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>试卷管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/examPaperManageList.css">
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/examination/examPaperManageList.js"></script>
	<style>
	.paperContainer{
		float:left;
		width:900px;
		height:600px;
		border:1px solid #DDD;
		position:absolute;
		top:20px;
		left:20px;
		background-color: white;
		display: none;
	}
	</style>
	
	<script type="text/javascript">
		$(function(){
			$("#checkAll").click(function(){
				if($(this).is(":checked")){
					$("input[name='checkbox']").each(function(){
						$(this).attr("checked",true);	
					});
				}else{
					$("input[name='checkbox']").each(function(){
						$(this).removeAttr("checked");	
					});
				}
			});
			$("#delete").click(function(){
				if($("input[name='checkbox']:checked").size()==0){
					alert("请选择。。。");
					return false;
				}else{
					var ids="";
					$("input[name='checkbox']").each(function(){
						if($(this).is(":checked")){
							ids=ids+$(this).val()+" ";
						}	
					});
					window.location.href="exam/ExaminationManageAction_deleteTestPaper.action?testPaperIds="+ids;
				}
			});
			
			for(var i=1; i<=${totalPage}; i++){
				$("#page").append("<option value="+i+">"+i+"</option>"); 
			}
			$("#page").val(${page}); //设置select的value为${page}的项选中 
			$("#page").change(function(){
				window.location="exam/ExaminationManageAction_queryByPage.action?page="+$("#page").val();
			});
		});
	</script>
</head>
<body>
<div class="mainDiv">
	<div class="container cont3">
		<div class="title">
			<div class="title1">历次考试试卷信息</div>
			<div class="title2"><div><a href="exam/ExaminationManageAction_examPaperManageDisp">进行组卷</a></div><div><img src="resource/image/examination/btn_delete.png" id="delete"/></div></div>
		</div>
		<div class="list_div">
			<div class="list_title">
				<div class="od"><input type="checkbox" id="checkAll"/></div>
				<div class="ne">考试名称</div>
				<div class="dt">考试时间</div>
				<div class="ne">试卷名称</div>
			</div>
			<div class="list_content">
				<ul class="list_ul">
					<s:iterator value="testPapers" status="s">
						<li class="item">
							<div class="item_div">
								<div class="od"><input type="checkbox" value="${id}" name="checkbox"/></div>
								<div class="ne">${testInfo.testName}</div>
								<div class="dt">${exam_date}</div>
								<div class="ne">${testPaperName}</div>
							</div>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="pageDiv">
			<div>共
		<s:property value="allRow" />
		条 共
		<s:property value="totalPage" />
		页 第
		<s:property value="page" />
		页
		<s:if test="page == 1">上一页</s:if>
		<s:else>
			<a
				href="exam/ExaminationManageAction_queryByPage.action?page=<s:property value="%{page-1}"/>">上一页</a>
		</s:else>
		<s:if test="page != totalPage">
			<a
				href="exam/ExaminationManageAction_queryByPage.action?page=<s:property value="%{page+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="page">
		</select>
		页</div>
		</div>
	</div>
	<div class="paperContainer">
		<div>考试试卷浏览</div>
		<div><iframe id='testPaperOut' frameborder="0" src="resource/templete/examination/html/exampaper-2014-7-5.html" height="570px" width="900px" scrolling="auto"></iframe></div>
	</div>
</div>
</body>
</html>
