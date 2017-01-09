function c(i){
	$(".tabC").hide();
	$("#tab"+i).show();
}

function b(i){
	$(".tabB").hide();
	$("#tabB"+i).show();
}

function d(i){
	$(".tabD").hide();
	$("#tabD"+i).show();
}

function initChart(){
	$.getJSON("wkea/WorkerEstimateListAction_WorkerEstimateAnalysis",function(data){
		var data0 = eval("(" + data.radarString+ ")");
		var companyTimeLengthChart = new FusionCharts("resource/script/fusioncharts/swf/Radar.swf","radarChartID", "600", "600", "0", "0");
	companyTimeLengthChart.setChartData(data0 , "json");
	companyTimeLengthChart.render("wholeEstContainer");
	});
	
	$.getJSON("wkea/WorkerEstimateListAction_WorkerEstimateAnalysis",function(data){
		var data0 = eval("(" + data.timeLengthString+ ")");
		var companyTimeLengthChart = new FusionCharts("resource/script/fusioncharts/swf/ScrollLine2D.swf","companyChartID", "600", "260", "0", "0");
	companyTimeLengthChart.setChartData(data0 , "json");
	companyTimeLengthChart.render("monthCountContainer");
	});
	
	$.getJSON("wkea/WorkerEstimateListAction_WorkerEstimateAnalysis",function(data){
		var data1 = eval("(" + data.setAccuracyString+ ")");
		var companyAcurChart = new FusionCharts("resource/script/fusioncharts/swf/ScrollLine2D.swf","companyAcurChartID", "1000", "260", "0", "0");
	companyAcurChart.setChartData(data1 , "json");
	companyAcurChart.render("monthAcurContainer");
	});
	
	$.getJSON("wkea/WorkerEstimateListAction_WorkerEstimateAnalysis",function(data){
		var data2 = eval("(" + data.setFeqString+ ")");
		var companyFeqChart = new FusionCharts("resource/script/fusioncharts/swf/ScrollLine2D.swf","companyFeqChartID", "1000", "260", "0", "0");
	companyFeqChart.setChartData(data2 , "json");
	companyFeqChart.render("monthFeqContainer");
	});
	
	$.getJSON("wkea/WorkerEstimateListAction_WorkerEstimateAnalysis",function(data){
		//成绩分类饼图
		var scorePerc = eval("(" + data.categoryUserTestScore + ")");
		var scorePercChart = new FusionCharts("resource/script/fusioncharts/swf/Pie3D.swf", "scorePercID", "1000", "260", "0", "0");
		scorePercChart.setChartData(scorePerc , "json");	   
		scorePercChart.render("userMockTestScoreCategoryContainer");
		
		//用户模拟考试成绩排名折线图
		var scoreOrder = eval("(" + data.userTestScoreRankByUserAndType + ")");
		var scoreOrderChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","scoreOrderID", "1000", "260", "0" );
		scoreOrderChart.setChartData(scoreOrder , "json");
		scoreOrderChart.render("userMockTestRankLineContainer");
		
		//用户模拟考试成绩柱状图UserTestScoreByUserAndType
		var historyScore = eval("(" + data.userTestScoreByUserAndType + ")");
		var historyScoreChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","historyScoreID", "1000", "260", "0" );
		historyScoreChart.setChartData(historyScore , "json");
		historyScoreChart.render("userMockTestScoreBarContainer");
		
		//用户模拟考试成绩排名稳定性折线图UserTestScoreStablilityByUserAndType
		var scoreStab = eval("(" + data.userTestScoreStablilityByUserAndType + ")");
		var scoreStabChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","scoreStabID", "1000", "260", "0" );
		scoreStabChart.setChartData(scoreStab , "json");
		scoreStabChart.render("userMockTestScoreStableLineContainer");
	});
	
	$.getJSON("wkea/WorkerEstimateListAction_WorkerEstimateAnalysis",function(data){
		//成绩分类饼图
		var scorePerc = eval("(" + data.categoryUserTrainTestScore + ")");
		var scorePercChart = new FusionCharts("resource/script/fusioncharts/swf/Pie3D.swf", "scoreTrainTestPercID", "1000", "260", "0", "0");
		scorePercChart.setChartData(scorePerc , "json");	   
		scorePercChart.render("userTrainTestScoreCategoryContainer");
		
		//用户正式考试成绩排名折线图
		var scoreOrder = eval("(" + data.userTrainTestScoreRankByUserAndType + ")");
		var scoreOrderChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","scoreTrainTestOrderID", "1000", "260", "0" );
		scoreOrderChart.setChartData(scoreOrder , "json");
		scoreOrderChart.render("userTrainTestRankLineContainer");
		
		//用户正式考试成绩柱状图UserTestScoreByUserAndType
		var historyScore = eval("(" + data.userTrainTestScoreByUserAndType + ")");
		var historyScoreChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","historyScoreTrainTestID", "1000", "260", "0" );
		historyScoreChart.setChartData(historyScore , "json");
		historyScoreChart.render("userTrainTestScoreBarContainer");
		
		//用户正式考试成绩排名稳定性折线图UserTestScoreStablilityByUserAndType
		var scoreStab = eval("(" + data.userTrainTestScoreStablilityByUserAndType + ")");
		var scoreStabChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","scoreStabTrainTestID", "1000", "260", "0" );
		scoreStabChart.setChartData(scoreStab , "json");
		scoreStabChart.render("userTrainTestScoreStableLineContainer");
	});
	
	$.getJSON("wkea/WorkerEstimateListAction_WorkerEstimateAnalysis",function(data){
		
		//搜索总量分类统计
		var historySearch = eval("(" + data.workerKlgSearchEst + ")");
		var historySearchChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","historySearchChartID", "1000", "260", "0" );
		historySearchChart.setChartData(historySearch , "json");
		historySearchChart.render("searchAmountBarContainer");
		
		//本日搜索总量分类统计
		var todaySearch = eval("(" + data.workerKlgSearchEstToday + ")");
		var todaySearchChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","todaySearchChartID", "1000", "260", "0" );
		todaySearchChart.setChartData(todaySearch , "json");
		todaySearchChart.render("todaySearchAmountBarContainer");
		
		//本周搜索总量分类统计
		var toweekSearch = eval("(" + data.workerKlgSearchEstToWeek + ")");
		var toweekSearchChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","toweekSearchChartID", "1000", "260", "0" );
		toweekSearchChart.setChartData(toweekSearch , "json");
		toweekSearchChart.render("toweekSearchAmountBarContainer");
		
		//本月搜索总量分类统计
		var tomonthSearch = eval("(" + data.workerKlgSearchEstToMonth + ")");
		var tomonthSearchChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","tomonthSearchChartID", "1000", "260", "0" );
		tomonthSearchChart.setChartData(tomonthSearch , "json");
		tomonthSearchChart.render("tomonthSearchAmountBarContainer");
		
		//本日上传操作经验统计
		var todayUpload = eval("(" + data.workerOpExpUploadToday + ")");
		var todayUploadChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","workerOpExpUploadTodayID", "1000", "260", "0" );
		todayUploadChart.setChartData(todayUpload , "json");
		todayUploadChart.render("todayOpExpUploadBarContainer");
		
		//本周上传操作经验统计
		var toweekUpload = eval("(" + data.workerOpExpUploadToWeek + ")");
		var toweekUploadChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","workerOpExpUploadToWeekID", "1000", "260", "0" );
		toweekUploadChart.setChartData(toweekUpload , "json");
		toweekUploadChart.render("toweekOpExpUploadBarContainer");
		
		//本月上传操作经验统计
		var tomonthUpload = eval("(" + data.workerOpExpUploadToMonth + ")");
		var tomonthUploadChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","workerOpExpUploadToMonthID", "1000", "260", "0" );
		tomonthUploadChart.setChartData(tomonthUpload , "json");
		tomonthUploadChart.render("tomonthOpExpUploadBarContainer");
		
	});
	
	$.getJSON("wkea/WorkerEstimateListAction_WorkerEstimateAnalysis",function(data){
		
		//问题交流总量分类统计
		var historyProCmncAmount = eval("(" + data.selectWorkerProCmncAmount + ")");
		var historyProCmncAmountChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","historyProCmncAmountChartID", "1000", "260", "0" );
		historyProCmncAmountChart.setChartData(historyProCmncAmount , "json");
		historyProCmncAmountChart.render("proCmncAmountBarContainer");
		
		//本周问题交流总量分类统计
		var toweekProCmncAmount = eval("(" + data.selectWorkerProCmncAmountToWeek + ")");
		var toweekProCmncAmountChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","toweekProCmncAmountChartID", "1000", "260", "0" );
		toweekProCmncAmountChart.setChartData(toweekProCmncAmount , "json");
		toweekProCmncAmountChart.render("toweekProCmncAmountBarContainer");
		
		//本月问题交流总量分类统计
		var tomonthProCmncAmount = eval("(" + data.selectWorkerProCmncAmountToMonth + ")");
		var tomonthProCmncAmountChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","tomonthProCmncAmountChartID", "1000", "260", "0" );
		tomonthProCmncAmountChart.setChartData(tomonthProCmncAmount , "json");
		tomonthProCmncAmountChart.render("tomonthProCmncAmountBarContainer");
		
		//学习交流总量分类统计
		var historyStuCmncAmount = eval("(" + data.selectWorkerStuCmncAmount + ")");
		var historyStuCmncAmountChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","historyStuCmncAmountChartID", "1000", "260", "0" );
		historyStuCmncAmountChart.setChartData(historyStuCmncAmount , "json");
		historyStuCmncAmountChart.render("stuCmncAmountBarContainer");
		
		//本周学习交流总量分类统计
		var toweekStuCmncAmount = eval("(" + data.selectWorkerStuCmncAmountToWeek + ")");
		var toweekStuCmncAmountChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","toweekStuCmncAmountChartID", "1000", "260", "0" );
		toweekStuCmncAmountChart.setChartData(toweekStuCmncAmount , "json");
		toweekStuCmncAmountChart.render("toweekStuCmncAmountBarContainer");
		
		//本月学习交流总量分类统计
		var tomonthStuCmncAmount = eval("(" + data.selectWorkerStuCmncAmountToMonth + ")");
		var tomonthStuCmncAmountChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","tomonthStuCmncAmountChartID", "1000", "260", "0" );
		tomonthStuCmncAmountChart.setChartData(tomonthStuCmncAmount , "json");
		tomonthStuCmncAmountChart.render("tomonthStuCmncAmountBarContainer");
		
		//问题交流回答采纳统计
		var proAcpAmount = eval("(" + data.selectWorkerProCmncAcp + ")");
		var proAcpAmountChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","proCmncAcpChartID", "1000", "260", "0" );
		proAcpAmountChart.setChartData(proAcpAmount , "json");
		proAcpAmountChart.render("proCmncAcpBarContainer");
		
		//月问题交流采纳率统计
		var proCmncAcpRatePerMonth = eval("(" + data.selectWorkerAcpRatePerMonth + ")");
		var proCmncAcpRatePerMonthChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","proCmncAcpRatePerMonthChartID", "1000", "260", "0" );
		proCmncAcpRatePerMonthChart.setChartData(proCmncAcpRatePerMonth , "json");
		proCmncAcpRatePerMonthChart.render("proCmncAcpRatePerMonthLineContainer");
		
	});
}

