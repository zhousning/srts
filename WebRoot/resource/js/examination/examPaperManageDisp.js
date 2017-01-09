/**
 * 鼠标点击导航
 * @param {Object} $this
 */
function navClickFun($this) {
	if ($($this.children(".nav")).hasClass("do")) {
		$($this.children(".nav")).addClass("nav1").addClass("target");
		$($($this.siblings()).children(".nav")).removeClass("nav1").removeClass("target");
		if ($($this.children(".navigation_name")).hasClass("name1")) {
			$(".panelDiv").removeClass("show").hide();	
			$(".panel").addClass("show").show();
		}
		if ($($this.children(".navigation_name")).hasClass("name2")) {
			$(".panelDiv").removeClass("show").hide();
			$(".panel1").addClass("show").show();
		}
		if ($($this.children(".navigation_name")).hasClass("name3")) {
			$(".panelDiv").removeClass("show").hide();
			$(".panel2").addClass("show").show();
		}
		if ($($this.children(".navigation_name")).hasClass("name4")) {
			$(".panelDiv").removeClass("show").hide();
			$(".panel3").addClass("show").show();
		}
	}
}
/**
 * 鼠标经过导航
 * @param {Object} $this
 */
function navOverFun($this) {
	$($($this.siblings()).children(".nav")).removeClass("nav1");
	$($this.children(".nav")).addClass("nav1");
}
/**
 * 鼠标离开导航
 * @param {Object} $this
 */
function navOutFun($this) {
	if (!$($this.children(".nav")).hasClass("target")) {
		$($this.children(".nav")).removeClass("nav1");
		$($($this.siblings()).children(".target")).addClass("nav1")
	}
}
/**
 * 鼠标点击上一步按钮
 */
function preFun(self, pane) {
	//点击上一步本身消失，上一显示
	$("." + self).removeClass("show").hide();
	$("." + pane).addClass("show").show();
	//判断各个panel，修改导航
	switch (self) {
	case "panel1":
		$($(".name2").siblings()).removeClass("nav1").removeClass("target");
		$($(".name1").siblings()).addClass("nav1").addClass("target");
		break;
	case "panel2":
		$($(".name3").siblings()).removeClass("nav1").removeClass("target");
		$($(".name2").siblings()).addClass("nav1").addClass("target");
		break;
	}
}
/**
 * 鼠标点击下一步按钮
 */
var docPathStr = "";

function nextFun(self, pane) {
	//点击上一步本身消失，下一显示
	$("." + self).removeClass("show").hide();
	$("." + pane).addClass("show").show();
	//判断各个panel，修改导航
	switch (self) {
	case "panel":
		$($(".name1").siblings()).removeClass("nav1").removeClass("target");
		$($(".name2").siblings()).addClass("nav1").addClass("target").addClass("do");	
		
		break;
	case "panel1":
		$($(".name2").siblings()).removeClass("nav1").removeClass("target");
		$($(".name3").siblings()).addClass("nav1").addClass("target").addClass("do");
		//获取试卷，显示在页面上
		$.getJSON("exam/ExaminationManageAction_examPaperManageOut",function(data){
			docPathStr = "resource/templete/examination/doc/" + data.examPaper+ ".doc";
			$("#testPaperOut").attr("src","resource/templete/examination/html/"+ data.examPaper + ".html");
		});
		break;
	}
}

/**
 * 点击考试课程，选择相应的课程
 * @param {Object} $this
 */
