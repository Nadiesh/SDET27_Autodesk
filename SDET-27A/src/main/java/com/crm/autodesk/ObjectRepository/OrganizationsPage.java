package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {//step 1
	//step 2
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchTextEdit;
	
	@FindBy(name = "submit")
	private WebElement searchNowbtn;
	
	//step 3
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step 4

	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}

	public WebElement getSearchTextEdit() {
		return searchTextEdit;
	}

	public WebElement getSearchNowbtn() {
		return searchNowbtn;
	}
	//business library
	public void clickoncreateOrg() 
	{
	createOrgLookUpImg.click();	
	
	

		
	}
	
	

}
