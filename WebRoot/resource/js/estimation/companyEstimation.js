/**
 * 初始化设置默认查询日期为当前月
 * @memberOf {TypeName} 
 */
function initChart(){
	
//	var chart1ID=Math.random().toString();
//	var chart2ID=Math.random().toString();
//	var chart3ID=Math.random().toString();
	$.getJSON("wkea/CompanyEstimateAction_AveScoreByCompanyAndDeptAnalysis",function(data){
		//按单位查询
		var data0 = eval("(" + data.selectAveScoreByCompanyAndDept+ ")");
		var aveScoreByCompanyAndDeptChart = new FusionCharts("resource/script/fusioncharts/swf/ScrollLine2D.swf","chart1ID", "1000", "260", "0", "0");
	aveScoreByCompanyAndDeptChart.setChartData(data0 , "json");
	aveScoreByCompanyAndDeptChart.render("aveScoreByCompanyAndDeptContainer");
	});
	
	$.getJSON("wkea/CompanyEstimateAction_categoryTestScoreAnalysis",function(data){
		//成绩分类饼图
		var scorePerc = eval("(" + data.categoryTestScoreByTestCompanyAndDept + ")");
		var scorePercChart = new FusionCharts("resource/script/fusioncharts/swf/Pie3D.swf", "chart3ID", "1000", "260", "0", "0");
		scorePercChart.setChartData(scorePerc , "json");	   
		scorePercChart.render("categoryTestScoreContainer");
	});
	
	$.getJSON("wkea/CompanyEstimateAction_AveScoreByTestNameAnalysis",function(data){
		
		//按考试查询
		var testSearch = eval("(" + data.selectAveScoreByTestName + ")");
		var testSearchChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf","chart2ID", "1000", "260", "0" );
		testSearchChart.setChartData(testSearch , "json");
		testSearchChart.render("aveScoreByTestNameContainer");		
	});
}

function queryByOptionFunction()
{
	   var companyId=$("#companyId").val();
	   var deptId=$("#dept").val();
	   var startDate=$("#startDate").val();
	   var endDate=$("#endDate").val();
	   var testInfoId=$("#testInfo").val();
       if(companyId==null)
       {
    	   companyId="0";
       }
       if(deptId==null)
       {
    	   deptId="0";
       }
       if(testInfoId==null)
       {
    	   testInfoId="0";
       }
       if(startDate==null)
       {
    	   startDate="";
       }
       if(endDate==null)
       {
    	   endDate="";
       }
       if(endDate!="")
       {
    	   endDate=encodeURI(endDate);
	       endDate=encodeURI(endDate);
       }
	   if(startDate!="")
       {
    	   startDate=encodeURI(startDate);
	       startDate=encodeURI(startDate);
       }
	   window.location.href = "wkea/CompanyEstimateAction_searchAllTestInfoAndEstString?companyId="+companyId+"&deptId="+deptId+"&endDate="+endDate+"&startDate="+startDate+"&testInfoId="+testInfoId;
}

function CompanyDeptOnChange()
{
	var companyId=$("#companyId").val();
	if(companyId==null)
       {
    	   companyId="0";
       }
	$.ajax({
	type:"POST",
	url:"wkea/CompanyEstimateAction_CompanyDeptOnChange",
	data:"companyId="+companyId,
	//////////上面是传递数据到服务器
	//////////下面是处理服务器返回的值
	success:function(data){
		
	}
    });
}
function CompanyDeptOnChange()
{
	var companyId=$("#companyId").val();
	if(companyId==null)
       {
    	   companyId="0";
       }
	$.ajax({
	type:"POST",
	url:"wkea/CompanyEstimateAction_CompanyDeptOnChange",
	data:"companyId="+companyId,
	success:function(data){
		var strHtml= "";
			if(data.findChildDeptByCompanyId.length!=0){
				$.each(data.findChildDeptByCompanyId,function(key,val){
					strHtml += "<option value=\""+val.id+"\">"+val.name+"</option>";
				});
				$("#dept").html(strHtml);
			}else{
				$("#dept").html(strHtml);
			}
	}
    });
}
function TestInfoOnChange()
{
	 var startDate=$("#startDate").val();
	 var endDate=$("#endDate").val();
	   if(startDate==null)
       {
    	   startDate="";
       }
       if(endDate==null)
       {
    	   endDate="";
       }
	   if(endDate!="")
       {
    	   endDate=encodeURI(endDate);
	       endDate=encodeURI(endDate);
       }
	   if(startDate!="")
       {
    	   startDate=encodeURI(startDate);
	       startDate=encodeURI(startDate);
       }
	   $.ajax({
	type:"POST",
	url:"wkea/CompanyEstimateAction_TestInfoOnDateOnchange",
	data:"startDate="+startDate+"&endDate="+endDate,
	success:function(data){
		var strHtml= "";
			if(data.findTestInfoByStartDateAndEndDate.length!=0){
				$.each(data.findTestInfoByStartDateAndEndDate,function(key,val){
					strHtml += "<option value=\""+val.id+"\">"+val.name+"</option>";
				});
				$("#test").html(strHtml);
			}else{
				$("#test").html(strHtml);
			}
	}
    });
}

