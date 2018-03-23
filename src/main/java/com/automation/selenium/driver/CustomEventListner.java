package com.automation.selenium.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class CustomEventListner extends AbstractWebDriverEventListener{
	
	private static final Logger logger = Logger.getLogger(CustomEventListner.class);
	
	@Override
	public void afterAlertAccept(WebDriver driver) {
		super.afterAlertAccept(driver);
		logger.info("Log from CustomEventListner After Alert Accepted.");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		super.afterAlertDismiss(driver);
		logger.info("Log from CustomEventListner After Alert Dismissed.");
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		super.afterChangeValueOf(element, driver, keysToSend);
		logger.info("Log from CustomEventListner After Change Value Of.");
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		super.afterClickOn(element, driver);
		logger.info("Log from CustomEventListner After Click On.");
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		super.afterFindBy(by, element, driver);
		logger.info("Log from CustomEventListner After Find By.");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		super.afterNavigateBack(driver);
		logger.info("Log from CustomEventListner After Navigate Back.");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		super.afterNavigateForward(driver);
		logger.info("Log from CustomEventListner After Navigate Forward.");
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		super.afterNavigateRefresh(driver);
		logger.info("Log from CustomEventListner After Navigate Refresh.");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		super.afterNavigateTo(url, driver);
		logger.info("Log from CustomEventListner After Navigate To.");
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		super.afterScript(script, driver);
		logger.info("Log from CustomEventListner After Script.");
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		super.beforeAlertAccept(driver);
		logger.info("Log from CustomEventListner Before Alert Accept.");
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		super.beforeAlertDismiss(driver);
		logger.info("Log from CustomEventListner Before Alert Dismiss.");
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		super.beforeChangeValueOf(element, driver, keysToSend);
		logger.info("Log from CustomEventListner Before Change Value Of.");
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		super.beforeClickOn(element, driver);
		logger.info("Log from CustomEventListner Before Click On.");
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		super.beforeFindBy(by, element, driver);
		logger.info("Log from CustomEventListner Before Find By.");
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		super.beforeNavigateBack(driver);
		logger.info("Log from CustomEventListner Before Navigate Back.");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		super.beforeNavigateForward(driver);
		logger.info("Log from CustomEventListner Before Navigate Forward.");
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		super.beforeNavigateRefresh(driver);
		logger.info("Log from CustomEventListner Before Navigate Refresh.");
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		super.beforeNavigateTo(url, driver);
		logger.info("Log from CustomEventListner Before Navigate To.");
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		super.beforeScript(script, driver);
		logger.info("Log from CustomEventListner Before Script.");
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		super.onException(throwable, driver);
		logger.info("Log from CustomEventListner On Exception.");
	}

}
