package com.automation.selenium.browserfactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.automation.selenium.driver.DriverConfig;
import com.automation.selenium.helper.OSDetails;

public class InternetExplorerDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {

    public InternetExplorerDriverFactory(final DriverConfig webDriverConfig) {
        super(webDriverConfig);
    }

    @Override
    public WebDriver createWebDriver() throws IOException {

        if (!OSDetails.isWindows()) {
            throw new RuntimeException("With gods grace IE browser is only supported on windows, Imagine a "
                    + "situation when you have to fix IE bugs on Unix and Mac as well");
        }

        killProcess();
        
        DriverConfig cfg = this.getWebDriverConfig();
		InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
		internetExplorerOptions.merge(new InternetExplorerDriverCapabilitiesFactory().createCapabilities(cfg));
        driver = new InternetExplorerDriver(internetExplorerOptions);

        // Implicit Waits to handle dynamic element.
        setImplicitWaitTimeout(cfg.getImplicitWaitTimeout());
        
        if (cfg.getPageLoadTimeout() >= 0) {
            driver.manage().timeouts().pageLoadTimeout(cfg.getPageLoadTimeout(), TimeUnit.SECONDS);
        }

        this.setWebDriver(driver);
        return driver;
    }

    private void killProcess() {
        if (OSDetails.isWindows()) {
            try {
            	OSDetails.execute("taskkill /F /IM IEDriverServer.exe");
            	OSDetails.execute("taskkill /F /IM Iexplore.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
