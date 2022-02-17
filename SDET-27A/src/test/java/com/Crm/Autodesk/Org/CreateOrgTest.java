package com.Crm.Autodesk.Org;



import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.CreateOrganizationpage;
import com.crm.autodesk.ObjectRepository.Homepage;
import com.crm.autodesk.ObjectRepository.OrganizationInfopage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
@Listeners(com.crm.autodesk.GenericUtility.ListImpClass.class)
public class CreateOrgTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {
		//get RanDom
        int randomNum = jLib.getRanDomNumber();
      
		//read test data from Excel
		String Orgname = eLib.getDataFromExcel("Org", 4, 2)+randomNum;
		
		//step :2 navigate to org page
		Homepage hp=new Homepage(driver);
		hp.clickonorganizationLink();
		
		//step :3 navigate to Create org page
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickoncreateOrg();
		Assert.fail();
		
		//step 4: create new org
     CreateOrganizationpage cop=new CreateOrganizationpage(driver);
     cop.createorg(Orgname);
     
     //step 5: verify organization name in header of the msg
		 OrganizationInfopage oip=new OrganizationInfopage(driver);
		 String Actmsg = oip.getOrginfo();
		 
		 Assert.assertTrue(Actmsg.contains(Orgname));
		  System.out.println("contact created sucessfully");
		
}
	//@Test
	//public void demoTest() {
	//	System.out.println("its working");
//	}
	
}
