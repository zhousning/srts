package com.srts.communication.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.communication.domain.BBSArtical;
import com.srts.communication.domain.BBSArticalReply;
import com.srts.communication.domain.BBSModel;
import com.srts.communication.domain.BBSReplyReply;
import com.srts.communication.po.ArticalTop3;
import com.srts.communication.po.BBSModelInfo;
import com.srts.communication.po.ComArtical;
import com.srts.communication.po.MonthTop;
import com.srts.communication.po.OneBBSArticalReply;
import com.srts.communication.po.OneBBSArticalShow;
import com.srts.communication.po.ReplyContent;
import com.srts.communication.service.BBSCommService;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.UserService;

@Controller
@Scope("prototype")
public class OnlineForumAction extends BaseActionImpl<BBSModel>{
	
	private static final long serialVersionUID = 1L;
	private BBSModel model = new BBSModel();
	@Resource
	private BBSCommService service;
	@Resource
	private UserService userService;
	//我的帖子
	private ComArtical myArtical;
	/**
	 * 发帖排行 3个最多发帖的人
	 */
	private ArrayList<ArticalTop3> articalTop3;
	/**
	 * 模块信息展示
	 */
	private ArrayList<BBSModelInfo> bbsModelInfos;
	/**
	 * 上月专区达人（模块分类下发帖最多者）
	 */
	private ArrayList<MonthTop> monthTops;
	//当前页
	private int curPage=1;
	
	//首页onlineForumModelList 帖子展示
	private ComArtical hotBBSArtical;//热门动态
	private ComArtical newBBSArtical;//最新动态
	private int curHotPage=1;
	private int curNewPage=1;
	//模块列表
	private List<BBSModel> models;
	//模块ID
	private long  bbsModelid;
	//帖子ID
	private long articalId;
	//帖子标题
	private String articalTile;
	//帖子内容
	private String articalContent;
	//回帖内容
	private String replyContent;
	//帖子回复者
	private long userId;
	//帖子 显示
	private OneBBSArticalShow  oneBBSArticalShow;
	
	//我回复的
	ArrayList<ReplyContent> myReplyContents;
	//回复我的
	ArrayList<ReplyContent> hisReplyContents;
	
	public BBSModel getModel() {
		return null;
	}
	public void prepare() throws Exception {}
	/**
	 * 提交对一个帖子回复的回复
	 * 保存  BBSReply
	 */
	public String submitArticalReplyReply(){
		Sys_User curUser=(Sys_User) ActionContext.getContext().getSession().get("user");
		
		Sys_User replyUser=new Sys_User();
		replyUser.setId(userId);
		
		BBSReplyReply b=new BBSReplyReply();
		BBSArticalReply a=new BBSArticalReply();
		a.setId(articalId);
		b.setArticalReply(a);
		b.setRelayDate(new Date());
		b.setReplyContent(replyContent);
		b.setUsr(curUser);
		b.setUsrReply(replyUser);
		service.save(b);
		return "rePlayReplay";
	}
	/**
	 * 提交对一个帖子的回复
	 * 传入：1，帖子Id 2,回复信息
	 * 跳转到onlineForumModelDisp.jsp
	 */
	public String submitArticalReply(){
		service.updateBBSArticalReplyCount(articalId);
		Sys_User user=(Sys_User) ActionContext.getContext().getSession().get("user");
		
		BBSArticalReply reply=new BBSArticalReply();
		reply.setArtical(new BBSArtical(articalId));
		reply.setRelayDate(new Date());
		reply.setReplyContent(replyContent);
		reply.setUsr(user);
		service.save(reply);
		
		return "toOnlineForumModelDisp";
	}
	/**
	 * 跳转到onlineForumModelList.jsp
	 * @return
	 */
	public String onlineForumModelList(){
		//上月专区达人
		monthTops=service.getMonthTop();
		
		
		//贴吧模块信息展示
		bbsModelInfos=service.getBBSModelInfos();
		
		//发帖排名
		articalTop3=service.getArticalTop3();
		ArticalTop3 at;
		for(int i=0;i<articalTop3.size();i++){
			at=articalTop3.get(i);
			at.setName(userService.getUserById(Long.valueOf(at.getName())).getName());
		}
		//热门动态 
		hotBBSArtical=service.getHotArtical(curHotPage);
		//最新动态
		newBBSArtical=service.getNewArtical(curNewPage);
		return "onlineForumModelList";
	}
	/**
	 * 跳转到onlineForumModelDisp.jsp
	 * @return
	 */
	public String onlineForumModelDisp(){
		oneBBSArticalShow=new OneBBSArticalShow();
		BBSArtical bbsArtical=service.getOneBBSArticalById(articalId);
		service.updateBBSArticalViewCount(articalId,bbsArtical.getViewCount()+1);
		oneBBSArticalShow.setArtical(bbsArtical);
		List<BBSArticalReply> replys=service.getBBSArticalReplyByArticalId(articalId);
		List<OneBBSArticalReply> articalReply=new ArrayList<OneBBSArticalReply>();
		OneBBSArticalReply oneBBSArticalReply ;
		List<BBSReplyReply> rr;
		for(int i=0;i<replys.size();i++){
			oneBBSArticalReply =new OneBBSArticalReply();
			BBSArticalReply b= replys.get(i);
			oneBBSArticalReply.setBbsArticalRePly(b);
			rr=service .getBBSReplyReplyByArticalReplyId(b.getId());
			oneBBSArticalReply.setBbsReplyReplies(rr);
			articalReply.add(oneBBSArticalReply);
		}
		oneBBSArticalShow.setReplys(articalReply);
		return "onlineForumModelDisp";
	}
	/**
	 * 跳转到myOnlineArticalList.jsp
	 * @return
	 */
	public String myOnlineArticalList(){
		return "myOnlineArticalList";
	}
	/**
	 * 跳转到myOnlineArticalDisp.jsp
	 * @return
	 */
	public String myOnlineArticalDisp(){
		Sys_User usr=(Sys_User) ActionContext.getContext().getSession().get("user");
		myArtical=service.getMyArticals(usr,curPage);
		//我回复别人的数据
		myReplyContents=service.getMyReplyContents(usr.getId());
		//别人回复我的数据
		hisReplyContents=service.getHisReplyContents(usr.getId());
		return "myOnlineArticalDisp";
	}
	/**
	 * 跳转到myOnlineArticalPost.jsp
	 * @return
	 */
	public String toMyOnlineArticalPost(){
		models=service.findAllBBSModels();
		return "toMyOnlineArticalPost";
	}
	/**
	 * 时间：2014-7-19下午05:25:47
	 * 功能：发帖 提交
	 * 返回类型：String
	 */
	public String myOnlineArticalPost(){
		Sys_User user=(Sys_User) ActionContext.getContext().getSession().get("user");
		BBSArtical ba=new BBSArtical();
		ba.setArticalContent(articalContent);
		ba.setArticalTile(articalTile);
		model.setId(bbsModelid);
		//更新帖子数量
		service.updateModelArticalNum(bbsModelid);
		ba.setModel(model);
		ba.setUsr(user);
		ba.setArticalDate(new Date());
		service.save(ba);
		models=service.findAllBBSModels();
		return "myOnlineArticalPost";
	}
	public List<BBSModel> getModels() {
		return models;
	}
	public void setModels(List<BBSModel> models) {
		this.models = models;
	}
	public void setModel(BBSModel model) {
		this.model = model;
	}
	
