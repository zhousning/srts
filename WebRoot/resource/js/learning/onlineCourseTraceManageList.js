/**
 * 初始化设置默认查询日期为当前月
 * @memberOf {TypeName} 
 */
window.onload = function(){
	var fullDate = new Date();
	var noticeYear = fullDate.getFullYear();
	var noticeMonth = fullDate.getMonth();
	var yearDom = $("#noticeYear option");
	var monthDom = $("#noticeMonth option");
	
	var year1Dom = $("#noticeYear1 option");
	var month1Dom = $("#noticeMonth1 option");
	
	$.each(yearDom,function(key,val){
		if($(this).val()==noticeYear){
			$(this).attr("selected","selected");
		}
	});
	$.each(monthDom,function(key,val){
		if($(this).val()==eval(noticeMonth+1)){
			$(this).attr("selected","selected");
		}
	});
	
	$.each(year1Dom,function(key,val){
		if($(this).val()==noticeYear){
			$(this).attr("selected","selected");
		}
	});
	$.each(month1Dom,function(key,val){
		if($(this).val()==eval(noticeMonth+1)){
			$(this).attr("selected","selected");
		}
	});
	
	var noticeTitle = $("#noticeTitle option");
	var tf = false;
	$.each(noticeTitle,function(key,val){
		var optionId = $(val).attr("id");
		if(optionId == eval(noticeMonth+1)){
			$(val).attr("selected","selected");
			tf = true;
			return false;
		}
	});
	initScrollLine();
}
/**
 * 点击当前页
 * @param {Object} $this
 */
function currentPage($this){
	var pageNum = $this.text();
	var noticeYear = $("#noticeYear option:selected").text();
	var noticeMonth = $("#noticeMonth option:selected").val();
	
	$this.parent("li").addClass("active");
	$.each($($this.parent("li")).siblings("li"),function(k,v){
		$(v).removeClass("active");
	});
	
	$.ajax({
		data:{pageNum:pageNum,noticeYear:noticeYear,noticeMonth:noticeMonth},
		type:"POST",
		url:"learning/OnlineCourseTraceManageAction_queryCurrentPage",
		dataType:"json",
		success:function(data){
			var strHtml= "<ul class='list_ul'>";
			$.each(data.tracePo.traces,function(key,val){
				strHtml+="<li class='item'>" +
				"<div class='item_div'>" +
					"<div class=\"od\">"+eval(key+1)+"</div>"+
					"<div class=\"dt\">"+val.usrName+"</div>"+
					"<div class=\"dt\">"+val.usrMajor+"</div>" +
					"<div class=\"dt\">"+val.usrCompany+"</div>" +
					"<div class=\"ne\">"+val.studyCourse+"</div>" +
					"<div id=\""+val.usrId+"\" class=\"dt dtcur\" onclick=\"recordDetailFun($(this))\">点击查看</div>" +
					"<div class=\"dt\">"+val.studyTime+"</div>" +
				"</div>" +
				"</li>";
			});
			strHtml+="</ul>";
			$("#traceContent").html(strHtml);
		}
	});
}
/**
 * 向前翻滚
 * @param {Object} $this
 */
function prePages($this){
	var pageNum = $($($this.parent("li")).next("li")).children("a").text();
	var noticeYear = $("#noticeYear option:selected").text();
	var noticeMonth = $("#noticeMonth option:selected").val();
	
	$.ajax({
		data:{pageNum:pageNum,noticeYear:noticeYear,noticeMonth:noticeMonth},
		type:"POST",
		url:"learning/OnlineCourseTraceManageAction_getCourseTurnForwardPage",
		dataType:"json",
		success:function(data){
			var strHtml= "<ul class='list_ul'>";
			$.each(data.tracePo.traces,function(key,val){
				strHtml+="<li class='item'>" +
				"<div class='item_div'>" +
					"<div class=\"od\">"+eval(key+1)+"</div>"+
					"<div class=\"dt\">"+val.usrName+"</div>"+
					"<div class=\"dt\">"+val.usrMajor+"</div>" +
					"<div class=\"dt\">"+val.usrCompany+"</div>" +
					"<div class=\"ne\">"+val.studyCourse+"</div>" +
					"<div id=\""+val.usrId+"\" class=\"dt dtcur\" onclick=\"recordDetailFun($(this))\">点击查看</div>" +
					"<div class=\"dt\">"+val.studyTime+"</div>" +
				"</div>" +
				"</li>";
			});
			strHtml+="</ul>";
			$("#traceContent").html(strHtml);
			var pageHtml = "<ul class='page_ul'>";
			$.each(data.tracePo.pageLi,function(key,val){
				pageHtml+=val;
			});
			pageHtml+="<li class='total disabled'><a>共"+data.tracePo.totalPage+"页</a></li></ul>";
			$("#tracePagination").html(pageHtml);
		}
	});
}

