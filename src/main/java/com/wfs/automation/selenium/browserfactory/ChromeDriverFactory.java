
package com.wfs.automation.selenium.browserfactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.wfs.automation.selenium.driver.DriverConfig;


public class ChromeDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {

    public ChromeDriverFactory(final DriverConfig cfg) {
        super(cfg);
    }

    protected WebDriver createNativeDriver() {
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.merge(new ChromeCapabilitiesFactory().createCapabilities(webDriverConfig));
        return new ChromeDriver(chromeOption);
    }

    @Override
    public WebDriver createWebDriver() throws IOException {
    	
    	DriverConfig cfg = this.getWebDriverConfig();

        driver = createNativeDriver();

        setImplicitWaitTimeout(cfg.getImplicitWaitTimeout());
        if (cfg.getPageLoadTimeout() >= 0) {
            setPageLoadTimeout(cfg.getPageLoadTimeout());
        }

        this.setWebDriver(driver);
        return driver;
    }

    protected void setPageLoadTimeout(final long timeout) {
        try {
            driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        } catch (UnsupportedCommandException e) { }
    }

}
