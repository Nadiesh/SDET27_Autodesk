package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Oppurtunitiespage {
	@FindBy(name = "search_text")
	private WebElement SearchEdt;
	
	public Oppurtunitiespage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}
	public void searchOppurtunities()
	{
		SearchEdt.sendKeys("oppurtunities");
	}

}
