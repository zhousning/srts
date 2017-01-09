package com.srts.learning.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.dao.ErrorSetDao;
import com.srts.learning.dao.OnlineExerciseDao;
import com.srts.learning.dao.impl.OnlineExerciseDaoImpl;
import com.srts.learning.po.ExerciseJudgeAnswerPo;
import com.srts.learning.service.OnlineExerciseService;
import com.srts.system.domain.Sys_User;

/**
 * 
 * @author H 2014-5-23 上午01:05:45
 * 
 */
@Service
public class OnlineExerciseServiceImpl implements OnlineExerciseService {
	@Resource
	private OnlineExerciseDao dao;
	@Resource
	private ErrorSetDao errorSetDao;

	// ----做练习前，展示信息----//

	// 获取最近n次历史准确率
	public String getRecentAccuracyRateN(Sys_User usr) {
		long userId = usr.getId();
		List<String[]> list = dao.getRecentAccuracyRate(userId);
		String acurString = "{\"chart\":{\"caption\":\"各次练习准确率/建议值\",\"numdivlines\":\"9\",\"linethickness\":\"2\",\"showvalues\":\"0\",\"anchorradius\":\"3\",\"anchorbgalpha\":\"50\",\"numvdivlines\":\"24\",\"showalternatevgridcolor\":\"1\",\"alternatevgridalpha\":\"3\",\"animation\":\"0\"},\"categories\":"
				+ "[{\"category\":[";
		for (int j = 1; j < list.size() + 1; j++) {
			if (j != list.size()) {
				acurString += "{\"label\":\"" + list.get(j - 1)[0] + "\"},";
			} else {
				acurString += "{\"label\":\"" + list.get(j - 1)[0] + "\"}]}]";
			}
		}
		acurString += ",\"dataset\":[";
		String acurString1 = "{\"seriesname\":\"练习准确率\",\"color\":\"800080\",\"anchorbordercolor\":\"800080\",\"data\":[";
		String acurString2 = "{\"seriesname\":\"准确率建议值\",\"color\":\"FF8040\",\"anchorbordercolor\":\"FF8040\",\"data\":[";
		for (int i = 1; i < list.size() + 1; i++) {
			if (i != list.size()) {
				acurString1 += "{\"value\":\"" + list.get(i - 1)[1] + "\"},";
				acurString2 += "{\"value\":\"" + String.valueOf(0.9) + "\"},";
			} else {
				acurString1 += "{\"value\":\"" + list.get(i - 1)[1]
						+ "\"}]},";
				acurString2 += "{\"value\":\"" + String.valueOf(0.9) + "\"}]}]}";
			}
		}
		acurString += acurString1 + acurString2;
		return acurString;
	}

	// 获取最近n次历史准确率稳定性
	public String getRecentAccuracyStabilityN(Sys_User usr) {
		long userId = usr.getId();
		List<String[]> list = dao.getRecentAccuracyStability(userId);
		String stabString = "{\"chart\":{\"caption\":\"各次练习准确率稳定性/建议值\",\"numdivlines\":\"9\",\"linethickness\":\"2\",\"showvalues\":\"0\",\"anchorradius\":\"3\",\"anchorbgalpha\":\"50\",\"numvdivlines\":\"24\",\"showalternatevgridcolor\":\"1\",\"alternatevgridalpha\":\"3\",\"animation\":\"0\"},\"categories\":"
				+ "[{\"category\":[";
		for (int j = 1; j < list.size() + 1; j++) {
			if (j != list.size()) {
				stabString += "{\"label\":\"" + list.get(j - 1)[0] + "\"},";
			} else {
				stabString += "{\"label\":\"" + list.get(j - 1)[0] + "\"}]}]";
			}
		}
		stabString += ",\"dataset\":[";
		String stabString1 = "{\"seriesname\":\"练习准确率稳定性\",\"color\":\"800080\",\"anchorbordercolor\":\"800080\",\"data\":[";
		String stabString2 = "{\"seriesname\":\"稳定性建议值\",\"color\":\"FF8040\",\"anchorbordercolor\":\"FF8040\",\"data\":[";
		for (int i = 1; i < list.size() + 1; i++) {
			if (i != list.size()) {
				stabString1 += "{\"value\":\"" + list.get(i - 1)[1] + "\"},";
				stabString2 += "{\"value\":\"" + String.valueOf(0.1) + "\"},";
			} else {
				stabString1 += "{\"value\":\"" + list.get(i - 1)[1] + "\"}]},";
				stabString2 += "{\"value\":\"" + String.valueOf(0.1)
						+ "\"}]}]}";
			}
		}
		stabString += stabString1 + stabString2;
		return stabString;
	}

	// ----做练习中，获取习题----//

//	// 随机n题
//	public List<QuestionBank> getRandomExercise(List<QuestionBank> list, int n) {
//		List<QuestionBank> Alist = new ArrayList<QuestionBank>();
//		for (int i = 0; i < n; i++) {
//			Random r = new Random();
//			int randomNum = r.nextInt(list.size() + 1);
//			Alist.add(list.get(randomNum));
//			list.remove(randomNum);
//		}
//		return Alist;
//	}

