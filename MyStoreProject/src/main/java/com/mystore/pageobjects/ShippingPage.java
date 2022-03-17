package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {

	
	@FindBy(id="cgv") private WebElement terms;
	
	@FindBy(xpath = "//button//span[contains(text(),'Proceed to checkout')]") private WebElement ProceedToCheckOutBtn ;
	
	public ShippingPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonTerms() 
	{
		Action.click(driver, terms);
	}
	
	public PaymentPage clickOnProceedToCheckOutBtn() {
		Action.click(driver, ProceedToCheckOutBtn);
		return new PaymentPage();
	}
	
}
