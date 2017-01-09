package com.srts.communication.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.srts.common.base.impl.BaseActionImpl;
import com.srts.communication.domain.BBSModel;

@Controller
@Scope("prototype")
public class OnlineForumArticalManageAction extends BaseActionImpl<BBSModel>{
	private static final long serialVersionUID = 1L;

	public BBSModel getModel() {
		return null;
	}
	public void prepare() throws Exception {
		
	}
	
	/**
	 * 跳转到onlineForumArticalManage.jsp
	 * @return
	 */
	public String onlineForumArticalManage(){
		return "onlineForumArticalManage";
	}
}
