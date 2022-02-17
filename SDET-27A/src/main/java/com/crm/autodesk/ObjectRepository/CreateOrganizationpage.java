package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class CreateOrganizationpage extends WebDriverUtility {
	@FindBy(name = "accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typedropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateOrganizationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypedropDown() {
		return typedropDown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	//business library for create organization
	public void createorg(String orgName)
	{
		organizationNameEdt.sendKeys(orgName);
		savebtn.click();
	}
	//business library for create organiZation with industry drop down
	public void  createOrgwithIndustryandType(String orgname,String industry,String type) {
		organizationNameEdt.sendKeys(orgname);
		select(industryDropDown,industry);
		select(typedropDown,type);
		savebtn.click();
	}	
	

}
