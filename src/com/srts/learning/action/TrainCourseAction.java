package com.srts.learning.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.jfree.data.time.Hour;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.domain.MyTrainCourse;
import com.srts.learning.po.TrainCoursePo;
import com.srts.learning.service.TrainCourseService;
import com.srts.system.domain.Sys_User;

@Controller
@Scope("prototype")
public class TrainCourseAction extends BaseActionImpl<MyTrainCourse> {
	private static final long serialVersionUID = 1L;
	private MyTrainCourse myTrainCourse;
	private long userId;
	private long trainCourseId;
	private long itemID;
	private long myTrainCourseId;
	private String chapterID;// 传入chapterID
	
	private List<MyTrainCourse> myCurrentTrainCourses;
	private List<MyTrainCourse> myHistoryTrainCourses;
	private List<BookChapter> bookChapters;
	private List<BookChapterContent> bookChapterContents;

	private TrainCoursePo trainCoursePo;
	

	/**
	 * 获取当前进行中和历史课程列表
	 */
	public String trainCourseList() {
		// 查询当前要学习的课程列表
//		userId = 1;
		myCurrentTrainCourses = trainCourseService.getCurrentCourse(userId);
		// 查询已完成课程的课程列表
		myHistoryTrainCourses = trainCourseService.getHistoryCourse(userId);
		return "trainCourseList";
	}

	/**
	 * 分析学习时间、阅读次数等信息
	 */
	public String trainCourseAnalysis() {
//		userId = 1;
		if (trainCoursePo == null) {
			trainCoursePo = new TrainCoursePo();
		}
		String trainCourseSumTime = trainCourseService.getSumTime(userId);
		String hisCouReadTime = trainCourseService.getSumReadTime(userId);
		String avgCompMyStudyTime = trainCourseService
				.getAvgCompMyStuTime(userId);
		String comDegree = trainCourseService.getComDegree(userId);
		String trainStudyTime = trainCourseService.getTrainStudyTime(userId);

		trainCoursePo.setCurrentCourseSumTime(trainCourseSumTime);
		trainCoursePo.setHistoryCourseSumRead(hisCouReadTime);
		trainCoursePo.setMeanComMyStudyTime(avgCompMyStudyTime);
		trainCoursePo.setCurrentCourseComDeg(comDegree);
		trainCoursePo.setTrainStudyTime(trainStudyTime);
		return "trainCourseAnalysis";
	}

	/**
	 * 根据trainCourseId获取员工需要培训的课程内容
	 */
	// public void prepareTrainContentUi() {
	// myTrainCourse=trainCourseService.getByUsrIdAndTrainCouId(userId,trainCourseId);
	// System.out.println(myTrainCourse.getStartTime()+"........."+myTrainCourse.getId());
	//		
	// }

	public String trainContentUi() {
		// 获取员工培训章节
		bookChapters = trainCourseService.getBookChapter(trainCourseId);
		myTrainCourse = trainCourseService.getByUsrIdAndTrainCouId(userId,
				trainCourseId);
		// 更新此次学习的开始时间
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String dateString = dateFormat.format(date);

		trainCourseService.updateThisStartTime(userId, trainCourseId,
				dateString);
		// 记录培训开始时间
		long startMillseconds = date.getTime();
		ActionContext.getContext().getSession().put("startMillseconds",
				startMillseconds);
		return "trainCourseDisp";
	}

	/**
	 * 根据trainCourseId获取员工历史培训的课程内容
	 */
	public String histrainContentUi() {
		// 获取员工培训章节
//		trainCourseId = 1;
		bookChapters = trainCourseService.getAllChapters(trainCourseId);
		return "trainCourseDisp";
	}

	/**
	 * 根据chapterId获取该章节相应的内容
	 */
	public String trainCourseContent() {
		long chapterId = Long.parseLong(chapterID);
		bookChapterContents = trainCourseService
				.getAllChapterContents(chapterId);
		return "trainCourseContent";
	}
	
	public String ChapterItemContent(){
//		long itemId=Long.parseLong(itemID);
		bookChapterContents = trainCourseService.getAllChapterContents(itemID);
		return "chapterItemContent";
	}

	/**
	 * 本次学习结果
	 */
	public String finishCurrentCourse() {
		float schedule=trainCourseService.getSchedule(myTrainCourseId);
		
		Date date = new Date();

		long startMillSeconds = Long.parseLong((ActionContext.getContext()
				.getSession().get("startMillseconds")).toString());
		long endMillSeconds = date.getTime();
		long diff = endMillSeconds - startMillSeconds;
		long sumTime = diff / (1000 * 60);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String endTime = dateFormat.format(date);
		String lastStudyDate = dateFormat.format(date);

		trainCourseService.updateTrainResult(myTrainCourseId, schedule,endTime,
				lastStudyDate, sumTime);

		return "totrainCourseList";
	}
	
	/**
	 * 更新小节状态
	 */
	public void finishThisItem(){
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd ");
		String dateString=format.format(date);
		
		trainCourseService.updateThisItem(myTrainCourseId,itemID,dateString);
	}


	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public MyTrainCourse getMyTrainCourse() {
		return myTrainCourse;
	}

	public void setMyTrainCourse(MyTrainCourse myTrainCourse) {
		this.myTrainCourse = myTrainCourse;
	}

	public long getTrainCourseId() {
		return trainCourseId;
	}

	public void setTrainCourseId(long trainCourseId) {
		this.trainCourseId = trainCourseId;
	}

	public TrainCoursePo getTrainCoursePo() {
		return trainCoursePo;
	}

	public void setTrainCoursePo(TrainCoursePo trainCoursePo) {
		this.trainCoursePo = trainCoursePo;
	}

	public String getChapterID() {
		return chapterID;
	}

	public void setChapterID(String chapterID) {
		this.chapterID = chapterID;
	}

	@Resource(name = "trainCourseService")
	private TrainCourseService trainCourseService;

	public List<MyTrainCourse> getMyHistoryTrainCourses() {
		return myHistoryTrainCourses;
	}

	public void setMyHistoryTrainCourses(
			List<MyTrainCourse> myHistoryTrainCourses) {
		this.myHistoryTrainCourses = myHistoryTrainCourses;
	}

	public long getUserId() {
		return userId;
	}

	public List<BookChapter> getBookChapters() {
		return bookChapters;
	}

	public void setBookChapters(List<BookChapter> bookChapters) {
		this.bookChapters = bookChapters;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<MyTrainCourse> getMyCurrentTrainCourses() {
		return myCurrentTrainCourses;
	}

	public void setMyCurrentTrainCourses(
			List<MyTrainCourse> myCurrentTrainCourses) {
		this.myCurrentTrainCourses = myCurrentTrainCourses;
	}

	public void prepare() throws Exception {

	}

	public List<BookChapterContent> getBookChapterContents() {
		return bookChapterContents;
	}

	public void setBookChapterContents(
			List<BookChapterContent> bookChapterContents) {
		this.bookChapterContents = bookChapterContents;
	}
	
	public long getMyTrainCourseId() {
		return myTrainCourseId;
	}

	public void setMyTrainCourseId(long myTrainCourseId) {
		this.myTrainCourseId = myTrainCourseId;
	}

	public MyTrainCourse getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
