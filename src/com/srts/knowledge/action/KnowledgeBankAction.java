package com.srts.knowledge.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.knowledge.domain.Book;
import com.srts.knowledge.po.ExperienceDispPo;
import com.srts.knowledge.po.KlgBankDispSePo;
import com.srts.knowledge.po.OperateSheetDispPo;
import com.srts.knowledge.po.RuleLearningDispPo;
import com.srts.knowledge.po.TypicalCaseDispPo;
import com.srts.knowledge.po.TypicalViolationDispPo;
import com.srts.knowledge.po.WholeExperiencePo;
import com.srts.knowledge.po.WholeRuleLearningPo;
import com.srts.knowledge.po.WholeTypicalCasePo;
import com.srts.knowledge.po.WholeTypicalViolationPo;
import com.srts.knowledge.po.WorkSheetDispPo;
import com.srts.knowledge.service.KlgBankDispService;
import com.srts.knowledge.service.KlgBankListService;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.UserService;

@Controller
@Scope("prototype")
public class KnowledgeBankAction extends BaseActionImpl<Book>{
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	@Resource
	private KlgBankDispService dispService;
	@Resource
	private KlgBankListService service;
	private Book book = new Book();
	private String klgBankAnalysis;
	private List<ExperienceDispPo> experienceDisp;
	private List<KlgBankDispSePo> klgBankPopDisp;
	private List<KlgBankDispSePo> klgBankFavorDisp;
	private OperateSheetDispPo operateSheetDisp;
	private WorkSheetDispPo workSheetDisp;
	private List<RuleLearningDispPo> ruleLearningDisp;
	private List<TypicalCaseDispPo> typicalCaseDisp;
	private List<TypicalViolationDispPo> typicalViolationDisp;
	private List<WholeRuleLearningPo> ruleLearningInfo;
	private List<WholeTypicalCasePo> typicalCaseInfo;
	private List<WholeTypicalViolationPo> typicalViolationInfo;
	private String searchType;
	private String searchKeyWords;
	private String updateKlgId;
	private String updateResString;
	private List<WholeExperiencePo> expSearchResList;
	private List<WholeRuleLearningPo> ruleSearchResList;
	private List<WholeTypicalCasePo> caseSearchResList;
	private List<WholeTypicalViolationPo> vioSearchResList;
	private String experienceContent;
	private String explaination;
	private String uploadExpResString;
	private String infoId;
	private String infoType;
	private List<String> allPageList;
	private String resNum="0";
	private String curPage="1";
	private String pageAmount="1";
	private String newPage="1";
	private String showPageTip;
	private String tag="1";
	
	
	
	public Book getModel() {
		return null;
	} 
	public void prepare() throws Exception {
		
	}
	
	public String KlgBankAnalysis()
	{
		klgBankAnalysis=service.findSearchnumByMonth();
		return "klgBankAnalysis";
	}
	
	public String UploadExperience()
	{
		//updateDataBase
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		int res=service.insertIntoExperience(experienceContent, explaination, usr);
		if(res==1)
		{
			uploadExpResString="success";
		}
		else
		{
			uploadExpResString="fail";
		}
		return "uploadExperienceRes";
	}
	
