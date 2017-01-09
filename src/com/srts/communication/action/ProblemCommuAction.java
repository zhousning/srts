package com.srts.communication.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.communication.domain.AnswerAsk;
import com.srts.communication.domain.AnswerInfo;
import com.srts.communication.domain.ProblemAnswerAccept;
import com.srts.communication.domain.ProblemInfo;
import com.srts.communication.po.AnswerInfoAndAnswerAsks;
import com.srts.communication.po.CommonUser;
import com.srts.communication.po.MyOneProblem;
import com.srts.communication.po.ProblemCommDisp;
import com.srts.communication.po.SelfAnswerInfo;
import com.srts.communication.po.SelfProblemInfo;
import com.srts.communication.service.ProblemCommService;
import com.srts.system.domain.Sys_User;
import com.srts.utils.pageUtils.PageBean;

@Controller
@Scope("prototype")
public class ProblemCommuAction extends BaseActionImpl<ProblemInfo> {
	
	@Resource
	private ProblemCommService service;
	private static final long serialVersionUID = 1L;
	private ProblemInfo problemInfo = new ProblemInfo();
	
	private int curPageNum=1;
	
	private ProblemCommDisp problemCommDisp;
	private SelfAnswerInfo selfAnswerInfo;
	private SelfProblemInfo selfProblemInfo;
	private SelfProblemInfo allProblemInfo;
	private Long problemId;
	private Long answerId;
	//我的一个问题的显示
	private MyOneProblem myOneProblem;
	// 对一个问题的回答  
	private AnswerInfo answerInfo;
	//答案
	private String myAnswer;
	//追问
	private String myAsk;
	//排行
	private List<CommonUser> most5ProblemUsers;
	private List<CommonUser> most5AnswerUsers;
	private List<CommonUser> most5AcceptUsers;
	
	
	public ProblemInfo getModel() {
		return null;
	}
	public void prepare() throws Exception {}
	 /**
	  * 保存一个问题的采纳回答
	  */
	public String saveProblemAnswerAccept(){
		AnswerInfo answerInfo=new AnswerInfo(answerId);
		ProblemInfo problemInfo=new ProblemInfo(problemId);
		ProblemAnswerAccept accept=new ProblemAnswerAccept();
		accept.setAccept("提问者采纳");
		accept.setAnswer(answerInfo);
		accept.setProblem(problemInfo);
		service.saveProblemAnswerAccept(accept);
		return "toSelfProblemCommDisp";
	}
	/**
	 * 保存一个追问
	 */
	public String saveMyAsk(){
		AnswerAsk answerAsk=new AnswerAsk();
		answerAsk.setAnswer(new AnswerInfo(answerId));
		answerAsk.setAskContent(myAsk);
		answerAsk.setAskDate(new Date());
		service.saveAnswerAsk(answerAsk);
		return "toSelfProblemCommDisp";
	}
	
	/**
	 * 对一个问题的回复的更新  
	 */
	public String updateMyAnswer(){
		Date date=new Date();
		answerInfo= new AnswerInfo();
		answerInfo.setId(answerId);
		answerInfo.setAnswerDate(date);
		answerInfo.setAnswerContent(myAnswer);
		service.updateAnswerInfo(answerInfo);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		answerInfo.setDate(sdf.format(date));
		return "toSubmitAnswerPage";
	}
	
