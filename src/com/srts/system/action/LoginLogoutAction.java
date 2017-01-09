package com.srts.system.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.srts.common.base.impl.BaseActionImpl;
import com.srts.system.domain.Sys_Privilieges;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.LoginLogoutService;
import com.srts.system.service.PriviliegeService;
import com.srts.system.service.UserService;

@Controller
@Scope("prototype")
public class LoginLogoutAction extends BaseActionImpl<Sys_User> {
	@Resource
	private LoginLogoutService loginLogoutService;
	@Resource 
	private UserService userService;
	@Resource
	private PriviliegeService priviliegeService;
	
	private String username;
	private String password;
	private String infomation;
	
	public String loginUi(){
		return "loginUi";
	}
	
	public String  logouUi() {
		return "loginUi";
	}
	public String login() {
		Sys_User user=null;
		if(username!=null&&password!=null){
	user=userService.findUserByNamePass(username,password);
		}
	if (user==null) {
		infomation="登录名或密码错误";
		return "loginUi";
	}else {
		List<Sys_Privilieges> privilieges=priviliegeService.findTopPriList();
		ActionContext.getContext().getSession().put("topPrivilegeList", privilieges);
		ActionContext.getContext().getSession().put("user", user);
		infomation="";
		return "toIndex";
	}	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getInfomation() {
		return infomation;
	}

	public void setInfomation(String infomation) {
		this.infomation = infomation;
	}

	public Sys_User getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
