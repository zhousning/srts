package com.srts.learning.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.dao.StudyCourseDao;
import com.srts.learning.domain.ChapterContentStatus;
import com.srts.learning.po.StudyBookInfoPo;
import com.srts.learning.po.StudyChapterInfoPo;
import com.srts.learning.po.StudyChapterStatusPo;
import com.srts.learning.service.StudyCourseService;
/**
 * 自主学习课程service
 * @author wyw 2014-05-12
 *
 */
@Service
public class StudyCourseServiceImpl implements StudyCourseService {
	@Resource
	private StudyCourseDao dao;
	/////////////////////////////StudyCourseList
	/**
	 * 查找所有的书
	 * @return
	 */
	public List<Book> getAllBooks(){
		return dao.findAll();
	}
	
	/**
	 * 得到员工自主学习每本书的学习进度
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
	 * 得到员工自主学习的书信息
	 */
	public List<StudyBookInfoPo> getMyStudyBookInfo(long userId){
		StudyBookInfoPo bookInfoPo = null;
		List<StudyBookInfoPo> studyBookList = new ArrayList<StudyBookInfoPo>();
		List<?> list = dao.getMyStudyCourseBookInfo(userId);
		Iterator<?>iterator = list.iterator();
		while(iterator.hasNext()){
			Object[]objects = (Object[]) iterator.next();
			bookInfoPo = new StudyBookInfoPo();
			bookInfoPo.setBookId(Long.parseLong(objects[0].toString()));
			bookInfoPo.setBookName(objects[1].toString());
			bookInfoPo.setBookIcon(objects[2].toString());
			int schedule = getBookScheduleById(Long.parseLong(objects[0].toString()),userId);
			bookInfoPo.setSchedule(schedule);
			
			long bookID = Long.parseLong(objects[0].toString());
			List<?>list_in = dao.getMyStudyCourseChapterInfo(userId, bookID); 
			Iterator<?>iterator_in = list_in.iterator();
			String bookChapterInfo = "{'bookId':'"+bookID+"','chapters':[";
			while (iterator_in.hasNext()) {
				Object[] objects_in = (Object[]) iterator_in.next();
				long chapterID = Long.parseLong(objects_in[0].toString());
				String chapterNum = objects_in[1].toString();
				String chapterName = objects_in[2].toString();
				String status = objects_in[3].toString();
				String sumTime = objects_in[5].toString();
				String startTime = objects_in[6].toString();
				String endTime = objects_in[7].toString();
				int schedule_in = schedule;
				bookChapterInfo+="{'chapterID':'"+chapterID+"','chapterName':'"+chapterNum+chapterName+"','sumTime':'"+sumTime+"','status':'"+status+"','schedule':'"+schedule_in+"','startTime':'"+startTime+"','endTime':'"+endTime+"'},";
			}
			bookChapterInfo+="]}";
			bookInfoPo.setBookChapterInfo(bookChapterInfo);
			studyBookList.add(bookInfoPo);
		}
		return studyBookList;
	}
	
