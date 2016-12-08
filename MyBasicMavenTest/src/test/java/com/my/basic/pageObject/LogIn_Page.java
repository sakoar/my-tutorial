package com.my.basic.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn_Page {
	
	public LogIn_Page(WebDriver driver) { //Constructor of Class
		PageFactory.initElements(driver,this);
	}

//##############################  USER ID #############################
	@FindBy(name="USER")
	public WebElement userID;
//##############################  PASSWORD ############################	
	@FindBy(name="PASSWORD")
	public WebElement Password;

//##############################  SIGNIN Button ########################
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submitBtng;

//Logout
	@FindBy(linkText="Log out")
	public WebElement LogOut;

//##############################  LogIn Method #########################
	public void Login(String UID, String Psswd) throws InterruptedException{
		userID.sendKeys(UID);
		Password.sendKeys(Psswd);
		submitBtng.click();
		}
	
	public void Logout() throws Exception{
		LogOut.click();
		Thread.sleep(3000);
	}

}
