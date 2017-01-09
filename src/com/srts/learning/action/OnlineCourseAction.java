package com.srts.learning.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.information.domain.TrainNotice;
import com.srts.information.service.InfoCenterService;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.po.StudyChapterStatusPo;
import com.srts.learning.service.OnlineCourseService;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.UserService;

@Controller
@Scope("prototype")
public class OnlineCourseAction extends BaseActionImpl<Book>{
	private static final long serialVersionUID = 1L;
	private Book book = new Book();
	@Resource
	private OnlineCourseService service;
	@Resource 
	private InfoCenterService tnService;
	@Resource
	private UserService userService;
	
	
	private String courseID;
	private String courseType;
	private String studyStartTime="0";
	private long studyEndTime=0;
	private String resString="";
	private String post="";
	
	private String chapterID="";
	private String beforeChapterID="";
	
	private List<Book> bookList = new ArrayList<Book>();//返回所有书，用于显示
	private List<OnlineCoursePPT> pptList = new ArrayList<OnlineCoursePPT>();//返回所有课件，用于显示
	private List<OnlineCourseVideo>videoList = new ArrayList<OnlineCourseVideo>();//返回所有视频，用于显示
	
	private List<BookChapter> chapterList = new ArrayList<BookChapter>();//返回所有章节标题，用于显示
	private List<StudyChapterStatusPo> chapterStatusPos = new ArrayList<StudyChapterStatusPo>();//返回书章节的学习进度
	private OnlineCoursePPT pptInfo = new OnlineCoursePPT();//返回课件内容，用于显示
	private OnlineCourseVideo videoInfo = new OnlineCourseVideo();//返回视频内容，用于显示
	
	private List<BookChapterContent> contentList = new ArrayList<BookChapterContent>();//返回章节信息，用于点击章节name显示
	private List<OnlineCourseVideo> recommendVideos = new ArrayList<OnlineCourseVideo>();//返回推荐视频信息，用于显示
	
	
	public Book getModel() {
		return null;
	}

	public void prepare() throws Exception {}

	/**
	 * 跳转到onlineCourseList.jsp
	 * 获得书，视频，PPT资料
	 * @return
	 */
	public String onlineCourseList(){
		bookList = service.getAllBooks();//得到所有的书
		pptList = service.getAllPPTs();//得到所有的课件
		videoList = service.getAllVideos();//得到所有的视频
		return "onlineCourseList";
	}

	/**
	 * 跳转到onlineCourseDisp.jsp
	 * 根据courseType，courseID获取相应的书，视频，课件资料详细内容
	 * @return
	 */
	public String onlineCourseDisp(){
		Long ID = 0L;
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		if(courseType=="BOOK"||courseType.equals("BOOK")){
			ID = Long.parseLong(courseID);
			chapterList = service.getBookChapterByID(ID);
			chapterStatusPos = service.getBookChapterSchedule(usr.getId(), ID);
			service.updateBookViewCount(ID);
			studyStartTime=String.valueOf(System.currentTimeMillis());
		}
		if(courseType=="VIDEO"||courseType.equals("VIDEO")){
			ID = Long.parseLong(courseID);
			videoInfo = service.getVideoByID(ID);
			service.updateVideoViewCount(ID);
			recommendVideos = service.getRecommendVideo();
		}
		if(courseType=="PPT"||courseType.equals("PPT")){
			ID = Long.parseLong(courseID);
			pptInfo = service.getPptByPptId(ID);
		}
		return "onlineCourseDisp";
	}
	
	/**
	 * 返回json数据，
	 * 根据chapterID，获取相应的章节内容
	 * @return
	 */
	public String chapterContentDisp(){
		long ID = Long.parseLong(chapterID);
		contentList = service.getChapterContentsByChapterID(ID);
		beforeChapterID=chapterID;
		return "chapterContentDisp";
	}
	
	public String updateOnlineCourseStudy()
	{
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		studyEndTime=System.currentTimeMillis();
		long sum=(studyEndTime-Long.parseLong(studyStartTime))/1000/60;
		if(sum==0)
		{
			sum=1;
		}
		List<TrainNotice> list=tnService.getAllInfo();
		long trainNoticeId=1;
		for(int i=0;i<list.size();i++)
		{
			if(usr.getDepartment().getParentdept().getName().equals(list.get(i).getAcceptCompany())==true||list.get(i).getAcceptCompany().equals("吉林供电公司")==true)
			{
				if(trainNoticeId<list.get(i).getId())
				{
					trainNoticeId=list.get(i).getId();
				}
			}
		}
		long trainId=service.selectTrainIdByNoticeId(trainNoticeId);
		resString=service.insertIntoMyStudyCourse(sum, usr, trainId, Long.parseLong(courseID));
		return "updateOnlineCourseStudy";
	}
	////////////////////////////////////////////////////
	
	public List<BookChapterContent> getContentList() {
		return contentList;
	}
	
	public String getCourseType() {
		return courseType;
	}

	public List<BookChapter> getChapterList() {
		return chapterList;
	}

	public OnlineCoursePPT getPptInfo() {
		return pptInfo;
	}

	public OnlineCourseVideo getVideoInfo() {
		return videoInfo;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public List<Book> getBookList() {
		return bookList;
	}
	public List<OnlineCoursePPT> getPptList() {
		return pptList;
	}
	public List<OnlineCourseVideo> getVideoList() {
		return videoList;
	}

	public void setChapterID(String chapterID) {
		this.chapterID = chapterID;
	}

	public List<OnlineCourseVideo> getRecommendVideos() {
		return recommendVideos;
	}

	public List<StudyChapterStatusPo> getChapterStatusPos() {
		return chapterStatusPos;
	}

	public String getStudyStartTime() {
		return studyStartTime;
	}

	public void setStudyStartTime(String studyStartTime) {
		this.studyStartTime = studyStartTime;
	}

	public long getStudyEndTime() {
		return studyEndTime;
	}

	public void setStudyEndTime(long studyEndTime) {
		this.studyEndTime = studyEndTime;
	}

	public String getResString() {
		return resString;
	}

	public void setResString(String resString) {
		this.resString = resString;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getCourseID() {
		return courseID;
	}

	public String getBeforeChapterID() {
		return beforeChapterID;
	}

	public void setBeforeChapterID(String beforeChapterID) {
		this.beforeChapterID = beforeChapterID;
	}

	public String getChapterID() {
		return chapterID;
	}

	
}
