function initChart(){
	$.getJSON("exam/ExaminationTestAction_examTestAnalysis",function(data){
		//成绩分类饼图
		var scorePerc = eval("(" + data.mockTestAnalysis.categoryUserTestScore + ")");
		var scorePercChart = new FusionCharts("resource/script/fusioncharts/swf/Pie3D.swf", "scorePercID", "280", "200", "0", "0");
		scorePercChart.setChartData(scorePerc , "json");	   
		scorePercChart.render("scorePercContainer");
		
		//用户模拟考试成绩排名折线图
		var scoreOrder = eval("(" + data.mockTestAnalysis.userTestScoreRankByUserAndType + ")");
		var scoreOrderChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","scoreOrderID", "280", "200", "0" );
		scoreOrderChart.setChartData(scoreOrder , "json");
		scoreOrderChart.render("scoreOrderContainer");
		
		//用户模拟考试成绩折线图UserTestScoreByUserAndType
		var historyScore = eval("(" + data.mockTestAnalysis.userTestScoreByUserAndType + ")");
		var historyScoreChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","historyScoreID", "280", "200", "0" );
		historyScoreChart.setChartData(historyScore , "json");
		historyScoreChart.render("historyScoreContainer");
		
		//用户模拟考试成绩排名稳定性折线图UserTestScoreStablilityByUserAndType
		var scoreStab = eval("(" + data.mockTestAnalysis.userTestScoreStablilityByUserAndType + ")");
		var scoreStabChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","scoreStabID", "280", "200", "0" );
		scoreStabChart.setChartData(scoreStab , "json");
		scoreStabChart.render("scoreStabContainer");
	});
}
