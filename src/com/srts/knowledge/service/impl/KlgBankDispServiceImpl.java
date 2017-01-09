package com.srts.knowledge.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.knowledge.dao.KlgBankDispDao;
import com.srts.knowledge.dao.KlgBankListDao;
import com.srts.knowledge.service.KlgBankDispService;
import com.srts.knowledge.service.KlgBankListService;
import com.srts.system.domain.Sys_User;
@Service
public class KlgBankDispServiceImpl implements KlgBankDispService {
	@Resource
	private KlgBankDispDao klgBankDispDao;

	public int viewSearchContent(String searchType, Sys_User user, long id) {
		int res1=0;
		int res2=0;
		int viewRes=0;
		long usrId=user.getId();
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		if(month.length()==1)
		{
			month="0"+month;
		}
		if(date.length()==1)
		{
			date="0"+date;
		}
		String searchdate=year+"-"+month+"-"+date;
		if(searchType.equals("条文导学"))
		{
			res1=klgBankDispDao.updateRuleLearningSearchnum(id);
			res2=klgBankDispDao.insertRuleLearningSearchRecord(id, searchdate, usrId);
		}else if(searchType.equals("典型案例"))
		{
			res1=klgBankDispDao.updateCaseSearchnum(id);
			res2=klgBankDispDao.insertCaseSearchRecord(id, searchdate, usrId);
		}else if(searchType.equals("典型违章"))
		{
			res1=klgBankDispDao.updateViolationSearchnum(id);
			res2=klgBankDispDao.insertViolationSearchRecord(id, searchdate, usrId);
		}else if(searchType.equals("操作经验"))
		{
			res1=klgBankDispDao.updateExperienceSearchnum(id);
			res2=klgBankDispDao.insertExperienceSearchRecord(id, searchdate, usrId);
		}
		if(res1==1&&res2==1)
		{
			viewRes=1;
		}
		return viewRes;
	}

	
}
