function showAllContent($this) {
	var tdparent=$this.parent("div");
	tdparent=$(tdparent).parent("div");
	var div=$($(tdparent).next());
	div.show();
	var idparent=$($($this.parent("div")).parent("div")).parent("div");
	var id=$(idparent).attr("id-info");
	var type=$("#pageInfo").attr("searchType");
	type=encodeURI(type);
	type=encodeURI(type);
	$.ajax({
	type:"POST",
	url:"kldg/KnowledgeBankAction_UpdateSearchRecord",
	data:"updateKlgId="+id+"&searchType="+type,
	//////////上面是传递数据到服务器
	//////////下面是处理服务器返回的值
	success:function(data){
		//var result=data.updateKlgResString;
		//if(result=="success")
			//{alert("修改信息成功!");}
		//else if(result="fail")
			//{alert("修改信息失败!");}	
	}
    });
}


function turnToPageN($this)
{
	var page=$($this.parent("li")).attr("value");
	var keyWords=$("#pageInfo").attr("searchKeyWords");
	var type=$("#pageInfo").attr("searchType");
	keyWords=encodeURI(keyWords);
	keyWords=encodeURI(keyWords);
	type=encodeURI(type);
	type=encodeURI(type);
	//var page=$("#pageSelect").val();
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
    window.location.href = "kldg/KnowledgeBankAction_KlgSearchByKeyWordsAndType?searchType="+type+"&searchKeyWords="+keyWords+"&newPage="+page+"&tag=1";
	//window.parent.main.document.location.reload();//上级页面   
    //document.location.reload();//当前页面 
}

function backToLastPage()
{
	var pageAmount=parseInt($("#pageInfo").attr("pageNum"));
	var currentPage=parseInt($("#pageInfo").attr("curPage"));
	var keyWords=$("#pageInfo").attr("searchKeyWords");
	var type=$("#pageInfo").attr("searchType");
	keyWords=encodeURI(keyWords);
	keyWords=encodeURI(keyWords);
	type=encodeURI(type);
	type=encodeURI(type);
	var page=currentPage-1;
	if(page>=1)
	{
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
    window.location.href = "kldg/KnowledgeBankAction_KlgSearchByKeyWordsAndType?searchType="+type+"&searchKeyWords="+keyWords+"&newPage="+page+"&tag=1";
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
	var keyWords=$("#pageInfo").attr("searchKeyWords");
	var type=$("#pageInfo").attr("searchType");
	keyWords=encodeURI(keyWords);
	keyWords=encodeURI(keyWords);
	type=encodeURI(type);
	type=encodeURI(type);
	var page=currentPage+1;
	if(page<=pageAmount)
	{
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
    window.location.href = "kldg/KnowledgeBankAction_KlgSearchByKeyWordsAndType?searchType="+type+"&searchKeyWords="+keyWords+"&newPage="+page+"&tag=1";
	//window.parent.main.document.location.reload();//上级页面   
    //document.location.reload();//当前页面 
	}else if(page>pageAmount)
	{
		alert("这是最后一页！");
	}
}