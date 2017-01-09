package com.srts.utils;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.srts.system.domain.Sys_Privilieges;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.PriviliegeService;
import com.srts.system.service.UserService;

/**
 * 初始化权限 安装只需要执行一次
 * 
 */
@Component("installer")
public class Install {

	@Resource
	private PriviliegeService priviliegeService;
	@Resource
	private UserService userService;

	@Transactional
	public void install() {
		// 1.设置超级管理员
		Sys_User user = new Sys_User();
		user.setUsername("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5Hex("1234"));
		userService.saveAdmin(user);

		Sys_Privilieges menu = new Sys_Privilieges("信息模块", null,
				"resource/image/system/leftItem_info.png", null);
		Sys_Privilieges menu1 = new Sys_Privilieges("通知中心",
				"info/InformationCenterAction_informationCenterList", null,
				menu);
		Sys_Privilieges menu2 = new Sys_Privilieges("下载中心",
				"info/InformationUploadAction_inforUploadList", null, menu);
		Sys_Privilieges menu3 = new Sys_Privilieges("通知管理",
				"info/InforManageCenterAction_inforManageCenterList", null,
				menu);

		priviliegeService.save(menu);
		priviliegeService.save(menu1);
		priviliegeService.save(menu2);
		priviliegeService.save(menu3);

		menu = new Sys_Privilieges("培训模块", null,
				"resource/image/system/leftItem_train.png", null);
		menu1 = new Sys_Privilieges("在线学习",
				"learning/OnlineCourseAction_onlineCourseList", null, menu);
		menu2 = new Sys_Privilieges("在线练习",
				"learning/OnlineExerciseAction_onlineExerciseList", null, menu);
		menu3 = new Sys_Privilieges("错题回顾",
				"learning/ErrorSetAction_errorSetList", null, menu);
		Sys_Privilieges menu4 = new Sys_Privilieges("课程管理",
				"learning/OnlineCourseManageAction_onlineCourseManageList",
				null, menu);
		Sys_Privilieges menu5 = new Sys_Privilieges("学习记录管理",
				"learning/OnlineCourseTraceManageAction_onlineCourseTraceList",
				null, menu);

		priviliegeService.save(menu);
		priviliegeService.save(menu1);
		priviliegeService.save(menu2);
		priviliegeService.save(menu3);
		priviliegeService.save(menu4);
		priviliegeService.save(menu5);

		menu = new Sys_Privilieges("考试模块", null,
				"resource/image/system/leftItem_exam.png", null);
		menu1 = new Sys_Privilieges("培训考试",
				"exam/ExaminationTrainAction_examTrainList", null, menu);
		menu2 = new Sys_Privilieges("竞技问答",
				"exam/ExaminationGameHomeAction_examGameHomeList", null, menu);
		menu3 = new Sys_Privilieges("考试管理",
				"exam/ExaminationManageAction_examManageList", null, menu);
		menu4 = new Sys_Privilieges("题库管理",
				"exam/QuestionBankManageAction_questionBankManageList", null,
				menu);

		priviliegeService.save(menu);
		priviliegeService.save(menu1);
		priviliegeService.save(menu2);
		priviliegeService.save(menu3);
		priviliegeService.save(menu4);
		
		menu = new Sys_Privilieges("知识库", null,
				"resource/image/system/leftItem_klg.png", null);
		menu1 = new Sys_Privilieges("知识库",
				"kldg/KnowledgeBankAction_knowledgeBankList", null, menu);
		menu2 = new Sys_Privilieges("管理知识库",
				"kldg/KnowledgeBankManageAction_knowledgeBankManageList", null, menu);
		
		priviliegeService.save(menu);
		priviliegeService.save(menu1);
		priviliegeService.save(menu2);
		
		menu = new Sys_Privilieges("评估模块", null,
				"resource/image/system/leftItem_est.png", null);
		menu1 = new Sys_Privilieges("员工评估",
				"wkea/WorkerEstimateListAction_WorkerEstimateList", null, menu);
		menu2 = new Sys_Privilieges("部门评估",
				"wkea/CompanyEstimateAction_CompanyEstimateList", null, menu);
		
		priviliegeService.save(menu);
		priviliegeService.save(menu1);
		priviliegeService.save(menu2);
		
		menu = new Sys_Privilieges("交流模块", null,
				"resource/image/system/leftItem_comm.png", null);
		menu1 = new Sys_Privilieges("问题交流",
				"commu/ProblemCommuAction_problemCommList", null, menu);
		menu2 = new Sys_Privilieges("学习交流", 
				"commu/OnlineForumAction_onlineForumModelList", null,menu);
		menu3 = new Sys_Privilieges("问题管理",
				"commu/ProblemManageAction_problemCommManage", null, menu);
		menu4 = new Sys_Privilieges("学习交流管理",
				"commu/OnlineForumArticalManageAction_onlineForumArticalManage", null, menu);
		
		priviliegeService.save(menu);
		priviliegeService.save(menu1);
		priviliegeService.save(menu2);
		priviliegeService.save(menu3);
		priviliegeService.save(menu4);
		
		menu = new Sys_Privilieges("个人中心", null,
				"resource/image/system/leftItem_self.png", null);
		menu1 = new Sys_Privilieges("个人信息",
				"ctro/PersonalCenterAction_personalInfoList", null, menu);
		menu2 = new Sys_Privilieges("密码修改",
				"ctro/PersonalCenterAction_personalPasswordChangeList", null, menu);
		
		priviliegeService.save(menu);
		priviliegeService.save(menu1);
		priviliegeService.save(menu2);

		menu = new Sys_Privilieges("综合管理", null,
				"resource/image/system/leftItem_mng.png", null);
		menu1 = new Sys_Privilieges("部门管理",
				"system/departmentAction_findTopDepList", null, menu);
		menu2 = new Sys_Privilieges("用户管理",
				"system/userAction_userList", null, menu);
		menu3 = new Sys_Privilieges("角色管理",
				"system/roleAction_roleList", null, menu);
		
		priviliegeService.save(menu);
		priviliegeService.save(menu1);
		priviliegeService.save(menu2);
		priviliegeService.save(menu3);

	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Install install = (Install) ac.getBean("installer");
		install.install();
		System.out.println("安装完毕");
	}
}
