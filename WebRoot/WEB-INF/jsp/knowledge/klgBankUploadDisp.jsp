<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>




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
    
    <title>知识上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
    <link href="resource/css/knowledge/klg.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klgBankUploadDisp.css" rel="stylesheet" type="text/css" />


    <script type="text/javascript" src="resource/js/knowledge/klgBankManageList.js"></script>

    
  </head>
  
<body>

  <div class="mainDiv">
  
    <div class="panel_sub">
    
      <div class="title_sub">
      <span class="span_item"> 
      <s:a action="KnowledgeBankManageAction_knowledgeBankManageList">返回</s:a>>>
      <s:if test="klgType=='tpc'"> 
      典型案例上传
      </s:if>
      
      <s:if test="klgType=='tpv'">
       典型违章上传
      </s:if>
      
      <s:if test="klgType=='tpe'">
      操作经验上传
      </s:if>
      
      </span></div>
  
      <div class="content_margin">
      
      <!-- 典型案例上传 -->
      <s:if test="klgType=='tpc'">
      
      <s:form action="KnowledgeBankManageAction_upload?klgType=tpc" id="formimg" method="post" enctype="multipart/form-data" theme="simple">
        <s:fielderror name="caseImg"></s:fielderror>
      <s:hidden name="klgType" value="%{klgType}"></s:hidden>
    
       <div>标题：<s:textfield name="title" id="title" ></s:textfield>     </div>
       <dv>案例内容：</dv>
        <div><s:textarea name="content" id="content" cssClass="{required:true,minlength:5}" cols="80" rows="30"></s:textarea></div>
        <div>
        <div>上传图片：</div>
        <div id="no1">
        <div>  <input type="file" name="caseImg"/> </div>
        </div>
        </div>
          <div onclick=""><input type="button" onclick="addimg()" value="继续添加"/>
        </div>
       <div><%--<img src="resource/image/knowledge/btn_submit.png" onclick="submit()"  style="cursor:hand"/>
       --%><s:submit value="上传"></s:submit>
       </div>
      </s:form>
      
      </s:if>
   
        <!-- 典型违章上传 -->
      <s:if test="klgType=='tpv'">
      <s:form action="KnowledgeBankManageAction_upload" method="post">
      <s:hidden name="klgType" value="%{klgType}"></s:hidden>
     <div> 违章类型：<s:select name="title" id="title" list="#{'bea':'行为违章','equ':'装置违章','man':'管理违章'}"></s:select></div><br/>
     <div> 违章内容:请将上传的违章内容按1.2.3...的格式分段标注</div><br/>
      <div><s:textarea name="content" id="content" cols="80" rows="30" cssClass="{required:true}"></s:textarea></div>
      <s:submit value="上传"></s:submit>
            </s:form>
      </s:if>
      
        <!-- 操作经验上传 -->
      <s:if test="klgType=='tpe'">
       <div>
      <s:form action="KnowledgeBankManageAction_upload" method="post">
       <s:hidden name="klgType" value="%{klgType}"></s:hidden>
       <s:hidden name="userId" value="%{userId}"></s:hidden>
        <div>输入操作经验：</div>
        <s:textarea cols="80" rows="8" id="title" name="title" cssClass="{required:true}"></s:textarea>
        <div>解释操作经验：</div>
        <div><s:textarea cols="80" rows="8" id="content" name="content" cssClass="{required:true}"></s:textarea></div>
       <div><s:submit value="上传"></s:submit></div>
      </s:form>
       </div>
      </s:if>
      
      
      </div>
    </div>
    
  </div>

</body>