/**
 * 向后翻滚
 * @param {Object} $this
 */
function aftPages($this){
	var pageNum = $($($this.parent("li")).prev("li")).children("a").text();
	var noticeYear = $("#noticeYear option:selected").text();
	var noticeMonth = $("#noticeMonth option:selected").val();
	
	$.ajax({
		data:{pageNum:pageNum,noticeYear:noticeYear,noticeMonth:noticeMonth},
		type:"POST",
		url:"learning/OnlineCourseTraceManageAction_getCourseTurnAfterPage",
		dataType:"json",
		success:function(data){
			var strHtml= "<ul class='list_ul'>";
			$.each(data.tracePo.traces,function(key,val){
				strHtml+="<li class='item'>" +
				"<div class='item_div'>" +
					"<div class=\"od\">"+eval(key+1)+"</div>"+
					"<div class=\"dt\">"+val.usrName+"</div>"+
					"<div class=\"dt\">"+val.usrMajor+"</div>" +
					"<div class=\"dt\">"+val.usrCompany+"</div>" +
					"<div class=\"ne\">"+val.studyCourse+"</div>" +
					"<div id=\""+val.usrId+"\" class=\"dt dtcur\" onclick=\"recordDetailFun($(this))\">点击查看</div>" +
					"<div class=\"dt\">"+val.studyTime+"</div>" +
				"</div>" +
				"</li>";
			});
			strHtml+="</ul>";
			$("#traceContent").html(strHtml);
			var pageHtml = "<ul class='page_ul'>";
			$.each(data.tracePo.pageLi,function(key,val){
				pageHtml+=val;
			});
			pageHtml+="<li class='total disabled'><a>共"+data.tracePo.totalPage+"页</a></li></ul>";
			$("#tracePagination").html(pageHtml);
		}
	});
}
/**
 * 根据条件查询
 */
function queryByOptionFunction(){
	
	var company = $("#companyId").val();
	var major = $("#majorId").val();
	var usrName = $("#usrId").val();
	var noticeYear = $("#noticeYear option:selected").text();
	var noticeMonth = $("#noticeMonth option:selected").val();
	var noticeTitle = $("#noticeTitle option:selected").text();
	$.ajax({
		data:{companyName:company,majorName:major,usrName:usrName,noticeYear:noticeYear,noticeMonth:noticeMonth,noticeTitle:noticeTitle},
		type:"POST",
		url:"learning/OnlineCourseTraceManageAction_queryTraceQueryByOption",
		dataType:"json",
		success:function(data){
			var strHtml= "<ul class='list_ul'>";
			
			$.each(data.courseTracePoList,function(key,val){
				strHtml+="<li class='item'>" +
				"<div class='item_div'>" +
					"<div class=\"od\">"+eval(key+1)+"</div>"+
					"<div class=\"dt\">"+val.usrName+"</div>"+
					"<div class=\"dt\">"+val.usrMajor+"</div>" +
					"<div class=\"dt\">"+val.usrCompany+"</div>" +
					"<div class=\"ne\">"+val.studyCourse+"</div>" +
					"<div id=\""+val.usrId+"\" class=\"dt dtcur\" onclick=\"recordDetailFun($(this))\">点击查看</div>" +
					"<div class=\"dt\">"+val.studyTime+"</div>" +
				"</div>" +
				"</li>";
			});
			strHtml+="</ul>";
			$("#traceContent").html(strHtml);
			var pageHtml = "<ul class='page_ul'>";
			$.each(data.pagationLi,function(key,val){
				pageHtml+=val;
			});
			pageHtml+="<li class='total disabled'><a>共"+data.pageCount+"页</a></li></ul>";
			$("#tracePagination").html(pageHtml);
		}
	});
	
}

/**
 * 根据条件查询，查询当前页
 */
