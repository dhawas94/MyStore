package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummuryPage extends BaseClass{
     
     
     @FindBy(xpath = "//span[text()='I confirm my order']") private WebElement confirmOrderBtn;
     
     public OrderSummuryPage() 
     {
    	 PageFactory.initElements(driver, this);
     }
     
     public OrderConfirmationPage clickOnConfirmOrderBtn() {
    	 
    	 Action.click(driver, confirmOrderBtn);
    	 return new OrderConfirmationPage();
     }
     
}
