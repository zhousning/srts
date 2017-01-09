function initChart(){
	$.getJSON("learning/ErrorSetAction_ErrorSetAnalysis",function(data){
		var errorSetCount = eval("(" + data.errorSetPo.errorSetCountByFlag+ ")");
		var errorSetCountChart = new FusionCharts( "resource/script/fusioncharts/swf/Pie3D.swf","pieContainerId", "280", "200", "0" );
		errorSetCountChart.setChartData(errorSetCount , "json");
		errorSetCountChart.render("pieContainer");
		
		var errorSetQuestionCount = eval("(" + data.errorSetPo.errorSetQuestionCountByType + ")");
		var errorSetQuestionCountChart = new FusionCharts( "resource/script/fusioncharts/swf/Bar2D.swf","barContainerId", "280", "200", "0" );
		errorSetQuestionCountChart.setChartData(errorSetQuestionCount , "json");
		errorSetQuestionCountChart.render("barContainer");
		
		var errorSetFlagCountLine= eval("(" + data.errorSetPo.errorSetFlagCount + ")");
		var errorSetFlagCountChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","lineContainerId", "280", "200", "0" );
		errorSetFlagCountChart.setChartData(errorSetFlagCountLine , "json");
		errorSetFlagCountChart.render("lineContainer");
	});
}
/////////////////////////wyw
/**
 * 左侧选择菜单wyw
 * @param {Object} $this
 */
var delayTime;
function errorSetMain_over($this){
delayTime = setTimeout(function(){
	_this_id = $this.attr("id");
	if(_this_id=="level"){
		$(".errorSet_main_set_ul").html("");
		$("#errorSet_main_set").css({"height":"110px","width":"0px"}).animate({height:"110px",width:"600px"});
		$(".errorSet_main_set_title").text("掌握程度选择");
		$(".errorSet_main_set_ul").html("<li><img onclick='errorSetMain_check($(this))' class ='check' src='resource/image/learning/ratio_true_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=zhangwochengdu&newPage=1&flag=0&type=''&timeLength='''>掌握较好</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=zhangwochengdu&newPage=1&flag=1&type=''&timeLength='''>基本掌握</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=zhangwochengdu&newPage=1&flag=2&type=''&timeLength='''>掌握较差</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=zhangwochengdu&newPage=1&flag=3&type=''&timeLength='''>完全不会</span></li>");
	}
	if(_this_id=="type"){
		$(".errorSet_main_set_ul").html("");
		$("#errorSet_main_set").css({"height":"110px","width":"0px"}).animate({height:"110px",width:"600px"});
		$(".errorSet_main_set_title").text("题目类型选择");
		$(".errorSet_main_set_ul").html("<li><img onclick='errorSetMain_check($(this))' class ='check' src='resource/image/learning/ratio_true_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotileixing&type=danxuanti&flag=''&timeLength='''>单选题</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotileixing&type=duoxuanti&newPage=1&flag=''&timeLength='''>多选题</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotileixing&type=panduanti&newPage=1&flag=''&timeLength='''>判断题</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotileixing&type=tiankongti&newPage=1&flag=''&timeLength='''>填空题</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotileixing&type=gaicuoti&newPage=1&flag=''&timeLength='''>改错题</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotileixing&type=mingcijieshi&newPage=1&flag=''&timeLength='''>名词解释</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotileixing&type=jiandati&newPage=1&flag=''&timeLength='''>简答题</span></li>");
	}
	if(_this_id=="time"){
		$(".errorSet_main_set_ul").html("");
		$("#errorSet_main_set").css({"height":"110px","width":"0px"}).animate({height:"110px",width:"600px"});
		$(".errorSet_main_set_title").text("记录日期选择");
		$(".errorSet_main_set_ul").html("<li><img onclick='errorSetMain_check($(this))' class ='check' src='resource/image/learning/ratio_true_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotishijian&newPage=1&timeLength=1&flag=''&type='''>1天</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotishijian&newPage=1&timeLength=2&flag=''&type='''>2天</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotishijian&newPage=1&timeLength=6&flag=''&type='''>6天</span></li>" +
		"<li><img onclick='errorSetMain_check($(this))' src='resource/image/learning/ratio_false_BG.png'/><span id='learning/ErrorSetAction_ErrorSetDisp?modelType=cuotishijian&newPage=1&timeLength=31&flag=''&type='''>31天</span></li>");
	}
},300);
}
function errorSetMain_out(){
	clearTimeout(delayTime);
}
/*
 * 用于单选框切换wyw
 * @param {Object} $this
 */