	// ----做完练习，传回数值----//

	// 系统判断一道题对错
	public int judgeAnswer(QuestionBank question,String answer) {
		String answerTrue = question.getAnswer();
		if (question.getContent().equals(answerTrue)==true)
			return 1;
		else if (answer.equals("未答")==true)
			return 0;
		else
			return -1;
	}

	// 计算本次练习准确率
	public float calAccuracyRate(int resultRight, int resultBlank, int resultWrong) {
		return (float)resultRight / (float)(resultRight + resultBlank + resultWrong);
	}

	// 计算本次练习准确率稳定性
	public float calAccuracyStability(Sys_User usr, float accuracyRate) {
		float sum=0, avg=1, stdDeviation=0;
		long userId=usr.getId();
		long n=dao.getCurrentExerciseSn(userId)+1;
		List<String[]> list=dao.getRecentAccuracyRate(userId);
		String[] temp={"",String.valueOf(accuracyRate)};
		list.add(temp);
		for(int i=0;i<n;i++){
			sum+=Float.parseFloat(String.valueOf(list.get(i)[1]));
		}
		avg=sum/n;
		if(avg==0)
		{
			avg=1;
		}
		sum=0;
		for(int i=0;i<n;i++){
			sum+=(Float.parseFloat(String.valueOf(list.get(i)[1]))-avg)*(Float.parseFloat(String.valueOf(list.get(i)[1]))-avg);
		}
		stdDeviation=(float) (Math.sqrt(sum/n))/avg;
		return stdDeviation;
	}

	//更新错题集表和在线练习表
	public boolean updateTable(Sys_User usr, List<ExerciseJudgeAnswerPo> list, String exerciseName) {
		int n=list.size();
		boolean updateRes=false;
		int res1=1;
		boolean res2=true;
		long userId=usr.getId();
		int resultRight=0, resultBlank=0, resultWrong=0;
		float accuracyRate=0, accuracyStability=0;
		long sn;
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
		for(int i=0;i<n;i++){
			if (list.get(i).getResultStatus()==-1) {
				resultWrong++;
				int temp=errorSetDao.insertErrorSet(usr, 2, newLastTestTime, list.get(i).getQuestionResult());
				if(temp==0)
				{
					res1=0;
				}
			}
			else if(list.get(i).getResultStatus()==0){
				resultBlank++;
				int temp=errorSetDao.insertErrorSet(usr, 2, newLastTestTime, list.get(i).getQuestionResult());
				if(temp==0)
				{
					res1=0;
				}
			}
			else if(list.get(i).getResultStatus()==1){
				resultRight++;
				int temp=errorSetDao.updateFdById(usr, list.get(i).getQuestionResult().getId());
				if(temp==0)
				{
					res1=0;
				}
			}
		}
		accuracyRate=calAccuracyRate(resultRight, resultBlank, resultWrong);
		accuracyStability=calAccuracyStability(usr, accuracyRate);
		sn=dao.getCurrentExerciseSn(userId);
		res2=dao.updateOnlineExercise(userId, resultRight, resultBlank, resultWrong, accuracyRate, accuracyStability, sn+1, newLastTestTime, exerciseName);
		if(res1==1&&res2==true)
		{
			updateRes=true;
		}
		return updateRes;
	}
	
	////////////////////////////////////////////////////////////////////////
	
	/**
	 * 获取所有的书
	 * @return
	 */
	public List<Book> getAllBooks(){
		return dao.getAllBooks();
	}
	
	/**
	 * 根据书的id获取所有章节
	 */
	public List<BookChapter> getBookChaptersByBookID(long bookID){
		return dao.getBookChaptersByBookID(bookID);
	}
	
	/**
	 * 根据练习总数，及章节id获取要练习的习题
	 * @param num
	 * @param chapterIDs
	 * @return
	 */
	public List<QuestionBank> getQuestionsByChpaterIdAndType(int num,String bookID,String chapterIDs){
		String[] chapters = chapterIDs.split("[,]");
		List<Long> ids = new ArrayList<Long>();
		List<Long> idsTrue = new ArrayList<Long>();
		for(String c:chapters){
			ids.add(Long.parseLong(c));
		}
		List<BookChapter> chaptList=new ArrayList<BookChapter>();
		chaptList=dao.getBookChaptersByBookID(Long.parseLong(bookID));
		for(int i=0;i<ids.size();i++)
		{
			long temp=chaptList.get(i).getId();
			idsTrue.add(temp);
		}
		List<QuestionBank> totalList = new ArrayList<QuestionBank>();
	    totalList=dao.getChapterQuestionsByChapterID(num, idsTrue);
		return totalList;
	}
	
	/**
	 * 处理员工在线练习的答案，并将员工的答案和正确的答案返回页面，并给出练习建议
	 * @param answerInfo
	 */
	public void getAnswerResult(String answerInfo){
		
	}

}
