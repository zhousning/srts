package com.srts.examination.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.examination.dao.MockTestDao;
import com.srts.examination.domain.AnswerSheet;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.po.TestInfoPo;
import com.srts.examination.service.MockTestService;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.domain.Train;
import com.srts.system.domain.Sys_User;
@Service
public class MockTestServiceImpl implements MockTestService {
	@Resource
	private MockTestDao mockTestDao;

	public String dispCategoryUserTestScore(Sys_User usr) {
		String type="模拟";
		List<Integer> list = mockTestDao.categoryUserTestScore(usr, type);
		int tag=0;
		String []category={"<90","90~92","93~95","96~98","99~100"};
		String dispCategory="{ 'chart': { 'outCnvbaseFont':'Arial','outCnvbaseFontSize':'11','outCnvBaseFontColor':'#000000'," +
				"'bgColor':'#FFFFFF','bgalpha': '100','showBorder':'0','borderColor':'#000000'," +
				"'canvasbgColor':'#FFFFFF','canvasbgAlpha':'100','canvasBorderColor':'#000000','canvasBorderThickness':'1','canvasBorderAlpha':'100'," +
				"'showLabels':'1','labelDisplay':'Rotate','slantLabels':'1','showValues':'1','placeValuesInside':'0'," +
				"'numberprefix': '', 'baseFont':'Arial','baseFontSize':'10','baseFontColor':'000000','palette': '3', 'showLimits':'0'," +
				"'yAxisMinValue':'0','yAxisMaxValue':'100','divIntervalHints':'10','divLineIsDashed':'1','divlinecolor': '000000', 'vdivlineisdashed': '1'," +
				"'numvdivlines': '10', 'chartLeftMargin':'5','chartRightMargin':'5','chartTopMargin':'5','chartBottomMargin':'5','captionPadding':'5','xAxisNamePadding':'1','yAxisNamePadding':'1'," +
				"'canvasPadding':'30','numbersuffix': '%','linecolor': '006e6b', 'anchorradius': '4', 'anchorbgcolor': '009b83', 'anchorbordercolor': 'FFFFFF', 'anchorborderthickness': '2', " +
				"'animation': '1', 'pieslicedepth': '20', 'pieRadius':'80','startingangle': '180','showlegend':'1'}, 'data': [ ";
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer obj =  iterator.next();
			String countAmount = obj.toString();			
			String gradeType = category[tag];
			tag++;
			dispCategory+="{'label':'"+gradeType+"','value':'"+countAmount+"'},";
		}
		dispCategory+="],";
		dispCategory+="'styles': { 'definition': [ { 'name': 'LineShadow', 'type': 'shadow', 'color': '333333', 'distance': '9' } ],"+
			"'application': [ { 'toobject': 'DATAPLOT', 'styles': 'LineShadow' } ]"+
		"} }";
		return dispCategory;
	}

	public List<QuestionBank> findTestPaperQuestion(Train train, String major,String type) {
		List<QuestionBank> questionList=new ArrayList<QuestionBank>();
		TestPaper testPaper=mockTestDao.findTestPaperByTrainTypeMajor(train, major, type);
		if(testPaper!=null)
		{
		String content=testPaper.getContent();
		String []questionId=content.split(",");
		int size=questionId.length;
		for(int i=0;i<size;i++)
		{
			long id=Long.parseLong(questionId[i]);
			questionList.add(mockTestDao.findQuestionById(id));
		}
		}
		else
		{
			BookChapter b=new BookChapter();
			b.setId(0);
			QuestionBank q=new QuestionBank(((long)0), "无记录", "无记录", "无记录", "无记录",
					b, "无记录", "无记录", 0);
			questionList.add(q);
		}
		return questionList;
	}

	public String findUserTestScoreByUserAndType(Sys_User usr) {
		// TODO Auto-generated method stub
		String type="模拟";
		List list = mockTestDao.findUserTestScoreByUserAndType(usr, type);
		String userTestScoreList = "{ 'chart': { 'outCnvbaseFont':'Arial','outCnvbaseFontSize':'11'," +
				"'outCnvBaseFontColor':'#000000','bgColor':'#FFFFFF','bgalpha': '100','showBorder':'0'," +
				"'borderColor':'#000000','canvasbgColor':'#FFFFFF','canvasbgAlpha':'100','canvasBorderColor':'#000000'," +
				"'canvasBorderThickness':'1','canvasBorderAlpha':'100','showLabels':'1','labelDisplay':'Rotate','slantLabels':'1'," +
				"'showValues':'1','placeValuesInside':'0','numberprefix': '', 'baseFont':'Arial','baseFontSize':'10','baseFontColor':'#000000'," +
				"'palette': '2', 'showLimits':'0','yAxisMinValue':'0','yAxisMaxValue':'100','divIntervalHints':'10','divLineIsDashed':'1'," +
				"'chartLeftMargin':'5','chartRightMargin':'5','chartTopMargin':'5','chartBottomMargin':'5','captionPadding':'5','xAxisNamePadding':'1'," +
				"'yAxisNamePadding':'1','canvasPadding':'30'},"+ "'data':[";
		int i = 1;
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String score=objs[1].toString();
			String testName=objs[17].toString();
			userTestScoreList+="{'label':'"+testName+"','value':'"+score+"'},";
			i++;
			}
		userTestScoreList+="]}" ;
		return userTestScoreList;
	}

	public String findUserTestScoreRankByUserAndType(Sys_User usr) {
		// TODO Auto-generated method stub
		String type="模拟";
		List list = mockTestDao.findUserTestScoreByUserAndType(usr, type);
		String userTestScoreRankList = "{ 'chart': { 'outCnvbaseFont':'Arial','outCnvbaseFontSize':'11','outCnvBaseFontColor':'#000000'," +
		"'bgColor':'#FFFFFF','bgalpha': '100','showBorder':'0','borderColor':'#000000','canvasbgColor':'#FFFFFF'," +
		"'canvasbgAlpha':'100','canvasBorderColor':'#000000','canvasBorderThickness':'1','canvasBorderAlpha':'100'," +
		"'showLabels':'1','labelDisplay':'Rotate','slantLabels':'1','showValues':'1','placeValuesInside':'0','numberprefix': '', " +
		"'baseFont':'Arial','baseFontSize':'10','baseFontColor':'000000','palette': '2', 'showLimits':'0','yAxisMinValue':'0'," +
		"'yAxisMaxValue':'100','divIntervalHints':'10','divLineIsDashed':'1','divlinecolor': '000000', 'vdivlineisdashed': '1'," +
		"'numvdivlines': '10', 'chartLeftMargin':'5','chartRightMargin':'5','chartTopMargin':'5','chartBottomMargin':'5'," +
		"'captionPadding':'5','xAxisNamePadding':'1','yAxisNamePadding':'1','canvasPadding':'30','linecolor': '006e6b', 'anchorradius': '4', " +
		"'anchorbgcolor': '009b83', 'anchorbordercolor': 'FFFFFF', 'anchorborderthickness': '2'},'data': [ ";
		int i = 1;
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			long testPaperId=Long.valueOf(objs[4].toString());
			String testName=mockTestDao.findTestNameByTrainAndType("模拟", testPaperId);
			int rank=mockTestDao.findUserTestScoreRankByUserAndType(usr, type, testPaperId);
			String rankString=String.valueOf(rank);
			userTestScoreRankList+="{'label':'"+testName+"','value':'"+rankString+"'},";
			i++;
			}
		userTestScoreRankList+="],'styles': {" +
			"'definition': [ { 'name': 'LineShadow', 'type': 'shadow', 'color': '333333', 'distance': '9' } ],"+
			"'application': [ { 'toobject': 'DATAPLOT', 'styles': 'LineShadow' } ]"+
		"} }" ;
		return userTestScoreRankList;
	}

	public String findUserTestScoreStablilityByUserAndType(Sys_User usr) {
		// TODO Auto-generated method stub
		double ave=0;
		double s=0;//方差
		double sd=0;
		double cv=0;
		int i=1;
		String type="模拟";
		String userTestScoreStablilityList = "{ 'chart': { 'outCnvbaseFont':'Arial','outCnvbaseFontSize':'11','outCnvBaseFontColor':'#000000'," +
		"'bgColor':'#FFFFFF','bgalpha': '100','showBorder':'0','borderColor':'#000000','canvasbgColor':'#FFFFFF'," +
		"'canvasbgAlpha':'100','canvasBorderColor':'#000000','canvasBorderThickness':'1','canvasBorderAlpha':'100'," +
		"'showLabels':'1','labelDisplay':'Rotate','slantLabels':'1','showValues':'1','placeValuesInside':'0','numberprefix': '', " +
		"'baseFont':'Arial','baseFontSize':'10','baseFontColor':'000000','palette': '2', 'showLimits':'0','yAxisMinValue':'0'," +
		"'yAxisMaxValue':'100','divIntervalHints':'10','divLineIsDashed':'1','divlinecolor': '000000', 'vdivlineisdashed': '1'," +
		"'numvdivlines': '10', 'chartLeftMargin':'5','chartRightMargin':'5','chartTopMargin':'5','chartBottomMargin':'5'," +
		"'captionPadding':'5','xAxisNamePadding':'1','yAxisNamePadding':'1','canvasPadding':'30','linecolor': '006e6b', 'anchorradius': '4', " +
		"'anchorbgcolor': '009b83', 'anchorbordercolor': 'FFFFFF', 'anchorborderthickness': '2'},'data': [ ";
		List list = mockTestDao.findUserTestScoreByUserAndType(usr, type);
		List<Integer> gradeList=new ArrayList<Integer>();
		List<Double> cvList=new ArrayList<Double>();
		List<String> testNameList=new ArrayList<String>();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			long testPaperId=Long.valueOf(objs[4].toString());
			String testName=mockTestDao.findTestNameByTrainAndType("模拟", testPaperId);
			testNameList.add(testName);
			gradeList.add(Integer.valueOf(objs[1].toString()));
			}
		Iterator<Integer> iteratorGrade = gradeList.iterator();
		while(iteratorGrade.hasNext()){
			int grade = iteratorGrade.next();
			System.out.println(grade);
			double temp=ave;
			ave=ave+(grade-ave)/i;
			System.out.println(ave);
			s=s+(grade-temp)*(grade-ave);
			if(i==1)
			{
				sd=0;
				cv=0;
			}
			else
			{
				sd=Math.sqrt(s/(i-1));
				cv=sd/ave;
				System.out.println(sd);
				System.out.println(cv);
			}
			cvList.add(cv);
			i++;
		}
		Iterator<Double> iteratorCv = cvList.iterator();
		int j = 1;
		int a=0;
		while(iteratorCv.hasNext()){
			double cvn = iteratorCv.next();
			String cvString=Double.toString(cvn);
			String testNameGet=testNameList.get(a);
			userTestScoreStablilityList+="{'label':'"+testNameGet+"','value':'"+cvString+"'},";
			j++;
			a++;
			}
		userTestScoreStablilityList+="],'styles': { "+
			"'definition': [ { 'name': 'LineShadow', 'type': 'shadow', 'color': '333333', 'distance': '9' } ],"+
			"'application': [ { 'toobject': 'DATAPLOT', 'styles': 'LineShadow' } ]"+
		"} }";
		return userTestScoreStablilityList;
	}

	public int insertAnswerSheet(Sys_User usr, TestPaper testPaper,
			String answerContent) {
		// TODO Auto-generated method stub
		int res=mockTestDao.insertAnswerSheet(usr, testPaper, answerContent);
		return res;
	}
	public List<String[]> compareUserAnswerAndTestPaperAnswer(Sys_User usr,long testPaperId) {
		// TODO Auto-generated method stub
		List<String[]> resList=new ArrayList<String[]>();
		TestPaper testPaper=mockTestDao.findTestPaperById(testPaperId);
		AnswerSheet answerSheet=mockTestDao.findAnswerSheetByUserAndTestPaper(usr, testPaperId);
		if(testPaper!=null&&answerSheet!=null)
		{
		String answerSheetContent=answerSheet.getContent();
		String content=testPaper.getContent();
		String []questionId=content.split(",");
		String []answerSheetAnswer=answerSheetContent.split("&");
		int size=questionId.length;
		for(int i=0;i<size;i++)
		{
			long id=Long.parseLong(questionId[i]);
			String qid=String.valueOf(i+1);
			String type=mockTestDao.findQuestionById(id).getType();
			String qcontent=mockTestDao.findQuestionById(id).getContent();
			String qanswer=mockTestDao.findQuestionById(id).getAnswer();
			String uanswer=answerSheetAnswer[i];
			String []addItem={qid,type,qcontent,qanswer,uanswer};
			resList.add(addItem);
		}
		}
		else
		{
			String []empty={"0","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}
	public List<Long> findTestPaperIdByUser(Sys_User usr) {
		// TODO Auto-generated method stub
		List<Long> resList=new ArrayList<Long>();
		List list=mockTestDao.findTestPaperIdByUser(usr, "模拟");
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object objs = iterator.next();
			long testPaperId=Long.parseLong(objs.toString());
			resList.add(testPaperId);
			}
		}
		else
		{
			long empty=0;
			resList.add(empty);
		}
		return resList;
	}

	public TestInfoPo findUserAndTestInfo(Sys_User usr, long id) {
		TestInfoPo info = null;
		TestInfo testInfo=mockTestDao.findTestInfo(id);
		int num=mockTestDao.findTestTakenNumByUser(usr);
		if(testInfo!=null){
			String num1 = String.valueOf(num-1);
			String name = usr.getName();
			String num2 = String.valueOf(num);
			String date = testInfo.getTestDate()+" "+testInfo.getTestTime();
			String count = testInfo.getTestPeopleNum()+"";
			info = new TestInfoPo(num1,name,num2,date,count);
		}else{
			info = new TestInfoPo("无记录",usr.getName(),"无记录","无记录","无记录");
		}
		return info;
	}
}
