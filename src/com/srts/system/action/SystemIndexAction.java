package com.srts.system.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.srts.common.base.impl.BaseActionImpl;
import com.srts.system.domain.Sys_User;

/**
 * 处理系统首页的Action
 * 
 * @author 薄小永
 */
@Controller
@Scope("prototype")
public class SystemIndexAction extends BaseActionImpl<Sys_User> {

	private static final long serialVersionUID = 1L;

	public Sys_User getModel() {
		return null;
	}

	public void prepare() throws Exception {
	}

	// *****************************************************************//

	public String topMenu() {
		return "topMenu";
	}

	public String leftMenu() {
		return "leftMenu";
	}

	public String homePage() {
		return "homePage";
	}

	public String statusBar() {
		return "statusBar";
	}

}
