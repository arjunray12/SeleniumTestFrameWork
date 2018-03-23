package com.automation.selenium.browserfactory;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.selenium.driver.DriverConfig;

public interface ICapabilitiesFactory {

	DesiredCapabilities createCapabilities(DriverConfig cfg);
}