function klgSearchRecordByKeyWordsType(){
	
	    var startdate=$("#starttime").val();
	    var enddate=$("#endtime").val();
	    var type=$("#typeSelect").val();

	   if(type==""||endtime==""||starttime==""){
		  alert("请选择查询条件!!!");
		  return;
	   }
	   
	   //$("#queryResult").css("display","block");
	   enddate=encodeURI(enddate);
	   enddate=encodeURI(enddate);
	   startdate=encodeURI(startdate);
	   startdate=encodeURI(startdate);
	   type=encodeURI(type);
	   type=encodeURI(type);
	   var page=1;
	   window.location.href = "wkea/WorkerEstimateListAction_workerKlgBankRecordSearch?type="+type+"&endDate="+enddate+"&startDate="+startdate+"&newPage="+page;
}

function initMessage()
{
	//日学习记录
	var page=1;
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#mySTLICD_"+i.toString()).show();    
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#mySTLICD_"+k.toString()).hide();
	}
	//周学习记录
	var page1=1;
	var resNum1=parseInt($("#pageInfo1").attr("recordAmount"));
	var endPage1=page1*3;
	if(resNum1<endPage1)
	{
		endPage1=resNum1;
	}
	for(var i1=(page1-1)*3+1;i1<=endPage1;i1++)
	{
		$("#mySTLICW_"+i1.toString()).show();    
	}
	for(var k1=endPage+1;k1<=resNum1;k1++)
	{
		$("#mySTLICW_"+k1.toString()).hide();
	}
	//月学习记录
	var page2=1;
	var resNum2=parseInt($("#pageInfo2").attr("recordAmount"));
	var endPage2=page2*3;
	if(resNum2<endPage2)
	{
		endPage2=resNum2;
	}
	for(var i2=(page2-1)*3+1;i2<=endPage2;i2++)
	{
		$("#mySTLICM_"+i2.toString()).show();    
	}
	for(var k2=endPage+1;k2<=resNum2;k2++)
	{
		$("#mySTLICM_"+k2.toString()).hide();
	}
	//学习评价
	$("#userEICMD").hide();
	$("#userEICDD").show();
	$("#userEICWD").hide();
	//日练习记录
	var page3=1;
	var resNum3=parseInt($("#pageInfo3").attr("recordAmount"));
	var endPage3=page3*3;
	if(resNum3<endPage3)
	{
		endPage3=resNum3;
	}
	for(var i3=(page3-1)*3+1;i3<=endPage3;i3++)
	{
		$("#userETDAI_"+i3.toString()).show();    
	}
	for(var k3=endPage+1;k3<=resNum3;k3++)
	{
		$("#userETDAI_"+k3.toString()).hide();
	}
	//周练习记录
	var page4=1;
	var resNum4=parseInt($("#pageInfo4").attr("recordAmount"));
	var endPage4=page4*3;
	if(resNum4<endPage4)
	{
		endPage4=resNum4;
	}
	for(var i4=(page4-1)*3+1;i4<=endPage4;i4++)
	{
		$("#userETWAI_"+i4.toString()).show();    
	}
	for(var k4=endPage4+1;k4<=resNum4;k4++)
	{
		$("#userETWAI_"+k4.toString()).hide();
	}
	//月练习记录
	var page5=1;
	var resNum5=parseInt($("#pageInfo5").attr("recordAmount"));
	var endPage5=page5*3;
	if(resNum5<endPage5)
	{
		endPage5=resNum5;
	}
	for(var i5=(page5-1)*3+1;i5<=endPage5;i5++)
	{
		$("#userETMAI_"+i5.toString()).show();    
	}
	for(var k5=endPage5+1;k5<=resNum5;k5++)
	{
		$("#userETMAI_"+k5.toString()).hide();
	}
}

