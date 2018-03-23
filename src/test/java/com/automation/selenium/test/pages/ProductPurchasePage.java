package com.automation.selenium.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.automation.selenium.helper.TestAutomationConstant;
import com.automation.selenium.helper.TestHelper;

import lombok.Getter;

public class ProductPurchasePage {
	
	private static final Logger logger = Logger.getLogger(ProductPurchasePage.class);
	
	@FindBy(xpath = ".//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
	private WebElement proceed_To_CheckOut_btn;
	
	@FindBy(xpath = ".//p[@class='cart_navigation clearfix']/button[@name='processAddress']")
	private WebElement process_With_Address_btn;
	
	@FindBy(css = "p.checkbox input[type='checkbox']")
	private WebElement shipping_Agree_Terms_ChkBox;
	
	@FindBy(xpath = ".//p[@class='cart_navigation clearfix']/button[@name='processCarrier']")
	private WebElement proceed_To_Shipping_btn;

	@FindBy(css = ".bankwire")
	private WebElement bankWire_PaymentProcess;

	@FindBy(css = ".cheque")
	private WebElement cheque_PaymentProcess;
	
	@FindBy(css = "#cart_navigation>button")
	private WebElement confirm_Order_btn;

	@FindBy(css = ".alert.alert-success")
	private WebElement order_Success_lbl;
	
    private final WebDriver driver;
    
    @Getter
    private HeaderSectionPage headerSectionPage;
    
    @Getter
    private FooterSectionPage footerSectionPage;
    
    private TestHelper testHelper;
   
    public ProductPurchasePage(WebDriver driver) {
        this.driver = driver;
        this.testHelper = new TestHelper(driver);
        this.headerSectionPage = new HeaderSectionPage(driver);
        this.footerSectionPage = new FooterSectionPage(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestAutomationConstant.AJAX_MAX_EXPLICIT_WAIT_TIME_OUT), this);
    }
    
    public ProductPurchasePage clickOnProceedToCheckOut_btn() throws Exception{
    	testHelper.click(proceed_To_CheckOut_btn);
    	return new ProductPurchasePage(driver);
    }
    
    public ProductPurchasePage clickOnProcessWithAddress_btn() throws Exception{
    	testHelper.click(process_With_Address_btn);
    	return new ProductPurchasePage(driver);
    }
    
    public ProductPurchasePage clickOnAgreeShippingTerms() throws Throwable{
    	testHelper.clickWithJavaScript(driver, shipping_Agree_Terms_ChkBox);
    	return new ProductPurchasePage(driver);
    }
    
    public ProductPurchasePage clickOnProceedToShipping_btn() throws Exception{
    	testHelper.click(proceed_To_Shipping_btn);
    	return new ProductPurchasePage(driver);
    }
    
    public ProductPurchasePage selectPayByBankWireOption() throws Exception{
    	testHelper.click(bankWire_PaymentProcess);
    	return new ProductPurchasePage(driver);
    }
    
    public ProductPurchasePage selectPayByCheckOption() throws Exception{
    	testHelper.click(cheque_PaymentProcess);
    	return new ProductPurchasePage(driver);
    }
    
    public ProductPurchasePage clickOnConfirm_btn() throws Throwable{
    	testHelper.mouseMoveAndClick(driver, confirm_Order_btn);
    	logger.info("Clicked on 'I confirm my order' button. ");
    	return new ProductPurchasePage(driver);
    }
    
    public String getPaymentSuccessMessage(){
    	return testHelper.getTextForParticularElement(order_Success_lbl);
    }
}
