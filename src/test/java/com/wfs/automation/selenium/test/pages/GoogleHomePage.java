package com.wfs.automation.selenium.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class GoogleHomePage { 
    private final By searchBox=By.name("q");
//    private final WebElement searchBox;
    private final WebDriver driver;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver; 
//      this.searchBox=driver.findElement(By.name("q"));
    }

	/**
	 * This Method Return Goole Page Object Because After Click On Search
	 * Button Redirect To The Google Page
	 * 
	 * @param searchTxt
	 * @return
	 */
    public GoogleHomePage searchTxt(String searchTxt){
      driver.findElement(searchBox).sendKeys(searchTxt); 
//      searchBox.sendKeys(searchTxt);
    return new GoogleHomePage(driver);
    }
    
    public String getSearchTxt(){ 
      return driver.findElement(searchBox).getAttribute("value");
      }
}