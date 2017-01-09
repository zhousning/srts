var curUserId=0;
var articalId=0;
/**
 * 提交回复的回复
 */
function submitUserReply(){
	var replyContent = $("#usrReplyTextarea").val();
	//跳转用
	var id=$(".articalDetailContainer").attr("articalId");
	//alert(replyContent);
	/**
	 * 提交到后台
	 */
	
	if(replyContent==null||replyContent==""){
		alert("请输入回复内容。");
		return false ;
	}
	$.ajax({
		type:"POST",
		url:"commu/OnlineForumAction_submitArticalReplyReply",
		data:{articalId:articalId,replyContent:replyContent,userId:curUserId},
		dataType:"json",
		success:function(data){
			alert("提交成功");
			window.location.href("commu/OnlineForumAction_onlineForumModelDisp?articalId="+id);
		}
		});
	
	/**
	 * 初始化数据
	 */
	curUserId=0;
	articalId=0;
}
/**
 * 与帖子标题同一行的回复，点击事件
 */
function articalReplyFun(){
	$("#replyTextarea").focus();
}
/**
 * 提交一个帖子的回复
 */
function submitReply(){
	var articalId=$(".articalDetailContainer").attr("articalId");
	var replyContent=$("#replyTextarea").val();
	if(replyContent==null){
		alert("请输入回复内容。");
		return false ;
	}
	$.ajax({
		type:"POST",
		url:"commu/OnlineForumAction_submitArticalReply",
		data:{articalId:articalId,replyContent:replyContent},
		dataType:"json",
		success:function(data){
			alert("提交成功");
			window.location.href("commu/OnlineForumAction_onlineForumModelDisp?articalId="+articalId);
		}
		});
}

/**
 * 用户对帖子的回复
 */
function articalReplyFun1($this,aId,cId){
	articalId=aId;
	curUserId=cId;
	var replyBtn = $($($($this.parent(".reply_btn")).parent(".replyDetail_group_btn")).siblings(".replyList")).children(".usr_reply_div");
	var textArea = $($($($($this.parent(".reply_btn")).parent(".replyDetail_group_btn")).siblings(".replyList")).children(".usr_reply_div")).children("#usrReplyTextarea");
	var status=$(replyBtn).attr("opstat");
	if(status=="close"){
		$(replyBtn).attr("opstat","open");
		$(replyBtn).toggle();
		$(textArea).val("");
	}
	if(status=="open"){
		$(replyBtn).attr("opstat","close");
		$(replyBtn).toggle();
		$(textArea).val("");
	}
	return false;
}
/**
 * 帖子下回复的回复
 */
function articalReplyFun2($this,aId,cId){
	articalId=aId;
	curUserId=cId;
	//var status=$("#usr_reply_div").attr("opstat");
	var replyDiv =$($($($($($this.parent(".usr_reply_span")).parent(".usr_reply")).parent(".reply_usr_info")).parent("li")).parent(".replyList_ul")).siblings(".usr_reply_div");
	var textArea = $($(replyDiv).children("#usrReplyTextarea"));
	var status=$(replyDiv).attr("opstat");
	var parents = $this.parents(".usr_reply");
	var bro = $(parents).siblings(".usr_info_reply");
	var span = $(bro).children("span");
	var t = $(span).text();
	if(status=="close"){
		$(replyDiv).attr("opstat","open");
		$(replyDiv).toggle();
		$(textArea).val("回复"+t+"：");
	}
	if(status=="open"){
		$(replyDiv).attr("opstat","close");
		$(replyDiv).toggle();
		$(textArea).val("");
	}
	return false;
}