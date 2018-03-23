package com.automation.selenium.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.automation.selenium.helper.TestAutomationConstant;

public class FooterSectionPage {

	private static final Logger logger = Logger.getLogger(FooterSectionPage.class);
	
	@FindBy(id = "email")
	private WebElement email_input_Box;

	@FindBy(id = "passwd")
	private WebElement password_input_Box;

	@FindBy(id = "SubmitLogin")
	private WebElement sign_Btn;
	
	private final WebDriver driver;

	public FooterSectionPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestAutomationConstant.AJAX_MAX_EXPLICIT_WAIT_TIME_OUT), this);
	}
}
