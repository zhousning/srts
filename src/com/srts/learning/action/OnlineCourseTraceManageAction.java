package com.srts.learning.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.information.domain.TrainNotice;
import com.srts.knowledge.domain.Book;
import com.srts.learning.po.OnlineCourseTraceManagePo;
import com.srts.learning.po.OnlineCourseTracePo;
import com.srts.learning.service.OnlineCourseTraceManageService;
import com.srts.system.domain.Sys_User;
import com.srts.utils.pageUtils.PaginationUtil;

@Controller
@Scope("prototype")
@SuppressWarnings("deprecation")
public class OnlineCourseTraceManageAction extends BaseActionImpl<Book>{
	private static final long serialVersionUID = 1L;

	@Resource
	private OnlineCourseTraceManageService service; 

	
	private String pageNum ="1";
	private String companyName = null;
	private String majorName = null;
	private String usrName = null;
	private String noticeYear = null;
	private String noticeMonth = null;
	private String noticeTitle = null;
	private List<TrainNotice> notices = new ArrayList<TrainNotice>();
	
	private OnlineCourseTraceManagePo tracePo = new OnlineCourseTraceManagePo();
	
	private List<String> pagationLi = new ArrayList<String>();
	private List<OnlineCourseTracePo> courseTracePoList = new ArrayList<OnlineCourseTracePo>();
	private long pageCount;
	private long userID;
	private String userTraceRecord;
	private String monthTotalEvg;
	private String companyTotalEvg;
	
	public Book getModel() {return null;}
	public void prepare() throws Exception {}

