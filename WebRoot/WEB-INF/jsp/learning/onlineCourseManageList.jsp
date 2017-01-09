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
    
    <title>学习课程管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/learning/StudyCourse.css"/>
	<link rel="stylesheet" type="text/css" href="resource/css/learning/onlineCourseManageList.css"/>

	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/script/fusioncharts/js/FusionCharts.js"></script>
	<script type="text/javascript" src="resource/js/learning/onlineCourseManageList.js"></script>
 	<script type="text/javascript">
		window.onload = function(){
			initColumn();
		}
		
		$(function(){
			if(${courseType=="BOOK"}){
				onlineCourseListChangeFun($("#book"));
				for(var i=1; i<=${size}; i++){
					$("#pageBook").append("<option value="+i+">"+i+"</option>"); 
				}
				$("#pageBook").val(${page}); //设置select的value为${page}的项选中 
				$("#pageBook").change(function(){
					window.location="learning/OnlineCourseManageAction_queryByPage.action?courseType=BOOK&&page="+$("#pageBook").val();
				});
			}else if(${courseType=="PPT"}){
				onlineCourseListChangeFun($("#ppt"));
				for(var i=1; i<=${size}; i++){
					$("#pagePPT").append("<option value="+i+">"+i+"</option>"); 
				}
				$("#pagePPT").val(${page}); //设置select的value为${page}的项选中 
				$("#pagePPT").change(function(){
					window.location="learning/OnlineCourseManageAction_queryByPage.action?courseType=PPT&&page="+$("#pagePPT").val();
				});
			}else if(${courseType=="VIDEO"}){
				onlineCourseListChangeFun($("#video"));
				for(var i=1; i<=${size}; i++){
					$("#pageVideo").append("<option value="+i+">"+i+"</option>"); 
				}
				$("#pageVideo").val(${page}); //设置select的value为${page}的项选中 
				$("#pageVideo").change(function(){
					window.location="learning/OnlineCourseManageAction_queryByPage.action?courseType=VIDEO&&page="+$("#pageVideo").val();
				});
			}
	
			$("#book").click(function(){
				window.location.href="learning/OnlineCourseManageAction_queryByPage.action?courseType=BOOK&&page=1";
			});
			$("#ppt").click(function(){
				window.location.href="learning/OnlineCourseManageAction_queryByPage.action?courseType=PPT&&page=1";
			});
			$("#video").click(function(){
				window.location.href="learning/OnlineCourseManageAction_queryByPage.action?courseType=VIDEO&&page=1";
			});
			
	
			$("#checkBookAll").click(function(){
				if($(this).is(":checked")){
					$("input[name='checkbox']").each(function(){
						$(this).attr("checked",true);	
					});
				}else{
					$("input[name='checkbox']").each(function(){
						$(this).removeAttr("checked");	
					});
				}
			});
			
			$("#checkPPTAll").click(function(){
				if($(this).is(":checked")){
					$("input[name='checkbox']").each(function(){
						$(this).attr("checked",true);	
					});
				}else{
					$("input[name='checkbox']").each(function(){
						$(this).removeAttr("checked");	
					});
				}
			});
			$("#checkVideoAll").click(function(){
				if($(this).is(":checked")){
					$("input[name='checkbox']").each(function(){
						$(this).attr("checked",true);	
					});
				}else{
					$("input[name='checkbox']").each(function(){
						$(this).removeAttr("checked");	
					});
				}
			});
			
			$("#deleteType").click(function(){
				if($("input[name='checkbox']:checked").size()==0){
					alert("请选择。。。");
					return false;
				}else{
					var courseType=$("#deleteType").attr("course");
					var ids="";
					$("input[name='checkbox']").each(function(){
						if($(this).is(":checked")){
							ids=ids+$(this).val()+" ";
						}	
					});
					if(courseType=="BOOK"){
						$(this).attr("href", "learning/OnlineCourseManageAction_deleteOnlineCourse.action?courseType=BOOK&&courseIds="+ids);
					}else if(courseType=="PPT"){
						$(this).attr("href", "learning/OnlineCourseManageAction_deleteOnlineCourse.action?courseType=PPT&&courseIds="+ids);
					}else if(courseType=="VIDEO"){
						$(this).attr("href", "learning/OnlineCourseManageAction_deleteOnlineCourse.action?courseType=VIDEO&&courseIds="+ids);
					}
				}
			});
		});
	</script>
