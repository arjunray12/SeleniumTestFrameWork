package com.automation.selenium.test.pages;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.automation.selenium.helper.TestAutomationConstant;
import com.automation.selenium.helper.TestHelper;

import lombok.Getter;

public class ProductSectionPage {
	
	private static final Logger logger = Logger.getLogger(ProductSectionPage.class);
	
	@FindBy(css = ".login")
    private WebElement inputBox;
    
	@FindBy(css = ".page-heading.product-listing>span")
    private WebElement product_Type_Name;

	@FindBy(css = "ul.product_list.grid.row>li")
    private List<WebElement> product_Items;
	
    private final WebDriver driver;
    @Getter
    private HeaderSectionPage headerSectionPage;
    @Getter
    private FooterSectionPage footerSectionPage;
    private TestHelper testHelper;
   
    public ProductSectionPage(WebDriver driver) {
        this.driver = driver;
        this.testHelper = new TestHelper(driver);
        this.headerSectionPage = new HeaderSectionPage(driver);
        this.footerSectionPage = new FooterSectionPage(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestAutomationConstant.AJAX_MAX_EXPLICIT_WAIT_TIME_OUT), this);
    }
     
    public String productType_Name() throws Exception {
		testHelper.sync(driver, product_Type_Name);
		return testHelper.getTextForParticularElement(product_Type_Name).trim();
	}
    
    public List<WebElement> getAllProductItems(){
    	return product_Items;
    }
    
    public ProductDetailsPage selectFirstProduct() throws Throwable{
    	WebElement firstProduct = product_Items.get(0);
    	testHelper.clickWithJavaScript(driver, firstProduct.findElement(By.cssSelector("a.quick-view")));
    	return new ProductDetailsPage(driver);
    }
}
 