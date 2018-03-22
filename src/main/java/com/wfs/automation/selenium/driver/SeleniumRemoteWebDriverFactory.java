package com.wfs.automation.selenium.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Strings;
import com.wfs.automation.selenium.browserfactory.ChromeCapabilitiesFactory;
import com.wfs.automation.selenium.browserfactory.FirefoxCapabilitiesFactory;
import com.wfs.automation.selenium.browserfactory.InternetExplorerDriverCapabilitiesFactory;

public class SeleniumRemoteWebDriverFactory {
	private static final Logger logger = Logger.getLogger(SeleniumRemoteWebDriverFactory.class);

	/**
	 * Create Web Driver based on the browser type passed as the input parameter.
	 * 
	 * @param browserTypeEnum - the browser type
	 * 
	 * @return the Web Driver instance
	 */
	public static WebDriver getWebDriver(BrowserType browserTypeEnum) throws MalformedURLException{
		
		logger.debug("Get Remote Web Driver for "+browserTypeEnum);

		Capabilities capabilities = getDesiredCapabilities(browserTypeEnum);
		
		String hubURL = TestSetUp.getDriverConfig().getHubUrl();
		
		logger.info("Hub URL is : "+hubURL);
		
		if(Strings.isNullOrEmpty(hubURL)){
			throw new RuntimeException("Hub URL is null or empty");
		}
		
		WebDriver webDriver = new RemoteWebDriver(new URL(hubURL), capabilities);
		
		//maximize the window size
		logger.debug("Going to maximize Remote Web Browser for "+browserTypeEnum);
		
		webDriver.manage().window().maximize();
		
		return webDriver;
	}
	
	 /**
	  * Helper method to call appropriate methods on DesiredCapabilities object.  
	  * This will likely need to be updated as the tests want
	  * to call on more specific capabilities.
	  */
	 private static DesiredCapabilities getDesiredCapabilities(BrowserType browserTypeEnum){
	        DesiredCapabilities capabilities = null;	        
	        
	        switch (browserTypeEnum) {
			case IE:
				capabilities = new InternetExplorerDriverCapabilitiesFactory().createCapabilities(TestSetUp.getDriverConfig());
				break;
			case CHROME:
				capabilities = new ChromeCapabilitiesFactory().createCapabilities(TestSetUp.getDriverConfig());
				break;
			case FIREFOX:
				capabilities = new FirefoxCapabilitiesFactory().createCapabilities(TestSetUp.getDriverConfig());
				break;
			default:
				throw new RuntimeException("Invalid BrowserType passed");
			}
	        
	        return capabilities;
	   }
}
