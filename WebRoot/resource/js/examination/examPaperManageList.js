/**
 * 点击全选按钮后，下面的选择按钮会全部选择
 * @param {Object} $htis
 */
function paperSelectAllFun($this){
	var clazz = $this.attr("class");//clazz用于判断这个选择框有没有处于选择状态
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		$($(".od").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		$($(".od").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}
/**
 * 单个试卷信息的选择与取消
 * @param {Object} $this
 */
function paperSelectSingleFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}

function paperInfoShowFun($this){
	
}