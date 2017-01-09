package com.srts.examination.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.examination.dao.CompetitionDao;
import com.srts.examination.dao.QuestionBankManageDao;
import com.srts.examination.domain.Competition;
import com.srts.examination.domain.QuestionBank;
import com.srts.examination.service.CompetitionService;
import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_User;
@Service
public class CompetitionServiceImpl implements CompetitionService {
	@Resource
	private CompetitionDao competitionDao;
	@Resource
	private QuestionBankManageDao questionBankManageDao;
	@Resource
	private Sys_UserDao sys_UserDao;

	public String dispCompetitionGradeByUser(Sys_User usr) {
		// TODO Auto-generated method stub
		List list = competitionDao.findCompetitionGradeByUser(usr);
		String competitionGradeList = "{'chart': {'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','divlinecolor': '91AF46','xaxisname': '闯关次数','yaxisname':'闯关成绩','caption': '闯关问答成绩变化情况','divlinealpha': '30','showvalues': '0','bgcolor': '009b83,FFFFFF','anchorradius': '5','anchorsides': '3','yaxismaxvalue': '30'}," +
		"'data':[";
		int i = 1;
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String grade=objs[1].toString();
			competitionGradeList+="{'value':'"+grade+"','label':'"+Integer.toString(i)+"'},";
			i++;
			}
		competitionGradeList+="]," +
		"'trendlines':[{'line':[" +
		"{'color': 'BC9F3F','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '闯关达人','endvalue': '120','startvalue': '90'}," +
		"{'color': '894D1B','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '闯关高手','endvalue': '90','startvalue': '60'}," +
		"{'color': '000111','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '闯关老手','endvalue': '60','startvalue': '40'}," +
		"{'color': 'f7ab00','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '闯关新手','endvalue': '40','startvalue': '0'},]}]}";
		return competitionGradeList;
	}

	public List<String[]> findCompetitionRankRightNow(String CurrentTime) {
		// TODO Auto-generated method stub
		int i=1;
		List<String[]> resList = new ArrayList<String[]>();
		List<Competition> list=competitionDao.findCompetitionRankRightNow(CurrentTime);
		if(list.isEmpty()==false)
		{
		Iterator iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			String username=sys_UserDao.getById(Long.valueOf(objs[1].toString())).getUsername();
			String []addItem = {String.valueOf(i),username,objs[0].toString()};
			resList.add(addItem);
			i++;
		}
		}
		else if(list.isEmpty()==true)
		{
			String []empty={"0","暂时无排名用户显示","暂时无用户排名显示"};
			resList.add(empty);
		}
		return resList;
	}

	public List<String[]> findHistoricalCompetitionRank() {
		// TODO Auto-generated method stub
		int i=1;
		List<String[]> resList = new ArrayList<String[]>();
		List list=competitionDao.findHistoricalCompetitionRank();
		if(list.isEmpty()==false)
		{
		Iterator iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			String username=sys_UserDao.getById(Long.valueOf(objs[1].toString())).getUsername();
			String []addItem = {String.valueOf(i),username,objs[0].toString()};
			resList.add(addItem);
			i++;
		}
		}
		else if(list.isEmpty()==true)
		{
			String []empty={"0","暂时无排名用户显示","暂时无用户排名显示"};
			resList.add(empty);
		}
		return resList;
	}

	public QuestionBank findQuestionRandomly() {
		// TODO Auto-generated method stub
		List list=questionBankManageDao.findAllQuestionId();
		int size=list.size();
		Random rand=new Random();
		long id=Long.parseLong(list.get(rand.nextInt(size)).toString());
		QuestionBank question=competitionDao.findQuestionById(id);
		return question;
	}

	public int judgeTheAnswer(QuestionBank question,String answer) {
		// TODO Auto-generated method stub
		String answerReal=question.getAnswer();
		int res=0;
		if(answerReal.equals(answer)==true)
		{
			res=1;
		}
		else
		{
			res=0;
		}
		return res;
	}

	public String findCompetitionRankRightNowByUser(Sys_User usr,
			String CurrentTime) {
		// TODO Auto-generated method stub
		int res=competitionDao.findCompetitionRankRightNowByUser(usr, CurrentTime);
		String resString=String.valueOf(res);
		return resString;
	}

	public String findHistoricalCompetitionRankByUser(Sys_User usr) {
		// TODO Auto-generated method stub
		int res=competitionDao.findHistoricalCompetitionRankByUser(usr);
		String resString=String.valueOf(res);
		return resString;
	}

	public List<String[]> findRecentFiveCompetitionError(Sys_User usr) {
		// TODO Auto-generated method stub
		int i=1;
		List<String[]> resList=new ArrayList<String[]>();
		List list=competitionDao.findRecentFiveCompetitionError(usr);
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String errorAnswer=objs[1].toString();
			String errorDate=objs[2].toString();
			long qid=Long.parseLong(objs[4].toString());
			QuestionBank question=questionBankManageDao.findQuestionById(qid);
			String id=String.valueOf(i);
			String type=question.getType();
			String content=question.getContent();
			String answer=question.getAnswer();
			i++;
			String []addItem={id,errorDate,type,content,answer,errorAnswer};
			resList.add(addItem);
			}
		}else if(list.isEmpty()==true)
		{
			String []empty={"无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
		}		

	public int insertCompetition(int grade, String comp_date, int comp_time,
			Sys_User usr) {
		// TODO Auto-generated method stub
		int res=competitionDao.insertCompetition(grade, comp_date, comp_time, usr);
		return res;
	}

	public int insertCompetitionError(String errorAnswer, String errorDate,
			Sys_User usr, QuestionBank errorQuestion) {
		// TODO Auto-generated method stub
		int res=competitionDao.insertCompetitionError(errorAnswer, errorDate, usr, errorQuestion);
		return res;
	}

	public String findCompetitionLastGradeByUser(Sys_User usr) {
		// TODO Auto-generated method stub
		int res=competitionDao.findCompetitionLastGradeByUser(usr);
		String resString=String.valueOf(res);
		return resString;
	}

	public String findCompetitionMaxGradeByUser(Sys_User usr) {
		// TODO Auto-generated method stub
		int res=competitionDao.findCompetitionMaxGradeByUser(usr);
		String resString=String.valueOf(res);
		return resString;
	}

	public QuestionBank findQuestionById(String id) {
		// TODO Auto-generated method stub
		QuestionBank question=competitionDao.findQuestionById(Long.parseLong(id));
		return question;
	}

}
