
/**
 * 更新课程信息
 * @param {Object} courseType
 */
function saveCourseInfo(courseType){
	var tag1_val = "";
	var tag2_val = "";
	var tag3_val = "";
	var tag4_val = "";
	if(courseType == "BOOK"){
		tag1_val = $("#bookID").val();
		tag2_val = $("#bookName").val();
		tag3_val = $("#bookIntro").val();
		tag4_val = courseType;
	}
	if(courseType == "PPT"){
		tag1_val = $("#pptID").val();
		tag2_val = $("#pptName").val();
		tag3_val = $("#pptIntro").val();
		tag4_val = courseType;
	}
	if(courseType == "VIDEO"){
		tag1_val = $("#videoID").val();
		tag2_val = $("#videoName").val();
		tag3_val = $("#videoIntro").val();
		tag4_val = courseType;
	}
	$.ajax({
		data:{courseIds:tag1_val,courseName:tag2_val,courseIntro:tag3_val,courseType:tag4_val},
		type:"POST",
		dateType:"json",
		url:"learning/OnlineCourseManageAction_updateOnlineCourse",
		success:function(data){
			alert(data.messages);
			window.location.reload(true);
		}
	});
}

/**
 * 删除重新上传课本
 * @param {Object} $this
 */
function deleteAndUpload($this){
	alert($this.attr("id"));
}