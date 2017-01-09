package com.srts.examination.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.srts.examination.dao.TestPeopleDao;
import com.srts.examination.domain.TestPeople;
import com.srts.examination.service.TestPeopleService;
import com.srts.system.dao.DepartmentDao;
import com.srts.system.domain.Sys_Department;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.UserService;

@Service
public class TestPeopleServiceImpl implements TestPeopleService {
	@Resource
	private TestPeopleDao testPeopleDao;
	@Resource
	private UserService userService;
	@Resource
	private DepartmentDao departmentDao;

	public String getDepAndWorkers(Long[] departmentIds, int counts) {

		List<Sys_User> userSelected = new ArrayList<Sys_User>();
		List<Sys_User> preUser = userService.getUserByDepIds(departmentIds);

		// 生成随机数集合
		List<Integer> index = new ArrayList<Integer>();
		for (int k = 0; k < counts;) {
			int in = new Random().nextInt(preUser.size());
			if (index.contains(in)) {
				k = k;
			} else {
				index.add(in);
				k++;
			}
		}

		// 根据随机数集合查询
		for(int l=0;l<index.size();l++){
			System.out.println(index.get(l)+"随机数");
			userSelected.add(preUser.get(index.get(l)));
		}

		String depAndWorkers = "[";
		for (int i = 0; i < departmentIds.length; i++) {

			Sys_Department department = departmentDao.getById(departmentIds[i]);

			depAndWorkers += "{'dep':{'id':" + department.getId() + ",'name':'"
					+ department.getName() + "'},";

			List<Sys_User> users = userService.getUserByDepId(departmentIds[i]);

			depAndWorkers += "'worker':[";
			if (users != null) {
				Iterator<Sys_User> iterator = users.iterator();

				while (iterator.hasNext()) {
					Sys_User sysUser = (Sys_User) iterator.next();
					long userId = sysUser.getId();

					// 统计员工考试信息
					List<?> state = testPeopleDao.getStatistics(userId);
					Iterator<?> iterator2 = state.iterator();
					String cou = null;
					String fail = null;
					while (iterator2.hasNext()) {
						Object[] object = (Object[]) iterator2.next();
						cou = object[1].toString();
						fail = object[3].toString();
					}
					if (cou == null) {
						cou = "0";
					}
					if (fail == null) {
						fail = "0";
					}

					// 查看此员工是否在被选择的员工之内
					int checkState = 0;

					for (int j = 0; j < userSelected.size(); j++) {
						if (sysUser.getId() == userSelected.get(j).getId()) {
							System.out.println(userSelected.get(j).getName()
									+ "*********");
							checkState = 1;
						}
						System.out.println("&&&&&&执行这个"
								+ userSelected.get(j).getName());
					}

					depAndWorkers += "{'id':" + sysUser.getId()
							+ ",'checkState':'" + checkState + "','name':'"
							+ sysUser.getName() + "','age':'"
							+ sysUser.getAge() + "','cou':'" + cou
							+ "','fail':'" + fail + "'},";
				}
			}
			depAndWorkers += "]},";
		}
		depAndWorkers += "]";
		System.out.println(depAndWorkers);

		return depAndWorkers;
	}

	public List<Sys_User> getWorkNums(Long[] depIds) {
		return userService.getUserByDepIds(depIds);
	}

	//插入名单数据
	public List<Sys_User> createNameList(String nameList, long testInfoId) {
		String[] names=nameList.split(",");
		Long[] nameArr=new Long[names.length];
		for (int i = 0; i < names.length; i++) {
			long userId=Long.parseLong(names[i]);
			nameArr[i]=userId;
	        testPeopleDao.createNameList(userId,testInfoId);
		}
		List<Sys_User> users=userService.getUserByIds(nameArr);
		return users;
	}

	//根据用户Id获取其参加的对应考试
	public List<TestPeople> getTestPeosByUserId(long userId) {
		List<TestPeople> testPeoples=null;
		testPeoples=testPeopleDao.getTestPeosByUserId(userId);
		return testPeoples;
	}

	public List<Sys_User> getTestPeoples(long testInfoId) {
		List<Sys_User> users=new ArrayList<Sys_User>();
	    List<TestPeople> testPeoples=testPeopleDao.findByTestInfoId(testInfoId);
	    Iterator<TestPeople> tIterator=testPeoples.iterator();
	    while (tIterator.hasNext()) {
			TestPeople testPeople = (TestPeople) tIterator.next();
			users.add(testPeople.getUsr());
		}

	    return users;
	}
	
	


}
