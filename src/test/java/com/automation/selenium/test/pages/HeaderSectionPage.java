package com.automation.selenium.test.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.automation.selenium.helper.ExecuteCommand;
import com.automation.selenium.helper.TestAutomationConstant;
import com.automation.selenium.helper.TestHelper;
import com.automation.selenium.waithelper.WaitHelper;
import com.google.common.base.Strings;

public class HeaderSectionPage {
	
	private static final Logger logger = Logger.getLogger(HeaderSectionPage.class);
	
	@FindBy(css = "#contact-link>a")
	private WebElement contactUs_link;
	
	@FindBy(css = "a.login")
	private WebElement signin_link;
	
	@FindBy(css = "div.header_user_info>a.account>span")
	private WebElement signInUser_name;
	
	@FindBy(css = "div.header_user_info>a.logout")
	private WebElement signOut_link;
	
	@FindBy(css = "#block_top_menu>ul>li>a")
	private List<WebElement> productCatagories_Menu;
	
	private final WebDriver driver;
	private TestHelper testHelper;

	public HeaderSectionPage(WebDriver driver) {
		this.driver = driver;
		testHelper = new TestHelper(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TestAutomationConstant.AJAX_MAX_EXPLICIT_WAIT_TIME_OUT), this);
	}
	
	public LogInPage clickOnSignin_Link() throws Exception{
		logger.info("Going to click on Signin button.");
		testHelper.click(signin_link);
		return new LogInPage(driver);
	}
	
	public String getUserName() throws TimeoutException {
		ExecuteCommand<Boolean> executeCommand = new ExecuteCommand<Boolean>() {
			
			@Override
			public Boolean execute() {
				return !Strings.isNullOrEmpty(testHelper.getTextForParticularElement(signInUser_name));
			}
		};
		
		WaitHelper waitHelper = new WaitHelper();
		waitHelper.waitUntillCommandReturnsTrue(executeCommand, TimeUnit.SECONDS, TestAutomationConstant.POLLING, TestAutomationConstant.AJAX_AVG_EXPLICIT_WAIT_TIME_OUT);
		return testHelper.getTextForParticularElement(signInUser_name).trim();
	}
	
	public ProductSectionPage clickOn_TShirt_Option() throws Exception{
		WebElement t_Shirt_Menu = productCatagories_Menu.get(2);
		testHelper.click(t_Shirt_Menu);
		return new ProductSectionPage(driver);
	}
	
	public void clickOnSignOut() throws Exception{
		testHelper.click(signOut_link);
	}
}
