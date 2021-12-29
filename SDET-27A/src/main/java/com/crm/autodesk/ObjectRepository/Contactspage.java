package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactspage {//step 1 create separate class
	
	//step 2 identify all the web elements
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	@FindAll({@FindBy(name = "search_text"),@FindBy(xpath = "//input[@class='txtBox']")})
	private WebElement searchtextEdt;
	
	@FindBy(name = "submit")
	private WebElement searchNowBtn;
	
	//step 3 initailize using constructor
	public Contactspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 4 utilization

	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}

	public WebElement getSearchtextEdt() {
		return searchtextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	//business Library
	public void clickoncreateContactImg()
	{
		createContactLookUpImg.click();
	}
	
	

}
