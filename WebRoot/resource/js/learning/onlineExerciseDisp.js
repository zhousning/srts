/**
 * 显示单个试题
 */
function showSingleFun(){
	$(".btnGps").hide();
	$(".show_s").show();
	$(".question_area").hide();
	$(".question_area[ans='u']").first().show();
	
}

function showTypeFun(type){
	$(".btnGps").hide();
	$(".show_t").show();
	$(".question_area").hide();
	$(".question_area[type='"+type+"']").show();
}
/**
 * 显示全部试题
 */
function showAllFun(){
	$(".btnGps").hide();
	$(".question_area").show();
}

/**
 * 显示试题类型
 * @param {Object} type
 */
function showTypeT1Fun(type){
	$(".question_area").hide();
	$(".question_area[type='"+type+"']").show();
}
/**
 * 单选设置
 * @param {Object} $this
 */
function ansSingleSelectFun($this){
	var content = "";
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		$($($($this.parent("span")).siblings("span")).children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		content = $($this.parent("span")).text();
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
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
 * 多选设置
 * @param {Object} $this
 */
function ansMultiSelectFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){//被选中
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		var content = $($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("content");
		if(content==""){
			content = $($this.parent("span")).text();
			$($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("content",content);
		}else{
			content+=","+$($this.parent("span")).text();
			$($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("content",content);
		}
	}
	if(clazz=="check"){//取消选中
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		var content = $($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("content");
		var contentLength = content.length;
		var sub = $($this.parent("span")).text();
		if(content.indexOf(sub)!=-1){
			var posi = content.indexOf(sub);
			if(posi==0){
				content = content.substring(2, contentLength);
			}else if(posi==eval(eval(contentLength)-1)){
				content = content.substring(0, eval(posi)-1);
			}else{
				content = content.substring(0, eval(posi)-1)+content.substring(eval(posi)+1,contentLength);
			}
			$($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("content",content);
		}else{
			$($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("content","");
		}
	}
	var check = $($($($($this.parent("span")).parent(".question_cont")).children("span")).children("img")).hasClass("check");
	if(check){
		$($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("ans","d");
		
	}else{
		$($($($this.parent("span")).parent(".question_cont")).parent("div")).attr("ans","u");
	}
}
/**
 * 判断设置
 * @param {Object} $this
 */
function ansJudgeSelectFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		$($($($this.parent("span")).siblings("span")).children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		content = $($this.parent("span")).text();
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
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
 * 带inut和textarea设置
 * @param {Object} $this
 */
function ansFillBlankCheckFun($this){
	var val = $this.val();
	if(val!=""){
		$($($($this.parent("div")).parent(".question_cont")).parent(".question_area")).attr("ans","d");
		$($($($this.parent("div")).parent(".question_cont")).parent(".question_area")).attr("content",val);
	}else{
		$($($($this.parent("div")).parent(".question_cont")).parent(".question_area")).attr("ans","u");
		$($($($this.parent("div")).parent(".question_cont")).parent(".question_area")).attr("content",val);
	}
}
/**
 * 単题显示，上一个
 */
function showSinglePreFun($this){
	var pre_order = $this.attr("order");
	var next_order = $("#next").attr("order");
	if(pre_order==0){
		alert("没有上一题");
	}else{
		$(".question_area").hide();
		$(".question_area[order='"+pre_order+"']").show();
		pre_order = eval(eval(pre_order)-1);
		$this.attr("order",pre_order);
		next_order = eval(eval(next_order)-1);
		$("#next").attr("order",next_order);
	}
}
/**
 * 単题显示，下一个
 * @param {Object} $this
 */
function showSingleNextFun($this){
	var orderCount = $(".question_area").size();
	var pre_order = $("#pre").attr("order");
	var next_order = $this.attr("order");
	if(eval(eval(orderCount)+1)!=next_order){
		$(".question_area").hide();
		$(".question_area[order='"+next_order+"']").show();
		next_order = eval(eval(next_order)+1);
		$this.attr("order",next_order);
		pre_order = eval(eval(pre_order)+1);
		$("#pre").attr("order",pre_order);
	}else{
		alert("没有下一题");
	}
}

/**
 * 提交答案
 */
function ansPostFun(){
	//获取所有试题的id和答案
	var chapterStr=$("#ansPost").attr("chapt");
	var bookID=$("#ansPost").attr("bookID");
	var ansStatus = "";//答题状态
	var id = "";//问题在数据库中的id
	var content = "";//答案内容
	var order = "";//问题序号
	var answer = "";//带提交的答案
	var warning = "<div>";
	var questionSize = $(".question_area").length;
	$.each($(".question_area"),function(key,val){
		ansStatus = $(this).attr("ans");
		id = $(this).attr("id");
		content = $(this).attr("content");
		order = $(this).attr("order");
		//
		if(ansStatus=="u"){
			if(key!=questionSize){
				warning+="第<span>"+order+"</span>题";
			}else{
				warning+="未完成</div>";
			}
			content="";
			answer+=order+","+id+","+"未答"+"|";
		}else{
			answer+=order+","+id+","+content+"|";
		}
	});
	answer=encodeURI(answer);
	answer=encodeURI(answer);
	$.ajax({
		type:"POST",
		url:"learning/OnlineExerciseAction_onlineExerciseAnswerCheck",
		data:"answerInfo="+answer+"&bookID="+bookID+"&chapterStr="+chapterStr,
		success:function(data){
		var res=data.resString;
		var acur=data.resAcur;
			if(res=="success")
			{
				alert("提交成功!练习准确率为:"+acur);
				$(".question_ans").show();
				$("#ansPost").hide();
			}
			else
			{
				alert("未提交成功!");
			}
			
		}
	});
}
function backPostFun()
{
	history.back(-1);
}















