package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummuryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummuryPage ordersummurypage;
	OrderConfirmationPage orderconfirmationpage;
	@Test(groups = "Regression")
	public void endToEndTest() throws InterruptedException 
	{
		indexpage=new IndexPage();
		searchresultpage=indexpage.searchProdct("T-shirt");
		addtocartpage= searchresultpage.clickOnProduct();
		
		addtocartpage.enterQuantity("2");
		addtocartpage.selectSize("L");
		addtocartpage.clickOnAddToCart();
		orderpage =addtocartpage.clickproceedToChechOutBtn();
		loginpage=orderpage.clickOnCheckOut();
		addresspage=loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingpage=addresspage.clickOnChechOut();
		shippingpage.clickonTerms();
		paymentpage=shippingpage.clickOnProceedToCheckOutBtn();
		ordersummurypage=paymentpage.clickOnPaymentMethod();
		orderconfirmationpage=ordersummurypage.clickOnConfirmOrderBtn();
		String actualmsg = orderconfirmationpage.validateConfirmMsg();
		String expectedmsg="Your order on My Store is complete.";
		Assert.assertEquals(actualmsg, expectedmsg);
	}
	

}
