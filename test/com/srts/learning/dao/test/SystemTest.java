package com.srts.learning.dao.test;

import java.util.Calendar;

public class SystemTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar=Calendar.getInstance();
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String lastTestTime=year+"-"+month+"-"+date;
		System.out.println(calendar);
        System.out.println(lastTestTime);
	}

}
