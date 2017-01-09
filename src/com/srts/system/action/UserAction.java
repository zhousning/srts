package com.srts.system.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.srts.common.base.impl.BaseActionImpl;
import com.srts.system.domain.Sys_Department;
import com.srts.system.domain.Sys_Role;
import com.srts.system.domain.Sys_User;
import com.srts.system.service.DepartmentService;
import com.srts.system.service.RoleService;
import com.srts.system.service.UserService;
import com.srts.utils.depUtils.DepartmentUtils;

@Controller
@Scope("prototype")
public class UserAction extends BaseActionImpl<Sys_User> {

	@Resource
	private UserService userService;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private RoleService roleService;
	private Long userId;
	private Long depId;
	private Long roleId;
	private Long[] roleIds;
	private String userName;
	private String workNo;
	private String result;
	private Sys_User user;

	private List<Sys_User> userList=new ArrayList<Sys_User>();
	private List<Sys_Department> depList;
	private List<Sys_Department> topList;
	private List<Sys_Role> roleList;


	/**
	 * 设置用户岗位页面
	 */
	public String setUserRole() {

		return "list";
	}

	/**
	 * 查询全部用户或根据条件查询用户
	 */
	public String userList() {
		preDep();
		List<Sys_User> list=new ArrayList<Sys_User>();
		list= userService.getUserListByCon(userName, depId, workNo);
		
		allRow=list.size();
		if(allRow>0){
			if(allRow%15==0){
				totalPage=allRow/15;
			}else{
				totalPage=allRow/15+1;
			}
			
			for(int i=(page-1)*15; i<page*15&&i<list.size(); i++){
				userList.add(list.get(i));
			}
		}else{
			totalPage=1;
		}
		
		return "list";
	}

	/**
	 * 显示某一个用户具体的信息
	 */
	public String userShow() {
		preDep();
		preRole();
		int i = 0;
		
		if (userId != null) {
			user = userService.getUserById(userId);
			roleIds = new Long[user.getRoles().size()];
			for (Sys_Role role : user.getRoles()) {
				System.out.println("("+i+")");
				roleIds[i++] = role.getId();
			}
		}

		return "show";
	}

	/**
	 *根据ID删除某一个用户
	 */
	public String deleteUserById() {
		if (userId != null) {
			System.out.println(userId);
			userService.deleteUserById(userId);
		} else {
			result = "{'k':'fail'}";
		}
		return "toList";
	}

	/**
	 * 更新某一个用户信息
	 */
	public String updateUser() {
	
		Sys_Department department = null;
		if (depId != null) {
			department = departmentService.getDepById(depId);
			user.setDepartment(department);
		}
		if (roleIds != null) {
			List<Sys_Role> roles = roleService.findByIds(roleIds);
			user.setRoles(new HashSet<Sys_Role>(roles));
		}
	    user.setWorkno(workNo);
	    	userService.updateUser(user);	
		return "toShow";
	}

	/**
	 * 新建一个用户
	 */
	public String saveUser() {
		Sys_Department department = null;
		List<Sys_Role> roles = null;

		if (depId != null) {
			department = departmentService.getDepById(depId);
			user.setDepartment(department);
		}
		if (roleIds!=null) {
			roles=roleService.findByIds(roleIds);
			user.setRoles(new HashSet<Sys_Role>(roles));
		}
        System.out.println(workNo+"******");
		userService.saveUser(user,workNo);
	
		return "toList";
	}

	/**
	 * 准备部门数据
	 */
	public void preDep() {
		depList = new ArrayList<Sys_Department>();
		topList = departmentService.findTopDepartmentList();
		DepartmentUtils.printDepartmentTree(topList, "┣", depList);
	}

	public void preRole() {
		// userRoles=userRoleService.findAll();
		roleList = roleService.findAll();
	}

	public Sys_User getModel() {
		if (user == null) {
			user = new Sys_User();
		}
		return user;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}


	public List<Sys_Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Sys_Role> roleList) {
		this.roleList = roleList;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void prepare() throws Exception {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDepId() {
		return depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public List<Sys_Department> getDepList() {
		return depList;
	}

	public void setDepList(List<Sys_Department> depList) {
		this.depList = depList;
	}

	public List<Sys_User> getUserList() {
		return userList;
	}

	public void setUserList(List<Sys_User> userList) {
		this.userList = userList;
	}

	public List<Sys_Department> getTopList() {
		return topList;
	}

	public void setTopList(List<Sys_Department> topList) {
		this.topList = topList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public Sys_User getUser() {
		return user;
	}

	public void setUser(Sys_User user) {
		this.user = user;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private int page=1;
	private int totalPage;
	private int allRow;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
}