function currentPageQBO($this){
	var pageNum = $this.text();
	var company = $("#companyId").val();
	var major = $("#majorId").val();
	var usrName = $("#usrId").val();
	var noticeYear = $("#noticeYear option:selected").text();
	var noticeMonth = $("#noticeMonth option:selected").val();
	var noticeTitle = $("#noticeTitle option:selected").text();
	
	$this.parent("li").addClass("active");
	$.each($($this.parent("li")).siblings("li"),function(k,v){
		$(v).removeClass("active");
	});
	
	$.ajax({
		data:{pageNum:pageNum,companyName:company,majorName:major,usrName:usrName,noticeYear:noticeYear,noticeMonth:noticeMonth,noticeTitle:noticeTitle},
		type:"POST",
		url:"learning/OnlineCourseTraceManageAction_queryCurrentPageQBO",
		dataType:"json",
		success:function(data){
			var strHtml= "<ul class='list_ul'>";
			$.each(data.tracePo.traces,function(key,val){
				strHtml+="<li class='item'>" +
				"<div class='item_div'>" +
					"<div class=\"od\">"+eval(key+1)+"</div>"+
					"<div class=\"dt\">"+val.usrName+"</div>"+
					"<div class=\"dt\">"+val.usrMajor+"</div>" +
					"<div class=\"dt\">"+val.usrCompany+"</div>" +
					"<div class=\"ne\">"+val.studyCourse+"</div>" +
					"<div id=\""+val.usrId+"\" class=\"dt dtcur\" onclick=\"recordDetailFun($(this))\">点击查看</div>" +
					"<div class=\"dt\">"+val.studyTime+"</div>" +
				"</div>" +
				"</li>";
			});
			strHtml+="</ul>";
			$("#traceContent").html(strHtml);
		}
	});
}

/**
 * 根据条件查询，查询上一页
 * @param {Object} $this
 */
function prePagesQBO($this){
	var pageNum = $($($this.parent("li")).next("li")).children("a").text();
	var company = $("#companyId").val();
	var major = $("#majorId").val();
	var usrName = $("#usrId").val();
	var noticeYear = $("#noticeYear option:selected").text();
	var noticeMonth = $("#noticeMonth option:selected").val();
	var noticeTitle = $("#noticeTitle option:selected").text();
	
	$.ajax({
		data:{pageNum:pageNum,companyName:company,majorName:major,usrName:usrName,noticeYear:noticeYear,noticeMonth:noticeMonth,noticeTitle:noticeTitle},
		type:"POST",
		url:"learning/OnlineCourseTraceManageAction_courseTurnForwardPageQBO",
		dataType:"json",
		success:function(data){
			var strHtml= "<ul class='list_ul'>";
			$.each(data.tracePo.traces,function(key,val){
				strHtml+="<li class='item'>" +
				"<div class='item_div'>" +
					"<div class=\"od\">"+eval(key+1)+"</div>"+
					"<div class=\"dt\">"+val.usrName+"</div>"+
					"<div class=\"dt\">"+val.usrMajor+"</div>" +
					"<div class=\"dt\">"+val.usrCompany+"</div>" +
					"<div class=\"ne\">"+val.studyCourse+"</div>" +
					"<div id=\""+val.usrId+"\" class=\"dt dtcur\" onclick=\"recordDetailFun($(this))\">点击查看</div>" +
					"<div class=\"dt\">"+val.studyTime+"</div>" +
				"</div>" +
				"</li>";
			});
			strHtml+="</ul>";
			$("#traceContent").html(strHtml);
			var pageHtml = "<ul class='page_ul'>";
			$.each(data.pagationLi,function(key,val){
				pageHtml+=val;
			});
			pageHtml+="<li class='total disabled'><a>共"+data.tracePo.totalPage+"页</a></li></ul>";
			$("#tracePagination").html(pageHtml);
		}
	});
}

/**
 * 根据条件查询，查询下一页
 * @param {Object} $this
 */
function aftPagesQBO($this){
	var pageNum = $($($this.parent("li")).prev("li")).children("a").text();
	var company = $("#companyId").val();
	var major = $("#majorId").val();
	var usrName = $("#usrId").val();
	var noticeYear = $("#noticeYear option:selected").text();
	var noticeMonth = $("#noticeMonth option:selected").val();
	var noticeTitle = $("#noticeTitle option:selected").text();
	
	$.ajax({
		data:{pageNum:pageNum,companyName:company,majorName:major,usrName:usrName,noticeYear:noticeYear,noticeMonth:noticeMonth,noticeTitle:noticeTitle},
		type:"POST",
		url:"learning/OnlineCourseTraceManageAction_getCourseTurnAfterPageQBO",
		dataType:"json",
		success:function(data){
			var strHtml= "<ul class='list_ul'>";
			$.each(data.tracePo.traces,function(key,val){
				strHtml+="<li class='item'>" +
				"<div class='item_div'>" +
					"<div class=\"od\">"+eval(key+1)+"</div>"+
					"<div class=\"dt\">"+val.usrName+"</div>"+
					"<div class=\"dt\">"+val.usrMajor+"</div>" +
					"<div class=\"dt\">"+val.usrCompany+"</div>" +
					"<div class=\"ne\">"+val.studyCourse+"</div>" +
					"<div id=\""+val.usrId+"\" class=\"dt dtcur\" onclick=\"recordDetailFun($(this))\">点击查看</div>" +
					"<div class=\"dt\">"+val.studyTime+"</div>" +
				"</div>" +
				"</li>";
			});
			strHtml+="</ul>";
			$("#traceContent").html(strHtml);
			var pageHtml = "<ul class='page_ul'>";
			$.each(data.pagationLi,function(key,val){
				pageHtml+=val;
			});
			pageHtml+="<li class='total disabled'><a>共"+data.tracePo.totalPage+"页</a></li></ul>";
			$("#tracePagination").html(pageHtml);
		}
	});
}

