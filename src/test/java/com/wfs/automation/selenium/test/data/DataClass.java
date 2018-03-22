package com.wfs.automation.selenium.test.data;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import com.wfs.automation.selenium.driver.TestSetUp;

public class DataClass {
		private static final Logger logger = Logger.getLogger(DataClass.class);
		@DataProvider(name="google-search-text")
		public static Object[][] getSearchTxt(){
			String[] searchTxt = TestSetUp.getTestDataProp().getProperty("test.google.search.txt").split(",");
			logger.info(" Search Texts are : "+ Arrays.asList(searchTxt));
			System.out.println("!!!!!!!!!!!!!!!!!!!");
			//Load the two dimensional array with the locale list results
			Object [][] texts = new Object[searchTxt.length][1];
			for (int x=0;x<texts.length;x++){
				texts[x][0] = searchTxt[x];
			}
			return texts;
		}			
}
