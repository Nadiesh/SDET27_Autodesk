package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserDemo {
	@Test(retryAnalyzer = com.crm.autodesk.GenericUtility.Retryanalyserimpl.class)
	public void retryAnalyserdemoTest()
	{
		System.out.println("RetryAnalyser");
		Assert.fail();
	}

}
