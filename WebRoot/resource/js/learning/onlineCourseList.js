/**
 * 点击切换各个学习资源
 * @param {Object} $this
 */
function onlineCourseListChangeFun($this){
	var clazz = $this.attr("class");
	var clazzs = clazz.split(" ");
	if(clazzs[1]=="bk"){
		
		$(".title_p").css({"color":"#000000","border-bottom":"none"});
		$(".content").hide();
		$("#bk").show();
		$this.css({"color":"#006e6b","border-bottom":"3px solid #006e6b"});
	}
	if(clazzs[1]=="pt"){
		$(".title_p").css({"color":"#000000","border-bottom":"none"});
		$(".content").hide();
		$("#pt").show();
		$this.css({"color":"#006e6b","border-bottom":"3px solid #006e6b"});
	}
	if(clazzs[1]=="ad"){
		$(".title_p").css({"color":"#000000","border-bottom":"none"});
		$(".content").hide();
		$("#ad").show();
		$this.css({"color":"#006e6b","border-bottom":"3px solid #006e6b"});
	}
}