function errorSetMain_check($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check");
		$this.attr("src","resource/image/learning/ratio_true_BG.png");
		$($($this.parent("li")).siblings()).children("img").removeClass("check").attr("src","resource/image/learning/ratio_false_BG.png");
	}
}
function errorSet_exerise(){
	var urlID = $($(".check").siblings()).attr("id");//获取url
	window.location.href=urlID;
}
////////////////////////wyw


//function initPie(){
//	var objJson={"chart": 
//	{"caption": "错题掌握情况百分比",
//	"formatnumberscale": "1",
//	"startingangle": "125",
//	"pieslicedepth": "30",
//	"numberprefix": "",
//	"decimals": "0", 
//	"animation": "1",
//	"palette": "1"},
//	"data": [
//		{"label": "掌握教好","value": "65","issliced": "1"},
//		{"label": "基本掌握","value": "25","issliced": "1"},
//		{"label": "掌握较差","value": "5","issliced": "1"},
//		{"label": "完全不会","value": "5","issliced": "1"}]}
//	var pieChart = new FusionCharts("resource/script/fusioncharts/swf/Pie3D.swf", "pieContainerId", "560", "400", "0", "0");
//	pieChart.setChartData(objJson , "json");	   
//	pieChart.render("pieContainer");
//}
//function initLine(){
//	var objJson = {"chart": {
//    	"valueposition": "auto",
//   	 	"rotatevalues": "1",
//    	"showvalues": "1",
//    	"linealpha": "85",
//    	"linecolor": "FF5904",
//    	"basefontcolor": "666666",
//    	"canvasbordercolor": "666666",
//    	"alternatehgridalpha": "5",
//    	"divlinealpha": "20",
//    	"divlinecolor": "ff5904",
//    	"alternatehgridcolor": "ff5904",
//    	"showalternatehgridcolor": "1",
//    	"animation": "1",
//    	"showcolumnshadow": "1",
//    	"showlabels": "1",
//    	"numberprefix": "",
//    	"yaxisname": "综合指数",
//    	"xaxisname": "日期",
//    	"caption": "错题复习变化曲线",
//    	"canvaspadding": "10"},
//  		"data": [{"value": "10","label": "Jan"},
//    			{"value": "18","label": "Feb"},
//    			{"value": "12","label": "Mar"},
//   	 			{"value": "14","label": "Apr"},
//    			{"value": "2","label": "May"},
//    			{"value": "4","label": "Jun"},
//    			{"value": "5","label": "Jul"},
//    			{"value": "8","label": "Aug"},
//    			{"value": "3","label": "Sep"},
//    			{"value": "1","label": "Oct"},
//    			{"value": "2","label": "Nov"},
//    			{"value": "1","label": "Dec"}]};
//	var lineChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","lineContainerId", "400", "300", "0" );
//	lineChart.setChartData(objJson , "json");
//	lineChart.render("lineContainer");
//}
//function initColumn(){
//	var objJson = {"chart":
//	{"caption":"各类错题复习统计",
//		"xAxisName":"类型",
//		"yAxisName":"总数",
//		"numberPrefix":"总数"},
//	"data":
//		[{"label":"掌握度","value":"8"},
//			{"label":"错题类型","value":"10"},
//			{"label":"错题时间","value":"5"}]}
//	var columnChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","columnContainerId", "400", "300", "0" );
//	columnChart.setChartData(objJson , "json");
//	columnChart.render("columnContainer");
//}