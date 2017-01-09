package com.srts.learning.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.learning.dao.OnlineCourseManageDao;
import com.srts.learning.po.OnlineCourseInfoPo;
import com.srts.learning.service.OnlineCourseManageService;
import com.srts.system.domain.Sys_User;
import com.srts.utils.pageUtils.PageBean;

@Service
public class OnlineCourseManageServiceImpl implements OnlineCourseManageService {
	@Resource
	private OnlineCourseManageDao dao;
	
	/**
	 * 按页码查询每页数据
	 * @return
	 */
	public List<?> getOnlineCourseInfoByPage(int page,String courseType){
		List<Book> bookInfo = null;
		List<OnlineCourseVideo> videoInfo = null;
		List<OnlineCoursePPT> pptInfo = null;
		int perPage = 9;//每页显示多少条记录
		int min = (page-1)*perPage;
		int max = perPage;
		if(courseType == "BOOK" || courseType.equals("BOOK")){
			bookInfo = dao.getOnlineCourseBookInfo(min, max);
		}
		if(courseType == "VIDEO" || courseType.equals("VIDEO")){
			videoInfo = dao.getOnlineCourseVideoInfo(min, max);
		}
		if(courseType == "PPT" || courseType.equals("PPT")){
			pptInfo = dao.getOnlineCoursePPTInfo(min, max);
		}
		return (bookInfo!=null)? bookInfo:(videoInfo!=null)?videoInfo:pptInfo;
	}
	/**
	 * 可分为多少页
	 */
	public Long getOnlineCourseTotalPages(String courseType){
		Long perPage = 9L;//每页显示多少条记录
		Long totalPage =0L;
		Long totalCount = 0L;
		if(courseType == "BOOK" || courseType.equals("BOOK")){
			totalCount = dao.getBookCount();
		}
		if(courseType == "PPT" || courseType.equals("PPT")){
			totalCount = dao.getPptCount();
		}
		if(courseType == "VIDEO" || courseType.equals("VIDEO")){
			totalCount = dao.getVideoCount();
		}
		totalPage = totalCount/perPage+1;
		return totalPage;
	}
	
	/**
	 * 各类课程资源统计
	 * @return
	 */
	public String getOnlineCourseCountByType(){
		Long bookCount = dao.getBookCount();
		Long pptCount = dao.getPptCount();
		Long videoCount = dao.getVideoCount();
		String TypeCount = "{\"chart\": {\"outCnvbaseFont\":\"Arial\",\"outCnvbaseFontSize\":\"11\",\"outCnvBaseFontColor\":\"#000000\",\"bgColor\":\"#FFFFFF\",\"bgalpha\": \"100\",\"showBorder\":\"0\",\"borderColor\":\"#000000\",\"canvasbgColor\":\"#FFFFFF\",\"canvasbgAlpha\":\"100\",\"canvasBorderColor\":\"#000000\",\"canvasBorderThickness\":\"1\",\"canvasBorderAlpha\":\"100\",\"showLabels\":\"1\",\"labelDisplay\":\"Rotate\",\"slantLabels\":\"1\",\"showValues\":\"1\",\"placeValuesInside\":\"0\",\"numberprefix\": \"\",\"baseFont\":\"Arial\",\"baseFontSize\":\"10\",\"baseFontColor\":\"#000000\",\"palette\": \"2\",\"showLimits\":\"0\",\"yAxisMinValue\":\"0\",\"divIntervalHints\":\"10\",\"divLineIsDashed\":\"1\",\"chartLeftMargin\":\"5\",\"chartRightMargin\":\"5\",\"chartTopMargin\":\"5\",\"chartBottomMargin\":\"5\",\"captionPadding\":\"5\",\"xAxisNamePadding\":\"1\",\"yAxisNamePadding\":\"1\",\"canvasPadding\":\"30\"},\"data\": [" +
				"{\"label\": \"课本资源\", \"value\": \""+bookCount+"\" },{\"label\": \"课件资源\", \"value\": \""+pptCount+"\" }, { \"label\": \"视频资源\", \"value\": \""+videoCount+"\" }]}";
		return TypeCount;
	}
	
