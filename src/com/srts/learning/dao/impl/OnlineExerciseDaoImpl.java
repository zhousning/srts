package com.srts.learning.dao.impl;
/**
 * 
 * @author H 2014-5-22 下午09:03:55
 *
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.learning.dao.OnlineExerciseDao;
import com.srts.learning.po.ExerciseJudgeAnswerPo;
import com.srts.learning.po.ExerciseQuestionPo;
import com.srts.learning.po.ExerciseResultSumPo;
import com.srts.learning.po.ExerciseSelectByNamePo;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class OnlineExerciseDaoImpl extends BaseDaoImpl<QuestionBank> implements OnlineExerciseDao{
	
	//----做练习前，展示信息----//
	
	//获取最近n次历史准确率
	
	public List<String[]> getRecentAccuracyRate(long userId) {
		List<String[]> resList=new ArrayList<String[]>();
		List list=(List) getSession().createSQLQuery(
				"select exerciseName,accuracyRate from lrn_onlineExercise where userId=? order by exerciseDate desc")
		.setParameter(0, userId).list();
		if(list.isEmpty()==false)
		{
		Iterator iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs=(Object[])iterator.next();
			String exerciseName=objs[0].toString();
			String recentAccuracyRate=objs[1].toString();
			String[] addItem={exerciseName,recentAccuracyRate};
			resList.add(addItem);
		}
		}
		else
		{
			String exerciseName="无记录";
			String recentAccuracyRate="0";
			String[] addItem={exerciseName,recentAccuracyRate};
			resList.add(addItem);
		}
		return resList;
	}
	//获取最近n次历史准确率稳定性
	public List<String[]> getRecentAccuracyStability(long userId) {
		List<String[]> resList=new ArrayList<String[]>();
		List list=(List) getSession().createSQLQuery(
				"select exerciseName,accuracyStability from lrn_onlineExercise where userId=? order by exerciseDate desc")
		.setParameter(0, userId).list();
		if(list.isEmpty()==false)
		{
		Iterator iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs=(Object[])iterator.next();
			String exerciseName=objs[0].toString();
			String accuracyStability=objs[1].toString();
			String[] addItem={exerciseName,accuracyStability};
			resList.add(addItem);
		}
		}
		else
		{
			String exerciseName="无记录";
			String accuracyStability="0";
			String[] addItem={exerciseName,accuracyStability};
			resList.add(addItem);
		}
		return resList;
	}
	//获取总答对-未答-答错次数
	public ExerciseResultSumPo getResultSum(long userId) {
		List list=getSession().createSQLQuery(
				"select sum(resultRight) as a, sum(resultBlank) as b, sum(resultWrong) as c from lrn_onlineExercise where userId=?")
		.setParameter(0, userId).list();
		Iterator iterator=list.iterator();
		ExerciseResultSumPo res=new ExerciseResultSumPo();
		while(iterator.hasNext())
		{
			Object[] objs=(Object[])iterator.next();
			String resultRight=objs[0].toString();
			String resultBlank=objs[1].toString();
			String resultWrong=objs[2].toString();
			res.setResultBlank(resultBlank);
			res.setResultRight(resultRight);
			res.setResultWrong(resultWrong);
		}
		return res;
	}
	
	
	//----做练习中，获取习题----//
	
	//1.章节：获取所有书+章节名
	public List<ExerciseSelectByNamePo> getAllChapter(){
		List<ExerciseSelectByNamePo> resList=new ArrayList<ExerciseSelectByNamePo>();
		List list = getSession().createSQLQuery(
				"select klg_book.id as a,klg_book.bookName,klg_bookChapter.id as b,klg_bookChapter.chapterNum,klg_bookChapter.chapterName" +
				" from klg_book,klg_bookChapter where klg_bookChapter.bookId = klg_book.id").list();
		if(list.isEmpty()==false)
		{
		Iterator iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs=(Object[])iterator.next();
			String bookId=objs[0].toString();
			String bookName=objs[1].toString();
			String chapterId=objs[2].toString();
			String chapterName=objs[4].toString();
			String chapterNum=objs[3].toString();
			ExerciseSelectByNamePo addItem=new ExerciseSelectByNamePo();
			addItem.setBookId(bookId);
			addItem.setBookName(bookName);
			addItem.setChapterId(chapterId);
			addItem.setChapterName(chapterName);
			addItem.setChapterNum(chapterNum);
			resList.add(addItem);
		}
		}
		else
		{
			String bookId="0";
			String bookName="无记录";
			String chapterId="0";
			String chapterName="无记录";
			String chapterNum="0";
			ExerciseSelectByNamePo addItem=new ExerciseSelectByNamePo();
			addItem.setBookId(bookId);
			addItem.setBookName(bookName);
			addItem.setChapterId(chapterId);
			addItem.setChapterName(chapterName);
			addItem.setChapterNum(chapterNum);
			resList.add(addItem);
		}
		return resList;
	}
	//1.章节：根据书+章节名获取对应习题
	public List<QuestionBank> getQuestionByChapter(ExerciseSelectByNamePo esbnPo){
		return (List<QuestionBank>) getSession().createQuery(
				"from QuestionBank where bookChapterId=:id").setLong("id", Long.parseLong(esbnPo.getChapterId())).list();
	}
	//2.随机：获取所有习题
	public List<QuestionBank> getAllQuestion() {
		return (List<QuestionBank>) getSession().createQuery(
		"from QuestionBank").list();
	}
	
	
	//----做完练习，传回数值----//
	
//	//对给定一道题找正确答案
//	public String getAnswer(QuestionBank question) {
//		return (String) getSession().createSQLQuery(
//				"select answer from exm_questionBank where id=?").setParameter(0, question.getId()).uniqueResult();
//	}
	//确定当前练习Sn（不算此次）
	public long getCurrentExerciseSn(long userId){
		long res=0;
		Object obj=getSession().createSQLQuery(
				"select max(exerciseSn) " +
		"from lrn_onlineExercise where userId=?")
		.setParameter(0, userId).uniqueResult();
		if(obj==null)
		{
			
		}
		else
		{
			res=Long.parseLong(String.valueOf(getSession().createSQLQuery("select max(exerciseSn) " +
			"from lrn_onlineExercise where userId=?")
			.setParameter(0, userId).uniqueResult()));
		}
		return res;
				
	}
	//更新在线练习lrn_onlineExercise表
	public boolean updateOnlineExercise(
			long userId, int resultRight, int resultBlank, int resultWrong, 
			float accuracyRate, float accuracyStability, long sn, String exerciseDate, String exerciseName) {
		String sql="insert into lrn_onlineExercise(exerciseSn,resultRight,resultBlank,resultWrong,accuracyRate,accuracyStability,userId,exerciseDate,exerciseName)" +
		"values(?,?,?,?,?,?,?,?,?)";
		SQLQuery query= getSession().createSQLQuery(sql);
		query.setLong(0, sn);
		query.setInteger(1, resultRight);
		query.setInteger(2, resultBlank);
		query.setInteger(3, resultWrong);
		query.setFloat(4, accuracyRate);
		query.setFloat(5, accuracyStability);
		query.setLong(6, userId);
		query.setString(7, exerciseDate);
		query.setString(8, exerciseName);
		int insertRes=query.executeUpdate();
		boolean res=false;
		if(insertRes==1)
		{
			res=true;
		}
		return res;
	}
	//正确时，更新错题集lrn_errorSet表
	public boolean updateErrorSetRight(ExerciseJudgeAnswerPo ejaPo){
		return false;
	}
	//错误时，更新错题集lrn_errorSet表
	public boolean updateErrorSetWrong(ExerciseJudgeAnswerPo ejaPo){
		return false;
	}
	////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 获取所有的书
	 */
	public List<Book> getAllBooks(){
		String HQL = "from Book";
		return getSession().createQuery(HQL).list();
	}
	
	/**
	 * 根据bookID获取书的章节
	 */
	public List<BookChapter> getBookChaptersByBookID(long bookID){
		String HQL = "from BookChapter where book.id = :bookID";
		return getSession().createQuery(HQL).setLong("bookID", bookID).list();
	}
	
	/**
	 * 根据chapterIDs及试题类型获取要选的试题，并设置选择的试题数目
	 */
	public List<QuestionBank> getChapterQuestionsByChapterID(int num, List<Long> chapterIDs){
		List<QuestionBank> resList=new ArrayList<QuestionBank>();
		String HQL = "from QuestionBank where bookChapter.id in(:chapterIDs) order by id";
		List<QuestionBank> list = getSession().createQuery(HQL).setParameterList("chapterIDs", chapterIDs).list();
		if(list.size()<num)
		{
			resList=list;
		}
		else
		{
			for(int i=0;i<num;i++)
			{
				int raNum=(int)(Math.random()*list.size());
				resList.add(list.get(raNum));
				list.remove(raNum);
			}
		}
		return resList;
	}
}
