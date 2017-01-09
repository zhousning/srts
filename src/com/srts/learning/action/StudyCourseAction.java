package com.srts.learning.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.po.StudyBookInfoPo;
import com.srts.learning.po.StudyChapterInfoPo;
import com.srts.learning.po.StudyChapterStatusPo;
import com.srts.learning.po.StudyCoursePo;
import com.srts.learning.service.StudyCourseService;
import com.srts.system.domain.Sys_User;

@Controller
@Scope("prototype")
public class StudyCourseAction extends BaseActionImpl<Book>{
	private static final long serialVersionUID = 1L;
	@Resource
	private StudyCourseService service;
	
	private List<Book> bookList = new ArrayList<Book>();//返回所有书，用于显示
	/////////////
	private List<StudyBookInfoPo> studyBookList = new ArrayList<StudyBookInfoPo>();//返回自主学习书
	private List<StudyChapterInfoPo> chapterInfoPos = new ArrayList<StudyChapterInfoPo>();//返回自主学习书章节信息
	private StudyCoursePo studyCoursePo = new StudyCoursePo();//返回自主学习统计信息
    private String bookID = null;
    ///////////
    private List<BookChapter> bookChapters = new ArrayList<BookChapter>();//返回书的章节
    private List<StudyChapterStatusPo> chapterStatusPos = new ArrayList<StudyChapterStatusPo>();//返回书章节的学习进度
    private String chapterID;//传入chapterID
    private List<BookChapterContent> chapterContents = new ArrayList<BookChapterContent>();
    ///////////////////////////////////
	private Book book = new Book();
	public Book getModel(){
		return null;
	}
	public void prepare() throws Exception {
		
	}
	///////////////////////////////////////////////////////////
	////////////////////////////StudyCourseList
	public String studyCourseList(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		long userId = usr.getId();
		bookList = service.getAllBooks();//得到所有的书
		studyBookList = service.getMyStudyBookInfo(userId);//得到阅读的书
		return "studyCourseList";
	}
	public String studyChapterList(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		long userId = usr.getId();
		if(bookID!=null||!bookID.equals("")){
			long ID = Long.parseLong(bookID);
			chapterInfoPos = service.getMyStudyChapterInfo(userId,ID);//得到阅读的章节
		}
		return "studyChapterList";
	}
	public String studyCourseAnalysis(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		long userId = usr.getId();
		if(studyCoursePo==null){
			studyCoursePo = new StudyCoursePo();
		}
		String year = new Date().getYear()+1900+"";
		String studyCourseNumCount = service.getMyStudyCourseNumCount(userId, year);
		String studyCourseSumTime = service.getMyStudyCourseSumTime(userId);
		String studyCourseSchedule = service.getMyStudyCourseSchedule(userId);
		studyCoursePo.setStudyCourseNumCount(studyCourseNumCount);
		studyCoursePo.setStudyCourseSchedule(studyCourseSchedule);
		studyCoursePo.setStudyCourseSumTime(studyCourseSumTime);
		return "studyCourseAnalysis";
	}
	////////////////////////////StudyCourseDisp
	/**
	 * 根据bookID进入disp,进行学习
	 */
	public String studyCourseDisp(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		long userID = usr.getId();
		if(bookID!=null || !book.equals("")){
			long b_ID = Long.parseLong(bookID);
			bookChapters = service.getBookChapters(b_ID);
			chapterStatusPos = service.getBookChapterSchedule(userID, b_ID);
		}
		return "studyCourseDisp";
	}
	/**
	 * 根据chapterID选择章节内容
	 * @return
	 */
	public String studyChapterContent(){
		long chapterId = Long.parseLong(chapterID);
		chapterContents= service.getBookChapterContents(chapterId);
		return "studyChapterContent";
	}
	/**
	 * 在我的自主学习历史中，继续学习其他章节
	 * @return
	 */
	public String studyBookOtherChapter(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		long userID = usr.getId();
		if(bookID!=null || !book.equals("")){
			long b_ID = Long.parseLong(bookID);
			bookChapters = service.getBookChapters(b_ID);
			chapterStatusPos = service.getBookChapterSchedule(userID, b_ID);
			chapterContents = service.getStudyBookOtherChapter(b_ID,userID);
		}
		return "studyBookOtherChapter";
	}
	//////////////////////////////////////////////////////////
	public StudyCoursePo getStudyCoursePo() {
		return studyCoursePo;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public List<StudyChapterInfoPo> getChapterInfoPos() {
		return chapterInfoPos;
	}
	public List<StudyBookInfoPo> getStudyBookList() {
		return studyBookList;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public List<BookChapter> getBookChapters() {
		return bookChapters;
	}
	public List<StudyChapterStatusPo> getChapterStatusPos() {
		return chapterStatusPos;
	}
	public void setChapterID(String chapterID) {
		this.chapterID = chapterID;
	}
	public List<BookChapterContent> getChapterContents() {
		return chapterContents;
	}
	
}
