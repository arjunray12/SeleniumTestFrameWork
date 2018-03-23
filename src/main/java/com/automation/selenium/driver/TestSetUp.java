package com.automation.selenium.driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.automation.selenium.propertieshelper.TestConfigurationPropertiesReader;
import com.google.common.base.Strings;

public class TestSetUp {
	private static final Logger logger = Logger.getLogger(TestSetUp.class);
	private static DriverConfig driverConfig = new DriverConfig();
	private static Properties testDataProp;

	/**
	 * 
	 * Returns properties captured from test-data.properties file located under testdata folder.
	 * 
	 */
	public static Properties getTestDataProp() {
		try {
			if(testDataProp == null){
				testDataProp = new Properties();
				testDataProp.load(new FileInputStream("./src/test/resources/testdata/test-data.properties"));	
			}
		} catch (IOException e) {
			logger.error("Error occured while loading test-data.properties", e);
		}
		return testDataProp;
	}

	/**
	 * Returns the indicator whether test would run in local or remote.
	 * 
	 * @return true|false
	 */
	private static boolean isRemoteTestRun(){
		boolean isRemoteTestRun = false;
		logger.debug("Loading Test Run Environment from the system property");
		String runEnvFromSystem = System.getProperty("test.run.env");
		logger.debug("Test Run Environment from system properties " + runEnvFromSystem);
		isRemoteTestRun = runEnvFromSystem != null && "remote".equalsIgnoreCase(runEnvFromSystem);
		if (!isRemoteTestRun) {
			logger.debug("Loading Test Run Environment from the test.properties");
			String runEnvFromProperties = TestConfigurationPropertiesReader.getInstance().getTestConfigurationPropertyValue("test.run.env");
			logger.debug("Test Run Environment from test.properties file " + runEnvFromProperties);
			isRemoteTestRun = runEnvFromProperties != null && "remote".equalsIgnoreCase(runEnvFromProperties);
		} 

		if(!isRemoteTestRun){
			logger.debug("Loading Test Run Environment from the DriverConig Class");
			DriverMode runEnvFromDriverConfig = driverConfig.getMode();
			logger.debug("Test Run Environment from the DriverConig Class " + runEnvFromDriverConfig);
			isRemoteTestRun = runEnvFromDriverConfig == DriverMode.REMOTE ? true : false ;	
		}
		return isRemoteTestRun;
	}

	/**
	 * 
	 * @return the HUB URL - required for remote web driver.
	 */
	private static String getTestHubURL(){
		logger.debug("Loading Test HUB URL from the system property");
		String hubURL = System.getProperty("test.hub.url");
		if(Strings.isNullOrEmpty(hubURL)){
			logger.debug("Loading Test HUB URL from the test.properties");
			hubURL = TestConfigurationPropertiesReader.getInstance().getTestConfigurationPropertyValue("test.hub.url");
			logger.debug("Loaded Test HUB URL from test.properties file " + hubURL);
		}

		if(Strings.isNullOrEmpty(hubURL)){
			logger.debug("Loading Test HUB URL from the DriverConig Class");
			hubURL = driverConfig.getHubUrl();
			logger.debug("Loaded Test HUB URL from the DriverConig Class " + hubURL);
		}
		return hubURL;
	}


	/**
	 * Returns the indicator whether test would run in local or remote.
	 * 
	 * @return true|false
	 */
	private static boolean isEventListnerDriver(){
		boolean isEventListnerDriver = false;
		logger.debug("Loading EventListner Driver settings from the system property");
		String eventEnabledDriverFromSystem = System.getProperty("test.driver.eventenabled");
		logger.debug("EventListner Driver settings from system properties " + eventEnabledDriverFromSystem);
		isEventListnerDriver = eventEnabledDriverFromSystem != null && "true".equalsIgnoreCase(eventEnabledDriverFromSystem);
		if (!isEventListnerDriver) {
			logger.debug("Loading EventListner Driver settings from the test.properties");
			String eventEnabledDriverFromProperties = TestConfigurationPropertiesReader.getInstance().getTestConfigurationPropertyValue("test.driver.eventenabled");
			logger.debug("EventListner Driver settings from test.properties file " + eventEnabledDriverFromProperties);
			isEventListnerDriver = eventEnabledDriverFromProperties != null && "true".equalsIgnoreCase(eventEnabledDriverFromProperties);
		} 

		if(!isEventListnerDriver){
			logger.debug("Loading EventListner Driver settings from the DriverConig Class");
			boolean eventEnabledDriverFromDriverConfig = driverConfig.isEnabledEventDriver();
			logger.debug("EventListner Driver settings from the DriverConig Class " + eventEnabledDriverFromDriverConfig);
			isEventListnerDriver = eventEnabledDriverFromDriverConfig;
		}
		return isEventListnerDriver;
	}
	
	public static void setDriverConfiguration(){
		logger.debug("Set all driver configuration");
		boolean remote = isRemoteTestRun();
		if(remote){
			logger.debug("Set driver mode as 'REMOTE'");	
			driverConfig.setMode(DriverMode.REMOTE);
			String hubURL = getTestHubURL();
			logger.debug("Set hub configuration");	
			driverConfig.setHubUrl(hubURL);
		}
		else{
			logger.debug("Set driver mode as 'LOCAL'");	
			driverConfig.setMode(DriverMode.LOCAL);
		}
		
		driverConfig.setEnableEventDriver(isEventListnerDriver());
	}
	public static DriverConfig getDriverConfig() {
		logger.debug("Get configuration Of WebDriver");
		return driverConfig;
	}
}
