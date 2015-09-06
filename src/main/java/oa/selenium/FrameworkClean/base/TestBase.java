package oa.selenium.FrameworkClean.base;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class TestBase {
	WebDriver driver;
	public static LoggingPreferences logs;
	//private static Logger log = LoggerFactory.getLogger(TestBase.class);
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver createDriver(BrowserType browserType, String url) {
		switch (browserType)
		{
		case FIREFOX:
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.setProperty("webdriver.firefox.logfile", "firefox.log");
			DesiredCapabilities capsFirefox = DesiredCapabilities.firefox();
			capsFirefox.setCapability(CapabilityType.LOGGING_PREFS, logs);
			driver.get(url);
			return driver;
		case CHROME:
			System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
			System.setProperty("webdriver.chrome.driver","chromedriver");
			DesiredCapabilities capsChrome = DesiredCapabilities.chrome();
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.DRIVER, Level.ALL);
			capsChrome.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			driver = new ChromeDriver(capsChrome);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		default:
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.setProperty("webdriver.firefox.logfile", "firefox.log");
			DesiredCapabilities capsFirefox2 = DesiredCapabilities.firefox();
			capsFirefox2.setCapability(CapabilityType.LOGGING_PREFS, logs);
			driver.get(url);
			return driver;
		}
	}
	
	public enum BrowserType {
		FIREFOX, CHROME
	}
	
	@AfterMethod
	public void logsAccess(){
		Logs logs = driver.manage().logs();
		LogEntries logEntries = logs.get(LogType.DRIVER);
		for (LogEntry logEntry : logEntries){
			System.out.println(logEntry.getMessage());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
