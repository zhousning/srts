package com.srts.learning.service;

import java.util.List;

import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.po.StudyBookInfoPo;
import com.srts.learning.po.StudyChapterInfoPo;
import com.srts.learning.po.StudyChapterStatusPo;

public interface StudyCourseService {
	//////////////////StudyCourseList
	public List<Book> getAllBooks();
	public List<StudyBookInfoPo> getMyStudyBookInfo(long userId);
	public List<StudyChapterInfoPo> getMyStudyChapterInfo(long userId,long bookId);
	public String getMyStudyCourseSchedule(long userId);
	public String getMyStudyCourseSumTime(long userId);
	public String getMyStudyCourseNumCount(long userId,String year);

	//////////////////StudyCourseDisp
	public List<StudyChapterStatusPo> getBookChapterSchedule(long userID, long bookID);
	
	public List<BookChapter> getBookChapters(long bookID);
	public List<BookChapterContent> getBookChapterContents(long chapterID);
	public List<BookChapterContent> getStudyBookOtherChapter(long bookID,long userID);
}
