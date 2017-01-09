<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
    <link rel="stylesheet" type="text/css" href="resource/css/controlPanel/self.css">
    <link rel="stylesheet" type="text/css" href="resource/css/controlPanel/personalInfoList.css">
    <script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resource/js/controlPanel/personalInfoList.js"></script>
    <script type="text/javascript">
window.onload = function() {
	initPage();
	initMessage();
}
</script>

  </head>
  
  <body>

<div class="mainDiv">


<!-- 上方跳转快捷通道 -->
<div class="panel_main">
  <div class="title_main">快捷通道</div>
  <div class="content_margin">
    <span class="span_item"><a href="javascript:goUrlSelfInfoAndNotice()">个人信息和通知</a></span>
    <span class="span_item"><a href="javascript:goUrlSelfTestAndComp()">考试和竞技问答</a></span>
    <span class="span_item"><a href="javascript:goUrlSelfCourseAndFavor()">课程和推荐课程</a></span>
    <span class="span_item"><a href="javascript:goUrlSelfExeTrace()">我的练习痕迹</a></span>
    <span class="span_item"><a href="javascript:goUrlSelfKnowledgeBank()">我的知识库</a></span>
    <span class="span_item"><a href="javascript:goUrlSelfCommunication()">我的学习交流</a></span>
    <span class="span_item"><a href="javascript:goUrlSelfEstimation()">我的学习总评</a></span>
  </div>
</div>


<!-- 个人信息和通知 -->
<div class="panel_main" id="selfInfoAndNotice">
  
  <div class="panel_sub" id="selfInfo">
    <div class="title_sub">个人信息</div>
    <div id="selfInfo_pic" class="content_margin">这里放一张类似证件照的图片</div>
    <div id="selfInfo_info" class="content_margin">
      <table class="table">
        <tr><th><span class="span_item">姓名</span></th><td>${usr.name}</td></tr>
        <tr><th><span class="span_item">性别</span></th>
        <td>${usr.sex}</td></tr>
        <tr><th><span class="span_item">年龄</span></th><td>${usr.age}</td></tr>
        <tr><th><span class="span_item">工号</span></th><td>${usr.workno}</td></tr>
        <tr><th><span class="span_item">单位</span></th><td>${usr.company}</td></tr>
        <tr><th><span class="span_item">部门</span></th><td>${usr.department.name}</td></tr>
      </table>
    </div>
  </div>
  
  <div class="panel_sub" id="selfNotice">
    <div class="title_sub">我的通知（只显示和我有关的通知）</div>
    <div class="content_margin">
							<table class="table">
								<tr>
									<th>
										序号
									</th>
									<th>
										类型
									</th>
									<th>
										标题
									</th>
									<th>
										内容
									</th>
								</tr>
								<s:iterator value="selectNoticeByUser"
									id="sNBU" status="st">
									<tr id="sNBU_${sNBU.id}">
										<td>
											${sNBU.id}
										</td>
										<td>
											${sNBU.type}
										</td>
										<td>
											${sNBU.title}
										</td>
										<td>
											${sNBU.content}
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
  </div>
  
  <div class="filling">&nbsp;</div>
</div>


<!-- 考试 -->
<div class="panel_main" id="selfTestAndComp">
  <div class="panel_sub" id="selfExam">
    <div class="title_sub">我的培训考核</div>
    <div class="content_margin">
							<table class="table">
								<tr>
									<th>
										考试时间
									</th>
									<th>
										考试内容
									</th>
									<th>
										考试成绩
									</th>
									<th>
										组织单位
									</th>
									<th>
										备注
									</th>
								</tr>
								<s:iterator value="selectTrainTestInfoByUser"
									id="sTTIU" status="st">
									<tr id="sTTIU_${sTTIU.id}">
										<td>
											${sTTIU.testDate}
										</td>
										<td>
											${sTTIU.testContent}
										</td>
										<td>
											${sTTIU.grade}
										</td>
										<td>
											${sTTIU.testCompany}
										</td>
										<td>
											${sTTIU.tips}
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
						<div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList" id="pageList">
									<li class="active" value="${pageList}">
										<a onclick="turnToPageN($(this))">${pageList}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo" recordAmount="${resNum}" pageNum="${pageNum}"></div>
						</div>
  </div>
  <div class="panel_sub" id="selfTest">
    <div class="title_sub">我的模拟考试</div>
     <div class="content_margin">
							<table class="table">
								<tr>
									<th>
										考试时间
									</th>
									<th>
										考试内容
									</th>
									<th>
										考试成绩
									</th>
									<th>
										组织单位
									</th>
									<th>
										备注
									</th>
								</tr>
								<s:iterator value="selectMockTestInfoByUser"
									id="sMTIU" status="st">
									<tr id="sMTIU_${sTTIU.id}">
										<td>
											${sMTIU.testDate}
										</td>
										<td>
											${sMTIU.testContent}
										</td>
										<td>
											${sMTIU.grade}
										</td>
										<td>
											${sMTIU.testCompany}
										</td>
										<td>
											${sMTIU.tips}
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
						<div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList1" id="pageList1">
									<li class="active" value="${pageList1}">
										<a onclick="turnToPageN1($(this))">${pageList1}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo1" recordAmount="${resNum1}"
								pageNum="${pageNum1}"></div>
						</div>
  </div>
  <div class="panel_sub" id="selfGame">
    <div class="title_sub">我的竞技问答</div>
    <div class="content_margin">
							<table class="table">
								<tr>
									<th>
										竞技问答时间
									</th>
									<th>
										竞技问答成绩
									</th>
									<th>
										竞技问答用时
									</th>
								</tr>
								<s:iterator value="selectCompetitionInfoByUser"
									id="sCIBU" status="st">
									<tr id="sCIBU_${sCIBU.id}">
										<td>
											${sCIBU.date}
										</td>
										<td>
											${sCIBU.grade}
										</td>
										<td>
											${sCIBU.time}
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
						<div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList2" id="pageList2">
									<li class="active" value="${pageList2}">
										<a onclick="turnToPageN2($(this))">${pageList2}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo2" recordAmount="${resNum2}"
								pageNum="${pageNum2}"></div>
						</div>
  </div>
  
  <div class="filling">&nbsp;</div>
