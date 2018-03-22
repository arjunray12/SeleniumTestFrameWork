package com.wfs.automation.selenium.helper;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class TestHelper {

	Logger Log = Logger.getLogger(TestHelper.class);
	WebDriver driver;

	public TestHelper(WebDriver driver)
	{
		this.driver = driver;
	}

	public void sync(WebDriver driver, WebElement element)
			throws Exception
	{
		try
		{
			Wait<WebDriver> wait = new WebDriverWait(driver, TestAutomationConstant.TIMEOUT_MAX);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (RuntimeException e)
		{
			this.Log.error(element + " Not visible on page : " + driver.getTitle());
			throw e;
		}
	}

	public void syncClickable(WebDriver driver, WebElement element)
	{
		try
		{
			Wait<WebDriver> wait = new WebDriverWait(driver, TestAutomationConstant.TIMEOUT_MAX);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch (Exception e)
		{
			this.Log.error(element + " Not clickable on page : " + driver.getTitle());
			throw e;
		}
	}

	public void type(WebElement element, String str)
			throws Exception
	{
		try
		{
			element.clear();
			element.sendKeys(new CharSequence[] { str.toString() });
		}
		catch (Exception e)
		{
			this.Log.error("Couldnot eble to send text on element: " + element);
			throw e;
		}
	}

	public void typeWithJavaScript(WebElement element, String str)
			throws Exception
	{
		try
		{
			element.clear();
			element.sendKeys(new CharSequence[] { str.toString() });
		}
		catch (Exception e)
		{
			this.Log.error("Couldnot eble to send text on element: " + element);
			throw e;
		}
	}

	public void click(WebElement element)
			throws Exception
	{
		try
		{
			element.click();
			Thread.sleep(1000L);
		}
		catch (Exception e)
		{
			this.Log.error("Element : " + element + " Not Clickable");
			throw e;
		}
	}

	public void clickWithJavaScript(WebDriver driver, WebElement element)
			throws Throwable
	{
		try
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", new Object[] { element });
		}
		catch (Exception e)
		{
			this.Log.error("Error Happened To Click On " + element + " Using JavaScript. " + e);
			throw new Throwable("Error Happened To Click On " + element + " Using JavaScript. ");
		}
	}

	public boolean isElementDisplay(WebElement element)
	{
		try
		{
			element.isDisplayed();
			return true;
		}
		catch (Exception e) {}
		return false;
	}

	public void selectElementFromDropDown(WebElement element, String visibleText)
	{
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(visibleText);
	}

	public void selectElementByValueFromDropDown(WebElement element, String value)
	{
		Select dropDown = new Select(element);
		dropDown.selectByValue(value);
	}

	public void selectElementByValueFromDropDownWithClick(WebElement element, String value)
			throws Throwable
	{
		Select dropDown = new Select(element);
		List<WebElement> dropDownOptions = dropDown.getOptions();
		for (WebElement webElement : dropDownOptions)
		{
			System.out.println(webElement.getAttribute("value"));
			if (StringUtils.equalsIgnoreCase(value.trim(), webElement.getAttribute("value").trim()))
			{
				System.out.println(webElement.getAttribute("value"));
				click(webElement);
				break;
			}
		}
	}

	public void selectElementByValueFromDropDownWithIndex(WebElement element, String value)
			throws Throwable
	{
		Select dropDown = new Select(element);
		List<WebElement> dropDownOptions = dropDown.getOptions();
		for (int index = 0; index < dropDownOptions.size(); index++)
		{
			System.out.println(((WebElement)dropDownOptions.get(index)).getAttribute("value"));
			click((WebElement)dropDownOptions.get(index));
			Thread.sleep(1000L);
			if (StringUtils.equalsIgnoreCase(value.trim(), ((WebElement)dropDownOptions.get(index)).getAttribute("value").trim()))
			{
				click((WebElement)dropDownOptions.get(index));
				Thread.sleep(1000L);
				break;
			}
		}
	}

	public void selectElementRandomElementFromDropDown(WebElement element)
			throws Exception
	{
		Select dropDown = new Select(element);

		int index = 0;
		try
		{
			Thread.sleep(2000L);

			index = new Random().nextInt(dropDown.getOptions().size() - 0 + 1) + 0;
			index = index < 0 ? 0 : dropDown.getOptions().size() - 1;
			dropDown.selectByIndex(index);
		}
		catch (Exception e)
		{
			this.Log.error("Issue On Select WebElement : " + element + "For Index " + index);
			throw e;
		}
	}

	public String getTextForParticularElement(WebElement element)
	{
		String text = element.getText();
		return text;
	}

	public String getInnerTextForParticularElement(WebElement element)
	{
		String text = element.getAttribute("innerText").trim();
		return text;
	}

	public String getTextFromTextBox(WebElement element)
	{
		return element.getAttribute("value");
	}

	public String getCurrentValueFromDropDown(WebElement element)
	{
		Select dropDown = new Select(element);
		WebElement value = dropDown.getFirstSelectedOption();
		String text = value.getText();
		return text;
	}

	public String getUniqueID()
	{
		return UUID.randomUUID().toString();
	}

	public void mouseMoveAndClick(WebDriver driver, WebElement element)
			throws InterruptedException
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			Thread.sleep(1000L);
			action.moveToElement(element).click().build().perform();
			Thread.sleep(1000L);
		}
		catch (RuntimeException e)
		{
			this.Log.error("Mouse Click Using Action On : " + element + "Not Happen");
			throw e;
		}
	}

	public void mouseMove(WebDriver driver, WebElement element)
			throws InterruptedException
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			Thread.sleep(1000L);
			action.moveToElement(element).build().perform();
			Thread.sleep(1000L);
		}
		catch (RuntimeException e)
		{
			this.Log.error("Mouse Over Using Action On : " + element + "Not Happen");
			throw e;
		}
	}

	public void sync(WebDriver driver, List<WebElement> elements)
	{
		try
		{
			Wait<WebDriver> wait = new WebDriverWait(driver, TestAutomationConstant.TIMEOUT_MAX);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		}
		catch (RuntimeException e)
		{
			this.Log.error(elements + " Not visible on page : " + driver.getTitle());
			throw e;
		}
	}

	public void syncInvisible(WebDriver driver, List<WebElement> elements)
	{
		try
		{
			Wait<WebDriver> wait = new WebDriverWait(driver, TestAutomationConstant.TIMEOUT_MAX);
			wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
		}
		catch (RuntimeException e)
		{
			this.Log.error(elements + " visible on page : " + driver.getTitle());
			throw e;
		}
	}

	public void syncInvisible(WebDriver driver, WebElement webElement)
	{
		final WebElement element = webElement;
		try
		{
			Wait<WebDriver> wait = new WebDriverWait(driver, TestAutomationConstant.TIMEOUT_MAX);
			wait.until(new ExpectedCondition<Boolean>() {

				@Override
				public Boolean apply(WebDriver arg0) {
					try
					{
						return Boolean.valueOf(!element.isDisplayed());
					}
					catch (NoSuchElementException e)
					{
						return Boolean.valueOf(true);
					}
					catch (StaleElementReferenceException e)
					{
						return Boolean.valueOf(true);
					}
					catch (NullPointerException e) {}
					return Boolean.valueOf(true);	        
				}});
			}
			catch (RuntimeException e)
			{
				this.Log.error(element + " visible on page : " + driver.getTitle());
				throw e;
			}
		}

		public String getTextAreaText(WebDriver driver, WebElement textAreaElement)
		{
			String text = "";
			try
			{
				text = textAreaElement.getAttribute("value");
			}
			catch (RuntimeException e)
			{
				this.Log.error("Not Able To Extracting Text From Element : " + textAreaElement + " on page : " + driver.getTitle());
				throw e;
			}
			return text;
		}

		public void waitUntillCommandReturnsTrue(ExecuteCommand<Boolean> executeCommand, TimeUnit timeUnit, long retryInterval, long timeOut)
				throws TimeoutException
		{
			boolean result = false;

			long startTime = System.currentTimeMillis();
			long maxWaitTime = startTime + TimeUnit.MILLISECONDS.convert(timeOut, timeUnit);
			while ((maxWaitTime > System.currentTimeMillis()) && (!result))
			{
				result = ((Boolean)executeCommand.execute()).booleanValue();
				if (!result) {
					try
					{
						Thread.sleep(TimeUnit.MILLISECONDS.convert(retryInterval, timeUnit));
					}
					catch (InterruptedException e1)
					{
						e1.printStackTrace();
					}
				}
			}
			if (!result) {
				throw new TimeoutException();
			}
		}

		public static void takeScreenShoot(WebDriver driver, String screenShotName) throws Exception {
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
			Date date = new Date();
			String modifiedScreenShotName = screenShotName + "_"+ dateFormat.format(date) + ".png";
			String path = new File("target/surefire-reports/screen-shots/" + modifiedScreenShotName).getAbsolutePath();
			System.out.println(path);		
			FileUtils.copyFile(screenshot, new File(path));
			//		Reporter.log("<a href= file:///" + path + "</a>");
			Reporter.log("<a href= file:///"+ path +"> <img src='"+ path + "' height='100' width='100'/> </a>");
		} 
	}
