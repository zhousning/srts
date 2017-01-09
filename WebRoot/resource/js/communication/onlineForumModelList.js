/**
 * 最上模块滚动效果
 * @param {Object} $this
 */
$(function() {
	//配置变量
	var config = {
		showNum : 4,//设置滚动的显示个数
		autoScroll : true,//是否自动滚动，默认为 false
		autoScrollInterval : 3000
	//自动滚动间隔，默认为 3000 毫秒，autoScroll = true 时才有效
	}
	var scrollUlWidth = $('.modelInfo_ul li').outerWidth(true), //单个 li 的宽度
	scrollUlLeft = 0, //.scroll_ul 初使化时的 left 值为 0
	prevAllow = true, //为了防止连续点击上一页按钮
	nextAllow = true;//为了防止连续点击下一页按钮
	//计算父容量限宽
	$('.modelInfo').width(config.showNum * scrollUlWidth);
	//点击上一页
	function leftHandler(event) {
		var ul_id = event.data.ul_id;
		if (prevAllow) {
			prevAllow = false;
			scrollUlLeft = scrollUlLeft - scrollUlWidth;
			$('#' + ul_id).css('left', scrollUlLeft);
			//复制最后一个 li 并插入到 ul 的最前面
			$('#' + ul_id + ' li:last').clone().prependTo('#' + ul_id);
			//删除最后一个 li
			$('#' + ul_id + ' li:last').remove();
			$('#' + ul_id).animate( {
				left : scrollUlLeft + scrollUlWidth
			}, 300, function() {
				scrollUlLeft = parseInt($('#' + ul_id).css('left'), 10);
				prevAllow = true;
			})
		}
	}
	function rightHandler(event) {
		var ul_id = event.data.ul_id;
		if (nextAllow) {
			nextAllow = false;
			$('#' + ul_id).animate( {
				left : scrollUlLeft - scrollUlWidth
			}, 300, function() {
				scrollUlLeft = parseInt($('#' + ul_id).css('left'), 10);
				scrollUlLeft = scrollUlLeft + scrollUlWidth;
				$('#' + ul_id).css('left', scrollUlLeft);
				//复制第一个 li 并插入到 ul 的最后面
					$('#' + ul_id + ' li:first').clone().appendTo('#' + ul_id);
					//删除第一个 li
					$('#' + ul_id + ' li:first').remove();
					nextAllow = true;
				})
		}
	}
	function modelMouseOver_Out(event){
		$this = $(this);
		var type = event.type;
		var tar = $this.attr("id");
		if(type=="mouseover"){
			tar=="prev"?$this.addClass("modelChange_btn_left_over"):$this.addClass("modelChange_btn_right_over");
		}
		if(type=="mouseout"){
			tar=="prev"?$this.removeClass("modelChange_btn_left_over"):$this.removeClass("modelChange_btn_right_over");
		}
	}
	$("#prev").bind("mouseover mouseout", modelMouseOver_Out);
	$("#next").bind("mouseover mouseout", modelMouseOver_Out);
	$("#prev").bind("click", {
		ul_id : "scroll_ul_0"
	}, leftHandler);
	$("#next").bind("click", {
		ul_id : "scroll_ul_0"
	}, rightHandler);
	//自动滚动
	if (config.autoScroll) {
		setInterval(function() {
			$('#next').trigger('click');
		}, config.autoScrollInterval)
	}
})
/**
 * 热门和最新动态按钮点击事件
 */
function forumArticalChange($this){
	var _id = $this.attr("id");
	if(_id=="hot"){
		$("#hotArticalMain").toggle();
		$("#latestArticalMain").toggle();
	}
	if(_id=="latest"){
		$("#hotArticalMain").toggle();
		$("#latestArticalMain").toggle();
	}
}
/**
 * 鼠标悬停在热门和最新动态按钮上
 */
function forumArticalChange_over($this){
	$this.addClass("type_hover");
}
/**
 * 鼠标离开在热门和最新动态按钮上
 */
function forumArticalChange_out($this){
	$this.removeClass("type_hover");
}
/**
 * 上月专区达人滚动效果
 * @memberOf {TypeName} 
 */
$(function(){
	var config = {
		autoScroll : true,//是否自动滚动，默认为 false
		autoScrollInterval : 4000//自动滚动间隔，默认为 3000 毫秒，autoScroll = true 时才有效
	}
	prevAllow = true, //为了防止连续点击上一页按钮
	nextAllow = true;//为了防止连续点击下一页按钮
	//点击上一页
	function leftHandler(event) {
		$("#analisis_change_ul li:first").clone().appendTo("#analisis_change_ul");
		$("#analisis_change_ul li:first").remove();
		if (prevAllow) {
			prevAllow = false;
			$("#analisis_change_ul li:first").animate( {}, 300, function() {prevAllow = true;})
		}
	}
	function rightHandler(event) {
		$("#analisis_change_ul li:first").clone().appendTo("#analisis_change_ul");
		$("#analisis_change_ul li:first").remove();
		if (nextAllow) {
			nextAllow = false;
			$("#analisis_change_ul li:first").animate( {}, 300, function() {nextAllow = true;})
		}
	}
	$("#turn_pre").bind("click", leftHandler);
	$("#turn_next").bind("click", rightHandler);
	//自动切换
	if (config.autoScroll) {
		setInterval(function() {$('#turn_next').trigger('click');}, config.autoScrollInterval)
	}
});