	public String KlgSearchByKeyWordsAndType() throws UnsupportedEncodingException
	{
		curPage=newPage;
		showPageTip="show";
		searchKeyWords = java.net.URLDecoder.decode(searchKeyWords,"UTF-8"); 
		searchType = java.net.URLDecoder.decode(searchType,"UTF-8");
		searchKeyWords = java.net.URLDecoder.decode(searchKeyWords,"UTF-8"); 
		searchType = java.net.URLDecoder.decode(searchType,"UTF-8");
		List<String[]> list=service.searchKlgBankByTypeAndKeyWords(searchType,searchKeyWords);
		if(searchType.equals("条文导学")==true)
		{
			ruleSearchResList=new ArrayList<WholeRuleLearningPo>();
			int length=list.size();
			resNum=String.valueOf(length);
			allPageList=new ArrayList<String>();
			int pageNum=0;
			if(length%5==0)
			{
				pageNum=length/5;//一页显示5条
				pageAmount=String.valueOf(pageNum);
			}
			else
			{
				pageNum=length/5+1;//一页显示5条
				pageAmount=String.valueOf(pageNum);
			}
			for(int i=1;i<=pageNum;i++)
			{
				allPageList.add(String.valueOf(i));
			}
			int curStart=(Integer.parseInt(curPage)-1)*5;
			int curEnd=(Integer.parseInt(curPage)*5-1)<(length-1)?(Integer.parseInt(curPage)*5-1):(length-1);
			for(int i=curStart;i<=curEnd;i++)
			{
				WholeRuleLearningPo temp=new WholeRuleLearningPo();
				temp.setId(list.get(i)[0]);
				temp.setBookname(list.get(i)[1]);
				temp.setChaptername(list.get(i)[2]);
				temp.setRoleno(list.get(i)[3]);
				int secLength=list.get(i)[4].length()/2;
				temp.setContentSe(list.get(i)[4].substring(0, secLength)+"......");
				temp.setContent(list.get(i)[4]);
				temp.setPic(list.get(i)[5]);
				temp.setUpdatedate(list.get(i)[6]);
				temp.setUploaddate(list.get(i)[7]);
				temp.setSearchnum(list.get(i)[8]);
				temp.setSerialnumber(String.valueOf(i+1));
				ruleSearchResList.add(temp);
			}
		}
			else if(searchType.equals("典型违章")==true)
			{
				vioSearchResList=new ArrayList<WholeTypicalViolationPo>();
				int length=list.size();
				resNum=String.valueOf(length);
				allPageList=new ArrayList<String>();
				int pageNum=0;
				if(length%5==0)
				{
					pageNum=length/5;//一页显示5条
					pageAmount=String.valueOf(pageNum);
				}
				else
				{
					pageNum=length/5+1;//一页显示5条
					pageAmount=String.valueOf(pageNum);
				}
				for(int i=1;i<=pageNum;i++)
				{
					allPageList.add(String.valueOf(i));
				}
				int curStart=(Integer.parseInt(curPage)-1)*5;
				int curEnd=(Integer.parseInt(curPage)*5-1)<(length-1)?(Integer.parseInt(curPage)*5-1):(length-1);
				for(int i=curStart;i<=curEnd;i++)
				{
					WholeTypicalViolationPo temp=new WholeTypicalViolationPo();
					temp.setId(list.get(i)[0]);
					temp.setTitle(list.get(i)[1]);
					temp.setSearchnum(list.get(i)[2]);
					temp.setContent(list.get(i)[3]);
					temp.setUploaddate(list.get(i)[4]);
					temp.setUpdatedate(list.get(i)[5]);
					temp.setType(list.get(i)[6]);
					temp.setSerialnumber(String.valueOf(i+1));
					vioSearchResList.add(temp);
				}
			}
			else if(searchType.equals("典型案例")==true)
			{
				caseSearchResList=new ArrayList<WholeTypicalCasePo>();
				int length=list.size();
				resNum=String.valueOf(length);
				allPageList=new ArrayList<String>();
				int pageNum=0;
				if(length%5==0)
				{
					pageNum=length/5;//一页显示5条
					pageAmount=String.valueOf(pageNum);
				}
				else
				{
					pageNum=length/5+1;//一页显示5条
					pageAmount=String.valueOf(pageNum);
				}
				for(int i=1;i<=pageNum;i++)
				{
					allPageList.add(String.valueOf(i));
				}
				int curStart=(Integer.parseInt(curPage)-1)*5;
				int curEnd=(Integer.parseInt(curPage)*5-1)<(length-1)?(Integer.parseInt(curPage)*5-1):(length-1);
				for(int i=curStart;i<=curEnd;i++)
				{
					WholeTypicalCasePo temp=new WholeTypicalCasePo();
					temp.setId(list.get(i)[0]);
					temp.setTitle(list.get(i)[1]);
					temp.setSearchnum(list.get(i)[2]);
					temp.setContent(list.get(i)[3]);
					temp.setUploaddate(list.get(i)[4]);
					temp.setUpdatedate(list.get(i)[5]);
					temp.setType(list.get(i)[6]);
					temp.setSerialnumber(String.valueOf(i+1));
					temp.setPic(list.get(i)[7]);
					caseSearchResList.add(temp);
				}
			}
			else if(searchType.equals("操作经验")==true)
			{
				expSearchResList=new ArrayList<WholeExperiencePo>();
				int length=list.size();
				resNum=String.valueOf(length);
				allPageList=new ArrayList<String>();
				int pageNum=0;
				if(length%5==0)
				{
					pageNum=length/5;//一页显示5条
					pageAmount=String.valueOf(pageNum);
				}
				else
				{
					pageNum=length/5+1;//一页显示5条
					pageAmount=String.valueOf(pageNum);
				}
				for(int i=1;i<=pageNum;i++)
				{
					allPageList.add(String.valueOf(i));
				}
				int curStart=(Integer.parseInt(curPage)-1)*5;
				int curEnd=(Integer.parseInt(curPage)*5-1)<(length-1)?(Integer.parseInt(curPage)*5-1):(length-1);
				System.out.println(curStart);
				System.out.println(curEnd);
				System.out.println(resNum);
				for(int i=curStart;i<=curEnd;i++)
				{
					WholeExperiencePo temp=new WholeExperiencePo();
					temp.setId(list.get(i)[0]);
					temp.setContent(list.get(i)[1]);
					temp.setStatement(list.get(i)[2]);
					temp.setExplaination(list.get(i)[3]);
					temp.setContentSe(list.get(i)[1]);
					temp.setUploaddate(list.get(i)[4]);
					temp.setUpdatedate(list.get(i)[5]);
					temp.setCheckeddate(list.get(i)[6]);
					temp.setSerialnumber(String.valueOf(i+1));
					Sys_User usr=userService.getUserById(Long.valueOf(list.get(i)[7]));
					temp.setSearchnum(list.get(i)[8]);
					String user=usr.getName();
					temp.setUser(user);
					expSearchResList.add(temp);
				}
			}
		return "knowledgeBankDisp";
	}
	