	/**
	 * 回复一个问题
	 */
	public String submitMyAnswer(){
		Sys_User user=(Sys_User) ActionContext.getContext().getSession().get("user");
		answerInfo=new AnswerInfo();
		answerInfo.setAnswerContent(myAnswer);
		Date date=new Date();
		answerInfo.setAnswerDate(date);
		answerInfo.setProblem(new ProblemInfo(problemId));
		answerInfo.setUsr(user);
		service.addAnswerInfo(answerInfo);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		answerInfo.setDate(sdf.format(date));
		return "toSubmitAnswerPage";
	}
	/**
	 * 我的提问 提交后  跳转到我的问题列表 
	 */
	public String submitSelfAsk(){
		Sys_User sysUser=(Sys_User) ActionContext.getContext().getSession().get("user");
		problemInfo.setUsr(sysUser);
		problemInfo.setPostDate(new Date());
		service.save(problemInfo);
		
		selfProblemInfo=service.findAllMyProblemInfos(sysUser,curPageNum);
		
		return "selfProblemCommList";
	}
	/**
	 * 跳转到问题交流页面
	 * @return
	 */
	public String problemCommList(){
		//allProblemInfo=service.findAllProblemInfos(curPageNum);
		//most5ProblemUsers=service.getProblemCountTop5();
		//most5AnswerUsers=service.getAnswerCountTop5();
		//most5AcceptUsers=service.getAcceptCountTop5();
		//return "problemCommList";
		return queryByPage();
	}
	/**
	 * 跳转到单个问题显示回复页面
	 * @return
	 */
	public String problemCommDisp(){
		Sys_User user=(Sys_User) ActionContext.getContext().getSession().get("user");
		
		problemInfo=service.findProblemInfoById(problemId);
		service.updateProblemInfoViewCount(problemInfo.getViewCount()+1,problemId);
		Set<AnswerInfo> answerInfos=problemInfo.getAnswerInfos();
		Set<AnswerInfo> answerInfoT=new TreeSet<AnswerInfo>();
		problemCommDisp=new ProblemCommDisp();
		answerInfo=null;
		Iterator<AnswerInfo> it=answerInfos.iterator();
		while(it.hasNext()){
			answerInfo= it.next();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			answerInfo.setDate(sdf.format(answerInfo.getAnswerDate()));
			if(answerInfo.getUsr().getId()==user.getId()){
				problemCommDisp.setAnswerInfo(answerInfo);
			}else{
				answerInfoT.add(answerInfo);
			}
			
		}
		
		problemCommDisp.setOtherAnswerInfos(answerInfoT);
		return "problemCommDisp";
	}
	/**
	 * 跳转到我要提问页面
	 * @return
	 */
	public String selfProblemCommAsk(){
		return "selfProblemCommAsk";
	}
	/**
	 * 跳转到我的单个问题处理页面
	 * @return
	 */
	public String selfProblemCommDisp(){
		Sys_User user=(Sys_User) ActionContext.getContext().getSession().get("user");
		
		problemInfo=service.findProblemInfoById(problemId);
		Set<AnswerInfo> answerInfos=new TreeSet<AnswerInfo>(problemInfo.getAnswerInfos());
		
		ProblemAnswerAccept paa=service.findProblemAnswerAcceptByProblemId(problemId);
		//有采纳的答案 
		if(paa!=null){
			
			myOneProblem=new MyOneProblem();
			myOneProblem.setProblemInfo(problemInfo);
			answerInfo=null;
			List<AnswerInfoAndAnswerAsks> answerInfoAndAnswerAskss=new ArrayList<AnswerInfoAndAnswerAsks>();
			AnswerInfoAndAnswerAsks answerInfoAndAnswerAsks;
			List<AnswerAsk> answerAsks;
			Iterator<AnswerInfo> it=answerInfos.iterator();
			while(it.hasNext()){
				answerInfo= it.next();
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				answerInfo.setDate(sdf.format(answerInfo.getAnswerDate()));
				answerAsks=service.findAnswerAskByAnswerInfoId(answerInfo.getId());
				answerInfoAndAnswerAsks=new AnswerInfoAndAnswerAsks();
				answerInfoAndAnswerAsks.setAnswerAsks(answerAsks);
				answerInfoAndAnswerAsks.setAnswerInfo(answerInfo);
				if(answerInfo.getId()==paa.getAnswer().getId()){
					myOneProblem.setAaas(answerInfoAndAnswerAsks);
				}else{
					answerInfoAndAnswerAskss.add(answerInfoAndAnswerAsks);
				}
				
			}
			myOneProblem.setAnswerInfoAndAnswerAsks(answerInfoAndAnswerAskss);
			return "selfProblemCommDispEnd";
			
		}else{
			myOneProblem=new MyOneProblem();
			myOneProblem.setProblemInfo(problemInfo);
			answerInfo=null;
			List<AnswerInfoAndAnswerAsks> answerInfoAndAnswerAskss=new ArrayList<AnswerInfoAndAnswerAsks>();
			AnswerInfoAndAnswerAsks answerInfoAndAnswerAsks;
			List<AnswerAsk> answerAsks;
			Iterator<AnswerInfo> it=answerInfos.iterator();
			while(it.hasNext()){
				answerInfo= it.next();
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				answerInfo.setDate(sdf.format(answerInfo.getAnswerDate()));
				answerAsks=service.findAnswerAskByAnswerInfoId(answerInfo.getId());
				answerInfoAndAnswerAsks=new AnswerInfoAndAnswerAsks();
				answerInfoAndAnswerAsks.setAnswerAsks(answerAsks);
				answerInfoAndAnswerAsks.setAnswerInfo(answerInfo);
				answerInfoAndAnswerAskss.add(answerInfoAndAnswerAsks);
			}
			myOneProblem.setAnswerInfoAndAnswerAsks(answerInfoAndAnswerAskss);
		}
		
		return "selfProblemCommDisp";
	}
	/**
	 * 跳转到我的问题列表
	 * @return
	 */
	public String selfProblemCommList(){
		Sys_User sysUser=(Sys_User) ActionContext.getContext().getSession().get("user");
		selfProblemInfo=service.findAllMyProblemInfos(sysUser,curPageNum);
		selfAnswerInfo=service.findAllMyAnswerInfo(sysUser,curPageNum);
		return "selfProblemCommList";
	}
	public ProblemInfo getProblemInfo() {
		return problemInfo;
	}
	public void setProblemInfo(ProblemInfo problemInfo) {
		this.problemInfo = problemInfo;
	}
	
