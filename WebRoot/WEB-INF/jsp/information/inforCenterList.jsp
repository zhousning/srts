<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

		<title>通知中心</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css"
			href="resource/css/common/common.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/common/paginate.css" media="screen">
		<link rel="stylesheet" type="text/css"
			href="resource/css/information/info.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/information/inforCenterList.css">
		<script type="text/javascript"
			src="resource/script/jquery/jquery.min.js">
</script>
		<script type="text/javascript"
			src="resource/js/information/inforCenterList.js">
</script>
		<script src="resource/js/learning/jquery.paginate.js"
			type="text/javascript">
</script>
		<script type="text/javascript">
$(function(){
		for(var i=1; i<=${size}; i++){
			$("#page").append("<option value="+i+">"+i+"</option>"); 
		}
		$("#page").val(${page}); //设置select的value为${page}的项选中 
		$("#page").change(function(){
			window.location="info/InformationCenterAction_queryByPage.action?page="+$("#page").val();
		});
	});
</script>
		<style type="text/css">
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
	</head>

	<body>



		<div class="mainDiv">

			<!--  通知公告列表   -->
			<div class="panel_main">
				<div class="title_main">
					<span class="span_item"> 通知列表 </span>

				</div>
				<div class="content_margin">
					<table width="90%" class="table">
						<thead>
							<tr>
								<th style="width: 5%;">
									序号
								</th>
								<th style="width: 40%;">
									名称
								</th>
								<th style="width: 15%;">
									类型
								</th>
								<th style="width: 15%;">
									时间
								</th>
								<th style="width: 15%;">
									发布者
								</th>
							</tr>
						</thead>
						<tbody id="self_add">
							<s:iterator value="pageBean.list" status="stt">
								<tr>
									<td>
										<s:property value="#stt.index+1" />
									</td>
									<td id="number">
										<a
											href="info/InformationCenterAction_informationCenterDisp?id=${id}">${noticeTitle
											}</a>
									</td>
									<td>
										${noticeType }
									</td>
									<td>
										${establishDate }
									</td>
									<td>
										${user.username}
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<!--  分页显示   -->

					<div align="center">
						共
						<s:property value="pageBean.allRow" />
						条 共
						<s:property value="pageBean.totalPage" />
						页 第
						<s:property value="pageBean.currentPage" />
						页
						<s:if test="%{pageBean.currentPage == 1}">上一页</s:if>
						<s:else>
							<a
								href="info/InformationCenterAction_queryByPage.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
						</s:else>
						<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
							<a
								href="info/InformationCenterAction_queryByPage.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
						</s:if>
						<s:else>下一页 </s:else>
						跳转到第
						<select name="" id="page">
						</select>
						页
					</div>

				</div>

			</div>
		</div>

	</body>
</html>
