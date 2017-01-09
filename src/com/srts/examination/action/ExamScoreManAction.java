package com.srts.examination.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.srts.common.base.impl.BaseActionImpl;
import com.srts.examination.domain.TestPaper;
import com.srts.examination.domain.UserTestScore;
import com.srts.examination.service.ExamScoreManService;
import com.srts.examination.service.TestPaperService;

@Controller
@Scope("prototype")
public class ExamScoreManAction extends BaseActionImpl<UserTestScore> {

	private long testId;
	private long testPaperId;
	private String paperName;
	private String examName;
	private String examDate;
	private String userName;
	private String depName;
	private String sysmbol;
	private String grade;
	private List<UserTestScore> testScores=new ArrayList<UserTestScore>();
	private List<TestPaper> testPapers=new ArrayList<TestPaper>();

	@Resource
	private ExamScoreManService examScoreManService;
	@Resource
	private TestPaperService paperService;

	// 跳转到试卷页面
	public String examScoreManageList() {
		return "examScoreManageList";
	}

	// 跳转到显示成绩页面
	public String examScoreManageDisp() {
		return "examScoreManageDisp";
	}

	// 按条件查询试卷
	public String findPaperByCon() {
		
		List<TestPaper> list=new ArrayList<TestPaper>();
		if (paperName==null&&examName==null&&examDate==null) {
			list=paperService.findFinishedTestPaper();
		}else {
			list = paperService.findPaperByCon(paperName, examName, examDate);
		}
		
		allRow=list.size();
		if(allRow>0){
			if(allRow%3==0){
				totalPage=allRow/3;
			}else{
				totalPage=allRow/3+1;
			}
			
			for(int i=(page-1)*3; i<page*3&&i<list.size(); i++){
				testPapers.add(list.get(i));
			}
		}else{
			totalPage=1;
		}
		
		return "examScoreManageList";
	}

	// 按条件查询用户考试成绩
	public String findScoreByCon() {
		System.out.println(testPaperId);
		List<UserTestScore> list=new ArrayList<UserTestScore>();
		String con = null;
		
		if (examDate==null&&userName==null&&depName==null&&grade==null) {
			list = examScoreManService.findScoresByTestPaperId(testPaperId);
		}else {
			if (grade != null && !(grade.equals(""))) {
				con = sysmbol + grade;
			}
			list = examScoreManService.findScoresByCon(examDate, userName,
					depName, con, testPaperId);
		}
		allRow=list.size();
		if(allRow>0){
			if(allRow%15==0){
				totalPage=allRow/15;
			}else{
				totalPage=allRow/15+1;
			}
			
			for(int i=(page-1)*15; i<page*15&&i<list.size(); i++){
				testScores.add(list.get(i));
			}
		}else{
			totalPage=1;
		}
		
		return "examScoreManageDisp";
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public long getTestPaperId() {
		return testPaperId;
	}

	public void setTestPaperId(long testPaperId) {
		this.testPaperId = testPaperId;
	}

	public List<UserTestScore> getTestScores() {
		return testScores;
	}

	public void setTestScores(List<UserTestScore> testScores) {
		this.testScores = testScores;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getSysmbol() {
		return sysmbol;
	}

	public void setSysmbol(String sysmbol) {
		this.sysmbol = sysmbol;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<TestPaper> getTestPapers() {
		return testPapers;
	}

	public void setTestPapers(List<TestPaper> testPapers) {
		this.testPapers = testPapers;
	}

	public UserTestScore getModel() {
		return null;
	}

	public void prepare() throws Exception {

	}

	
	
	
	private int page=1;
	private int totalPage;
	private int allRow;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

}
