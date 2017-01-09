package com.srts.system.dao.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.system.dao.Sys_UserDao;
import com.srts.system.domain.Sys_User;

@Repository
@Transactional
public class Sys_UserDaoImpl extends BaseDaoImpl<Sys_User> implements
		Sys_UserDao {

	public List<Sys_User> getUserByDepIds(Long[] depIds) {
		if (depIds == null || depIds.length == 0) {
			return Collections.EMPTY_LIST;
		}
		return this.getSession().createCriteria(Sys_User.class).add(
				Restrictions.in("department.id", depIds)).list();
	}

	public List<Sys_User> getUserByDepId(Long depId) {
		return this.getSession().createCriteria(Sys_User.class).add(
				Restrictions.eq("department.id", depId)).list();
	}

	/**
	 * 根据查询条件查询用户
	 */
	public List<Sys_User> getUserListByCon(String userName, Long depId,
			String workNo) {
		List<Sys_User> list=null;
		String strWhere="from Sys_User u where ";
		if (userName!=null&&!(userName.equals(""))) {
			userName=userName.trim();
		strWhere+="u.name="+"'"+userName+"'"+" and ";
		}
		if (workNo!=null&&!(workNo.equals(""))) {
			workNo=workNo.trim();
			strWhere+="u.workno="+"'"+workNo+"'"+" and ";
		}
		if (depId!=null) {
			strWhere+="u.department.id="+depId+" and ";
		}
		strWhere+="1=1";
		Query query=getSession().createQuery(strWhere);
		
		list=query.list();
		
		return list;
	}

	/**
	 * 根据Id删除相应实体
	 */
	public void deleteById(Long userId) {
	
	}

	/**
	 * 随机指定部门指定数量的员工
	 */
	public List<Sys_User> getgetUsersByRandom(Long[] departmentIds, int counts) {
		List<Sys_User> users=null;
//		String sql="from Sys_User where Sys_User.id = "+departmentIds+"";
//		Query query=this.getSession().createQuery(sql);
//		users=query.list();
		Criteria criteria=this.getSession().createCriteria(Sys_User.class);
		criteria.add(Restrictions.in("department.id", departmentIds));
		users=criteria.setMaxResults(counts).list();
		return users;
	}

	public Sys_User findUserByNamePass(String username, String password) {
		Sys_User user=null;
		//String pass=DigestUtils.md5Hex(password);
		Criteria criteria=getSession().createCriteria(Sys_User.class);
		Conjunction conjunction=Restrictions.conjunction();
		conjunction.add(Restrictions.eq("username", username));
		conjunction.add(Restrictions.eq("password", password));
		criteria.add(conjunction);
		user=(Sys_User) criteria.uniqueResult();	
		return user;
	}
}
