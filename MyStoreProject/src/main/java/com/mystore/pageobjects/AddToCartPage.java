package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	
	
	@FindBy(id="quantity_wanted") private WebElement quantity;
	
	@FindBy(name="group_1")private WebElement size;
	
	@FindBy(xpath = "//span[text()='Add to cart']")private WebElement addToCartBtn;
	
	@FindBy(xpath = "//h2//i") private WebElement addToCartMsg;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]") private WebElement proceedToChechOutBtn;
	
	public  AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity( String QuantityInNum) 
	{
		Action.type(quantity, QuantityInNum);
	}
	
	public void selectSize(String size1) throws InterruptedException {
		Thread.sleep(3000);
		Action.click(driver, size);
		Action.selectByVisibleText(size1, size);

	} 
    
	public void clickOnAddToCart() throws InterruptedException {
		Thread.sleep(3000);

		 Action.click(driver, addToCartBtn);
		 
	}
	
	public boolean validateAddToCart() throws InterruptedException {
		Action.explicitWait(driver, addToCartMsg, 10);
		Thread.sleep(2000);

		return Action.isDisplayed(driver, addToCartMsg);
		
	}
	
	public OrderPage clickproceedToChechOutBtn() throws InterruptedException {
		Thread.sleep(3000);

		Action.JSClick(driver, proceedToChechOutBtn);
		Thread.sleep(3000);

		return new OrderPage();
	}
}
