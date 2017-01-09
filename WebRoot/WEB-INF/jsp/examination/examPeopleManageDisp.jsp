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
    
    <title>考试抽人</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/examination/exam.css">
    <link rel="stylesheet" type="text/css" href="resource/css/examination/examPeopleManageDisp.css">
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/examination/examPeople.js"></script>

<STYLE type="text/css">
#dep_choice{
width:1150px;
height:550px
border:1px solid #80858C
}

td{
border:1px solid #005E5E;
width:100px;
height:30px;
}
</STYLE>
  </head>
  
  <body>

<div class="mainDiv">
  <div class="panel_main">
    <div class="title_main"><span class="span_item">模拟考试/培训考核选人</span></div>
 
  
     
      <div id="header">
      <ul>
        <li id="no1">部门选择</li>
        <li id="no2">员工选择</li>
        <li id="no3">生成名单</li>
      </ul>
    </div>
   
    <div class="content_margin">
        
    <!-- 部门选择 -->
    <div id="dep_choice">
      <div id="company">
        <div>考试名称:<s:select list="testInfos" id="exm_name" listKey="id" listValue="testName" name="testInfoId"></s:select>  </div>
        <div>在以下单位中抽取员工参加考试：<input type="checkbox" onClick="selectAll(this)"/>全选</div>
        <s:iterator value="topDepartmentList">
           <div> 
             <!-- 一级部门列表 -->
             <div id="parent_dep">
         <span class="span_item"><input type="checkbox" class="department"  id="cb_${id}" name="departmentIds" value="${id}" onClick="parentChoice($(this))"  />${name}</span>
          </div>
          <!-- 二级部门列表 -->
                <div id="child_dep">
         <s:iterator value="childrenDepartment">
           <span class="span_item"><input type="checkbox" class="department" id="cb_${id}" name="departmentIds" value="${id}" onClick="childChoice($(this))"  />${name}</span>
         </s:iterator>
          </div>
        </div>
        </s:iterator>
    
      </div>
      <div id="con"> 
      <div id="num">考试总人数：<input type="text" id="count" /></div>
       <div id="dep_worker_all"><font color="#FF0000">当前已选择部门的总人数：<span id="select_sum">0</span>人</font></div>
      </div>
        <div id="confirm"><input type="button" value="下一步"  onclick="worker_choice()" /></div>
      </div>
      
       <!-- 员工选择：随机+手动 -->
      <div id="namelist_all" class="panel_sub" style="display: none;">
        <div class="title_sub"><span class="span_item">可供选择的员工</span></div>
        <div class="content_margin">          
         <div> 
           <div id="dep_worker" class="left"> 
           </div>
           <div class="content_margin right">
             <div><font color="#FF0000">您设定的考试总人数是：<span id="select_count"></span>人；当前已选择：<span id="selected_count"></span>人。</div>
           </div>
         </div>
        <div><input type="button" value="上一步" onclick="preStep()"/></div>
          <div id="btn_random"><input type="button" id="name_btn" value="生成名单" onclick="create_name_list()" /></div>
        </div>
      </div>
      
      <!-- 名单预览 -->
      <div id="create_namelist" style="display:none;">
      <table>
    </table>
    <div onclick="export_names()" style="cursor:hand;width:100px;height:20px;margin-left:900px;">导出名单 </div>
      </div>
      
  </div>
  
</div>

<div id="exit" style="display:none;"><s:a action="exam/ExaminationManageAction_examManageList">退出</s:a></div>
</div>

  </body>
</html>
