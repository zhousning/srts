package com.srts.information.action;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.srts.common.base.impl.BaseActionImpl;
import com.srts.information.domain.TrainNotice;
import com.srts.information.service.InfoCenterService;
import com.srts.utils.pageUtils.PageBean;

@Controller
@Scope("prototype")
public class InformationCenterAction extends BaseActionImpl<TrainNotice>{
	private static final long serialVersionUID = 1L;
	private TrainNotice trainNotice = new TrainNotice();
	private List<TrainNotice> infos;
	private long id;
	private String noticeAttach;
	
	private int currentPageNum=1;
	private int allPageNum;
	
	@Resource
	private InfoCenterService service;
	public TrainNotice getModel() {
		return null;
	}

	public void prepare() throws Exception {}

	/**
	 * 跳转到inforCenterDisp.jsp
	 * @return
	 */
	public String informationCenterDisp(){
		trainNotice=service.getOneInfo(id);
		return "informationCenterDisp";
	}
	
	/**
	 * 跳转到inforCenterList.jsp
	 * @return
	 */
	public String informationCenterList(){
		return queryByPage();
		//return "informationCenterList";
	}

	public String noticeCommManage(){
		infos=service.getAllInfo();
		int i=infos.size();
		if(i%30==0){
			allPageNum=i/18;
		}else{
			allPageNum=i/18+1;
		}
		infos=service.findAllNoticeInfo(currentPageNum);
		return "informationCenterList";
	}
	

	/**
	 * 
	 * @return
	 */
	public String informationCenterDownload() throws Exception{
		System.out.println(noticeAttach);
		return "informationCenterDownload";
	}
	/**
	 * 附件下载
	 * @return
	 */
	public InputStream getInputStream() throws Exception {
		ServletActionContext.getResponse().setHeader(
				"Content-Disposition",
				"attachment;fileName=" + java.net.URLEncoder.encode(noticeAttach, "UTF-8"));
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/resource/templete/information/notice/" + noticeAttach);
	}
	
	
	public List<TrainNotice> getInfos() {
		return infos;
	}

	public void setInfos(List<TrainNotice> infos) {
		this.infos = infos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TrainNotice getTrainNotice() {
		return trainNotice;
	}

	public void setTrainNotice(TrainNotice trainNotice) {
		this.trainNotice = trainNotice;
	}
	public String getNoticeAttach() {
		return noticeAttach;
	}

	public void setNoticeAttach(String noticeAttach) throws Exception{
		this.noticeAttach =  new String(noticeAttach.getBytes("ISO-8859-1"),"UTF-8");
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
		this.allPageNum=allPageNum;
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
	
	private int offset;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String queryByPage() {
		int pageSize = service.getAllRowCount("from TrainNotice");
		System.out.println(pageSize);
		if (pageSize % 15 == 0) {
			size = pageSize / 15;
		} else {
			size = pageSize / 15 + 1;
		}
		pageBean = service.queryForPage("from TrainNotice order by id desc", 15, page);
		offset=PageBean.countOffset(15, page);
		System.out.println(pageBean);
		return "informationCenterList";
	}
	
}
