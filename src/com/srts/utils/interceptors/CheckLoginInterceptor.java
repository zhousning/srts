package com.srts.utils.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.srts.system.action.LoginLogoutAction;
import com.srts.system.domain.Sys_User;

public class CheckLoginInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		if (arg0.getAction() instanceof LoginLogoutAction) {
			return arg0.invoke();
		}
		
		Sys_User user=(Sys_User) ActionContext.getContext().getSession().get("user");
		
		String namespace=arg0.getProxy().getNamespace();
		String action=arg0.getProxy().getActionName();
		
		if (namespace==null||namespace.equals("/")) {
			namespace="";
		}else if (namespace.substring(0, 1).equals("/")) {
			namespace=namespace.substring(1,namespace.length());
		}
		String url=namespace+"/"+action;

		if (user==null) {
			return "loginUi";
		}else {
			if (user.hasPrivilegeByUrl(url)) {
				return arg0.invoke();
			}else {
				return "error_privilege";
			}
		}

	}

}
