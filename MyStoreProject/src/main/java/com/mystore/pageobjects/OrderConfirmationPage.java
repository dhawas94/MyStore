package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	
	@FindBy(xpath = "//strong[text()='Your order on My Store is complete.']") private WebElement confirmMessage;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateConfirmMsg() 
	{
		String confirmMsg= confirmMessage.getText();
	    return confirmMsg;
	
	}
}
