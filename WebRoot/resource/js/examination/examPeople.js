/**
 * 全选
 */
function selectAll(selAll) {
	var departments = document.getElementsByName("departmentIds");
	if (selAll.checked == true) {
		for ( var i = 0; i < departments.length; i++) {
			departments[i].checked = true;
		}
	} else {
		for ( var i = 0; i < departments.length; i++) {
			departments[i].checked = false;
		}
	}
	selDepWorkers();
}
/**
 * 父选择子全选
 */
function parentChoice($this) {

	var child = $this.parents("#parent_dep").siblings("#child_dep").find(
			".department");
	if ($this.prop("checked") == true) {
		child.prop("checked", true);
	} else {
		child.prop("checked", false);
	}
	selDepWorkers();
}

/**
 * 子选择父选择
 */
function childChoice($this) {
	var parent = $this.parents("#child_dep").siblings("#parent_dep").find(
			".department");
	var bro = $this.parent().siblings().find(":checked");
	if ($this.prop("checked") == true) {
		parent.prop("checked", true);
	} else {
		if(bro.length>0){
			parent.prop("checked", true);
		}else{
			parent.prop("checked", false);
		}
	}
	selDepWorkers();
}

/**
 * 根据部门获取相应的员工信息
 */

function getWorkers(dep, cou) {
	var count = cou.value;
	var depSelecteds = "";
	var depsel=$(".department:checked");
	var select_sum=$("#select_sum").text();

	//判断至少一个部门被选中
	if(depsel.length==0){
		alert("请选择部门！！");
		return "pause";
	}else{
		//判断输入的是否为数字
		if(count==""||count==null){
		alert("请输入考试总人数！")
		return "pause";
	}else {
		if(isNaN(count)){
			alert("您输入的不是有效数字");
			return "pause";
		}else{
			if(parseInt(select_sum)<parseInt(count)){
				alert("请输入小于已选部门员工总数的有效数字!!");
				return "pause";
			}
		}
	}
	}
	
	for ( var i = 0; i < dep.length; i++) {
		if (dep[i].checked == true) {
			depSelecteds += dep[i].value + ",";
		}
	}

	$
			.getJSON(
					"exam/ExaminationPeopleAction_findAllWorkers",
					{
						depSelected:depSelecteds,
						counts:count,
						b:Math.random()
					},
					function(data) {
						var depAndWrokers = eval("(" + data + ")");
						var content = "";
						for ( var i = 0; i < depAndWrokers.length; i++) {
								content+="<div class='dep_work_info'>";
							for ( var key in depAndWrokers[i]) {
								//获取部门信息
								if (key == "dep") {
									for(var depKey in depAndWrokers[i][key]){
									if(depKey=="id"){
									content += "<div class='title' id=dp_"+depAndWrokers[i][key][depKey]+" name='dep_work_info_dep' value="+depAndWrokers[i][key][depKey]+">"  ;
								  }
								if(depKey=="name"){
									content+=depAndWrokers[i][key][depKey]+ "</div>";
								  }	
									}				
								}
								
								//获取员工信息
								if (key == "worker") {
									content+="<div class='work_info'>";
									for ( var j = 0; j < depAndWrokers[i][key].length; j++) {
										var temp = depAndWrokers[i][key][j];
										for ( var val in temp) {
											if(val=="id"){
				                    content += "<span class='span_item'><input type='checkbox' class='works' id=wk_"+temp[val]+" name='dep_work_info_worker' value="+temp[val]+" onclick='selectedCount()' ";
											}
											if(val=="checkState"){
												if(parseInt(temp[val])==1){
				
													content+="checked='checked'  />";
												}
											}
											if (val == "name") {
											content+= temp[val] + "</span>";
											}
											if (val == "age") {
												if (parseFloat(temp[val]) >= 50) {
													//设置红色显示
													content += "<font color='#FF0000'>"
															+ temp[val]
															+ "岁</font>";
												} else {
													content += "" + temp[val]
															+ "岁";
												}
											}
											if (val == "cou") {
												content += "&nbsp;&nbsp;考试<font color='#FF0000'>"
														+ temp[val]
														+ "</font>次";
											}
											if (val == "fail") {
												content += "&nbsp;&nbsp;不合格<font color='#FF0000'>"
														+ temp[val]
														+ "</font>次";
											}
										}
										
									}
										content+="</div>";
								}
							
							}
								content+="</div>"
						}
						
				
						$("#selected_count").html(count);
						
						$("#dep_worker").html(content);

						$("#select_count").html(count);
					
					
					});
}
/**
 * 计算已经选择的部门的员工的总数
 */
