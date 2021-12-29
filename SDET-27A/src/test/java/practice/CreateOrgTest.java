package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {

	public static void main(String[] args) throws Throwable {
		//read common data from properties file
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
        Properties pobj=new Properties();
        pobj.load(fis);
       String url = pobj.getProperty("url");
      String username = pobj.getProperty("username");
     String password = pobj.getProperty("password");
    String browser = pobj.getProperty("browser");
    //get random num
    Random ran =new Random();
   int ranDomNum = ran.nextInt(10000);
   //read test data from Excel File
   FileInputStream fis_e=new FileInputStream("./data/testdata.xlsx");
  Workbook wb = WorkbookFactory.create(fis_e);
  Sheet sh = wb.getSheet("Org");
   Row row = sh.getRow(1);
  String orgname = row.getCell(2).getStringCellValue()+ranDomNum;
  WebDriver driver;
  if(browser.equals("firefox")) {
  	driver=new FirefoxDriver();
  }else if(browser.equals("chrome")){
  	driver=new ChromeDriver();
  }
  else if(browser.equals("IE")){
  driver=new InternetExplorerDriver();	
  }
  else {
  	driver=new ChromeDriver();
  }
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  driver.get(url);
  driver.findElement(By.name("user_name")).sendKeys("admin");
  driver.findElement(By.name("user_password")).sendKeys("admin");
  driver.findElement(By.id("submitButton")).click();
  driver.findElement(By.linkText("Organizations")).click();
  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
  driver.findElement(By.name("accountname")).sendKeys(orgname);
  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
  String a = driver.findElement(By.className("dvHeaderText")).getText();
  if(a.contains(orgname)) {
	  System.out.println("org is sucessufully created...pass");
  }else {
	  System.out.println("org is not created..fail");
  }
  Actions act=new Actions(driver);
  act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
  driver.findElement(By.linkText("Sign Out")).click();
  driver.close();
    
     
        		
	}

}
