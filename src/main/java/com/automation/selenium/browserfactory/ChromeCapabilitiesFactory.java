package com.automation.selenium.browserfactory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.selenium.driver.DriverConfig;
import com.automation.selenium.driver.DriverMode;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class ChromeCapabilitiesFactory implements ICapabilitiesFactory {

    public DesiredCapabilities createCapabilities(final DriverConfig webDriverConfig) {

        // Set ChromeDriver for local mode
        if (webDriverConfig.getMode() == DriverMode.LOCAL) {
        	ChromeDriverManager.getInstance().setup(); 
        }
        
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        
        capability.setBrowserName(DesiredCapabilities.chrome().getBrowserName());

        ChromeOptions options = new ChromeOptions();
        
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        
        capability.setJavascriptEnabled(webDriverConfig.isEnableJavascript());
        capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        if (webDriverConfig.getBrowserVersion() != null) {
            capability.setVersion(webDriverConfig.getBrowserVersion());
        }

        if (webDriverConfig.getChromeBinPath() != null) {
            capability.setCapability("chrome.binary", webDriverConfig.getChromeBinPath());
        }
        
        return capability;
    }
}
