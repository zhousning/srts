function turnToPageN($this)
{
	var page=$($this.parent("li")).attr("value");
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
    window.location.href = "wkea/WorkerEstimateListAction_workerKlgBankRecordSearch?newPage="+page; 
}

function backToLastPage()
{
	var pageAmount=parseInt($("#pageInfo").attr("pageNum"));
	var currentPage=parseInt($("#pageInfo").attr("curPage"));
	var page=currentPage-1;
	if(page>=1)
	{
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
    window.location.href = "wkea/WorkerEstimateListAction_workerKlgBankRecordSearch?newPage="+page; 
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
    window.location.href = "wkea/WorkerEstimateListAction_workerKlgBankRecordSearch?newPage="+page;
	}else if(page>pageAmount)
	{
		alert("这是最后一页！");
	}
}