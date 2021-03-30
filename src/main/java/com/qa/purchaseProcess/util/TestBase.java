package com.qa.purchaseProcess.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.purchaseProcess.ExtentReportsListeners.ExtentReportListener;

public class TestBase extends ExtentReportListener {
	public static WebDriver driver;
	public static Properties prop;
	public static Actions action;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("F:\\Selenium\\PurchaseProcessAutomation\\src\\main\\java\\com\\qa\\purchaseProcess\\config\\config.properties");
			prop.load(fis);
		} catch(IOException e) {
			e.getMessage();
		}
	}
	
	public static void init() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chrome EXE\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	public boolean isAlertPresent(){
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(driver, 3 /*timeout in seconds*/);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	    } catch (TimeoutException eTO) {
	        foundAlert = false;
	    }
	    return foundAlert;
	}
	
	public static void frameSwitchable(WebDriver driver, WebElement element, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public static void eleAvailability(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void eleAvailability(WebDriver driver, WebElement element, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void eleClickable(WebDriver driver, WebElement element, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void eleClickable(WebDriver driver, By locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void eleToBeInvisible(WebDriver driver, WebElement locator, int time) {
		new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOf(locator));
	}
	
	public static void eleAttributeToBeNotEmpty(WebDriver driver, WebElement element, int time, String attribute) {
		new WebDriverWait(driver, time).until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
	}
	
	public static void eletextToBePresentInElement(WebDriver driver, WebElement element, int time, String text) {
		new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public static void eleSelectionStateToBe(WebDriver driver, WebElement element, int time, boolean selected) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}
	
	public static ExpectedCondition<Boolean> eleFocussed(final WebElement element){
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return element.equals(driver.switchTo().activeElement());
			}
		};
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public double convertStringToDouble(String str) {
		double value = Double.parseDouble(str);
		return value;
	}
	
}