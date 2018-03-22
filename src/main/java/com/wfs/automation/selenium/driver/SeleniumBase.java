package com.wfs.automation.selenium.driver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SeleniumBase {

	private static final Logger logger = Logger.getLogger(SeleniumBase.class);

	protected static WebDriver driver = null;

	protected String browserType = null;
	
	/**
	 * Initialization of Log4j configuration. 
	 */
	static{
		DOMConfigurator.configure("./log4j.xml");
//		PropertyConfigurator.configure("./Log4j.properties");
	}
	
	@BeforeSuite
	@Parameters(value = "browser")
	public final void initializeBeforeSuite(String browser, ITestContext iTestCtx) throws IOException {
		logger.info("BeforeSuite Called");
		if (iTestCtx.getSuite().getParallel().equalsIgnoreCase("false")||iTestCtx.getSuite().getParallel().equalsIgnoreCase("none")) {
			initializeDriver(browser);	
		}
	}

	@BeforeTest
	@Parameters(value = "browser")
	public final void initializeBeforeTest(String browser, ITestContext iTestCtx) throws IOException {
		logger.info("BeforeTest Called");
		if (iTestCtx.getSuite().getParallel().equalsIgnoreCase("tests")) {
			initializeDriver(browser);	
		}
	}

	@BeforeClass
	@Parameters(value = "browser")
	public final void initializeBeforeClass(String browser, ITestContext iTestCtx) throws IOException {
		logger.info("BeforeClass Called");
		if (iTestCtx.getSuite().getParallel().equalsIgnoreCase("classes")) {
			initializeDriver(browser);	
		}
	}

	@BeforeMethod
	@Parameters(value = "browser")
	public final void initializeBeforeMethod(String browser, ITestContext iTestCtx) throws IOException {
		logger.info("BeforeMethod Called");
		if (iTestCtx.getSuite().getParallel().equalsIgnoreCase("methods")) {
			initializeDriver(browser);			
		}
	}

	public void initializeDriver(String browser) throws IOException{
		browserType = browser;
		BrowserType browserTypeEnum = BrowserType.valueOf(browser);
		driver = SeleniumDriverManager.getWebDriver(browserTypeEnum);
		if(TestSetUp.getDriverConfig().isEnabledEventDriver()){
			WebDriverEventListener evtlistner=new CustomEventListner();
			driver = new EventFiringWebDriver(driver).register(evtlistner);
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public final void destroySuiteLevelBrowser(ITestContext iTestCtx) {
		if (iTestCtx.getSuite().getParallel().equalsIgnoreCase("false")||iTestCtx.getSuite().getParallel().equalsIgnoreCase("none")) {
			logger.info("After Suite Run, going to close the open browser " + browserType);
			quitDriver();
		}
	}

	@AfterTest(alwaysRun = true)
	public final void destroyTestLevelBrowser(ITestContext iTestCtx) {
		if (iTestCtx.getSuite().getParallel().equalsIgnoreCase("tests")||iTestCtx.getSuite().getParallel().equalsIgnoreCase("false")) {
			logger.info("After Test Run, going to close the open browser " + browserType);
			quitDriver();
		}
	}

	@AfterClass(alwaysRun = true)
	public final void destroyClassLevelBrowser(ITestContext iTestCtx) {
		if (iTestCtx.getSuite().getParallel().equalsIgnoreCase("classes")) {
			logger.info("After Class Run, going to close the open browser " + browserType);
			quitDriver();
		}
	}

	@AfterMethod(alwaysRun = true)
	public final void destroyMethodLevelBrowser(ITestContext iTestCtx) {
		if (iTestCtx.getSuite().getParallel().equalsIgnoreCase("methods")) {
			logger.info("After Method Run, going to close the open browser " + browserType);
			quitDriver();
		}
	}
	public void quitDriver(){
		if (driver != null) {
			SeleniumDriverManager.quitWebDriver(driver, browserType);
		} else {
			logger.warn("Driver instance not available for close in the destroy method for " + browserType);
		}
	}
}
