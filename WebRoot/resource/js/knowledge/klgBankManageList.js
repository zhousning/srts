function link_upLoad(){
	var klg=$("#klg");
	var klgType=klg.val();
	location.href="kldg/KnowledgeBankManageAction_knowledgeBankUploadDisp?klgType="+klgType+"";
}

function addimg(){
	$("#no1").after("<div>" +
	"<div> <input type='file' name='caseImg'/><img src='resource/image/knowledge/delete.png' onclick='remove($(this))'  style='cursor:hand;'/></div>" +
	"</div>");
}

function remove($this){
	$this.parent("div").remove();
}