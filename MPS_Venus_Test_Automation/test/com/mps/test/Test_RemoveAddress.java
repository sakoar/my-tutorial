package com.mps.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lexmark.automation.test.PageObject.helper.LogIn_Page;
import com.lexmark.automation.test.PageObject.helper.PageObject_CreateAddress;
import com.lexmark.automation.test.PageObject.helper.PageObject_RemoveAddress;
import com.lexmark.automation.test.PageObject.helper.dateCalculations;

public class Test_RemoveAddress {
	WebDriver driver;
	String baseUrl = "https://managedservices.qa.lexmark.com";//"Launching url 
		String addressName = "Walmart #3887";
		SoftAssert s_assert = new SoftAssert();
@BeforeClass
	public void setUp() throws InterruptedException{
	System.out.println("################# THis is Remove Adrress Test ####################");
	//System.setProperty("webdriver.firefox.bin", "C:\\Users\\sanoaoa\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver=new ChromeDriver();
       // driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				LogIn_Page signin = new LogIn_Page(driver);
				signin.Login("perftest_walmart@customer.com", "Lexmark01");
				
			}
  @Test
  public void RemoveAddressTest() throws InterruptedException {
  PageObject_RemoveAddress removeAdrs = new PageObject_RemoveAddress(driver);
  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
  removeAdrs.addresses.click();//To click on Address Tab
  removeAdrs.searchInput.sendKeys(addressName);
   Assert.assertEquals(removeAdrs.searchFilter.getText(), "Address Name");
  
  Thread.sleep(2000);
  removeAdrs.searchIcon.click();
  Thread.sleep(4000);
  System.out.println("going to click on select key");
  removeAdrs.selectKey.click();
  
  removeAdrs.removeButton.click();
  //Thread.sleep(6000);
  
  String rpAddressDetail = removeAdrs.reviewPageAddrsDetail.getText().trim();
  String rpAddressPrimaryContact =removeAdrs.reviewPagePrimaryContact.getText().trim();
  System.out.println(rpAddressPrimaryContact);
  String rpReqstCreatedBy = removeAdrs.reviewPageReqstCreatedBy.getText().trim();
  System.out.println(rpReqstCreatedBy);
  
  removeAdrs.refID.sendKeys("This is for testing");
   Actions a=new Actions(driver);
  a.sendKeys(Keys.TAB).build().perform();
  Thread.sleep(2000);
  //removeAdrs.comment.sendKeys(Keys.TAB);
  //Thread.sleep(2000);
  a.sendKeys(Keys.TAB).build().perform();
  Thread.sleep(2000);
  a.sendKeys(Keys.ENTER).build().perform();
  Thread.sleep(15000);
  //removeAdrs.reviewPageRemoveButton.click();
  //Thread.sleep(15000);
  //System.out.println(driver.findElement(By.cssSelector("div.col-lg-2-3.col-md-1-1 > h1.ng-scope")).getText().trim());
  System.out.println("Which page you are in? "+removeAdrs.submitPageMessage.getText());
  
//############################REMOVE ADDRESS SUBMIT PAGE#################################
//Capturing the SR DETAILS 
String message1 = "Your Data Address Remove request is being submitted";
String message2= "Your request ( generating request number... ) is being submitted.";
	if(message1.equalsIgnoreCase(removeAdrs.submitPageMessage.getText())){
		Assert.assertEquals(message2, removeAdrs.submitPageMessage2.getText());
		System.out.println("removeAdrs.submitPageMessage2.getText()");
		} else {
			System.out.println("SR number has been generated");
			String successSR_message="Submitted | Delete Address request";
			Assert.assertEquals(removeAdrs.submitPageMessage.getText(),successSR_message);
			String str=removeAdrs.readSRNumber.getText();
			String SR = str.split("\\:")[1];
			System.out.println("SR number generated is: "+SR);
		}
  }
	
	/*
	//Assert.assertEquals(removeAdrs.status.getText(), "Submitted");
	//Assert.assertEquals(removeAdrs.status.getText(), successSR_message)
	dateCalculations dateExpected = new dateCalculations();
	s_assert.assertEquals(removeAdrs.date.getText(), dateExpected.dateCalculate());

  String spAddressDetail = removeAdrs.submitPageAddrsDetail.getText();
  String spAddressPrimaryContact =removeAdrs.submitPagePrimaryContact.getText();
  String spReqstCreatedBy = removeAdrs.submitPageReqstCreatedBy.getText();
  
  //Assert.assertEquals(spAddressDetail, rpAddressDetail);
  System.out.println("Address Detail passed");
  
  Assert.assertEquals(spAddressPrimaryContact, rpAddressPrimaryContact);
  System.out.println("Prim contact passed");
  Assert.assertEquals(spReqstCreatedBy, rpReqstCreatedBy);
  System.out.println("Reqst created by passed");
  
  }
  
  */
  @AfterTest
  public void tearDown() throws Exception{
  	  LogIn_Page logout = new LogIn_Page(driver); //Logout
  	  logout.Logout();
  	  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
  	  driver.close();
  }
  }
	  

