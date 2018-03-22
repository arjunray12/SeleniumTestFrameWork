package com.wfs.automation.selenium.helper;

/**
 * 
 * This class contains constants used for automation test.
 *
 */
public class TestAutomationConstant {
	
    public static final int TIMEOUT_MIN = 10;
	
	public static final int TIMEOUT_AVG = 15;
	
	public static final int TIMEOUT_MAX = 45;
	
	public static final int RETRY_INTERVAL_MIN = 1;
	
	public static final int RETRY_INTERVAL_AVG = 2;
	
	public static final int RETRY_INTERVAL_MAX = 5;
	
	public static final int DELAY_MIN = 3;
	
	public static final int DELAY_AVG = 5;
	
	public static final int DELAY_MAX = 10;
	
	public static final String HYPHEN = "-";
	
	public static final String COMMA = ",";
	
	public static final String EMPTY = "";
	
	public static final String SPACE = " ";
	
	public static final String SLASH_FRONT = "/";
	
	public static final int DEFAULT_WEBSESSION_TIMEOUT = 90 * 1000;
	
    public static final int IMPLICIT_WAIT_TIMEOUT = 5;
    
    public static final int MAX_EXPLICIT_WAIT_TIME_OUT = 25;
   
    public static final int AVG_EXPLICIT_WAIT_TIME_OUT = 10;
    
    public static final int MIN_EXPLICIT_WAIT_TIME_OUT = 5;
    
    public static final int AJAX_MAX_EXPLICIT_WAIT_TIME_OUT = 65;
    
    public static final int AJAX_AVG_EXPLICIT_WAIT_TIME_OUT = 45;
    
    public static final int AJAX_MIN_EXPLICIT_WAIT_TIME_OUT = 20;
    
    public static final int POLLING = 2;
	
    public static final int PAGE_LOAD_TIMEOUT = 90;
    
    public static final int DEFAULT_BROWSER_WINDOW_WIDTH = -1;
    
    public static final int DEFAULT_BROWSER_WINDOW_HEIGHT = -1;
    
    public static final String DEFAULT_HUBURL = "http://localhost:4444/wd/hub";
    
    public static final String DEFAULT_FF_BINARY_PATH = "C:/Program Files (x86)/Mozilla Firefox/firefox.exe";

    public static final String DEFAULT_IE_DRIVER_PATH = "src/test/resources/drivers/IEDriverServer_Win32/IEDriverServer.exe";
    
    public static final String DEFAULT_GECKO_DRIVER_PATH = "src/test/resources/drivers/geckodriver_win32/geckodriver.exe";
    
    public static final String DEFAULT_CHROME_DRIVER_PATH = "src/test/resources/drivers/chromedriver_win32/chromedriver.exe";
    
    public static final String DEFAULT_CHROME_BINARY_PATH = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";
}