function selDepWorkers(){
	var dep=document.getElementsByName("departmentIds");
	var depIds="";
	for(var i=0;i<dep.length;i++){
		if(dep[i].checked==true){
				depIds+=dep[i].value+",";
			}
	}

//	if(depIds.length!=0){
	$.getJSON("exam/ExaminationPeopleAction_findWorkNums?depSelected="+depIds,function(data){
		var num=eval("("+data+")");
		$("#select_sum").text(num.allnum);
	});
//	}else{
//		$("#select_sum").text("0");
//	}
//	
}
/**
 * 计算已经选择的员工的总数
 */
function selectedCount() {
	var worker = document.getElementsByName("dep_work_info_worker");
	var count = 0;
	for ( var i = 0; i < worker.length; i++) {
		if (worker[i].checked == true) {
			count += 1;
		}
	}
	$("#selected_count").html(count);
}

function clearAll(){
	var clear=$(".works:checked")
	for(var i=0;i<clear.length;i++){
	     clear[i].checked=false;
	}
}
/**
 * 随机选择
function randomChoice(){
	var dep=$(".span_item").parent(".work_info").prev(".title");
	var work=$(".works:checked");
	var depStr="";
	var workStr="";
	var select_count=$("#select_count").text();
	var selected_count=$("#selected_count").text();
	
	for(var i=0; i<dep.length;i++){
		depStr+=dep[i].value+",";
	}
	for(var i=0; i<work.length;i++){
		workStr+=work[i].value+",";
	}
	alert("zhixing");
	//如果未选择员工，则workStr为空，要设置判断条件了
	$.getJSON("exam/ExaminationPeopleAction_getWorkersByRandom",function(data){
		alert("客户端传回数据"+data);
	});	
}
*  */

/**
 * 选择员工
 */
function worker_choice(){
	var exm_name=$("#exm_name").val();
	if(exm_name==null||exm_name==""){
		alert("当前没有考试，您不能抽人！！！");
		return false;
	}
	
	var res=getWorkers(document.getElementsByName('departmentIds'),document.getElementById('count'));
	if(res!="pause"){
		$("#no1").css("background","#FFFFFF");
		$("#no2").css("background","#006E6B");
		$("#dep_choice").css("display","none");
	$("#namelist_all").css("display","block");
	}
}
/**
 * 上一步
 */
function preStep(){
	$("#no1").css("background","#006E6B");
		$("#no2").css("background","#FFFFFF");
	$("#dep_choice").css("display","block");
	$("#namelist_all").css("display","none");
}
/**
 * 生成名单
 */
function create_name_list(){
	 var names=$(".works:checked");
	 var exm_name=$("#exm_name  option:selected").val();
	 var list="";
	 var cnt='<tr><td>序号</td><td>人名</td><td>部门</td></tr>';


	 var j=1;
	 for(var i=0;i<names.length;i++){
		 list+=names[i].value+",";
	 }

	 $.getJSON("exam/ExaminationPeopleAction_createNameList",
		 {
		 nameList:list,
		 testInfoId:exm_name,
		 b:Math.random()
		 },
		 function(data){
		  $.each(data.userList,function(k,v){
			  var str='';
			  str="<tr><td>"+j+"</td><td>"+v.name+"</td><td>"+v.department.name+"</td></tr>";
			  cnt+=str;
			  	j++; 
		  });
		   $("table").html(cnt);
	 });

	 $("#namelist_all").css("display","none");
	 $("#create_namelist").css("display","block");
	 $("#exit").css("display","block");
}

/**
 * 导出名单
 */
function export_names(){
	var testInfoId=$("#exm_name").val();
	alert(testInfoId);
	window.location="exam/ExaminationPeopleAction_exporNameList?testInfoId="+testInfoId+"";
}































