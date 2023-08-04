package com.pageobjects.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class SearchPage {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	By searchBox = By.xpath("//*[@id='twotabsearchtextbox']");
	By searchButton = By.xpath("//*[@id='nav-search-submit-button']");
	By searchFirstresult = By.xpath("//div[@data-component-type='s-search-result'][1]//span[contains(text(),'Apple iPhone')]");
	public void searchItem(String searchItemName) throws InterruptedException {
		boolean flag = false;
		try {
		Thread.sleep(2000);
		driver.findElement(searchBox).sendKeys(searchItemName);
		driver.findElement(searchButton).click();
		String searchResultTextValue = driver.findElement(searchFirstresult).getText();
		
		if(searchResultTextValue.contains("Apple iPhone")) {
			flag = true;
			softAssert.assertTrue(flag);
			softAssert.assertAll();
			}else {
				Assert.fail("Apple iPhone not found");
			}
		}catch(Exception e){
			Reporter.log(e.getMessage());
			Assert.fail();
			
		}

	}
}
