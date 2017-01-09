function c(i){
	$(".tabC").hide();
	$("#tab"+i).show();
}

function initChart(){
	$.getJSON("kldg/KnowledgeBankAction_KlgBankAnalysis",function(data){
		var klgSearchPerMonth = eval("(" + data.klgBankAnalysis + ")");
		var countChart = new FusionCharts( "resource/script/fusioncharts/swf/Bar2D.swf","barContainerId", "280", "200", "0" );
		countChart.setChartData(klgSearchPerMonth , "json");
		countChart.render("barContainer");
	});
}

function showUpload($this) {
	var tdparent=$this.parent("div");
	var div=$($(tdparent).next());
	div.show();
}

function submit($this) {
	var content = $("#contentUpload").attr("value");
	var explaination = $("#explainationUpload").attr("value");
	$.ajax({
	type:"POST",
	url:"kldg/KnowledgeBankAction_UploadExperience",
	data:"experienceContent="+content+"&explaination="+explaination,
	//////////上面是传递数据到服务器
	//////////下面是处理服务器返回的值
	success:function(data){
		var result=data.uploadExpResString;
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
	div.hide();
}



function klgSearchResByKeyWordsType(){
	
	    var keyWords=$("#keyWords").val();
	    var type=$("#typeSelect").val();

	   if(type==""&&keyWords==""){
		  alert("请选择至少一个查询条件!!!");
		  return;
	   }
	   
	   $("#queryResult").css("display","block");
	   keyWords=encodeURI(keyWords);
	   keyWords=encodeURI(keyWords);
	   type=encodeURI(type);
	   type=encodeURI(type);
	   var page=1;
	   window.location.href = "kldg/KnowledgeBankAction_KlgSearchByKeyWordsAndType?searchType="+type+"&searchKeyWords="+keyWords+"&newPage="+page+"&tag=1";
}


function showAll($this) {
	var id = $($($this.parent()).parent()).parent().attr("id");
	var type=$($($this.parent()).parent()).parent().attr("type-info");
	id=encodeURI(id);
	id=encodeURI(id);
	type=encodeURI(type);
	type=encodeURI(type);
	window.location.href = "kldg/KnowledgeBankAction_ShowAllInfo?infoId="+id+"&infoType="+type;
}


