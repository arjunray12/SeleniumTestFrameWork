package com.wfs.automation.selenium.browserfactory;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.wfs.automation.selenium.driver.DriverConfig;

public interface ICapabilitiesFactory {

	DesiredCapabilities createCapabilities(DriverConfig cfg);
}
