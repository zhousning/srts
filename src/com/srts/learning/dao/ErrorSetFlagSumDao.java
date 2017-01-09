package com.srts.learning.dao;

import java.util.List;

import com.srts.common.base.BaseDao;
import com.srts.learning.domain.ErrorSetFlagSum;
import com.srts.system.domain.Sys_User;

public interface ErrorSetFlagSumDao extends BaseDao<ErrorSetFlagSum>{
	public List<ErrorSetFlagSum> findErrorSetFlagSumById(Sys_User usr);
	public int insertErrorSetFlagSum(int flagSum,String TimePoint,Sys_User usr);
}
