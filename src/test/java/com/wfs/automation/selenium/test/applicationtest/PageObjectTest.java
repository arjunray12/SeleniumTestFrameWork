package com.wfs.automation.selenium.test.applicationtest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wfs.automation.selenium.driver.SeleniumBase;
import com.wfs.automation.selenium.helper.TestHelper;
import com.wfs.automation.selenium.test.pages.BlogTestPage;
import com.wfs.automation.selenium.test.pages.GoogleHomePage;

public class PageObjectTest extends SeleniumBase {
	private static final Logger logger = Logger.getLogger(PageObjectTest.class);

	/**
	 * This Is Created To Go the Base Page Before Every Test
	 */

	@BeforeMethod
	public void testMethodSetUp() {
		logger.info("BeforeMethod Called For Default Page Load");
		
	}

	@Test
	public void testSubmit() throws Exception {
		driver.get("http://startingwithseleniumwebdriver.blogspot.in/2013/12/frmset1.html");
		logger.info("---------------testSubmit Start---------------");
		BlogTestPage blog = new BlogTestPage(driver);
		blog.submitForm("Test");
		TestHelper.takeScreenShoot(driver, "testSubmit");
		logger.info("---------------testSubmit Complete---------------");
	}

//	@Test(dataProviderClass = DataClass.class, dataProvider = "google-search-text")
	public void testGoogleLink(String searchTxt) throws Exception {
		driver.get("http://startingwithseleniumwebdriver.blogspot.in/2013/12/frmset1.html");
		logger.info("---------------testGoogleLink Start With "+searchTxt+"---------------");
//		BlogTestPage blog = PageFactory.initElements(driver, BlogTestPage.class);
		BlogTestPage blog = new BlogTestPage(driver);
//		blog.clickonGoogleLink().searchTxt(searchTxt);
		Assert.assertEquals(searchTxt, new GoogleHomePage(driver).getSearchTxt());
		logger.info("---------------testGoogleLink Complete With "+searchTxt+"---------------");
	}

}