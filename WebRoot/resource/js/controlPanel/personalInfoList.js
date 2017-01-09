function c(i){
	var i;
	document.getElementById("tab").className="tabD"+i;
	window.name=i;
}
function initPage()
{
	$("#selfInfoAndNotice").show();
	$("#selfTestAndComp").hide();
	$("#selfCourseAndFavor").hide();
	$("#selfExeTrace").hide();
	$("#selfKnowledgeBank").hide();
	$("#selfCommunication").hide();
	$("#selfEstimation").hide();
}
function goUrlSelfInfoAndNotice(){
	$("#selfInfoAndNotice").show();
	$("#selfTestAndComp").hide();
	$("#selfCourseAndFavor").hide();
	$("#selfExeTrace").hide();
	$("#selfKnowledgeBank").hide();
	$("#selfCommunication").hide();
	$("#selfEstimation").hide();
	
}
function goUrlSelfTestAndComp(){
	$("#selfInfoAndNotice").hide();
	$("#selfTestAndComp").show();
	$("#selfCourseAndFavor").hide();
	$("#selfExeTrace").hide();
	$("#selfKnowledgeBank").hide();
	$("#selfCommunication").hide();
	$("#selfEstimation").hide();
	
}
function goUrlSelfCourseAndFavor(){
	$("#selfInfoAndNotice").hide();
	$("#selfTestAndComp").hide();
	$("#selfCourseAndFavor").show();
	$("#selfExeTrace").hide();
	$("#selfKnowledgeBank").hide();
	$("#selfCommunication").hide();
	$("#selfEstimation").hide();
	
}
function goUrlSelfExeTrace(){
	$("#selfInfoAndNotice").hide();
	$("#selfTestAndComp").hide();
	$("#selfCourseAndFavor").hide();
	$("#selfExeTrace").show();
	$("#selfKnowledgeBank").hide();
	$("#selfCommunication").hide();
	$("#selfEstimation").hide();
	
}
function goUrlSelfKnowledgeBank(){
	$("#selfInfoAndNotice").hide();
	$("#selfTestAndComp").hide();
	$("#selfCourseAndFavor").hide();
	$("#selfExeTrace").hide();
	$("#selfKnowledgeBank").show();
	$("#selfCommunication").hide();
	$("#selfEstimation").hide();
	
}
function goUrlSelfCommunication(){
	$("#selfInfoAndNotice").hide();
	$("#selfTestAndComp").hide();
	$("#selfCourseAndFavor").hide();
	$("#selfExeTrace").hide();
	$("#selfKnowledgeBank").hide();
	$("#selfCommunication").show();
	$("#selfEstimation").hide();
	
}
function goUrlSelfEstimation(){
	$("#selfInfoAndNotice").hide();
	$("#selfTestAndComp").hide();
	$("#selfCourseAndFavor").hide();
	$("#selfExeTrace").hide();
	$("#selfKnowledgeBank").hide();
	$("#selfCommunication").hide();
	$("#selfEstimation").show();
	
}
function turnToPageN($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#sTTIU_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#sTTIU_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#sTTIU_"+k.toString()).hide();
	}
}
function turnToPageN1($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo1").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#sMTIU_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#sMTIU_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#sMTIU_"+k.toString()).hide();
	}
}
function turnToPageN2($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo2").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#sCIBU_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#sCIBU_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#sCIBU_"+k.toString()).hide();
	}
}
function turnToPageN3($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo3").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#sCOUIBU_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#sCOUIBU_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#sCOUIBU_"+k.toString()).hide();
	}
}
function turnToPageN4($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo4").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#sEIBU_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#sEIBU_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#sEIBU_"+k.toString()).hide();
	}
}
function turnToPageN5($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo5").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#sKBIBU_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#sKBIBU_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#sKBIBU_"+k.toString()).hide();
	}
}
function turnToPageN6($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo6").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#sPIBU_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#sPIBU_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#sPIBU_"+k.toString()).hide();
	}
}
function turnToPageN7($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo7").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#sAIBU_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#sAIBU_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#sAIBU_"+k.toString()).hide();
	}
}
function turnToPageN8($this)
{
	var page=parseInt($($this.parent("li")).attr("value"));
	var resNum=parseInt($("#pageInfo8").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#sTBU_"+i.toString()).show();    
	}
	for(var j=1;j<=(page-1)*3;j++)
	{
		$("#sTBU_"+j.toString()).hide();
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#sTBU_"+k.toString()).hide();
	}
}
function initMessage()
{
	//
	var page=1;
	var resNum=parseInt($("#pageInfo").attr("recordAmount"));
	var endPage=page*3;
	if(resNum<endPage)
	{
		endPage=resNum;
	}
	for(var i=(page-1)*3+1;i<=endPage;i++)
	{
		$("#sTTIU_"+i.toString()).show();    
	}
	for(var k=endPage+1;k<=resNum;k++)
	{
		$("#sTTIU_"+k.toString()).hide();
	}
	//
	var page1=1;
	var resNum1=parseInt($("#pageInfo1").attr("recordAmount"));
	var endPage1=page1*3;
	if(resNum1<endPage1)
	{
		endPage1=resNum1;
	}
	for(var i1=(page1-1)*3+1;i1<=endPage1;i1++)
	{
		$("#sMTIU_"+i1.toString()).show();    
	}
	for(var k1=endPage+1;k1<=resNum1;k1++)
	{
		$("#sMTIU_"+k1.toString()).hide();
	}
	//
	var page2=1;
	var resNum2=parseInt($("#pageInfo2").attr("recordAmount"));
	var endPage2=page2*3;
	if(resNum2<endPage2)
	{
		endPage2=resNum2;
	}
	for(var i2=(page2-1)*3+1;i2<=endPage2;i2++)
	{
		$("#sCIBU_"+i2.toString()).show();    
	}
	for(var k2=endPage+1;k2<=resNum2;k2++)
	{
		$("#sCIBU_"+k2.toString()).hide();
	}
	//
	var page3=1;
	var resNum3=parseInt($("#pageInfo3").attr("recordAmount"));
	var endPage3=page3*3;
	if(resNum3<endPage3)
	{
		endPage3=resNum3;
	}
	for(var i3=(page3-1)*3+1;i3<=endPage3;i3++)
	{
		$("#sCOUIBU_"+i3.toString()).show();    
	}
	for(var k3=endPage+1;k3<=resNum3;k3++)
	{
		$("#sCOUIBU_"+k3.toString()).hide();
	}
	//
	var page4=1;
	var resNum4=parseInt($("#pageInfo4").attr("recordAmount"));
	var endPage4=page4*3;
	if(resNum4<endPage4)
	{
		endPage4=resNum4;
	}
	for(var i4=(page4-1)*3+1;i4<=endPage4;i4++)
	{
		$("#sEIBU_"+i4.toString()).show();    
	}
	for(var k4=endPage4+1;k4<=resNum4;k4++)
	{
		$("#sEIBU_"+k4.toString()).hide();
	}
	//
	var page5=1;
	var resNum5=parseInt($("#pageInfo5").attr("recordAmount"));
	var endPage5=page5*3;
	if(resNum5<endPage5)
	{
		endPage5=resNum5;
	}
	for(var i5=(page5-1)*3+1;i5<=endPage5;i5++)
	{
		$("#sKBIBU_"+i5.toString()).show();    
	}
	for(var k5=endPage5+1;k5<=resNum5;k5++)
	{
		$("#sKBIBU_"+k5.toString()).hide();
	}
	//
	var page6=1;
	var resNum6=parseInt($("#pageInfo6").attr("recordAmount"));
	var endPage6=page6*3;
	if(resNum6<endPage6)
	{
		endPage6=resNum6;
	}
	for(var i6=(page6-1)*3+1;i6<=endPage6;i6++)
	{
		$("#sPIBU_"+i6.toString()).show();    
	}
	for(var k6=endPage6+1;k6<=resNum6;k6++)
	{
		$("#sPIBU_"+k6.toString()).hide();
	}
	//
	var page7=1;
	var resNum7=parseInt($("#pageInfo7").attr("recordAmount"));
	var endPage7=page7*3;
	if(resNum7<endPage7)
	{
		endPage7=resNum7;
	}
	for(var i7=(page7-1)*3+1;i7<=endPage7;i7++)
	{
		$("#sAIBU_"+i7.toString()).show();    
	}
	for(var k7=endPage7+1;k7<=resNum7;k7++)
	{
		$("#sAIBU_"+k7.toString()).hide();
	}
	//
	var page8=1;
	var resNum8=parseInt($("#pageInfo8").attr("recordAmount"));
	var endPage8=page8*3;
	if(resNum8<endPage8)
	{
		endPage8=resNum8;
	}
	for(var i8=(page8-1)*3+1;i8<=endPage8;i8++)
	{
		$("#sTBU_"+i8.toString()).show();    
	}
	for(var k8=endPage8+1;k8<=resNum8;k8++)
	{
		$("#sTBU_"+k8.toString()).hide();
	}
}