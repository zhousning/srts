package com.srts.examination.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.examination.dao.QuestionBankManageDao;
import com.srts.examination.domain.QuestionBank;
import com.srts.knowledge.domain.BookChapter;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class QuestionBankManageDaoImpl extends BaseDaoImpl<QuestionBank> implements QuestionBankManageDao {

	public int deleteQuestionById(long id) {
		return getSession().createSQLQuery(
				"delete from exm_questionBank where exm_questionBank.id=:id").setLong("id",id).executeUpdate();
	}

	public List findAllQuestion() {
		String SQL="select * from exm_questionBank";
		return (List) getSession().createSQLQuery(SQL).list();
	}

	public QuestionBank findQuestionById(long id) {
		String HQL="from QuestionBank where id=:id";
		QuestionBank res=new QuestionBank();
		QuestionBank resTemp=new QuestionBank();
		resTemp=(QuestionBank)getSession().createQuery(HQL).setLong("id",id).uniqueResult();
		if(resTemp!=null)
		{
			res=resTemp;
		}
		else
		{
			BookChapter b=new BookChapter();
			b.setId(0);
			QuestionBank empty=new QuestionBank(((long)0), "无记录", "无记录", "无记录", "无记录",
					b, "无记录", "无记录",0);
			res=empty;
		}
		return res;
	}

	public List findQuestionByType(String type) {
		String SQL="select * from exm_questionBank where exm_questionBank.type=:type";
		return (List) getSession().createSQLQuery(SQL).setString("type",type).list();
	}

	public int insertQuestionBank(String type, String content, String answer,
			BookChapter bookChapter, String questionPic, String uploadTime, String lastUpdateTime,int selectOptions) {
		long bookChapter_id=bookChapter.getId();
		String sql="insert into exm_questionBank(type,content,answer,bookChapterId,questionPic,lastUpdateTime,uploadTime,selectOptions) values(?,?,?,?,?,?,?,?)";
		SQLQuery query= getSession().createSQLQuery(sql);
		query.setString(0,type);
		query.setString(1, content);
		query.setString(2, answer);
		query.setLong(3, bookChapter_id);
		query.setString(4, questionPic);
		query.setString(5, lastUpdateTime);
		query.setString(6, uploadTime);
		query.setInteger(7, selectOptions);
		int insertRes=query.executeUpdate();
		return insertRes;
	}

	public int updateQuestionContentById(long id, String content) {
		String SQL="update exm_questionBank set " +
		"exm_questionBank.content=:content where exm_questionBank.id=:id";
		return getSession().createSQLQuery(SQL).setString("content",content).setLong("id", id).executeUpdate();
	}
	
	public int updateLastUpdateTimeById(long id, String lastUpdateTime) {
		String SQL="update exm_questionBank set " +
		"exm_questionBank.lastUpdateTime='"+lastUpdateTime+"' where exm_questionBank.id=:id";
		return getSession().createSQLQuery(SQL).setLong("id", id).executeUpdate();
	}

	public int updateQuestionAnswerById(long id, String answer) {
		String SQL="update exm_questionBank set " +
		"exm_questionBank.answer=:answer where exm_questionBank.id=:id";
		return getSession().createSQLQuery(SQL).setString("answer",answer).setLong("id", id).executeUpdate();
	}

	public List findQuestionByKeyWords(String key) {
		String SQL="select * from exm_questionBank " +
		"where exm_questionBank.content like'%"+key+"%'";
        return (List) getSession().createSQLQuery(SQL).list();
	}

	public List findQuestionByTypeAndKeyWords(String type,
			String key) {
		String SQL="select * from exm_questionBank " +
		"where exm_questionBank.type=:type and exm_questionBank.content like'%"+key+"%'";
        return (List)getSession().createSQLQuery(SQL).setString("type", type).list();
	}
	
	public List<Integer> findUploadQuestionNumPerKind(String currentTime) {
		List<Integer> resList=new ArrayList<Integer>();
		String[] kind={"单选题","多选题","判断题","填空题","改错题","名词解释","简答题","问答题"};
		for(int i=0;i<8;i++)
		{
			String SQL="select count(*) from exm_questionBank "
				+"where exm_questionBank.type=:type and exm_questionBank.uploadTime like'%"+currentTime+"%'";
			int num=Integer.parseInt(String.valueOf(getSession().createSQLQuery(SQL).setString("type",kind[i]).list().get(0)));
			resList.add(num);			
		}
		return resList;
	}

	public List<Integer> findUploadQuestionNumPerMonth(String currentTime) {
		int tag=0;
		List<Integer> resList=new ArrayList<Integer>();
		String year=currentTime.split("-")[0];
		String month=currentTime.split("-")[1];
		String[] kind={"01","02","03","04","05","06","07","08","09","10","11","12"};
		for(int a=0;a<12;a++)
		{
			if(month.equals(kind[a]))
			{
				tag=a+1;
			}
		}
		for(int i=0;i<tag;i++)
		{
			String Time=year+"-"+kind[i];
			String SQL="select count(*) from exm_questionBank "
				+"where exm_questionBank.uploadTime like'%"+Time+"%'";
			int num=Integer.parseInt(String.valueOf(getSession().createSQLQuery(SQL).list().get(0)));
			resList.add(num);			
		}
		return resList;
	}

	public List<Integer> findQuestionNumByType() {
		List<Integer> resList=new ArrayList<Integer>();
		String[] kind={"单选题","多选题","判断题","填空题","改错题","名词解释","简答题","问答题"};
		for(int i=0;i<8;i++)
		{
			String SQL="select count(*) from exm_questionBank "
				+"where exm_questionBank.type=:type";
			int num=Integer.parseInt(String.valueOf(getSession().createSQLQuery(SQL).setString("type",kind[i]).list().get(0)));
			resList.add(num);			
		}
		return resList;
	}

	public List findTopFiveQuestionOrderByUploadTime() {
		String SQL="select top 5 * from exm_questionBank order by uploadTime desc";
		return (List) getSession().createSQLQuery(SQL).list();
	}

	public List findTopFiveQuestionOrderBylastUpdateTime() {
		String SQL="select top 5 * from exm_questionBank order by lastUpdateTime desc";
		return (List) getSession().createSQLQuery(SQL).list();
	}

	public List findAllQuestionUpdateTimeDesc() {
		String SQL="select * from exm_questionBank order by lastUpdateTime desc";
		return (List) getSession().createSQLQuery(SQL).list();
	}

	public List findAllQuestionUploadTimeDesc() {
		String SQL="select * from exm_questionBank order by uploadTime desc";
		return (List) getSession().createSQLQuery(SQL).list();
	}
	
	/**
	 * 插入一条试题到数据库wyw
	 * @param question
	 */
	public void saveQuestionsInfo(QuestionBank question){
		getSession().save(question);
	}
	
	/**
	 * 根据bookname和chapterNum获取书的章节
	 */
	public BookChapter getBookChapterId(String bookName,String chapterNum){
		String HQL = "from BookChapter bkc where bkc.id =(select bc.id  from BookChapter bc,Book bk " +
				"where bk.id = bc.book.id and " +
				"bk.bookName = :bookName and " +
				"bc.chapterNum = :chapterNum)";
		return (BookChapter) getSession().createQuery(HQL).setString("bookName", bookName).setString("chapterNum",chapterNum).uniqueResult();
	}

	public int updateQuestionSelectOptionsById(long id, int selectOptions) {
		String SQL="update exm_questionBank set " +
		"exm_questionBank.selectOptions=:selectOptions where exm_questionBank.id=:id";
		return getSession().createSQLQuery(SQL).setInteger("selectOptions", selectOptions).setLong("id", id).executeUpdate();
	}

	public int updateQuestionPicById(long id, String questionPic) {
		String SQL="update exm_questionBank set " +
		"exm_questionBank.questionPic=:questionPic where exm_questionBank.id=:id";
		return getSession().createSQLQuery(SQL).setString("questionPic", questionPic).setLong("id", id).executeUpdate();
	}

	public List findAllQuestionId() {
		String SQL="select id from exm_questionBank";
		return getSession().createSQLQuery(SQL).list();
	}
	
	public List<?> getByQuesIds(String questionIds,long testPaperId) {
		questionIds=questionIds.substring(0, questionIds.length()-1);
		String sql="select * from (select * from exm_questionBank WHERE id in ("+questionIds+"))a,(SELECT * FROM exm_questionScoreList where testPaperId="+testPaperId+")b WHERE a.type=b.type";
		System.out.println(sql);
		List<?> questionBanks=this.getSession().createSQLQuery(sql).list();

		return questionBanks;
	}

	public List<QuestionBank> findQuestionBank(String hql) {
		// TODO Auto-generated method stub
		return  this.getSession().createQuery(hql).list();
	}

	
	
}