	public String UpdateSearchRecord() throws UnsupportedEncodingException
	{
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		long id=Long.parseLong(updateKlgId);
		searchType = java.net.URLDecoder.decode(searchType,"UTF-8");
		searchType = java.net.URLDecoder.decode(searchType,"UTF-8");
		int res=dispService.viewSearchContent(searchType, usr, id);
		if(res==1)
		{
			updateResString="success";
		}
		else
		{
			updateResString="fail";
		}
		return "updateKlgSearchRes";
	}
	/**
	 * 跳转到klgBankDisp.jsp
	 * @return
	 */
	public String knowledgeBankDisp(){
		return "knowledgeBankDisp";
	}
	/**
	 * 跳转到klgBankList.jsp
	 * @return
	 */
	public String knowledgeBankList(){
		Sys_User usr = (Sys_User) ActionContext.getContext().getSession().get("user");
		List<String[]> res0 = service.findFavorRuleByUser(usr);
		//res0=service.findFavorRuleByUser(user);
		int length0 = res0.size();
		klgBankFavorDisp = new ArrayList<KlgBankDispSePo>();
		for(int i=0;i<length0;i++){
			KlgBankDispSePo temp =new KlgBankDispSePo();
			String id=res0.get(i)[1];
			String type="条文导学";
			int secLength=res0.get(i)[5].length()/2;
			temp.setContentSe(res0.get(i)[5].substring(0, secLength)+"......");
			String lastUpdateDate=res0.get(i)[7];
            temp.setId(id);
            temp.setLastUpdateDate(lastUpdateDate);
            temp.setType(type);
            klgBankFavorDisp.add(temp);
		}
		List<String[]> res1 = service.findPopKlgBank();
		//res1=service.findPopKlgBank();
		int length1 = res1.size();
		klgBankPopDisp = new ArrayList<KlgBankDispSePo>();
		for(int i=0;i<length1;i++){
			KlgBankDispSePo temp =new KlgBankDispSePo();
			String id=res1.get(i)[3];
			String type=res1.get(i)[0];
			int secLength=res1.get(i)[1].length()/2;
			String contentSe=res1.get(i)[1].substring(0, secLength)+"......";
			String lastUpdateDate=res1.get(i)[2];
            temp.setContentSe(contentSe);
            temp.setId(id);
            temp.setLastUpdateDate(lastUpdateDate);
            temp.setType(type);
            klgBankPopDisp.add(temp);
		}
		List<String[]> res2 = service.listTopFiveRule();
		//res2=service.listTopFiveRule();
		int length2 = res2.size();
		ruleLearningDisp = new ArrayList<RuleLearningDispPo>();
		for(int i=0;i<length2;i++){
			RuleLearningDispPo temp =new RuleLearningDispPo();
			String id=res2.get(i)[0];
			String bookname=res2.get(i)[1];
			String chaptername=res2.get(i)[2];
			String ruleno=res2.get(i)[3];
			String content=res2.get(i)[4];
            temp.setId(id);
            temp.setBookname(bookname);
            temp.setChaptername(chaptername);
            temp.setRuleno(ruleno);
            temp.setContent(content);
            ruleLearningDisp.add(temp);
		}
		List<String[]> res3 = service.listTopFiveViolation();
		//res3=service.listTopFiveViolation();
		int length3 = res3.size();
		typicalViolationDisp = new ArrayList<TypicalViolationDispPo>();
		for(int i=0;i<length3;i++){
			TypicalViolationDispPo temp =new TypicalViolationDispPo();
			String id=res3.get(i)[0];
			String content=res3.get(i)[3];
            temp.setId(id);
            temp.setContent(content);
            typicalViolationDisp.add(temp);
		}
		List<String[]> res4 = service.listTopThreeExperience();
		//res4=service.listTopThreeExperience();
		int length4 = res4.size();
		experienceDisp = new ArrayList<ExperienceDispPo>();
		for(int i=0;i<length4;i++){
			ExperienceDispPo temp =new ExperienceDispPo();
			String id=res4.get(i)[0];
			String content=res4.get(i)[1];
            temp.setId(id);
            temp.setContent(content);
            experienceDisp.add(temp);
		}
		List<String[]> res5 = service.listTopOneCase();
		//res5=service.listTopOneCase();
		int length5 = res5.size();
		typicalCaseDisp = new ArrayList<TypicalCaseDispPo>();
		for(int i=0;i<length5;i++){
			TypicalCaseDispPo temp=new TypicalCaseDispPo();
			String id=res5.get(i)[0];
			String content=res5.get(i)[3];
			String title =res5.get(i)[1];
			String date=res5.get(i)[4];
			temp.setId(id);
			temp.setTitle(title);
			temp.setContent(content);
			temp.setDate(date);
			typicalCaseDisp.add(temp);
		}
		return "knowledgeBankList";
	}
	
