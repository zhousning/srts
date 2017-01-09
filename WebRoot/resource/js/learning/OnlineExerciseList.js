/**
 * 点击切换各个学习资源
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
	}
	if(clazzs[1]=="pt"){
		$(".title_p").css({"color":"#000000","border-bottom":"none"});
		$(".content").hide();
		$("#pt").show();
		$this.css({"color":"#006e6b","border-bottom":"3px solid #006e6b"});
	}
	if(clazzs[1]=="ad"){
		$(".title_p").css({"color":"#000000","border-bottom":"none"});
		$(".content").hide();
		$("#ad").show();
		$this.css({"color":"#006e6b","border-bottom":"3px solid #006e6b"});
	}
}

function initLine(){
	$.getJSON("learning/OnlineExerciseAction_onlineExerciseAnalysis",function(data){
		//按单位查询
		var data0 = eval("(" + data.getRecentAccuracyRateN+ ")");
		var getRecentAccuracyRateNChart = new FusionCharts("resource/script/fusioncharts/swf/ScrollLine2D.swf","lineContainerID", "1000", "260", "0", "0");
	getRecentAccuracyRateNChart.setChartData(data0 , "json");
	getRecentAccuracyRateNChart.render("lineContainer");
	});
	$.getJSON("learning/OnlineExerciseAction_onlineExerciseAnalysis",function(data){
		//按单位查询
		var data1 = eval("(" + data.getRecentAccuracyStabilityN+ ")");
		var getRecentAccuracyStabilityNChart = new FusionCharts("resource/script/fusioncharts/swf/ScrollLine2D.swf","stableLineContainerID", "1000", "260", "0", "0");
	getRecentAccuracyStabilityNChart.setChartData(data1 , "json");
	getRecentAccuracyStabilityNChart.render("stableLineContainer");
	});
}

////////////////////////new wyw

/**
 * 清空以前数据
 */
function initSelect(){
	$("#selectBook").val("");
	$("#chapterStr").val("");
	$("#chapterStr").attr("class","");
	$("#totalImg").removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
}

/**
 * 书被选中
 * @param {Object} $this
 */
function bookSelectFun($this){
	//清空以前数据
	initSelect();
		
	var bookID = $this.attr("id").toString();
	var bookName = $($($this.children(".book_title")).children("a")).text();
	$("#selectBook").val(bookName);
	$("#postTheInfo").attr("bookID",bookID);
	var check = $this.hasClass("test_book1");
	if(!check){
		$(".test_book").removeClass("test_book1");
		$this.addClass("test_book1");
		var htmlStr = "";
		$.ajax({
			type:"POST",
			data:{bookID:bookID},
			url:"learning/OnlineExerciseAction_onlineExerciseChpater",
			dataType:"json",
			success:function(data){
				$(".list_ul1").html("");
				$.each(data.chapters,function(key,val){
					htmlStr+="<li><div class='t'><div class='select_btn'><img src='resource/image/learning/select_false_BG.png' name='"+eval(eval(key)+1)+"' id='"+val.id+"' onClick='chapterSelectSingleClickFun($(this))'/></div><div class='select_item'>"+val.chapterNum+"-"+val.chapterName+"</div></div></li>";
				});
				$(".list_ul1").html(htmlStr);
			}
		});
	}
}
/**
 * 换一换事件
 * @param {Object} $this
 * @memberOf {TypeName} 
 */
function bookChangeNext3Fun($this){
	initSelect();
	
	var count = Math.ceil(eval(eval($(".test_book").size())/3));//获取总数
	var currentID = $this.attr("id");//获取当前显示范围
	var nextID = eval(eval(currentID)+1);//计算下一个要显示的范围
	//重新设置"换一换"按钮下一个将要显示的范围
	$(".test_book").addClass("unshow");//将所有的test_book div设置成不可见
	$(".test_book").removeClass("show")
	//用于设置下一个将要显示的范围
	$.each($(".test_book"),function(i,v){
		var clazz = $(this).attr("class");
		var clazzs = clazz.split(" ");
		var id = Math.floor(eval(eval(clazzs[0])/3));
		if(id==nextID){
			$(this).removeClass("unshow");
			$(this).addClass("show");
			if(eval(eval(count)-eval(id))==1){
				$this.attr("id",-1);
			}else{
				$this.attr("id",nextID);
			}
		}
	});
	var check =  $(".show").hasClass("test_book1");
	if(check){
		var bookID = $(".show[class*='test_book1']").attr("id");
		var htmlStr = "";
		$.ajax({
			type:"POST",
			data:{bookID:bookID},
			url:"learning/OnlineExerciseAction_onlineExerciseChpater",
			dataType:"json",
			success:function(data){
				$(".list_ul1").html("");
				$.each(data.chapters,function(key,val){
					htmlStr+="<li><div class='t'><div class='select_btn'><img src='resource/image/learning/select_false_BG.png' name='"+eval(eval(key)+1)+"' id='"+val.id+"' onClick='chapterSelectSingleClickFun($(this))'/></div><div class='select_item'>"+val.chapterNum+"-"+val.chapterName+"</div></div></li>";
				});
				$(".list_ul1").html(htmlStr);
			}
		});
	}
}

