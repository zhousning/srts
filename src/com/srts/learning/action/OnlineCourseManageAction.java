package com.srts.learning.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.po.OnlineCourseBookInfoPo;
import com.srts.learning.po.OnlineCourseInfoPo;
import com.srts.learning.po.OnlineCoursePPTInfoPo;
import com.srts.learning.po.OnlineCourseStatisticsPo;
import com.srts.learning.po.OnlineCourseVideoInfoPo;
import com.srts.learning.service.OnlineCourseManageService;
import com.srts.system.domain.Sys_User;
import com.srts.utils.pageUtils.PageBean;
import com.srts.utils.pageUtils.PaginationUtil;


@Controller
@Scope("prototype")
@SuppressWarnings("unchecked")
public class OnlineCourseManageAction extends BaseActionImpl<Book>{
	private static final long serialVersionUID = 1L;
	
	@Resource
	private OnlineCourseManageService service;
	
	private String pageNum = "1";
	private String courseType = "";
	private String courseIds = "1";
	private String courseName = "";
	private String courseIntro = "";
	private File courseImage = null;
	private String courseImageFileName = null;
	private File courseDoc = null;
	private String courseDocFileName = null;
	
	private OnlineCourseBookInfoPo bookPo = new OnlineCourseBookInfoPo();
	private OnlineCoursePPTInfoPo pptPo = new OnlineCoursePPTInfoPo();
	private OnlineCourseVideoInfoPo videoPo = new OnlineCourseVideoInfoPo();
	private OnlineCourseStatisticsPo statisticPo = new OnlineCourseStatisticsPo();
	private OnlineCourseInfoPo courseInfoPo = new OnlineCourseInfoPo();
	private String messages;
	
	public Book getModel() {
		return null;
	}
	public void prepare() throws Exception {}

	/**
	 * 跳转到onlineCourseManageList.jsp
	 * @return
	 */
	public String onlineCourseManageList(){
		/*
		if(pageNum==null||pageNum.equals("")){
			pageNum = "1";
		}
		PaginationUtil pageUtil = new PaginationUtil();
		Long bookTotalPages = service.getOnlineCourseTotalPages("BOOK");
		bookPo.setBookInfos((List<Book>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), "BOOK"));
		bookPo.setTotalPage(bookTotalPages);
		bookPo.setPageLi(pageUtil.getInitPages(bookTotalPages,"BOOK"));
		
		PaginationUtil pageUtil1 = new PaginationUtil();
		Long pptTotalPages = service.getOnlineCourseTotalPages("PPT");
		pptPo.setPptInfos((List<OnlineCoursePPT>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), "PPT"));
		pptPo.setTotalPage(pptTotalPages);
		pptPo.setPageLi(pageUtil1.getInitPages(pptTotalPages,"PPT"));
		
		PaginationUtil pageUtil2 = new PaginationUtil();
		Long videoTotalPages = service.getOnlineCourseTotalPages("VIDEO");
		videoPo.setVideoInfos((List<OnlineCourseVideo>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), "VIDEO"));
		videoPo.setTotalPage(videoTotalPages);
		videoPo.setPageLi(pageUtil2.getInitPages(videoTotalPages,"VIDEO"));
		//return "onlineCourseManageList";
		 * */
		
		courseType="BOOK";
		return queryByPage();
	}
	
