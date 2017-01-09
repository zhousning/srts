package com.srts.learning.dao.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.support.DaoSupport;

import com.srts.knowledge.domain.BookChapter;
import com.srts.knowledge.domain.BookChapterContent;
import com.srts.learning.dao.StudyCourseDao;
import com.srts.learning.dao.TrainCourseDao;
import com.srts.learning.domain.MyTrainCourse;
import com.srts.learning.po.TrainCourseInfoPo;
import com.srts.learning.service.StudyCourseService;
import com.srts.learning.service.TrainCourseService;

public class TrainCourseDaoTest {
	private ApplicationContext act;
	private TrainCourseDao trainCourseDao;
	private TrainCourseService service;

	public void init() {
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		trainCourseDao = (TrainCourseDao) act.getBean("trainCourseDao");
		service = (TrainCourseService) act.getBean("trainCourseService");
	}

	@Test
	public void getSumTime() {
		init();
		String curCourseSumTime = "{'chart': {'divlinecolor': '91AF46','xaxisname': '课程名称','yaxisname':'时长','caption': '当前课程学习时间累计','divlinealpha': '30','showvalues': '0','bgcolor': '91AF46,FFFFFF','anchorradius': '5','anchorsides': '3','yaxismaxvalue': '100'},'data':[";
		List<?> list = trainCourseDao.getSumTime(1);
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();

			String sumTime = object[1].toString();
			String bookName = object[0].toString();

			curCourseSumTime += "{'value':'" + bookName + "','label':'"
					+ sumTime + "'},";
		}
		curCourseSumTime += "] }";
		System.out.println(curCourseSumTime);
	}

	@Test
	public void getAvgCompMyStuTime() {
		init();
		String compTime1 = "{ 'chart': { 'canvaspadding': '10', 'caption': '课程学习时间对比','yaxisname': '时间','bgcolor': 'F7F7F7, E9E9E9','numvdivlines': '10','divlinealpha': '30','labelpadding': '10','yaxisvaluespadding': '10','showvalues': '1','rotatevalues': '1','valueposition': 'auto' },'categories': [ { 'category': [";
		List<?> list = trainCourseDao.getAvgAndMyStuTime(1);
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			String bookName = object[0].toString();

			compTime1 += "{ 'label': '" + bookName + "' },";
		}
		compTime1 += "] } ],'dataset': [{ 'seriesname': '员工课程平均学习时间', 'color': 'A66EDD', 'data': [";

		Iterator<?> iterator2 = list.iterator();
		while (iterator2.hasNext()) {
			Object[] object = (Object[]) iterator2.next();
			String avgTime = object[1].toString();

			compTime1 += "{ 'value': '" + avgTime + "' },";
		}
		compTime1 += "] }, { 'seriesname': '我的课程学习时间', 'color': 'F6BD0F', 'data': [";

		Iterator<?> iterator3 = list.iterator();
		while (iterator3.hasNext()) {
			Object[] object = (Object[]) iterator3.next();
			String myTime = object[3].toString();

			compTime1 += "{ 'value': '" + myTime + "' },";
		}
		compTime1 += "] } ] }";

		System.out.println(compTime1);
	}

	/**
	 * 获取历史课程阅读次数总数
	 */
	@Test
	public void getSumReadTime() {
		init();
		String readTime = "{'chart': { 'caption' : '课程阅读次数统计' ,'xAxisName' : '章节','yAxisName' : '次数','numberPrefix' : '次数'},'data':[";
		List<?> list = trainCourseDao.getSumReadTime(1);
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			String trainNum = object[1].toString();
			String sumRead = object[0].toString();
			readTime += "{'label':'第" + trainNum + "次培训','value':'" + sumRead
					+ "'},";
		}
		readTime += "]};";
		System.out.println(readTime);
	}

	/**
	 *当前进行的课程的完成度
	 */
	@Test
	public void getComDegree() {
		// TODO Auto-generated method stub
		init();
		String comDe = "{'chart': {'caption': '当前课程完成度','formatnumberscale': '1','startingangle': '125','pieslicedepth': '30','numberprefix': '','decimals': '0', 'animation': '1','palette': '1'},'data': [";
		List<?> list = trainCourseDao.getComDegree(1);
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			String label = object[1].toString();
			String value = object[0].toString();
			comDe += "{'label': '" + label + "','value': '" + value
					+ "','issliced': '1'},";
		}
		comDe += "]}";
		System.out.println(comDe);
	}

	/**
	 * 获取总的培训时间
	 */

	/**
	 * 获取总的培训时间
	 */
	@Test
	public void getTrainStudyTime() {
		// TODO Auto-generated method stub
		init();
		String sumTime = "{ 'chart': { 'manageresize': '1', 'origw': '280', 'origh': '280', 'bgcolor': 'FFFFFF', 'upperlimit': '180', 'lowerlimit': '0', 'majortmnumber': '7', 'majortmcolor': 'AF9A03', 'majortmheight': '8', 'minortmnumber': '0', 'majortmthickness': '8', 'showgaugeborder': '0', 'gaugeouterradius': '100', 'gaugeoriginx': '140', 'gaugeoriginy': '140', 'gaugestartangle': '230', 'gaugeendangle': '-50', 'placevaluesinside': '1', 'gaugeinnerradius': '90', 'tickvaluedistance': '17', 'pivotradius': '12', 'pivotfillmix': '{AF9A03},{ffffff}', 'pivotbordercolor': 'AF9A03', 'pivotborderthickness': '2', 'pivotfillratio': '50,50', 'pivotfilltype': 'linear', 'showpivotborder': '1', 'showshadow': '0' }, 'dials': { 'dial': [";
		String time = trainCourseDao.getTrainStudyTime(1);
		// Iterator<?> iterator=list.iterator();
		// while (iterator.hasNext()) {
		// Object[] object = (Object[]) iterator.next();
		// String time=object[0].toString();
		sumTime += " { 'value': '" + time + "',";
		// }
		sumTime += " 'borderalpha': '0', 'bgcolor': '6A6FA6,AF9A03', 'basewidth': '4', 'topwidth': '4', 'radius': '93' } ] }, 'annotations': { 'groups': [ { 'x': '140', 'y': '140', 'items': [ { 'type': 'circle', 'radius': '110', 'fillpattern': 'linear', 'fillcolor': 'eeeeee,ebce05,eeeeee', 'fillratio': '0,100,0', 'fillangle': '270', 'showborder': '1', 'bordercolor': '444444', 'borderthickness': '1' }, { 'type': 'circle', 'radius': '100', 'fillpattern': 'linear', 'fillcolor': 'ffffff,ebce05,eeeeee', 'fillalpha': '100,10,100', 'fillratio': '5,83,12', 'fillangle': '270' } ] } ] } }";
		System.out.println(sumTime);
	}

	@Test
	public void getAllChapters() {
		// TODO Auto-generated method stub
		init();
		List<?> list = trainCourseDao.getAllChapters(1);
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] objects = (Object[]) iterator.next();
			// System.out.println("id"+objects[0]+"chapterNum"+objects[1]+"chapterName"+objects[2]+"bookId"+objects[3]);
			// TrainCourseChapter bookChapter = new TrainCourseChapter();
			//
			// long chapterId = Long.parseLong(objects[0].toString());
			// String chapterNum = objects[1].toString();
			// String chapterName = objects[2].toString();
			// long bookId = Long.parseLong(objects[3].toString());
			//
			// bookChapter.setChapterId(chapterId);
			// bookChapter.setChapterNum(chapterNum);
			// bookChapter.setChapterName(chapterName);
			// bookChapter.setBookId(bookId);
			//
			// System.out.println(bookChapter.getBookId() + " " + " "
			// + bookChapter.getChapterName() + " "
			// + bookChapter.getChapterNum());

			BookChapter bookChapter = new BookChapter();

			long chapterId = Long.parseLong(objects[0].toString());
			String chapterNum = objects[1].toString();
			String chapterName = objects[2].toString();
			long bookId = Long.parseLong(objects[3].toString());

			bookChapter.setId(chapterId);
			bookChapter.setChapterNum(chapterNum);
			bookChapter.setChapterName(chapterName);

			System.out.println(bookChapter.getId());
			System.out.println(bookChapter.getChapterNum());
			System.out.println(bookChapter.getChapterName());
			// System.out.println(bookChapter.getBook().getId());

		}
	}

	@Test
	public void getBookChapter() {
		init();
		List<BookChapter> bookChapters = trainCourseDao.getBookChapter(1);
		Iterator<BookChapter> iterator = bookChapters.iterator();
		while (iterator.hasNext()) {
			BookChapter bookChapter = iterator.next();

			System.out.println(bookChapter.getChapterName());

		}
	}

	/**
	 * 根据chapterId获取该章节相应的内容
	 */
	@Test
	public void getAllContents() {
		// TODO Auto-generated method stub
		init();
		List<BookChapterContent> bookChapterContents = trainCourseDao
				.getAllChapterContents(1);
		Iterator<BookChapterContent> iterator = bookChapterContents.iterator();
		while (iterator.hasNext()) {
			BookChapterContent bookChapterContent = (BookChapterContent) iterator
					.next();
			System.out.println(bookChapterContent.getContent());
		}

	}

	/**
	 * 根据chapterId获取该章节相应的内容
	 */
	@Test
	public void getAllChapterContents() {
		// TODO Auto-generated method stub
		init();
		List<BookChapterContent> list = trainCourseDao.getAllChapterContents(1);
		Iterator<BookChapterContent> iterator = list.iterator();
		while (iterator.hasNext()) {
			BookChapterContent bookChapterContent = (BookChapterContent) iterator
					.next();
			System.out.println(bookChapterContent.getContentName());
		}
	}

	/**
	 * 更新用户开始时间
	 */
	@Test
	public void updateThisStartTime() {
		// TODO Auto-generated method stub
		init();
		long userId = 1;
		long trainCourseId = 1;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String dateString = dateFormat.format(date);
		trainCourseDao.updateThisStartTime(userId, trainCourseId, dateString);
	}

	/**
	 * 根据userId与trainCourseId获取某一次的MyTrainCourse
	 */
	@Test
	public void getByUsrIdAndTrainCouId() {
		// TODO Auto-generated method stub
		init();
		MyTrainCourse myTrainCourse = trainCourseDao.getByUsrIdAndTrainCouId(1,
				1);
		System.out.println(myTrainCourse.getStartTime() + "..............");
		System.out.println(myTrainCourse.getStatus());
	}
	/**
	 * 更新小节状态
	 */
	@Test
	public void updateThisItem() {
		init();
		trainCourseDao.updateThisItem(1,2,"2015-1-2");
		
	}

	
	/**
	 * 本次学习结果
	 */
	@Test
	public void updateTrainResult() {
		// TODO Auto-generated method stub
		init();
		trainCourseDao.updateTrainResult(1,(float) 10.0,"2010", "2015", 30);
	}

	/**
	 * 计算培训进度
	 */
	@Test
	public void getSchedule() {
		// TODO Auto-generated method stub
		init();
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
		System.out.println(a[1]/sum);
	}
}
