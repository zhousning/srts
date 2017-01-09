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
    <%@include file="/WEB-INF/jsp/commons/commons.jsp" %>
    <title>考试管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	 <link href="resource/css/controlPanel/self.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="resource/css/examination/exam.css">
	<link rel="stylesheet" type="text/css" href="resource/css/intman/userList.css">
    <link rel="stylesheet" type="text/css" href="resource/css/examination/examManageList.css">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	
	<style type="text/css">
	ul{
	width:1000px;
	height:30px;
	}
	li{
	margin-left:20px;
	margin-top:10px;
	float:left;
	}
	li a{
	width:200px;
	height:120px;
	display:block;
	text-decoration: none;
	border:1px solid #005E5E;
	text-align:center;
	line-height:120px;
    font-size:20px;
   color:#202020;
	}
	li a:hover{
	cursor:hand;
	border:1px solid #FDBA03;
	}
	</style>
	<script type="text/javascript">
	$(function(){
		for(var i=1; i<=${totalPage}; i++){
			$("#page").append("<option value="+i+">"+i+"</option>"); 
		}
		$("#page").val(${page}); //设置select的value为${page}的项选中 
		$("#page").change(function(){
			window.location="exam/ExaminationManageAction_examManageList.action?page="+$("#page").val();
		});
	});
</script>
</head>
  
<body>



<div class="mainDiv">
  <!-- 考试列表与管理 -->
  <div id="exammanage" class="panel_main">
    <div class="title_main"><span class="span_item">考试管理</span></div>
    <div id="examlist" class="content_margin">
    <ul>
   <li> <a href="exam/ExaminationManageAction_examPaperManageList">组卷</a></li>
    <li><a href="exam/ExaminationManageAction_examPeopleManageDisp">抽人考试</a></li><%--
    <li> <a href="exam/ExaminationManageAction_examPaperCheckManageDisp">评卷管理</a></li>
     --%><li><a href="exam/ExamScore_findPaperByCon">成绩管理</a></li>        
    </ul>	
    </div>
  </div>
  
  <div class="panel_main">
   <div class="title_main"><span class="span_item">考试信息</span></div>
   <div id="examlist" class="content_margin">
   
   <table id="t">
   <tr><td class="no">序号</td><td>考试名称</td><td>考试时间</td><td>组卷情况</td><td>抽人情况</td>
   <td>操作</td>
   </tr>
   <s:iterator value="examInfoPos" status="st">
    <tr>
    <td class="no"><s:property value="#st.index+1"/> </td>
    <td>${testName}</td>
    <td>${testDate}&nbsp;${testTime}</td>
    <td>
    <s:if test="testPaper!=null">
    <s:a action="ExaminationManageAction_examManageDisp?testInfoId=%{id}&reqStatus=0">已完成</s:a>
    </s:if>
    <s:else>
    未组卷
    </s:else>
    </td>
    <td>
    <s:if test="testPeople.size()!=0">
    <s:a action="ExaminationManageAction_examManageDisp?testInfoId=%{id}&reqStatus=1">已完成</s:a>
    </s:if>
    <s:else>
    未抽人
    </s:else>
    </td>
    <td >
     <s:if test="testPaper!=null">
    <s:a action="exam/ExaminationManageAction_examPaperManageExport?testInfoId=%{id}">试卷</s:a> &nbsp;
    </s:if>
   
      <s:if test="testPeople.size()!=0">
    <s:a action="exam/ExaminationPeopleAction_exporNameList?testInfoId=%{id}">名单</s:a>
    </s:if>
    </td>

    </tr>
   </s:iterator>  
   </table>
   
   </div>
  </div>
  
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
				href="exam/ExaminationManageAction_examManageList.action?page=<s:property value="%{page-1}"/>">上一页</a>
		</s:else>
		<s:if test="page != totalPage">
			<a
				href="exam/ExaminationManageAction_examManageList.action?page=<s:property value="%{page+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="page">
		</select>
		页</div>
  
  

</div>


</body>
</html>
