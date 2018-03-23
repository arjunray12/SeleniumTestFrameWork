package com.automation.selenium.driver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.browserfactory.ChromeDriverFactory;
import com.automation.selenium.browserfactory.FirefoxDriverFactory;
import com.automation.selenium.browserfactory.InternetExplorerDriverFactory;

public class SeleniumLocalWebDriverFactory {
	private static final Logger logger = Logger.getLogger(SeleniumLocalWebDriverFactory.class);

	/**
	 * Create Web Driver based on the browser type passed as the input parameter.
	 * 
	 * @param browserTypeEnum - the browser type
	 * 
	 * @return the Web Driver instance
	 * @throws IOException 
	 */
	
	public static WebDriver getWebDriver(BrowserType browserTypeEnum) throws IOException{
		
		logger.debug("Get Local Web Driver for "+browserTypeEnum);
		
		WebDriver webDriver = null;
		DriverConfig cfg = TestSetUp.getDriverConfig();
		logger.info(cfg);
		switch (browserTypeEnum) {
		case IE:
			webDriver = new InternetExplorerDriverFactory(cfg).createWebDriver();
			break;
		case CHROME:
			webDriver = new ChromeDriverFactory(cfg).createWebDriver();
			break;
		case FIREFOX:
			webDriver = new FirefoxDriverFactory(cfg).createWebDriver();
			break;
		default:
			throw new RuntimeException("Invalid BrowserType passed");
		}
		
		//maximize the window size
		if(browserTypeEnum == BrowserType.IE
				|| browserTypeEnum == BrowserType.CHROME || browserTypeEnum == BrowserType.FIREFOX){
			webDriver.manage().window().maximize();
		}
		
		return webDriver;
	}
}
