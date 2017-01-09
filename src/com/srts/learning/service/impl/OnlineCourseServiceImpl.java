package com.srts.learning.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.dao.OnlineCourseDao;
import com.srts.learning.po.StudyChapterStatusPo;
import com.srts.learning.service.OnlineCourseService;
import com.srts.system.domain.Sys_User;

@Service
public class OnlineCourseServiceImpl implements OnlineCourseService {
	@Resource 
	private OnlineCourseDao dao;
	
	/**
	 * 查找所有的书
	 * @return
	 */
	public List<Book> getAllBooks(){
		return dao.findAll();
	}
	/**
	 * 查找所有的视频
	 * @return
	 */
	public List<OnlineCourseVideo>getAllVideos(){
		return dao.getAllOnlineCourseVideo();
	}
	
	/**
	 * 查找所有的课件
	 * @return
	 */
	public List<OnlineCoursePPT>getAllPPTs(){
		return dao.getAllOnlineCoursePPT();
	}
	
	/**
	 * 根据bookID查找书的章节
	 * @param bookID
	 * @return
	 */
	public List<BookChapter> getBookChapterByID(long bookID){
		return dao.getBookChapters(bookID);
	}
	
	/**
	 * 根据pptID查找课件信息
	 * @param pptID
	 * @return
	 */
	public OnlineCoursePPT getPptByPptId(long pptID){
		return dao.getPptByPptId(pptID);
	}
	
	/**
	 * 根据videoID查找视频信息
	 * @param videoID
	 * @return
	 */
	public OnlineCourseVideo getVideoByID(long videoID){
		return dao.getVideoByID(videoID);
	}
	
	/**
	 * 根据chapterID查找章节内容
	 * @param chapterID
	 * @return
	 */
	public List<BookChapterContent> getChapterContentsByChapterID(long chapterID){
		return dao.getChapterContentsByChapterID(chapterID);
	}
	
	/**
	 * 获取推荐给用户的视频
	 * @param chapterID
	 * @return
	 */
	public List<OnlineCourseVideo> getRecommendVideo(){
		return dao.getTop6Video();
	}
	
	/**
	 * 得到员工课本学习每本书的学习进度
	 * @param bookId
	 * @param userId
	 * @return
	 */
	private int getBookScheduleById(long bookId,long userId){
		int schedule = 0;
		String bookSchedule = dao.getBookChapterCountById(bookId)+"";
		String studyBookSchedule = dao.getStudyBookChapterCountById(bookId, userId)+"";
		schedule = (int)((Float.parseFloat(studyBookSchedule)/Float.parseFloat(bookSchedule))*100);
		return schedule;
	}
	
	/**
	 * 获取当前课本学习的进度
	 * @param userID
	 * @param bookID
	 * @return
	 */
	public List<StudyChapterStatusPo> getBookChapterSchedule(long userID, long bookID){
		List<StudyChapterStatusPo> chapterStatusPos = new ArrayList<StudyChapterStatusPo>();//返回值
		
		List<BookChapter> bookAllChapters = dao.getBookChapters(bookID);//获取所有书的章节
		for(BookChapter chapter:bookAllChapters){
			long chapter_out_id = chapter.getId();
			String chapter_out_num = chapter.getChapterNum();
			String chapter_out_name = chapter.getChapterName();
			String chapter_out_status = "";
			StudyChapterStatusPo chapterStatusPo = new StudyChapterStatusPo();
			chapterStatusPo.setChapterID(chapter_out_id);
			chapterStatusPo.setChapterNum(chapter_out_num);
			chapterStatusPo.setChapterName(chapter_out_name);
			chapterStatusPo.setChapterStatus(chapter_out_status);
			chapterStatusPos.add(chapterStatusPo);
		}
		return chapterStatusPos;
	}
	public String insertIntoMyStudyCourse(long sumTime, Sys_User usr,
			 long trainId, long bookId) {
		String resString="fail";
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
		String lastStudyTime=year+"-"+month+"-"+date;
		String studyRecord=lastStudyTime+"|"+String.valueOf(sumTime);
		String studyContent=dao.getById(bookId).getBookName();
		int res=dao.insertIntoMyStudyCourse(sumTime, usr, studyRecord, studyContent,
				trainId, "2000-01-01", "2099-12-31", lastStudyTime, bookId);
		if(res==1)
		{
			resString="success";
		}
		return resString;
	}
	public int updateBookViewCount(long bookID) {
		int res=dao.updateBookViewCount(bookID);
		return res;
	}
	public int updateVideoViewCount(long videoID) {
		int res=dao.updateVideoViewCount(videoID);
		return res;
	}
	public long selectTrainIdByNoticeId(long noticeId) {
		long id=dao.selectTrainIdByNoticeId(noticeId);
		return id;
	}
}
