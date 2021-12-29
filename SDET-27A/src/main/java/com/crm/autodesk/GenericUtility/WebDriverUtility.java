package com.crm.autodesk.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



/**
 * its contains WebDriver specific reusable actions
 * @author 91917
 * 
 */

public class WebDriverUtility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM [HTML-Document]
	 * @param driver
	 */
	public void waitforpageToload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * wait for page to load before identifying any assychronisation[java scripts actions]elements in DOM[HTML-Document]
	 * @param driver
	 */
	public void waitForpageToLoadForJsElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

	}
	/**
	 * used  to wait for element to be clickable in GUi,& check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickAble(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to wait for element to be clickable in GUi,&check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 * @param polling Time in the form second
	 * @throws Throwable 
	 * @throws throwable
	 */
	public void waitForElementWithCustoMTimeOut(WebDriver driver,WebElement element,int pollingTime) throws Throwable {
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to switch to any window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void SwitchToWindow(WebDriver driver,String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String Wid = it.next();
			driver.switchTo().window(Wid);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * used to switch to alert window & click on ok button
	 * @param driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch to alert window & click on cancel button
	 * @param driver
	 */
	public void swithToAlertWindowAndcancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switchto Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to switch to window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * used to select the value from the dropDown based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);

	}
	/**
	 * used to select the value from the dropDown based on value/option avlable in GUi
	 * @param element
	 * @param value
	 */
	public void  select(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);

	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick().perform();

	}
	/**
	 * @param driver
	 * @param javaScript
	 */
	public void executejavaScript(WebDriver driver,String javaScript) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeAsyncScript(javaScript, null);
	}
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}

		}
	}
	public void takeScreenshot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(src, dest);
	}
	/**
	 * pass enter key appertain in to Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void Maximisewindow(WebDriver driver) {
		driver.manage().window().maximize();
	}



}
