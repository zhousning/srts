///////////////problemCommDisp.jsp 开始////////////////////
/**
 * 我有更好的答案按钮
 */
var answerDelay;
function selfBetterAnswer(){
	answerDelay = setTimeout(function(){
		$("#questionAreaMain_answer_area").toggle("slow");
	},300);
}
function selfBetterAnswer_out(){
	clearTimeout(answerDelay);
}
/**
 * 提交答案
 */
function selfBetterAnswerPost(){
	var test = $("#answerarea1").val();
	alert(test);

}
/**
 * 完善答案
 */
var repairDelay;
function selfBetterAnswerRepair(){
	repairDelay = setTimeout(function(){
		$("#answerAreaMain_area_self_area").toggle("slow");
	},300);
}
function selfBetterAnswerRepair_out(){
	clearTimeout(repairDelay);
}
function selfBetterAnswerRepairPost(){
	var test = $("#answerarea2").val();
	alert(test);
}
///////////////problemCommDisp.jsp 结束////////////////////



///////////////problemCommList.jsp 开始////////////////////

///////////////problemCommList.jsp 结束////////////////////



///////////////selfProblemCommList.jsp 开始////////////////
/**
 * 处理问题的回复
 */
function handleAnswer(){
	alert("sd");
}
///////////////selfProblemCommList.jsp 结束////////////////



///////////////selfProblemCommDisp.jsp 开始////////////////
function AskAnswerChange(){
	
}
///////////////selfProblemCommDisp.jsp 结束////////////////












