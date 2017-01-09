/**
 * 添加部门
 */


/**
 * 根据部门id获取相应信息
 */
function getById(id){
	var depId=id;
	$.getJSON("system/departmentAction_getDepById?depId="+depId+"",function(data){
		var val=eval('('+data+')');
		var id,name,parentId;
		for(var i in val){
			
		 if(i=='id'){
			id=val[i];
			$("#depId").attr("value",id);
			
		 }
		 if(i=='name'){
			 name=val[i];
			 $("#depName").attr("value",name);
		 }
		 if(i=='parentId'){
			 parentId=val[i];
			 $("#upDepId").attr("value",parentId);
		 }
		}
	});
}

/**
 * 删除部门
 */
function delete_dep(){
	var depId=$("#depId").val();
	
	if(depId==null||depId==""){
		alert("请选择一个部门");
	}else{
		$.getJSON("system/departmentAction_delete?depId="+depId+"",function(data){
			
			var json=eval("("+data+")");
	
			if(json.k=="success"){
				window.location='departmentAction!findTopDepList.action';
			}else{
				alert("删除失败！！！"+json.k);
			}
			
		});
	}
	
}

/**
 * 保存部门验证
 */
function add_test(){
	var dep_name=$("#dep_name").val();
	if(dep_name!=""){
		location.href="system/departmentAction_addDepartment";
	}else{
		alert("请填写部门名称!")
	}
}

function update_dep(){
	var dep_name=$("#depName").val();
	if(dep_name!=""){
		location.href="system/departmentAction_updateDepartment";
	}else{
		alert("请选择一个部门!")
	}
}


