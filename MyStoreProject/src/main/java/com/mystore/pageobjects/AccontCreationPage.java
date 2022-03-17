package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccontCreationPage extends BaseClass{
	
	
	@FindBy(xpath = "//h1[@class='page-heading']") private WebElement formTitel;
	
	public AccontCreationPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountCreationPage() {
		
		return Action.isDisplayed(driver, formTitel);
	}

}
