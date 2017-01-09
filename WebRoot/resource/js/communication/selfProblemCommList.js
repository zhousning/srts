/**
 * 处理问题的回复
 */
function handleAnswer($this){
	var clazz = $this.attr("class");
	var clazzs = clazz.split(" ");
	if(clazzs[1]!="check"){
		$this.addClass("check");
		$($($($this.parents(".info").parents(".scroll_block"))).siblings("#input")).show();
	}
	if(clazzs[1]=="check"){
		$this.removeClass("check");
		$($($($this.parents(".info").parents(".scroll_block"))).siblings("#input")).hide();
	}
	
}
$(function() {
	$("#demo2").paginate({
		count : 50,
		start : 5,
		display : 10,
		border : false,
		text_color : '#888',
		background_color : '#EEE',	
		text_hover_color : 'black',
		background_hover_color : '#CFCFCF'
	});
});
/**
 * 上面我的提问和我的回答的切换
 * @param {Object} $this
 */
function AskAnswerChange($this){
	var id = $this.attr("id");
	if(id == "title_ask"){
		$("#my_ask").show();
		$("#my_answer").hide();
	}
	if(id == "title_answer"){
		$("#my_ask").hide();
		$("#my_answer").show();
	}
}