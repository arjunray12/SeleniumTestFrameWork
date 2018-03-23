package com.automation.selenium.browserfactory;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.selenium.driver.DriverConfig;
import com.automation.selenium.driver.DriverMode;

import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class InternetExplorerDriverCapabilitiesFactory implements ICapabilitiesFactory {

    public DesiredCapabilities createCapabilities(final DriverConfig cfg) {

        // Set IEDriver for Local Mode
        if (cfg.getMode() == DriverMode.LOCAL) {
			InternetExplorerDriverManager.getInstance().setup();
        }
        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        capability.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
        capability.setJavascriptEnabled(cfg.isEnableJavascript());
        capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability("ignoreZoomSetting", true);

        if (cfg.getBrowserVersion() != null) {
            capability.setVersion(cfg.getBrowserVersion());
        }
        
        capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        return capability;
    }
}