	/**
	 * 
	 * 计算自主学习书章节信息
	 * @return
	 */
	public List<StudyChapterInfoPo> getMyStudyChapterInfo(long userId,long bookId){
		//scc.chapterId,bc.chapterNum,bc.chapterName,scc.status,scc.myStudyCourseId,msc.sumTime,msc.startTime,msc.endTime,bk.id bookId
		List<StudyChapterInfoPo> chapterInfoPos = new ArrayList<StudyChapterInfoPo>();//返回值
		List<?>list = dao.getMyStudyCourseChapterInfo(userId, bookId); 
		int schedule = 0;
		Iterator<?>iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] objects = (Object[]) iterator.next();
			StudyChapterInfoPo chapterInfoPo = new StudyChapterInfoPo();
			chapterInfoPo.setChapterId(Long.parseLong(objects[0].toString()));
			chapterInfoPo.setChapterNum(objects[1].toString());
			chapterInfoPo.setChapterName(objects[2].toString());
			chapterInfoPo.setStatus(objects[3].toString());
			chapterInfoPo.setSumTime(objects[5].toString());
			chapterInfoPo.setStartTime(objects[6].toString());
			chapterInfoPo.setEndTime(objects[7].toString());
			long b_id = Long.parseLong(objects[8].toString());
			chapterInfoPo.setBookId(b_id);
			schedule = getBookScheduleById(b_id,userId);
			chapterInfoPo.setSchedule(schedule);
			chapterInfoPos.add(chapterInfoPo);
		}
		return chapterInfoPos;
	}
	
	/**
	 * 计算员工自主学习的书及学习进度,使用column
	 * @return
	 */
	public String getMyStudyCourseSchedule(long userId){
		String bookSchedule = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','labelDisplay':'WRAP','useEllipsesWhenOverflow':'0','caption':'各类课程学习进度','xAxisName':'课程','yAxisName':'进度','numberSuffix ':'%'}," +
				"'data':[";
		int schedule = 0;
		List<?> bookCount = dao.getBookChapterCount();//所有书的章节统计
		List<?> studyBookCount = dao.getStudyBookChapterCount(userId);//自主学习书完成章节的统计
		
		Iterator<?> studyBookCountIte = studyBookCount.iterator();
		Iterator<?> bookCountIte = bookCount.iterator();
		while(studyBookCountIte.hasNext()){
			Object[]studyBookObj = (Object[]) studyBookCountIte.next();
			String studyBookChapterCount = studyBookObj[0].toString();
			String bookId = studyBookObj[1].toString();
			Book book = dao.getById(Long.parseLong(bookId));
			String bookName = book.getBookName();
			bookSchedule+="{'label':'"+bookName+"',";
			while(bookCountIte.hasNext()){
				Object[]bookObj = (Object[]) bookCountIte.next();
				String bookChapterCount = bookObj[0].toString();
				String id = bookObj[1].toString();
				if(id.equals(bookId)){
					schedule = (int)((Float.parseFloat(studyBookChapterCount)/Float.parseFloat(bookChapterCount))*100);
					break;
				}
			}
			bookSchedule+="'value':'"+schedule+"'},";
		}
		bookSchedule+="]}";
		return bookSchedule;
	}
	
	/**
	 * 计算员工自主学习的书及学习进度使用bar
	 * @param userId
	 * @return
	 */
	public String getMyStudyCourseSchedule1(long userId){
		String bookSchedule = "{'chart':{'showlabels':'1','numberperfix':'%','caption':'各类书学习进度图','xaxisname':'书名','yaxisname':'进度百分比','decimals':'0','showvalues':'0','palette':'2','yAxisMaxValue':'100'},";
		String categories = "'categories':[{'category':[";
		String dataSet = "'dataset':[{'showvalues':'0','color':'FFD8F8','data':[";
		int schedule = 0;
		List<?> bookCount = dao.getBookChapterCount();//所有书的章节统计
		List<?> studyBookCount = dao.getStudyBookChapterCount(userId);//自主学习书完成章节的统计
		
		Iterator<?> studyBookCountIte = studyBookCount.iterator();
		Iterator<?> bookCountIte = bookCount.iterator();
		while(studyBookCountIte.hasNext()){
			Object[]studyBookObj = (Object[]) studyBookCountIte.next();
			String studyBookChapterCount = studyBookObj[0].toString();
			String bookId = studyBookObj[1].toString();
			Book book = dao.getById(Long.parseLong(bookId));
			String bookName = book.getBookName();
			categories+="{'label':'"+bookName+"'},";
			while(bookCountIte.hasNext()){
				Object[]bookObj = (Object[]) bookCountIte.next();
				String bookChapterCount = bookObj[0].toString();
				String id = bookObj[1].toString();
				if(id.equals(bookId)){
					schedule = (int)((Float.parseFloat(studyBookChapterCount)/Float.parseFloat(bookChapterCount))*100);
					break;
				}
			}
			dataSet+="{'value':'"+schedule+"'},";
		}
		categories+="]}],";
		dataSet+="]}]}";
		bookSchedule+=categories+dataSet;
		return bookSchedule;
	}
	
	/**
	 * 计算员工自主学习的书及学习时间累计
	 * @return
	 */
	public String getMyStudyCourseSumTime(long userId){
		String bookSumTime = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','labelDisplay':'WRAP','useEllipsesWhenOverflow':'0','caption':'当前各门课程学习时间累计','xAxisName':'课程','yAxisName':'时间','numberPrefix':'时间'},'data':[";
		List<?> list = dao.getStudyTotalTime(userId);
		Iterator<?> iterator = list.iterator();
		while(iterator.hasNext()){
			Object[]obj = (Object[]) iterator.next();
			String sumTime = obj[0].toString();
			String bookId = obj[1].toString();
			Book book = dao.getById(Long.parseLong(bookId));
			String bookName = book.getBookName();
			bookSumTime+="{'label':'"+bookName+"','value':'"+sumTime+"'},";
		}
		bookSumTime+="]}";
		return bookSumTime;
	}
	/**
	 * 计算员工自主学习每月学习次数变化
	 * @return
	 */
	public String getMyStudyCourseNumCount(long userId,String year){
		String numCount = "{'chart': {'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','divlinecolor': '91AF46','xaxisname': '月份','yaxisname':'次数','caption': '月自学次数统计变化趋势','divlinealpha': '30','showvalues': '0','bgcolor': '91AF46,FFFFFF','anchorradius': '5','anchorsides': '3','yaxismaxvalue': '30'}," +
				"'data':[";
		String[]months = new String[12];
		for(int i=0;i<12;i++){
			if(i<9){
				int n = i+1;
				months[i]=year+"-0"+n;
				int num = dao.getStudyCourseNumCount(userId,months[i]+"%");
				numCount+="{'value':'"+num+"','label':'"+months[i]+"'},";
			}else{
				int n = i+1;
				months[i]=year+"-"+n;
				int num = dao.getStudyCourseNumCount(userId,months[i]+"%");
				numCount+="{'value':'"+num+"','label':'"+months[i]+"'},";
			}	
		}
		numCount+="]," +
				"'trendlines':[{'line':[" +
				"{'color': 'BC9F3F','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '一般','endvalue': '15','startvalue': '7'}," +
				"{'color': '894D1B','alpha': '25','valueonright': '1','showontop': '0','istrendzone': '1','displayvalue': '主动','endvalue': '30','startvalue': '15'}]}]}";
		return numCount;
	}
	/////////////////////////////StudyCourseDisp
	/**
	 * 获取当前自主学习的进度
	 */
	public List<StudyChapterStatusPo> getBookChapterSchedule(long userID, long bookID){
		List<StudyChapterStatusPo> chapterStatusPos = new ArrayList<StudyChapterStatusPo>();//返回值
		
		List<BookChapter> bookAllChapters = dao.getBookChapters(bookID);//获取所有书的章节
		List<?> bookSomeChapter = dao.getBookChapterStatusNotByFinishOrUndone(userID, bookID);//获取完成或进行中的章节
		//Iterator<?> iterator_in = bookSomeChapter.iterator();
		for(BookChapter chapter:bookAllChapters){
			long chapter_out_id = chapter.getId();
			//System.out.println("chapter_out_id="+chapter_out_id);
			String chapter_out_num = chapter.getChapterNum();
			String chapter_out_name = chapter.getChapterName();
			String chapter_out_status = "";
			StudyChapterStatusPo chapterStatusPo = new StudyChapterStatusPo();
			chapterStatusPo.setChapterID(chapter_out_id);
			chapterStatusPo.setChapterNum(chapter_out_num);
			chapterStatusPo.setChapterName(chapter_out_name);
			chapterStatusPo.setChapterStatus(chapter_out_status);
			Iterator<?> iterator_in = bookSomeChapter.iterator();
			while(iterator_in.hasNext()){
				Object[] objects_in = (Object[]) iterator_in.next();
				long chapter_in_id = Long.parseLong(objects_in[0].toString());
				String chapter_in_status = objects_in[1].toString();
				//如果out_章节和in_章节相同，且已完成，则保存章节内容。
				if(chapter_in_id==chapter_out_id){
					if((chapter_in_status.trim())=="完成"||(chapter_in_status.trim()).equals("完成")){
						//System.out.println(chapter_in_id+"------"+chapter_out_id);
						chapter_out_status = chapter_in_status;
						chapterStatusPo.setChapterStatus(chapter_out_status);
					}
					if((chapter_in_status.trim())=="进行中"||(chapter_in_status.trim()).equals("进行中")){
						chapter_out_status = chapter_in_status;
						chapterStatusPo.setChapterStatus(chapter_out_status);
					}
				}
				
			}
			chapterStatusPos.add(chapterStatusPo);
		}
		return chapterStatusPos;
	}
	/**
	 * 根据bookID获取章节
	 */
	public List<BookChapter> getBookChapters(long bookID){
		return dao.getBookChapters(bookID);
	}
	/**
	 * 根据chapterID获取章节内容
	 */
	public List<BookChapterContent> getBookChapterContents(long chapterID){
		return dao.getBookChapterContents(chapterID);
	}
	/**
	 * 根据chapterId获取正在进行的章节内容
	 * @param bookID
	 * @param userID
	 * @return
	 */
	public List<BookChapterContent> getStudyBookOtherChapter(long bookID,long userID){
		List<BookChapterContent> contentList = dao.getStudyBookOtherChapter(bookID, userID);
		int size = contentList.size();
		if(size==0){
			contentList = dao.getStudyBookOtherChapterUndo(bookID,userID);
		}
		return contentList;
	}
}	
