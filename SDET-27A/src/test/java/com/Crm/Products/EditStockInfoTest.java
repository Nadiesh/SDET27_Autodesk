package com.Crm.Products;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericUtility.BaseClass;


public class EditStockInfoTest extends BaseClass {
	@Test
	public  void EditStockInfoTest() throws Throwable {
  
String productname = fLib.getpropertykeyvalue("productname");
String editinfo = fLib.getpropertykeyvalue("editinfo");
 
   
      driver.findElement(By.linkText("Products")).click();
     driver.findElement(By.name("search_text")).sendKeys(productname);
     wLib.select(driver.findElement(By.id("bas_searchfield")), "Product Name");
      driver.findElement(By.name("submit")).click();
      driver.findElement(By.xpath("//a[@title='Products']")).click();
      wLib.mouseOverOnElement(driver, driver.findElement(By.id("mouseArea_Description")));
      driver.findElement(By.linkText("Edit")).click();
      driver.findElement(By.id("txtbox_Description")).sendKeys(editinfo);
      driver.findElement(By.name("button_Description")).click();
     
      



	}

}
