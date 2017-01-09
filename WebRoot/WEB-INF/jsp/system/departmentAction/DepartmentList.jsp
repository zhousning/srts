<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

<%@ include file="/WEB-INF/jsp/commons/commons.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/jqueryvalidate.jsp" %>

		<title>My JSP 'DepartmentList.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="resource/css/system/departmentManList.css">
		<SCRIPT type="text/javascript" src="resource/js/system/depMan.js"></SCRIPT>
	<script type="text/javascript">
		$(function(){
			$(".filetree").treeview();
			$("#myform1").submit(function(){
				var val=$("#dep_name").val();
				if(val==null||val==""){
					alert("请填写部门")
					return false;
				}
			});
			$("#myform2").submit(function(){
				var val=$("#depName").val();
				if(val==null||val==""){
					alert("请选择一个部门")
					return false;
				}
			});
		});
	
		</script>

<STYLE type="text/css">
#dep_list{
	height:650px;
	overflow-y:scroll;
	}
</STYLE>

	</head>

	<body>
	<div class="mainDiv">
	
<div class="panel_main" id="left">
 <div class="title_main">部门列表</div>
 <div class="content_margin" id="dep_list">
 <!-- 显示一级菜单 -->
				<ul class="filetree">
					<s:iterator value="topDepList">
						<li>
							<span class="folder"  onclick="getById(${id})">${name}</span>

							<!-- 显示二级菜单 -->
							<ul>
								<s:iterator value="childrenDepartment">
									<li>
										<span class="folder" onclick="getById(${id})">${name }</span>

										<!-- 显示三级菜单 -->
										<ul>
											<s:iterator value="childrenDepartment">
												<li>
													<span class="folder" onclick="getById(${id})">${name }</span>
													<!-- 显示四级菜单 -->
										<ul>
											<s:iterator value="childrenDepartment">
												<li>
													<span class="folder" onclick="getById(${id})">${name }</span>
												</li>
											</s:iterator>
										</ul>
												</li>
											</s:iterator>
										</ul>
										
									</li>
								</s:iterator>
							</ul>
						</li>

					</s:iterator>
				</ul>
				</div>
 </div>


<div class="panel_main" id="right">
 <div class="panel_sub">
  <div class="title_sub">添加部门</div>
 <div class="content_margin">

 <s:form action="departmentAction_addDepartment" method="post" id="myform1">
 <div><span class="span_item">上级部门：<s:select name="depParentId" list="departmentList" listKey="id" listValue="name" headerKey="" headerValue="--请选择部门--"></s:select></span></div>
 <div><span class="span_item">部门名称: <s:textfield  name="depName" id="dep_name"></s:textfield></span></div>
<%--<input type="button" value="保存" onclick="add_test()">
 --%>
 <s:submit value="保存"></s:submit>
 </s:form>
 </div>
 </div>
 
  <div class="panel_sub">
 <div class="title_sub">修改部门信息</div>
  <div class="content_margin">
 
 <s:form action="departmentAction_updateDepartment" method="post" id="myform2">
 <s:hidden name="depId" id="depId"></s:hidden>
 <div><span class="span_item">上级部门：</span><s:select name="depParentId" id="upDepId" list="departmentList" listKey="id" listValue="name" headerKey="" headerValue="--请选择部门--"></s:select></div>
 <div><span class="span_item">部门名称: </span><s:textfield name="depName" id="depName" ></s:textfield></div>
<%--<input type="button" value="保存" onclick="update_dep()">
 --%>
 <s:submit value="修改"></s:submit>
 <input type="button" onclick="delete_dep()" value="删除"/>
 </s:form>
</div>
 </div>

 </div>
</div>
	</body>
</html>
