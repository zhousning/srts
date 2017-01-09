package com.srts.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.system.dao.PriviliegeDao;
import com.srts.system.domain.Sys_Privilieges;
import com.srts.system.service.PriviliegeService;

@Service
public class PriviliegeServiceImpl implements PriviliegeService {

	@Resource
	private PriviliegeDao priviliegeDao;

	public void save(Sys_Privilieges privilieges) {
		priviliegeDao.save(privilieges);
	}

	public List<Sys_Privilieges> findTopPriList() {
		 List<Sys_Privilieges> topPriList=null;
		 topPriList=priviliegeDao.findTopPriList();
		return topPriList;
	}

	public List<Sys_Privilieges> findByIds(Long[] privilegeIds) {
	List<Sys_Privilieges> privilieges=null;
	privilieges=priviliegeDao.getByIds(privilegeIds);
		return privilieges;
	}

	public List<String> findAllByUrl() {
		List<String> allUrl=null;
		allUrl=priviliegeDao.findAllUrl();
		return allUrl;
	}

}
