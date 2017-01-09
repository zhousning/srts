package com.srts.estimation.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.estimation.dao.CompanyEstimateDao;
import com.srts.examination.domain.TestInfo;
import com.srts.system.dao.DepartmentDao;
import com.srts.system.domain.Sys_Department;
@Repository
@Transactional
public class CompanyEstimateDaoImpl implements CompanyEstimateDao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private DepartmentDao deptDao;

	public List<String[]> findAllTestInfoByAllConditions(long companyId,
			long deptId, String startDate, String endDate, long testInfoId) {
		String sql="select su.workno,su.name,su.company,uts.id as scoreId,su.departmentId,uts.grade,ti.id as testInfoId,ti.testName,tp.id as testPaperId,ti.testDate,sd.id as deptId,sd.name as deptName " +
				"from exm_userTestScore as uts,exm_testPaper as tp,exm_testInfo as ti,srts_sys_department as sd,srts_sys_user as su where " +
				"uts.usrId=su.id and uts.testPaperId=tp.id and tp.testInfoId=ti.id and su.departmentId=sd.id and" +
				" ti.testDate<=:endDate and ti.testDate>=:startDate and tp.type=:type";
		if(startDate.equals("")==true)
		{
			startDate="0000-00-00";
		}
		if(endDate.equals("")==true)
		{
			endDate="9999-99-99";
		}
        List list=sessionFactory.getCurrentSession().createSQLQuery(sql).setString("endDate", endDate).
        setString("startDate", startDate).setString("type","正式").list();
        List resList=new ArrayList<Object[]>();
        List<String[]> resListFinal=new ArrayList<String[]>();
        List<Sys_Department> deptList=new ArrayList<Sys_Department>();
        if(companyId!=0&&deptId==0)
        {
        	deptList=deptDao.findChildDepartmentByParentId(companyId);
        }
        if(testInfoId==0&&companyId==0&&deptId==0)
        {
        	resList=list;
        	if(list.isEmpty()==true)
        	{
        		String[] temp={"0","无记录","无记录","0","0","0","0","无记录","0","无记录","0","无记录"};
        		resListFinal.add(temp);
        	}
        	else
        	{
        		Iterator iterator = list.iterator();
        		while(iterator.hasNext()){
        			Object[] objs = (Object[]) iterator.next();
        			String [] temp=new String[objs.length];
        			for(int i=0;i<objs.length;i++)
        			{
        				temp[i]=String.valueOf(objs[i]);
        			}
        			resListFinal.add(temp);
        		}	
        	}
        }
        else if(testInfoId!=0&&companyId==0&&deptId==0)
        {
        	Iterator iterator = list.iterator();
        	if(list.isEmpty()==true)
        	{
        		String[] temp={"0","无记录","无记录","0","0","0","0","无记录","0","无记录","0","无记录"};
        		resListFinal.add(temp);
        	}
        	else
        	{
        	while(iterator.hasNext()){
    			Object[] objs = (Object[]) iterator.next();
    			if(testInfoId==Long.parseLong(String.valueOf(objs[6])))
    			{
    				resList.add(objs);
    			}
    		}
        	Iterator iterator1 = resList.iterator();
    		while(iterator1.hasNext()){
    			Object[] objs = (Object[]) iterator1.next();
    			String [] temp=new String[objs.length];
    			for(int i=0;i<objs.length;i++)
    			{
    				temp[i]=String.valueOf(objs[i]);
    			}
    			resListFinal.add(temp);
    		}	
        	}
        }
        else if(testInfoId==0&&companyId!=0&&deptId==0)
        {
        	Iterator iterator = list.iterator();
        	if(list.isEmpty()==true)
        	{
        		String[] temp={"0","无记录","无记录","0","0","0","0","无记录","0","无记录","0","无记录"};
        		resListFinal.add(temp);
        	}
        	else
        	{
        	while(iterator.hasNext()){
    			Object[] objs = (Object[]) iterator.next();
    			for(int i=0;i<deptList.size();i++)
    			{
    				if(Long.parseLong(String.valueOf(objs[4]))==deptList.get(i).getId())
    				{
    					resList.add(objs);
    				}
    			}
    		}
        	Iterator iterator1 = resList.iterator();
    		while(iterator1.hasNext()){
    			Object[] objs = (Object[]) iterator1.next();
    			String [] temp=new String[objs.length];
    			for(int i=0;i<objs.length;i++)
    			{
    				temp[i]=String.valueOf(objs[i]);
    			}
    			resListFinal.add(temp);
    		}	
        	}
        }
        else if(testInfoId==0&&companyId!=0&&deptId!=0)
        {
        	Iterator iterator = list.iterator();
        	if(list.isEmpty()==true)
        	{
        		String[] temp={"0","无记录","无记录","0","0","0","0","无记录","0","无记录","0","无记录"};
        		resListFinal.add(temp);
        	}
        	else
        	{
        	while(iterator.hasNext()){
    			Object[] objs = (Object[]) iterator.next();
    			if(Long.parseLong(String.valueOf(objs[4]))==deptId)
    			{
    				resList.add(objs);
    			}
    		}
        	Iterator iterator1 = resList.iterator();
    		while(iterator1.hasNext()){
    			Object[] objs = (Object[]) iterator1.next();
    			String [] temp=new String[objs.length];
    			for(int i=0;i<objs.length;i++)
    			{
    				temp[i]=String.valueOf(objs[i]);
    			}
    			resListFinal.add(temp);
    		}	
        	}
        }
        else if(testInfoId!=0&&companyId!=0&&deptId==0)
        {
        	Iterator iterator = list.iterator();
        	if(list.isEmpty()==true)
        	{
        		String[] temp={"0","无记录","无记录","0","0","0","0","无记录","0","无记录","0","无记录"};
        		resListFinal.add(temp);
        	}
        	else
        	{
        	while(iterator.hasNext()){
    			Object[] objs = (Object[]) iterator.next();
    			for(int i=0;i<deptList.size();i++)
    			{
    				if(Long.parseLong(String.valueOf(objs[4]))==deptList.get(i).getId()&&testInfoId==Long.parseLong(String.valueOf(objs[6])))
    				{
    					resList.add(objs);
    				}
    			}
    		}
        	Iterator iterator1 = resList.iterator();
    		while(iterator1.hasNext()){
    			Object[] objs = (Object[]) iterator1.next();
    			String [] temp=new String[objs.length];
    			for(int i=0;i<objs.length;i++)
    			{
    				temp[i]=String.valueOf(objs[i]);
    			}
    			resListFinal.add(temp);
    		}	
        	}
        }
        else if(testInfoId!=0&&companyId!=0&&deptId!=0)
        {
        	Iterator iterator = list.iterator();
        	if(list.isEmpty()==true)
        	{
        		String[] temp={"0","无记录","无记录","0","0","0","0","无记录","0","无记录","0","无记录"};
        		resListFinal.add(temp);
        	}
        	else
        	{
        	while(iterator.hasNext()){
    			Object[] objs = (Object[]) iterator.next();
    			if(Long.parseLong(String.valueOf(objs[4]))==deptId&&testInfoId==Long.parseLong(String.valueOf(objs[6])))
    			{
    				resList.add(objs);
    			}
    		}
        	Iterator iterator1 = resList.iterator();
    		while(iterator1.hasNext()){
    			Object[] objs = (Object[]) iterator1.next();
    			String [] temp=new String[objs.length];
    			for(int i=0;i<objs.length;i++)
    			{
    				temp[i]=String.valueOf(objs[i]);
    			}
    			resListFinal.add(temp);
    		}	
        	}
        }
		return resListFinal;
	}

	public List<Long> findAllTestInfoId() {
		List<Long> resList=new ArrayList<Long>();
		String sql="select * from exm_testInfo";
		List list=sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		Iterator iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			resList.add(Long.parseLong(String.valueOf(objs[0])));
		}
		return resList;
	}

	@SuppressWarnings("unchecked")
	public List<TestInfo> findTestListByStartDateAndEndDate(String startDate,
			String endDate) {
		if(startDate.equals(""))
		{
			startDate="0000-00-00";
		}
		if(endDate.equals(""))
		{
			endDate="9999-99-99";
		}
		String HQL="from TestInfo "+
		"where testDate>=:startDate and testDate<=:endDate";
		return (List<TestInfo>) sessionFactory.getCurrentSession()
		.createQuery(
				HQL).setString("startDate", startDate).setString("endDate", endDate).list();
	}	

}
