/**
 * 我有更好的答案按钮
 */
function selfBetterAnswer(){
	$("#questionAreaMain_answer_area").toggle("fast");
}
/**
 * 提交答案
 */
function selfBetterAnswerPost(){
	var myAnswer = $("#answerarea1").val();
	var problemId=$("#answerAreaMain").attr("problemInfoId");
	$.ajax({
		type:"POST",
		url:"commu/ProblemCommuAction_submitMyAnswer",
		data:{problemId:problemId,myAnswer:myAnswer},
		dataType:"json",
		success:function(data){
			$("#myAnswerArea").html("<div class='answerAreaMain_area_self_up'>"+
						"<span class='answerAreaMain_area_up2'>"+data.answerInfo.date+"</span>"+
						"<span class='answerAreaMain_area_up1'>我的回答</span>|"+
						"<span class='answerAreaMain_area_up1'></span>"+
					"</div>"+
					"<div class='answerAreaMain_area_self_down'>"+data.answerInfo.answerContent+"</div>"+
					"<div class='answerAreaMain_area_self_btn' onclick='selfBetterAnswerRepair()'>完善答案</div>"+
					"<div class='answerAreaMain_area_self_area' id='answerAreaMain_area_self_area'>"+
						"<form action='' method='post'>"+
							"<div><textarea id='answerarea2' name='bbcode_field1' style='height:150px;width:730px;overflow-y:auto;'></textarea></div>"+
							"<div class='answerAreaMain_area_self_area_btn' onclick='selfBetterAnswerRepairPost()'>提交修改</div>"+
						"</form>"+
					"</div>");
				var count = eval($("#answerCount").text()+1);
				$("#answerCount").text(count);
				$("#questionAreaMain_answer_btn").hide();
				$("#questionAreaMain_answer_area").hide();
				}
		});
	/*
	$.getJSON("commu/ProblemCommuAction_submitMyAnswer?questionId="+encodeURI(problemId)+"&myAnswer="+myAnswer, function(data) {
		$("#myAnswerArea").html("<div class='answerAreaMain_area_self_up'>"+
						"<span class='answerAreaMain_area_up2'>"+data.answerInfo.date+"</span>"+
						"<span class='answerAreaMain_area_up1'>我的回答</span>|"+
						"<span class='answerAreaMain_area_up1'></span>"+
					"</div>"+
					"<div class='answerAreaMain_area_self_down'>"+data.answerInfo.answerContent+"</div>"+
					"<div class='answerAreaMain_area_self_btn' onclick='selfBetterAnswerRepair()'>完善答案</div>"+
					"<div class='answerAreaMain_area_self_area' id='answerAreaMain_area_self_area'>"+
						"<form action='' method='post'>"+
							"<div><textarea id='answerarea2' name='bbcode_field1' style='height:150px;width:730px;overflow-y:auto;'></textarea></div>"+
							"<div class='answerAreaMain_area_self_area_btn' onclick='selfBetterAnswerRepairPost()'>提交修改</div>"+
						"</form>"+
					"</div>");
			var count = eval($("#answerCount").text()+1);
			$("#answerCount").text(count);
			$("#questionAreaMain_answer_btn").hide();
			$("#questionAreaMain_answer_area").hide();
		});
	*/
}
/**
 * 完善答案
 */

function selfBetterAnswerRepair(){
	$("#answerAreaMain_area_self_area").toggle("fast");
}
function selfBetterAnswerRepairPost(){
	var answerId=$("#answerInfo").attr("answerInfoId");
	var myAnswer = $("#answerarea2").val();
	$.ajax({
		type:"POST",
		url:"commu/ProblemCommuAction_updateMyAnswer",
		data:{myAnswer:myAnswer,answerId:answerId},
		dataType:"json",
		success:function(data){
			$("#myAnswerArea").html("<div class='answerAreaMain_area_self_up'>"+
						"<span class='answerAreaMain_area_up2'>"+data.answerInfo.date+"</span>"+
						"<span class='answerAreaMain_area_up1'>我的回答</span>|"+
						"<span class='answerAreaMain_area_up1'></span>"+
					"</div>"+
					"<div class='answerAreaMain_area_self_down'>"+data.answerInfo.answerContent+"</div>"+
					"<div class='answerAreaMain_area_self_btn' onclick='selfBetterAnswerRepair()'>完善答案</div>"+
					"<div class='answerAreaMain_area_self_area' id='answerAreaMain_area_self_area'>"+
						"<form action='' method='post'>"+
							"<div><textarea id='answerarea2' name='bbcode_field1' style='height:150px;width:730px;overflow-y:auto;'></textarea></div>"+
							"<div class='answerAreaMain_area_self_area_btn' onclick='selfBetterAnswerRepairPost()'>提交修改</div>"+
						"</form>"+
					"</div>");
				}
		});
}