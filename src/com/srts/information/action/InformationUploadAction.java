package com.srts.information.action;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.srts.common.base.impl.BaseActionImpl;
import com.srts.information.domain.TrainNotice;
import com.srts.information.service.InfoCenterService;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.utils.pageUtils.PageBean;

@Controller
public class InformationUploadAction extends BaseActionImpl<TrainNotice>{
	private static final long serialVersionUID = 1L;
	private TrainNotice trainNotice = new TrainNotice();
	private List<OnlineCoursePPT> ppts;
	private List<OnlineCourseVideo> videos;
	private List<Book> books;
	private List<TrainNotice> notices;
	private OnlineCoursePPT ppt;
	private OnlineCourseVideo video;
	private Book book;
	private TrainNotice notice;
	private String downloadName;
	private Long id;
	private String saveURL;

	private int currentPageNum=1;
	private int allPageNum;
	
	public TrainNotice getModel() {
		return null;
	}

	@Resource
	private InfoCenterService service;
	
	public void prepare() throws Exception {}
	
	/**
	 * 跳转到inforUploadList.jsp
	 * @return
	 */
	public String inforUploadList(){
		ppts=service.getTop5PPT();
		videos=service.getTop5Video();
		books=service.getTop5Book();
		notices=service.getTop5Notice();
		for(int i=0; i<ppts.size(); i++){
			String str=ppts.get(i).getPptName();
			if(str.length()>10){
				ppts.get(i).setPptName(str.substring(0, 8)+"...");
			}
		}
		for(int i=0; i<videos.size(); i++){
			String str=videos.get(i).getVideoName();
			if(str.length()>10){
				videos.get(i).setVideoName(str.substring(0, 8)+"...");
			}
		}
		for(int i=0; i<books.size(); i++){
			String str=books.get(i).getBookName();
			if(str.length()>10){
				books.get(i).setBookName(str.substring(0, 8)+"...");
			}
		}
		for(int i=0; i<notices.size(); i++){
			String str=notices.get(i).getNoticeTitle();
			if(str.length()>10){
				notices.get(i).setNoticeTitle(str.substring(0, 8)+"...");
			}
		}
		return "inforUploadList";
	}
	
	/**
	 * 跳转到coursewareDownloadDisp.jsp
	 * @return
	 */
	public String coursewareDownloadDisp(){
		//ppts=service.getAllPPT();
		//return "coursewareDownloadDisp";
		return downloadPPTByPage();
	}
	
	/**
	 * 跳转到studyCourseDownloadDisp.jsp
	 * @return
	 */
	public String studyCourseDownloadDisp(){
		//return "studyCourseDownloadDisp";
		return downloadBookByPage();
	}
	
	/**
	 * 跳转到videoDownloadDisp.jsp
	 * @return
	 */
	public String videoDownloadDisp(){
		//videos=service.getAllVideo();
		//return "videoDownloadDisp";
		return downloadVideoByPage();
	}
	
	/**
	 * 跳转到othersDownloadDisp.jsp
	 * @return
	 */
	public String othersDownloadDisp(){
		//return "othersDownloadDisp";
		return downloadNoticeByPage();
	}

	/**
	 *下载ppt
	 * @return
	 */
	public String downloadPPT(){
		ppt=service.getPPTById(id);
		long loadCount=ppt.getLoadCount();
		downloadName=ppt.getSaveURL();
		System.out.println(downloadName);
		ppt.setLoadCount(loadCount+1);
		service.updatePPT(ppt);
		return "coursewareDownload";
		//return inforUploadList();
		
	}
	
	/**
	 * 
	 * @return
	 */
	
