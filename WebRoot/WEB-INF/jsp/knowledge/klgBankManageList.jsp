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
    
    <title>知识库</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klg.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klgBankManageList.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resource/js/knowledge/klgBankManageList.js"></script>
   

  </head>
  
<body>

<div class="mainDiv">


  <!-- 选择类型上传 -->
  <div id="upload" class="panel_main">
    <div class="title_main"><span class="span_item">上传知识库条目</span></div>
    <div class="content_margin">
      <div>选择类目：
      <s:select list="#{'tpc':'典型案例','tpv':'典型违章','tpe':'操作经验'}" name="klgType" id="klg"></s:select>
        <img src="resource/image/knowledge/btn_upload.png"  onclick="link_upLoad()" style="cursor:hand"/>
      </div>
    </div>
  </div>

  <!-- 上传记录4类 -->

  <div class="panel_main">
    <div class="title_main"><span class="span_item">上传记录</span></div>
    
    <div class="panel_sub uploadlist">
      <div class="title_sub"><span class="span_item">典型案例</span></div>
      <div class="content_margin">
        <table class="table">
          <s:iterator value="topFiveTypicalCases"  status="st">
           <tr>
            <td><span class="span_item"> <s:property value="#st.index+1"/></span></td>
          <td><span class="span_item">
          <s:if test="null!=title&&title.length()>20">
         <s:a href="javascript:void(0)"> <s:property value="title.substring(0,20)"/>....</s:a>
          </s:if>
          <s:else>
           <s:a href="javascript:void(0)"> <s:property value="title"/></s:a>
          </s:else>
          </span></td>
          </tr>       
          </s:iterator>
        </table>
      </div>
      <div class="viewdetail"><s:a action="KnowledgeBankManageAction_knowledgeBankManageDisp?klgType=tpc">更多...</s:a></div>
    </div>
    
    <div class="panel_sub uploadlist">
      <div class="title_sub"><span class="span_item">典型违章</span></div>
      <div class="content_margin">
        <table class="table">
     <s:iterator value="topFiveTypicalViolation"  status="st">
           <tr>
            <td><span class="span_item"> <s:property value="#st.index+1"/></span></td>
          <td><span class="span_item">
          <s:if test="null!=content&&content.length()>20">
          <s:a href="javascript:void(0)">  <s:property value="content.substring(0,20)"/>.....</s:a>
          </s:if>
          <s:else>
         <s:a href="javascript:void(0)">${content}</s:a>
          </s:else>
          </span></td>
          </tr>       
          </s:iterator>
        </table>
      </div>
      <div class="viewdetail"><s:a action="KnowledgeBankManageAction_knowledgeBankManageDisp?klgType=tpv">更多...</s:a></div>
    </div>
    
    <div class="panel_sub uploadlist">
      <div class="title_sub"><span class="span_item">操作经验</span></div>
      <div class="content_margin">
        <table class="table">
   <s:iterator value="topFiveExperiences"  status="st">
           <tr>
            <td><span class="span_item"> <s:property value="#st.index+1"/></span></td>
          <td><span class="span_item">
          <s:if test="null!=content&&content.length()>20">
          <s:a href="javascript:void(0)" >  <s:property value="content.substring(0,20)"/>.....</s:a>
          </s:if>
          <s:else>
           <s:a href="javascript:void(0)"> <s:property value="content"/></s:a>
          </s:else>
          
          </span></td>
          </tr>       
          </s:iterator>
        </table>
      </div>
      <div class="viewdetail"><s:a action="KnowledgeBankManageAction_knowledgeBankManageDisp?klgType=tpe">更多...</s:a></div>
    </div>
    
    <div class="filling">&nbsp;</div>
  </div>

</div>
</body>

</html>