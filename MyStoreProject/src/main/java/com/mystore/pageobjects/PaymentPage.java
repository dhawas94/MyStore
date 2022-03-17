package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	
	@FindBy(xpath = "//a[@class='bankwire']") private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[@class='cheque']") private WebElement payByCheque;

	public PaymentPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public OrderSummuryPage clickOnPaymentMethod() 
	{
		Action.click(driver, bankWireMethod);
		return new OrderSummuryPage();
	}
}
