package com.srts.utils.interceptors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srts.system.domain.Sys_User;

public class CheckLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		
		response.setDateHeader("Expires", -1);
		 response.setHeader("Cache-Control","no-cache"); 
		 response.setHeader("Pragma","No-cache"); 
		
		String uri=request.getRequestURI();
		Sys_User user=(Sys_User) request.getSession().getAttribute("user");
	
		
		if (user==null) {
			if (!uri.contains("loginLogoutAction")) {
			
				response.sendRedirect("/srts/system/loginLogoutAction_loginUi");
			}
			
		}else {
			arg2.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	
	}

}
