package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {
     IndexPage indexpage;
     LoginPage loginpage;
     HomePage homepage;
     
     
    
     
     
     @Test(dataProvider= "credentials",dataProviderClass= DataProviders.class,groups = {"Smoke","Sanity"}) 
	public void loginTest( String uname,String pswd) throws Throwable 
	{   Log.startTestCase("loginTest");
		indexpage=new IndexPage();
		Log.info("user is going to click on sigIn");
    	loginpage=indexpage.clickOnSignIn();
    	Thread.sleep(2000);
    	Log.info("enter user name and password");
    	//homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
    	homepage= loginpage.login(uname,pswd);
    	boolean validate = homepage.validateMyWishList();
	    Assert.assertTrue(validate, "test case sucssesfully passed");
	    String actualUrl = homepage.getCurrentUrl();
	   String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
	   Log.info("Verifying is user is able to login");
	   Assert.assertEquals(actualUrl, expectedUrl);
	   Log.info("Log In Success");
	   Log.endTestCase("loginTest");
	}
	

}
