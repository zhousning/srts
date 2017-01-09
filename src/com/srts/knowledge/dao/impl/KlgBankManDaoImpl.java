package com.srts.knowledge.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srts.common.base.impl.BaseDaoImpl;
import com.srts.knowledge.dao.KlgBankManDao;
import com.srts.knowledge.domain.Experience;
import com.srts.knowledge.domain.RuleLearning;
import com.srts.knowledge.domain.TypicalCase;
import com.srts.knowledge.domain.TypicalViolation;

@Repository
@Transactional
public class KlgBankManDaoImpl extends BaseDaoImpl<Experience> implements
		KlgBankManDao {

	/**
	 * 查询知识的前五条
	 */

	public List<Experience> findTopFiveExperiences() {
		String sql = "from Experience order by id desc";
		List<Experience> list = this.getSession().createQuery(sql)
				.setMaxResults(5).list();
		return list;
	}

	public List<TypicalCase> findTopFiveTypicalCases() {
		String sql = "from TypicalCase order by id desc";
		List<TypicalCase> list = this.getSession().createQuery(sql)
				.setMaxResults(5).list();
		return list;
	}

	public List<TypicalViolation> findTopFiveTypicalViolations() {
		String sql = "from TypicalViolation order by id desc";
		List<TypicalViolation> list = this.getSession().createQuery(sql)
				.setMaxResults(5).list();
		return list;
	}

	/**
	 * 按知识类型查询
	 */
	public List<Object[]> findAllByType(String klgType) {
		String sql = "select * from " + klgType + " order by id desc";
		Query query = getSession().createSQLQuery(sql);
		List<Object[]> list = query.list();
		return list;
	}

	/**
	 * 根据知识类型，知识ID删除对应的知识
	 */
	public void deleteKlg(String klgType, long klgId) {
		String sql = "delete from " + klgType + " where id=" + klgId + "";
		Query query = getSession().createSQLQuery(sql);
		query.executeUpdate();
	}

	/**
	 * 根据知识id获取响应的知识内容
	 */
	public List<Object[]> findContentById(long klgId, String klgType) {
		List<Object[]> list = null;
		System.out.println(klgId + "klgId");
		String sql = "select * from " + klgType + " where id= " + klgId + "";
		System.out.println(sql);
		Query query = getSession().createSQLQuery(sql);
		list = query.list();
		return list;
	}

	/**
	 * 更新知识
	 */
	public void updateKlg(long klgId, String klgType, String updateTime,
			String title, String content, String type) {
		String sql = "update " + klgType
				+ " set title=?,content=?,type=?,updatedate=? where id=? ";
		Query query = getSession().createSQLQuery(sql);
		query.setString(0, title).setString(1, content).setString(2, type)
				.setString(3, updateTime).setLong(4, klgId);
		query.executeUpdate();
	}

	/**
	 * 上传知识
	 */
	public void upLoadKlg(String klg, String title, String dates,
			String content, long userId) {
		
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String now=simpleDateFormat.format(date);

		if (klg.equals("klg_typicalViolation")) {
			String sql = "insert into " + klg
					+ " (title,searchnum,content,uploaddate,type) values (?,?,?,?,?)";
			Query query = getSession().createSQLQuery(sql);
			query.setString(0,"典型违章100条").setLong(1, 0).setString(2, content).setString(3, dates).setString(4, title);
			query.executeUpdate();
		} else if (klg.equals("klg_experience")) {
			String state="未审核";
			String sql = "insert into " + klg
					+ " (content,uploaddate,explaination,usrId,statement,updatedate,checkeddate,searchnum) values (?,?,?,?,?,?,?,?)";
			Query query = getSession().createSQLQuery(sql);
			query.setString(0, title).setString(1, dates).setString(2, content)
					.setLong(3, userId).setString(4, state).setString(5, now).setString(6, now).setLong(7, 0);
			query.executeUpdate();
		}

	}

	/**
	 * 上传典型案例
	 */
	public void upLoadTypeCase(String klg, String title, String content,
			String path, String dates) {
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String now=simpleDateFormat.format(date);
		String sql = "insert into " + klg
				+ " (title,content,uploaddate,pic,searchnum,updatedate,type) values (?,?,?,?,?,?,?)";
		Query query = getSession().createSQLQuery(sql);
		query.setString(0, title).setString(1, content).setString(2, dates)
				.setString(3, path).setLong(4, 0l).setString(5,now ).setString(6, "典型案例");
		query.executeUpdate();
	}

}
