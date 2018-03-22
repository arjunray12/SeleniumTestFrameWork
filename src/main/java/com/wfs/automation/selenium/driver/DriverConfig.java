package com.wfs.automation.selenium.driver;

import org.openqa.selenium.WebDriver;

import com.wfs.automation.selenium.helper.TestAutomationConstant;

public class DriverConfig {

	private boolean setAssumeUntrustedCertificateIssuer = true;
	private boolean setAcceptUntrustedCertificates = true;
	private boolean enableJavascript = true;
	private WebDriver driver;
	private boolean enableEventDriver = false;
	private DriverMode mode = DriverMode.LOCAL;
	private String hubUrl= TestAutomationConstant.DEFAULT_HUBURL;
	private String geckoDriverPath = TestAutomationConstant.DEFAULT_GECKO_DRIVER_PATH;
	private String ffBinPath;
	private String ieDriverPath = TestAutomationConstant.DEFAULT_IE_DRIVER_PATH;
	private String chromeDriverPath = TestAutomationConstant.DEFAULT_CHROME_DRIVER_PATH;
	private String chromeBinPath;
	private int webSessionTimeout = TestAutomationConstant.DEFAULT_WEBSESSION_TIMEOUT;
	private double implicitWaitTimeout = TestAutomationConstant.IMPLICIT_WAIT_TIMEOUT;
	private int maxExplicitWaitTimeout = TestAutomationConstant.MAX_EXPLICIT_WAIT_TIME_OUT;
	private int avgExplicitWaitTimeout = TestAutomationConstant.AVG_EXPLICIT_WAIT_TIME_OUT;
	private int minExplicitWaitTimeout = TestAutomationConstant.MIN_EXPLICIT_WAIT_TIME_OUT;
	private int ajaxMaxExplicitWaitTimeout = TestAutomationConstant.AJAX_MAX_EXPLICIT_WAIT_TIME_OUT;
	private int ajaxAvgExplicitWaitTimeout = TestAutomationConstant.AJAX_AVG_EXPLICIT_WAIT_TIME_OUT;
	private int ajaxMinExplicitWaitTimeout = TestAutomationConstant.AJAX_MIN_EXPLICIT_WAIT_TIME_OUT;
	private int pageLoadTimeout = TestAutomationConstant.PAGE_LOAD_TIMEOUT;
	private String browserVersion;
	private int browserWindowWidth = TestAutomationConstant.DEFAULT_BROWSER_WINDOW_WIDTH;
	private int browserWindowHeight = TestAutomationConstant.DEFAULT_BROWSER_WINDOW_HEIGHT;
	
/*	private String proxyHost;
  	private Platform webPlatform;
  	private String ffProfilePath;
  	private String operaProfilePath;
	private String testType;
	private String ntlmAuthTrustedUris;
	private String browserDownloadDir;
	private boolean addJSErrorCollectorExtension = false;
	private ArrayList<WebDriverEventListener> webDriverListeners;
	private boolean useFirefoxDefaultProfile = true;
	private String userAgentOverride;
	private String outputDirectory;*/

	public boolean isEnabledEventDriver() {
		return enableEventDriver;
	}
	
	public void setEnableEventDriver(final boolean enableEventDriver) {
		this.enableEventDriver = enableEventDriver;
	}
	
	public String getBrowserVersion() {
		return browserVersion;
	}

	public String getChromeBinPath() {
		return chromeBinPath;
	}

