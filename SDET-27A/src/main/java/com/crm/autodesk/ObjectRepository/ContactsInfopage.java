package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfopage {
	//declaration
	@FindBy(xpath =  "//span[@class='dvHeaderText']")
	private WebElement contactHeaderInfoText;
	
	//initialization
	public ContactsInfopage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public String  getcontactHeaderInfoText() {
		return (contactHeaderInfoText.getText());
		}

}
