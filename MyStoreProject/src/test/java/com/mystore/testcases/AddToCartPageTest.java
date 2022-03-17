package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;

	
	@Test (groups = {"Regression","Sanity"})
	public void addToCartTest() throws InterruptedException {
		indexpage=new IndexPage();
		searchresultpage=indexpage.searchProdct("T-shirt");
		addtocartpage= searchresultpage.clickOnProduct();
		
		addtocartpage.enterQuantity("2");
		addtocartpage.selectSize("L");
		addtocartpage.clickOnAddToCart();
		boolean result = addtocartpage.validateAddToCart();
		Assert.assertTrue(result);
		
		
	}
}

