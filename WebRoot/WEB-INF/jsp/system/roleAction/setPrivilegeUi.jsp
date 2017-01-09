<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		
	

		<script type="text/javascript">
$(function() {
 
	$("#Form").treeview();

			<s:iterator value="privilegeIds" var="privilegeId">
			$("[name=privilegeIds][value=${privilegeId}]").attr("checked",true);
			</s:iterator>
			
			//为所有的权限复选框绑定一个权限处理函数，用于处理点击时选中或取消上下级的效果
			$("input[type=checkbox][name=privilegeIds]").click(function(){
				var check=this.checked;
				//下级一同被选中或取消
		$(this).siblings("ul").find("[name=privilegeIds]").attr("checked",check);
				//上级一同被选中或取消
				if(check){
					//选项被选中，该选项的上一级与上上级都应被选中
					$(this).parents("li").children("input[type=checkbox][name=privilegeIds]").attr("checked",true);
				}else{
					//如果只剩最后一个选项被撤销，其上级与上上级都应被撤销
					if($(this).parent("li").siblings("li").children("input[type=checkbox][name=privilegeIds]:checked").size()==0){
						$(this).parent("li").parent("ul").parent("li").children("input[type=checkbox][name=privilegeIds]").attr("checked",false);
					
						if($(this).parent("li").parent("ul").parent("li").siblings("li").children("input[type=checkbox][name=privilegeIds]:checked").size()==0){
							$(this).parent("li").parent("ul").parent("li").parent("ul").siblings("input[type=checkbox][name=privilegeIds]").attr("checked",false);
						}
					}
				}	
			});
			
});
</script>

	</head>

	<body>

<div class="panel_main">
 <div class="title_main">权限列表</div>

		<s:form action="roleAction_setPrivilege" id="Form" theme="simple">

			<s:hidden name="roleId" value="%{roleId}"></s:hidden>

			<!-- 显示所有的权限复选框privilegeList -->
		
			<!-- 在action中准备的privilegeList是顶级列表 -->
		<ul class="filetree">
				<s:iterator value="privilegeList">
					<li>		
					<input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}"/>
					<label for="cb_${id}"><span class="folder">${name }</span></label>
						<!-- 显示二级菜单 -->
						<ul>
							<s:iterator value="children">
								<li>
										<input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}">
					<label for="cb_${id}"><span class="folder">${name }</span></label>
									<!-- 显示三级菜单 -->
									<ul>
										<s:iterator value="children">
											<li>
											<input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}">
					<label for="cb_${id}"><span class="folder">${name }</span></label>
											</li>
										</s:iterator>
									</ul>
								</li>
							</s:iterator>
						</ul>
					</li>
				</s:iterator>
			</ul>
			<s:submit value="提交"></s:submit>
		</s:form>
		</div>
		</div>
	</body>
</html>
