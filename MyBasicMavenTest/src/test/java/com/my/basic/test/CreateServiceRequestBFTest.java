package com.my.basic.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.verifier.exc.StructuralCodeConstraintException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.my.basic.pageObject.LogIn_Page;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class CreateServiceRequestBFTest {
	
	WebDriver driver;
	String baseUrl= "https://managedservices.qa.lexmark.com";
	String operationKey = "REQUEST SERVICE";
	String deviceNumber = "072M9342";
	
	com.my.basic.pageObject.PageObject_BreakFix device;
	SoftAssert s_assert =new SoftAssert(); 
	
	Logger logger = Logger.getLogger(CreateServiceRequestBFTest.class); 
@BeforeClass
public void SetUP() throws InterruptedException{
	logger.info("################# This is BreakFix Test ####################");
	System.out.println("################# This is BreakFix Test ####################");
	driver = new FirefoxDriver();
	driver.get(baseUrl);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Thread.sleep(5000);
	driver.manage().window().maximize();
	logger.info("Browser Launched & navigated to BaseURL");
	 	LogIn_Page signin = new LogIn_Page(driver);
		signin.Login("perftest_bestbuy11@customer.com", "Lexmark01");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		logger.info("Login successful");
	  }

@Test
  public void CreateServiceReqst_BF() throws Exception{

	  device= new com.my.basic.pageObject.PageObject_BreakFix(driver);
	  device.searchDevice(deviceNumber);
	  driver.findElement(By.linkText(deviceNumber)).click();
	  
//Device details page
	  
	  s_assert.assertEquals(deviceNumber, device.serialNumber.getText()); // asserting on the serial no searched for & the one in detail page
	  String productModel=device.productModel.getText();
	  String ipAddress=device.ipAddress.getText();
	  String primaryContact = device.primaryContact.getText();
	  
	  Assert.assertTrue(IsElementPresent(device.installAddress));  //install address verificstion in detail page

	  System.out.println("in Device page");
	  logger.info("in Device page");
	  Thread.sleep(3000);
	//driver.findElement(By.xpath("//*[@ng-if, "deviceActionPermissions.createBreakFixAccess"]"))
	  
	  String text=driver.findElement(By.xpath("//*[contains(@ng-click, 'btnRequestService(device)')]")).getText();
	  System.out.println(text);
	  logger.info(text);
	  
driver.findElement(By.xpath("//*[contains(@ng-click, 'btnRequestService(device)')]")).click();
System.out.println("clicked on device BF");
logger.info("clicked on device BF");
 
//Compare data in detail page & review page
	 // Assert.assertEquals(deviceNumber, device.capturePageSerialNumber.getText());
	  s_assert.assertEquals(productModel, device.capturePageProductModel.getText());
	 // s_assert.assertTrue(IsElementPresent(device.capturePageInstallAddress));
	  s_assert.assertEquals(ipAddress, device.capturePageIPAddress.getText());
	  logger.info("capturing details in BF capture page");
	  device.captureDetails();
	  Thread.sleep(3000);
//Review Page
	  s_assert.assertEquals(deviceNumber, device.reviewPageSerialNumber.getText());
	  s_assert.assertEquals(productModel, device.reviewPageProductModel.getText());
	  //s_assert.assertEquals(ipAddress, device.reviewPageIPAddress.getText());
	 // s_assert.assertTrue(IsElementPresent(device.reviewPageInstallAddress));
	  //s_assert.assertTrue(IsElementPresent(device.reviewPageContactforthisreqst));
	  //s_assert.assertTrue(IsElementPresent(device.reviewPageRequestCreatedBy));
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 30);
	  WebElement reviewPageReqstCreatedBy = wait1.until(ExpectedConditions.elementToBeClickable(device.reviewPageRequestCreatedBy));
	  
	  String reviewPageRequestCreatedBy =reviewPageReqstCreatedBy.getText();
	  String reviewPageContactforThisReqst= device.reviewPageContactforthisreqst.getText();
	  String reviewPageInstallAddress=device.reviewPageInstallAddress.getText();
	  
	  device.reviewPage();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("In review page");
//Submit Page
	  String message1 = "Your Service request is being submitted";
	  String message2= "Your request ( generating request number... ) is being submitted.";
	  System.out.println("message 2 is set as: "+message2);
	  logger.info("message 2 is set as: "+message2);
		if(message1.equalsIgnoreCase(device.submitPageMessage.getText())){
			Assert.assertEquals(message2, device.submitPageMessage2.getText());
			} else {
				System.out.println("SR number has been generate");
				logger.info("SR number has been generate");
				String successSR_message="Request service for "+productModel;
				Assert.assertEquals(successSR_message, device.submitPageMessage.getText());
				String str=device.readSRNumber.getText();
				/*String[] SR = new String[2];
					String[] SR=	str.split("\\:");
				System.out.println("SR number generated is: "+SR[1]);*/
				logger.info("SR number generated is: "+str);
				System.out.println("SR number generated is: "+str);
			}
//CONFIRMATION PAGE STATUS & PROGRESS BAR		
		//Assert.assertEquals(device.status.getText(), "Submitted");
		System.out.println("Status confirmed as: "+device.status.getText());
//Date calculations
	/*	dateCalculations dateExpected = new dateCalculations();		
		s_assert.assertEquals(device.date.getText(), dateExpected.dateCalculate());
		System.out.println("Date shows as: "+device.date.getText()); */
//other element confirmation
		
		Assert.assertEquals(deviceNumber, device.submitPageSerialNumber.getText());
		Assert.assertEquals(productModel, device.submitPageProductModel.getText());
		Assert.assertEquals(ipAddress, device.submitPageIPAddress.getText());
		
		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		WebElement ele = wait2.until(ExpectedConditions.elementToBeClickable(device.submitPageReqstCreatedBy));
		
		Assert.assertEquals(ele.getText(),reviewPageRequestCreatedBy);
		Assert.assertEquals(device.submitPageContactforthisReqst.getText(),reviewPageContactforThisReqst);
		Assert.assertEquals(device.submitPageInstallAddress.getText(),reviewPageInstallAddress);
		
		
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);  
		com.my.basic.pageObject.LogIn_Page logout = new com.my.basic.pageObject.LogIn_Page(driver); //Logout
		  logout.Logout();
		  logger.info("Logged out");
		  driver.close();
		  logger.info("& browser close");
	}
/*
@AfterTest
  public void logOut() throws Exception{
	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);  
	com.my.basic.pageObject.LogIn_Page logout = new com.my.basic.pageObject.LogIn_Page(driver); //Logout
	  logout.Logout();
	  logger.info("Logged out");
	  driver.close();
	  logger.info("& browser close");
  }
*/
//Compare data in detail page & review page



private boolean IsElementPresent(WebElement capturePageInstallAddress) {
	// TODO Auto-generated method stub
	return true;
}

}


