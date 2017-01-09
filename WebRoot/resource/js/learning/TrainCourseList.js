function initChart(userId){
	$.getJSON("learning/TrainCourseAction_trainCourseAnalysis?userId="+userId,function(data){
		//1
		var trainCourseSumTime= eval("(" + data.trainCoursePo.currentCourseSumTime + ")");
		var sumTimeChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","timeContainerId", "400", "300", "0" );
		sumTimeChart.setChartData(trainCourseSumTime , "json");
		sumTimeChart.render("timeContainer");
		//2
		var comDeg=eval("("+data.trainCoursePo.currentCourseComDeg+")");
	 	var pieChart = new FusionCharts("resource/script/fusioncharts/swf/Pie3D.swf", "pieContainerId", "560", "400", "0", "0");
	    pieChart.setChartData(comDeg , "json");	   
	    pieChart.render("pieContainer");
	    //3
		var compaTime=eval("("+data.trainCoursePo.meanComMyStudyTime+")");
		var compTimeChart = new FusionCharts( "resource/script/fusioncharts/swf/MSLine.swf","lineContainerId", "400", "300", "0" );
	    compTimeChart.setChartData(compaTime , "json");
	    compTimeChart.render("lineContainer");
	    //4
		var trainCourseSumRead=eval("("+ data.trainCoursePo.historyCourseSumRead + ")");
		var sumReadChart=new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","columnContainerId", "400", "300", "0");
		sumReadChart.setChartData(trainCourseSumRead,"json");
		sumReadChart.render("columnContainer");
		//5
		var trainSumTime=eval("("+data.trainCoursePo.trainStudyTime+")");
		var trainSumTimeChart = new FusionCharts("resource/script/fusioncharts/swf/AngularGauge.swf", "widgetContainerId", "300", "300", "0", "0");
	    trainSumTimeChart.setChartData(trainSumTime , "json");	   
	    trainSumTimeChart.render("widgetContainer");
		
	});
}

