    /**
	 * 去除空格
	 */
	function trim(str){
		str=str.replace(/^ +/,"");
		str=str.replace(/ +$/,"");
		return str;
	}
	/**
	 * 弹窗
	 */
	function initWin(){
		 //提示窗弹出
         var winHeight;
    	 var winWidth;
    	 var hintHeight;
    	 var coverWidth;
    
    	 winHeight=$(window).height();
    	 winWidth=$(window).width();
    	 hintHeight=$("#hint").height();
    	 hintWidth=$("#hint").width(); 
     //计算弹出窗口的左上角Y的偏移量 
     var popY=(winHeight-hintHeight)/2; 
     var popX=(winWidth-hintWidth)/2; 
     //设定窗口的位置 
      $("#cover").css("display","block");
     $("#hint").css("top",popY).css("left",popX).slideToggle("slow",function(){
    	 alert("回调函数");
    	 leave();
     }); 
	}
	
	/**
	 * 提交试卷答案
	 */
function submitForm(){
    var single=$("div[model='S']");
	var mul=$("div[model='M']");
	var judge=$("div[model='J']");
	var blank=$("div[model='B']");
	var change=$("div[model='C']");
	var explain=$("div[model='E']");
	var ask=$("div[model='A']");
	var ques=$("div[model='Q']");
	
	var testPaperId="";
	var userId="";
	
	var res="";
	/**
	 * 单选题
	 */
	for(var i=0;i<single.length;i++){
		var queId=$(single[i]).parent().attr("id");
		var itemVal=$(single[i]).find("input:checked");
		var itemRes="";
		if(itemVal.length<=0){
			itemRes="未答";
		}else{
			itemRes=itemVal.attr("value");
		}
		res+=queId+"@"+itemRes+",";
	}
    /**
	 * 多选题
	 */
	for(var i=0;i<mul.length;i++){
		var queId=$(mul[i]).parent().attr("id");
		var itemVal=$(mul[i]).find("input:checked");
		var itemRes="";
		if(itemVal.length<=0){
			itemRes="未答";
		}else{
			for(var j=0;j<itemVal.length;j++){
				var item=$(itemVal[j]).attr("value");
				itemRes+=item+"&";
			}
			
		}
		res+=queId+"@"+itemRes+",";
	}
	/**
	 * 判断题
	 */
	for(var i=0;i<judge.length;i++){
		var queId=$(judge[i]).parent().attr("id");
		var itemVal=$(judge[i]).find("input:checked");
		var itemRes="";
		if(itemVal.length<=0){
			itemRes="未答";
		}else{
			itemRes=itemVal.attr("value");
		}
		res+=queId+"@"+itemRes+",";
	}	
	/**
	 * 填空题
	 */
	for(var i=0;i<blank.length;i++){
		var queId=$(blank[i]).parent().attr("id");
		var itemVal=$(blank[i]).find("input");
		var itemRes2=itemVal.attr("value");
		var itemRes=trim(itemRes2);
		if(itemRes==""){
			itemRes="未答";
		}
		res+=queId+"@"+itemRes+",";
	}
	/**
	 * 改错题
	 */
	for(var i=0;i<change.length;i++){
		var queId=$(change[i]).parent().attr("id");
		var itemVal=$(change[i]).find("input");
		var itemRes2=itemVal.attr("value");
		var itemRes=trim(itemRes2);
		if(itemRes==""){
			itemRes="未答";
		}
		res+=queId+"@"+itemRes+",";
	}
	/**
	 * 名词解释
	 */
	for(var i=0;i<explain.length;i++){
		var queId=$(explain[i]).parent().attr("id");
		var itemVal=$(explain[i]).find("textarea");
		var itemRes2=itemVal.attr("value");
		var itemRes=trim(itemRes2);
		if(itemRes==""){
			itemRes="未答";
		}
		res+=queId+"@"+itemRes+",";
	}
	/**
	 * 简答题
	 */
	for(var i=0;i<ask.length;i++){
		var queId=$(ask[i]).parent().attr("id");
		var itemVal=$(ask[i]).find("textarea");
		var itemRes2=itemVal.attr("value");
		var itemRes=trim(itemRes2);
		if(itemRes==""){
			itemRes="未答";
		}
		res+=queId+"@"+itemRes+",";
	}
	/**
	 * 简答题
	 */
	for(var i=0;i<ques.length;i++){
		var queId=$(ques[i]).parent().attr("id");
		var itemVal=$(ques[i]).find("textarea");
		var itemRes2=itemVal.attr("value");
		var itemRes=trim(itemRes2);
		if(itemRes==""){
			itemRes="未答";
		}
		res+=queId+"@"+itemRes+",";
	}
	alert(res);
	location.href="exam/ExaminationTrainAction_insertAnswer?questionAnswer="+res+"";
	      
}
function comStatus($this){
	var obj=$this.parents(".question_cont").attr("model");
	var ids=$this.attr("ids");
	if(obj=="S"||obj=="J"){
		$("#"+ids+"").attr("class","check_y");
	}
	if(obj=="M"){
		var act=document.activeElement;
		if($(act).attr("ids")!=ids){
			var selObj=$("input[ids="+ids+"]:checked");
		if(selObj.length>0){
			$("#"+ids+"").attr("class","check_y");
		}else{
			$("#"+ids+"").attr("class","check_n");
		}
		}
	}
	if(obj=="B"||obj=="C"||obj=="E"||obj=="A"||obj=="Q"){
		var res=trim($this.val());
		if(res==""){
			$("#"+ids+"").attr("class","check_n");
		}else{
			$("#"+ids+"").attr("class","check_y");
		}
	}
}


/**
 * 倒计时
 */
  function GetRTime(){
	  var ed=$("#exam_date").text();
	  var st=$("#exam_time").text();
	  var et=$("#end_time").text();
	  ed=ed.replace(/-/g,"/");
	  var en=ed+" "+et
       var EndTime= new Date(en); 
       var NowTime = new Date();
       var t =EndTime.getTime() - NowTime.getTime();
	   
       var h=Math.floor(t/1000/60/60%24);
       var m=Math.floor(t/1000/60%60);
       var s=Math.floor(t/1000%60);
	   if(h<10){
		h="0"+h;  
	   }
	   if(m<10){
	   m="0"+m
	   }
	   if(s<10){
		s="0"+s;   
	   }

       document.getElementById("t_h").innerHTML = h + "时";
       document.getElementById("t_m").innerHTML = m + "分";
       document.getElementById("t_s").innerHTML = s + "秒";
       
       if(h=="00"&&m=="00"&&s=="00"){
    	 submitForm();
    	 $("#cover").css("display","block");
    	initWin();
       }
       
   }
   setInterval(GetRTime,1000);

   /**
    * 提示窗口倒计时
    */
   function leave(){
   var inter=6;
   function time(){
	   inter--;
	   $("#exit").html(""+inter+"");
	   if(inter==0){
	   window.opener=null; 
       window.open('', '_self', ''); 
       window.close();
	   }
   }
   setInterval("time()",1000);   
   }
   
   
































