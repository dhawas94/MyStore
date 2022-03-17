package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass  {
	
	
	
	@FindBy(xpath="//a[@class='login']") private WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']") private WebElement myStoreLogo;
	
	@FindBy(xpath="//input[@id='search_query_top']") private WebElement searchProductBox;
	
	@FindBy(xpath = "//button[@name='submit_search']") private WebElement searchButton;
	
	public IndexPage( ) 
	{
		
		PageFactory.initElements(driver,this);
		
	}
	
	public LoginPage clickOnSignIn() throws Throwable	
	{
		Action.explicitWait(driver, signInBtn, 10);
		Action.click(driver,signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() 
	{
		
		return Action.isDisplayed(driver, myStoreLogo);
	}
	
	
	public String getMyStoreTitle() {
		
		String myStoreTitel  =driver.getTitle();
		return  myStoreTitel;
		
	}
	
	public SearchResultPage searchProdct(String productName) 
	{
		Action.type(searchProductBox, productName);
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}
	
	


}
