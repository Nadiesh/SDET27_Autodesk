package com.crm.autodesk.GenericUtility;


import java.util.Date;
import java.util.Random;

/**
 * 
 * @author 91917
 *
 */

public class JavaUtility {
	/**
	 * its used to generate random number
	 * @return int data
	 */
	public int getRanDomNumber() {
		Random random=new Random();
		int intRandom=random.nextInt(10000);
		return intRandom;
	}
	/**
	 * used to get system date&time in IST format
	 * @return
	 */
	public String getsystemDateAndTime() {
		Date date= new Date();
		return date.toString();

	}
	/**
	 * used to get system date in YYYY-MM-DD format
	 * @return
	 */
	public String getSystemdateWithFormat() {
		Date date=new Date();
		String dateAndTime = date.toString();

		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;

		String finalFormat = YYYY+" "+MM+" "+DD;

		return finalFormat;

	}

}
