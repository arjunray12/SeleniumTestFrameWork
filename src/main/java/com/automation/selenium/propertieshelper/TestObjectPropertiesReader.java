package com.automation.selenium.propertieshelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestObjectPropertiesReader {

	private static TestObjectPropertiesReader propfile;
	private Properties properties;

	/**
	 * Implemented Singleton Design Pattern.
	 */
	
	public static TestObjectPropertiesReader getInstance() {
		if (propfile == null) {
			propfile = new TestObjectPropertiesReader();
		}
		return propfile;
	}

	private TestObjectPropertiesReader() {

		try {
			File file = new File("./src/test/resources/test-object.properties");
			FileInputStream fileInputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTestObjectPropertyValue(String property){
		return properties.getProperty(property);
	}
	
	public Properties getTestObjectProperties(){
		return properties;
	}
}
