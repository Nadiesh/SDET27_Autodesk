	package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{//step 1:create a separate class for web page
	//step 2: identify allwebelements and declare them on private
	@FindBy(name =  "user_name")
	private WebElement usernameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginbtn;
	
	//step 3: initialise the elements using constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//step 4 utilization provide getter methods

	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	//business library 
	public void Login(String username,String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();
	}
	
	
	
	

}
