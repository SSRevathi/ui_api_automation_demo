package com.testcases.uiautomation;

import org.testng.annotations.Test;

import com.pageobjects.uiautomation.SearchPage;

public class SearchTest extends BaseTest{

	@Test
	public void SearchTest() throws InterruptedException {
		SearchPage searchIphone = new SearchPage(driver);
		searchIphone.searchItem("iphone");
		
	}
	
}
