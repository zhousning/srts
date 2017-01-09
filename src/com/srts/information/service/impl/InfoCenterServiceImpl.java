package com.srts.information.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.information.dao.TrainNoticeDao;
import com.srts.information.domain.TrainNotice;
import com.srts.information.service.InfoCenterService;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.domain.OnlineCoursePPT;
import com.srts.knowledge.domain.OnlineCourseVideo;
import com.srts.utils.pageUtils.PageBean;


@Service
public class InfoCenterServiceImpl implements InfoCenterService {
	@Resource
	private TrainNoticeDao trainNoticeDao;

	public List<TrainNotice> getAllInfo() {
		return trainNoticeDao.getAllInfo();
	}
	public TrainNotice getOneInfo(long id) {
		return trainNoticeDao.getById(id);
	}
	
	public void addOneInfo(TrainNotice trainNotice) {
		// TODO Auto-generated method stub
		trainNoticeDao.addOneInfo(trainNotice);
		if (trainNotice.getNoticeType().equals("培训通知")) {
			List<TrainNotice> list = trainNoticeDao.findAll();
			trainNoticeDao.addTrain(list.get(list.size() - 1).getId());
		}
	}
	public void updateOneInfo(TrainNotice trainNotice) {
		// TODO Auto-generated method stub
		trainNoticeDao.updateOneInfo(trainNotice);
	}
	public void deleteOneInfo(Long id) {
		// TODO Auto-generated method stub
		trainNoticeDao.deleteOneInfo(id);
	}
	public List<TrainNotice> findAllNoticeInfo(int currentPageNum) {
		// TODO Auto-generated method stub
		return trainNoticeDao.findAllNoticeInfo(currentPageNum);
	}
	public List<OnlineCoursePPT> getAllPPT() {
		// TODO Auto-generated method stub
		return trainNoticeDao.getAllPPT();
	}
	public List<OnlineCourseVideo> getAllVideo() {
		// TODO Auto-generated method stub
		return trainNoticeDao.getAllVideo();
	}
	public List<OnlineCoursePPT> getTop5PPT() {
		// TODO Auto-generated method stub
		return trainNoticeDao.getTop5PPT();
	}
	public List<OnlineCourseVideo> getTop5Video() {
		// TODO Auto-generated method stub
		return trainNoticeDao.getTop5Video();
	}
	public OnlineCoursePPT getPPTById(Long id) {
		// TODO Auto-generated method stub
		return trainNoticeDao.getPPTById(id);
	}
	public void updatePPT(OnlineCoursePPT ppt) {
		// TODO Auto-generated method stub
		trainNoticeDao.updatePPT(ppt);
	}
	public OnlineCourseVideo getVideoById(Long id) {
		// TODO Auto-generated method stub
		return trainNoticeDao.getVideoById(id);
	}
	public void updateVideo(OnlineCourseVideo video) {
		// TODO Auto-generated method stub
		trainNoticeDao.updateVideo(video);
	}
	public List<OnlineCoursePPT> findAllPPT(int currentPageNum) {
		// TODO Auto-generated method stub
		return trainNoticeDao.findAllPPT(currentPageNum);
	}
	public List<OnlineCourseVideo> findAllVideo(int currentPageNum) {
		// TODO Auto-generated method stub
		return trainNoticeDao.findAllVideo(currentPageNum);
	}
	public List<Book> findAllBook(int currentPageNum) {
		// TODO Auto-generated method stub
		return trainNoticeDao.findAllBook(currentPageNum);
	}
	public List<TrainNotice> findAllNotice(int currentPageNum) {
		// TODO Auto-generated method stub
		return trainNoticeDao.findAllNotice(currentPageNum);
	}
	public Book getBookById(Long id) {
		// TODO Auto-generated method stub
		return trainNoticeDao.getBookById(id);
	}
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		trainNoticeDao.updateBook(book);
	}
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return trainNoticeDao.getAllBook();
	}
	public List<Book> getTop5Book() {
		// TODO Auto-generated method stub
		return trainNoticeDao.getTop5Book();
	}
	public List<TrainNotice> getAllNotice() {
		// TODO Auto-generated method stub
		return trainNoticeDao.getAllNotice();
	}
	public List<TrainNotice> getTop5Notice() {
		// TODO Auto-generated method stub
		return trainNoticeDao.getTop5Notice();
	}
	
	
	public PageBean queryForPage(String hql, int pageSize,int page){

		int allRow = trainNoticeDao.getAllRowCount(hql);//总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, page);//当前页开始记录
		final int length = pageSize;//每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List list = trainNoticeDao.queryForPage(hql, offset, length);//"一页"的记录

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
			return trainNoticeDao.getAllRowCount(hql);
		}
	
}
