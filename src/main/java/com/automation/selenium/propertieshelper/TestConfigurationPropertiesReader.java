package com.automation.selenium.propertieshelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestConfigurationPropertiesReader {

	private static TestConfigurationPropertiesReader propfile;
	private Properties properties;

	/**
	 * Implemented Singleton Design Pattern.
	 */
	
	public static TestConfigurationPropertiesReader getInstance() {
		if (propfile == null) {
			propfile = new TestConfigurationPropertiesReader();
		}
		return propfile;
	}

	private TestConfigurationPropertiesReader() {

		try {
			File file = new File("./src/test/resources/test.properties");
			FileInputStream fileInputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTestConfigurationPropertyValue(String property){
		return properties.getProperty(property);
	}
	
	public Properties getgetTestConfigurationProperties(){
		return properties;
	}
}
