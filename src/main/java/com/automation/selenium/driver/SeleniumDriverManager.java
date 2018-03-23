package com.automation.selenium.driver;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SeleniumDriverManager {
	private static final Logger logger = Logger.getLogger(SeleniumDriverManager.class);
	private static ThreadLocal<WebDriver> threadWebDriver = new ThreadLocal<WebDriver>();
	public static WebDriver getWebDriver(BrowserType browserTypeEnum) throws IOException {
		WebDriver currentDriver = threadWebDriver.get();
		/**
		 * Get the driver currently used for the thread.
		 * Lazy loaded, if there is not driver yet, create it.
		 */
		
		if (currentDriver == null)
		{
			TestSetUp.setDriverConfiguration();
			DriverMode remoteDriver = TestSetUp.getDriverConfig().getMode();
			
			if(remoteDriver == DriverMode.REMOTE){
				logger.debug("Creating remote web driver instance for "+browserTypeEnum);
				try {
					currentDriver = SeleniumRemoteWebDriverFactory.getWebDriver(browserTypeEnum);
				} catch (MalformedURLException e) {
					throw new RuntimeException("Error occured while instantiating remote web driver for "+browserTypeEnum,e);
				}
			}else{
				logger.debug("Creating local web driver instance for "+browserTypeEnum);
				currentDriver = SeleniumLocalWebDriverFactory.getWebDriver(browserTypeEnum);
			}
			threadWebDriver.set(currentDriver);
		}
		return threadWebDriver.get();
	}

	public static void quitWebDriver(WebDriver driver, String browserType) {
		WebDriver currentDriver = threadWebDriver.get();
		if (currentDriver != null) {
			currentDriver.manage().deleteAllCookies();
			currentDriver.quit();
			threadWebDriver.set(null);
		}
	}
}
