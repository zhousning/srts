<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript" src="resource/script/jquery/jquery.metadata.js"></script>
    <script type="text/javascript" src="resource/script/jquery/jquery.validate.js"></script>
    
 <script type="text/javascript"> 
    jQuery.extend(jQuery.validator.messages, {
	    required: "*",
	    remote: "验证失败",
	    email: "请输入正确的电子邮件",
	    url: "请输入正确的网址",
	    date: "请输入正确的日期",
	    dateISO: "请输入正确的日期 (ISO).",
	    number: "请输入正确的数字",
	    digits: "请输入正确的整数",
	    creditcard: "请输入正确的信用卡号",
	    equalTo: "请再次输入相同的值",
	    accept: "请输入指定的后缀名的字符串",
	    maxlength: jQuery.validator.format("最大长度为{0}"),
	    minlength: jQuery.validator.format("最小长度为{0}"),
	    rangelength: jQuery.validator.format("允许的长度为{0}和{1}之间"),
	    range: jQuery.validator.format("请输入介于 {0} 和 {1} 之间的值"),
	    max: jQuery.validator.format("请输入一个最大为{0}  的值"),
	    min: jQuery.validator.format("请输入一个最小为 {0} 的值")
	});
   
   	
   	$(function(){
   	 	//关闭ajax相应的缓存
        $.ajaxSetup ({
        	cache: false
        });
   	
   		// 表单在提交前要先进行验证
   	 $("form").validate();
   	});
   </script>
   
       
    <style type="text/css">
		label.error{
			margin-left: 10px;
			color: red;
		}
	</style>