function bookSelectClickFun($this){
	var _img = $($this.children("span")).children("img");
	var _sibimg = $($($($($($this.parents("li")).siblings()).children(".book")).children(".icon")).children("span")).children("img");
	var clazz = $(_img).attr("class");
	if(clazz!="check"){
		$(_img).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		$(_sibimg).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
	if(clazz=="check"){
		$(_img).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}
/**
 * 点击选择框，全选所有章节或取消全选所有章节
 * @param {Object} $this
 */
function chapterSelectAllClickFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$($(".select_btn").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$($(".select_btn").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}
/**
 * 单个章节选择与取消
 * @param {Object} $this
 */
function chapterSelectSingleClickFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}
/**
 * 点击选择框，全选所有试题类型或取消全选所有试题类型
 * @param {Object} $this
 */
function typeSelectAllClickFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$($(".ratio").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$($(".ratio").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}
/**
 * 单个试题类型选择与取消
 * @param {Object} $this
 */
function typeSelectSingleClickFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}
/**
 * 点击选择框，全选所有试题或取消全选所有试题
 * @param {Object} $this
 */
function questionSelectAllClickFun($this){
	var clazz = $this.attr("class");
	var optionClazz = $("select option:selected").attr("class");
	var optionClazzs = optionClazz.split(" ");
	switch (optionClazzs[0]) {
	case "_s_s":
		if(clazz!="check"){
			$("select option:selected").addClass("check");
			$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
			$($(".s_s_").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		}
		if(clazz=="check"){
			$("select option:selected").removeClass("check");
			$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
			$($(".s_s_").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		}
		break;
	case "_s_m":
		if(clazz!="check"){
			$("select option:selected").addClass("check");
			$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
			$($(".s_m_").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		}
		if(clazz=="check"){
			$("select option:selected").removeClass("check");
			$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
			$($(".s_m_").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		}
		break;
	case "_s_j":
		if(clazz!="check"){
			$("select option:selected").addClass("check");
			$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
			$($(".s_j_").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		}
		if(clazz=="check"){
			$("select option:selected").removeClass("check");
			$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
			$($(".s_j_").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		}
		break;
	case "_s_b":
		if(clazz!="check"){
			$("select option:selected").addClass("check");
			$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
			$($(".s_b_").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		}
		if(clazz=="check"){
			$("select option:selected").removeClass("check");
			$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
			$($(".s_b_").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		}
		break;
	case "_s_saqs":
		if(clazz!="check"){
			$("select option:selected").addClass("check");
			$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
			$($(".s_saqs_").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
		}
		if(clazz=="check"){
			$("select option:selected").removeClass("check");
			$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
			$($(".s_saqs_").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
		}
		break;
	}
}
/**
 * 单个试题选择与取消
 * @param {Object} $this
 */
function questionSelectSingleClickFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}
/**
 * 点击选择框，全选所有已选试题或取消全选所有已选试题
 * @param {Object} $this
 */
function questSelectAllClickFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$($(".select_img_si").children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$($(".select_img_si").children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}
/**
 * 单个已选试题选择与取消
 * @param {Object} $this
 */
function questSelectSingleClickFun($this){
	var clazz = $this.attr("class");
	if(clazz!="check"){
		$this.addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	if(clazz=="check"){
		$this.removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
}
/**
 * 下拉选择，根据选择项，切换下面选择的试题。
 * @param {Object} $this
 */
function typeChangeFun($this){
	var clazz = $("select option:selected").attr("class");
	var clazzs = clazz.split(" ");
	if(clazzs[1]!="check"){
		$($($($this.parent(".select_cont")).siblings(".select_img")).children("img")).removeClass("check").attr("src","resource/image/examination/select_false_BG.png");
	}
	if(clazzs[1]=="check"){
		$($($($this.parent(".select_cont")).siblings(".select_img")).children("img")).addClass("check").attr("src","resource/image/examination/select_true_BG.png");
	}
	switch (clazzs[0]) {
	case "_s_s":
		$(".select_content").hide();
		$(".s_s").show();
		break;
	case "_s_m":
		$(".select_content").hide();
		$(".s_m").show();
		break;
	case "_s_j":
		$(".select_content").hide();
		$(".s_j").show();
		break;
	case "_s_b":
		$(".select_content").hide();
		$(".s_b").show();
		break;
	case "_s_saqs":
		$(".select_content").hide();
		$(".s_saqs").show();
		break;
	}
}
/**
 * 添加试题按钮
 * @param {Object} $this
 */
function questionAddClickFun($this){
	alert("questionAddClickFun方法")
}
/**
 * 删除试题按钮
 * @param {Object} $this
 */
function questionDeleteClickFun($this){
	alert("questionDeleteClickFun方法")
}
function downExamPaper(){
	if (docPathStr != "") {
		window.location.href = "http://" + window.location.host + "/srts/" + docPathStr;
	}
}