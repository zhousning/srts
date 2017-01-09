package com.srts.learning.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.Book;
import com.srts.learning.dao.ErrorSetDao;
import com.srts.learning.dao.ErrorSetFlagSumDao;
import com.srts.learning.domain.ErrorSet;
import com.srts.learning.domain.ErrorSetFlagSum;
import com.srts.learning.po.ErrorSetAnswerPo;
import com.srts.learning.service.ErrorSetService;
import com.srts.system.domain.Sys_User;

@Service
public class ErrorSetServiceImpl implements ErrorSetService {
	@Resource
	private ErrorSetDao errorSetDao;
	@Resource
	private ErrorSetFlagSumDao errorSetFlagSumDao;

	public List<String[]> findByErrorSetFlagUsrId(Sys_User usr, int flag) {
		List list = errorSetDao.findByErrorSetFlagUsrId(usr, flag);
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[4].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String []empty={"无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public List<String[]> findByLastTestTimeUsrId(Sys_User usr,
			String lastTestTime) {
		List list = errorSetDao.findByLastTestTimeUsrId(usr, lastTestTime);
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[4].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String []empty={"无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public List<String[]> findByErrorSetTypeUsrId(Sys_User usr, String type) {
		List list = errorSetDao.findByErrorSetTypeUsrId(usr, type);
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[4].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String []empty={"无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public String getCountByErrorSetFlagUsrId(Sys_User usr) {
		List<Integer> list = new ArrayList<Integer>();
		int tag=0;
		String []category={"掌握较好","基本掌握","掌握较差","完全不会"};
		int []count=new int[3];
		for(int i=0;i<3;i++)
		{
			int temp=errorSetDao.countByErrorSetFlagUsrId(i, usr);
			count[i]=temp;
			list.add(temp);
		}
		int sum=errorSetDao.countAllErrorSetByUsrId(usr);
		list.add(sum-count[0]-count[1]-count[2]);
		//'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50',
		String countByFlag="{'chart': {'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','caption': '错题掌握情况百分比','formatnumberscale': '1','startingangle': '125','pieslicedepth': '30','numberprefix': '','decimals': '0', 'animation': '1','palette': '1'},"+"'data': [";
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer obj =  iterator.next();
			String countAmount = obj.toString();			
			String errorSetType = category[tag];
			tag++;
			countByFlag+="{'label':'"+errorSetType+"','value':'"+countAmount+"'},";
		}
		countByFlag+="]}";
		return countByFlag;
	}

	public String getFindErrorSetFlagSumById(Sys_User usr) {
		List<ErrorSetFlagSum> list = errorSetFlagSumDao.findErrorSetFlagSumById(usr);
		String flagCount = "{'chart': {'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','divlinecolor': '91AF46','xaxisname': '月份','yaxisname':'掌握情况','caption': '月错题回顾统计变化趋势','divlinealpha': '30','showvalues': '0','bgcolor': '009b83,FFFFFF','anchorradius': '5','anchorsides': '3','yaxismaxvalue': '30'}," +
		"'data':[";
		int i = 1;
		for(ErrorSetFlagSum errorSetflagSum:list){
			String flagSum = Integer.toString(errorSetflagSum.getFlagSum());
			flagCount+="{'value':'"+flagSum+"','label':'"+Integer.toString(i)+"'},";
			i++;
		}	
		Iterator<ErrorSetFlagSum> iterator = list.iterator();
		flagCount+="]," +
		"'trendlines':[{'line':[" +
		"{'color': 'BC9F3F','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '完全不会','endvalue': '50','startvalue': '30'}," +
		"{'color': '894D1B','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '掌握较差','endvalue': '30','startvalue': '20'}," +
		"{'color': '000111','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '基本掌握','endvalue': '20','startvalue': '10'}," +
		"{'color': 'f7ab00','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '掌握良好','endvalue': '10','startvalue': '0'},]}]}";
		return flagCount;
    }

	public String getCountByErrorSetTypeUsrId(Sys_User usr) {
		List<Integer> list =  new ArrayList<Integer>();
		String []type={"单选题","多选题","判断题","填空题","改错题","名词解释","简答题"};
		int tag=0;
		list.add(errorSetDao.countByErrorSetTypeUsrId("单选题", usr));
		list.add(errorSetDao.countByErrorSetTypeUsrId("多选题", usr));
		list.add(errorSetDao.countByErrorSetTypeUsrId("判断题", usr));
		list.add(errorSetDao.countByErrorSetTypeUsrId("填空题", usr));
		list.add(errorSetDao.countByErrorSetTypeUsrId("改错题", usr));
		list.add(errorSetDao.countByErrorSetTypeUsrId("名词解释", usr));
		list.add(errorSetDao.countByErrorSetTypeUsrId("简答题", usr));
		String questionCountByType = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'当前各类型错题数目累计','xAxisName':'错题类型','yAxisName':'错题个数','numberPrefix':'题目个数'},'data':[";
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer obj =  iterator.next();
			String countAmount = obj.toString();			
			String questionType = type[tag];
			tag++;
			questionCountByType+="{'label':'"+questionType+"','value':'"+countAmount+"'},";
		}
		questionCountByType+="]}";
		return questionCountByType;
	}

	public String judgeTheAnswer(Sys_User usr,ErrorSetAnswerPo errorSetAnswerPo) {
		String res = null;
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(date.length()==1)
		{
			date="0"+date;
		}
		String newLastTestTime=year+"-"+month+"-"+date;
		String answerfind=errorSetDao.findAnswerByQuestionId(Integer.parseInt(errorSetAnswerPo.getErrorSetQuestionId()));
		String []answermodified=answerfind.split("\\s");
		answerfind=answermodified[0];
		String questionType=errorSetDao.findQuestionTypeByQuestionId(Integer.parseInt(errorSetAnswerPo.getErrorSetQuestionId()));

		if(questionType.equals("单选题")==true||questionType.equals("多选题")==true||questionType.equals("判断题")==true)
		{
			if(answerfind.equals(errorSetAnswerPo.getErrorSetQuestionAnswer())==true)
			{
				long errorSetId=errorSetDao.findErrorSetIdByQuestionIdAndUsrId(usr,Integer.parseInt(errorSetAnswerPo.getErrorSetQuestionId()));
				errorSetDao.updateFdById(usr,errorSetId);
				errorSetDao.updateLastTestTimeById(usr, errorSetId, newLastTestTime);
				int flagdelete=errorSetDao.findFlagByErrorSetId(errorSetId);
				if(flagdelete<0)
				{
					errorSetDao.deleteById(usr, errorSetId);
				}
				res="right";
			}
			else if(answerfind.equals(errorSetAnswerPo.getErrorSetQuestionAnswer())==false)
			{
				long errorSetId=errorSetDao.findErrorSetIdByQuestionIdAndUsrId(usr,Integer.parseInt(errorSetAnswerPo.getErrorSetQuestionId()));
				errorSetDao.updateFiById(usr,errorSetId);
				errorSetDao.updateLastTestTimeById(usr, errorSetId, newLastTestTime);
				res="wrong";
			}	
		}
		else if(questionType.equals("填空题")||questionType.equals("名词解释")||questionType.equals("简答题")||questionType.equals("改错题"))
		{
		if(errorSetAnswerPo.getErrorSetQuestionAnswer().equals(answerfind)==true)
		{
			long errorSetId=errorSetDao.findErrorSetIdByQuestionIdAndUsrId(usr,Integer.parseInt(errorSetAnswerPo.getErrorSetQuestionId()));
			errorSetDao.updateFdById(usr,errorSetId);
			errorSetDao.updateLastTestTimeById(usr, errorSetId, newLastTestTime);
			int flagdelete=errorSetDao.findFlagByErrorSetId(errorSetId);
			if(flagdelete<0)
			{
				errorSetDao.deleteById(usr, errorSetId);
			}
			res="right";
		}
		else if(errorSetAnswerPo.getErrorSetQuestionAnswer().equals(answerfind)==false)
		{
			long errorSetId=errorSetDao.findErrorSetIdByQuestionIdAndUsrId(usr,Integer.parseInt(errorSetAnswerPo.getErrorSetQuestionId()));
			errorSetDao.updateFiById(usr,errorSetId);
			errorSetDao.updateLastTestTimeById(usr, errorSetId, newLastTestTime);
			res="wrong";
		}
		}
		return res;
	}

	public List<String[]> findErrorSetSimpilfiedDisplayedById(Sys_User usr) {
		List list = errorSetDao.findTopFlagFiveErrorSetById(usr);
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[4].toString(),objs[6].toString(),objs[7].toString(),objs[1].toString(),objs[2].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String []empty={"无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public String insertIntoErrorSet(Sys_User usr, int flag,
			String lastTestTime, QuestionBank question) {
		String resString=String.valueOf(errorSetDao.insertErrorSet(usr, flag, lastTestTime, question));
		return resString;
	}

}
