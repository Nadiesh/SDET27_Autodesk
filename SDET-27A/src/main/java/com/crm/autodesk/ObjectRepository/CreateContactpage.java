package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class CreateContactpage extends WebDriverUtility {
	//declaration
	@FindBy(name = "lastname")
	private WebElement contactlastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement orgNameLookupImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	 private WebElement selectOrg;
	
	@FindBy(name = "search_text")
	private WebElement orgsearchTextEdt;
	
	@FindBy(name = "search")
	private WebElement orgSearchBtn;
	
	//intialization
	public CreateContactpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
   //utilization
	public WebElement getContactlastNameEdt() {
		return contactlastNameEdt;
	}

	public WebElement getOrgNameLookupImg() {
		return orgNameLookupImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSelectOrg() {
		return selectOrg;
	}
	
	public WebElement getOrgsearchTextEdt() {
		return orgsearchTextEdt;
	}
	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	//business Library for create contact
	public void createContact(String lastname)
	{
		contactlastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	//business library for 
	public void createContactwithOrga(WebDriver driver,String lastname,String orgName)
	{
		contactlastNameEdt.sendKeys(lastname);
		orgNameLookupImg.click();
		SwitchToWindow(driver, "Accounts");
		orgsearchTextEdt.sendKeys(orgName);
		orgSearchBtn.click();
		driver.findElement(By.linkText(orgName)).click();
		SwitchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	
	}


