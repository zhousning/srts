package com.srts.system.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.system.dao.LoginLogoutDao;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
public class LoginLogoutDaoImpl extends BaseDaoImpl<Sys_User> implements LoginLogoutDao {

}
