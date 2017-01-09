function initColumn(){
	$.getJSON("exam/ExaminationTrainAction_TrainTestAnalysis",function(data){
		var objJson= eval("(" + data.trainTestAnalysis.userTestScoreByUserAndType + ")");
		var historyScoreChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","historyScoreID", "280", "200", "0" );
	    historyScoreChart.setChartData(objJson , "json");
	    historyScoreChart.render("historyScoreContainer");
	    });
}

function initLine(){
	$.getJSON("exam/ExaminationTrainAction_TrainTestAnalysis",function(data){
		var objJson= eval("(" + data.trainTestAnalysis.userTestScoreStablilityByUserAndType + ")");
		var scoreStabChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","scoreStabID", "280", "200", "0" );
	    scoreStabChart.setChartData(objJson , "json");
	    scoreStabChart.render("scoreStabContainer");
	    });
}

function initPie(){
	$.getJSON("exam/ExaminationTrainAction_TrainTestAnalysis",function(data){
		var objJson= eval("(" + data.trainTestAnalysis.categoryUserTestScore + ")");
		var scorePercChart = new FusionCharts("resource/script/fusioncharts/swf/Pie3D.swf", "scorePercID", "280", "200", "0", "0");
	    scorePercChart.setChartData(objJson , "json");	   
	    scorePercChart.render("scorePercContainer");
	    });
}

function initLine1(){
	$.getJSON("exam/ExaminationTrainAction_TrainTestAnalysis",function(data){
		var objJson= eval("(" + data.trainTestAnalysis.userTestScoreRankByUserAndType + ")");
		var scoreOrderChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","scoreOrderID", "280", "200", "0" );
	    scoreOrderChart.setChartData(objJson , "json");
	    scoreOrderChart.render("scoreOrderContainer");
	    });
}