</div>


<!-- 左右栏：我的课程/推荐课程 -->
<div class="panel_main" id="selfCourseAndFavor">

  <div class="panel_sub" id="selfCourse">
    <div class="title_sub">我的课程</div>
     <div class="content_margin">
							<table class="table">
								<tr>
									<th>
										正在学习的课程
									</th>
									<th>
										学习时长
									</th>
									<th>
										最后阅读时间
									</th>
								</tr>
								<s:iterator value="selectCourseInfoByUser"
									id="sCOUIBU" status="st">
									<tr id="sCOUIBU_${sCOUIBU.id}">
										<td>
											${sCOUIBU.studyContent}
										</td>
										<td>
											${sCOUIBU.studyTime}
										</td>
										<td>
											${sCOUIBU.lastStudyDate}
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
						<div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList3" id="pageList3">
									<li class="active" value="${pageList3}">
										<a onclick="turnToPageN3($(this))">${pageList3}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo3" recordAmount="${resNum3}"
								pageNum="${pageNum3}"></div>
						</div>
  </div>
  
  <div class="panel_sub" id="hotCourse">
    <div class="title_sub">推荐课程</div>
    <div class="content_margin">
    <table class="table">
								<tr>
									<th>
										书本名
									</th>
									<th>
										浏览量
									</th>
								</tr>
								<s:iterator value="selectFavorCourse"
									id="sFC" status="st">
									<tr id="sFC_${sFC.id}">
										<td>
											${sFC.bookName}
										</td>
										<td>
										<font color="#FF0000">
											${sFC.viewCount}
											</font>
										</td>
									</tr>
								</s:iterator>
							</table>
    </div>
  </div>
  
  <div class="filling">&nbsp;</div>
</div>


<!-- 学习痕迹 -->
<div class="panel_main" id="selfExeTrace">
  <div class="title_main">我的练习痕迹</div>
  
  <div class="panel_sub" id="history1">
    <div class="title_sub">练习记录（折叠标签页）</div>
     <div class="content_margin">
							<table class="table">
								<tr>
									<th>
										练习名称
									</th>
									<th>
										练习日期
									</th>
									<th>
										练习准确率
									</th>
								</tr>
								<s:iterator value="selectExerciseInfoByUser"
									id="sEIBU" status="st">
									<tr id="sEIBU_${sEIBU.id}">
										<td>
											${sEIBU.exerciseName}
										</td>
										<td>
											${sEIBU.exerciseDate}
										</td>
										<td>
											${sEIBU.exerciseAcur}
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
						<div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList4" id="pageList4">
									<li class="active" value="${pageList4}">
										<a onclick="turnToPageN4($(this))">${pageList4}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo4" recordAmount="${resNum4}"
								pageNum="${pageNum4}"></div>
						</div>
  </div>
  
  </div>
  
  <div class="filling">&nbsp;</div>
</div>