</head>
<body>
<div class="mainDiv">
    <div class="panelContainer firstpanel">
    	<div class="title_main">课程管理</div>
    	<div class="title_cld">
    		<ul class="title_ul">
    			<li><span id="book" class="title_p bk" >书籍管理</span><span class="title_c">|</span></li>
    			<li><span id="ppt" class="title_p pt" >文档管理</span><span class="title_c">|</span></li>
    			<li><span id="video" class="title_p ad" >视频管理</span><span class="title_c"></span></li>
    		</ul>
    		<span class="span_item">
    			<!--  <a href="" id="deleteType" course="BOOK">删除</a>-->
        		<a id="addType" course="BOOK" href="learning/OnlineCourseManageAction_onlineCourseManagePost?courseType=BOOK">添加</a>
   			</span>
    	</div>
		<div class="content" id="bk">
			<div class="list_div">
				<div class="list_title list_titlen">
					<div class="od"><input type="checkbox" id="checkBookAll"/></div>
					<div class="ne">书籍名称</div>
					<%--<div class="dt">章节数目</div>
					--%><div class="ne">简介</div>
					<div class="dt">上传者</div>
					<div class="dt">修改时间</div>
					<div class="dt">总浏览量</div>
					<div class="dt">操作</div>
				</div>
				<div class="list_content" id="bookInfoContent">
					<ul class="list_ul">
					<s:iterator value="pageBean.list" id="book">
						<li class="item">
							<div class="item_div item_divn">
								<div class="od"><input type="checkbox" value="${id}" name="checkbox"/></div>
								<div class="ne dtcur"><a href="learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds=${id}&courseType=BOOK">${bookName}</a></div>
								<%--<div class="dt">共&nbsp;<s:property value="chapters.size"/>&nbsp;章</div>
								--%><div class="ne dt1">${bookIntro}</div>
								<div class="dt">${uploadUsr}</div>
								<div class="dt dt1">${date}</div>
								<div class="dt">${viewCount}</div>
								<div class="dt dtcur"><a href="learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds=${id}&courseType=BOOK">修改</a></div>
							</div>
						</li>
					</s:iterator>	
					</ul>
				</div>
			</div>
			<div class="pageDiv pagination" id="bookPagination">
				<!--  分页显示   -->

									<div>共
		<s:property value="pageBean.allRow" />
		条 共
		<s:property value="pageBean.totalPage" />
		页 第
		<s:property value="pageBean.currentPage" />
		页
		<s:if test="%{pageBean.currentPage == 1}">上一页</s:if>
		<s:else>
			<a
				href="learning/OnlineCourseManageAction_queryByPage.action?courseType=BOOK&&page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
		</s:else>
		<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
			<a
				href="learning/OnlineCourseManageAction_queryByPage.action?courseType=BOOK&&page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="pageBook">
		</select>
		页</div>
			</div>
		</div>
		<div class="content" id="pt">
			<div class="list_div">
				<div class="list_title list_titlen">
					<div class="od"><input type="checkbox" id="checkPPTAll"/></div>
					<div class="ne">文档名称</div>
					<div class="ne">简介</div>
					<div class="dt">上传者</div>
					<div class="dt">修改时间</div>
					<div class="dt">总浏览量</div>
					<div class="dt">总下载量</div>
					<div class="dt">操作</div>
				</div>
				<div class="list_content" id="pptInfoContent">
				<ul class="list_ul">
				<s:iterator value="pageBean.list" id="ppt">
					<li class="item">
						<div class="item_div item_divn">
							<div class="od"><input type="checkbox" value="${id}" name="checkbox"/></div>
							<div class="ne dtcur"><a href="learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds=${id}&courseType=PPT">${pptName}</a></div>
							<div class="ne dt1">${pptIntro}</div>
							<div class="dt">${uploadUsr}</div>
							<div class="dt dt1">${uploadDate}</div>
							<div class="dt">${readCount}</div>
							<div class="dt">${loadCount}</div>
							<div class="dt dtcur"><a href="learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds=${id}&courseType=PPT">修改</a></div>
						</div>
					</li>
				</s:iterator>
				</ul>
				</div>
			</div>
			<div class="pageDiv pagination" id="pptPagination">
				<!--  分页显示   -->

									<div>共
		<s:property value="pageBean.allRow" />
		条 共
		<s:property value="pageBean.totalPage" />
		页 第
		<s:property value="pageBean.currentPage" />
		页
		<s:if test="%{pageBean.currentPage == 1}">上一页</s:if>
		<s:else>
			<a
				href="learning/OnlineCourseManageAction_queryByPage.action?courseType=PPT&&page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
		</s:else>
		<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
			<a
				href="learning/OnlineCourseManageAction_queryByPage.action?courseType=PPT&&page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="pagePPT">
		</select>
		页</div>
			</div>
		</div>
		<div class="content" id="ad">
			<div class="list_div">
				<div class="list_title list_titlen">
					<div class="od"><input type="checkbox" id="checkVideoAll"/></div>
					<div class="ne">视频名称</div>
					<div class="ne">简介</div>
					<div class="dt">上传者</div>
					<div class="dt">修改时间</div>
					<div class="dt">总浏览量</div>
					<div class="dt">总下载量</div>
					<div class="dt">操作</div>
				</div>
				<div class="list_content" id="videoInfoContent">
					<ul class="list_ul">
					<s:iterator value="pageBean.list" id="video">
						<li class="item">
							<div class="item_div item_divn">
								<div class="od"><input type="checkbox" value="${id}" name="checkbox"/></div>
								<div class="ne dtcur"><a href="learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds=${id}&courseType=VIDEO">${videoName}</a></div>
								<div class="ne dt1">${videoIntro}</div>
								<div class="dt">${uploadUsr}</div>
								<div class="dt dt1">${uploadDate}</div>
								<div class="dt">${viewCount}</div>
								<div class="dt">${loadCount}</div>
								<div class="dt dtcur"><a href="learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds=${id}&courseType=VIDEO">修改</a></div>
							</div>
						</li>
					</s:iterator>
					</ul>
				</div>
			</div>
			<div class="pageDiv pagination" id="videoPagination">
				<!--  分页显示   -->

									<div>共
		<s:property value="pageBean.allRow" />
		条 共
		<s:property value="pageBean.totalPage" />
		页 第
		<s:property value="pageBean.currentPage" />
		页
		<s:if test="%{pageBean.currentPage == 1}">上一页</s:if>
		<s:else>
			<a
				href="learning/OnlineCourseManageAction_queryByPage.action?courseType=VIDEO&&page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
		</s:else>
		<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
			<a
				href="learning/OnlineCourseManageAction_queryByPage.action?courseType=VIDEO&&page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="pageVideo">
		</select>
		页</div>
			</div>
		</div>
		<div class="filling"></div>
	</div>
  <!-- 图表与统计 -->
	<div id="statistics" class="panel_sub_main">
		<div class="title_sub_main"><span class="span_item">统计图表</span></div>
    	<div class="panel_sub graph">
			<div class="title_sub"><span class="span_item">各类课程资源统计</span></div>
      		<div class="content_margin">
				<div id="courseCountContainer"></div>
	  		</div>
    	</div>
    	<div class="panel_sub graph">
      		<div class="title_sub"><span class="span_item">课本视频浏览统计</span></div>
      		<div class="content_margin">
				<div id="courseViewCountContainer"></div>
	  		</div>
    	</div>
    	<div class="panel_sub graph">
      		<div class="title_sub"><span class="span_item">各类课程下载统计</span></div>
      		<div class="content_margin">
				<div id="courseLoadCountContainer"></div>
	  		</div>
    	</div>
    	<div class="filling"></div>
  	</div>
</div>
</body>
</html>
