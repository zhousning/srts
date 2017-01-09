/**
 * 点击章节名，获取章节内容
 * @param {Object} $this
 */
var clickDelay;
function readBookChapterContent($this) {
	var chapterID = $this.attr("id");
	$("#studyContentSave").attr("chapterID", chapterID);
	$("#img_" + chapterID).attr("src",
			"resource/image/learning/chapter_status_un_BG.png");
	$("#img1_" + chapterID).attr("src", "resource/image/learning/line2.png");
	var beforeChapterID = $("#studyContentSave").attr("beforeChapterID");
	if (beforeChapterID != "") {
		$("#img_" + beforeChapterID).attr("src",
				"resource/image/learning/chapter_status_f_BG.png");
		$("#img1_" + beforeChapterID).attr("src",
				"resource/image/learning/line1.png");
	}
	var chapterName = $this.text();
	clickDelay = setTimeout(function() {
		$.getJSON("learning/OnlineCourseAction_chapterContentDisp?chapterID="
				+ chapterID, function(data) {

		
			var res = "";
			$.each(data.contentList, function(i, v) {  
					var contents = "";
				var str = v.content.split(/\r\n/);
				for(var i=0;i<str.length;i++){
					if(i==0){
						contents+=str[i]+"</br>";
					}else{
						contents+=str[i]+"</br>";
					}
					
				}
				res += "<div id='con'>" + contents + "</div>";
			});
			$("#currentChapter").text(chapterName);
			$("#chapterContent").html(res);
		});
	}, 300);
	$("#studyContentSave").attr("beforeChapterID", chapterID);
}
function readBookChapterContentOut($this) {
	clearTimeout(clickDelay);
}
function checkLeave() {
	var post = "1";
	var courseID = $("#studyContentSave").attr("courseInfo").toString();
	var studyStartTime = $("#studyContentSave").attr("studyStartTime")
			.toString();
	$.ajax( {
		type : "POST",
		url : "learning/OnlineCourseAction_updateOnlineCourseStudy",
		data : "post=" + post + "&courseID=" + courseID + "&studyStartTime="
				+ studyStartTime,
		//////////上面是传递数据到服务器
		//////////下面是处理服务器返回的值
		success : function(data) {
			var result = data.resString;
			if (result == "success") {
				alert("修改成功!");
			} else if (result == "fail") {
				alert("修改失败!");
			}
		}
	});
}