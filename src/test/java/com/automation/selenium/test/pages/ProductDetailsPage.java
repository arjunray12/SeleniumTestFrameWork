package com.automation.selenium.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.automation.selenium.helper.TestAutomationConstant;
import com.automation.selenium.helper.TestHelper;
import com.google.common.base.Strings;

import lombok.Getter;

public class ProductDetailsPage {
	
	private static final Logger logger = Logger.getLogger(ProductDetailsPage.class);
	
	@FindBy(css = ".box-cart-bottom button")
	private WebElement addToCart_btn;
	
	@FindBy(id = "layer_cart")
	private WebElement proceed_To_CheckOut_Modal;
	
	@FindBy(css = ".button-container a[title='Proceed to checkout']")
	private WebElement proceed_To_CheckOut_btn;
	
    private final WebDriver driver;
    
    @Getter
    private HeaderSectionPage headerSectionPage;
    
    @Getter
    private FooterSectionPage footerSectionPage;
    
    private TestHelper testHelper;
   
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.testHelper = new TestHelper(driver);
        this.headerSectionPage = new HeaderSectionPage(driver);
        this.footerSectionPage = new FooterSectionPage(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestAutomationConstant.AJAX_MAX_EXPLICIT_WAIT_TIME_OUT), this);
    }
    
    public ProductPurchasePage clickOnAddToCart() throws Throwable {
    	testHelper.click(addToCart_btn);
    	try {
        	if (!Strings.isNullOrEmpty(proceed_To_CheckOut_Modal.getAttribute("style"))) {
    			testHelper.click(proceed_To_CheckOut_btn);
    		}	
		} catch (Exception e) {
		}
		return new ProductPurchasePage(driver);
	}
}
