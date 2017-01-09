package com.srts.utils.listner;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.srts.system.service.PriviliegeService;

public class LoadPrivilegeServletContext implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		PriviliegeService priviliegeService=(PriviliegeService) ac.getBean("priviliegeServiceImpl");
		List<String> privileges=priviliegeService.findAllByUrl();
		arg0.getServletContext().setAttribute("privileges", privileges);
	
	}

}
