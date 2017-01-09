document.onclick = function(event) {
	$("#selected_item").hide();
}
/**
 * 点击选择框出现下拉菜单
 * @param {Object} event
 * @return {TypeName} 
 */
function selectFun(event) {
	event.stopPropagation ? event.stopPropagation() : event.cancelBubble = true;
	$("#selected_item").toggle();
	return false;
}
/**
 * 鼠标悬停在下拉框的一条上时
 * @param {Object} $this
 */
function overFun($this) {
	$this.addClass("li_hover");
}
/**
 * 鼠标离开在下拉框的一条上时
 * @param {Object} $this
 */
function outFun($this) {
	$this.removeClass("li_hover");
}
/**
 * 点击下拉框的一条时
 * @param {Object} $this
 */
function clickFun($this) {
	var id = $this.attr("id");
	$(".content_ul").attr("id",id);
	
	var val = $this.text();
	$(".selected_title").text(val);
	$("#selected_item").toggle();
}
/**
 * 点击提交
 */
function submit(){
	var bbsModelid=$(".content_ul").attr("id");
	var articalTile=$(".area1").val();
	var articalContent=$(".area2").val();
	$.ajax({
		type:"POST",
		url:"commu/OnlineForumAction_myOnlineArticalPost",
		data:{bbsModelid:bbsModelid,articalTile:articalTile,articalContent:articalContent},
		dataType:"json",
		success:function(data){
			$(".area1").val("");
			$(".area2").val("");
			alert("发帖成功！您可以点击左侧“学习交流”查看您发的帖子，或者在本界面继续发帖");
		}
		});
	
}