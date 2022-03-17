package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import com.mystore.utility.XLUtils;

public class LoginPageTest2 extends BaseClass {
     IndexPage indexpage;
     LoginPage loginpage;
     HomePage homepage;
     
     @Test(dataProvider= "LoginData") 
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
     
     @DataProvider(name="LoginData")
     String [][] getData() throws IOException
     {
    	 String path="C:\\Users\\admin\\eclipse-workspace\\MyStoreProject\\src\\test\\resources\\My Project Excel Worksheet.xlsx";
         
    	 int rownum=XLUtils.getRowCount(path, "Credentials");
    	 int colcouunt=XLUtils.getCellCount(path, "Credentials", 1);
    	 String logindata[][]=new String[rownum][colcouunt];
    	 
    	 for(int i=1;i<=rownum;i++) 
    	 {
    		 for(int j=0;j<colcouunt;j++)
    		 {
    			logindata[i-1][j]=XLUtils.getCellData(path, "Credentials", i, j); 
    			//1st row is header thats why we have to save it in i-1
    		 }
    	 }
		return logindata;
     
     
     
     
     }
	

}
