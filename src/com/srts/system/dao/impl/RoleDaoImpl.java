package com.srts.system.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.system.dao.RoleDao;
import com.srts.system.domain.Sys_Role;

@Repository
@Transactional
public class RoleDaoImpl extends BaseDaoImpl<Sys_Role> implements RoleDao {

}
