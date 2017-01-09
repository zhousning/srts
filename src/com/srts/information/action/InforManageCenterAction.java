package com.srts.information.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.service.TestInfoManService;
import com.srts.information.domain.TrainNotice;
import com.srts.information.service.InfoCenterService;
import com.srts.system.domain.Sys_User;
import com.srts.utils.pageUtils.PageBean;

@Controller
@Scope("prototype")
public class InforManageCenterAction extends BaseActionImpl<TrainNotice>{
	private static final long serialVersionUID = 1L;
	private TrainNotice trainNotice;
	private List<TrainNotice> infos;
	private Long id;
	private TestInfo testInfo=new TestInfo();
	
	private File upload;
	private String uploadFileName;
	private String savePath;
	
	private String noticeIds;
	private String noticeType;
	
	private int currentPageNum=1;
	private int allPageNum;
	
	@Resource
	private InfoCenterService service;
	@Resource
	private TestInfoManService testInfoService;
	
	public TrainNotice getModel() {
		return null;
	}

	public void prepare() throws Exception {}
	
	/**
	 * 跳转到inforManageCenterDisp.jsp
	 * @return
	 */
	public String inforManageCenterDisp(){
		trainNotice=service.getOneInfo(id);
		return "inforManageCenterDisp";
	}
	
	/**
	 * 跳转到inforManageCenterList.jsp
	 * @return
	 */
	public String inforManageCenterList(){
		System.out.println(allPageNum);
		return queryByPage();
	}
	/**
	 * 跳转到inforManageUploadDisp.jsp
	 * @return
	 */
	public String inforManageUploadDisp(){
		return "inforManageUploadDisp";
	}
	
	/**
	 * 跳转到inforManageUpdateDisp.jsp
	 * @return
	 */
	public String inforManageUpdateDisp(){
		trainNotice=service.getOneInfo(id);
		noticeType=trainNotice.getNoticeType();
		return "inforManageUpdateDisp";
	}

	
	/**
	 *新建通知的方法，跳转到inforManageCenterList.jsp
	 * @return
	 */
	public String inforManageCenterNew() throws Exception{
		 Sys_User user=(Sys_User) ActionContext.getContext().getSession().get("user");
		if(upload==null){
			trainNotice.setNoticeAttach("");
		}else{
			FileInputStream in = new FileInputStream(getUpload());
			FileOutputStream out = new FileOutputStream(getSavePath() + "\\" + getUploadFileName());
			byte[] buffer = new byte[2097152];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			in.close();
			out.close();
			System.out.println(uploadFileName);
			trainNotice.setNoticeAttach(uploadFileName);
		}
		String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		trainNotice.setEstablishDate(date);
		String[] str=date.split("-");
		System.out.println(str[0]);
		trainNotice.setNonticeYear(Integer.parseInt(str[0]));
		trainNotice.setNonticeMonth(Integer.parseInt(str[1]));
		trainNotice.setNonticeDay(Integer.parseInt(str[2]));
		trainNotice.setUser(user);
		trainNotice.setLoadCount(0);
		
		if(trainNotice.getNoticeType().equals("考试通知")){
			String[] hour=testInfo.getTestTime().split(":");
			String[] minute=testInfo.getEndTime().split(":");
			
			testInfo.setTestTimeLength("");
			testInfo.setState("0");
			trainNotice.setTestInfo(testInfo);
		}else{
			testInfo.setState("2");
			trainNotice.setTestInfo(testInfo);
		}
		testInfoService.addTestInfo(testInfo);
		service.addOneInfo(trainNotice);
		infos=service.getAllInfo();
		//upload=null;
		//return "inforManageCenterList";
		page=1;
		
		return queryByPage();
	}
	
	/**
	 *新建通知的方法，跳转到inforManageCenterList.jsp
	 * @return
	 */
	public String inforManageCenterUpdate() throws Exception{
		trainNotice=service.getOneInfo(trainNotice.getId());
		if(upload==null){
			trainNotice.setNoticeAttach(trainNotice.getNoticeAttach());
		}else{
			File file=new File("/resource/templete/information/notice/" + trainNotice.getNoticeAttach());
			file.delete();
			FileInputStream in = new FileInputStream(getUpload());
			FileOutputStream out = new FileOutputStream(getSavePath() + "\\" + getUploadFileName());
			byte[] buffer = new byte[2097152];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			in.close();
			out.close();
			trainNotice.setNoticeAttach(uploadFileName);
		}
		trainNotice.setEstablishDate(trainNotice.getEstablishDate());
		trainNotice.setNonticeYear(trainNotice.getNonticeYear());
		trainNotice.setNonticeMonth(trainNotice.getNonticeMonth());
		trainNotice.setNonticeDay(trainNotice.getNonticeDay());
		trainNotice.setUser(trainNotice.getUser());
		HttpServletRequest request=ServletActionContext.getRequest();
		trainNotice.setNoticeTitle(request.getParameter("trainNotice.noticeTitle"));
		trainNotice.setNoticeType(request.getParameter("trainNotice.noticeType"));
		trainNotice.setNoticeContent(request.getParameter("trainNotice.noticeContent"));
		trainNotice.setAcceptCompany(request.getParameter("trainNotice.acceptCompany"));
		
		if(trainNotice.getNoticeType().equals("考试通知")){
			testInfo=testInfoService.getTestInfoById(trainNotice.getTestInfo().getId());
			testInfo.setTestName(request.getParameter("testInfo.testName"));
			testInfo.setTestDate(request.getParameter("testInfo.testDate"));
			testInfo.setTestTime(request.getParameter("testInfo.testTime"));
			testInfo.setEndTime(request.getParameter("testInfo.endTime"));
			testInfoService.updateTestInfo(testInfo);
		}
		service.updateOneInfo(trainNotice);
		upload=null;
		return queryByPage();
	}
	
	
	
	/**
	 * 删除通知的方法，跳转到inforManageCenterList.jsp
	 * @return
	 */
	public String inforManageCenterDelete() throws Exception{
		String[] nums=noticeIds.split(",");
		long id;
		for(int i=0;i<nums.length;i++){
			id=Long.parseLong(nums[i]);
			service.deleteOneInfo(id);
			trainNotice=service.getOneInfo(id);
			File file=new File("/resource/templete/information/notice/" + trainNotice.getNoticeAttach());
			file.delete();
			System.out.println(id);
		}
		//infos=service.getAllInfo();
		return queryByPage();
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
		return "inforManageCenterList";
	}
	
	public TrainNotice getTrainNotice() {
		return trainNotice;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTrainNotice(TrainNotice trainNotice) {
		this.trainNotice = trainNotice;
	}

	public List<TrainNotice> getInfos() {
		return infos;
	}

	public void setInfos(List<TrainNotice> infos) {
		this.infos = infos;
	}

	public TestInfo getTestInfo() {
		return testInfo;
	}

	public void setTestInfo(TestInfo testInfo) {
		this.testInfo = testInfo;
	}

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

	public String getNoticeIds() {
		return noticeIds;
	}

	public void setNoticeIds(String noticeIds) {
		this.noticeIds = noticeIds;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
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

	public String queryByPage() {
		int pageSize = service.getAllRowCount("from TrainNotice");
		System.out.println(pageSize);
		if (pageSize % 15 == 0) {
			size = pageSize / 15;
		} else {
			size = pageSize / 15 + 1;
		}
		pageBean = service.queryForPage("from TrainNotice order by id desc", 15, page);
		System.out.println(pageBean);
		return "inforManageCenterList";
	}
	
}
