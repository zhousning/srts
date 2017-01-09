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
	<title>组织试卷</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/examPaperManageDisp.css">
	
	<script type="text/javascript"
			src="resource/script/jquery/jquery.min.js">
</script>
	<!--  <script type="text/javascript" src="resource/js/examination/examPaperManageDisp.hjs"></script> -->
 
	<script type="text/javascript">
	
		$(function(){
			
			$("#typeOne").click(function(){
				if($(this).is(":checked")){
					$(this).attr("value", "true");
				}
			});
			$("#typeTwo").click(function(){
				if($(this).is(":checked")){
					$(this).attr("value", "true");
				}
			});
			$("#typeThree").click(function(){
				if($(this).is(":checked")){
					$(this).attr("value", "true");
				}
			});
			$("#typeFour").click(function(){
				if($(this).is(":checked")){
					$(this).attr("value", "true");
				}
			});
			$("#typeFive").click(function(){
				if($(this).is(":checked")){
					$(this).attr("value", "true");
				}
			});
			
			$("#checkAll").click(function(){
				if($(this).is(":checked")){
					$("input[type='checkbox']").each(function(){
						$(this).attr("checked",true);	
					});
					$("#typeOne").attr("value", "true");
					$("#typeTwo").attr("value", "true");
					$("#typeThree").attr("value", "true");
					$("#typeFour").attr("value", "true");
					$("#typeFive").attr("value", "true");
				}else{
					$("input[type='checkbox']").each(function(){
						$(this).removeAttr("checked");	
					});
				}
			});
			
			$("#paperShow").click(function(){
				
				if($("input[type='checkbox']:checked").size()==0){
					alert("请选择试题类型！");
					return false;
				}else{
					$($(".name1").siblings()).removeClass("nav1").removeClass("target");
					$($(".name2").siblings()).addClass("nav1").addClass("target").addClass("do");	
					$(".panel").hide();
					$(".panel1").show();
				
					var params=$("#myForm").serialize();
					$.ajax({
						url:"exam/ExaminationManageAction_examPaperManageShow.action?testInfoId="+$("#testInfoId").val(),
						type:"post",
						data:params,
						dataType:"json",
						success:function(data){
							var strHtml = "";
							var i=1;
							$.each(data.questionBankList,function(key,val){
								var html="";
								html= "<br>"+i+"、"+val.content+"<br>";
								strHtml+=html;
								i++;
							});
							$("#testPaperShow").html(strHtml);
							
						}
					});	
				}	
			});
			
			if($("select option").length==0){
				alert("您当前没有考试，不能进行组卷！");
				$("#paperShow").attr("disabled", "true");
			}
		});
	</script>
	

</head> 
<body>
<div class="mainDiv">
	<div class="container">
		<div class="title">出卷顺序</div>
		<div class="content">
			<div class="navigation" onclick="navClickFun($(this))" onmouseover="navOverFun($(this))" onmouseout="navOutFun($(this))"><div class="navigation_name name1">1、试题类型</div><div class="nav nav1 target do"></div></div>
			<div class="navigation" onclick="navClickFun($(this))" onmouseover="navOverFun($(this))" onmouseout="navOutFun($(this))"><div class="navigation_name name2">2、生成试卷</div><div class="nav"></div></div>
		</div>
	</div>
	<div class="panelDiv panel show" >
		<div class="container2">
			<div class="title">考试名称</div>
			<div style="margin-left: 50px; margin-top:5px;"><select id="testInfoId">
				<s:iterator value="testInfos">
					<option value="${id}">${testName}</option>
				</s:iterator>
			</select></div>
		</div>
		<div class="container1">
			<div class="list">
				<div class="list_div3">
					<div class="title">试题类型</div>
					<div class="ty"><div class="ratio"><input type="checkbox" id="checkAll"/></div><div class="type">试题类型</div><div class="num">试题数目</div><div class="score">每题分值</div></div>
					<div class="ty1">
						<form action="" id="myForm">
							<ul class="list_ul2">
								<li class="li_item"><div class="ratio"><input type="checkbox" name="typeOne" id="typeOne" value="false"/></div><div class="type">单选题</div><div class="num"><input class="ni" type="text" name="oneNum" maxlength="2" value="20"/>题</div><div class="score"><input class="si" type="text" maxlength="2" name="oneScore" value="10"/>分/题</div></li>
								<li class="li_item"><div class="ratio"><input type="checkbox" name="typeTwo" id="typeTwo" value="false"/></div><div class="type">多选题</div><div class="num"><input class="ni" type="text" name="twoNum" maxlength="2" value="10"/>题</div><div class="score"><input class="si" type="text" maxlength="2" name="twoScore" value="10"/>分/题</div></li>
								<li class="li_item"><div class="ratio"><input type="checkbox" name="typeThree" id="typeThree" value="false"/></div><div class="type">判断题</div><div class="num"><input class="ni" type="text" name="threeNum" maxlength="2" value="5"/>题</div><div class="score"><input class="si" type="text" maxlength="2" name="threeScore" value="10"/>分/题</div></li>
								<li class="li_item"><div class="ratio"><input type="checkbox" name="typeFour" id="typeFour" value="false"/></div><div class="type">填空题</div><div class="num"><input class="ni" type="text" name="fourNum" maxlength="2" value="10"/>题</div><div class="score"><input class="si" type="text" maxlength="2" name="fourScore" value="10"/>分/题</div></li>
								<li class="li_item"><div class="ratio"><input type="checkbox" name="typeFive" id="typeFive" value="false"/></div><div class="type">简答题</div><div class="num"><input class="ni" type="text" name="fiveNum" maxlength="2" value="5"/>题</div><div class="score"><input class="si" type="text" maxlength="2" name="fiveScore" value="10"/>分/题</div></li>
							</ul>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="container2"><div class="btn_group"><div class="next_btn" id="paperShow">下一步</div></div></div>
	</div>
	<div class="panelDiv panel1" style="display:none;">
		<div class="container1">
			<div class="title">生成试卷</div>
			<div class="list">
				<div id="testPaperShow"></div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