//function initLine(){
//	var objJson={"chart": {"divlinecolor": "91AF46","xaxisname": "月份",'yaxisname':'次数',"caption": "月自学次数统计变化趋势","divlinealpha": "30","showvalues": "0","bgcolor": "91AF46,FFFFFF","anchorradius": "5","anchorsides": "3","yaxismaxvalue": "100"},
//  "data": [
//	{"value": "34","label": "1"},
//    {"value": "27","label": "2"},
//    {"value": "42","label": "3"},
//    {"value": "50","label": "4"},
//    {"value": "68","label": "5"},
//    {"value": "56","label": "6"},
//    {"value": "48","label": "7"},
//    {"value": "34","label": "8"},
//    {"value": "30","label": "9"},
//    {"value": "34","label": "10"},
//    {"value": "34","label": "11"},
//    {"value": "34","label": "12"},],
//  "trendlines": [
//    {"line": [
//        {"color": "BC9F3F","alpha": "25","valueonright": "1","showontop": "0","istrendzone": "1","displayvalue": "一般","endvalue": "80","startvalue": "50"},
//        {"color": "894D1B","alpha": "25","valueonright": "1","showontop": "0","istrendzone": "1","displayvalue": "主动","endvalue": "100","startvalue": "80"}
//      ]
//    }
//  ],
//}};
//
//function initColumn(){
//	var objJson = {'chart': { 'caption' : '课程阅读次数统计' ,'xAxisName' : '章节','yAxisName' : '次数','numberPrefix' : '次数'},'data':[{'label':'第1次培训','value':'5'},{'label':'第2次培训','value':'6'},{'label':'第3次培训','value':'2'},{'label':'第4次培训','value':'4'},]};
//	var columnChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","columnContainerId", "400", "300", "0","1");
//	columnChart.setChartData(objJson,"json");
//	columnChart.render("columnContainer");	
//}	
//function initLine(){
//	var objJson={ 
//'chart': { 'canvaspadding': '10', 'caption': '课程学习时间对比','yaxisname': '时间','bgcolor': 'F7F7F7, E9E9E9','numvdivlines': '10','divlinealpha': '30','labelpadding': '10','yaxisvaluespadding': '10','showvalues': '1','rotatevalues': '1','valueposition': 'auto' },
//'categories': 
//[ { 'category':
// [{ 'label': '安规培训' },{ 'label': '安规培训1' },] } ],
//'dataset': 
//[{ 'seriesname': '员工课程平均学习时间', 'color': 'A66EDD', 'data': [{ 'value': '76' },{ 'value': '50' },] }, 
//{ 'seriesname': '我的课程学习时间', 'color': 'F6BD0F', 'data': [{ 'value': '75' },{ 'value': '50' },] } ] }
//
//	var lineChart = new FusionCharts( "resource/script/fusioncharts/swf/MSLine.swf","lineContainerId", "400", "300", "0" );
//	lineChart.setChartData(objJson , "json");
//	lineChart.render("lineContainer");
//}
//function initPie(){
//	var objJson={'chart': {'caption': '当前课程完成度','formatnumberscale': '1','startingangle': '125','pieslicedepth': '30','numberprefix': '','decimals': '0', 'animation': '1','palette': '1'},'data': [{'label': '进行中','value': '3','issliced': '1'},{'label': '已完成','value': '1','issliced': '1'},]}
//	var pieChart = new FusionCharts("resource/script/fusioncharts/swf/Pie3D.swf", "pieContainerId", "560", "400", "0", "0");
//	pieChart.setChartData(objJson , "json");	   
//	pieChart.render("pieContainer");
//}
//function initWidget(){
//	var objJson={ "chart": { "manageresize": "1", "origw": "280", "origh": "280", "bgcolor": "FFFFFF", "upperlimit": "180", "lowerlimit": "0", "majortmnumber": "7", "majortmcolor": "AF9A03", "majortmheight": "8", "minortmnumber": "0", "majortmthickness": "8", "showgaugeborder": "0", "gaugeouterradius": "100", "gaugeoriginx": "140", "gaugeoriginy": "140", "gaugestartangle": "230", "gaugeendangle": "-50", "placevaluesinside": "1", "gaugeinnerradius": "90", "tickvaluedistance": "17", "pivotradius": "12", "pivotfillmix": "{AF9A03},{ffffff}", "pivotbordercolor": "AF9A03", "pivotborderthickness": "2", "pivotfillratio": "50,50", "pivotfilltype": "linear", "showpivotborder": "1", "showshadow": "0" }, "dials": { "dial": [ { "value": "25", "borderalpha": "0", "bgcolor": "6A6FA6,AF9A03", "basewidth": "4", "topwidth": "4", "radius": "93" } ] }, "annotations": { "groups": [ { "x": "140", "y": "140", "items": [ { "type": "circle", "radius": "110", "fillpattern": "linear", "fillcolor": "eeeeee,ebce05,eeeeee", "fillratio": "0,100,0", "fillangle": "270", "showborder": "1", "bordercolor": "444444", "borderthickness": "1" }, { "type": "circle", "radius": "100", "fillpattern": "linear", "fillcolor": "ffffff,ebce05,eeeeee", "fillalpha": "100,10,100", "fillratio": "5,83,12", "fillangle": "270" } ] } ] } }
//	var widgetChart = new FusionCharts("resource/script/fusioncharts/swf/AngularGauge.swf", "widgetContainerId", "300", "300", "0", "0");
//	widgetChart.setChartData(objJson , "json");	   
//	widgetChart.render("widgetContainer");
//}
var clickDelay
//获取每一章节中具体的内容
function readChapterContent(read){
    var chapterID = read.attr("id");
	var chapterName = read.text();
	clickDelay = setTimeout(function(){
		$.getJSON("learning/TrainCourseAction_trainCourseContent?chapterID="+chapterID,function(data){
			var contents="";
			$.each(data.bookChapterContents,function(i,v){
				contents+="<div><div>"+v.contentName+"</div><div>"+v.content+"</div></div>";
			});		
			contents+="</div>";
			$("#currentChapter").text(chapterName);
			$("#course_content").html(contents);
		});
	},300);
}

function readChapterContentOut(read){
	clearTimeout(clickDelay);
}
//获取每一小节中具体的内容
function readItemContent(read){
	var itemId=read.attr("id");
    var title=read.text();
  
	clickDelay = setTimeout(function(){
	$.getJSON("learning/TrainCourseAction_ChapterItemContent?itemID="+itemId,function(data){
			var contents="";
		$.each(data.bookChapterContents,function(i,v){
			contents+="<div>"+v.content+"</div>";
		});
		contents+="</div>";
		$("#course_content").html(contents);
		$("#currentChapter").text(title);
		$("#save").attr("contentId",itemId);
	});
},300);	
	}

function finishThisItem($this){
	var myTrainCourseId=$this.attr("myTrainCourseId");
	var itemID=$this.attr("contentId");
	$.get("learning/TrainCourseAction_finishThisItem?myTrainCourseId="+myTrainCourseId+"&itemID="+itemID);
} 

function finishRead(userId,trainCourseId){
	$.get("learning/TrainCourseAction_finishCurrentCourse?userId="+userId+"&trainCourseId="+trainCourseId);
}

