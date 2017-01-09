<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>问题交流</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/common/common.css">
	<link rel="stylesheet" type="text/css" href="resource/css/common/paginate.css" media="screen">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemComm.css">
	<link rel="stylesheet" type="text/css" href="resource/css/communication/problemCommList.css">
    <link rel="stylesheet" type="text/css" href="resource/css/communication/comm.css">
	
	<script type="text/javascript" src="resource/script/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="resource/js/communication/ProblemCommList.js"></script>
	<script type="text/javascript" src="resource/script/jquery/jquery.paginate.js"></script>
	<script type="text/javascript">
		$(function(){
			for(var i=1; i<=${size}; i++){
				$("#page").append("<option value="+i+">"+i+"</option>"); 
			}
			$("#page").val(${page}); //设置select的value为${page}的项选中 
			$("#page").change(function(){
				window.location="commu/ProblemCommuAction_queryByPage.action?page="+$("#page").val();
			});
		});
	</script>
</head>
<body>
<div class="mainDiv">
	<div class="problemSearchContainer">
		<!--<input class="problemSearchInput"  name="problemSearch"/>
		 <input type="button" value="搜索答案"/> 
        <img src="resource/image/communication/btn_search.png" />    <img src="resource/image/communication/btn_ask.png" /> -->
        <a href="commu/ProblemCommuAction_selfProblemCommAsk"></a>
		<a href="commu/ProblemCommuAction_selfProblemCommList">我的问题</a>
	</div>
	
	<div class="problemListTitle">
		<div class="problemListTitle_main">等待您来回答 </div>
	</div>
	
	<div class="problemListContainer">
		<div class="problemListCon_title">
		<!-- <ul class="problemListCon_title_ul">
			<li>最新发布</li>
			<li>浏览最多</li>
			<li>回复最多</li>
		</ul> -->
            <img src="resource/image/communication/tab_new.png" />
            <img src="resource/image/communication/tab_hot.png" />
            <img src="resource/image/communication/tab_ans.png" />
		</div>
		<div class="problemList_container">
			<ul class="problemList_container_ul">
			<s:iterator value="pageBean.list" status="stuts">
				<!--  判断记号是否为奇数  -->
    			<s:if test="#stuts.odd == true">
    				<li class="item1w">
					<div class="content"><a href="commu/ProblemCommuAction_problemCommDisp?problemId=${id}">${problemDesc}</a></div>
					<div class="info">
                        <div id="tab" class="time">标签：${labels}</div>
                        <div id="ans_time" class="time">${date }</div>
                        <div id="ans_num" class="highlight">${answerCount}</div>
                        <div class="text">回答</div>
                        <div id="ans_num" class="highlight">${viewCount }</div>
                        <div class="text">浏览</div>
                        <!-- <div><img src="resource/image/communication/btn_showquestion.png" /></div> -->
                    </div>
                    <div class="filling">&nbsp;</div>
				</li>
    			</s:if>
    			<s:else><!--  判断记号是否为偶数 -->
    				<li class="item2w">
					<div class="content"><a href="commu/ProblemCommuAction_problemCommDisp?problemId=${id}">${problemDesc}</a></div>
					<div class="info">
                        <div id="tab" class="time">标签：${labels}</div>
                        <div id="ans_time" class="time">${date }</div>
                        <div id="ans_num" class="highlight">${answerCount}</div>
                        <div class="text">回答</div>
                        <div id="ans_num" class="highlight">${viewCount }</div>
                        <div class="text">浏览</div>
                        <!-- <div><img src="resource/image/communication/btn_showquestion.png" /></div> -->
                    </div>
                    <div class="filling">&nbsp;</div>
				</li>
    			</s:else>
				
				
			</s:iterator>
			</ul>
			</div>
	<!-- <div class="problemList_page">
				<ul class="problemList_page_ul">
					<li class="page">«</li>
					<li class="page">1</li>
					<li class="page">2</li>
					<li class="page">3</li>
					<li class="page">4</li>
					<li class="page">5</li>
					<li class="page">6</li>
					<li class="page">»</li>
					<li class="total">共6页</li>
				</ul>
			</div>   -->
			<div class="problemList_page">
				<div align="center">共
		<s:property value="pageBean.allRow" />
		条 共
		<s:property value="pageBean.totalPage" />
		页 第
		<s:property value="pageBean.currentPage" />
		页
		<s:if test="%{pageBean.currentPage == 1}">上一页</s:if>
		<s:else>
			<a
				href="commu/ProblemCommuAction_queryByPage.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页</a>
		</s:else>
		<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
			<a
				href="commu/ProblemCommuAction_queryByPage.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
		</s:if>
		<s:else>下一页 </s:else>
		跳转到第
		<select name="" id="page">
		</select>
		页</div>
			</div> 
		</div>
		<!-- 右边排行榜 -->
        <div class="panel_rank">
		<!-- <div class="problemAnalisisContainer"> -->
			<!-- <div class="problemAnalisis1">
				<div class="problemAnalisis_title">问题达人</div>
				<ul class="problemAnalisis_ul">
					<li>(1)XXX 上周问题XX</li>
					<li>(2)XXX 上周问题XX</li>
					<li>(3)XXX 上周问题XX</li>
					<li>(4)XXX 上周问题XX</li>
					<li>(5)XXX 上周问题XX</li>
				</ul>
			</div> -->
            <!-- rank1问题达人 -->
            <div id="rankpanel1" class="panel_rank_sub">
                <div id="pic1"><img src="resource/image/communication/title_rank1.png" /></div>
                <s:iterator value="most5ProblemUsers" status="st">
	            	<s:if test="#st.count==1">
	            		<div class="rank1">
                    		<div class="rank_sn">1</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
                		</div>
                	</s:if><s:elseif test="#st.count==2">
		                <div class="rank2">
		                    <div class="rank_sn">2</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
		          	</s:elseif><s:elseif test="#st.count==3">
		                <div class="rank3">
		                    <div class="rank_sn">3</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
		          	</s:elseif><s:elseif test="#st.count==4">
		                <div class="rank4">
		                    <div class="rank_sn">4</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
		            </s:elseif><s:elseif test="#st.count==5">
		                <div class="rank4">
		                    <div class="rank_sn">5</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
	                </s:elseif>
	        	</s:iterator>
                
            </div>
            <!-- 问题达人排行榜结束 -->
            <!-- rank2回复达人 -->
            <div id="rankpanel2" class="panel_rank_sub">
                <div id="pic1"><img src="resource/image/communication/title_rank2.png" /></div>
                
                 <s:iterator value="most5AnswerUsers" status="st">
	            	<s:if test="#st.count==1">
	            		<div class="rank1">
                    		<div class="rank_sn">1</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
                		</div>
                	</s:if><s:elseif test="#st.count==2">
		                <div class="rank2">
		                    <div class="rank_sn">2</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
		          	</s:elseif><s:elseif test="#st.count==3">
		                <div class="rank3">
		                    <div class="rank_sn">3</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
		          	</s:elseif><s:elseif test="#st.count==4">
		                <div class="rank4">
		                    <div class="rank_sn">4</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
		            </s:elseif><s:elseif test="#st.count==5">
		                <div class="rank4">
		                    <div class="rank_sn">5</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
	                </s:elseif>
	        	</s:iterator>
                
               
            </div>
            <!-- 回复达人排行榜结束 -->
            <!-- rank3采纳排行 -->
            <div id="rankpanel3" class="panel_rank_sub">
                <div id="pic1"><img src="resource/image/communication/title_rank3.png" /></div>
               <s:iterator value="most5AcceptUsers" status="st">
	            	<s:if test="#st.count==1">
	            		<div class="rank1">
                    		<div class="rank_sn">1</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
                		</div>
                	</s:if><s:elseif test="#st.count==2">
		                <div class="rank2">
		                    <div class="rank_sn">2</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
		          	</s:elseif><s:elseif test="#st.count==3">
		                <div class="rank3">
		                    <div class="rank_sn">3</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
		          	</s:elseif><s:elseif test="#st.count==4">
		                <div class="rank4">
		                    <div class="rank_sn">4</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
		            </s:elseif><s:elseif test="#st.count==5">
		                <div class="rank4">
		                    <div class="rank_sn">5</div><div class="rank_name">${userName}</div><div class="rank_text"></div><div class="rank_num">${num }</div>
		                </div>
	                </s:elseif>
	        	</s:iterator>
            </div>
            <!-- 采纳排行榜结束 -->
        <div class="filling">&nbsp;</div>
		</div>
        <!-- 右边排行榜结束 -->
    

</div>
</body>
</html>