	/**
	 * 点击分页标签获得当前页数据
	 * @return
	 */
	public String queryCurrentPage(){
		if(courseType=="BOOK"||courseType.equals("BOOK")){		
			Long bookTotalPages = service.getOnlineCourseTotalPages(courseType);
			bookPo.setBookInfos((List<Book>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), courseType));
			bookPo.setTotalPage(bookTotalPages);
		}
		if(courseType=="PPT"||courseType.equals("PPT")){
			Long pptTotalPages = service.getOnlineCourseTotalPages(courseType);
			pptPo.setPptInfos((List<OnlineCoursePPT>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), courseType));
			pptPo.setTotalPage(pptTotalPages);
		}
		if(courseType=="VIDEO"||courseType.equals("VIDEO")){
			Long videoTotalPages = service.getOnlineCourseTotalPages(courseType);
			videoPo.setVideoInfos((List<OnlineCourseVideo>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), courseType));
			videoPo.setTotalPage(videoTotalPages);
		}
		return "queryCurrentPage";
	}
	
	/**
	 * 向下翻滚，查询下一页的数据
	 * @return
	 */
	public String getCourseTurnAfterPage(){
		if(courseType=="BOOK"||courseType.equals("BOOK")){
			PaginationUtil pageUtil = new PaginationUtil();
			Long bookTotalPages = service.getOnlineCourseTotalPages(courseType);
			bookPo.setBookInfos((List<Book>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), courseType));
			bookPo.setTotalPage(bookTotalPages);
			bookPo.setPageLi(pageUtil.turnAfterPages(bookTotalPages, pageNum, courseType));
		}
		if(courseType=="PPT"||courseType.equals("PPT")){
			PaginationUtil pageUtil = new PaginationUtil();
			Long pptTotalPages = service.getOnlineCourseTotalPages(courseType);
			pptPo.setPptInfos((List<OnlineCoursePPT>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), courseType));
			pptPo.setTotalPage(pptTotalPages);
			pptPo.setPageLi(pageUtil.turnAfterPages(pptTotalPages, pageNum, courseType));
		}
		if(courseType=="VIDEO"||courseType.equals("VIDEO")){
			PaginationUtil pageUtil = new PaginationUtil();
			Long videoTotalPages = service.getOnlineCourseTotalPages(courseType);
			videoPo.setVideoInfos((List<OnlineCourseVideo>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), courseType));
			videoPo.setTotalPage(videoTotalPages);
			videoPo.setPageLi(pageUtil.turnAfterPages(videoTotalPages, pageNum, courseType));
		}
		return "getCourseTurnAfterPage";
	}
	
	/**
	 * 向上翻滚，查询上一页的数据
	 * @return
	 */
	public String getCourseTurnForwardPage(){
		
		if(courseType=="BOOK"||courseType.equals("BOOK")){
			PaginationUtil pageUtil = new PaginationUtil();
			Long bookTotalPages = service.getOnlineCourseTotalPages(courseType);
			bookPo.setBookInfos((List<Book>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), courseType));
			bookPo.setTotalPage(bookTotalPages);
			bookPo.setPageLi(pageUtil.turnForwardPages(bookTotalPages, pageNum, courseType));
		}
		if(courseType=="PPT"||courseType.equals("PPT")){
			PaginationUtil pageUtil = new PaginationUtil();
			Long pptTotalPages = service.getOnlineCourseTotalPages(courseType);
			pptPo.setPptInfos((List<OnlineCoursePPT>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), courseType));
			pptPo.setTotalPage(pptTotalPages);
			pptPo.setPageLi(pageUtil.turnForwardPages(pptTotalPages, pageNum, courseType));
		}
		if(courseType=="VIDEO"||courseType.equals("VIDEO")){
			PaginationUtil pageUtil = new PaginationUtil();
			Long videoTotalPages = service.getOnlineCourseTotalPages(courseType);
			videoPo.setVideoInfos((List<OnlineCourseVideo>)service.getOnlineCourseInfoByPage(Integer.parseInt(pageNum), courseType));
			videoPo.setTotalPage(videoTotalPages);
			videoPo.setPageLi(pageUtil.turnForwardPages(videoTotalPages, pageNum, courseType));
		}
		
		return "getCourseTurnForwardPage";
		
		
	}
	
	/**
	 * 各类统计信息
	 * @return
	 */
	public String courseTypeCount(){
		statisticPo.setOnlineCourseCount(service.getOnlineCourseCountByType());
		statisticPo.setOnlineCourseLoadCount(service.getOnlineCourseLoadCount());
		statisticPo.setOnlineCourseViewCount(service.getOnlineCourseviewCount());
		return "courseTypeCount";
	}
	
	/**
	 * 根据courseIds删除相应课本
	 * @return
	 */
	public String deleteOnlineCourse(){
		//messages = service.deleteOnlineCourseByTypeAndIds(courseType, courseIds);
		//return "deleteOnlineCourse";
		if(courseType.equals("BOOK")){
			String[] str = courseIds.split(" ");
			for (int i = 0; i < str.length; i++) {
				Book book=service.getBookInfoById(Long.parseLong(str[i]));
				if(book!=null){
					service.deleteBook(book);
				}	
			}
		}else if(courseType.equals("PPT")){
			String[] str = courseIds.split(" ");
			for (int i = 0; i < str.length; i++) {
				OnlineCoursePPT ppt=service.getPptInfoById(Long.parseLong(str[i]));
				if(ppt!=null){
					service.deletePpt(ppt);
				}
			}
		}else if(courseType.equals("VIDEO")){
			String[] str = courseIds.split(" ");
			for (int i = 0; i < str.length; i++) {
				OnlineCourseVideo video=service.getVideoInfoById(Long.parseLong(str[i]));
				if(video!=null){
					service.deleteVideo(video);
				}	
			}
		}
		return queryByPage();
	}
	
	/**
	 * 修改课程信息
	 * @return
	 */
	public String updateOnlineCourse(){
		messages = service.updateOnlineCourseInfoByTypeAndID(courseType, courseIds,courseName,courseIntro);
		return "updateOnlineCourse";
	}
	
	/**
	 * 跳转到onlineCourseManageDisp.jsp
	 * @return
	 */
	public String onlineCourseManageDisp(){
		courseInfoPo = service.getOnlineCourseByTypeAndID(courseIds, courseType);
		if(courseType=="BOOK"||courseType.equals("BOOK")){
			book=service.getBookInfoById(Long.parseLong(courseIds));
		}
		if(courseType=="PPT"||courseType.equals("PPT")){
			ppt=service.getPptInfoById(Long.parseLong(courseIds));
		}
		if(courseType=="VIDEO"||courseType.equals("VIDEO")){
			video=service.getVideoInfoById(Long.parseLong(courseIds));
		}
		return "onlineCourseManageDisp";
	}
	
	/**
	 * 跳转到onlineCourseManagePost.jsp
	 * @return
	 */
	public String onlineCourseManagePost(){
		return "onlineCourseManagePost";
	}
	
	/**
	 * 提交课程信息
	 * @return
	 */
	
	/*
	public String onlineCourseManagePostSus(){
		Sys_User user = new Sys_User();
		user.setName("小张");
		service.onlineCourseManageAdd(courseName, courseIntro, courseImage,courseImageFileName, courseDoc,courseDocFileName,courseType,user);
		
		return "onlineCourseManagePostSus";
	}
	*/
	//////////////////////////////////////////
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public OnlineCourseBookInfoPo getBookPo() {
		return bookPo;
	}
	public void setBookPo(OnlineCourseBookInfoPo bookPo) {
		this.bookPo = bookPo;
	}
	public OnlineCoursePPTInfoPo getPptPo() {
		return pptPo;
	}
	public void setPptPo(OnlineCoursePPTInfoPo pptPo) {
		this.pptPo = pptPo;
	}
	public OnlineCourseVideoInfoPo getVideoPo() {
		return videoPo;
	}
	public OnlineCourseStatisticsPo getStatisticPo() {
		return statisticPo;
	}
	public String getCourseIds() {
		return courseIds;
	}
	public void setCourseIds(String courseIds) {
		this.courseIds = courseIds;
	}
	public String getMessages() {
		return messages;
	}
	public OnlineCourseInfoPo getCourseInfoPo() {
		return courseInfoPo;
	}
	public void setCourseInfoPo(OnlineCourseInfoPo courseInfoPo) {
		this.courseInfoPo = courseInfoPo;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setCourseIntro(String courseIntro) {
		this.courseIntro = courseIntro;
	}
	public File getCourseImage() {
		return courseImage;
	}
	public void setCourseImage(File courseImage) {
		this.courseImage = courseImage;
	}
	public File getCourseDoc() {
		return courseDoc;
	}
	public void setCourseDoc(File courseDoc) {
		this.courseDoc = courseDoc;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getCourseIntro() {
		return courseIntro;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public String getCourseDocFileName() {
		return courseDocFileName;
	}
	public void setCourseDocFileName(String courseDocFileName) {
		this.courseDocFileName = courseDocFileName;
	}
	public String getCourseImageFileName() {
		return courseImageFileName;
	}
	public void setCourseImageFileName(String courseImageFileName) {
		this.courseImageFileName = courseImageFileName;
	}
	
	private Book book = new Book();
	private OnlineCoursePPT ppt = new OnlineCoursePPT();
	private OnlineCourseVideo video = new OnlineCourseVideo();
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public OnlineCoursePPT getPpt() {
		return ppt;
	}
	public void setPpt(OnlineCoursePPT ppt) {
		this.ppt = ppt;
	}
	public OnlineCourseVideo getVideo() {
		return video;
	}
	public void setVideo(OnlineCourseVideo video) {
		this.video = video;
	}


	private File upload;
	private String uploadFileName;
	private String savePath;
	private String uploadContentType;

	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	public String onlineCourseManagePostSus() throws Exception{
		//service.onlineCourseManageAdd(courseName, courseIntro, courseImage,courseImageFileName, courseDoc,courseDocFileName,courseType,user);
		System.out.println(uploadContentType);
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		if(courseType=="BOOK"||courseType.equals("BOOK")){ 
			if(!getUploadContentType().equals("application/msword")){
				return onlineCourseManagePost();
			}
			Book bookInfo = new Book();
			FileInputStream in = new FileInputStream(getUpload());
			FileOutputStream out = new FileOutputStream(getSavePath() + "\\" + getUploadFileName());
			byte[] buffer = new byte[2097152];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			in.close();
			out.close();
			bookInfo.setSaveURL(getUploadFileName());
		
			String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			bookInfo.setBookName(courseName);
			bookInfo.setBookIntro(courseIntro);
			bookInfo.setLoadCount(0);
			bookInfo.setViewCount(0);
			bookInfo.setDate(date);
			bookInfo.setUploadUsr(usr.getName());
//			bookInfo.setChapters(service.getAllChapterFromCourseDoc(upload, "BOOK"));
			service.addBookInfo(bookInfo);
			courseType="BOOK";
		}
		
		if(courseType=="PPT"||courseType.equals("PPT")){
			//System.out.println(getUploadContentType());
			if(!getUploadContentType().equals("application/msword")){
				return onlineCourseManagePost();
			}
			OnlineCoursePPT pptInfo = new OnlineCoursePPT();
			FileInputStream in = new FileInputStream(getUpload());
			FileOutputStream out = new FileOutputStream(getSavePath() + "\\" + getUploadFileName());
			byte[] buffer = new byte[2097152];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			in.close();
			out.close();
			pptInfo.setSaveURL(getUploadFileName());
			String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			pptInfo.setPptName(courseName);
			pptInfo.setPptIntro(courseIntro);
			pptInfo.setLoadCount(0);
			pptInfo.setReadCount(0);
			pptInfo.setUploadDate(date);
			pptInfo.setUploadUsr(usr.getName());
			pptInfo.setUploadUsr(usr.getName());
			service.addPptInfo(pptInfo);
			courseType="PPT";
			
		}
		
		if(courseType=="VIDEO"||courseType.equals("VIDEO")){
			if(!getUploadContentType().equals("video/mp4")){
				return onlineCourseManagePost();
			}
			OnlineCourseVideo videoInfo = new OnlineCourseVideo();
			FileInputStream in = new FileInputStream(getUpload());
			FileOutputStream out = new FileOutputStream(getSavePath() + "\\" + getUploadFileName());
			byte[] buffer = new byte[2097152];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			in.close();
			out.close();
			videoInfo.setSaveURL(getUploadFileName());
			String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			videoInfo.setVideoName(courseName);
			videoInfo.setVideoIntro(courseIntro);
			videoInfo.setLoadCount(0);
			videoInfo.setViewCount(0);
			videoInfo.setUploadDate(date);
			videoInfo.setUploadUsr(usr.getName());
			service.addVideoInfo(videoInfo);
			courseType="VIDEO";
		}	
		return queryByPage();	
	}
	
	
	private int page=1;// 第几页

	private PageBean pageBean=null;// 包含分布信息的bean

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	

	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String queryByPage() {
		if(courseType.equals("BOOK")){
			int pageSize = service.getAllRowCount("from Book");
			System.out.println(pageSize);
			if (pageSize % 10 == 0) {
				size = pageSize / 10;
			} else {
				size = pageSize / 10 + 1;
			}
			pageBean = service.queryForPage("from Book order by id desc", 10, page);
			courseType="BOOK";
		}else 
		if(courseType.equals("PPT")){
			int pageSize = service.getAllRowCount("from OnlineCoursePPT");
			System.out.println(pageSize);
			if (pageSize % 10 == 0) {
				size = pageSize / 10;
			} else {
				size = pageSize / 10 + 1;
			}
			pageBean = service.queryForPage("from OnlineCoursePPT order by id desc", 10, page);
			courseType="PPT";
		}else 
		if(courseType.equals("VIDEO")){
			int pageSize = service.getAllRowCount("from OnlineCourseVideo");
			System.out.println(pageSize);
			if (pageSize % 10 == 0) {
				size = pageSize / 10;
			} else {
				size = pageSize / 10 + 1;
			}
			pageBean = service.queryForPage("from OnlineCourseVideo order by id desc", 10, page);
			courseType="VIDEO";
		}
		
		
		System.out.println(pageBean);
		return "onlineCourseManageList";
	}
	
	
}
