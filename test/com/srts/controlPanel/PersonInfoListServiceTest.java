package com.srts.controlPanel;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srts.controlPanel.po.FavorCourseInfoPo;
import com.srts.controlPanel.po.FavorKlgBankInfoPo;
import com.srts.controlPanel.po.FavorThemeInfoPo;
import com.srts.controlPanel.po.MyAnswerInfoPo;
import com.srts.controlPanel.po.MyCompetitionInfoPo;
import com.srts.controlPanel.po.MyCourseInfoPo;
import com.srts.controlPanel.po.MyEstInfoPo;
import com.srts.controlPanel.po.MyExerciseInfoPo;
import com.srts.controlPanel.po.MyKlgUploadInfoPo;
import com.srts.controlPanel.po.MyNoticeInfoPo;
import com.srts.controlPanel.po.MyProblemInfoPo;
import com.srts.controlPanel.po.MyTestInfoPo;
import com.srts.controlPanel.po.MyThemeInfoPo;
import com.srts.controlPanel.service.PersonalInfoListService;
import com.srts.estimation.po.CompanyTestInfoPo;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.UserService;

public class PersonInfoListServiceTest {
	private ApplicationContext act;
	private PersonalInfoListService service;
	private UserService userService;
	public void init(){
		act = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (PersonalInfoListService) act.getBean("personalInfoListServiceImpl");
		userService = (UserService) act.getBean("userServiceImpl");
	}
	@Test
	public void selectNoticeByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<MyNoticeInfoPo> res=service.selectNoticeByUser(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getTitle());
			System.out.println(res.get(i).getContent());
		}
	}
	@Test
	public void selectTrainTestInfoByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<MyTestInfoPo> res=service.selectTrainTestInfoByUser(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getGrade());
			System.out.println(res.get(i).getTestCompany());
			System.out.println(res.get(i).getTestContent());
			System.out.println(res.get(i).getTestDate());
			System.out.println(res.get(i).getTips());
		}
	}
	@Test
	public void selectMockTestInfoByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<MyTestInfoPo> res=service.selectMockTestInfoByUser(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getGrade());
			System.out.println(res.get(i).getTestCompany());
			System.out.println(res.get(i).getTestContent());
			System.out.println(res.get(i).getTestDate());
			System.out.println(res.get(i).getTips());
		}
	}
	@Test
	public void selectCompetitionInfoByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<MyCompetitionInfoPo> res=service.selectCompetitionInfoByUser(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getGrade());
			System.out.println(res.get(i).getDate());
			System.out.println(res.get(i).getTime());
		}
	}
	@Test
	public void selectCourseInfoByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)4);
		List<MyCourseInfoPo> res=service.selectCourseInfoByUser(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getLastStudyDate());
			System.out.println(res.get(i).getStudyContent());
			System.out.println(res.get(i).getStudyTime());
		}
	}
	@Test
	public void selectFavorCourseTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)4);
		List<FavorCourseInfoPo> res=service.selectFavorCourse();
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getBookName());
			System.out.println(res.get(i).getViewCount());
		}
	}
	@Test
	public void selectExerciseInfoByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<MyExerciseInfoPo> res=service.selectExerciseInfoByUser(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getExerciseAcur());
			System.out.println(res.get(i).getExerciseDate());
			System.out.println(res.get(i).getExerciseName());
		}
	}
	@Test
	public void selectKlgBankInfoByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<MyKlgUploadInfoPo> res=service.selectKlgBankInfoByUser(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getKlgContent());
			System.out.println(res.get(i).getKlgDate());
			System.out.println(res.get(i).getType());
		}
	}
	@Test
	public void selectFavorKlgBankTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<FavorKlgBankInfoPo> res=service.selectFavorKlgBank();
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getTitle());
			System.out.println(res.get(i).getType());
			System.out.println(res.get(i).getViewCount());
		}
	}
	@Test
	public void selectProblemInfoByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<MyProblemInfoPo> res=service.selectProblemInfoByUser(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getProAnsCount());
			System.out.println(res.get(i).getProContent());
			System.out.println(res.get(i).getProDate());
		}
	}
	@Test
	public void selectAnswerInfoByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<MyAnswerInfoPo> res=service.selectAnswerInfoByUser(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getAnswerDate());
			System.out.println(res.get(i).getAnswerContent());
		}
	}
	@Test
	public void selectThemeByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<MyThemeInfoPo> res=service.selectThemeByUser(usr);
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getArticleTitle());
			System.out.println(res.get(i).getArticleDate());
			System.out.println(res.get(i).getReplyCount());
			System.out.println(res.get(i).getUserName());
		}
	}
	@Test
	public void selectFavorThemeByUserTest()
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		List<FavorThemeInfoPo> res=service.selectFavorThemeByUser();
		for(int i=0;i<res.size();i++)
		{
			System.out.println(res.get(i).getId());
			System.out.println(res.get(i).getArticleTitle());
			System.out.println(res.get(i).getArticleDate());
			System.out.println(res.get(i).getReplyCount());
			System.out.println(res.get(i).getUserName());
		}
	}
	@Test
	public void setEstInfoTest() throws ParseException
	{	
		init();
		Sys_User usr=userService.getUserById((long)1);
		MyEstInfoPo res=service.setEstInfo(usr);
		System.out.println(res.getContent());
	}

}
