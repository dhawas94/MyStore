package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	
	@Test(groups = "Regression")
	public void verifyTotalPrice() throws InterruptedException 
	{
		indexpage=new IndexPage();
		searchresultpage=indexpage.searchProdct("T-shirt");
		addtocartpage= searchresultpage.clickOnProduct();
		
		addtocartpage.enterQuantity("2");
		Thread.sleep(1000);
		addtocartpage.selectSize("L");
		Thread.sleep(1000);
		addtocartpage.clickOnAddToCart();
		Thread.sleep(1000);
		orderpage =addtocartpage.clickproceedToChechOutBtn();
		Thread.sleep(1000);
		double unitprice = orderpage.getUnitPrice();
		double totalprice = orderpage.getTotalPrice();
		double totalExpectedPrice=(unitprice*2)+2;
		Assert.assertEquals(totalprice, totalExpectedPrice);
		
	}

}
