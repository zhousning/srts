package com.srts.learning.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;

public interface StudyCourseDao extends BaseDao<Book>{	
	//////////////////////StudyCourseList
	public Integer getBookChapterCountById(long bookId);
	public Integer getStudyBookChapterCountById(long bookId,long userId);
	public List getMyStudyCourseBookInfo(long userId);
	public List getMyStudyCourseChapterInfo(long userId,long bookId);
	
	public List getBookChapterCount();
	public List getStudyBookChapterCount(long userId);
	public List getStudyTotalTime(long userId);
	public Integer getStudyCourseNumCount(long userId,String month);
	
	//////////////////////StudyCourseDisp
	public List getBookChapterStatusByFinishOrUndone(long userId,long bookId,String status);
	public List getBookChapterStatusNotByFinishOrUndone(long userId,long bookId);
	public List<BookChapter> getBookChapters(long bookID);
	public List<BookChapterContent> getBookChapterContents(long chapterID);
	public List<BookChapterContent> getStudyBookOtherChapter(long bookID,long userID);
	public List<BookChapterContent> getStudyBookOtherChapterUndo(long bookID,long userID);
}
