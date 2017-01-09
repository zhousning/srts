function submit($this) {
	//var QuestionType =  $($(this.parent("tr"))).attr("class");
	var tdparent=$this.parent();
	//var tdparent=$(tdparent).parent();
	var tdsuperparent=$(tdparent).parent("tr");
	var QuestionType=$(tdsuperparent).attr("type-info");
	var QuestionId=$(tdsuperparent).attr("id");
	var QuestionAnswer="";
	if(QuestionType=="单选题")
		{QuestionAnswer = $("input[name='SINGLE']:checked").val();
		$("input[name='SINGLE']").attr("checked",false);
		alert("1."+QuestionType+"2."+QuestionAnswer);}
	else if(QuestionType=="多选题")
		{
		//{QuestionAnswer = $("input[name='A']:checked").val()+$("input[name='B']:checked").val()+$("input[name='C']:checked").val()+$("input[name='D']:checked").val();
		if($("input[name='A']:checked").val()=="A,"){QuestionAnswer+="A,";}
		if($("input[name='B']:checked").val()=="B,"){QuestionAnswer+="B,";}
		if($("input[name='C']:checked").val()=="C,"){QuestionAnswer+="C,";}
		if($("input[name='D']:checked").val()=="D"){QuestionAnswer+="D,";}
		$("input[name='A']").attr("checked",false);
		$("input[name='B']").attr("checked",false);
		$("input[name='C']").attr("checked",false);
		$("input[name='D']").attr("checked",false);
		alert("1."+QuestionType+"2."+QuestionAnswer);}
	else if(QuestionType=="判断题")
		{QuestionAnswer = $("input[name='judge']:checked").val();
		$("input[name='judge']").attr("checked",false);}
	else if(QuestionType=="填空题")
		{QuestionAnswer = $("#FullBlank").val();
		$("#FullBlank").value="";}
	else if(QuestionType=="改错题")
		{QuestionAnswer = $("#CorrectError").val();
		$("#CorrectError").value="";}
	else if(QuestionType=="名词解释")
		{QuestionAnswer = $("#Explaination").val();
		$("#Explaination").value="";}
	else if(QuestionType=="简答题")
		{QuestionAnswer = $("#ShortAnswer").val();
		$("#ShortAnswer").value="";}
	var QuestionType=$(tdsuperparent).attr("type-info");
	//$.post("learning/ErrorSetAction_SetAnswerAndId",{'questionId':QuestionId,'questionAnswer':QuestionAnswer});
	$.ajax({
	type:"POST",
	url:"learning/ErrorSetAction_SetAnswerAndId",
	data:"questionId="+QuestionId+"&questionAnswer="+QuestionAnswer,
	//////////上面是传递数据到服务器
	//////////下面是处理服务器返回的值
	success:function(data){
		var result=data.resString;
		if(result=="right")
			{alert("回答正确!");}
		else if(result=="wrong")
			{alert("1."+QuestionType+"2."+QuestionAnswer+"回答错误，请继续努力!");}	
	}
    });
}
function cancel($this) {
	var tdparent=$this.parent("div");
	var tdsuperparent=$(tdparent).parent("div");
	var QuestionType=$(tdsuperparent).attr("type-info");
	if(QuestionType=="单选题")
		{$("input[name='SINGLE']").attr("checked",false);}
	else if(QuestionType=="多选题")
		{
	    $("input[name='A']").attr("checked",false);
		$("input[name='B']").attr("checked",false);
		$("input[name='C']").attr("checked",false);
		$("input[name='D']").attr("checked",false);}
	else if(QuestionType=="判断题")
		{$("input[name='judge']").attr("checked",false);}
	else if(QuestionType=="填空题")
		{$("#FullBlank").value="";}
	else if(QuestionType=="改错题")
		{$("#CorrectError").value="";}
	else if(QuestionType=="名词解释")
		{$("#Explaination").value="";}
	else if(QuestionType=="简答题")
		{$("#ShortAnswer").value="";}
}
function turnToPageN($this)
{
	var page=$($this.parent("li")).attr("value");
	//var page=$("#pageSelect").val();
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
	var model=$("#pageInfo").attr("info-model");
	var type=$("#pageInfo").attr("info-type");
	var timeLength=$("#pageInfo").attr("info-timeLength");
	var flag=$("#pageInfo").attr("info-flag");
    window.location.href = "learning/ErrorSetAction_ErrorSetDisp?newPage="+page+"&modelType="+model+"&type="+type+"&timeLength="+timeLength+"&flag="+flag;
	//window.parent.main.document.location.reload();//上级页面   
    //document.location.reload();//当前页面 
}

function backToLastPage()
{
	var pageAmount=parseInt($("#pageInfo").attr("pageNum"));
	var currentPage=parseInt($("#pageInfo").attr("curPage"));
	var page=currentPage-1;
	var model=$("#pageInfo").attr("info-model");
	var type=$("#pageInfo").attr("info-type");
	var timeLength=$("#pageInfo").attr("info-timeLength");
	var flag=$("#pageInfo").attr("info-flag");
	if(page>=1)
	{
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
    window.location.href = "learning/ErrorSetAction_ErrorSetDisp?newPage="+page+"&modelType="+model+"&type="+type+"&timeLength="+timeLength+"&flag="+flag;
	//window.parent.main.document.location.reload();//上级页面   
    //document.location.reload();//当前页面 
	}
	else if(page<1)
	{
		alert("这是第一页！");
	}
	
}

function goToNextPage()
{
	var pageAmount=parseInt($("#pageInfo").attr("pageNum"));
	var currentPage=parseInt($("#pageInfo").attr("curPage"));
	var page=currentPage+1;
	var model=$("#pageInfo").attr("info-model");
	alert(model);
	var type=$("#pageInfo").attr("info-type");
	var timeLength=$("#pageInfo").attr("info-timeLength");
	var flag=$("#pageInfo").attr("info-flag");
	if(page<=pageAmount)
	{
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
    window.location.href = "learning/ErrorSetAction_ErrorSetDisp?newPage="+page+"&modelType="+model+"&type="+type+"&timeLength="+timeLength+"&flag="+flag;
	//window.parent.main.document.location.reload();//上级页面   
    //document.location.reload();//当前页面 
	}else if(page>pageAmount)
	{
		alert("这是最后一页！");
	}
}
