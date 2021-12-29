package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfopage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;

	public OrganizationInfopage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	public String getOrginfo()
	{
		return (orgHeaderText.getText());
		
	}

}