	public String getChromeDriverPath() {
		return chromeDriverPath;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public int getMaxExplicitWaitTimeout() {
		if (maxExplicitWaitTimeout < getImplicitWaitTimeout()) {
			return (int) getImplicitWaitTimeout();
		} else {
			return maxExplicitWaitTimeout;
		}
	}

	public int getAvgExplicitWaitTimeout() {
		if (avgExplicitWaitTimeout < getImplicitWaitTimeout()) {
			return (int) getImplicitWaitTimeout();
		} else {
			return avgExplicitWaitTimeout;
		}
	}
	public int getMinExplicitWaitTimeout() {
		if (minExplicitWaitTimeout < getImplicitWaitTimeout()) {
			return (int) getImplicitWaitTimeout();
		} else {
			return minExplicitWaitTimeout;
		}
	}
	public int getAjaxMaxExplicitWaitTimeout() {
		if (ajaxMaxExplicitWaitTimeout < getImplicitWaitTimeout()) {
			return (int) getImplicitWaitTimeout();
		} else {
			return ajaxMaxExplicitWaitTimeout;
		}
	}
	public int getAjaxAvgExplicitWaitTimeout() {
		if (ajaxAvgExplicitWaitTimeout < getImplicitWaitTimeout()) {
			return (int) getImplicitWaitTimeout();
		} else {
			return ajaxAvgExplicitWaitTimeout;
		}
	}
	public int getAjaxMinExplicitWaitTimeout() {
		if (ajaxMinExplicitWaitTimeout < getImplicitWaitTimeout()) {
			return (int) getImplicitWaitTimeout();
		} else {
			return ajaxMinExplicitWaitTimeout;
		}
	}
	
	public String getGeckoDriverPath() {
		return geckoDriverPath;
	}
	
	public String getFirefoxBinPath() {
		return ffBinPath;
	}

	public String getHubUrl() {
		return hubUrl;
	}

	public String getIeDriverPath() {
		return ieDriverPath;
	}

	public double getImplicitWaitTimeout() {
		return implicitWaitTimeout;
	}
	public DriverMode getMode() {
		return mode;
	}

	public int getPageLoadTimeout() {
		return pageLoadTimeout;
	}

	public int getWebSessionTimeout() {
		return webSessionTimeout;
	}

	public boolean isEnableJavascript() {
		return enableJavascript;
	}

	public boolean isSetAcceptUntrustedCertificates() {
		return setAcceptUntrustedCertificates;
	}

	public boolean isSetAssumeUntrustedCertificateIssuer() {
		return setAssumeUntrustedCertificateIssuer;
	}

	public void setBrowserVersion(final String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public void setGeckoDriverPath(final String geckoDriverPath) {
		this.geckoDriverPath = geckoDriverPath;
	}
	
	public void setChromeBinPath(final String chromeBinPath) {
		this.chromeBinPath = chromeBinPath;
	}

	public void setChromeDriverPath(final String chromeDriverPath) {
		this.chromeDriverPath = chromeDriverPath;
	}

	public void setDriver(final WebDriver driver) {
		this.driver = driver;
	}

	public void setEnableJavascript(final boolean enableJavascript) {
		this.enableJavascript = enableJavascript;
	}

	public void setMaxExplicitWaitTimeout(final int maxExplicitWaitTimeout) {
		this.maxExplicitWaitTimeout = maxExplicitWaitTimeout;
	}

	public void setAvgExplicitWaitTimeout(final int avgExplicitWaitTimeout) {
		this.avgExplicitWaitTimeout = avgExplicitWaitTimeout;
	}
	
	public void setMinExplicitWaitTimeout(final int minExplicitWaitTimeout) {
		this.minExplicitWaitTimeout = minExplicitWaitTimeout;
	}
	
	public void setAjaxMaxExplicitWaitTimeout(final int ajaxMaxExplicitWaitTimeout) {
		this.ajaxMaxExplicitWaitTimeout = ajaxMaxExplicitWaitTimeout;
	}
	
	public void setAjaxAvgExplicitWaitTimeout(final int ajaxAvgExplicitWaitTimeout) {
		this.ajaxAvgExplicitWaitTimeout = ajaxAvgExplicitWaitTimeout;
	}
	
	public void setAjaxMinExplicitWaitTimeout(final int ajaxMinExplicitWaitTimeout) {
		this.ajaxMinExplicitWaitTimeout = ajaxMinExplicitWaitTimeout;
	}
	public void setFfBinPath(final String ffBinPath) {
		this.ffBinPath = ffBinPath;
	}

	public void setHubUrl(final String hubUrl) {
		this.hubUrl = hubUrl;
	}

	public void setIeDriverPath(final String ieDriverPath) {
		this.ieDriverPath = ieDriverPath;
	}

	public void setImplicitWaitTimeout(final double implicitWaitTimeout) {
		this.implicitWaitTimeout = implicitWaitTimeout;
	}
	public void setMode(final DriverMode mode) {
		this.mode = mode;
	}

	public void setPageLoadTimeout(final int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setSetAcceptUntrustedCertificates(final boolean setAcceptUntrustedCertificates) {
		this.setAcceptUntrustedCertificates = setAcceptUntrustedCertificates;
	}

	public void setSetAssumeUntrustedCertificateIssuer(final boolean setAssumeUntrustedCertificateIssuer) {
		this.setAssumeUntrustedCertificateIssuer = setAssumeUntrustedCertificateIssuer;
	}

	public void setWebSessionTimeout(final int webSessionTimeout) {
		this.webSessionTimeout = webSessionTimeout;
	}

	public int getBrowserWindowWidth() {
		return browserWindowWidth;
	}

	public void setBrowserWindowWidth(final int browserWindowWidth) {
		this.browserWindowWidth = browserWindowWidth;
	}

	public int getBrowserWindowHeight() {
		return browserWindowHeight;
	}

	public void setBrowserWindowHeight(final int browserWindowHeight) {
		this.browserWindowHeight = browserWindowHeight;
	}

/*	public String getTestType() {
		return testType;
	}
	
	public Platform getWebPlatform() {
		return webPlatform;
	}

	public Proxy getProxy() {
		Proxy proxy = null;
		if (proxyHost != null) {
			proxy = new Proxy();
			proxy.setProxyType(ProxyType.MANUAL);
			proxy.setHttpProxy(proxyHost);
			proxy.setFtpProxy(proxyHost);
			proxy.setSslProxy(proxyHost);
		}
		return proxy;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setBrowserDownloadDir(final String browserDownloadDir) {
		this.browserDownloadDir = browserDownloadDir;
	}
	
	public void setFfProfilePath(final String ffProfilePath) {
		this.ffProfilePath = ffProfilePath;
	}
	
	public void setNtlmAuthTrustedUris(final String ntlmAuthTrustedUris) {
		this.ntlmAuthTrustedUris = ntlmAuthTrustedUris;
	}
	
	public void setWebPlatform(final Platform webPlatform) {
		this.webPlatform = webPlatform;
	}

	public void setTestType(final String testType) {
		this.testType = testType;
	}

	public void setUserAgentOverride(final String userAgentOverride) {
		this.userAgentOverride = userAgentOverride;
	}

	public void setOutputDirectory(final String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	public void setAddJSErrorCollectorExtension(final boolean addJSErrorCollectorExtension) {
		this.addJSErrorCollectorExtension = addJSErrorCollectorExtension;
	}

	public boolean isAddJSErrorCollectorExtension() {
		return addJSErrorCollectorExtension;
	}

	public boolean isUseFirefoxDefaultProfile() {
		return this.useFirefoxDefaultProfile;
	}

	public void setUseFirefoxDefaultProfile(final boolean useFirefoxDefaultProfile) {
		this.useFirefoxDefaultProfile = useFirefoxDefaultProfile;
	}

	public void setOperaProfilePath(final String operaProfilePath) {
		this.operaProfilePath = operaProfilePath;
	}
	
	public String getUserAgentOverride() {
		return this.userAgentOverride;
	}

	public String getOutputDirectory() {
		return outputDirectory;
	}
	public ArrayList<WebDriverEventListener> getWebDriverListeners() {
		return webDriverListeners;
	}

	public void setWebDriverListeners(final ArrayList<WebDriverEventListener> webDriverListeners) {
		this.webDriverListeners = webDriverListeners;
	}

	public void setWebDriverListeners(final String listeners) {
		ArrayList<WebDriverEventListener> listenerList = new ArrayList<WebDriverEventListener>();
		String[] list = listeners.split(",");
		for (String aList : list) {

			WebDriverEventListener listener = null;
			try {
				if (!aList.equals("")) {
					listener = (WebDriverEventListener) (Class.forName(aList)).newInstance();
					listenerList.add(listener);
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ClassCastException e) {
				e.printStackTrace();
			}
		}

		this.webDriverListeners = listenerList;
	}

	public String getBrowserDownloadDir() {
		return browserDownloadDir;
	}
	
	public void setProxyHost(final String proxyHost) {
		this.proxyHost = proxyHost;
	}
	
	public String getFirefoxProfilePath() {
		if (ffProfilePath == null && getClass().getResource("/profiles/customProfileDirCUSTFF") != null) {

			try {
				return getClass().getResource("/profiles/customProfileDirCUSTFF").toURI().getPath();
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		} else {
			return ffProfilePath;
		}
	}
	
	public String getNtlmAuthTrustedUris() {
		return ntlmAuthTrustedUris;
	}

	public String getOperaProfilePath() {
		if (operaProfilePath == null && getClass().getResource("/profiles/operaProfile") != null) {

			try {
				return getClass().getResource("/profiles/operaProfile").toURI().getPath();
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}

		return operaProfilePath;
	}*/
}
