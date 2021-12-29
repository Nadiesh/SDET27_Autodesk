package com.AutoDesk.contacts;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.LogOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.GenericUtility.ExcelUtility;
import com.crm.autodesk.GenericUtility.FileUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.autodesk.ObjectRepository.ContactsInfopage;
import com.crm.autodesk.ObjectRepository.Contactspage;
import com.crm.autodesk.ObjectRepository.CreateContactpage;
import com.crm.autodesk.ObjectRepository.CreateOrganizationpage;
import com.crm.autodesk.ObjectRepository.Homepage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfopage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;



public class createContactwithOrgTest extends BaseClass{

	@Test
	public  void createContactwithOrgTest() throws Throwable {
		int randomNum = jLib.getRanDomNumber();

		String Orgname = eLib.getDataFromExcel("Org", 4, 2)+randomNum;
		String contactName = eLib.getDataFromExcel("Org", 4, 6)+randomNum;

	   //navigate to org page
		Homepage hp = new Homepage(driver);
		hp.clickonorganizationLink();
		
		//navigate to Create org page
		OrganizationsPage op =new OrganizationsPage(driver);
		op.clickoncreateOrg();

		CreateOrganizationpage cop= new CreateOrganizationpage(driver);
		cop.createorg(Orgname);
		
		wLib.waitForElementToBeClickAble(driver, driver.findElement(By.className("dvHeaderText")));
		
		hp.clickoncontactlink();

		//navigate to contact page
		Contactspage cp=new Contactspage(driver);
		cp.clickoncreateContactImg();


		//create new contact with Orgname
		CreateContactpage ccp=new CreateContactpage(driver);
		ccp.createContactwithOrga(driver, contactName, Orgname);
		
		ContactsInfopage cip=new ContactsInfopage(driver);
		String success = cip.getcontactHeaderInfoText();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(success.contains(contactName));
		System.out.println(success);
		sa.assertAll();
		

	}
}


