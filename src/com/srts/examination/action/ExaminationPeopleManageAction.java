package com.srts.examination.action;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.srts.common.base.impl.BaseActionImpl;
import com.srts.examination.domain.TestInfo;
import com.srts.examination.domain.TestPeople;
import com.srts.examination.po.UserPo;
import com.srts.examination.service.TestPeopleService;
import com.srts.system.domain.Sys_Department;
import com.srts.system.domain.Sys_User;

@Controller
@Scope("prototype")
public class ExaminationPeopleManageAction extends BaseActionImpl<TestPeople> {
	private static final long serialVersionUID = 1L;
	private TestPeople testPeople = null;
	private List<Sys_Department> departmentList;
	private List<Sys_User> userList;
	private List<TestInfo> testInfoList;

	private Long[] departmentIds;
	private Long[] candidates;

	private String depSelected;// 已选择的部门
	private String depAndWorkers;// 部门和员工列表
	private String sum;// 当前已选择部门的总人数
	private String selectedCandidates;// 已选择的候选人
	private int counts;// 考试总人数
	private String selectedNum;// 已选择的总人数
	private String nameList;//名单
	private long userId;
	private long testInfoId;

	private UserPo userPo;

	@Resource
	private TestPeopleService testPeopleService;


	// 根据部门id获取本部门的员工信息,并按部门分类显示
	public String findAllWorkers() {
		String[] arr = depSelected.split(",");
		departmentIds = new Long[arr.length];
		for (int i = 0; i < arr.length; i++) {
			departmentIds[i] = Long.parseLong(arr[i]);
		}
		depAndWorkers = testPeopleService.getDepAndWorkers(departmentIds,counts);
		return "allWrokers";
	}

	// 获取已选择的部门的员工总数
	public String findWorkNums() {
		String res = null;
		if (depSelected.equals("")) {
			res = "0";
		} else {
			String[] arr = depSelected.split(",");
			Long[] depIds = new Long[arr.length];
			for (int i = 0; i < depIds.length; i++) {
				depIds[i] = Long.parseLong(arr[i]);
			}
			
			List<Sys_User> workNum = testPeopleService.getWorkNums(depIds);
			res = String.valueOf(workNum.size());
		}
		sum = "{allnum:'" + res + "'}";
		return "workNums";
	}

	//生成名单
	public String createNameList() {
		userList=testPeopleService.createNameList(nameList,testInfoId);
		Iterator<Sys_User> usIterator=userList.iterator();
		while (usIterator.hasNext()) {
			Sys_User sysUser = (Sys_User) usIterator.next();
		}
		return "userList";
	}

	/**
	 * 导出名单
	 * @throws Exception 
	 */
	public String exporNameList() throws Exception{
		List<Sys_User> users=testPeopleService.getTestPeoples(testInfoId);
	
		//System.out.print(users.size());
		int i=1;
		String str=ServletActionContext.getServletContext().getRealPath("/resource/templete/examination/excel");
		File file=new File(str+"\\nameList.xls");
		WritableWorkbook book = Workbook.createWorkbook(file);
		//生成名为“第一页”的工作表，参数0表示这是第一页
		WritableSheet sheet = book.createSheet("第一页 ", 0);
		WritableCellFormat format = new WritableCellFormat();
		format.setAlignment(Alignment.CENTRE);
		//添加标题
		Label label = null;
		label = new Label(0, 0, "序号", format);
		sheet.addCell(label);
		sheet.setColumnView(0, 10);
		label = new Label(1, 0, "姓名", format);
		sheet.addCell(label);
		sheet.setColumnView(1, 25);
		label = new Label(2, 0, "工号", format);
		sheet.addCell(label);	
		sheet.setColumnView(2, 25);
		label = new Label(3, 0, "部门", format);
		sheet.addCell(label);
		sheet.setColumnView(3, 25);
		i=0;
		for(Sys_User user:users){
			label = new Label(0, i + 1, String.valueOf(i+1), format);
			sheet.addCell(label);										
			label = new Label(1, i + 1, user.getName(), format);
			sheet.addCell(label);						
			label = new Label(2, i + 1, user.getWorkno(), format);
			sheet.addCell(label);						
			label = new Label(3, i + 1, user.getDepartment().getName(), format);
			sheet.addCell(label);
			i++;
		}
		book.write();
		book.close();
	
		return "nameList";
	}
	
	public InputStream getInputStream() throws Exception {
		
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/resource/templete/examination/excel/"+"nameList.xls");
	}
	
	public String getDepSelected() {
		return depSelected;
	}

	public void setDepSelected(String depSelected) {
		this.depSelected = depSelected;
	}

	public String getDepAndWorkers() {
		return depAndWorkers;
	}

	public void setDepAndWorkers(String depAndWorkers) {
		this.depAndWorkers = depAndWorkers;
	}

	public TestPeople getTestPeople() {
		return testPeople;
	}

	public Long[] getDepartmentIds() {
		return departmentIds;
	}

	public void setDepartmentIds(Long[] departmentIds) {
		this.departmentIds = departmentIds;
	}

	public Long[] getCandidates() {
		return candidates;
	}

	public void setCandidates(Long[] candidates) {
		this.candidates = candidates;
	}

	public void setTestPeople(TestPeople testPeople) {
		this.testPeople = testPeople;
	}

	public TestPeople getModel() {
		return null;
	}

	public List<Sys_Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Sys_Department> departmentList) {
		this.departmentList = departmentList;
	}

	public UserPo getUserPo() {
		return userPo;
	}

	public void setUserPo(UserPo userPo) {
		this.userPo = userPo;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getSelectedCandidates() {
		return selectedCandidates;
	}

	public void setSelectedCandidates(String selectedCandidates) {
		this.selectedCandidates = selectedCandidates;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public String getSelectedNum() {
		return selectedNum;
	}

	public void setSelectedNum(String selectedNum) {
		this.selectedNum = selectedNum;
	}

	public void prepare() throws Exception {
	}

	public List<TestInfo> getTestInfoList() {
		return testInfoList;
	}

	public void setTestInfoList(List<TestInfo> testInfoList) {
		this.testInfoList = testInfoList;
	}

	public String getNameList() {
		return nameList;
	}

	public void setNameList(String nameList) {
		this.nameList = nameList;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getTestInfoId() {
		return testInfoId;
	}

	public void setTestInfoId(long testInfoId) {
		this.testInfoId = testInfoId;
	}

	public List<Sys_User> getUserList() {
		return userList;
	}

	public void setUserList(List<Sys_User> userList) {
		this.userList = userList;
	}
	
	
	
	
	
	

}
