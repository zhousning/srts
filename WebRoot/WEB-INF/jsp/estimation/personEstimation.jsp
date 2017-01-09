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

		<title>员工评估</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css"
			href="resource/css/common/common.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/estimation/est.css">
		<link rel="stylesheet" type="text/css"
			href="resource/css/estimation/personEstimation.css">
		<script type="text/javascript"
			src="resource/script/jquery/jquery.min.js">
</script>
		<script type="text/javascript"
			src="resource/js/estimation/personEstimation.js">
</script>
		<script type="text/javascript"
			src="resource/script/fusioncharts/js/FusionCharts.js">
</script>
		<script type="text/javascript"
			src="resource/js/estimation/DatePicker.js">
</script>
		<script type="text/javascript">
window.onload = function() {
	initChart();
	initMessage();
}
</script>

	</head>

	<body>
	

		<div class="mainDiv">
		<div id="wholeEst" class="panel_sub">
						<div class="title_sub">
							<span class="span_item">员工学习状况总评</span>
						</div>
						<div class="content_margin" id="wholeEstContainer"></div>
							<div class="title_sub">
								评价信息：
							</div>
							<div class="content_margin">
								<table class="table">
									<tr>
										<td>
											${wholeEstString}
										</td>
									</tr>
								</table>
							</div>
	</div>

			<div>
				以下3个标签页切换显示
				<a onClick="c(1)"> 在线学习评估 </a>
				<a onClick="c(2)"> 在线练习评估 </a>
				<a onClick="c(3)"> 模拟考试评估 </a>
				<a onClick="c(4)"> 调考评估 </a>
				<a onClick="c(5)"> 知识库评估 </a>
				<a onClick="c(6)"> 交流评估 </a>
			</div>


			<!-- 在线学习评估 -->
			<div id="tab1" class="tabC tabC1 panel_main">
				<div class="title_main">
					<span class="span_item">在线学习评估</span>
				</div>
				<div>

					<div id="studyRecByDay" class="panel_sub">
						<div class="title_sub">
							本日学习记录
						</div>
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
										课程
									</th>
									<th>
										我的学习时长
									</th>
									<th>
										平均学习时长
									</th>
								</tr>
								<s:iterator value="myStudyTimeLengthInfoCurrentDay"
									id="mySTLICD" status="st">
									<tr id="mySTLICD_${mySTLICD.id}">
										<td>
											${mySTLICD.id}
										</td>
										<td>
											${mySTLICD.type}
										</td>
										<td>
											${mySTLICD.course}
										</td>
										<td>
											${mySTLICD.userUsedTimeLength}
										</td>
										<td>
											${mySTLICD.aveStudyTimeLength}
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

					<div id="studyRecByWeek" class="panel_sub">
						<div class="title_sub">
							本周学习记录
						</div>
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
										课程
									</th>
									<th>
										我的学习时长
									</th>
									<th>
										平均学习时长
									</th>
								</tr>
								<s:iterator value="myStudyTimeLengthInfoCurrentWeek"
									id="mySTLICW" status="st">
									<tr id="mySTLICW_${mySTLICW.id}">
										<td>
											${mySTLICW.id}
										</td>
										<td>
											${mySTLICW.type}
										</td>
										<td>
											${mySTLICW.course}
										</td>
										<td>
											${mySTLICW.userUsedTimeLength}
										</td>
										<td>
											${mySTLICW.aveStudyTimeLength}
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

					<div id="studyRecByMonth" class="panel_sub">
						<div class="title_sub">
							本月学习记录
						</div>
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
										课程
									</th>
									<th>
										我的学习时长
									</th>
									<th>
										平均学习时长
									</th>
								</tr>
								<s:iterator value="myStudyTimeLengthInfoCurrentMonth"
									id="mySTLICM" status="st">
									<tr id="mySTLICM_${mySTLICM.id}">
										<td>
											${mySTLICM.id}
										</td>
										<td>
											${mySTLICM.type}
										</td>
										<td>
											${mySTLICM.course}
										</td>
										<td>
											${mySTLICM.userUsedTimeLength}
										</td>
										<td>
											${mySTLICM.aveStudyTimeLength}
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

					<div class="filling">
						&nbsp;
					</div>
				</div>
				<div>

					<div id="studyTimeSumAvg" class="panel_sub">
						<div class="title_sub">
							<span class="span_item">各月份学习总时/均时变化</span>
						</div>
						<div class="content_margin" id="monthCountContainer"></div>
					</div>

					<div id="studyEstimation" class="panel_sub">
						<div class="title_sub">
							学习评价
						</div>
						<div class="content_margin">
							<div id="userEICDD">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											类型
										</th>
										<th>
											评价信息
										</th>
									</tr>
									<s:iterator value="userEstimateInfoCurrentDay" id="userEICD"
										status="st">
										<tr>
											<td>
												${userEICD.id}
											</td>
											<td>
												${userEICD.type}
											</td>
											<td>
												${userEICD.estimateInfo}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
							<div id="userEICWD">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											类型
										</th>
										<th>
											评价信息
										</th>
									</tr>
									<s:iterator value="userEstimateInfoCurrentWeek" id="userEICW"
										status="st">
										<tr>
											<td>
												${userEICW.id}
											</td>
											<td>
												${userEICW.type}
											</td>
											<td>
												${userEICW.estimateInfo}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
							<div id="userEICMD">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											类型
										</th>
										<th>
											评价信息
										</th>
									</tr>
									<s:iterator value="userEstimateInfoCurrentMonth" id="userEICM"
										status="st">
										<tr>
											<td>
												${userEICM.id}
											</td>
											<td>
												${userEICM.type}
											</td>
											<td>
												${userEICM.estimateInfo}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
						</div>
						<div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<li class="active" value="1">
									<a onclick="turnToPageN3($(this))">日</a>
								</li>
								<li class="active" value="2">
									<a onclick="turnToPageN3($(this))">周</a>
								</li>
								<li class="active" value="3">
									<a onclick="turnToPageN3($(this))">月</a>
								</li>
							</ul>
						</div>
					</div>

					<div class="filling">
						&nbsp;
					</div>
				</div>
			</div>


			<!-- 在线练习评估 -->
			<div id="tab2" class="tabC tabC2 panel_main">
				<div class="title_main">
					<span class="span_item">在线练习评估</span>
				</div>

				<div id="testAccuracy" class="panel_sub">
					<div class="title_sub">
						练习准确率显示
					</div>
					<div>
						以下3个标签页切换显示
						<a onClick="b(1)"> 本日 </a>
						<a onClick="b(2)"> 本周 </a>
						<a onClick="b(3)"> 本月 </a>
					</div>
					<div id="tabB1" class="content_margin tabB tabB1">
						<table class="table">
							<tr>
								<th>
									序号
								</th>
								<th>
									日期
								</th>
								<th>
									课程
								</th>
								<th>
									准确率
								</th>
							</tr>
							<s:iterator value="userExerciseTodayAccuracyInfo" id="userETDAI"
								status="st">
								<tr id="userETDAI_${userETDAI.id}">
									<td>
										${userETDAI.id}
									</td>
									<td>
										${userETDAI.timeString}
									</td>
									<td>
										${userETDAI.courseString}
									</td>
									<td>
										${userETDAI.accuracyString}
									</td>
								</tr>
							</s:iterator>
						</table>
						<div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList3" id="pageList3">
									<li class="active" value="${pageList3}">
										<a onclick="turnToPageN4($(this))">${pageList3}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo3" recordAmount="${resNum3}"
								pageNum="${pageNum3}"></div>
						</div>
					</div>
					<div id="tabB2" class="content_margin tabB tabB2">
						<table class="table">
							<tr>
								<th>
									序号
								</th>
								<th>
									日期
								</th>
								<th>
									课程
								</th>
								<th>
									评价
								</th>
							</tr>
							<s:iterator value="userExerciseToWeekAccuracyInfo" id="userETWAI"
								status="st">
								<tr id="userETWAI_${userETWAI.id}">
									<td>
										${userETWAI.id}
									</td>
									<td>
										${userETWAI.timeString}
									</td>
									<td>
										${userETWAI.courseString}
									</td>
									<td>
										${userETWAI.accuracyString}
									</td>
								</tr>
							</s:iterator>
						</table>
						<div class="pageDiv pagination" id="pageChangeDisp">
							<ul class="page_ul">
								<s:iterator value="allPageList4" id="pageList4">
									<li class="active" value="${pageList4}">
										<a onclick="turnToPageN5($(this))">${pageList4}</a>
									</li>
								</s:iterator>
							</ul>
							<div id="pageInfo4" recordAmount="${resNum4}"
								pageNum="${pageNum4}"></div>
						</div>
					    </div>
						<div id="tabB3" class="content_margin tabB tabB3">
							<table class="table">
								<tr>
									<th>
										序号
									</th>
									<th>
										日期
									</th>
									<th>
										课程
									</th>
									<th>
										评价
									</th>
								</tr>
								<s:iterator value="userExerciseToMonthAccuracyInfo"
									id="userETMAI" status="st">
									<tr id="userETMAI_${userETMAI.id}">
										<td>
											${userETMAI.id}
										</td>
										<td>
											${userETMAI.timeString}
										</td>
										<td>
											${userETMAI.courseString}
										</td>
										<td>
											${userETMAI.accuracyString}
										</td>
									</tr>
								</s:iterator>
							</table>
							<div class="pageDiv pagination" id="pageChangeDisp">
								<ul class="page_ul">
									<s:iterator value="allPageList5" id="pageList5">
										<li class="active" value="${pageList5}">
											<a onclick="turnToPageN6($(this))">${pageList5}</a>
										</li>
									</s:iterator>
								</ul>
								<div id="pageInfo5" recordAmount="${resNum5}"
									pageNum="${pageNum5}"></div>
							</div>
						</div>
						</div>

						<div id="testFrequency" class="panel_sub">
							<div class="title_sub">
								练习频率评估
							</div>
							<div>
								以下3个标签页切换显示
								<a onClick="d(1)"> 本日 </a>
								<a onClick="d(2)"> 本周 </a>
								<a onClick="d(3)"> 本月 </a>
								<a onClick="d(4)"> 练习频率显示 </a>
							</div>
							<div id="tabD1" class="content_margin tabD tabD1">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											类型
										</th>
										<th>
											练习内容
										</th>
										<th>
											评价
										</th>
									</tr>
									<s:iterator value="userExerciseEstimateInfoToday"
										id="userEEITD" status="st">
										<tr>
											<td>
												${userEEITD.id}
											</td>
											<td>
												${userEEITD.type}
											</td>
											<td>
												${userEEITD.exerciseContent}
											</td>
											<td>
												${userEEITD.estimateString}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
							<div id="tabD2" class="content_margin tabD tabD2">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											类型
										</th>
										<th>
											练习内容
										</th>
										<th>
											评价
										</th>
									</tr>
									<s:iterator value="userExerciseEstimateInfoToWeek"
										id="userEEITW" status="st">
										<tr>
											<td>
												${userEEITW.id}
											</td>
											<td>
												${userEEITW.type}
											</td>
											<td>
												${userEEITW.exerciseContent}
											</td>
											<td>
												${userEEITW.estimateString}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
							<div id="tabD3" class="content_margin tabD tabD3">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											类型
										</th>
										<th>
											练习内容
										</th>
										<th>
											评价
										</th>
									</tr>
									<s:iterator value="userExerciseEstimateInfoToMonth"
										id="userEEITM" status="st">
										<tr>
											<td>
												${userEEITM.id}
											</td>
											<td>
												${userEEITM.type}
											</td>
											<td>
												${userEEITM.exerciseContent}
											</td>
											<td>
												${userEEITM.estimateString}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
							<div id="tabD4" class="content_margin tabD tabD4">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											时间
										</th>
										<th>
											练习频率
										</th>
										<th>
											平均练习题量
										</th>
									</tr>
									<s:iterator value="userExerciseFrequencyInfo" id="userEFI"
										status="st">
										<tr>
											<td>
												${userEFI.id}
											</td>
											<td>
												${userEFI.time}
											</td>
											<td>
												${userEFI.exerciseFeq}
											</td>
											<td>
												${userEFI.aveExerciseQuestionNum}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
						</div>

						<div id="testAccuracyChart" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">各月份练习准确率变化曲线</span>
							</div>
							<div class="content_margin" id="monthAcurContainer"></div>
						</div>

						<div id="testFrequencyChart" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">各月份练习频率变化曲线</span>
							</div>
							<div class="content_margin" id="monthFeqContainer"></div>
						</div>

						<div class="filling">
							&nbsp;
						</div>
					</div>


					<!-- 模拟考试评估 -->
					<div id="tab3" class="tabC tabC3 panel_main">
						<div class="title_main">
							<span class="span_item">模拟考试评估</span>
						</div>

						<div id="personInfo" class="panel_sub">
							<div class="title_sub">
								员工信息
							</div>
							<div class="content_margin">
								<table class="table">
									<tr>
										<th>
											姓名
										</th>
										<td>
											${userInfo.name}
										</td>
									</tr>
									<tr>
										<th>
											工号
										</th>
										<td>
											${userInfo.workno}
										</td>
									</tr>
									<tr>
										<th>
											工区
										</th>
										<td>
											${userInfo.company}
										</td>
									</tr>
								</table>
							</div>
						</div>

						<div id="examEstimation" class="panel_sub">
							<div class="title_sub">
								考试评价
							</div>
							<div class="content_margin">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											评价类型
										</th>
										<th>
											评价信息
										</th>
									</tr>
									<s:iterator value="userTestEstimateInfo" id="userTEI"
										status="st">
										<tr>
											<td>
												${userTEI.id}
											</td>
											<td>
												${userTEI.type}
											</td>
											<td>
												${userTEI.estimateString}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
						</div>

						<div class="filling">
							&nbsp;
						</div>

						<div id="personMockScore" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">员工模拟考试成绩柱状图</span>
							</div>
							<div class="content_margin" id="userMockTestScoreBarContainer"></div>
						</div>

						<div id="personMockRank" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">员工模拟考试成绩排名折线图</span>
							</div>
							<div class="content_margin" id="userMockTestRankLineContainer"></div>
						</div>

						<div id="personMockRankStability" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">员工模拟考试成绩稳定性折线图</span>
							</div>
							<div class="content_margin"
								id="userMockTestScoreStableLineContainer"></div>
						</div>

						<div id="ScoreType" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">员工模拟考试成绩分类饼图</span>
							</div>
							<div class="content_margin"
								id="userMockTestScoreCategoryContainer"></div>
						</div>

						<div class="filling">
							&nbsp;
						</div>
					</div>

					<!--调考评估 -->
					<div id="tab4" class="tabC tabC4 panel_main">
						<div class="title_main">
							<span class="span_item">调考评估</span>
						</div>

						<div id="personInfo" class="panel_sub">
							<div class="title_sub">
								员工信息
							</div>
							<div class="content_margin">
								<table class="table">
									<tr>
										<th>
											姓名
										</th>
										<td>
											${userInfo.name}
										</td>
									</tr>
									<tr>
										<th>
											工号
										</th>
										<td>
											${userInfo.workno}
										</td>
									</tr>
									<tr>
										<th>
											工区
										</th>
										<td>
											${userInfo.company}
										</td>
									</tr>
								</table>
							</div>
						</div>

						<div id="examEstimation" class="panel_sub">
							<div class="title_sub">
								考试评价
							</div>
							<div class="content_margin">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											评价类型
										</th>
										<th>
											评价信息
										</th>
									</tr>
									<s:iterator value="userTrainTestEstimateInfo" id="userTTEI"
										status="st">
										<tr>
											<td>
												${userTTEI.id}
											</td>
											<td>
												${userTTEI.type}
											</td>
											<td>
												${userTTEI.estimateString}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
						</div>

						<div class="filling">
							&nbsp;
						</div>

						<div id="personTrainTestScore" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">员工调考成绩柱状图</span>
							</div>
							<div class="content_margin" id="userTrainTestScoreBarContainer"></div>
						</div>

						<div id="personTrainTestRank" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">员工调考成绩排名折线图</span>
							</div>
							<div class="content_margin" id="userTrainTestRankLineContainer"></div>
						</div>

						<div id="personTrainTestRankStability" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">员工调考成绩稳定性折线图</span>
							</div>
							<div class="content_margin"
								id="userTrainTestScoreStableLineContainer"></div>
						</div>

						<div id="TrainTestScoreType" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">员工调考成绩分类饼图</span>
							</div>
							<div class="content_margin"
								id="userTrainTestScoreCategoryContainer"></div>
						</div>

						<div class="filling">
							&nbsp;
						</div>
					</div>

					<!--知识库评估 -->
					<div id="tab5" class="tabC tabC5 panel_main">
						<div class="title_main">
							<span class="span_item">知识库评估</span>
						</div>

						<div id="personInfo" class="panel_sub">
							<div class="title_sub">
								知识库搜索记录查询
							</div>
							<div class="content_margin">
								<table class="table">
									<tr>
										<th>
											类别:
										</th>
										<td>
											<select id="typeSelect">
												<option value="条文导学">
													条文导学
												</option>
												<option value="典型案例">
													典型案例
												</option>
												<option value="典型违章">
													典型违章
												</option>
												<option value="操作经验">
													操作经验
												</option>
											</select>
										</td>
									</tr>
									<tr>
										<th>
											开始日期:
										</th>
										<td>
											<input id="starttime" type="text" onfocus="setday(this)"
												readonly="readonly" />
										</td>
									</tr>
									<tr>
										<th>
											结束日期:
										</th>
										<td>
											<input id="endtime" type="text" onfocus="setday(this)"
												readonly="readonly" />

										</td>
									</tr>
								</table>
								<div>
									<img id="query" style="cursor: hand"
										src="resource/image/knowledge/btn_search.png"
										onclick="klgSearchRecordByKeyWordsType()" />
								</div>
							</div>
						</div>

						<div id="examEstimation" class="panel_sub">
							<div class="title_sub">
								知识库使用评价
							</div>
							<div class="content_margin">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											评价类型
										</th>
										<th>
											评价信息
										</th>
									</tr>
									<s:iterator value="setUserKlgBankEstimateInfoPo" id="sUKBEIP"
										status="st">
										<tr>
											<td>
												${sUKBEIP.id}
											</td>
											<td>
												${sUKBEIP.type}
											</td>
											<td>
												${sUKBEIP.estimateString}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
						</div>

						<div class="filling">
							&nbsp;
						</div>

						<div id="historicalSearchAmount" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">搜索总量分类统计</span>
							</div>
							<div class="content_margin" id="searchAmountBarContainer"></div>
						</div>

						<div id="todaySearchAmount" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">本日搜索总量分类统计</span>
							</div>
							<div class="content_margin" id="todaySearchAmountBarContainer"></div>
						</div>

						<div id="toweekSearchAmount" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">本周搜索总量分类统计</span>
							</div>
							<div class="content_margin" id="toweekSearchAmountBarContainer"></div>
						</div>

						<div id="tomonthSearchAmount" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">本月搜索总量分类统计</span>
							</div>
							<div class="content_margin" id="tomonthSearchAmountBarContainer"></div>
						</div>

						<div id="todayOpExpUpload" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">本日上传操作经验</span>
							</div>
							<div class="content_margin" id="todayOpExpUploadBarContainer"></div>
						</div>

						<div id="toweekOpExpUpload" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">本周上传操作经验</span>
							</div>
							<div class="content_margin" id="toweekOpExpUploadBarContainer"></div>
						</div>

						<div id="tomonthOpExpUpload" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">本月上传操作经验</span>
							</div>
							<div class="content_margin" id="tomonthOpExpUploadBarContainer"></div>
						</div>
						<div class="filling">
							&nbsp;
						</div>
					</div>

					<!--交流评估 -->
					<div id="tab6" class="tabC tabC6 panel_main">
						<div class="title_main">
							<span class="span_item">交流评估</span>
						</div>

						<div id="examEstimation" class="panel_sub">
							<div class="title_sub">
								交流评价
							</div>
							<div class="content_margin">
								<table class="table">
									<tr>
										<th>
											序号
										</th>
										<th>
											评价类型
										</th>
										<th>
											评价信息
										</th>
									</tr>
									<s:iterator value="setWorkerCmncEstimateInfo" id="sWCEI"
										status="st">
										<tr>
											<td>
												${sWCEI.id}
											</td>
											<td>
												${sWCEI.type}
											</td>
											<td>
												${sWCEI.estimateString}
											</td>
										</tr>
									</s:iterator>
								</table>
							</div>
						</div>

						<div class="filling">
							&nbsp;
						</div>

						<div id="workerProCmncAmount" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">问题交流总量分类统计</span>
							</div>
							<div class="content_margin" id="proCmncAmountBarContainer"></div>
						</div>

						<div id="workerProCmncAmountToWeek" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">本周问题交流总量分类统计</span>
							</div>
							<div class="content_margin" id="toweekProCmncAmountBarContainer"></div>
						</div>

						<div id="workerProCmncAmountToMonth" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">本月问题交流总量分类统计</span>
							</div>
							<div class="content_margin" id="tomonthProCmncAmountBarContainer"></div>
						</div>

						<div id="workerStuCmncAmount" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">学习交流总量分类统计</span>
							</div>
							<div class="content_margin" id="stuCmncAmountBarContainer"></div>
						</div>

						<div id="workerStuCmncAmountToWeek" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">本周学习交流总量分类统计</span>
							</div>
							<div class="content_margin" id="toweekStuCmncAmountBarContainer"></div>
						</div>

						<div id="workerStuCmncAmountToMonth" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">本月学习交流总量分类统计</span>
							</div>
							<div class="content_margin" id="tomonthStuCmncAmountBarContainer"></div>
						</div>

						<div id="proCmncAcp" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">问题交流回答采纳统计</span>
							</div>
							<div class="content_margin" id="proCmncAcpBarContainer"></div>
						</div>

						<div id="proCmncAcpRatePerMonth" class="panel_sub">
							<div class="title_sub">
								<span class="span_item">月问题交流采纳率统计</span>
							</div>
							<div class="content_margin"
								id="proCmncAcpRatePerMonthLineContainer"></div>
						</div>

						<div class="filling">
							&nbsp;
						</div>
					</div>
					</div>


	</body>
</html>