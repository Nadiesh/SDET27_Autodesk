package com.AutoDesk.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.GenericUtility.FileUtility;
import com.crm.autodesk.GenericUtility.JavaUtility;
import com.crm.autodesk.GenericUtility.WebDriverUtility;
import com.crm.autodesk.ObjectRepository.ContactsInfopage;
import com.crm.autodesk.ObjectRepository.Contactspage;
import com.crm.autodesk.ObjectRepository.CreateContactpage;
import com.crm.autodesk.ObjectRepository.Homepage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class CreateContacttTest extends BaseClass {
	@Test
    public  void CreateContacttTest()  throws Throwable {

		int randomNum = jLib.getRanDomNumber();
		jLib.getRanDomNumber();
		String contactName = eLib.getDataFromExcel("Org", 4, 6)+randomNum;

		//navigate to contact module
		Homepage hp =new Homepage(driver);
		hp.clickoncontactlink();
		
		//create contact
		Contactspage cp= new Contactspage(driver);
		cp.clickoncreateContactImg();
		CreateContactpage ccp = new CreateContactpage(driver);
		ccp.createContact(contactName);
		
		//verifying
		ContactsInfopage cop=new ContactsInfopage(driver);
		String actualResult = cop.getcontactHeaderInfoText();
		
	  Assert.assertTrue(actualResult.contains(contactName));
	
	  System.out.println("contact created sucessfully");

	}

}
