package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	 
	@BeforeTest (groups = {"Smoke","Sanity","Regression"})
	public void beforeSuite() 
	{   ExtentManager.setExtent();
		DOMConfigurator.configure("Log4j.xml");
	}
	
	@BeforeClass(groups = {"Smoke","Sanity","Regression"})
	public static void loadConfig() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	    @Parameters("browser")
	 	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public  void launchApp(String browserName) {
//		 String browserName = prop.getProperty("browser");
		 
		if (browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		} else if (browserName.contains("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		} else if (browserName.contains("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
//		 System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
//		    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver,30);
		driver.get(prop.getProperty("url"));
	}
	
	
//	 	public void setup(String browser ) 
//	 	{
//	 		launchApp(browser);
//	 	} 
	     
	 	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	 	public void tearDown() 
	 	{
	 		driver.close();
	 	}
	 	
	 	@AfterTest
	 	
	 	public void afterSuite() 
	 	{
	 		ExtentManager.endReport();
	 	}
		
}