	public SelfProblemInfo getAllProblemInfo() {
		return allProblemInfo;
	}
	public void setAllProblemInfo(SelfProblemInfo allProblemInfo) {
		this.allProblemInfo = allProblemInfo;
	}
	public Long getProblemId() {
		return problemId;
	}
	public void setProblemId(Long problemId) {
		this.problemId = problemId;
	}
	
	public int getCurPageNum() {
		return curPageNum;
	}
	public void setCurPageNum(int curPageNum) {
		this.curPageNum = curPageNum;
	}
	public String getMyAnswer() {
		return myAnswer;
	}
	public void setMyAnswer(String myAnswer) {
		this.myAnswer = myAnswer;
	}
	public AnswerInfo getAnswerInfo() {
		return answerInfo;
	}
	public void setAnswerInfo(AnswerInfo answerInfo) {
		this.answerInfo = answerInfo;
	}
	public ProblemCommDisp getProblemCommDisp() {
		return problemCommDisp;
	}
	public void setProblemCommDisp(ProblemCommDisp problemCommDisp) {
		this.problemCommDisp = problemCommDisp;
	}
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public SelfProblemInfo getSelfProblemInfo() {
		return selfProblemInfo;
	}
	public void setSelfProblemInfo(SelfProblemInfo selfProblemInfo) {
		this.selfProblemInfo = selfProblemInfo;
	}
	public SelfAnswerInfo getSelfAnswerInfo() {
		return selfAnswerInfo;
	}
	public void setSelfAnswerInfo(SelfAnswerInfo selfAnswerInfo) {
		this.selfAnswerInfo = selfAnswerInfo;
	}
	public MyOneProblem getMyOneProblem() {
		return myOneProblem;
	}
	public void setMyOneProblem(MyOneProblem myOneProblem) {
		this.myOneProblem = myOneProblem;
	}
	public String getMyAsk() {
		return myAsk;
	}
	public void setMyAsk(String myAsk) {
		this.myAsk = myAsk;
	}
	public List<CommonUser> getMost5ProblemUsers() {
		return most5ProblemUsers;
	}
	public void setMost5ProblemUsers(List<CommonUser> most5ProblemUsers) {
		this.most5ProblemUsers = most5ProblemUsers;
	}
	public List<CommonUser> getMost5AnswerUsers() {
		return most5AnswerUsers;
	}
	public void setMost5AnswerUsers(List<CommonUser> most5AnswerUsers) {
		this.most5AnswerUsers = most5AnswerUsers;
	}
	public List<CommonUser> getMost5AcceptUsers() {
		return most5AcceptUsers;
	}
	public void setMost5AcceptUsers(List<CommonUser> most5AcceptUsers) {
		this.most5AcceptUsers = most5AcceptUsers;
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
		most5ProblemUsers=service.getProblemCountTop5();
		most5AnswerUsers=service.getAnswerCountTop5();
		most5AcceptUsers=service.getAcceptCountTop5();
		
		
		int pageSize = service.getAllRowCount("from ProblemInfo");
		System.out.println(pageSize);
		if (pageSize % 1 == 0) {
			size = pageSize / 1;
		} else {
			size = pageSize / 1 + 1;
		}
		pageBean = service.queryForPage("from ProblemInfo order by id desc", 1, page);
		System.out.println(pageBean);
		return "problemCommList";
	}
	
}
