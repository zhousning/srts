package com.srts.controlPanel.dao;

import com.srts.system.domain.Sys_User;

public interface PersonPasswordChangeDao {
	public String updateUserPassword(Sys_User usr,String password);

}
