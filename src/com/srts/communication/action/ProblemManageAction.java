package com.srts.communication.action;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.srts.common.base.impl.BaseActionImpl;
import com.srts.communication.domain.ProblemInfo;
import com.srts.communication.po.AllAnswerInfo;
import com.srts.communication.po.CommUtils;
import com.srts.communication.po.SelfProblemInfo;
import com.srts.communication.service.ProblemCommService;
import com.srts.utils.pageUtils.PageBean;

@Controller
@Scope("prototype")
public class ProblemManageAction extends BaseActionImpl<ProblemInfo>{

	private static final long serialVersionUID = 1L;
	//问题列表
	private SelfProblemInfo problmInfos;
	//回答列表
	private AllAnswerInfo answerInfos;
	//当前页
	private int curPageNumProblem=1;
	private int curPageNumAnswerInfo=1;
	//要删除的问题ID
	private String problemIds;

	@Resource
	private ProblemCommService service;
	public ProblemInfo getModel() {
		return null;
	}
	public void prepare() throws Exception {		
	}
	public String deleteAnswer(){
		String[] nums=problemIds.split(",");
		long id;
		for(int i=0;i<nums.length;i++){
			id=Long.parseLong(nums[i]);
			service.deleteAnswerInfo(id);
		}
		return problemCommManage();
	}
	public String deleteProblem(){
		String[] nums=problemIds.split(",");
		long id;
		for(int i=0;i<nums.length;i++){
			id=Long.parseLong(nums[i]);
			service.deleteProblemInfo(id);
		}
		return problemCommManage();
	}
	
	public String problemCommManage(){
		/*
		problmInfos=service.findAllProblemInfos(curPageNumProblem);
		//问题描述只显示15字
		List<ProblemInfo> ps= problmInfos.getSelfProblemInfos();
		ProblemInfo pi;
		for(int i=0;i<ps.size();i++){
			pi=ps.get(i);
			pi.setDesc(CommUtils.subString(pi.getProblemDesc()));
		}
		answerInfos=service.findAllAnswerInfo(curPageNumAnswerInfo);

		return "problemCommManage";
		*/
		type="question";
		return queryByPage();
	}

	public SelfProblemInfo getProblmInfos() {
		return problmInfos;
	}
	public void setProblmInfos(SelfProblemInfo problmInfos) {
		this.problmInfos = problmInfos;
	}
	public AllAnswerInfo getAnswerInfos() {
		return answerInfos;
	}
	public void setAnswerInfos(AllAnswerInfo answerInfos) {
		this.answerInfos = answerInfos;
	}
	
	public int getCurPageNumProblem() {
		return curPageNumProblem;
	}
	public void setCurPageNumProblem(int curPageNumProblem) {
		this.curPageNumProblem = curPageNumProblem;
	}
	public int getCurPageNumAnswerInfo() {
		return curPageNumAnswerInfo;
	}
	public void setCurPageNumAnswerInfo(int curPageNumAnswerInfo) {
		this.curPageNumAnswerInfo = curPageNumAnswerInfo;
	}
	public String getProblemIds() {
		return problemIds;
	}
	public void setProblemIds(String problemIds) {
		this.problemIds = problemIds;
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

	
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String queryByPage() {
		if(type.equals("question")){
			int pageSize = service.getAllRowCount("from ProblemInfo");
			System.out.println(pageSize);
			if (pageSize % 1 == 0) {
				size = pageSize / 1;
			} else {
				size = pageSize / 1 + 1;
			}
			pageBean = service.queryForPage("from ProblemInfo order by id desc", 1, page);
			System.out.println(pageBean);
			type="question";
		}
		if(type.equals("answer")){
			int pageSize = service.getAllRowCount("from AnswerInfo");
			System.out.println(pageSize);
			if (pageSize % 1 == 0) {
				size = pageSize / 1;
			} else {
				size = pageSize / 1 + 1;
			}
			pageBean = service.queryForPage("from AnswerInfo order by id desc", 1, page);
			System.out.println(pageBean);
			type="answer";
		}
		return "problemCommManage";
	}
	
	
}