	/**
	 * 各类课程资源下载统计
	 * @return
	 */
	public String getOnlineCourseLoadCount(){
		Long bookLoadCount = dao.getBookLoadCount();
		Long pptLoadCount = dao.getPptLoadCount();
		Long videoLoadCount = dao.getVideoLoadCount();
		String loadCount = "{\"chart\": {\"outCnvbaseFont\":\"Arial\",\"outCnvbaseFontSize\":\"11\",\"outCnvBaseFontColor\":\"#000000\",\"bgColor\":\"#FFFFFF\",\"bgalpha\": \"100\",\"showBorder\":\"0\",\"borderColor\":\"#000000\",\"canvasbgColor\":\"#FFFFFF\",\"canvasbgAlpha\":\"100\",\"canvasBorderColor\":\"#000000\",\"canvasBorderThickness\":\"1\",\"canvasBorderAlpha\":\"100\",\"showLabels\":\"1\",\"labelDisplay\":\"Rotate\",\"slantLabels\":\"1\",\"showValues\":\"1\",\"placeValuesInside\":\"0\",\"numberprefix\": \"\",\"baseFont\":\"Arial\",\"baseFontSize\":\"10\",\"baseFontColor\":\"#000000\",\"palette\": \"2\",\"showLimits\":\"0\",\"yAxisMinValue\":\"0\",\"yAxisMaxValue\":\"100\",\"divIntervalHints\":\"10\",\"divLineIsDashed\":\"1\",\"chartLeftMargin\":\"5\",\"chartRightMargin\":\"5\",\"chartTopMargin\":\"5\",\"chartBottomMargin\":\"5\",\"captionPadding\":\"5\",\"xAxisNamePadding\":\"1\",\"yAxisNamePadding\":\"1\",\"canvasPadding\":\"30\"},\"data\": [" +
		"{\"label\": \"课本资源\", \"value\": \""+bookLoadCount+"\" },{\"label\": \"课件资源\", \"value\": \""+pptLoadCount+"\" }, { \"label\": \"视频资源\", \"value\": \""+videoLoadCount+"\" }]}";
		return loadCount;
	}
	
	/**
	 * 根据courseid删除course
	 * @param courseId
	 * @param courseType
	 */
	
	/*
	public String deleteOnlineCourseByTypeAndIds(String courseType,String courseIds){
		boolean delete = false;
		if(courseIds!=null){
			String[] courses = courseIds.split("[,]");
			List<Long> ids = new ArrayList<Long>();
			for(String c:courses){
				ids.add(Long.parseLong(c));
			}
			if(courseType == "BOOK" ||courseType.equals("BOOK")){
				delete = dao.deleteBookByIds(ids);
			}
			if(courseType == "PPT" ||courseType.equals("PPT")){
				delete = dao.deletePptByIds(ids);
			}
			if(courseType == "VIDEO" ||courseType.equals("VIDEO")){
				delete = dao.deleteVideoByIds(ids);
			}
		}
		return delete?"删除成功":"删除失败";
	}
	
	*/
	
	/**
	 * 根据courseid和coursetype获取course
	 * @param courseId
	 * @param courseType
	 * @return
	 */
	public OnlineCourseInfoPo getOnlineCourseByTypeAndID(String courseId,String courseType){
		OnlineCourseInfoPo courseInfoPo = new OnlineCourseInfoPo();
		if(courseType=="BOOK"||courseType.equals("BOOK")){
			courseInfoPo.setBookInfo(dao.getBookInfoById(Long.parseLong(courseId)));
		}
		if(courseType=="PPT"||courseType.equals("PPT")){
			courseInfoPo.setPptInfo(dao.getPptInfoById(Long.parseLong(courseId)));
		}
		if(courseType=="VIDEO"||courseType.equals("VIDEO")){
			courseInfoPo.setVideoInfo(dao.getVideoInfoById(Long.parseLong(courseId)));
		}
		return courseInfoPo;
	}
	
	/**
	 * 根据courseid,courseType修改相应课程
	 * @param courseId
	 * @param courseType
	 * @param infoPo
	 */
	public String updateOnlineCourseInfoByTypeAndID(String courseType,String courseIds,String courseName,String courseIntro){
		
		boolean update = false;
		if(courseType=="BOOK"||courseType.equals("BOOK")){
			Book book = new Book();
			book.setBookName(courseName);
			book.setBookIntro(courseIntro);
			update = dao.updateBookInfoById(Long.parseLong(courseIds), book);
		}
		if(courseType=="PPT"||courseType.equals("PPT")){
			OnlineCoursePPT ppt = new OnlineCoursePPT();
			ppt.setPptName(courseName);
			ppt.setPptIntro(courseIntro);
			update = dao.updatePptInfoById(Long.parseLong(courseIds), ppt);
		}
		if(courseType=="VIDEO"||courseType.equals("VIDEO")){
			OnlineCourseVideo video = new OnlineCourseVideo();
			video.setVideoName(courseName);
			video.setVideoIntro(courseIntro);
			update = dao.updateVideoInfoById(Long.parseLong(courseIds), video);
		}
		return update?"修改成功":"修改失败";
	}
	
