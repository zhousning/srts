function initChart(){
	$.getJSON("exam/ExaminationGameHomeAction_examGameHomeAnalysis",function(data){
		var compScore=eval("("+data.compeitionScoreAnalysis+")");
		var compScoreChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","lineContainerId", "400", "300", "0" );
	    compScoreChart.setChartData(compScore , "json");
	    compScoreChart.render("lineContainer");
	});
}

