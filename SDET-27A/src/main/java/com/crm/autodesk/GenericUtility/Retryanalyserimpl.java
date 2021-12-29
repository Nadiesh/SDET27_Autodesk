package com.crm.autodesk.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanalyserimpl implements IRetryAnalyzer {
	int count =0;
	int retrycount=5;
	@Override
	public boolean retry(ITestResult result) {
		while(count<retrycount) {
			count++;
			return true;
		}
		return false;
		
		
	}

}