function CompanyDeptOnChange1()
{
	var companyId1=$("#companyId1").val();
	if(companyId1==null)
       {
    	   companyId1="0";
       }
	$.ajax({
	type:"POST",
	url:"wkea/CompanyEstimateAction_CompanyDeptOnChange1",
	data:"companyId1="+companyId1,
	success:function(data){
		var strHtml= "";
			if(data.findChildDeptByCompanyId1.length!=0){
				$.each(data.findChildDeptByCompanyId1,function(key,val){
					strHtml += "<option value=\""+val.id+"\">"+val.name+"</option>";
				});
				$("#dept1").html(strHtml);
			}else{
				$("#dept1").html(strHtml);
			}
	}
    });
}

function queryByOptionFunction1()
{
	//var chart1ID=Math.random().toString();
	var companyId1=$("#companyId1").val();
	var deptId1=$("#dept1").val();
	$.ajax({
	type:"POST",
	url:"wkea/CompanyEstimateAction_AveScoreByCompanyAndDeptAnalysis",
	data:"companyId1="+companyId1+"&deptId1="+deptId1,
	success:function(data){
		
	}
    });
	$.getJSON("wkea/CompanyEstimateAction_AveScoreByCompanyAndDeptAnalysis",function(data){
		//按单位查询
		var data0 = eval("(" + data.selectAveScoreByCompanyAndDept+ ")");
		var aveScoreByCompanyAndDeptChart=FusionCharts("chart1ID");
		//var aveScoreByCompanyAndDeptChart = new FusionCharts("resource/script/fusioncharts/swf/ScrollLine2D.swf",chart1ID, "1000", "260", "0", "0");
	aveScoreByCompanyAndDeptChart.setChartData(data0 , "json");
	aveScoreByCompanyAndDeptChart.render("aveScoreByCompanyAndDeptContainer");
	});
}

function queryByOptionFunction2()
{
	   //var chart2ID=Math.random().toString();
	   var companyId2=$("#companyId2").val();
	   var testInfoId2=$("#test2").val();
       if(companyId2==null)
       {
    	   companyId2="0";
       }
       if(testInfoId2==null)
       {
    	   testInfoId2="0";
       }
       $.ajax({
	type:"POST",
	url:"wkea/CompanyEstimateAction_AveScoreByTestNameAnalysis",
	data:"companyId2="+companyId2+"&testInfoId2="+testInfoId2,
	success:function(data){
		
	}
    });
       $.getJSON("wkea/CompanyEstimateAction_AveScoreByTestNameAnalysis",function(data){
		
		//按考试查询
		var testSearch = eval("(" + data.selectAveScoreByTestName + ")");
		var testSearchChart=FusionCharts("chart2ID");
		//var testSearchChart = new FusionCharts( "resource/script/fusioncharts/swf/Column3D.swf",chart2ID, "1000", "260", "0" );
		testSearchChart.setChartData(testSearch , "json");
		testSearchChart.render("aveScoreByTestNameContainer");		
	});
}

function CompanyDeptOnChange3()
{
	var companyId3=$("#companyId3").val();
	if(companyId3==null)
       {
    	   companyId3="0";
       }
	$.ajax({
	type:"POST",
	url:"wkea/CompanyEstimateAction_CompanyDeptOnChange3",
	data:"companyId3="+companyId3,
	success:function(data){
		var strHtml= "";
			if(data.findChildDeptByCompanyId3.length!=0){
				$.each(data.findChildDeptByCompanyId3,function(key,val){
					strHtml += "<option value=\""+val.id+"\">"+val.name+"</option>";
				});
				$("#dept3").html(strHtml);
			}else{
				$("#dept3").html(strHtml);
			}
	}
    });
}

function queryByOptionFunction3()
{
	//var chart3ID=Math.random().toString();
	var companyId3=$("#companyId3").val();
	   var deptId3=$("#dept3").val();
	   var testInfoId3=$("#test3").val();
       if(companyId3==null)
       {
    	   companyId3="0";
       }
       if(deptId3==null)
       {
    	   deptId3="0";
       }
       if(testInfoId3==null)
       {
    	   testInfoId3="0";
       }
        $.ajax({
	type:"POST",
	url:"wkea/CompanyEstimateAction_categoryTestScoreAnalysis",
	data:"companyId3="+companyId3+"&deptId3="+deptId3+"&testInfoId3="+testInfoId3,
	success:function(data){
		
	}
    });
        $.getJSON("wkea/CompanyEstimateAction_categoryTestScoreAnalysis",function(data){
		//成绩分类饼图
		var scorePerc = eval("(" + data.categoryTestScoreByTestCompanyAndDept + ")");
		var scorePercChart=FusionCharts("chart3ID");
		//var scorePercChart = new FusionCharts("resource/script/fusioncharts/swf/Pie3D.swf", chart3ID, "1000", "260", "0", "0");
		scorePercChart.setChartData(scorePerc , "json");	   
		scorePercChart.render("categoryTestScoreContainer");
	});
}