/**
 * noticeYear改变后noticeTitle改变
 */
function noticeYearSelectChangeFun(){
	var noticeYear = $("#noticeYear option:selected").text();
	$.ajax({
		data:{noticeYear:noticeYear},
		type:"POST",
		url:"learning/OnlineCourseTraceManageAction_getOnlineCourseNoticeTitle",
		dataType:"json",
		success:function(data){
			var strHtml= "";
			if(data.notices.length!=0){
				$.each(data.notices,function(key,val){
					strHtml += "<option id=\""+val.nonticeMonth+"\" value=\""+val.noticeTitle+"\">"+val.noticeTitle+"</option>";
				});
				$("#noticeTitle").html(strHtml);
			}else{
				$("#noticeTitle").html(strHtml);
			}
		}
	});
}

/**
 * noticeMonth改变后noticeTitle改变
 */
function noticeMonthSelectChangeFun(){
	var noticeMonth = $("#noticeMonth option:selected").text();
	var noticeTitle = $("#noticeTitle option");
	var tf = false;
	$.each(noticeTitle,function(key,val){
		var optionId = $(val).attr("id");
		if(optionId == noticeMonth){
			$(val).attr("selected","selected");
			tf = true;
			return false;
		}
	});
	if(!tf){
		alert("该月份没有培训主题");
	}
}

/**
 * noticeMonth改变后noticeTitle改变
 */
function noticeTitleSelectChangeFun(){
	var noticeTitle = $("#noticeTitle option:selected").attr("id");
	var noticeMonth = $("#noticeMonth option");
	
	$.each(noticeMonth,function(key,val){
		var optionId = $(val).val();
		if(optionId == noticeTitle){
			$(val).attr("selected","selected");
			tf = true;
			return false;
		}
	});
}

/**
* 点击查看单个员工详细的记录
*/
function recordDetailFun($this){
	var userID = $this.attr("id");
	var noticeYear = $("#noticeYear option:selected").text();
	var noticeMonth = $("#noticeMonth option:selected").val();
	var noticeTitle = $("#noticeTitle option:selected").text();
	$.ajax({
		data:{noticeYear:noticeYear,noticeMonth:noticeMonth,noticeTitle:noticeTitle,userID:userID},
		type:"POST",
		url:"learning/OnlineCourseTraceManageAction_userStudyTraceRecord",
		dataType:"json",
		success:function(data){
			var userTraceRecord = eval("(" + data.userTraceRecord + ")");
			if(!FusionCharts("traceRecordId")){
				var traceRecord = new FusionCharts( "resource/script/fusioncharts/swf/Line.swf","traceRecordId", "1178", "315", "0" );
				traceRecord.setChartData(userTraceRecord , "json");
				traceRecord.render("traceRecordContainer");
				$("#userCourseTraceRecord").show();  			
			}else{
				var traceRecord = FusionCharts("traceRecordId");
   				traceRecord.setChartData(userTraceRecord , "json");
				traceRecord.render("traceRecordContainer");
				$("#userCourseTraceRecord").show();
			}	
		}
	});
}

function initScrollLine(){
	$.ajax({
		type:"POST",
		url:"learning/OnlineCourseTraceManageAction_studyTraceStatistics",
		dataType:"json",
		success:function(data){
			var monthChartJson = eval("(" + data.monthTotalEvg + ")");
			var monthChart = new FusionCharts("resource/script/fusioncharts/swf/ScrollLine2D.swf","monthChartID", "1000", "260", "0", "0");
			monthChart.setChartData(monthChartJson , "json");
			monthChart.render("monthCountContainer");
		}
	});	
}
function traceRecordWinClose(){
	$("#traceRecordContainer").html("");
	$("#userCourseTraceRecord").hide();
}
function traceRecordWinOver($this){
	$this.css("color","red");
}
function traceRecordWinOut($this){
	$this.css("color","#000000");
}
function traceRecordWinQuery(){
	alert("建设中");
}
