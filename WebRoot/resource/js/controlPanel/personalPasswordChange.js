function submit($this) {
	var oldPassword = $("#tbOldPassword").attr("value");
	var newPassword = $("#tbPassword").attr("value");
	var newPasswordRepeat = $("#tbPasswordRepeat").attr("value");
	if(newPassword.length<6)
	{
		alert("新密码长度太短,请重新输入!");
		$("#tbPassword").val("");
		$("#tbPasswordRepeat").val("");
	}
	else if(newPassword!=newPasswordRepeat)
	{
		alert("两次输入新密码不符,请重新输入!");
		$("#tbPassword").val("");
		$("#tbPasswordRepeat").val("");
	}
	else
	{
		$.ajax({
	type:"POST",
	url:"ctro/PersonalCenterAction_personPasswordChange",
	data:"oldPassword="+oldPassword+"&newPassword="+newPassword,
	//////////上面是传递数据到服务器
	//////////下面是处理服务器返回的值
	success:function(data){
		var result=data.passwordChangeRes;
		if(result=="success")
		{
			alert("修改成功!");
			$("#tbPassword").val("");
		    $("#tbPasswordRepeat").val("");
		    $("#tbOldPassword").val("");
		}
		else if(result=="fail")
		{
			alert("修改失败!");
			$("#tbPassword").val("");
		    $("#tbPasswordRepeat").val("");
		    $("#tbOldPassword").val("");
		}
		else if(result=="error")
		{
			alert("旧密码不符,请重新输入!");
			$("#tbPassword").val("");
		    $("#tbPasswordRepeat").val("");
		    $("#tbOldPassword").val("");
		}
	}
    });
	}
	
}
function reset($this) {
	
			$("#tbPassword").val("");
		    $("#tbPasswordRepeat").val("");
		    $("#tbOldPassword").val("");
}