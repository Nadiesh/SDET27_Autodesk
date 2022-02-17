package com.crm.autodesk.GenericUtility;

import java.io.File;
import java.io.IOException;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;





public class ListImpClass implements ITestListener{
	JavaUtility jLib = new JavaUtility();
	ExtentReports report;
	ExtentTest test;
	public void onTestFailure(ITestResult result) {
//step8: log for failed methods
		String testNAme = result.getMethod().getMethodName();
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());

		String date = jLib.getsystemDateAndTime();

		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File srcFiel = edriver.getScreenshotAs(OutputType.FILE);

		File dstFile = new File("./screenshot/"+testNAme+"_"+date +".png");
		test.addScreenCaptureFromPath(dstFile.getAbsolutePath());
		try {
			Files.copy(srcFiel, dstFile);
		} catch (IOException e) {

		}

	}

	public void onTestStart(ITestResult result) {//@Test
		//step5: create test name in report
		test = report.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		//step6: log for pass test method
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");

	}


	public void onTestSkipped(ITestResult result) {
		//step7:log for skipped methods
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onStart(ITestContext context) {
		//step1:- report configuration
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReport.html");
		spark.config().setDocumentTitle("Vtiger App");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Automation Execution report"); 
		//step2:- attaching the configuration to extent report and also System info
		report=new ExtentReports();
		report.attachReporter(spark);
		//step3: write system info
		FileUtility fLib = new FileUtility();
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("Platform", "WINDOWS");
		report.setSystemInfo("Reporter Name", "Nithesh");
		try {
			report.setSystemInfo("url",  fLib.getpropertykeyvalue("url"));
		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

	public void onFinish(ITestContext context) {
		//step4: flush report
		report.flush();

	}
}