<!-- 左右栏：我的知识库/推荐知识 -->
<div class="panel_main" id="selfKnowledgeBank">
  <div class="title_main">知识库</div>

  <div class="panel_sub" id="selfKlgBank">
    <div class="title_sub">我的知识库</div>
    <div class="content_margin">
    <table class="table">
								<tr>
									<th>
										操作日期
									</th>
									<th>
										信息类型
									</th>
									<th>
										知识库内容
									</th>
								</tr>
								<s:iterator value="selectKlgBankInfoByUser"
									id="sKBIBU" status="st">
									<tr id="sKBIBU_${sKBIBU.id}">
										<td>
											${sKBIBU.klgDate}
										</td>
										<td>
											上传了<font color="#FF0000">${sKBIBU.type}</font>
										</td>
										<td>
											${sKBIBU.klgContent}
										</td>
									</tr>
								</s:iterator>
							</table>
    </div>
    <div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList5" id="pageList5">
									<li class="active" value="${pageList5}">
										<a onclick="turnToPageN5($(this))">${pageList5}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo5" recordAmount="${resNum5}"
								pageNum="${pageNum5}"></div>
						</div>
  </div>
  
  <div class="panel_sub" id="hotKlgBank">
    <div class="title_sub">推荐知识条目</div>
    <div class="content_margin">
    <table class="table">
								<tr>
									<th>
										知识类型
									</th>
									<th>
										标题
									</th>
									<th>
										浏览量
									</th>
								</tr>
								<s:iterator value="selectFavorKlgBank"
									id="sFKB" status="st">
									<tr id="${sFKB }">
										<td>
											<font color="#FF0000">${sFKB.type}</font>
										</td>
										<td>
											${sFKB.title}
										</td>
										<td>
											${sFKB.viewCount}
										</td>
									</tr>
								</s:iterator>
							</table>
    </div>
  </div>
  
  <div class="filling">&nbsp;</div>
</div>


<!-- 左右栏：我的问答/推荐问答 我的主题/推荐主题 -->
<div class="panel_main" id="selfCommunication">
  <div class="title_main">交流</div>

  <div class="panel_sub" id="selfQA">
    <div class="title_sub">我的问题</div>
    <div class="content_margin">
    <table class="table">
								<tr>
									<th>
										提问日期
									</th>
									<th>
										提问内容
									</th>
									<th>
										回复数目
									</th>
								</tr>
								<s:iterator value="selectProblemInfoByUser"
									id="sPIBU" status="st">
									<tr id="sPIBU_${sPIBU.id}">
										<td>
											${sPIBU.proDate}
										</td>
										<td>
											${sPIBU.proContent}
										</td>
										<td>
											${sPIBU.proAnsCount}
										</td>
									</tr>
								</s:iterator>
							</table>
    </div>
    <div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList6" id="pageList6">
									<li class="active" value="${pageList6}">
										<a onclick="turnToPageN6($(this))">${pageList6}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo6" recordAmount="${resNum6}"
								pageNum="${pageNum6}"></div>
						</div>
  </div>
  
  <div class="panel_sub" id="hotQA">
    <div class="title_sub">我的问答</div>
    <div class="content_margin">
    <table class="table">
								<tr>
									<th>
										回复日期
									</th>
									<th>
										回复内容
									</th>
								</tr>
								<s:iterator value="selectAnswerInfoByUser"
									id="sAIBU" status="st">
									<tr id="sAIBU_${sAIBU.id}">
										<td>
											${sAIBU.answerDate}
										</td>
										<td>
											${sAIBU.answerContent}
										</td>
									</tr>
								</s:iterator>
							</table>
    </div>
    <div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList7" id="pageList7">
									<li class="active" value="${pageList7}">
										<a onclick="turnToPageN7($(this))">${pageList7}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo7" recordAmount="${resNum7}"
								pageNum="${pageNum7}"></div>
						</div>
  </div>
  
  <div class="panel_sub" id="selfTopic">
    <div class="title_sub">我的主题</div>
    <div class="content_margin">
    <table class="table">
								<tr>
									<th>
										发表日期
									</th>
									<th>
										标题
									</th>
									<th>
										发表人
									</th>
									<th>
										回复数目
									</th>
								</tr>
								<s:iterator value="selectThemeByUser"
									id="sTBU" status="st">
									<tr id="sTBU_${sTBU.id}">
										<td>
											${sTBU.articleDate}
										</td>
										<td>
											${sTBU.articleTitle}
										</td>
										<td>
											${sTBU.userName}
										</td>
										<td>
											${sTBU.replyCount}
										</td>
									</tr>
								</s:iterator>
							</table>
    </div>
    <div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList8" id="pageList8">
									<li class="active" value="${pageList8}">
										<a onclick="turnToPageN8($(this))">${pageList8}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo8" recordAmount="${resNum8}"
								pageNum="${pageNum8}"></div>
						</div>
  </div>
  
  <div class="panel_sub" id="hotTopic">
    <div class="title_sub">推荐主题</div>
    <div class="content_margin">
     <table class="table">
								<tr>
									<th>
										发表日期
									</th>
									<th>
										标题
									</th>
									<th>
										发表人
									</th>
									<th>
										回复数目
									</th>
								</tr>
								<s:iterator value="selectFavorThemeByUser"
									id="sFTBU" status="st">
									<tr id="sFTBU_${sFTBU.id}">
										<td>
											${sFTBU.articleDate}
										</td>
										<td>
											${sFTBU.articleTitle}
										</td>
										<td>
											${sFTBU.userName}
										</td>
										<td>
											${sFTBU.replyCount}
										</td>
									</tr>
								</s:iterator>
							</table>
    </div>
  </div>
  
  <div class="filling">&nbsp;</div>
</div>


<!-- 评估 -->
<div class="panel_main" id="selfEstimation">
  <div class="title_main">我的评估</div>
  <div class="content_margin">
  ${setEstInfo.content}
  </div>
</div>

  </body>
</html>
