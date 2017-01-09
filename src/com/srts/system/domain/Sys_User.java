package com.srts.system.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import com.opensymphony.xwork2.ActionContext;
import com.srts.examination.domain.TestPeople;
import com.srts.examination.domain.UserTestScore;

public class Sys_User implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String username;// 登录名
	private String password;// 登录密码
	private String company;//公司名
	private String name;// 用户姓名
	private String sex;// 用户性别
	private String workno;// 工号
	private String idno;// 身份证号
	private String workdate;// 参加工作日期（精确到月）
	private String degree;// 学历
	private String job;// 专业
	private String jobtitle;// 职称
	private String polite;// 政治面貌
	private String photo;//照片
	private String age;// 年龄
	private Sys_Department department;// 部门
private Set<Sys_Role> roles=new HashSet<Sys_Role>();
//	private Set<UserTestScore> testScores = new HashSet<UserTestScore>();//成绩

	public Sys_User() {
	}

	public Sys_User(long id, String username, String password, String company, String name,
			String sex, String workno, String idno, String workdate,
			String degree, String job, String jobtitle, String polite, String photo,
			String age, Sys_Department department) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.photo=photo;
		this.name = name;
		this.sex = sex;
		this.workno = workno;
		this.idno = idno;
		this.workdate = workdate;
		this.degree = degree;
		this.job = job;
		this.jobtitle = jobtitle;
		this.polite = polite;
		this.age = age;
		this.department = department;
		this.company=company;
	}
	
	public boolean isAdmin() {
		return "admin".equals(username);
	}
	
	public boolean hasPrivilegeByUrl(String url) {
		if (isAdmin()) {
			return true;
		} else {
			// 如果不是超级管理员，则要判断是否有权限
			List<String> allPrivilege = (List<String>) ActionContext.getContext()
			.getApplication().get("privileges");
			// b, 去掉UI后缀（如果有）
			if (url.endsWith("Ui.action")) {
				url=url.replace("Ui.action", "");
			}
		
			if (!allPrivilege.contains(url)) {
				// 如果这个URL不是要控制的权限，则返回true
				return true;
			} else {
				for(Sys_Role role : roles){
					
					for(Sys_Privilieges privilieges : role.getPrivilieges()){
						if (url.equals(privilieges.getUrl())) {
							return true;
						}
					}
					
				}
				
			}

		}
		return false;

	}
	
	public boolean hasPrivilegeByName(String name) {
		// 如果是超级管理员则拥有所有的权限
		if (isAdmin()) {
			return true;
		} else {
			// 如果不是超级管理员，则要判断是否有权限
			for(Sys_Role role : roles){
				for(Sys_Privilieges privilieges : role.getPrivilieges()){
					if (name.equals(privilieges.getName())) {
						return true;
					}
				}
			}

		}
		return false;
	}
	
	


	public Set<Sys_Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Sys_Role> roles) {
		this.roles = roles;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWorkno() {
		return workno;
	}

	public void setWorkno(String workno) {
		this.workno = workno;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getWorkdate() {
		return workdate;
	}

	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getPolite() {
		return polite;
	}

	public void setPolite(String polite) {
		this.polite = polite;
	}

	public Sys_Department getDepartment() {
		return department;
	}

	public void setDepartment(Sys_Department department) {
		this.department = department;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	
	

//	public Set<UserTestScore> getTestScores() {
//		return testScores;
//	}
//
//	public void setTestScores(Set<UserTestScore> testScores) {
//		this.testScores = testScores;
//	}

}
