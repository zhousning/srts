package com.srts.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.srts.common.CommonTest;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.UserService;

public class UserServiceTest extends CommonTest {
	

	private UserService userService;
	
	public void init() {
		userService = (UserService) act.getBean("userServiceImpl");
	}
	
	@Test
	public void getUserListByCon() {
		init();
		String userName="刘备";
		Long depId=null;
		String workNo="5789";
		List<Sys_User> userList=null;
		
		userList=userService.getUserListByCon(userName, depId, workNo);
		Iterator<Sys_User> iterator=userList.iterator();
		while (iterator.hasNext()) {
			Sys_User sysUser = (Sys_User) iterator.next();
			System.out.println(sysUser.getName());
		}
	}
	
	@Test
	public void getUsersByRandom(){
		init();
		Long[] depIds={4l,7l,10l};
		int counts=3;
		List<Sys_User> users=userService.getUsersByRandom(depIds, counts);
		Iterator<Sys_User> iterator=users.iterator();
		while (iterator.hasNext()) {
			Sys_User sysUser = (Sys_User) iterator.next();
			System.out.println("**********"+sysUser.getName());
		}
		
	}
	@Test
	public void test(){
		List<Sys_User> users=new ArrayList<Sys_User>();
		Sys_User user=new Sys_User();
		user.setId(1);
		users.add(user);
		Sys_User user2=new Sys_User();
		user2.setId(1);
		if (users.contains(user)) {
			System.out.println("bsaohanhhhhhh");
		}
	}
	
	@Test
	public void findUserByNamePass(){
		init();
		String name="admin";
		String pass="1234";
		Sys_User user=userService.findUserByNamePass(name, pass);
		System.out.println(user.getUsername()+"***"+user.getPassword());
	}
	
	public static void main(String[] args) {
		System.out.println(DigestUtils.md5Hex("1234"));
	}

	
}
