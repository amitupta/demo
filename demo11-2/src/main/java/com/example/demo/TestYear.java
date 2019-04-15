package com.example.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestYear {

	public static void main (String ...a)
	{
		 Calendar yearMonthDate = new GregorianCalendar(2019, Calendar.APRIL, 01);
	        Calendar today = new GregorianCalendar();
	        today.setTime(new Date());
	        
	        int yearsInBetween =yearMonthDate.get(Calendar.YEAR)- today.get(Calendar.YEAR);
	        int monthsDiff = today.get(Calendar.MONTH)-yearMonthDate.get(Calendar.MONTH);
	        long months = yearsInBetween*12 + monthsDiff;
	        long year = yearsInBetween;
	        
	        System.out.println("Months Count : "
	                + months);
	        
//	        System.out.println("Year Count : " + year);
	}
}
