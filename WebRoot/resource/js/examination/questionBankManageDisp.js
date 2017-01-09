function showUpdate($this) {
	var tdparent=$this.parent("div");
	var div=$($(tdparent).next());
	div.show();
}
function deleteQuestion($this) {
	var tdparent=$this.parent("div");
	var tdsuperparent=$(tdparent).parent("div");
	var QuestionId=$(tdsuperparent).attr("id-info");
	alert(QuestionId);
	$.ajax({
	type:"POST",
	url:"exam/QuestionBankManageAction_DeleteQuestion",
	data:"deleteQuestionId="+QuestionId,
	//////////上面是传递数据到服务器
	//////////下面是处理服务器返回的值
	success:function(data){
		var result=data.resDeleteString;
		if(result=="success")
			{alert("删除成功!");}
		else if(result="fail")
			{alert("删除失败!");}	
	}
    });
}
function submit($this) {
	var tdparent=$this.parent("div");
	var tdsuperparent=$(tdparent).parent("div");
	var tdContent=$(tdparent).children(".content");
	var tdAnswer=$(tdparent).children(".answer");
	var tdSelect=$(tdparent).children(".selectOption");
	var newContent=$($(tdContent).children("input")).attr("value");
	var newAnswer=$($(tdAnswer).children("input")).attr("value");
	var newSelect=$($(tdSelect).children("input")).attr("value");
	var questionId=$(tdsuperparent).attr("id-info");
	$.ajax({
	type:"POST",
	url:"exam/QuestionBankManageAction_UpdateQuestion",
	data:"updateQuestionId="+questionId+"&updateQuestionContent="+newContent+"&updateQuestionAnswer="+newAnswer+"&updateSelectOptions="+newSelect,
	//////////上面是传递数据到服务器
	//////////下面是处理服务器返回的值
	success:function(data){
		var result=data.updateResString;
		if(result=="success")
			{alert("修改成功!");}
		else if(result="fail")
			{alert("修改失败!");}	
	}
    });
}
function cancel($this) {
	var tdparent=$this.parent("div");
    var div=$(tdparent);
	div.hide()
}
function submitPic()
{
	//alert("数据上传成功！");
	$("#pictureForm")
		.attr("action",
		"exam/QuestionBankManageAction_UpdateQuestionPic");
	$("#pictureForm").submit();
	alert("数据上传成功！");
}
function turnToPageN($this)
{
	var page=$($this.parent("li")).attr("value");
	//var page=$("#pageSelect").val();
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
    window.location.href = "exam/QuestionBankManageAction_FindAllQuestionDisp?newPage="+page;
	//window.parent.main.document.location.reload();//上级页面   
    //document.location.reload();//当前页面 
}

function backToLastPage()
{
	var pageAmount=parseInt($("#pageInfo").attr("pageNum"));
	var currentPage=parseInt($("#pageInfo").attr("curPage"));
	var page=currentPage-1;
	if(page>=1)
	{
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
    window.location.href = "exam/QuestionBankManageAction_FindAllQuestionDisp?newPage="+page;
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
	if(page<=pageAmount)
	{
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
    window.location.href = "exam/QuestionBankManageAction_FindAllQuestionDisp?newPage="+page;
	//window.parent.main.document.location.reload();//上级页面   
    //document.location.reload();//当前页面 
	}else if(page>pageAmount)
	{
		alert("这是最后一页！");
	}
}