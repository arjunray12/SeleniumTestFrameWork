package com.wfs.automation.selenium.test.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BlogTestPage {
	
	@FindBy(name = "txtbox1")
    private WebElement inputBox;
	
	@FindBy(name = "btnsub")
	private WebElement submitBtn;
	
	@FindBy(linkText ="Google")
    private WebElement googleLink;
    
    private final WebDriver driver;
   
    public BlogTestPage(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
   
     
	/**
	 * This Method Return BlogPage Object Because After Submit It's Stay On The
	 * Same Page
	 * 
	 * @param inputTxt
	 * @return
	 */
    public BlogTestPage submitForm(String inputTxt){
        inputBox.sendKeys(inputTxt);
        submitBtn.click();
    return new BlogTestPage(driver);
    }    

	/**
	 * This Method Return GoolePage Object Because After Click On This Link
	 * It's Redirect To The Google Page
	 * 
	 * @return
	 */
     public GoogleHomePage clickonGoogleLink(){
        googleLink.click();
      return new GoogleHomePage(driver);
    }
}
 