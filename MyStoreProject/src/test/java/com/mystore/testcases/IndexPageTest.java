package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage index;
	
	
	
	@Test (groups = "Smoke")
	public void verifyLogo() {
		index=new IndexPage();
		boolean result = index.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
		public void verifyTitle() 
		{
			String actualtile = index.getMyStoreTitle();
			String expectedtitle="My Store";
			Assert.assertEquals(actualtile, expectedtitle);
		}
		
		
	
	
	
}