	public long getBbsModelid() {
		return bbsModelid;
	}
	public void setBbsModelid(long bbsModelid) {
		this.bbsModelid = bbsModelid;
	}
	public String getArticalTile() {
		return articalTile;
	}
	public void setArticalTile(String articalTile) {
		this.articalTile = articalTile;
	}
	public String getArticalContent() {
		return articalContent;
	}
	public void setArticalContent(String articalContent) {
		this.articalContent = articalContent;
	}
	
	public ComArtical getHotBBSArtical() {
		return hotBBSArtical;
	}
	public void setHotBBSArtical(ComArtical hotBBSArtical) {
		this.hotBBSArtical = hotBBSArtical;
	}
	public ComArtical getNewBBSArtical() {
		return newBBSArtical;
	}
	public void setNewBBSArtical(ComArtical newBBSArtical) {
		this.newBBSArtical = newBBSArtical;
	}
	public int getCurHotPage() {
		return curHotPage;
	}
	public void setCurHotPage(int curHotPage) {
		this.curHotPage = curHotPage;
	}
	public int getCurNewPage() {
		return curNewPage;
	}
	public void setCurNewPage(int curNewPage) {
		this.curNewPage = curNewPage;
	}
	public long getArticalId() {
		return articalId;
	}
	public void setArticalId(long articalId) {
		this.articalId = articalId;
	}
	public ComArtical getMyArtical() {
		return myArtical;
	}
	public void setMyArtical(ComArtical myArtical) {
		this.myArtical = myArtical;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public OneBBSArticalShow getOneBBSArticalShow() {
		return oneBBSArticalShow;
	}
	public void setOneBBSArticalShow(OneBBSArticalShow oneBBSArticalShow) {
		this.oneBBSArticalShow = oneBBSArticalShow;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public ArrayList<ArticalTop3> getArticalTop3() {
		return articalTop3;
	}
	public void setArticalTop3(ArrayList<ArticalTop3> articalTop3) {
		this.articalTop3 = articalTop3;
	}
	public ArrayList<BBSModelInfo> getBbsModelInfos() {
		return bbsModelInfos;
	}
	public void setBbsModelInfos(ArrayList<BBSModelInfo> bbsModelInfos) {
		this.bbsModelInfos = bbsModelInfos;
	}
	public ArrayList<MonthTop> getMonthTops() {
		return monthTops;
	}
	public void setMonthTops(ArrayList<MonthTop> monthTops) {
		this.monthTops = monthTops;
	}
	public ArrayList<ReplyContent> getMyReplyContents() {
		return myReplyContents;
	}
	public void setMyReplyContents(ArrayList<ReplyContent> myReplyContents) {
		this.myReplyContents = myReplyContents;
	}
	public ArrayList<ReplyContent> getHisReplyContents() {
		return hisReplyContents;
	}
	public void setHisReplyContents(ArrayList<ReplyContent> hisReplyContents) {
		this.hisReplyContents = hisReplyContents;
	}
	
	
}
