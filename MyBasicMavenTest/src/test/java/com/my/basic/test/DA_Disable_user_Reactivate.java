package com.my.basic.test;

import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.testng.log4testng.Logger;

import com.my.basic.pageObject.LogIn_Page;
import com.my.basic.pageObject.Users_PageObject;

public class DA_Disable_user_Reactivate {
	
		WebDriver driver;
		String baseUrl = "https://managedservices.qa.lexmark.com";//"https://managedservices.qa.lexmark.com";
		LogIn_Page login;
		String emailID;
		String lastName;
		Users_PageObject ActivatenreactivateUsr;
		String email = "selenium.808@domain.com";
		Logger logger = Logger.getLogger(DA_Disable_user_Reactivate.class);
		SoftAssert Assert = new SoftAssert();
		
@BeforeClass
public void launch(){
	System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
    driver = new FirefoxDriver();
	}
@BeforeMethod
		public void setUp() throws InterruptedException{
//		PropertyConfigurator.configure("log4j.properties");
		logger.info("################# This is User Deactivation/Activation Test ####################");
		System.out.println("################# This is User Deactivation/Activation Test ####################");
			//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			//driver=new ChromeDriver();
	
			driver.manage().window().maximize();
			driver.get(baseUrl);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			logger.info("Browser Launched & navigated to URL");
			login = new LogIn_Page(driver);
				login.Login("perftest_amica11@customer.com", "Lexmark01"); //Login Test		
				logger.info("Login successful");
			}
@Test 
	  public void InActivatingUser() throws Exception {
		ActivatenreactivateUsr = new Users_PageObject(driver);
		
//########################### Search for Email	###################################	
	ActivatenreactivateUsr.searchEmail(email); //Calling search method 
	Thread.sleep(6000);
	ActivatenreactivateUsr.searchBox.sendKeys(Keys.ENTER);
	logger.info("Searched for email");
	driver.findElement(By.linkText(email)).click();
	logger.info("Clicked on email");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(6000);
//############################# Click on DEACTIVE BUTTON ###########################
		String buttonText = driver.findElement(By.xpath("//button[@type='button']")).getText();
		if(buttonText.equalsIgnoreCase("ACTIVATE USER")){
			System.out.println("The user is not ready to test");
			logger.info("The user is not ready to test");
			System.out.println("The user is not ready to test");
			logger.info("User needs to be Activated first");
			System.out.println("User needs to be Activated first");
			driver.findElement(By.xpath("//button[@type='button']")).click();
			driver.findElement(By.xpath("//div[@id='activate-confirm-popup']/div/button")).click(); //click on Yes button
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Thread.sleep(3000);
			logger.info("Deactivation Confirmation message");
			System.out.println("Confirmation message on user activation");
			//Thread.sleep(6000);
			System.out.println("After activation search for the user & do the operation");
			ActivatenreactivateUsr.searchEmail(email);
			driver.findElement(By.linkText(email)).click();

		} else {
			System.out.println("we rae in else block. user is Ready to test");
			Assert.assertEquals(buttonText, "DEACTIVATE USER");
			logger.info("User is good to go");
		}
		
		driver.findElement(By.xpath("//button[@type='button']")).click();
		//check the message on the confirmation pop-up
		//Assert.AssertEquals(driver.findElement(By.xpath("//*[@id='deactivate-confirm-popup']/div/h2")).getText(),"Do you want to deactivate the user?");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='deactivate-confirm-popup']/div/button[1]")).getText(),"Yes");
		String textPopUp = driver.findElement(By.xpath("//*[@id='deactivate-confirm-popup']/div/button[1]")).getText();
		System.out.println("Test in Popup: "+ textPopUp);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='deactivate-confirm-popup']/div/button[2]")).getText(),"No");
		logger.info("checked the message on the confirmation pop-up");
		System.out.println("checked the message on the confirmation pop-up");
		System.out.println("going to click on the YES button");
		
		//**************************************************************************
		driver.findElement(By.xpath("//*[@id='deactivate-confirm-popup']/div/button[1]")).click(); //click on Yes button
		//**************************************************************************
		
