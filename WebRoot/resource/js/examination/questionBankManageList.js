function initChart(){
	$.getJSON("exam/QuestionBankManageAction_QuestionBankManageAnalysis",function(data){
		var trainCourseSumTime= eval("(" + data.questionBankManagePo.uploadQuestionNumPerKind + ")");
		var sumTimeChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","perKindId", "400", "300", "0" );
		sumTimeChart.setChartData(trainCourseSumTime , "json");
		sumTimeChart.render("perKind");
		//2
		var compaTime=eval("("+data.questionBankManagePo.uploadQuestionNumPerMonth+")");
		var compTimeChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","perMonthId", "400", "300", "0" );
	    compTimeChart.setChartData(compaTime , "json");
	    compTimeChart.render("perMonth");
	});
}


function questionSearchResByKeyWordsTypeDisp(){
	
	    var keyWords=$("#keyWords").val();
	    var type1=$("[name='question_type']:checked");
	    var page=1;

	   if(type1.length==0&&keyWords==""){
		  alert("请选择至少一个查询条件!!!");
		  return;
	   }
	   
	   var type=type1.val();
	   
	   if(type==null){
		   type="";
	   }
	   
	   keyWords=encodeURI(keyWords);
	   keyWords=encodeURI(keyWords);
	   type=encodeURI(type);
	   type=encodeURI(type);
       window.location.href = "exam/QuestionBankManageAction_QuestionSearchResByKeyWordsTypeDisp?questionKeyWords="+keyWords+"&questionType="+type+"&newPage1="+page;
}

