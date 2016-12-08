package com.mps.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;

public class NewTest {
  @Test
  public void fileTest() throws Exception {
	  WebDriver driver = new FirefoxDriver();
	  LogIn_Page myLogin = new LogIn_Page(driver);
	  
	 /* myLogin.userID.sendKeys("testamica@customer.com");
	  myLogin.Password.sendKeys("$#%*&^(**&");
	  myLogin.submitBtng.click();*/
	  
	  myLogin.Login("testamica", "Lexmark143");   //This completes Login test
	  
  }
}
