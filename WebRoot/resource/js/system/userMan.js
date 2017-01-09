/**
 * 提交查询表单
 */
function submit_form(){
	var userName=$("#userName").val();
	var depId=$("#depId").val();
	var workNo=$("#workNo").val();
	
	$("form").submit();
	
}

function save_user(){
	window.location='system/userAction!userShow.action';
}

function delete_user(userId){
	alert("执行这个");
	var v=userId
	alert(v);
	window.location="system/userAction!deleteUserById?userId="+v+"";
}
