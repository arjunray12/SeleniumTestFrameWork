package com.wfs.automation.selenium.browserfactory;

import org.openqa.selenium.WebDriver;

import com.wfs.automation.selenium.driver.DriverConfig;

public interface IWebDriverFactory {

	WebDriver createWebDriver() throws Exception;

	WebDriver getWebDriver();

	DriverConfig getWebDriverConfig();
}