function turnToPageN($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#mySTLICD_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#mySTLICD_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#mySTLICD_"+k.toString()).hide();
	}
}

function turnToPageN1($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo1").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#mySTLICW_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#mySTLICW_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#mySTLICW_"+k.toString()).hide();
	}
}

function turnToPageN2($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo2").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#mySTLICM_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#mySTLICM_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#mySTLICM_"+k.toString()).hide();
	}
}

function turnToPageN3($this)
{
	var page=$($this.parent("li")).attr("value");
	if(page=="3")
	{
		$("#userEICMD").show();
		$("#userEICDD").hide();
		$("#userEICWD").hide();
	}
	if(page=="2")
	{
		$("#userEICMD").hide();
		$("#userEICDD").hide();
		$("#userEICWD").show();
	}
	if(page=="1")
	{
		$("#userEICMD").hide();
		$("#userEICDD").show();
		$("#userEICWD").hide();
	}
}

function turnToPageN4($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo3").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#userETDAI_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#userETDAI_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#userETDAI_"+k.toString()).hide();
	}
}

function turnToPageN5($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo4").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#userETWAI_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#userETWAI_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#userETWAI_"+k.toString()).hide();
	}
}

function turnToPageN6($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo5").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#userETMAI_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#userETMAI_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#userETMAI_"+k.toString()).hide();
	}
}