	public String ShowAllInfo() throws UnsupportedEncodingException
	{
		showPageTip="hide";
		infoId = java.net.URLDecoder.decode(infoId,"UTF-8"); 
		infoType = java.net.URLDecoder.decode(infoType,"UTF-8");
		infoId = java.net.URLDecoder.decode(infoId,"UTF-8"); 
		infoType = java.net.URLDecoder.decode(infoType,"UTF-8");
		List<String[]> res=service.showAllInfo(infoId, infoType);
		ruleLearningInfo=new ArrayList<WholeRuleLearningPo>();
		typicalCaseInfo=new ArrayList<WholeTypicalCasePo>();
		typicalViolationInfo=new ArrayList<WholeTypicalViolationPo>();
		int length=res.size();
		for(int i=0;i<length;i++){
			if(infoType.equals("典型案例"))
			{
			WholeTypicalCasePo temp=new WholeTypicalCasePo();
			String id=res.get(i)[0];
			String title=res.get(i)[1];
			String content =res.get(i)[3];
			String type=res.get(i)[6];
			String searchnum=res.get(i)[2];
			String uploaddate=res.get(i)[4];
			String updatedate=res.get(i)[5];
			String pic=res.get(i)[7];
			temp.setId(id);
			temp.setTitle(title);
			temp.setContent(content);
			temp.setSearchnum(searchnum);
			temp.setUpdatedate(updatedate);
			temp.setUploaddate(uploaddate);
			temp.setType(type);
			temp.setSerialnumber("1");
			temp.setPic(pic);
			searchType="典型案例";
			typicalCaseInfo.add(temp);
		}
			else if(infoType.equals("条文导学"))
			{
				WholeRuleLearningPo temp=new WholeRuleLearningPo();
				String id=res.get(i)[0];
				String bookname=res.get(i)[1];
				String chaptername =res.get(i)[2];
				String roleno=res.get(i)[3];
				String content=res.get(i)[4];
				String pic=res.get(i)[5];
				String updatedate=res.get(i)[6];
				String uploaddate=res.get(i)[7];
				String searchnum=res.get(i)[8];
				String contentSe=res.get(i)[4].substring(0, res.get(i)[4].length()/2)+"......";
				temp.setContentSe(contentSe);
				temp.setId(id);
				temp.setBookname(bookname);
				temp.setChaptername(chaptername);
				temp.setContent(content);
				temp.setSearchnum(searchnum);
				temp.setUpdatedate(updatedate);
				temp.setUploaddate(uploaddate);
				temp.setPic(pic);
				temp.setRoleno(roleno);
				temp.setSerialnumber("1");
				searchType="条文导学";
				ruleLearningInfo.add(temp);
			}else if(infoType.equals("典型违章"))
			{
				WholeTypicalViolationPo temp=new WholeTypicalViolationPo();
				String id=res.get(i)[0];
				String title=res.get(i)[1];
				String content =res.get(i)[3];
				String type=res.get(i)[6];
				String searchnum=res.get(i)[2];
				String uploaddate=res.get(i)[4];
				String updatedate=res.get(i)[5];
				temp.setId(id);
				temp.setTitle(title);
				temp.setContent(content);
				temp.setSearchnum(searchnum);
				temp.setUpdatedate(updatedate);
				temp.setUploaddate(uploaddate);
				temp.setType(type);
				temp.setSerialnumber("1");
				searchType="典型违章";
				typicalViolationInfo.add(temp);
			}
		}
		return "knowledgeBankDisp";
	}
	public String ChangeCurrentPage()
	{
		curPage=newPage;
		
		return "knowledgeBankDisp";
	}
	
	
	/*
	 * getter and setters*/
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getKlgBankAnalysis() {
		return klgBankAnalysis;
	}
	public void setKlgBankAnalysis(String klgBankAnalysis) {
		this.klgBankAnalysis = klgBankAnalysis;
	}
	public List<ExperienceDispPo> getExperienceDisp() {
		return experienceDisp;
	}
	public void setExperienceDisp(List<ExperienceDispPo> experienceDisp) {
		this.experienceDisp = experienceDisp;
	}
	public OperateSheetDispPo getOperateSheetDisp() {
		return operateSheetDisp;
	}
	public void setOperateSheetDisp(OperateSheetDispPo operateSheetDisp) {
		this.operateSheetDisp = operateSheetDisp;
	}
	public WorkSheetDispPo getWorkSheetDisp() {
		return workSheetDisp;
	}
	public void setWorkSheetDisp(WorkSheetDispPo workSheetDisp) {
		this.workSheetDisp = workSheetDisp;
	}
	public List<RuleLearningDispPo> getRuleLearningDisp() {
		return ruleLearningDisp;
	}
	public void setRuleLearningDisp(List<RuleLearningDispPo> ruleLearningDisp) {
		this.ruleLearningDisp = ruleLearningDisp;
	}
	public List<TypicalCaseDispPo> getTypicalCaseDisp() {
		return typicalCaseDisp;
	}
	public void setTypicalCaseDisp(List<TypicalCaseDispPo> typicalCaseDisp) {
		this.typicalCaseDisp = typicalCaseDisp;
	}
	public List<TypicalViolationDispPo> getTypicalViolationDisp() {
		return typicalViolationDisp;
	}
	public void setTypicalViolationDisp(
			List<TypicalViolationDispPo> typicalViolationDisp) {
		this.typicalViolationDisp = typicalViolationDisp;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchKeyWords() {
		return searchKeyWords;
	}
	public void setSearchKeyWords(String searchKeyWords) {
		this.searchKeyWords = searchKeyWords;
	}
	public String getExperienceContent() {
		return experienceContent;
	}
	public void setExperienceContent(String experienceContent) {
		this.experienceContent = experienceContent;
	}
	public String getExplaination() {
		return explaination;
	}
	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}
	public List<KlgBankDispSePo> getKlgBankPopDisp() {
		return klgBankPopDisp;
	}
	public void setKlgBankPopDisp(List<KlgBankDispSePo> klgBankPopDisp) {
		this.klgBankPopDisp = klgBankPopDisp;
	}
	public List<KlgBankDispSePo> getKlgBankFavorDisp() {
		return klgBankFavorDisp;
	}
	public void setKlgBankFavorDisp(List<KlgBankDispSePo> klgBankFavorDisp) {
		this.klgBankFavorDisp = klgBankFavorDisp;
	}
	public String getUploadExpResString() {
		return uploadExpResString;
	}
	public void setUploadExpResString(String uploadExpResString) {
		this.uploadExpResString = uploadExpResString;
	}
	public List<WholeExperiencePo> getExpSearchResList() {
		return expSearchResList;
	}
	public void setExpSearchResList(List<WholeExperiencePo> expSearchResList) {
		this.expSearchResList = expSearchResList;
	}
	public List<WholeRuleLearningPo> getRuleSearchResList() {
		return ruleSearchResList;
	}
	public void setRuleSearchResList(List<WholeRuleLearningPo> ruleSearchResList) {
		this.ruleSearchResList = ruleSearchResList;
	}
	public List<WholeTypicalCasePo> getCaseSearchResList() {
		return caseSearchResList;
	}
	public void setCaseSearchResList(List<WholeTypicalCasePo> caseSearchResList) {
		this.caseSearchResList = caseSearchResList;
	}
	public List<WholeTypicalViolationPo> getVioSearchResList() {
		return vioSearchResList;
	}
	public void setVioSearchResList(List<WholeTypicalViolationPo> vioSearchResList) {
		this.vioSearchResList = vioSearchResList;
	}
	public String getUpdateKlgId() {
		return updateKlgId;
	}
	public void setUpdateKlgId(String updateKlgId) {
		this.updateKlgId = updateKlgId;
	}
	public String getUpdateResString() {
		return updateResString;
	}
	public void setUpdateResString(String updateResString) {
		this.updateResString = updateResString;
	}
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getInfoType() {
		return infoType;
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public List<WholeRuleLearningPo> getRuleLearningInfo() {
		return ruleLearningInfo;
	}
	public void setRuleLearningInfo(List<WholeRuleLearningPo> ruleLearningInfo) {
		this.ruleLearningInfo = ruleLearningInfo;
	}
	public List<WholeTypicalCasePo> getTypicalCaseInfo() {
		return typicalCaseInfo;
	}
	public void setTypicalCaseInfo(List<WholeTypicalCasePo> typicalCaseInfo) {
		this.typicalCaseInfo = typicalCaseInfo;
	}
	public List<WholeTypicalViolationPo> getTypicalViolationInfo() {
		return typicalViolationInfo;
	}
	public void setTypicalViolationInfo(
			List<WholeTypicalViolationPo> typicalViolationInfo) {
		this.typicalViolationInfo = typicalViolationInfo;
	}
	public List<String> getAllPageList() {
		return allPageList;
	}
	public void setAllPageList(List<String> allPageList) {
		this.allPageList = allPageList;
	}
	public String getCurPage() {
		return curPage;
	}
	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}
	public String getResNum() {
		return resNum;
	}
	public void setResNum(String resNum) {
		this.resNum = resNum;
	}
	public String getPageAmount() {
		return pageAmount;
	}
	public void setPageAmount(String pageAmount) {
		this.pageAmount = pageAmount;
	}
	public String getNewPage() {
		return newPage;
	}
	public void setNewPage(String newPage) {
		this.newPage = newPage;
	}
	public String getShowPageTip() {
		return showPageTip;
	}
	public void setShowPageTip(String showPageTip) {
		this.showPageTip = showPageTip;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	
	
}
