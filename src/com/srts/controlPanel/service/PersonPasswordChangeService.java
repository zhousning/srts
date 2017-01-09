package com.srts.controlPanel.service;

import com.srts.system.domain.Sys_User;

public interface PersonPasswordChangeService {
	public String updateUserPassword(Sys_User usr,String password);

}
