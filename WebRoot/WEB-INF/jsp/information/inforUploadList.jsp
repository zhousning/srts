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
		<title>下载中心</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css"
			href="resource/css/common/common.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/information/info.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/information/inforUploadList.css">

		<script type="text/javascript"
			src="resource/js/information/inforUploadList.js">
</script>

	</head>
	<body>
		<div class="mainDiv">
			<div class="panel_main">
				<div class="title_main">
					<span class="span_item">下载中心</span>
				</div>
				<div>

					<div class="panel_sub panel_download">
						<div class="title_sub">
							<span class="span_item">文档下载</span>
						</div>
						<div class="content_margin">
							<div>
								<table class="table">
									<thead>
										<tr>
											<th>
												<span class="span_item">序号</span>
											</th>
											<th>
												<span class="span_item">文档名称</span>
											</th>
											<th>
												<span class="span_item">上传时间</span>
											</th>
											<th>
												<span class="span_item">上传作者</span>
											</th>
											<th>
												<span class="span_item">下载次数</span>
											</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="ppts" status="st">
											<tr height="25">
												<td>
													<s:property value='#st.index+1' />
												</td>
												<td>
													<a
														href="info/InformationUploadAction_downloadPPT.action?id=${id }">${pptName}</a>
												</td>
												<td>
													${uploadDate}
													<br>
												</td>
												<td>
													${uploadUsr}
												</td>
												<td>
													${loadCount}
												</td>
											</tr>

										</s:iterator>
									</tbody>
								</table>
							</div>
							<div class="viewdetail">
								<a
									href="info/InformationUploadAction_downloadPPTByPage.action?page=1">＞＞点击查看更多</a>
							</div>
						</div>
					</div>

					<div class="panel_sub panel_download">
						<div class="title_sub">
							<span class="span_item">教学视频下载</span>
						</div>
						<div class="content_margin">
							<div>
								<table class="table">
									<thead>
										<tr>
											<th>
												<span class="span_item">序号</span>
											</th>
											<th>
												<span class="span_item">视频名称</span>
											</th>
											<th>
												<span class="span_item">上传时间</span>
											</th>
											<th>
												<span class="span_item">上传作者</span>
											</th>
											<th>
												<span class="span_item">下载次数</span>
											</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="videos" status="st">
											<tr height="25">
												<td>
													<s:property value='#st.index+1' />
												</td>
												<td>
													<a
														href="info/InformationUploadAction_downloadVideo.action?id=${id }">${videoName}</a>
												</td>
												<td>
													${uploadDate}
													<br>
												</td>
												<td>
													${uploadUsr}
												</td>
												<td>
													${loadCount}
												</td>
											</tr>

										</s:iterator>
									</tbody>
								</table>
							</div>
							<div class="viewdetail">
								<a
									href="info/InformationUploadAction_downloadVideoByPage.action?page=1">＞＞点击查看更多</a>
							</div>
						</div>
					</div><%--

					<div class="panel_sub panel_download">
						<div class="title_sub">
							<span class="span_item">学习资料下载</span>
						</div>
						<div class="content_margin">
							<div>
								<table class="table">
									<thead>
										<tr>
											<th>
												<span class="span_item">序号</span>
											</th>
											<th>
												<span class="span_item">资料名称</span>
											</th>
											<th>
												<span class="span_item">上传时间</span>
											</th>
											<th>
												<span class="span_item">上传作者</span>
											</th>
											<th>
												<span class="span_item">下载次数</span>
											</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="books" status="st">
											<tr height="25">
												<td>
													<s:property value='#st.index+1' />
												</td>
												<td>
													<a
														href="info/InformationUploadAction_downloadBook.action?id=${id }">
														${bookName}</a>
												</td>
												<td>
													${date}
													<br>
												</td>
												<td>
													${uploadUsr}
												</td>
												<td>
													${loadCount}
												</td>
											</tr>

										</s:iterator>
									</tbody>
								</table>
							</div>
							<div class="viewdetail">
								<a
									href="info/InformationUploadAction_downloadBookByPage.action?page=1">＞＞点击查看更多</a>
							</div>
						</div>
					</div>

					<div class="panel_sub panel_download">
						<div class="title_sub">
							<span class="span_item">其他下载</span>
						</div>
						<div class="content_margin">
							<div>
								<table class="table">
									<thead>
										<tr>
											<th>
												<span class="span_item">序号</span>
											</th>
											<th>
												<span class="span_item">通知名称</span>
											</th>
											<th>
												<span class="span_item">上传时间</span>
											</th>
											<th>
												<span class="span_item">上传作者</span>
											</th>
											<th>
												<span class="span_item">下载次数</span>
											</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="notices" status="st">
											<tr height="25">
												<td>
													<s:property value='#st.index+1' />
												</td>
												<td>
													<a
														href="info/InformationUploadAction_downloadNotice.action?id=${id }">
														${noticeTitle}</a>
												</td>
												<td>
													${establishDate}
													<br>
												</td>
												<td>
													${user.username}
												</td>
												<td>
													${loadCount}
												</td>
											</tr>

										</s:iterator>
									</tbody>
								</table>
							</div>
							<div class="viewdetail">
								<a
									href="info/InformationUploadAction_downloadNoticeByPage.action?page=1">＞＞点击查看更多</a>
							</div>
						</div>
					</div>--%>

					<div class="filling"></div>
				</div>
			</div>
		</div>
	</body>
</html>
