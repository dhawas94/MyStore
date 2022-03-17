
package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author admin
 *
 */
public class LoginPage extends BaseClass  {
	
	
	
	@FindBy(id="email") private WebElement userName; 
	
	@FindBy(id="passwd") private WebElement password;
	
	@FindBy(id="SubmitLogin") private WebElement singInBtn;
	
	@FindBy(id="email_create") private WebElement emailForNewAccount;
	
	@FindBy(id="SubmitCreate") private WebElement createNewAccount;
	
	public LoginPage() 
	{
	
		PageFactory.initElements(driver , this);
	}
	
	public HomePage login(String uname, String pswd) 
	{
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(driver, singInBtn);
		return new HomePage();
		
	}
	public AddressPage login1(String uname, String pswd) 
	{
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(driver, singInBtn);
		return new AddressPage();
		
	}
	
	public AccontCreationPage createNewAccount(String newEmail) 
	{
		Action.type(emailForNewAccount, newEmail);
		Action.click(driver, createNewAccount);
		return new AccontCreationPage();
	}
	
	

}
