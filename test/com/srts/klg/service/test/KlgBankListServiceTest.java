package com.srts.klg.service.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.knowledge.service.KlgBankListService;
import com.srts.system.domain.Sys_User;

public class KlgBankListServiceTest {
	private ApplicationContext act;
	private KlgBankListService service;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (KlgBankListService) act.getBean("klgBankListServiceImpl");	
	}
	@Test
	public void findFavorRuleByUserTest()
	{
		init();
		Sys_User user =new Sys_User();
		user.setId(1);
		List<String[]> list=service.findFavorRuleByUser(user);
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findPopKlgBankTest()
	{
		init();
		Sys_User user =new Sys_User();
		user.setId(1);
		List<String[]> list=service.findPopKlgBank();
		Iterator<String[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void insertIntoExperienceTest()
	{
		init();
		String content="gsaifhausil"; 
		String explaination="haslfcoaniu";
		Sys_User user=new Sys_User();
		user.setId(1);
		int res=service.insertIntoExperience(content, explaination, user);
		System.out.println(res);
	}
	@Test
	public void searchKlgBankByTypeAndKeyWordsTest()
	{
		init();
		String type="条文导学";
		String keyWords="违章";
		List list = service.searchKlgBankByTypeAndKeyWords(type, keyWords);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	 public void listTopFiveRuleTest()
	{
		init();
		List list = service.listTopFiveRule();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	@Test
	public void findSearchnumByMonthTest()
	{
		init();
		String res=service.findSearchnumByMonth();
		System.out.println(res);
	}
	@Test
	 public void listTopOneCaseTest()
	{
		init();
		List list = service.listTopOneCase();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
	
	@Test 
	public void searchTest()
	{
		init();
		List list = service.searchKlgBankByTypeAndKeyWords("条文导学", "违章");
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object[] objs = (Object[]) iterator.next();
			for(Object ojb:objs){
				if(ojb!=null){
				System.out.println(ojb.toString());
				}
			}
		}
	}
		
}
