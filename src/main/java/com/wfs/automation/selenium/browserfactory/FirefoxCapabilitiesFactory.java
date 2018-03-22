
package com.wfs.automation.selenium.browserfactory;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.wfs.automation.selenium.driver.DriverConfig;
import com.wfs.automation.selenium.driver.DriverMode;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class FirefoxCapabilitiesFactory implements ICapabilitiesFactory {

    /**
     * Create firefox capabilities.
     */
    public DesiredCapabilities createCapabilities(final DriverConfig webDriverConfig) {
    	
        // Set ChromeDriver for local mode
        if (webDriverConfig.getMode() == DriverMode.LOCAL) {
        	FirefoxDriverManager.getInstance().setup();
        }
        
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName(DesiredCapabilities.firefox().getBrowserName());

        capability.setJavascriptEnabled(webDriverConfig.isEnableJavascript());
        capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        if (webDriverConfig.getBrowserVersion() != null) {
            capability.setVersion(webDriverConfig.getBrowserVersion());
        }

        return capability;
    }
}
