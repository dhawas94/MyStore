package com.mystore.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccontCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class accountCreationPageTest extends BaseClass {
	   IndexPage indexpage;
	     LoginPage loginpage;
	     HomePage homepage;
	     AccontCreationPage accountcreationpage;
	     
	@Test (groups = "Sanity")
	public void verifyCreateAccountTest() throws Throwable 
	{
		indexpage=new IndexPage();
    	loginpage=indexpage.clickOnSignIn();
    	accountcreationpage=loginpage.createNewAccount("dgfjgsf@gmail.com");
	    boolean validation = accountcreationpage.validateAccountCreationPage();
	    Assert.assertTrue(validation);
	    Reporter.log("TC PASS");
	    
	    
	    
	    
	    
	  
	
	}

}
