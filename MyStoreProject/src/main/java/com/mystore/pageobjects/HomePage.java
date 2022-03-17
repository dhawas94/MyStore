package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	
	
	@FindBy(xpath="//span[text()='My wishlists']") private WebElement myWishList;
	
	@FindBy(xpath="//span[text()='Order history and details']") private WebElement orderHistory;
	
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyWishList() 
	{
		return Action.isDisplayed(driver, myWishList);
		
	}
	
	public boolean validateOrderHistory() 
	{
	return	Action.isDisplayed(driver, orderHistory);
	}
	
	public String getCurrentUrl() 
	{
		String Currenturl = driver.getCurrentUrl();
		return Currenturl;
	}
	

}
