package com.srts.learning.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.common.base.BaseDao;
import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.dao.TrainCourseDao;
import com.srts.learning.domain.MyTrainCourse;
import com.srts.learning.po.TrainCourseBookPo;
import com.srts.learning.po.TrainCourseInfoPo;
import com.srts.learning.service.TrainCourseService;

@Service("trainCourseService")
public class TrainCourseServiceImpl implements TrainCourseService {
	@Resource(name = "trainCourseDao")
	private TrainCourseDao trainCourseDao;

	public List<MyTrainCourse> getCurrentCourse(long userId) {
		// TODO Auto-generated method stub
		return trainCourseDao.selectCurrentCourse(userId);
	}

	public MyTrainCourse getById(long userId) {
		return trainCourseDao.getById(userId);
	}

	public List<MyTrainCourse> getHistoryCourse(long userId) {

		return trainCourseDao.selectHistoryCourse(userId);
	}

	/**
	 * 获取当前学习课程总的时间
	 */
	public String getSumTime(long userId) {
		String curCourseSumTime = "{'chart': { 'caption' : '当前课程学习时间累计' ,'xAxisName' : '课程名称','yAxisName' : '时长','numberPrefix' : '小时'},'data':[";

		List<?> list = trainCourseDao.getSumTime(userId);
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();

			String trainNum = object[1].toString();
			String sumTime = object[0].toString();
			curCourseSumTime += "{'label':'第" + trainNum + "次培训','value':'"
					+ sumTime + "'},";
		} 
		curCourseSumTime += "] }";
		return curCourseSumTime;
	} 

	/**
	 * 获取历史课程阅读次数总数
	 */
	public String getSumReadTime(long userId) {
		String readTime = "{'chart': { 'caption' : '课程阅读次数统计' ,'xAxisName' : '章节','yAxisName' : '次数','numberPrefix' : '次数'},'data':[";
		List<?> list = trainCourseDao.getSumReadTime(userId);
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			String trainNum = object[1].toString();
			String sumRead = object[0].toString();
			readTime += "{'label':'第" + trainNum + "次培训','value':'" + sumRead
					+ "'},";
		}
		readTime += "]}";
		return readTime;
	}

	/**
	 * 获取员工课程平均学习时间与我的学习时间
	 */
	public String getAvgCompMyStuTime(long userId) {
		String compTime1 = "{ 'chart': { 'canvaspadding': '10', 'caption': '课程学习时间对比','yaxisname': '时间','bgcolor': 'F7F7F7, E9E9E9','numvdivlines': '10','divlinealpha': '30','labelpadding': '10','yaxisvaluespadding': '10','showvalues': '1','rotatevalues': '1','valueposition': 'auto' },'categories': [ { 'category': [";
		List<?> list = trainCourseDao.getAvgAndMyStuTime(1);
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			String trainNum = object[0].toString();

			compTime1 += "{ 'label': '第" + trainNum + "次培训' },";
		}
		compTime1 += "] } ],'dataset': [{ 'seriesname': '员工课程平均学习时间', 'color': 'A66EDD', 'data': [";

		Iterator<?> iterator2 = list.iterator();
		while (iterator2.hasNext()) {
			Object[] object = (Object[]) iterator2.next();
			String avgTime = object[3].toString();

			compTime1 += "{ 'value': '" + avgTime + "' },";
		}
		compTime1 += "] }, { 'seriesname': '我的课程学习时间', 'color': 'F6BD0F', 'data': [";

		Iterator<?> iterator3 = list.iterator();
		while (iterator3.hasNext()) {
			Object[] object = (Object[]) iterator3.next();
			String myTime = object[1].toString();

			compTime1 += "{ 'value': '" + myTime + "' },";
		}
		compTime1 += "] } ] }";
		return compTime1;
	}

	/**
	 *当前进行的课程的完成度
	 */
	public String getComDegree(long userId) {
		// TODO Auto-generated method stub
		String comDe = "{'chart': {'caption': '当前课程完成度','formatnumberscale': '1','startingangle': '125','pieslicedepth': '30','numberprefix': '','decimals': '0', 'animation': '1','palette': '1'},'data': [";
		List<?> list = trainCourseDao.getComDegree(userId);
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			String label = object[1].toString();
			String value = object[0].toString();
			comDe += "{'label': '" + label + "','value': '" + value
					+ "','issliced': '1'},";
		}
		comDe += "]}";
		return comDe;
	}

	/**
	 * 获取总的培训时间
	 */
	public String getTrainStudyTime(long userId) {
		String sumTime = "{ 'chart': { 'manageresize': '1', 'origw': '280', 'origh': '280', 'bgcolor': 'FFFFFF', 'upperlimit': '180', 'lowerlimit': '0', 'majortmnumber': '7', 'majortmcolor': 'AF9A03', 'majortmheight': '8', 'minortmnumber': '0', 'majortmthickness': '8', 'showgaugeborder': '0', 'gaugeouterradius': '100', 'gaugeoriginx': '140', 'gaugeoriginy': '140', 'gaugestartangle': '230', 'gaugeendangle': '-50', 'placevaluesinside': '1', 'gaugeinnerradius': '90', 'tickvaluedistance': '17', 'pivotradius': '12', 'pivotfillmix': '{AF9A03},{ffffff}', 'pivotbordercolor': 'AF9A03', 'pivotborderthickness': '2', 'pivotfillratio': '50,50', 'pivotfilltype': 'linear', 'showpivotborder': '1', 'showshadow': '0' }, 'dials': { 'dial': [";
		String time = trainCourseDao.getTrainStudyTime(userId);
		sumTime += " { 'value': '" + time + "',";
		sumTime += " 'borderalpha': '0', 'bgcolor': '6A6FA6,AF9A03', 'basewidth': '4', 'topwidth': '4', 'radius': '93' } ] }, 'annotations': { 'groups': [ { 'x': '140', 'y': '140', 'items': [ { 'type': 'circle', 'radius': '110', 'fillpattern': 'linear', 'fillcolor': 'eeeeee,ebce05,eeeeee', 'fillratio': '0,100,0', 'fillangle': '270', 'showborder': '1', 'bordercolor': '444444', 'borderthickness': '1' }, { 'type': 'circle', 'radius': '100', 'fillpattern': 'linear', 'fillcolor': 'ffffff,ebce05,eeeeee', 'fillalpha': '100,10,100', 'fillratio': '5,83,12', 'fillangle': '270' } ] } ] } }";
		return sumTime;
	}

	/**
	 * 获取培训的所有章节
	 */
	public List<BookChapter> getAllChapters(long trainCourseId) {
		// TODO Auto-generated method stub
		List<?> list = trainCourseDao.getAllChapters(trainCourseId);
		List<BookChapter> chapterInfoPos = new ArrayList<BookChapter>();
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] objects = (Object[]) iterator.next();
			BookChapter bookChapter = new BookChapter();

			long chapterId = Long.parseLong(objects[0].toString());
			String chapterNum = objects[1].toString();
			String chapterName = objects[2].toString();
			long bookId = Long.parseLong(objects[3].toString());

			bookChapter.setId(chapterId);
			bookChapter.setChapterNum(chapterNum);
			bookChapter.setChapterName(chapterName);
			bookChapter.getBook().setId(bookId);

			chapterInfoPos.add(bookChapter);
		}
		return chapterInfoPos;
	}

    /**
     * 根据chapterId获取该章节相应的内容
     */
	public List<BookChapterContent> getAllChapterContents(long chapterId) {
		// TODO Auto-generated method stub
		return  trainCourseDao.getAllChapterContents(chapterId);
	}

	/**
     * 更新用户开始时间
     */
	public void updateThisStartTime(long userId, long trainCourseId,
			String dateString) {
		// TODO Auto-generated method stub
		trainCourseDao.updateThisStartTime(userId,trainCourseId,dateString);
	}

	/**
	 * 本次学习结果
	 */
	public void updateTrainResult(long myTrainCourseId,float schedule, String endTime,
			String lastStudyDate, long sumTime) {
		// TODO Auto-generated method stub
		trainCourseDao.updateTrainResult(myTrainCourseId,schedule,endTime, lastStudyDate, sumTime);
	}


	/**
	 * 根据userId与trainCourseId获取某一次的MyTrainCourse
	 */
	public MyTrainCourse getByUsrIdAndTrainCouId(long userId, long trainCourseId) {
		// TODO Auto-generated method stub
		return trainCourseDao.getByUsrIdAndTrainCouId(userId,trainCourseId);
	}

	public List<BookChapter> getBookChapter(long trainCourseId) {
		// TODO Auto-generated method stub
		return trainCourseDao.getBookChapter(trainCourseId);
	}
	
	/**
	 * 更新小节状态
	 */
	public void updateThisItem(long myTrainCourseId, long itemID,
			String dateString) {
		trainCourseDao.updateThisItem(myTrainCourseId,itemID,dateString);
		
	}

	/**
	 * 计算培训进度
	 */
	public float getSchedule(long myTrainCourseId) {
		List<?> list=trainCourseDao.getSchedule(1);
		Iterator<?> iterator=list.iterator();
		int i=0;
	   float a[]=new float[2];
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			float res=Float.parseFloat(object[0].toString());
			a[i]=res;
			i++;
		}
		float sum=a[0]+a[1];
		float res=(a[1]/sum)*100;
		System.out.println(res);
		return res;
	}



	









}
