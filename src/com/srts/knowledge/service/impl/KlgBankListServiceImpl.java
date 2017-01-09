package com.srts.knowledge.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.knowledge.dao.KlgBankListDao;
import com.srts.knowledge.service.KlgBankListService;
import com.srts.system.domain.Sys_User;
@Service
public class KlgBankListServiceImpl implements KlgBankListService {
	@Resource
	private KlgBankListDao klgBankListDao;

	public List<String[]> findFavorRuleByUser(Sys_User user) {
		List list=klgBankListDao.findFavorRuleByUser(user);
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}


	public List<String[]> findPopKlgBank() {
		List list=klgBankListDao.findPopKlgBank();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public int insertIntoExperience(String content, String explaination,
			Sys_User user) {
		String statement="未审核";
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
		String uploaddate=year+"-"+month+"-"+date;
		String updatedate=year+"-"+month+"-"+date;
		String checkeddate="2099-12-31";
		int res=klgBankListDao.insertIntoExperience(content, statement, explaination, uploaddate, updatedate, checkeddate, user);
		return res;
	}

	public List<String[]> searchKlgBankByTypeAndKeyWords(String type,
			String keyWords) {
		List list=klgBankListDao.searchKlgBankByTypeAndKeyWords(type, keyWords);
		List<String[]> resList = new ArrayList<String[]>();
		if(type.equals("操作经验")==true)
		{
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","1","无记录"};
			resList.add(empty);
		}
		}else if(type.equals("条文导学")==true)
		{
			if(list.isEmpty()==false)
			{
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
				resList.add(addItem);
				}
			}
			else
			{
				String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
				resList.add(empty);
			}
		}
		else if(type.equals("典型违章")==true)
		{
			if(list.isEmpty()==false)
			{
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString()};
				resList.add(addItem);
				}
			}
			else
			{
				String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
				resList.add(empty);
			}
		}
		else if(type.equals("典型案例")==true)
		{
			if(list.isEmpty()==false)
			{
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				Object[] objs = (Object[]) iterator.next();
				String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString()};
				resList.add(addItem);
				}
			}
			else
			{
				String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
				resList.add(empty);
			}
		}
		return resList;
	}

	public String findSearchnumByMonth() {
		List<Integer[]> list=klgBankListDao.findSearchnumByMonth();
		Integer[] searchnumNow=list.get(list.size()-1);
		String[] kind={"条文导学","典型违章","典型案例","操作经验"};
		String CountByType = "{'chart':{'showBorder':'1','borderColor':'000000','chartTopMargin':'2','chartBottomMargin':'2','chartLeftMargin':'2','chartRightMargin':'2','canvasBgColor':'#ffffff','canvasbgAlpha':'50','bgcolor': 'b89842,FFFFFF','caption':'当前各类知识条目检索量累计','xAxisName':'知识条目类型','yAxisName':'检索量','numberPrefix':'次'},'data':[";
		for(int i=0;i<4;i++)
		{
			CountByType+="{'label':'"+kind[i]+"','value':'"+String.valueOf(searchnumNow[i])+"'},";
		}
		CountByType+="]}";
		return CountByType; 
	}

	public List<String[]> listTopFiveRule() {
		List list=klgBankListDao.listTopFiveRule();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public List<String[]> listTopFiveViolation() {
		List list=klgBankListDao.listTopFiveViolation();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public List<String[]> listTopOneCase() {
		List list=klgBankListDao.listTopOneCase();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public List<String[]> listTopOneOperateSheet() {
		List list=klgBankListDao.listTopThreeExperience();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public List<String[]> listTopOneWorkSheet() {
		List list=klgBankListDao.listTopThreeExperience();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}

	public List<String[]> listTopThreeExperience() {
		List list=klgBankListDao.listTopThreeExperience();
		List<String[]> resList = new ArrayList<String[]>();
		if(list.isEmpty()==false)
		{
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
			resList.add(addItem);
			}
		}
		else
		{
			String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
			resList.add(empty);
		}
		return resList;
	}


	public List<String[]> showAllInfo(String id, String type) {
			List list=klgBankListDao.findAllInfo(id, type);
			List<String[]> resList = new ArrayList<String[]>();
			if(type.equals("条文导学")==true)
			{
				if(list.isEmpty()==false)
				{
				Iterator iterator = list.iterator();
				while(iterator.hasNext()){
					Object[] objs = (Object[]) iterator.next();
					String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString(),objs[8].toString()};
					resList.add(addItem);
					}
				}
				else
				{
					String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
					resList.add(empty);
				}
			}
			else if(type.equals("典型违章")==true)
			{
				if(list.isEmpty()==false)
				{
				Iterator iterator = list.iterator();
				while(iterator.hasNext()){
					Object[] objs = (Object[]) iterator.next();
					String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString()};
					resList.add(addItem);
					}
				}
				else
				{
					String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
					resList.add(empty);
				}
			}
			else if(type.equals("典型案例")==true)
			{
				if(list.isEmpty()==false)
				{
				Iterator iterator = list.iterator();
				while(iterator.hasNext()){
					Object[] objs = (Object[]) iterator.next();
					String []addItem = {objs[0].toString(),objs[1].toString(),objs[2].toString(),objs[3].toString(),objs[4].toString(),objs[5].toString(),objs[6].toString(),objs[7].toString()};
					resList.add(addItem);
					}
				}
				else
				{
					String empty[]={"无记录","无记录","无记录","无记录","无记录","无记录","无记录","无记录"};
					resList.add(empty);
				}
			}
			return resList;
		}

}
