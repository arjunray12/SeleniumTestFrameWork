package com.automation.selenium.browserfactory;

import org.openqa.selenium.WebDriver;

import com.automation.selenium.driver.DriverConfig;

public interface IWebDriverFactory {

	WebDriver createWebDriver() throws Exception;

	WebDriver getWebDriver();

	DriverConfig getWebDriverConfig();
}
