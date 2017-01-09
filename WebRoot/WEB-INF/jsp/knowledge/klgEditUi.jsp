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
    
  <%@ include file="/WEB-INF/jsp/commons/commons.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/jqueryvalidate.jsp" %>
    
    <title>EditUi</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klg.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klgEditUi.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="resource/js/knowledge/klgEditUi.js"></script>
   

  </head>
  
<body>
<div class="mainDiv">

<div class="panel_main">
  <div class="title_main"><span class="span_item"><s:a action="KnowledgeBankManageAction_knowledgeBankManageDisp?klgType=%{klgType}"> 返回 </s:a></div>
<s:form action="KnowledgeBankManageAction_klgUpdate" namespace="/kldg" method="post">

<s:hidden name="klgId" value="%{klgId}"></s:hidden>
<s:hidden name="klgType" value="%{klgType}"></s:hidden>

 
 <s:if test="klgType=='klg_typicalCase'||klgType=='klg_experience'">
 <div class="content_margin">
  <s:label for="titleId">知识标题：</s:label>
 <s:textfield name="title" id="titleId" size="40"></s:textfield>
  </div>
 </s:if>


 
 
    <div class="content_margin">
   <s:if test="klgType=='klg_typicalViolation'">
 
    <s:label  for="vioId">违章类型：</s:label>
   <s:select name="type" id="vioId"  value="%{type}"list="#{'行为违章': '行为违章', '装置违章':'装置违章','管理违章':'管理违章' }"> </s:select>
   </s:if>
   
  <s:if test="klgType=='klg_experience'">
     <s:label  for="expId">审核状态：</s:label>
     <s:select list="#{'已审核':'已审核','未审核':'未审核'}" name="type" id="expId" value="#{type}"></s:select>
  </s:if>
  </div>
  
   <div class="content_margin">
   <s:label for="contentId">知识内容：</s:label>
   <br/>
    <s:textarea name="content" id="contentId" cols="80" rows="10"></s:textarea>
  </div>

<s:if test="klgType=='klg_typicalCase'">
   
     <s:if test="pic.length>0">
     <div  class="content_margin">
     <div>附图：</div>
   <s:iterator status="st" value="pic" id="ty" >
   <s:if test="#st.index!=0">
   <div > 
    <img src="<s:property value="pic[0]" />\<s:property value="pic[#st.index]"/>" style="width: 200px;height: 200px;"/>     
    </div>
   </s:if> 
   </s:iterator>
   </div>
   </s:if>
  </s:if>
  
  <s:submit value="提交"></s:submit>

  </s:form>


</div>
</body>
</html>
