package com.srts.utils.test;

import java.util.List;

import com.srts.utils.pageUtils.PaginationUtil;

public class PaginationUtilTest {
	
	public static void main(String[]args){
		PaginationUtil util = new PaginationUtil();
		List<String> list = util.getInitPages(9L,"BOOK");
		for(String s:list){
			System.out.println(s);
		}
	}
}	