		System.out.println("check the confirmation message");
		logger.info("Deactivation Confirmation message");
	//	Assert.AssertEquals(driver.findElement(By.xpath("//div[5]")).getText(),"User has been successfully deactivated"); //Deactivation Confirmation message
		logger.info("Search the user & check if the status shows as INACTIVE");
		ActivatenreactivateUsr.searchEmail(email); //Calling search method 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		ActivatenreactivateUsr.searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.linkText(email));		
		System.out.println("The status on the grid shows as"+driver.findElement(By.cssSelector("div.ng-binding.ng-scope")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ng-binding.ng-scope")).getText(),"Inactive"); 
        System.out.println("############################# DEACTIVATION DONE #############################");
//############################# Check if the INACTIVE user can login ###########################	
logger.info("Check if the INACTIVE user can login");
	//Logout from existing login
logger.info("Logout from parent useer");
		  login.Logout();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//Login with the deactivated user
		  logger.info("Login with user under test");
		  System.out.println("Login with user under test");
		  driver.get(baseUrl);
			Thread.sleep(6000);	
			login = new LogIn_Page(driver);
				login.Login(email, "Lexmark01"); //Login Test
			//Thread.sleep(5000);
			Assert.assertEquals(driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div/div")).getText(),"You do not have access to this application. Please contact your primary support person.");
			logger.info("The user should not be able to login");
			System.out.println("The DEACTIVATED user should not be able to login");
	//Logout now
			login.Logout();
			Thread.sleep(4000);
			logger.info("test under test logs out.next parent will log in again");
			System.out.println("The user logs out to re-login with parent user");
	//Re-login with parent user
}
@Test (dependsOnMethods={"InActivatingUser"}) 
public void ReActivatingUser() throws Exception{
	
System.out.println("This is in second test");
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//########################  Search for the user to REACTIVATE  ###########################	
			ActivatenreactivateUsr.searchEmail(email);
			System.out.println("searched the email");
			System.out.println("email searched");
			driver.findElement(By.linkText(email)).click();
			System.out.println("clciked on the email");
			logger.info("searched & clicked the user inder test. Intention is to Reactivate it.");
			
			Assert.assertEquals(driver.findElement(By.xpath("//button[@type='button']")).getText(), "ACTIVATE USER");
			System.out.println("Assertion Passed");
			driver.findElement(By.xpath("//button[@type='button']")).click();
			logger.info("ACTIVATED user");
			Assert.assertEquals(driver.findElement(By.xpath("//h2[text()='Do you want to deactivate the user?']")).getText(),"Do you want to activate the user?");
			System.out.println("pop-up assertion also passed");
			System.out.println("going to click on the Yes Button");
			//driver.findElement(By.xpath("//div[@id='deactivate-confirm-popup']/div/button")).click(); //click on Yes button
			
			//**************************************************************************
			driver.findElement(By.xpath("//div[@id='activate-confirm-popup']/div/button")).click();
			//**************************************************************************
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[5]")).getText(),"User has been successfully updated"); //Deactivation Confirmation message

//############################# Check if the ACTIVE user can login ###########################		
			//Logout from existing login
			logger.info("Log Out from Parent user");
				  login.Logout();
				  //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Login with the deactivated user
				  logger.info("logging with user under test");
				  driver.get(baseUrl);
						login = new LogIn_Page(driver);
						login.Login(email, "Lexmark01"); //Login Test
					Assert.assertEquals(driver.findElement(By.linkText("Home")).getText(),"Home");
					//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				}
@AfterTest
public void logout() throws Exception{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	 
	logger.info("logging out");
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.close();
	   
}
/*
//Compare data in detail page & review page
@AfterClass
public void quitBrowser() throws Exception{
	Thread.sleep(3000);
	logger.info("logging out");
	  LogIn_Page logout = new LogIn_Page(driver); //Logout
	  logout.Logout();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	  driver.quit();
	  logger.info("quiting browser");
}*/
}
