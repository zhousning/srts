/**
 * 图一，各类课程资源统计
 */
function initColumn(){
	$.getJSON("learning/OnlineCourseManageAction_courseTypeCount",function(data){
		var courseCount = eval("(" + data.statisticPo.onlineCourseCount + ")");
		var courseCountChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","courseTypeCountID", "280", "200", "0" );
		courseCountChart.setChartData(courseCount , "json");
		courseCountChart.render("courseCountContainer");
		
		var courseViewCount = eval("(" + data.statisticPo.onlineCourseViewCount + ")");
		var courseViewCountChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","courseViewCountID", "280", "200", "0" );
		courseViewCountChart.setChartData(courseViewCount , "json");
		courseViewCountChart.render("courseViewCountContainer");
		
		var courseLoadCount = eval("(" + data.statisticPo.onlineCourseLoadCount + ")");
		var courseLoadCountChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","courseLoadCountID", "280", "200", "0" );
		courseLoadCountChart.setChartData(courseLoadCount , "json");
		courseLoadCountChart.render("courseLoadCountContainer");
	});
}


/**
 * 点击切换各个课程管理
 * @param {Object} $this
 */
function onlineCourseListChangeFun($this){
	var clazz = $this.attr("class");
	var clazzs = clazz.split(" ");
	if(clazzs[1]=="bk"){
		
		$(".title_p").css({"color":"#000000","border-bottom":"none"});
		$(".content").hide();
		$("#bk").show();
		$this.css({"color":"#006e6b","border-bottom":"3px solid #006e6b"});
		
		$("#deleteType").attr("course","BOOK");
		//$("#addType").attr("course","BOOK");
		$("#addType").attr("href","learning/OnlineCourseManageAction_onlineCourseManagePost?courseType=BOOK");
	}
	if(clazzs[1]=="pt"){
		$(".title_p").css({"color":"#000000","border-bottom":"none"});
		$(".content").hide();
		$("#pt").show();
		$this.css({"color":"#006e6b","border-bottom":"3px solid #006e6b"});
		
		$("#deleteType").attr("course","PPT");
		//$("#addType").attr("course","PPT");
		$("#addType").attr("href","learning/OnlineCourseManageAction_onlineCourseManagePost?courseType=PPT");
	}
	if(clazzs[1]=="ad"){
		$(".title_p").css({"color":"#000000","border-bottom":"none"});
		$(".content").hide();
		$("#ad").show();
		$this.css({"color":"#006e6b","border-bottom":"3px solid #006e6b"});
		
		$("#deleteType").attr("course","VIDEO");
		//$("#addType").attr("course","VIDEO");
		$("#addType").attr("href","learning/OnlineCourseManageAction_onlineCourseManagePost?courseType=VIDEO");
	}
}
/**
 * 单选设置
 * @param {Object} $this
 */