	/**
	 * 添加课程信息
	 * @param courseName
	 * @param courseIntro
	 * @param courseImage
	 * @param courseDoc
	 * @return
	 */
	public String onlineCourseManageAdd(String courseName,String courseIntro,File courseImage,String courseImageFileName,File courseDoc,String courseDocFileName,String type,Sys_User user){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(type=="BOOK"||type.equals("BOOK")){ 
			String courseIcon = null;
			String courseFileUrl=null;
			String courseDate = null;
			courseDate = format.format(new Date());
			courseIcon = uploadOnlineCourseFile(courseImage,courseImageFileName,type,"image");
			courseFileUrl = uploadOnlineCourseFile(courseDoc,courseDocFileName,type,"templete");
			
			Book bookInfo = new Book();
			bookInfo.setBookName(courseName);
			bookInfo.setBookIntro(courseIntro);
			bookInfo.setLoadCount(0);
			bookInfo.setBookIcon(courseIcon);
			bookInfo.setViewCount(0);
			bookInfo.setDate(courseDate);
			bookInfo.setSaveURL(courseFileUrl);
			bookInfo.setUploadUsr(user.getName());
			dao.addBookInfo(bookInfo);
		}
		if(type=="PPT"||type.equals("PPT")){
			String pptIcon = null;
			String pptFileUrl = null;
			String courseDate = null;
			courseDate = format.format(new Date());
			pptIcon = uploadOnlineCourseFile(courseImage,courseImageFileName,type,"image");
			pptFileUrl = uploadOnlineCourseFile(courseDoc,courseDocFileName,type,"templete");
			
			OnlineCoursePPT pptInfo = new OnlineCoursePPT();
			pptInfo.setPptName(courseName);
			pptInfo.setPptIntro(courseIntro);
			pptInfo.setLoadCount(0);
			pptInfo.setPptImgURL(pptIcon);
			pptInfo.setReadCount(0);
			pptInfo.setUploadDate(courseDate);
			pptInfo.setUploadUsr(user.getName());
			pptInfo.setSaveURL(pptFileUrl);
			pptInfo.setUploadUsr(user.getName());
			dao.addPptInfo(pptInfo);
		}
		if(type=="VIDEO"||type.equals("VIDEO")){
			String videoIcon = null;
			String videoFileUrl = null;
			String courseDate = null;
			courseDate = format.format(new Date());
			videoIcon = uploadOnlineCourseFile(courseImage,courseImageFileName,type,"image");
			videoFileUrl = uploadOnlineCourseFile(courseDoc,courseDocFileName,type,"templete");
			OnlineCourseVideo videoInfo = new OnlineCourseVideo();
			videoInfo.setVideoName(courseName);
			videoInfo.setVideoIntro(courseIntro);
			videoInfo.setLoadCount(0);
			videoInfo.setVideoImgURL(videoIcon);
			videoInfo.setViewCount(0);
			videoInfo.setUploadDate(courseDate);
			videoInfo.setSaveURL(videoFileUrl);
			videoInfo.setUploadUsr(user.getName());
			dao.addVideoInfo(videoInfo);
		}	
		return null;
	}
	
