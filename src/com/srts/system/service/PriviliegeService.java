package com.srts.system.service;

import java.util.List;

import com.srts.system.domain.Sys_Privilieges;

public interface PriviliegeService {

public void save(Sys_Privilieges privilieges);

public List<Sys_Privilieges> findTopPriList();

public List<Sys_Privilieges> findByIds(Long[] privilegeIds);

public List<String> findAllByUrl();
}
