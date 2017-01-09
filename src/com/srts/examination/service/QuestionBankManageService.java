package com.srts.examination.service;

import java.io.File;
import java.util.List;

import com.srts.examination.domain.QuestionBank;

public interface QuestionBankManageService {
	public String findUploadQuestionNumPerKind();
	public String findUploadQuestionNumPerMonth();
	public List<String[]> findQuestionByTypeAndKeyWords(String type,String key);//通过关键字查找相关问题
	public List<String[]> findQuestionByKeyWords(String key);//通过关键字查找相关问题
	public QuestionBank findQuestionById(long id);//通过题库id找问题
	public List<String[]> findAllQuestion();//找出全部问题
	public List<String[]> findQuestionByType(String type);//通过类别查找问题
	public int insertQuestionBank(String type, String content, String answer, String bookName, String chapterNum, String questionPic, String uploadTime, String lastUpdateTime, int selectOptions);//插入题库问题
	public int deleteQuestionById(long id);//删除题库问题
	public int updateQuestionContentById(long id,String content,int selectOptions);//更新题库问题内容
	public int updateQuestionAnswerById(long id,String answer);//更新题库问题答案
	public List<String[]> findQuestionNumByType();//分类统计题目数目
	public List<String[]> findTopFiveQuestionOrderByUploadTime();//查找上传时间最新的5条题目
	public List<String[]> findTopFiveQuestionOrderBylastUpdateTime();//查找更新时间最新的5条题目
	public List<String[]> findAllQuestionUpdateTimeDesc();
	public List<String[]> findAllQuestionUploadTimeDesc();
	public int updateQuestionPicById(long id,String questionPic);
	public String saveQuestionPic(File questionPicture, String updateQuestionPic);
    public void saveQuestionPicData(String s);
    public String saveQuestionBank(File uploadQuestionBank);
	/////////////////////////wyw
	public String saveQuestionInfo(String excelPath);
	
	
	public List<QuestionBank> findQuestionBank(String hql);
	public List<QuestionBank> findByIds(String content);
}
