package com.automation.selenium.test.applicationtest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.selenium.driver.SeleniumBase;
import com.automation.selenium.test.data.DataClass;
import com.automation.selenium.test.pages.ProductSectionPage;
import com.google.common.base.Strings;

public class ValidatePurchase extends SeleniumBase {
	private static final Logger logger = Logger.getLogger(ValidatePurchase.class);
	
	ProductSectionPage productPage;

	@Test(dataProviderClass = DataClass.class, dataProvider = "login")
	public void purchaseTShirtAfterLogin(String credential){
		logger.info("---------------Validate Purchase TShirt After Login---------------");
		SoftAssert softAssert = new SoftAssert();
		productPage = new ProductSectionPage(driver);
		try {
			productPage.getHeaderSectionPage().clickOnSignin_Link().typeUserName(credential.split("/")[0]).typePassword(credential.split("/")[1]).clickOnSignIn_Btn();
			String loggedInUserName = productPage.getHeaderSectionPage().getUserName();
		} catch (Throwable e) {
			softAssert.assertTrue(false, "After Login With Credentials No User Name Showing On Header Section Of The Current Page. " + driver.getCurrentUrl());
			logger.error("No User Name Showing After Login: " + e);
		}
		
		try {
			String clickedProductTypeName = productPage.getHeaderSectionPage().clickOn_TShirt_Option().productType_Name();
			softAssert.assertFalse(Strings.isNullOrEmpty(clickedProductTypeName), "No Product Name Showing On Page Header section After Click On T-Shirt Option. ");
		} catch (Exception e) {
			softAssert.assertTrue(false, "Product Name Not Loaded On Page Section Header On The Current Page. " + driver.getCurrentUrl());
			logger.error("No Product Type Name Showing After Click On T-Shirt Option. : " + e);
		}
		
		try {
			String paymentSuccessMessage = productPage.selectFirstProduct().clickOnAddToCart().clickOnProceedToCheckOut_btn().clickOnProcessWithAddress_btn()
					.clickOnAgreeShippingTerms().clickOnProceedToShipping_btn().selectPayByCheckOption().clickOnConfirm_btn().getPaymentSuccessMessage();	
			softAssert.assertFalse(Strings.isNullOrEmpty(paymentSuccessMessage), "No Payment Success Message Showing After Payment For T-Shirt. ");
		} catch (Throwable e) {
			softAssert.assertTrue(false, "T-Shirt Purchase Not Successfully Completed.");
			logger.error("T-Shirt Purchase Not Successfully Completed. " + e);
		}
		logger.info("---------------Validate Purchase TShirt After Login Completed---------------");
		softAssert.assertAll();
	}

}