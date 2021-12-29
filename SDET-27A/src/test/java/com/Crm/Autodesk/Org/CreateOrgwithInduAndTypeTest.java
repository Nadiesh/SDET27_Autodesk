package com.Crm.Autodesk.Org;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.GenericUtility.BaseClass;
import com.crm.autodesk.ObjectRepository.CreateOrganizationpage;
import com.crm.autodesk.ObjectRepository.Homepage;
import com.crm.autodesk.ObjectRepository.OrganizationInfopage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;

public class CreateOrgwithInduAndTypeTest extends BaseClass
{
	

	@Test(groups = "RegressionTest")
	public void CreateOrgwithInduAndTypeTest() throws Throwable {
		

		int randomNum = jLib.getRanDomNumber();

		

		String Orgname = eLib.getDataFromExcel("Org", 4, 2)+randomNum;
		String industryname= eLib.getDataFromExcel("Org", 4, 3);
		String typename = eLib.getDataFromExcel("Org", 4, 4);

       //step:2 navigate to Org Module
		Homepage hp=new Homepage(driver);
		hp.clickonorganizationLink();
		//step :3 click on create Org button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickoncreateOrg();
		//step 4:Enter all the details & and create new Organization
		CreateOrganizationpage co=new CreateOrganizationpage(driver);
		co.createOrgwithIndustryandType(Orgname, industryname, typename);
		//step 5 verification
		OrganizationInfopage oif=new OrganizationInfopage(driver);
		String msg = oif.getOrginfo();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(msg.contains(Orgname));
		System.out.println("orgname created");
		sa.assertAll();
		
		}

}
