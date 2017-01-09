function submit()
{
	var tip=0;
	var answerSheetId=$("#answerSheetDisp").attr("answerSheetId");
	var size=parseInt($("#answerSheetDisp").attr("subQuestionNum"));
	var objMark=parseInt($("#answerSheetDisp").attr("obQuestionMark"));
	for(var i=1;i<size+1;i++)
	{
		var questionScore=$("#ePC_"+i.toString()).attr("value");
		var questionFullScore=$("#QS_"+i.toString()).attr("score");
		if(questionScore!=""&&questionScore!=null&&isNaN(parseInt(questionScore,10))==false
				&&parseInt(questionScore)<=parseInt(questionFullScore))
		{
			objMark+=parseInt(questionScore);
		}
		else
		{
			$("#ePC_"+i.toString()).val("");
			tip=1;
		}
	}
	if(tip==0)
	{
		$.ajax({
	type:"POST",
	url:"exam/ExaminationManageAction_insertUserTestScore",
	data:"evaMark="+objMark.toString()+"&answerSheetId="+answerSheetId,
	//////////上面是传递数据到服务器
	//////////下面是处理服务器返回的值
	success:function(data){
		var result=data.resString;
		if(result=="success")
			{alert("评卷成功!");
			history.back(-1);}
		else if(result="fail")
			{alert("评卷失败!");}	
	}
    });
	}
	else
	{
		alert("评卷信息不正确!");
	}
	
}
