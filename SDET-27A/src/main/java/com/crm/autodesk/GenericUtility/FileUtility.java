package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;



/**
 * 
 * @author 91917
 *
 */

public class FileUtility {
	/**
	 * its used to read the data from commonData.Properties File based on key which you pass as an argument
	 * @param key
	 * @throws Throwable
	 */
	public String getpropertykeyvalue(String key)throws Throwable{
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;

	}


}