function ansSingleSelectFun($this){
	var content = "";
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/learning/select_true_BG.png");
		$($($($this.parent("span")).siblings("span")).children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		content = $($this.parent("span")).text();
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/learning/select_false_BG.png");
	}
	var check = $($($($($this.parent("span")).parent(".question_cont")).children("span")).children("img")).hasClass("check");
	if(check){
		$($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("ans","d");
		$($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("content",content);
	}else{
		$($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("ans","u");
		$($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("content","");
	}
}
/**
 * 点击全选按钮后，下面的选择按钮会全部选择
 * @param {Object} $htis
 */
function courseSelectAllFun($this){
	var clazz = $this.attr("class");//clazz用于判断这个选择框有没有处于选择状态
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		$($(".od").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		$($(".od").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}
/**
 * 单个课程的选择与取消
 * @param {Object} $this
 */
function courseSelectSingleFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}

/**
 * 点击当前页
 * @param {Object} $this
 */
function currentPage($this,courseType){
	var pageNum = $this.text();
	$this.parent("li").addClass("active");
	$.each($($this.parent("li")).siblings("li"),function(k,v){
		$(v).removeClass("active");
	});
	if(courseType=="BOOK"){
		$.ajax({
			data:{pageNum:pageNum,courseType:courseType},
			type:"POST",
			url:"learning/OnlineCourseManageAction_queryCurrentPage",
			dataType:"json",
			success:function(data){
				var strHtml= "<ul class='list_ul'>";
				$.each(data.bookPo.bookInfos,function(key,val){
					strHtml+="<li class='item'>" +
					"<div class='item_div item_divn'>" +
						"<div class='od'><img src='resource/image/learning/select_false_BG.png' onclick='courseSelectSingleFun($(this))'/></div>"+
						"<div class=ne dtcur><a href=\"learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds="+val.id+"&courseType=BOOK\">"+val.bookName+"</a></div>"+
						"<div class='dt'>共&nbsp;"+val.chapters.length+"&nbsp;章</div>" +
						"<div class='ne dt1'>"+val.bookIntro+"</div>" +
						"<div class='dt'>"+val.uploadUsr+"</div>" +
						"<div class='dt dt1'>"+val.date+"</div>" +
						"<div class='dt'>"+val.viewCount+"</div>" +
						"<div class='dt dtcur'>操作</div>" +
					"</div>" +
					"</li>";
				});
				strHtml+="</ul>";
				$("#bookInfoContent").html(strHtml);
			}
		});
	}
	if(courseType=="PPT"){
		$.ajax({
			data:{pageNum:pageNum,courseType:courseType},
			type:"POST",
			url:"learning/OnlineCourseManageAction_queryCurrentPage",
			dataType:"json",
			success:function(data){
				var strHtml= "<ul class='list_ul'>";
				$.each(data.pptPo.pptInfos,function(key,val){
					strHtml+="<li class='item'>"+
						"<div class='item_div item_divn'>" +
						"<div class='od'><img src='resource/image/learning/select_false_BG.png' onclick='courseSelectSingleFun($(this))'/></div>"+
							"<div class='ne dtcur'><a href=\"learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds="+val.id+"&courseType=PPT\">"+val.pptName+"</a></div>"+
							"<div class='ne dt1'>"+val.pptIntro+"</div>"+
							"<div class='dt'>"+val.uploadUsr+"</div>"+
							"<div class='dt dt1'>"+val.uploadDate+"</div>"+
							"<div class='dt'>"+val.readCount+"</div>"+
							"<div class='dt'>"+val.loadCount+"</div>"+
							"<div class='dt dtcur'>操作</div>"+
						"</div>"+
					"</li>";
				});
				strHtml+="</ul>";
				$("#pptInfoContent").html(strHtml);
			}
		});
	}
	if(courseType=="VIDEO"){
		$.ajax({
			data:{pageNum:pageNum,courseType:courseType},
			type:"POST",
			url:"learning/OnlineCourseManageAction_queryCurrentPage",
			dataType:"json",
			success:function(data){
				var strHtml= "<ul class='list_ul'>";
				$.each(data.videoPo.videoInfos,function(key,val){
					strHtml+="<li class='item'>"+
						"<div class='item_div item_divn'>" +
						"<div class='od'><img src='resource/image/learning/select_false_BG.png' onclick='courseSelectSingleFun($(this))'/></div>"+
							"<div class='ne dtcur'><a href=\"learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds="+val.id+"&courseType=VIDEO\">"+val.videoName+"</a></div>"+
							"<div class='ne dt1'>"+val.videoIntro+"</div>"+
							"<div class='dt'>"+val.uploadUsr+"</div>"+
							"<div class='dt dt1'>"+val.uploadDate+"</div>"+
							"<div class='dt'>"+val.viewCount+"</div>"+
							"<div class='dt'>"+val.loadCount+"</div>"+
							"<div class='dt dtcur'>操作</div>"+
						"</div>"+
					"</li>";
				});
				strHtml+="</ul>";
				$("#videoInfoContent").html(strHtml);
			}
		});
	}
}

/**
 * 向前翻滚
 * @param {Object} $this
 */
function prePages($this,courseType){
	var pageNum = $($($this.parent("li")).next("li")).children("a").text();
	if(courseType=="BOOK"){
		$.ajax({
			data:{pageNum:pageNum,courseType:courseType},
			type:"POST",
			url:"learning/OnlineCourseManageAction_getCourseTurnForwardPage",
			dataType:"json",
			success:function(data){
				var strHtml= "<ul class='list_ul'>";
				$.each(data.bookPo.bookInfos,function(key,val){
					strHtml+="<li class='item'>" +
					"<div class='item_div item_divn'>" +
						"<div class='od'><img src='resource/image/learning/select_false_BG.png' onclick='courseSelectSingleFun($(this))'/></div>"+
						"<div class=ne dtcur><a href=learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds="+val.id+"&courseType=BOOK>"+val.bookName+"</a></div>"+
						"<div class='dt'>共&nbsp;"+val.chapters.length+"&nbsp;章</div>" +
						"<div class='ne dt1'>"+val.bookIntro+"</div>" +
						"<div class='dt'>"+val.uploadUsr+"</div>" +
						"<div class='dt dt1'>"+val.date+"</div>" +
						"<div class='dt'>"+val.viewCount+"</div>" +
						"<div class='dt dtcur'>操作</div>" +
					"</div>" +
					"</li>";
				});
				strHtml+="</ul>";
				$("#bookInfoContent").html(strHtml);
				var pageHtml = "<ul class='page_ul'>";
				$.each(data.bookPo.pageLi,function(key,val){
					pageHtml+=val;
				});
				pageHtml+="<li class='total disabled'><a>共"+data.bookPo.totalPage+"页</a></li></ul>";
				$("#bookPagination").html(pageHtml);
			}
		});
	}
	if(courseType=="PPT"){
		$.ajax({
			data:{pageNum:pageNum,courseType:courseType},
			type:"POST",
			url:"learning/OnlineCourseManageAction_getCourseTurnForwardPage",
			dataType:"json",
			success:function(data){
			var strHtml= "<ul class='list_ul'>";
				$.each(data.pptPo.pptInfos,function(key,val){
					strHtml+="<li class='item'>"+
						"<div class='item_div item_divn'>" +
						"<div class='od'><img src='resource/image/learning/select_false_BG.png' onclick='courseSelectSingleFun($(this))'/></div>"+
							"<div class='ne dtcur'><a href='learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds="+val.id+"&courseType=PPT>"+val.pptName+"</a></div>"+
							"<div class='ne dt1'>"+val.pptIntro+"</div>"+
							"<div class='dt'>"+val.uploadUsr+"</div>"+
							"<div class='dt dt1'>"+val.uploadDate+"</div>"+
							"<div class='dt'>"+val.readCount+"</div>"+
							"<div class='dt'>"+val.loadCount+"</div>"+
							"<div class='dt dtcur'>操作</div>"+
						"</div>"+
					"</li>";
				});
				strHtml+="</ul>";
				$("#pptInfoContent").html(strHtml);
				var pageHtml = "<ul class='page_ul'>";
				$.each(data.pptPo.pageLi,function(key,val){
					pageHtml+=val;
				});
				pageHtml+="<li class='total disabled'><a>共"+data.pptPo.totalPage+"页</a></li></ul>";
				$("#bookPagination").html(pageHtml);
			}
		});
	}
	if(courseType=="VIDEO"){
		$.ajax({
			data:{pageNum:pageNum,courseType:courseType},
			type:"POST",
			url:"learning/OnlineCourseManageAction_getCourseTurnForwardPage",
			dataType:"json",
			success:function(data){
				var strHtml= "<ul class='list_ul'>";
				$.each(data.videoPo.videoInfos,function(key,val){
					strHtml+="<li class='item'>"+
						"<div class='item_div item_divn'>" +
						"<div class='od'><img src='resource/image/learning/select_false_BG.png' onclick='courseSelectSingleFun($(this))'/></div>"+
							"<div class='ne dtcur'><a href='learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds="+val.id+"&courseType=VIDEO>"+val.videoName+"</a></div>"+
							"<div class='ne dt1'>"+val.videoIntro+"</div>"+
							"<div class='dt'>"+val.uploadUsr+"</div>"+
							"<div class='dt dt1'>"+val.uploadDate+"</div>"+
							"<div class='dt'>"+val.viewCount+"</div>"+
							"<div class='dt'>"+val.loadCount+"</div>"+
							"<div class='dt dtcur'>操作</div>"+
						"</div>"+
					"</li>";
				});
				strHtml+="</ul>";
				$("#videoInfoContent").html(strHtml);
				var pageHtml = "<ul class='page_ul'>";
				$.each(data.videoPo.pageLi,function(key,val){
					pageHtml+=val;
				});
				pageHtml+="<li class='total disabled'><a>共"+data.videoPo.totalPage+"页</a></li></ul>";
				$("#bookPagination").html(pageHtml);
			}
		});
	}
}

/**
 * 向后翻滚
 * @param {Object} $this
 */
function aftPages($this,courseType){
	var pageNum = $($($this.parent("li")).prev("li")).children("a").text();
	if(courseType=="BOOK"){
		$.ajax({
			data:{pageNum:pageNum,courseType:courseType},
			type:"POST",
			url:"learning/OnlineCourseManageAction_getCourseTurnAfterPage",
			dataType:"json",
			success:function(data){
				var strHtml= "<ul class='list_ul'>";
				$.each(data.bookPo.bookInfos,function(key,val){
					strHtml+="<li class='item'>" +
					"<div class='item_div item_divn'>" +
						"<div class='od'><img src='resource/image/learning/select_false_BG.png' onclick='courseSelectSingleFun($(this))'/></div>"+
						"<div class=ne dtcur><a href=learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds="+val.id+"&courseType=BOOK>"+val.bookName+"</a></div>"+
						"<div class='dt'>共&nbsp;"+val.chapters.length+"&nbsp;章</div>" +
						"<div class='ne dt1'>"+val.bookIntro+"</div>" +
						"<div class='dt'>"+val.uploadUsr+"</div>" +
						"<div class='dt dt1'>"+val.date+"</div>" +
						"<div class='dt'>"+val.viewCount+"</div>" +
						"<div class='dt dtcur'>操作</div>" +
					"</div>" +
					"</li>";
				});
				strHtml+="</ul>";
				$("#bookInfoContent").html(strHtml);
				var pageHtml = "<ul class='page_ul'>";
				$.each(data.bookPo.pageLi,function(key,val){
					pageHtml+=val;
				});
				pageHtml+="<li class='total disabled'><a>共"+data.bookPo.totalPage+"页</a></li></ul>";
				$("#bookPagination").html(pageHtml);
			}
		});
	}
	if(courseType=="PPT"){
		$.ajax({
			data:{pageNum:pageNum,courseType:courseType},
			type:"POST",
			url:"learning/OnlineCourseManageAction_getCourseTurnAfterPage",
			dataType:"json",
			success:function(data){
			var strHtml= "<ul class='list_ul'>";
				$.each(data.pptPo.pptInfos,function(key,val){
					strHtml+="<li class='item'>"+
						"<div class='item_div item_divn'>" +
						"<div class='od'><img src='resource/image/learning/select_false_BG.png' onclick='courseSelectSingleFun($(this))'/></div>"+
							"<div class='ne dtcur'><a href='learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds="+val.id+"&courseType=PPT>"+val.pptName+"</a></div>"+
							"<div class='ne dt1'>"+val.pptIntro+"</div>"+
							"<div class='dt'>"+val.uploadUsr+"</div>"+
							"<div class='dt dt1'>"+val.uploadDate+"</div>"+
							"<div class='dt'>"+val.readCount+"</div>"+
							"<div class='dt'>"+val.loadCount+"</div>"+
							"<div class='dt dtcur'>操作</div>"+
						"</div>"+
					"</li>";
				});
				strHtml+="</ul>";
				$("#pptInfoContent").html(strHtml);
				var pageHtml = "<ul class='page_ul'>";
				$.each(data.pptPo.pageLi,function(key,val){
					pageHtml+=val;
				});
				pageHtml+="<li class='total disabled'><a>共"+data.pptPo.totalPage+"页</a></li></ul>";
				$("#bookPagination").html(pageHtml);
			}
		});
	}
	if(courseType=="VIDEO"){
		$.ajax({
			data:{pageNum:pageNum,courseType:courseType},
			type:"POST",
			url:"learning/OnlineCourseManageAction_getCourseTurnAfterPage",
			dataType:"json",
			success:function(data){
				var strHtml= "<ul class='list_ul'>";
				$.each(data.videoPo.videoInfos,function(key,val){
					strHtml+="<li class='item'>"+
						"<div class='item_div item_divn'>" +
						"<div class='od'><img src='resource/image/learning/select_false_BG.png' onclick='courseSelectSingleFun($(this))'/></div>"+
							"<div class='ne dtcur'><a href='learning/OnlineCourseManageAction_onlineCourseManageDisp?courseIds="+val.id+"&courseType=VIDEO>"+val.videoName+"</a></div>"+
							"<div class='ne dt1'>"+val.videoIntro+"</div>"+
							"<div class='dt'>"+val.uploadUsr+"</div>"+
							"<div class='dt dt1'>"+val.uploadDate+"</div>"+
							"<div class='dt'>"+val.viewCount+"</div>"+
							"<div class='dt'>"+val.loadCount+"</div>"+
							"<div class='dt dtcur'>操作</div>"+
						"</div>"+
					"</li>";
				});
				strHtml+="</ul>";
				$("#videoInfoContent").html(strHtml);
				var pageHtml = "<ul class='page_ul'>";
				$.each(data.videoPo.pageLi,function(key,val){
					pageHtml+=val;
				});
				pageHtml+="<li class='total disabled'><a>共"+data.videoPo.totalPage+"页</a></li></ul>";
				$("#bookPagination").html(pageHtml);
			}
		});
	}
}

/**
 * 根据选择id删除课本
 */
function deleteOnlineCourse($this){
	var courseType = $this.attr("course");
	var item;
	if(courseType == "BOOK"){
		item = $($("#bookInfoContent").children(".list_ul")).children(".item");
	}
	if(courseType == "PPT"){
		item = $($("#pptInfoContent").children(".list_ul")).children(".item");
	}
	if(courseType == "VIDEO"){
		item = $($("#videoInfoContent").children(".list_ul")).children(".item");
	}
	var courseIds="";
	$.each(item,function(key,val){
		var img = $($($(this).children(".item_div")).children(".od")).children("img");
		if($(img).hasClass("check")){
			var ids = $(img).attr("id");
			courseIds += ids+",";
		}
	});
	if(courseIds!=""){
		$.ajax({
			data:{courseIds:courseIds,courseType:courseType},
			type:"POST",
			url:"learning/OnlineCourseManageAction_deleteOnlineCourse",
			dataType:"json",
			success:function(data){
				alert(data.messages);
				window.location.href = "learning/OnlineCourseManageAction_onlineCourseManageList";
			}
		});
	}else{
		alert("请选择要删除的课程");
	}
}
function addOnlineCourse($this){
	alert("add");
}





