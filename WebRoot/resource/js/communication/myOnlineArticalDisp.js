/**
 * 我的帖子，我的回复，回复我的，我的消息按钮点击事件
 */
function forumArticalChange($this){
	var _id = $this.attr("id");
	if(_id=="my_artical"){
		$("#container_Content1").show();
		$("#container_Content2").hide();
		$("#container_Content3").hide();
		$("#container_Content4").hide();
	}
	if(_id=="my_reply"){
		$("#container_Content1").hide();
		$("#container_Content2").show();
		$("#container_Content3").hide();
		$("#container_Content4").hide();
	}
	if(_id=="reply_my"){
		$("#container_Content1").hide();
		$("#container_Content2").hide();
		$("#container_Content3").show();
		$("#container_Content4").hide();
	}
	if(_id=="my_message"){
		$("#container_Content1").hide();
		$("#container_Content2").hide();
		$("#container_Content3").hide();
		$("#container_Content4").show();
	}
}
/**
 * 鼠标悬停我的帖子，我的回复，回复我的，我的消息按钮上
 */
function forumArticalChange_over($this){
	$this.addClass("type_hover");
}
/**
 * 鼠标离开我的帖子，我的回复，回复我的，我的消息按钮上
 */
function forumArticalChange_out($this){
	$this.removeClass("type_hover");
}