package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class Homepage extends WebDriverUtility{//step:1 create a separate class for home page
	//step :2 Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink ;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy (linkText = "Documents")
	private WebElement documentsLink;
	
	@FindBy (linkText = "Products")
	private WebElement productLink;
	
	@FindBy (linkText = "Email")
	private WebElement emailLink;
	
	@FindBy (linkText = "Trouble Tickets")
	private WebElement troubleTicketsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	//step 3: initialization
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 4:utilization

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getTroubleTicketsLink() {
		return troubleTicketsLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//business library to click on organizations
	public void clickonorganizationLink()
	{
		organizationsLink.click();
	}
	//business library to click on contacts
	public void clickoncontactlink()
	{
		contactsLink.click();
	}
	public void clickonproductlink()
	{
		productLink.click();
	}
	
	//business library for logout
	public void logout(WebDriver driver)
	{
		mouseOverOnElement(driver, administratorImg);
		signOutLink.click();
	}
	
	

	
	
	
	
	

}