	public InputStream getDownloadPPT() throws Exception {
		ServletActionContext.getResponse().setHeader(
				"Content-Disposition",
				"attachment;fileName=" + java.net.URLEncoder.encode(downloadName, "UTF-8"));
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/resource/templete/learning/book_ppt_video/"+downloadName);
	}
	
	
	/**
	 *下载video
	 * @return
	 */
	public String downloadVideo(){
		video=service.getVideoById(id);
		long loadCount=video.getLoadCount();
		downloadName=video.getSaveURL();
		System.out.println(downloadName);
		video.setLoadCount(loadCount+1);
		service.updateVideo(video);
		return "videoDownload";
		
		
	}
	/**
	 * 
	 * @return
	 */
	public InputStream getDownloadVideo() throws Exception {
		ServletActionContext.getResponse().setHeader(
				"Content-Disposition",
				"attachment;fileName=" + java.net.URLEncoder.encode(downloadName, "UTF-8"));
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/resource/templete/learning/book_ppt_video/"+downloadName);
	}
	/**
	 *下载学习资料
	 * @return
	 */
	public String downloadBook(){
		book=service.getBookById(id);
		long loadCount=book.getLoadCount();
		downloadName=book.getSaveURL();
		System.out.println(downloadName);
		book.setLoadCount(loadCount+1);
		service.updateBook(book);
		return "studyCourseDownload";
		
		
	}
	/**
	 * 
	 * @return
	 */
	public InputStream getDownloadBook() throws Exception {
		ServletActionContext.getResponse().setHeader(
				"Content-Disposition",
				"attachment;fileName=" + java.net.URLEncoder.encode(downloadName, "UTF-8"));
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/resource/templete/learning/book_ppt_video/" + downloadName);
	}
	
	
	/**
	 *下载其他
	 * @return
	 */
	public String downloadNotice(){
		notice=service.getOneInfo(id);
		long loadCount=notice.getLoadCount();
		downloadName=notice.getNoticeAttach();
		System.out.println(downloadName);
		notice.setLoadCount(loadCount+1);
		service.updateOneInfo(notice);
		return "othersDownload";
	}
	/**
	 * 
	 * @return
	 */
	public InputStream getDownloadNotice() throws Exception {
		ServletActionContext.getResponse().setHeader(
				"Content-Disposition",
				"attachment;fileName=" + java.net.URLEncoder.encode(downloadName, "UTF-8"));
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/resource/templete/information/notice/" + downloadName);
	}
	
	
	

	
	
	public List<OnlineCoursePPT> getPpts() {
		return ppts;
	}

	public void setPpts(List<OnlineCoursePPT> ppts) {
		this.ppts = ppts;
	}

	public List<OnlineCourseVideo> getVideos() {
		return videos;
	}

	public void setVideos(List<OnlineCourseVideo> videos) {
		this.videos = videos;
	}
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
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
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getDownloadName() {
		return downloadName;
	}

	public void setDownloadName(String downloadName) {
		this.downloadName = downloadName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getAllPageNum() {
		return allPageNum;
	}

	public void setAllPageNum(int allPageNum) {
		this.allPageNum = allPageNum;
	}

	public List<TrainNotice> getNotices() {
		return notices;
	}

	public void setNotices(List<TrainNotice> notices) {
		this.notices = notices;
	}

	public TrainNotice getNotice() {
		return notice;
	}

	public void setNotice(TrainNotice notice) {
		this.notice = notice;
	}
	
	
	
	
	private int page=1;// 第几页

	private PageBean pageBean;// 包含分布信息的bean

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

	public String downloadPPTByPage() {
		int pageSize = service.getAllRowCount("from OnlineCoursePPT");
		System.out.println(pageSize);
		if (pageSize % 15 == 0) {
			size = pageSize / 15;
		} else {
			size = pageSize / 15 + 1;
		}
		pageBean = service.queryForPage("from OnlineCoursePPT order by id desc", 15, page);
		System.out.println(pageBean);
		return "coursewareDownloadDisp";
	}
	
	public String downloadVideoByPage() {
		int pageSize = service.getAllRowCount("from OnlineCourseVideo");
		System.out.println(pageSize);
		if (pageSize % 15 == 0) {
			size = pageSize / 15;
		} else {
			size = pageSize / 15 + 1;
		}
		pageBean = service.queryForPage("from OnlineCourseVideo order by id desc", 15, page);
		System.out.println(pageBean);
		return "videoDownloadDisp";
	}
	
	public String downloadBookByPage() {
		int pageSize = service.getAllRowCount("from Book");
		System.out.println(pageSize);
		if (pageSize % 15 == 0) {
			size = pageSize / 15;
		} else {
			size = pageSize / 15 + 1;
		}
		pageBean = service.queryForPage("from Book order by id desc", 15, page);
		System.out.println(pageBean);
		return "studyCourseDownloadDisp";
	}
	
	public String downloadNoticeByPage() {
		int pageSize = service.getAllRowCount("from TrainNotice where noticeAttach!=''");
		System.out.println(pageSize);
		if (pageSize % 15 == 0) {
			size = pageSize / 15;
		} else {
			size = pageSize / 15 + 1;
		}
		pageBean = service.queryForPage("from TrainNotice where noticeAttach!='' order by id desc", 15, page);
		System.out.println(pageBean);
		return "othersDownloadDisp";
	}
}
