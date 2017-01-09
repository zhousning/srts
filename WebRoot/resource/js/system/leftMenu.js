// JavaScript Document
$(document).ready(function() {
		$(".item").click(function() {
//				$(this).siblings(".item").css("background-image","url(resource/image/system/left_item_train_click.png)");
				if($(this).next("div").css("display") == "none"){
						$(this)./*css("background-image","url(resource/image/system/left_item_train_release.png)").*/next("div").slideDown("slow").siblings(".subitem:visible").slideUp("slow");
					}else{
						$(this)./*css("background-image","url(resource/image/system/left_item_train_click.png)").*/next("div").slideUp("slow").siblings(".subitem:visible").slideUp("slow");
					}
			});
//		$(".oneItem_bg").mouseover(function() {
//				if($(this).next("div").css("display") == "none"){
//					$(this).css("background-image","url(resource/image/system/leftMenuOneItem_focus_bg.gif)");
//				}
//			});
//		$(".oneItem_bg").mouseout(function() {
//				if($(this).next("div").css("display") == "none"){
//					$(this).css("background-image","url(resource/image/system/leftMenuOneItem_bg.gif)");
//				}
//			});
/*
		$(".subitem1").mousedown(function() {
				$(this).css("background-image","url(resource/image/system/leftMenuTwoItem_click_bg.gif)");
			});
		$(".subitem1").mouseup(function() {
				$(this).css("background-image","url(resource/image/system/leftMenuTwoItem_bg.gif)");
			});
		$(".subitem1").mouseout(function() {
				$(this).css("background-image","url(resource/image/system/leftMenuTwoItem_bg.gif)");
			});
			*/
	});