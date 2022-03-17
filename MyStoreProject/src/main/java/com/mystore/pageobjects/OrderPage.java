package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
   
    
    @FindBy(xpath = "//td//span/span[text()='$16.51']") private WebElement unitPrice;
    
    @FindBy(id="total_price") private WebElement totalPrice;
    
    @FindBy(xpath = "//span[text()='Proceed to checkout']") private WebElement proceedToCheckut;
    
    public OrderPage() {
    	PageFactory.initElements(driver, this);
    }
    
    public double getUnitPrice() {
    	Action.explicitWait(driver, unitPrice, 20);
    	String unitPrice1=unitPrice.getText();
    	String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]" ,"");
    	double finalUnitPrice = Double.parseDouble(unit);
    	return finalUnitPrice/100;
    }
    
    public double getTotalPrice() {
    	String totalPrice1 = totalPrice.getText();
    	String total = totalPrice1.replaceAll("[^a-zA-Z0-9]","");
    	double finalTotalPrice = Double.parseDouble(total);
    	return finalTotalPrice/100;
    	
    }
    
    public LoginPage clickOnCheckOut() {
    	Action.click(driver, proceedToCheckut);
    	return new LoginPage();
    }
}
