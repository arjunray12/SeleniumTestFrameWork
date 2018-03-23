package com.automation.selenium.test.data;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import com.automation.selenium.driver.TestSetUp;

public class DataClass {
		private static final Logger logger = Logger.getLogger(DataClass.class);
		@DataProvider(name="login")
		public static Object[][] getSearchTxt(){
			String[] searchTxt = TestSetUp.getTestDataProp().getProperty("test.login").split(",");
			logger.info(" Login Details : "+ Arrays.asList(searchTxt));
			//Load the two dimensional array with the locale list results
			Object [][] texts = new Object[searchTxt.length][1];
			for (int x=0;x<texts.length;x++){
				texts[x][0] = searchTxt[x];
			}
			return texts;
		}			
}
