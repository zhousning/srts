/**
 * 继续追问按钮
 */
function continueAsk(answerId){
	$("#"+answerId).toggle("fast");
}

/**
 * 采纳答案按钮
 */
function adoptAnswer(answerId){
	var problemId=$("input").val();
	$.ajax({
		type:"POST",
		url:"commu/ProblemCommuAction_saveProblemAnswerAccept",
		data:{problemId:problemId,answerId:answerId},
		dataType:"json",
		success:function(data){
			alert("返回成功");
		}
		});
	
	
}

/**
 * 提交追问
 */
function postAnswer(answerId,$this){
	var myAsk = $("#myAsk"+answerId).val();
	
	
	$.ajax({
		type:"POST",
		url:"commu/ProblemCommuAction_saveMyAsk",
		data:{myAsk:myAsk,answerId:answerId},
		dataType:"json",
		success:function(data){
			$($this.parents(".ans_ask_area")).before("<div class='ans_ask'><div class='ans_ask_content'><span>追问：</span>"+myAsk+"</div></div>");
			$("#myAsk"+answerId).val("");
			$("#"+answerId).toggle("fast");
		}
		});
}








