package com.crm.autodesk.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepository.Homepage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	/*Object Creation for Lib*/
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public DatabaseUtility dLib=new DatabaseUtility();


	@BeforeSuite (groups = {"smokeTest","RegressionTest"})
	public void dbconnection() {
		dLib.ConnectToDB();
		System.out.println("========================connect to DB========================");

	}
//@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","RegressionTest"})
	public void launchBrowser() throws Throwable
	{

		String URL = fLib.getpropertykeyvalue("url");
		String BROWSER = fLib.getpropertykeyvalue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		} else if(BROWSER.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");

		}
		sdriver=driver;
		wLib.waitforpageToload(driver);
		wLib.Maximisewindow(driver);
		driver.get(URL);
		System.out.println("=============Launch the Browser=======");

	}

	@BeforeMethod(groups = {"smokeTest","RegressionTest"})
	public void loginToApp() throws Throwable {
		/*common Data*/
		String USERNAME = fLib.getpropertykeyvalue("username");
		String PASSWORD = fLib.getpropertykeyvalue("password");
		LoginPage lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		System.out.println("login...successfull");


	}


	@AfterMethod(groups = {"smokeTest","RegressionTest"})
	public void logoutApp() {
		Homepage hp=new Homepage(driver);
		hp.logout(driver);
		System.out.println("...logout...succefull");

	}

	@AfterClass(groups = {"smokeTest","RegressionTest"})
	public void closeBrowser() {
		driver.quit();
		System.out.println("=============Close the Browser=======");

	}

	@AfterSuite
	public void closeDbconnection() {
		dLib.closeDB();
		System.out.println("========================close DB========================");
	}
}


