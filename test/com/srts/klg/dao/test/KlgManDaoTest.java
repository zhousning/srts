package com.srts.klg.dao.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.knowledge.dao.KlgBankManDao;
import com.srts.knowledge.domain.TypicalCase;
import com.srts.knowledge.domain.TypicalViolation;
import com.srts.knowledge.service.KnowledgeBankManageService;

public class KlgManDaoTest {

	ApplicationContext act = null;
	KlgBankManDao bankManDao = null;

	public void init() {
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		bankManDao = (KlgBankManDao) act.getBean("klgBankManDaoImpl");
	}

	@Test
	public void findTopFiveTypicalViolations() {
		init();
		List<TypicalViolation> list = bankManDao.findTopFiveTypicalViolations();

		Iterator<TypicalViolation> iterator = list.iterator();
		while (iterator.hasNext()) {
			TypicalViolation typicalViolation = (TypicalViolation) iterator
					.next();
			System.out.println(typicalViolation.getTitle());
		}
	}

	/**
	 * 按知识类型查询
	 */
	@Test
	public void findAllByType() {
		init();
		List<Object[]> objects = bankManDao.findAllByType("klg_typicalCase");
		for (Object[] objects2 : objects) {
			System.out.println(objects2[1]);
		}
	}
	/**
	 * 根据知识类型，知识ID删除对应的知识
	 */
	@Test
	public void deleteKlg(){
		init();
		String type="klg_typicalCase";
		long id=7;
		bankManDao.deleteKlg(type, id);
	}
	/**
	 * 根据知识id获取响应的知识内容
	 */
	@Test
	public void findContentById() {
		init();
		long id=3;
		String klgType="klg_typicalCase";
		List<Object[]> list=bankManDao.findContentById(id, klgType);
		Iterator<Object[]> iterator=list.iterator();
		while (iterator.hasNext()) {
			Object[] objects = (Object[]) iterator.next();
			System.out.println(Arrays.asList(objects));
		}
	}
	
	/**
	 * 更新知识
	 */
	@Test
	public void updateKlg(){
		init();
		bankManDao.updateKlg(5,"klg_typicalViolation", "2014-9-18", "更新***测试", "更新测试1232content", "管理违章");
	}
	/**
	 * 知识上传
	 */
	@Test
	public void upLoadKlg() {
		init();
		String klg="klg_typicalViolation";
		String title="行为违章";
		String dates="2012-02-14";
		String content="进入作业现场未按规定正确佩戴安全帽。";

	}

}
