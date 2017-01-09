package com.srts.controlPanel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.controlPanel.dao.PersonPasswordChangeDao;
import com.srts.controlPanel.service.PersonPasswordChangeService;
import com.srts.system.domain.Sys_User;
@Service
public class PersonPasswordChangeServiceImpl implements
		PersonPasswordChangeService {
	@Resource
	private PersonPasswordChangeDao dao;

	public String updateUserPassword(Sys_User usr, String password) {
		String resString=dao.updateUserPassword(usr, password);
		return resString;
	}

}
