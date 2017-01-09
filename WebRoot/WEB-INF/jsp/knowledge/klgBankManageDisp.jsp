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
    
    <title>知识库管理Disp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="resource/css/common/common.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klg.css" rel="stylesheet" type="text/css" />
    <link href="resource/css/knowledge/klgBankManageDisp.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resource/js/knowledge/klgBankManageDisp.js"></script>
   

  </head>
  
<body>

<div class="mainDiv">


<div class="panel_main">
  <div class="title_main"><span class="span_item"><s:a action="KnowledgeBankManageAction_knowledgeBankManageList">知识库</s:a>>>

 <s:if test="klgType=='tpc'">典型案例</s:if>
  <s:if test="klgType=='tpv'">典型违章</s:if>
   <s:if test="klgType=='tpe'">操作经验</s:if>
  </span></div>
  <div class="content_margin">
    <table class="table">
    
      <!-- 典型案例 -->
    <s:if test="klgType=='klg_typicalCase'">
    <tr><td></td><td>标题</td><td>上传日期</td><td>操作</td></tr>
    <s:iterator value="typeContent" status="st">
     <tr>
        <td><s:property value="#st.index+1"/></td>
        <s:if test="typeContent[#st.index][1].length()>30">
         <td><s:a action="KnowledgeBankManageAction_klgEditUi?klgType=%{klgType}&klgId=%{typeContent[#st.index][0]}"> 
        <s:property value="typeContent[#st.index][1]"/>....</s:a></td>
        </s:if>
       <s:else>
        <td><s:a action="KnowledgeBankManageAction_klgEditUi?klgType=%{klgType}&klgId=%{typeContent[#st.index][0]}"> 
        <s:property value="typeContent[#st.index][1]"/></s:a></td>
       </s:else>
        
         <td><s:property value="typeContent[#st.index][4]"/></td><td><s:a action="KnowledgeBankManageAction_klgDelete?klgType=%{klgType}&klgId=%{typeContent[#st.index][0]}">删除</s:a></td>
      </tr>
    </s:iterator>
    </s:if>
    
    <!-- 典型违章 -->
        <s:if test="klgType=='klg_typicalViolation'">
         <tr><td></td><td>违章内容</td><td>上传日期</td><td>类型</td><td></td></tr>
    <s:iterator value="typeContent" status="st">
     <tr>
        <td><s:property value="#st.index+1"/></td>
        <td>
        
        <s:if test="typeContent[#st.index][3]!=null&typeContent[#st.index][3].length()>30">
         <s:a action="KnowledgeBankManageAction_klgEditUi?klgType=%{klgType}&klgId=%{typeContent[#st.index][0]}">
            <s:property value="typeContent[#st.index][3].substring(0,30)"/>....
         </s:a>
        </s:if>
        <s:else>
         <s:a action="KnowledgeBankManageAction_klgEditUi?klgType=%{klgType}&klgId=%{typeContent[#st.index][0]}">
         <s:property value="typeContent[#st.index][3]"/>

         </s:a>
        </s:else>
        
    
        </td>
         <td><s:property value="typeContent[#st.index][4]"/></td>
          <td><s:property value="typeContent[#st.index][6]"/>
          <s:a action="KnowledgeBankManageAction_klgDelete?klgType=%{klgType}&klgId=%{typeContent[#st.index][0]}">删除</s:a></td>
      </tr>
    </s:iterator>
    </s:if>
    
    <!-- 操作经验 -->
        <s:if test="klgType=='klg_experience'">
         <tr><td></td><td>标题</td><td>上传日期</td><td>审核</td><td></td></tr>
    <s:iterator value="typeContent" status="st">
     <tr>
        <td><s:property value="#st.index+1"/></td>
        <s:if test="typeContent[#st.index][1].length()>30">
        <td><s:a action="KnowledgeBankManageAction_klgEditUi?klgType=%{klgType}&klgId=%{typeContent[#st.index][0]}">
        <s:property value="typeContent[#st.index][1].substring(0,30)"/>....</s:a>
        </td>
        </s:if>
       <s:else>
        <td><s:a action="KnowledgeBankManageAction_klgEditUi?klgType=%{klgType}&klgId=%{typeContent[#st.index][0]}">
        <s:property value="typeContent[#st.index][1]"/></s:a>
        </td>
       </s:else>
          <td><s:property value="typeContent[#st.index][4]"/></td>
            <td><s:property value="typeContent[#st.index][2]"/></td>
                  <td><s:a action="KnowledgeBankManageAction_klgDelete?klgType=%{klgType}&klgId=%{typeContent[#st.index][0]}">删除</s:a></td>
      </tr>
    </s:iterator>
    </s:if>
    </table>
  </div>
</div>

<div id="paginate" class="viewdetail">分页插件</div>
</div>

</body>
</html>