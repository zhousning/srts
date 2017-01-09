package com.srts.system;

import java.util.List;

import org.junit.Test;

import com.srts.common.CommonTest;
import com.srts.system.domain.Sys_Privilieges;
import com.srts.system.service.PriviliegeService;

public class PrivilegeServiceTest extends CommonTest {
	private PriviliegeService priviliegeService;

	public void init() {
		priviliegeService = (PriviliegeService) act
				.getBean("priviliegeServiceImpl");
	}

	@Test
	public void findTopPriList() {
		init();
		List<Sys_Privilieges> privilieges = priviliegeService.findTopPriList();

		for (int i = 0; i < privilieges.size(); i++) {
			System.out.println(privilieges.get(i).getName());
		}
	}
	
	@Test
	
	public void findAllUrl(){
		init();
		List<String> prList=priviliegeService.findAllByUrl();
		for(String aString :prList){
			System.out.println(aString);
		}
	}
	
	public static void main(String[] args) {
		String aString="123456";
		System.out.println(aString.substring(1, aString.length()));
	}
}
