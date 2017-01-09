/**
 * 与帖子标题同一行的回复，点击事件
 */
function articalReplyFun(){
	$("#replyTextarea").focus();
}

/**
 * 用户对帖子的回复
 */
function articalReplyFun1($this){
	var status=$("#usr_reply_div").attr("opstat");
	if(status=="close"){
		$("#usr_reply_div").attr("opstat","open");
		$("#usr_reply_div").toggle();
		$("#usrReplyTextarea").val("");
	}
	if(status=="open"){
		$("#usr_reply_div").toggle();
		$("#usrReplyTextarea").val("");
	}
}
/**
 * 帖子下回复的回复
 */
function articalReplyFun2($this){
	var status=$("#usr_reply_div").attr("opstat");
	var parents = $this.parents(".usr_reply");
	var bro = $(parents).siblings(".usr_info_reply");
	var span = $(bro).children("span");
	var t = $(span).text();
	if(status=="close"){
		$("#usr_reply_div").attr("opstat","open");
		$("#usr_reply_div").toggle();
		$("#usrReplyTextarea").val("回复"+t+"：");
	}
	if(status=="open"){
		$("#usr_reply_div").attr("opstat","close");
		$("#usr_reply_div").toggle();
		$("#usrReplyTextarea").val("");
	}
	return false;
}