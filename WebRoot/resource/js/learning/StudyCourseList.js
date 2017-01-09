/**
 * 初始化各类图标
 */
function initChart(){
	$.getJSON("learning/StudyCourseAction_studyCourseAnalysis",function(data){
		var studySumTime = eval("(" + data.studyCoursePo.studyCourseSumTime + ")");
		var sumTimeChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","studySumTimeId", "360", "280", "0" );
		sumTimeChart.setChartData(studySumTime , "json");
		sumTimeChart.render("columnContainer");
		
		var studySchedule = eval("(" + data.studyCoursePo.studyCourseSchedule + ")");
		var scheduleChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","studyScheduleId", "360", "280", "0" );
		scheduleChart.setChartData(studySchedule , "json");
		scheduleChart.render("barContainer");
		
		var studyNumCount= eval("(" + data.studyCoursePo.studyCourseNumCount + ")");
		var numCountChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","studyNumCountId", "360", "280", "0" );
		numCountChart.setChartData(studyNumCount , "json");
		numCountChart.render("lineContainer");
	});
}
/**
 * 用于右侧显示自主学习书章节信息
 * @param {Object} $this
 */
var delay;
function bookChapterInfo_over($this){
	delay = setTimeout(function(){
		var chapterInfo = $this.attr("chapter-info");
		var data =  eval("(" + chapterInfo + ")");
		var schedule = "";
		var strHTML = "<div class='myStudyCourse_chapter_table'><table><tr><td>章节</td><td>状态</td><td>用时</td></tr>";
		var bookID;
		for(var o in data){
			var temp = data[o];
			if(o=="bookId"){
				bookID = temp;
			}
			for(var i = 0 ; i < temp.length; i++){ 
				for(var t in temp[i]){ 
					if(t == "chapterName"){
						strHTML+="<tr><td>"+temp[i][t]+"</td>";
					}
					if(t=="sumTime"){
						strHTML+="<td>"+temp[i][t]+"</td>";
					}
					if(t=="status"){
						strHTML+="<td>"+temp[i][t]+"</td></tr>";
					}
					if(t=="schedule"){
						schedule = temp[i][t];
					}
				}
			}
		}
		strHTML+="</table><div>自主学习进度："+schedule+"</div><div><a href='learning/StudyCourseAction_studyBookOtherChapter?bookID="+bookID+"'>继续学习</a></div></div>"
		$("#bookChapterInfo").html(strHTML);
		$this.addClass("current");
		var brother = $($this.parent(".myStudyCourse_main_books")).siblings();
		$(brother).children(".myStudyCourse_main_book").removeClass("current");
	},300);
}
//var delay;
//function bookChapterInfo_over($this){
//delay = setTimeout(function(){
//	var chapterInfo = $($this.parent(".myStudyCourse_main_book")).attr("chapter-info");
//	var data =  eval("(" + chapterInfo + ")");
//	//var dataJSON = "{'chapters':[{'chapterID':'1','chapterName':'第一章总  则','sumTime':'20','status':'完成','schedule':'42','startTime':'2014-05-11|09-18','endTime':'2014-05-11|10-00'},{'chapterID':'2','chapterName':'第二章违章界定','sumTime':'20','status':'完成','schedule':'42','startTime':'2014-05-12|09-18','endTime':'2014-05-12|09-18'},{'chapterID':'3','chapterName':'第三章职责分工','sumTime':'20','status':'完成','schedule':'42','startTime':'2014-05-12|09-18','endTime':'2014-05-12|09-18'},{'chapterID':'4','chapterName':'第四章工作机制','sumTime':'20','status':'进行中','schedule':'42','startTime':'2014-05-11|09-18','endTime':'2014-05-11|10-00'},]}";
//	//var data = eval("(" + dataJSON + ")");
//	var schedule = "";
//	var strHTML = "<div class='myStudyCourse_chapter_table'><table><tr><td>章节</td><td>状态</td><td>用时</td></tr>";
//	for(var o in data){  
//    	var temp = data[o];  
//   	 	for(var i = 0 ; i < temp.length; i++){  
//        	for(var t in temp[i]){ 
//        		if(t == "chapterName"){
//        			//alert("t1"+t);
//        			strHTML+="<tr><td>"+temp[i][t]+"</td>";
//        		}
//        		if(t=="sumTime"){
//        			//alert("t2"+t);
//        			strHTML+="<td>"+temp[i][t]+"</td>";
//        		}
//        		if(t=="status"){
//        			//alert("t2"+t);
//        			strHTML+="<td>"+temp[i][t]+"</td></tr>";
//        		}
//        		if(t=="schedule"){
//        			schedule = temp[i][t];
//        		}
//        	}  
//    	}  
//	} 
////	$.each(data.chapters,function(i,v){
////		$_this = $(v);
////		strHTML+="<tr><td>"+v.chapterName+"</td><td>"+v.status+"</td><td>"+v.sumTime+"</td></tr>";
////		schedule=v.schedule;
////	});
//	strHTML+="</table><div>自主学习进度："+schedule+"</div></div>";
//	$("#bookChapterInfo").html(strHTML);
//	$this.parent(".myStudyCourse_main_book").addClass("current");
//	
//	var brothers = $($this.parents(".myStudyCourse_main_books")).siblings();
//	$($(brothers).children(".myStudyCourse_main_book").children("img")).removeClass("current");
//},300);
//}
function bookChapterInfo_out($this){
	clearTimeout(delay);
}
////1
//function initColumn(){	
//	var objJson = {'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','labelDisplay':'WRAP','useEllipsesWhenOverflow':'0','caption':'当前各门课程学习时间累计','xAxisName':'课程','yAxisName':'时间','numberPrefix':'时间'},'data':[{'label':'国家电网公司安全生产反违章工作管理办法','value':'80'},{'label':'国家电网公司安全生产反违章工作管理办法','value':'20'},]};
//	var columnChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","columnContainerId", "360", "280", "0" );
//	columnChart.setChartData(objJson , "json");
//	columnChart.render("columnContainer");
//}
////2
//function initBar(){
//	var objJson = {'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','labelDisplay':'WRAP','useEllipsesWhenOverflow':'0','caption':'当前各门课程学习时间累计','xAxisName':'课程','yAxisName':'时间','numberPrefix':'时间'},'data':[{'label':'国家电网公司安全生产反违章工作管理办法','value':'80'},{'label':'国家电网公司安全生产反违章工作管理办法','value':'20'},]};
//  	var barChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","columnContainerId2", "360", "280", "0" );
//	barChart.setChartData(objJson , "json");
//	barChart.render("barContainer");
//}
////3	
//function initLine(){
//	var objJson={'chart': {'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','divlinecolor': '91AF46','xaxisname': '月份','yaxisname':'次数','caption': '月自学次数统计变化趋势','divlinealpha': '30','showvalues': '0','bgcolor': '91AF46,FFFFFF','anchorradius': '5','anchorsides': '3','yaxismaxvalue': '100'},'data':[{'value':'0','label':'2014-01'},{'value':'0','label':'2014-02'},{'value':'0','label':'2014-03'},{'value':'0','label':'2014-04'},{'value':'5','label':'2014-05'},{'value':'0','label':'2014-06'},{'value':'0','label':'2014-07'},{'value':'0','label':'2014-08'},{'value':'0','label':'2014-09'},{'value':'0','label':'2014-10'},{'value':'0','label':'2014-11'},{'value':'0','label':'2014-12'},],'trendlines':[{'line':[{'color': 'BC9F3F','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '一般','endvalue': '80','startvalue': '50'},{'color': '894D1B','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '主动','endvalue': '100','startvalue': '80'}]}]};
//	var lineChart = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","lineContainerId", "360", "280", "0" );
//	lineChart.setChartData(objJson , "json");
//	lineChart.render("lineContainer");
//}
var clickDelay;
function readBookChapterContent($this){
	var chapterID = $this.attr("id");
	var chapterName = $this.text();
	clickDelay = setTimeout(function(){
		$.getJSON("learning/StudyCourseAction_studyChapterContent?chapterID="+chapterID,function(data){
			var contents="";
			$.each(data.chapterContents,function(i,v){
				contents+="<div><div>"+v.contentName+"</div><div>"+v.content+"</div></div>";
			});		
			contents+="</div>";
			$("#currentChapter").text(chapterName);
			$("#course_content").html(contents);
		});
	},300);
}
function readBookChapterContentOut($this){
	clearTimeout(clickDelay);
}



