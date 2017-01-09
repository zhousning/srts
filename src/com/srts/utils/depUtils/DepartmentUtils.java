package com.srts.utils.depUtils;

import java.util.Collection;
import java.util.List;

import com.srts.system.domain.Sys_Department;



public class DepartmentUtils {
	public static void printDepartmentTree(Collection<Sys_Department> topList,
			String prefix,List<Sys_Department> departmentList) {

		for (Sys_Department top : topList) {
			Sys_Department copy=new Sys_Department();
			copy.setId(top.getId());
			copy.setName(prefix + top.getName());//副本的作用就是模拟游离状态
			departmentList.add(copy);//添加副本到同一个集合中，因为原对象是持久对象
			DepartmentUtils.printDepartmentTree(top.getChildrenDepartment(), "　" + prefix,departmentList);// 使用中文全角空格
		}
	}
}
