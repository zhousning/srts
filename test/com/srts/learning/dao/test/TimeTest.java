package com.srts.learning.dao.test;

import java.util.Calendar;

public class TimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar=Calendar.getInstance();
		long s=calendar.getTimeInMillis();
        System.out.println(s);
	}

}
