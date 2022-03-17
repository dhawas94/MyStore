package com.mystore.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage  homepage;
    @Test(groups = "Smoke")
	public void wishlisttest() throws Throwable 
	{
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	    boolean validate1 = homepage.validateMyWishList();
	    Assert.assertTrue(validate1);
	    System.out.println("validation1 successful");
	  
	
	
	}
    
    @Test(groups = "Smoke")
   	public void orderHistoryAndDetailsTest() throws Throwable 
   	{
   		indexpage=new IndexPage();
   		loginpage=indexpage.clickOnSignIn();
   		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
   	   boolean validation2 = homepage.validateOrderHistory();
	   Assert.assertTrue(validation2);
	   System.out.println("validation2 successful");	
   	
   	}}
