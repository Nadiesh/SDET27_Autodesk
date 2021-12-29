package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchType;
	
	@FindBy(name = "submit")
	private WebElement searchBtn;

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchType() {
		return searchType;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public  Productpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String productname)
	{
		searchEdt.sendKeys(productname);
	}
	
	
	

}