	/**
	 * 保存各类上传课件信息，返回保存的地址
	 * @param file
	 * @param fileName
	 * @param type
	 * @return
	 */
	private String uploadOnlineCourseFile(File file,String fileName,String type,String img_file){
		String new_name = null;
		String[]name_type = null;
		String newPath = "resource/"+img_file+"/learning/"+type;
		String realpath = ServletActionContext.getServletContext().getRealPath("/resource/"+img_file+"/learning/"+type);
		System.out.println(realpath);
		if (file != null) {
			try {
				if(file!=null){
					name_type = fileName.split("[.]");
					int length = name_type.length;
					new_name = new Date().getTime()+"."+name_type[length-1];
				}
				File savefile = new File(new File(realpath), new_name); 
				if (!savefile.getParentFile().exists()) {
					savefile.getParentFile().mkdirs();
				}
				FileUtils.copyFile(file, savefile);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String saveDir = newPath +"/"+ new_name;
		return saveDir;
	}
	
	/**
	 * 上传word文件，读取其中章、节内容
	 */
	public Set<BookChapter> getAllChapterFromCourseDoc(File courseDoc,String type){
		Set<BookChapter> bookChapterSet = new HashSet<BookChapter>();
		BookChapter chapter = null;
		Set<BookChapterContent> contentSet = null;
		BookChapterContent content = null;
		try {
			WordExtractor we = new WordExtractor(new FileInputStream(courseDoc));
			String tfp = we.getTextFromPieces();
			String[] pt = we.getParagraphText();
			for(String str:pt){
				if(str!=null){
					if(str.startsWith("@")){
						chapter = new BookChapter();
						contentSet = new HashSet<BookChapterContent>();
						String[] a = str.split("[$]");
						String name = a[1];
						String num = a[2];
						chapter.setChapterName(name);
						chapter.setChapterNum(num);
					}
					if(str.startsWith("&")){
						content = new BookChapterContent();
						String[] a = str.split("&#");
						String b0 = a[0];
						String b1 = a[1];
						String contentName =  b0.split("&")[1];
						content.setContentName(contentName);
						if(b1.contains("#@\r\n")){
							String contents = b1.split("[#@]")[0];
							content.setContent(contents);
							contentSet.add(content);
							chapter.setContents(contentSet);
							bookChapterSet.add(chapter);
						}else{
							String contents = b1.substring(1, (b1.length()-3));
							content.setContent(contents);
							contentSet.add(content);
						}
					}
					if(str.startsWith("#")){
						content = new BookChapterContent();
						String contentName = "";
						content.setContentName(contentName);
						if(str.contains("#@\r\n")){
							String contents = str.split("[#@]")[0];
							content.setContent(contents);
							contentSet.add(content);
							chapter.setContents(contentSet);
							bookChapterSet.add(chapter);
						}else{
							String contents = str.substring(1, (str.length()-3));
							content.setContent(contents);
							contentSet.add(content);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookChapterSet;
	}
	public void addBookInfo(Book bookInfo) {
		dao.addBookInfo(bookInfo);
	}
	public void addPptInfo(OnlineCoursePPT pptInfo) {
		dao.addPptInfo(pptInfo);
	}
	public void addVideoInfo(OnlineCourseVideo videoInfo) {
		dao.addVideoInfo(videoInfo);
	}
	
	
	
	public Book getBookInfoById(Long bookId) {
		// TODO Auto-generated method stub
		return dao.getBookInfoById(bookId);
	}
	public OnlineCoursePPT getPptInfoById(Long pptId) {
		// TODO Auto-generated method stub
		return dao.getPptInfoById(pptId);
	}
	public OnlineCourseVideo getVideoInfoById(Long videoId) {
		// TODO Auto-generated method stub
		return dao.getVideoInfoById(videoId);
	}
	
	
	
	public PageBean queryForPage(String hql, int pageSize,int page){

		int allRow = dao.getAllRowCount(hql);//总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, page);//当前页开始记录
		final int length = pageSize;//每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List list = dao.queryForPage(hql, offset, length);//"一页"的记录

		//把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
		}

		public int getAllRowCount(String hql) {
			// TODO Auto-generated method stub
			return dao.getAllRowCount(hql);
		}
		public void deleteBook(Book book) {
			// TODO Auto-generated method stub
			dao.deleteBook(book);
		}
		public void deletePpt(OnlineCoursePPT ppt) {
			// TODO Auto-generated method stub
			dao.deletePpt(ppt);
		}
		public void deleteVideo(OnlineCourseVideo video) {
			// TODO Auto-generated method stub
			dao.deleteVideo(video);
		}
		public String getOnlineCourseviewCount() {
			Long bookViewCount = dao.getBookViewCount();
			Long videoViewCount = dao.getVideoViewCount();
			String TypeCount = "{\"chart\": {\"outCnvbaseFont\":\"Arial\",\"outCnvbaseFontSize\":\"11\",\"outCnvBaseFontColor\":\"#000000\",\"bgColor\":\"#FFFFFF\",\"bgalpha\": \"100\",\"showBorder\":\"0\",\"borderColor\":\"#000000\",\"canvasbgColor\":\"#FFFFFF\",\"canvasbgAlpha\":\"100\",\"canvasBorderColor\":\"#000000\",\"canvasBorderThickness\":\"1\",\"canvasBorderAlpha\":\"100\",\"showLabels\":\"1\",\"labelDisplay\":\"Rotate\",\"slantLabels\":\"1\",\"showValues\":\"1\",\"placeValuesInside\":\"0\",\"numberprefix\": \"\",\"baseFont\":\"Arial\",\"baseFontSize\":\"10\",\"baseFontColor\":\"#000000\",\"palette\": \"2\",\"showLimits\":\"0\",\"yAxisMinValue\":\"0\",\"divIntervalHints\":\"10\",\"divLineIsDashed\":\"1\",\"chartLeftMargin\":\"5\",\"chartRightMargin\":\"5\",\"chartTopMargin\":\"5\",\"chartBottomMargin\":\"5\",\"captionPadding\":\"5\",\"xAxisNamePadding\":\"1\",\"yAxisNamePadding\":\"1\",\"canvasPadding\":\"30\"},\"data\": [" +
					"{\"label\": \"课本资源\", \"value\": \""+bookViewCount+"\" }, { \"label\": \"视频资源\", \"value\": \""+videoViewCount+"\" }]}";
			return TypeCount;
		}
	
	
}
