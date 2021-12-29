package com.Crm.Products;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.GenericUtility.ExcelUtility;
import com.crm.autodesk.GenericUtility.FileUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.autodesk.ObjectRepository.Homepage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.Productpage;

public class EditProductInfoTest extends BaseClass{
	@Test
public void EditProductInfoTest () throws Throwable {
		
String productname = fLib.getpropertykeyvalue("productname");
 
  	
     Homepage hp=new Homepage(driver);
     hp.clickonproductlink();
     
     Productpage pp=new Productpage(driver);
     pp.searchProduct(productname);
     wLib.select(driver.findElement(By.id("bas_searchfield")), "Product Name");
      driver.findElement(By.name("submit")).click();
      driver.findElement(By.xpath("//a[@title='Products']")).click();
      }

}