/**
 * 点击选择框，全选所有章节或取消全选所有章节
 * @param {Object} $this
 */
function chapterSelectAllClickFun($this){
	$("#chapterStr").val("");
	$("#chapterStr").attr("class","");
	
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$($(".select_btn").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		var img = $($(".t").children(".select_btn")).children("img");
		var imgLength = img.length;
		var ids = "";
		$.each(img,function(key,val){
			if(key!=eval(eval(imgLength)-1)){
				ids+=$(this).attr("id")+",";
			}else{
				ids+=$(this).attr("id");
			}
		});
		var vals = "";
		$.each(img,function(key,val){
			if(key!=eval(eval(imgLength)-1)){
				vals+=eval(eval(key)+1)+",";
			}else{
				vals+=eval(eval(key)+1);
			}
		});
		$("#chapterStr").val(vals);
		$("#chapterStr").attr("class",ids);
	}
	if(clazz=="check"){
		$($(".select_btn").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		$("#chapterStr").val("");
		$("#chapterStr").attr("class","");
	}
}
/**
 * 单个章节选择与取消
 * @param {Object} $this
 */
function chapterSelectSingleClickFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		var val = $("#chapterStr").val();
		if(val==""){
			val = $this.attr("name");
			$("#chapterStr").val(val);
		}else{
			val+=","+$this.attr("name");
			$("#chapterStr").val(val);
		}
		var chap = $("#chapterStr").attr("class");
		if(chap==""){
			chap = $this.attr("id");
			$("#chapterStr").attr("class",chap);
		}else{
			chap+=","+$this.attr("id");
			$("#chapterStr").attr("class",chap);
		}
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		var val = $("#chapterStr").val();
		var valLength = val.length;
		var sub = $this.attr("name");
		if(val.indexOf(sub)!=-1){
			var posi = val.indexOf(sub);
			if(posi==0){
				val = val.substring(2, valLength);
			}else if(posi==eval(eval(valLength)-1)){
				val = val.substring(0, eval(posi)-1);
			}else{
				val = val.substring(0, eval(posi)-1)+val.substring(eval(posi)+1,valLength);
			}
			$("#chapterStr").val(val);
		}else{
			$("#chapterStr").val("");
		}
		
		var chap = $("#chapterStr").attr("class");
		var chaptLength = chap.length;
		var chapSub = $this.attr("id");
		if(chap.indexOf(chapSub)!=-1){
			var posi = chap.indexOf(chapSub);
			if(posi==0){
				chap = chap.substring(2, chaptLength);
			}else if(posi==eval(eval(chaptLength)-1)){
				chap = chap.substring(0, eval(posi)-1);
			}else{
				chap = chap.substring(0, eval(posi)-1)+val.substring(eval(posi)+1,chaptLength);
			}
			$("#chapterStr").attr("class",chap);
		}else{
			$("#chapterStr").attr("class","");
		}
	}
}
/**
 * 开始测试
 */
function startTestFun(){
	var bookID = $("#postTheInfo").attr("bookID");
	var selectBook = $("#selectBook").val();
	var chapterStr = $("#chapterStr").attr("class");
	var testNum = $("#testNum").val();
	if(selectBook==""){
		alert("请选择练习的书");
		return;
	}else if(chapterStr==""){
		alert("请选择练习的章节");
		return;
	}else if(testNum==""){
		alert("请选择练习试题数");
		return;
	}
	var testType = "T1";
	window.location.href="learning/OnlineExerciseAction_onlineExerciseDisp?bookID="+bookID+"&chapterStr="+chapterStr+"&testNum="+testNum+"&testType="+testType; 
}
