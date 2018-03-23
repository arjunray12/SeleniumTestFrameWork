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

public class LogInPage { 
	
	private static final Logger logger = Logger.getLogger(LogInPage.class);
	
	@FindBy(id = "email")
	private WebElement email_input_Box;

	@FindBy(id = "passwd")
	private WebElement password_input_Box;

	@FindBy(id = "SubmitLogin")
	private WebElement sign_Btn;
	
	private final WebDriver driver;
	private TestHelper testHelper;
	
	@Getter
	private HeaderSectionPage headerSectionPage;
	
	@Getter
	private FooterSectionPage footerPage;

	public LogInPage(WebDriver driver) {
        this.driver = driver;
        testHelper = new TestHelper(driver);
        this.headerSectionPage = new HeaderSectionPage(driver);
        this.footerPage = new FooterSectionPage(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestAutomationConstant.AJAX_MAX_EXPLICIT_WAIT_TIME_OUT), this);
	}
	
	public LogInPage typeUserName(String email) throws Exception {
		testHelper.type(email_input_Box, email);
		return new LogInPage(driver);
	}
	
	public LogInPage typePassword(String password) throws Exception {
		testHelper.type(password_input_Box, password);
		return new LogInPage(driver);
	}
	
	public LogInPage clickOnSignIn_Btn() throws Exception {
		testHelper.click(sign_Btn);
		return new LogInPage(driver);
	}
}