	/**
	 * 跳转到onlineCourseTraceManageList.jsp
	 * @return
	 */
	public String onlineCourseTraceList(){
		if(pageNum==null||pageNum.equals("")){
			pageNum = "1";
		}
		if(noticeYear == null){
			noticeYear = new Date().getYear()+1900+"" ;
		}
		if(noticeMonth == null){
			noticeMonth = new Date().getMonth()+1+"";
		}
		//
		notices = service.getOnlineCourseNoticeTitle(Integer.parseInt(noticeYear));
		//
		PaginationUtil pageUtil = new PaginationUtil();
		Integer totalPage = service.getCourseTraceTotalPages(Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth));
		tracePo.setTraces(service.getCourseTracePoByPage(Integer.parseInt(pageNum), Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth)));
		tracePo.setPageLi(pageUtil.getInitCommPages(totalPage));
		tracePo.setTotalPage(totalPage);
		return "onlineCourseTraceList";
	}
	
	/**
	 * 点击分页标签获得当前页数据
	 * @return
	 */
	
	public String queryCurrentPage(){
		if(pageNum==null||pageNum.equals("")){
			pageNum = "1";
		}
		if(noticeYear == null){
			noticeYear = new Date().getYear()+1900+"" ;
		}
		if(noticeMonth == null){
			noticeMonth = new Date().getMonth()+1+"";
		}
		Integer totalPage = service.getCourseTraceTotalPages(Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth));
		tracePo.setTraces(service.getCourseTracePoByPage(Integer.parseInt(pageNum), Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth)));
		tracePo.setTotalPage(totalPage);
		return "queryCurrentPage";
	}
	
	/**
	 * 向下翻滚，查询下一页的数据
	 * @return
	 */
	public String getCourseTurnAfterPage(){
		if(pageNum==null||pageNum.equals("")){
			pageNum = "1";
		}
		if(noticeYear == null){
			noticeYear = new Date().getYear()+1900+"" ;
		}
		if(noticeMonth == null){
			noticeMonth = new Date().getMonth()+1+"";
		}
		PaginationUtil pageUtil = new PaginationUtil();
		Integer totalPage = service.getCourseTraceTotalPages(Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth));
		tracePo.setTraces(service.getCourseTracePoByPage(Integer.parseInt(pageNum), Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth)));
		tracePo.setPageLi(pageUtil.turnAfterCommPages(totalPage, pageNum));
		tracePo.setTotalPage(totalPage);	
		return "getCourseTurnAfterPage";
	}
	
	/**
	 * 向上翻滚，查询上一页的数据
	 * @return
	 */
	public String getCourseTurnForwardPage(){
		if(pageNum==null||pageNum.equals("")){
			pageNum = "1";
		}
		if(noticeYear == null){
			noticeYear = new Date().getYear()+1900+"" ;
		}
		if(noticeMonth == null){
			noticeMonth = new Date().getMonth()+1+"";
		}
		PaginationUtil pageUtil = new PaginationUtil();
		Integer totalPage = service.getCourseTraceTotalPages(Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth));
		tracePo.setTraces(service.getCourseTracePoByPage(Integer.parseInt(pageNum), Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth)));
		tracePo.setTotalPage(totalPage);
		tracePo.setPageLi(pageUtil.turnForwardCommPages(totalPage, pageNum));
		return "getCourseTurnForwardPage";
	}
	
	/**
	 * 根据条件查询学习记录,并显示分页标签
	 * @return
	 */
	public String queryTraceQueryByOption(){
		PaginationUtil pageUtil = new PaginationUtil();
		Integer totalPage = service.getCourseTraceTotalPages(Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth), usrName, majorName, companyName, noticeTitle);
		tracePo = new OnlineCourseTraceManagePo();
		List<OnlineCourseTracePo> poList = service.getCourseTraceQueryByOptions(Integer.parseInt(pageNum), Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth), usrName, majorName, companyName, noticeTitle);
		
		pagationLi = pageUtil.getInitQboPages(totalPage);
		courseTracePoList = poList;
		pageCount = totalPage;
		//tracePo.setTraces(poList);
		//tracePo.setTotalPage(totalPage);
		//tracePo.setPageLi(pageUtil.getInitQboPages(totalPage));
		return "queryTraceQueryByOption";
	}
	
	/**
	 * 根据条件查询当前页
	 * @return
	 */
	public String queryCurrentPageQBO(){
		if(pageNum==null||pageNum.equals("")){
			pageNum = "1";
		}
		if(noticeYear == null){
			noticeYear = new Date().getYear()+1900+"" ;
		}
		if(noticeMonth == null){
			noticeMonth = new Date().getMonth()+1+"";
		}
		Integer totalPage = service.getCourseTraceTotalPages(Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth), usrName, majorName, companyName, noticeTitle);
		tracePo.setTraces(service.getCourseTraceQueryByOptions(Integer.parseInt(pageNum), Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth), usrName, majorName, companyName, noticeTitle));
		tracePo.setTotalPage(totalPage);
		return "queryCurrentPageQBO";
	}
	
	/**
	 * 根据条件查询，向上翻滚，查询上一页的数据
	 * @return
	 */
	public String courseTurnForwardPageQBO(){
		if(pageNum==null||pageNum.equals("")){
			pageNum = "1";
		}
		if(noticeYear == null){
			noticeYear = new Date().getYear()+1900+"" ;
		}
		if(noticeMonth == null){
			noticeMonth = new Date().getMonth()+1+"";
		}
		PaginationUtil pageUtil = new PaginationUtil();
		Integer totalPage = service.getCourseTraceTotalPages(Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth), usrName, majorName, companyName, noticeTitle);
		tracePo.setTraces(service.getCourseTraceQueryByOptions(Integer.parseInt(pageNum), Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth), usrName, majorName, companyName, noticeTitle));
		tracePo.setTotalPage(totalPage);
		//tracePo.setPageLi(pageUtil.turnForwardCommPages(totalPage, pageNum));
		pagationLi = pageUtil.turnForwardQboPages(totalPage,pageNum);
		return "courseTurnForwardPageQBO";
	}
	
	public String courseTurnAfterPageQBO(){
		if(pageNum==null||pageNum.equals("")){
			pageNum = "1";
		}
		if(noticeYear == null){
			noticeYear = new Date().getYear()+1900+"" ;
		}
		if(noticeMonth == null){
			noticeMonth = new Date().getMonth()+1+"";
		}
		PaginationUtil pageUtil = new PaginationUtil();
		Integer totalPage = service.getCourseTraceTotalPages(Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth), usrName, majorName, companyName, noticeTitle);
		tracePo.setTraces(service.getCourseTraceQueryByOptions(Integer.parseInt(pageNum), Integer.parseInt(noticeYear), Integer.parseInt(noticeMonth), usrName, majorName, companyName, noticeTitle));
		tracePo.setTotalPage(totalPage);
		pagationLi = pageUtil.turnAfterQboPages(totalPage, pageNum);
		//tracePo.setPageLi(pageUtil.turnAfterCommPages(totalPage, pageNum));	
		return "getCourseTurnAfterPageQBO";
	}
	
	/**
	 * 根据年获取trainNotices
	 * @return
	 */
	public String getOnlineCourseNoticeTitle(){
		notices = service.getOnlineCourseNoticeTitle(Integer.parseInt(noticeYear));
		return "getOnlineCourseNoticeTitle";
	}
	
	/**
	 * 单个员工学习记录
	 * @return
	 */
	public String userStudyTraceRecord(){
		userTraceRecord = service.userStudyTraceRecord(userID,Integer.parseInt(noticeYear),Integer.parseInt(noticeMonth),noticeTitle);
		return "userStudyTraceRecord";
	}
	
	/**
	 * 统计各类图标
	 * @return
	 */
	public String studyTraceStatistics(){
		if(noticeYear == null){
			noticeYear = new Date().getYear()+1900+"" ;
		}
		monthTotalEvg = service.getMonthStudyTimeCount(Integer.parseInt(noticeYear));
		return "studyTraceStatistics";
	}

	/**
	 * 跳转到onlneCourseTraceManageDisp.jsp
	 * @return
	 */
	public String onlineCourseTraceDisp(){
		return "onlineCourseTraceDisp";
	}
	
	////////////////////////////////////////////////
	public void setNoticeYear(String noticeYear) {
		this.noticeYear = noticeYear;
	}
	public void setNoticeMonth(String noticeMonth) {
		this.noticeMonth = noticeMonth;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public OnlineCourseTraceManagePo getTracePo() {
		return tracePo;
	}
	public void setTracePo(OnlineCourseTraceManagePo tracePo) {
		this.tracePo = tracePo;
	}
	public void setService(OnlineCourseTraceManageService service) {
		this.service = service;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public List<TrainNotice> getNotices() {
		return notices;
	}
	public List<String> getPagationLi() {
		return pagationLi;
	}
	public void setPagationLi(List<String> pagationLi) {
		this.pagationLi = pagationLi;
	}
	public List<OnlineCourseTracePo> getCourseTracePoList() {
		return courseTracePoList;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserTraceRecord() {
		return userTraceRecord;
	}
	public String getMonthTotalEvg() {
		return monthTotalEvg;
	}
	public String getCompanyTotalEvg() {
		return companyTotalEvg;
	}
	
}
